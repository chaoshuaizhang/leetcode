---
tags: [工作/任务(不经过产品)]
title: firebase相关问题处理
created: '2020-08-24T12:46:41.334Z'
modified: '2020-09-03T09:34:43.343Z'
---

## firebase相关问题处理

1.  Parcel 并发传输的数据量过多时 > 1MB

2. Context.startForegroundService() did not then call Service.startForeground()
>1. 服务是在什么时候开启的？
>2. 应用在后台时也会/要开启服务？

3. 相机3秒问题【具体是否是初始化阻塞，还未知】

>sConfigProvider是否需要在APP中初始化

mCameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())

public static ListenableFuture<ProcessCameraProvider> getInstance(
        @NonNull Context context) {
    Preconditions.checkNotNull(context);
    return Futures.transform(【CameraX.getOrCreateInstance(context)】, cameraX ->  {
        sAppInstance.setCameraX(cameraX);
        return sAppInstance;
    }, CameraXExecutors.directExecutor());
}

getOrCreateInstance(@NonNull Context context){

    initializeInstanceLocked(app);
}    

initializeInstanceLocked(@NonNull Context context) {
    // sConfigProvider的赋值在哪里？
    CameraX cameraX = new CameraX(sConfigProvider.getCameraXConfig());
}

// 赋值只有这一个地方
private static void configureInstanceLocked(@NonNull CameraXConfig.Provider configProvider) {
    sConfigProvider = configProvider;
}

public static void configureInstance(@NonNull CameraXConfig cameraXConfig) {
    CameraX.configureInstance(cameraXConfig);
}

4. 启动前台服务问题
先启动 -> 杀死 -> 再启动
4823             4973
5608             5767

2020-08-25 13:42:55.768 6296-6296/com.youdao.hindict D/startServiceTAG: startWatch: main
2020-08-25 13:42:55.779 6296-6296/com.youdao.hindict D/startServiceTAG: startWatch: main   11

42-56 执行 onCreate

//----------------START
2020-08-25 13:46:18.579 7228-7228/com.youdao.hindict D/startServiceTAG: startWatch: main
2020-08-25 13:46:18.585 7228-7228/com.youdao.hindict D/startServiceTAG: startWatch: main   6

2020-08-25 13:46:19.433 7632-7632/com.youdao.hindict D/startServiceTAG: onCreate: main
2020-08-25 13:46:21.453 7632-7632/com.youdao.hindict D/startServiceTAG: onStartCommand: 
2020-08-25 13:46:21.609 7632-7632/com.youdao.hindict D/startServiceTAG: onStartCommand: 
//------------------END


if (allowedMagic) {
    // 此处已经调用startService开启服务了
    ClipboardWatcher.startMagic(HinDictApplication.getInstance(), false);
}
if (allowedSearch) {
    boolean allowed = MMKVUtil.INSTANCE.getBoolean(PreferenceConsts.INSTANT_TRANS, false);
    // 此处继续调用startForegroundService开启服务
    ClipboardWatcher.startWatch(HinDictApplication.getInstance(), true, allowed);
}


先把magic关闭，保证启动watch服务时  服务还没有开启  然后执行bind。

应该不会崩溃了，但问题是，如果onCreate执行耗时，则startMagic也会延时执行（因为不管是bindService还是startService，都只会执行一次onCreate方法，所以一旦onCreate耗时，那么onStartCommand方法就会延迟执行）


2020-08-25 14:44:49.350 21002-21002/com.youdao.hindict D/startServiceTAG: getServerConfig: allowedMagic=true     allowedSearch=true
2020-08-25 14:44:49.350 21002-21002/com.youdao.hindict D/startServiceTAG: startMagic: 
2020-08-25 14:44:49.369 21002-21002/com.youdao.hindict D/startServiceTAG: startWatch: before bindmain
2020-08-25 14:45:00.140 21002-21002/com.youdao.hindict D/startServiceTAG: onServiceConnected: 11111
2020-08-25 14:45:00.143 21002-21002/com.youdao.hindict D/startServiceTAG: startWatch: 22222

2020-08-25 14:44:50.116 21412-21412/com.youdao.hindict D/startServiceTAG: onCreate: main
2020-08-25 14:45:00.136 21412-21412/com.youdao.hindict D/startServiceTAG: onBind: 
2020-08-25 14:45:00.142 21412-21412/com.youdao.hindict D/startServiceTAG: onStartCommand: false
2020-08-25 14:45:00.345 21412-21412/com.youdao.hindict D/startServiceTAG: onStartCommand: true


