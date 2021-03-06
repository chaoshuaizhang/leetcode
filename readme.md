# 算法练习

>基础算法 + LeetCode
>注意，如果一个题有多个解法，要把多个解法都写下来，而不是在原有基础上改。

* 提交规范
1. feat：新功能（feature）
2. fix：修补bug
3. docs：文档（documentation）
4. style： 格式（不影响代码运行的变动）
5. refactor：重构（即不是新增功能，也不是修改bug的代码变动）
6. test：增加测试
7. chore：构建过程或辅助工具的变动
# 数据结构课本
## 排序
### 冒泡排序
>注意冒泡排序的第一层for循环就是参与技术的，指明你需要多少趟，内层循环才是做比较的！
* 空间复杂度：只用了tmp、change等变量，所以时O(1)
* 时间复杂度：
    * 最差情况是：默认是从大到小，所以需要进行n-1趟。
        * 每趟需要比较：
            1. 第一趟比较n-1次
            2. 第二趟比较n-2
            3. 第n-1趟比较1次
        * 所以时间复杂度是：((n-1)+1) * (n-1) = (n^2 - n)/2 = O(n^2)
    
### 快速排序
* 空间复杂度：本来以为是O(1)，但因为是递归调用，使用的空间大小需要和栈深度一样。
    * 栈的深度这里可想象成二叉树：每一棵树分成两棵树进行遍历，然后每棵子树再分成两棵树，
    所以最好情况是完全二叉树，最差情况是所有的树只有左子树/右子树。
    完全二叉树的高度是O(log2N)，只有左子树时高度是n，
    所以：完全二叉树时栈深度是O(log2(N+1))，因为n=1时栈深度是1，只有左子树时栈深度是O(n)。
* 时间复杂度：当划分成一边是0个元素，另一边是n-1个元素，此时的时间复杂度是最大的，是O(n^2)
    * 举例：1,2,3,4,5：
        1. 第一躺1和其它4个比较，固定1，比较n-1次
        2. 第二趟2和其它3个比较，固定2，比较n-2次
        3. 第三趟3和其它2个比较，固定3，比较n-3次
        4. 第四趟4和其它1个比较，固定4，比较n-4次
        5. 第五趟low=hight，不再比较
        6. 最终结果：n-1 + n-2 + n-3 + ... + n-(n-1) = 1+...+(n-2)+(n-1)=(n-1)*(1+n-1)/2=O(n^2)

#### 快排的优化：
1. 当划分的子序列较小时不再使用快排算法，使用其它算法。
2. 为了防止每次拿到的都是最小的元素（这样分出来的两个区域元素个数不一样，相当于避免变成只有左子树的树），可以首、尾、中间
取三个数，拿到三个数中第二小的。

### 插入排序
* 空间复杂度：O(1)
* 时间复杂度：
    * 最好情况是，数据源本来就是从小到大排序，：O(n)
    * 最坏情况是：数据源是从大到小排序，则需要移动1+2+..+n-1 = (n-1)n/2 = O(n^2)
    
# leetcode

### 5最长回文字串
* 刚开始的思路是没有思路，只有穷举：生成一个反转的串，比如qwert---trewq，得到qwe时，从trewq中取出ewq（根据角标取），
然后比较这俩字串，如果相等，则MAX=3，MAX_STR=qwe，接下来再比较时覆盖之前的MAX。
