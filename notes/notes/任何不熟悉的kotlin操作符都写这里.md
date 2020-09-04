---
tags: [kotlin/问题记录]
title: 任何不熟悉的kotlin操作符都写这里
created: '2020-09-02T07:46:37.513Z'
modified: '2020-09-03T13:18:00.722Z'
---

# 任何不熟悉的kotlin操作符都写这里

1. as?
一种安全的as转换
```
// 如果e是Mlk类型，就赋值给 exc，如果不是，就返回e.message，并不赋值给exc
val exc = e as? MlKitException ?: return e.message
```

2. 定义回调接口
```

```

3. by lazy

4. kotlin的lambda表达式始终用花括号{}包围，但是实参并没有用括号括起来，箭头 -> 把实参列表和lambda的函数体分隔开。
```
{ x: Int, y: Int -> x + y }
```

5. 可以把lambda表达式存储在一个变量中，然后把这个变量当成普通函数对待
```
val sum = { x: Int, y: Int -> x + y }
val n = sum(2, 5) // n = 7
```