if (clipboardManager != null && clipboardManager.hasPrimaryClip() && clipboardManager.getPrimaryClip() != null && clipboardManager.getPrimaryClip().getItemCount() > 0) {
        activity.clipped = clipboardManager.getPrimaryClip().getItemAt(0).getText();
}

5. 关于剪切板：
>实现在任意地方复制/剪切文本，都能触发magic的翻译

获取不到剪切板的原因是：ud不在前台，没有获取焦点

在onResume中post一个run消息，为什么这么做？可能是在onCreate方法中还在申请获取焦点
>这个解决的问题是：当剪切板有数据时，你进入一个Activity然后立刻显示剪切板数据，此时就有可能无法显示，因为还在获取焦点。【不能解决我们的问题，但也不一定】

在android10上进行复制会报：Denying clipboard access to com.youdao.hindict, application is not in focus neither is a system service for user 0


6. ActivityRecord not found问题
ty.ClipboardTransActivity t-1 f}}
android.app.ActivityThread.reportSizeConfigurations

MagicFakeActivity

Fatal Exception: java.lang.IllegalArgumentException
reportSizeConfigurations: ActivityRecord not found for: Token{f6ff6ff ActivityRecord{ba72e1e u0 com.youdao.hindict/.activity.MagicFakeActivity t-1 f}}




https://console.firebase.google.com/project/hindict-ccdff/crashlytics/app/android:com.youdao.hindict/issues/9ddff4675a142a5b607233d53f08d7da?time=last-seven-days&sessionId=5F460814027900012079340445E84564_DNE_0_v2


记录下未解决的问题：
1. https://console.firebase.google.com/project/hindict-ccdff/crashlytics/app/android:com.youdao.hindict/issues/5c5acaa7f8b88c2963dcb727?time=last-seven-days&sessionId=5F48647B03A500016BA1DADA5F04E1C9_DNE_0_v2

2. https://console.firebase.google.com/project/hindict-ccdff/crashlytics/app/android:com.youdao.hindict/issues/80087491779d1325a0029105f84f329d?time=last-seven-days&sessionId=5F48655F03D30001205EC24C1E31CD25_DNE_0_v2

* 对于8.0以上的系统，在Toast.TN类里边已经校验了是否存在Looper，所以不会报那个Handler中的错
```
// Toast.java
TN(String packageName, @Nullable Looper looper) {

    if (looper == null) {
        // Use Looper.myLooper() if looper is not specified.
        looper = Looper.myLooper();
        // 【 1 】此处已经校验了looper
        if (looper == null) {
            throw new RuntimeException("Can't toast on a thread that has not called Looper.prepare()");
        }
    }
    // 【 2 】为啥此处还会报 Can't create handler inside thread that has not called Looper.prepare()
    mHandler = new Handler(looper, null) {}
```

* 对于8.0以下的系统，Handler是当作成员变量直接创建的，所以在Toast中没有Looper的校验，所以如果不存在Looper，则会在Handler中抛出异常。

但是很奇怪，都会抛出异常，但是只看到了一种异常，另一种为什么不存在？

所以解决问题的出发点是：在哪调用的？主线程？子线程？

从firebase的源码中看到，它建议onMessageReceived方法在子线程中执行，所以可以猜测：当它进行push时，应该也是在子线程中进行消息回调的。


```
android.os.Handler.<init> (Handler.java:209)
android.os.Handler.<init> (Handler.java:123)
android.widget.Toast$TN.<init> (Toast.java:350)
android.widget.Toast.<init> (Toast.java:106)
android.widget.Toast.makeText (Toast.java:264)
android.media.RingtoneManager.isRingtoneExist (RingtoneManager.java:1195)
android.app.NotificationManager.notify (NotificationManager.java:235)
android.app.NotificationManager.notify (NotificationManager.java:202)
com.youdao.hindict.utils.ac.a (Proguard:126)
com.youdao.hindict.utils.ac.a (Proguard:96)
com.youdao.hindict.push.MyFirebaseMessagingService.a (Proguard:41)
com.google.firebase.messaging.FirebaseMessagingService.c (Proguard:68)
com.google.firebase.messaging.h.run (Proguard:2)
java.util.concurrent.ThreadPoolExecutor.runWorker (ThreadPoolExecutor.java:1113)
java.util.concurrent.ThreadPoolExecutor$Worker.run (ThreadPoolExecutor.java:588)
com.google.android.gms.common.util.a.d.run (未知来源:6)
java.lang.Thread.run (Thread.java:818)
```


```
public class FirebaseMessagingService {

    @WorkerThread
    public void onMessageReceived(@NonNull RemoteMessage var1) {
        // 建议在工作线程中处理
    }

}
```










