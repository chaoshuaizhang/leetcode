---
attachments: [Clipboard_2020-09-01-16-34-33.png]
tags: [工作/任务(不经过产品)]
title: Google OCR接入
created: '2020-08-31T10:17:18.601Z'
modified: '2020-09-03T09:40:13.664Z'
---

## Google OCR接入

【模型文件】
【模型文件】
【模型文件】

1. 把之前的离线OCR去掉，包括SDK，测一下apk的大小
2. MLKit集成进来，测一下apk的大小

![](@attachment/Clipboard_2020-09-01-16-34-33.png)

#### 第一步：目前UD用到OCR的地方

#### 第二步：梳理下代码
1. 取词模块的页面相关逻辑在 FastOcrFunctionBinder
2. 两者使用的是同一个Camera
3. 拍照是先获取到当前的bitmap，然后进行文字识别，分为在线和离线识别，识别完成后，进行翻译。（在线OCR是把bitmap打成字节流传到服务器，离线是使用快速取词的OCR进行识别）。

```
fun ocrTranslate(bitmap: Bitmap?, from: String, to: String, reqSrc: String, rotation: Int = -1): Single<OcrTransData> {
    if (bitmap == null) {
        return Single.error(NoContentException())
    }
    // 存储一下拍摄的照片，便于测试
    bitmap2File(bitmap, HinDictApplication.getInstance(), "pic_translate_bak.png")
    return if (NetworkUtils.isNetworkAvailable()) {
        // 先在线识别，失败后转离线【测试需要：先删除离线】
        onlineOcr(bitmap, from, to, rotation)
    } else {
        // 直接进行离线识别
        // offlineOcr(bitmap, from, to, reqSrc, OcrMode.OFFLINE, rotation)
        throw NoContentException()
    }
}
```

4. 快速取词是先获取到bitmap，然后使用离线的OCR识别，然后调用API进行翻译。

>目前两个Binder还没有梳理清楚


#### 第三步：移除


#### 第四步：接入

1. 目前项目里边已经有ML相关的包了，不过是在FireBase下的





图片翻译应该首先进行的是：图片识别，然后再 文字翻译



