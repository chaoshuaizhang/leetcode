---
attachments: [Clipboard_2020-09-01-12-03-44.png]
tags: [工作/调研]
title: OCR调研
created: '2020-08-31T04:57:42.977Z'
modified: '2020-09-03T09:35:03.822Z'
---

# OCR调研

## 已有文档
https://codelabs.developers.google.com/codelabs/mlkit-android/#0

https://developers.google.com/ml-kit/samples

https://github.com/googlesamples/mlkit/tree/master/android/translate-showcase

http://confluence.inner.youdao.com/pages/viewpage.action?pageId=49160832 月玥之前总结的文档

## 调研的几个指标
0. 调研一下这个MLKit的OCR识别，支持哪些语言，每个语言的模型下载大小

1. 对离线和在线的支持

2. 接入之后对包体积的影响

3. UI是否支持自己定制

4. 支持的语言

5. 包括具体哪些语言？

## 小点

1. ML Kit的所有API均在设备上运行，从而允许在您想处理实时摄像机流的实时用例中使用。这也意味着该功能可以脱机使用。
2. 第一次运行时报错： Waiting for the text recognition model（文字识别模型） to be downloaded. Please wait.【需要google服务】

## 调研


文字识别：
demo：vision-quickstart（MLKit Vision项目，相机动态识别）、mlkit-android-master（静态图片识别vision-final，即ML Kit Codelab项目）、translate-showcase（相机动态识别文字，quick-start的精简版本）

1. 任何基于拉丁语的字符集中的文本（拉丁字母、罗马数字）
2. 支持离线
3. 必须要有谷歌商店，以便下载对应的ML模型

语言识别：
demo：MLKit LanguageID
100+

文字翻译：
demo：ML Kit - Translate（translate项目）
1. [支持50多种语言之间的翻译](https://developers.google.com/ml-kit/language/translation/translation-language-support)
2. 语言模型下载成功后，支持离线
3. 语言模型大小差不多为30MB
4. 跑项目时没有下载下来对应的语言模型[]


手写识别：
https://developers.google.com/ml-kit/vision/digital-ink-recognition


--------
1. OCR 和 翻译分别是在线还是离线？
   两者都是离线，手机必须支持谷歌服务，以便下载对应的Module，OCR的module比较小，大约不到1MB，翻译的module会在30MB左右

2. UI样式可以自己控制吗，还是必须按照demo？
   可以自定义UI

3. 包括具体哪些语言？
   OCR：任何基于拉丁语的字符集中的文本（拉丁字母）
   翻译：支持50多种语言之间的翻译，具体的语言列表 https://developers.google.com/ml-kit/language/translation/translation-language-support


运行不起来的报错：
File google-services.json is missing. The Google Services Plugin cannot function without it. 
需要apply plugin: 'com.google.gms.google-services'服务

mlkit-android-master
————custom-model 未运行起来，貌似是自定义图像识别（自定义识别的标准，然后去识别相应的图片。比如自定义识别的是鸟，则你给一张鸟的图片，他就会识别出是什么鸟-鹦鹉、八哥）
————object-detection 未运行起来，
————translate\starter 文字识别（成型的，我们可以进行裁剪，，但是这里运行后无法识别，不清楚是不是没有写完整，因为他写的是starter项目，但是下面的那个translate-showcase是成型的，可以识别）
————vision\final 识别静态图片和人脸识别

mlkit\android
————android-snippets 代码片段，各个功能的代码片段，只写了一些核心代码，没有具体实现，我们在项目里集成时，可以参考这个demo
————automl
————digitalink 
————langid 鉴别文字是何种语言
————material-showcase material风格的相机（主要就是自定义物体识别、定位相机范围内的物体）
————smartreply 聊天服务
————translate 输入指定语言，选择要翻译成的语言（需要下载对应的model，但是下载不下来）
————translate-showcase 成型的文字识别，可以自定义框框大小等等
————vision-quickstart 集前面许多功能为一体的 "大型" demo，但是里边好多功能还不清楚是干嘛用的

包体积：
nothing - 3709
camera-core - 3907
camera-camera2 - 4003
camera-lifecycle - 























