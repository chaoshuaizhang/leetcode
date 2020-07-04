//package com.testmodule.dailypractice.泛型;
//
//import com.testmodule.pattern.factory.abstractfactory.HuaWeiPhoneProduct;
//import com.testmodule.pattern.factory.factorymethod.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestFanxing {
//    public void testFanxing() {
//        // 协变，extends：父类类型的泛型引用指向子类类型的具体泛型实例
//        testExtends();
//
//        // 逆变/反变，super：子类类型的泛型引用指父类类类型的具体泛型实例
//        List<? super XiaoMiPowerProduct> what = new ArrayList<>();
//        List<PhoneProduct> phoneProducts = new ArrayList<>();
//        phoneProducts.add(new XiaoMiPowerProduct());
//        phoneProducts.add(new HuaWeiPowerProduct());
//
//        what = phoneProducts;
//        // 即使改变what引用的指向，它get得到的依旧是 ? extends XiaoMiPowerProduct
//        what.add(new XiaoMiPowerProduct());
//        // 得到的是什么类型？不知道。。。
//        Object object = what.get(0);
//
//        // ------------------------------------------------
//
//        List<RobinWoman> robinWomanList = new ArrayList<>();
//        List<Employee> employees = new ArrayList<>();
//        List<Manager> managers = new ArrayList<>();
//        List<CEO> ceos = new ArrayList<>();
//        List<Manager> list = null;
//        list = robinWomanList;
//
//        list = employees;
//        list = managers;
//        // CEO不再是Manager的父类，所以引用报错
//         list = ceos;
//
//        /*
//        * Manager实现RobinWoman接口
//        *
//        * 添加自己的接口类型 - 不行，相当于是下转型
//        * */
//        RobinWoman rw = new RobinWoman(){};
//        list.add(rw);
//        /*
//        * 添加自己父类的父类，报错
//        * 这里相当于是逆多态（下转型），这是不被允许的
//        * */
//        list.add(new Robin());
//
//        /*
//        * 不能添加自己的父类，报错
//        * 和上述一样，也是下转型，不被允许
//        * */
//        list.add(new Employee());
//        /*
//        * 可以添加自己，这不用解释
//        * */
//        list.add(new Manager());
//        /*
//        * 可以添加子类
//        * 多态（上转型）的应用
//        * */
//        list.add(new CEO());
//        // 为什么？
//
//        // 看这个实例，当定义一个Manager类型的List后，所有get出来的全都是Manager类型
//        List<Manager> managers1 = new ArrayList<>();
//        managers1.add(new CEO());
//        // 对于<Manager>类型的list，拿出来的都是Manager类型的
//        // 那么对于 ? super Manager类型的List，你装进去的是Manager的父类或者是Manager实现的接口，那么它
//        // 默认就要转为? super Manager类型，但是? super Manager实际到底是什么类型？是Employee还是RobinWoman？假设
//        // 你实际是RobinWoman，但是你取出来之后改为了Employee，这样就就会出现异常
//        // 编译器不知道具体的父类会是什么，但编译器知道的是：里边放的肯定是Manager的子类，不管你放的是哪一个子类，下转型肯定是不会错的
//        Manager manager = managers1.get(0);
//
//        // 来看看 <? super Manager> 如何取?
//        List<? super Manager> managers2 = new ArrayList<>();
//        // 这是报错的，子类竟然不能转为父类，为什么？谁知道你取出来的是Employee还是RobinWoman？
//        Employee employee = managers2 .get(0);
//        // 可以取出Object，但是对于Object来说，没有意义，你强转转为固定类型后，仍然可能会报错（下转型）
//        Object object1 = list.get(0);
//
//        //java不支持协变和逆变，需要 ? extends和? super来打破限制： 无法声明一个父类的泛型类型，然后让它指向子类的泛型类型（因为有类型擦除的原因）
//        List<Robin> robins = new ArrayList<Employee>();
//        // 但是数组支持，见下边
//
//        // 但是可以通过下面这种通配符，来解除上述无法把子类赋值给父类的限制，但是也会增加新的限制---》上边已经说了，可读不可写
//        // 读操作
//        List<Manager> l = new ArrayList<>();
//        List<? extends Robin> robins_ = new ArrayList<Employee>();
//        robins_ = l;
//        // 不可写操作，发现什么类型都放不进去
//        robins_.add(new Robin());
//        robins_.add(new Manager());
//        robins_.add(new Employee());
//
//        setAAA(robins_);
//
//        List<String> strs = new ArrayList<String>();
//        // 这块儿报错的原因是：实际上Object是所有类型的父类，但是在形式上，String类里并没有extends Object这样的形式
//        List<Object> objs = strs;
//        objs.add("");
//
//        // 但是数组就可以把子类赋值给父类
//        Employee[] employees1 = new Manager[10];
//        employees1[0] = new Manager();
//        employees.add(new Manager());
//
//        // 关于数组的协变
//        Robin[] robinss = new Employee[2];
//        System.out.println(robinss.length);
//
//        Robin employee = new Robin();
//        // 下转型一定会报错---之前竟然认为不会报错，只是子类的方法父类无法调，。。。。。看看下边的！！！
//        //com.testmodule.dailypractice.泛型.Robin cannot be cast to com.testmodule.dailypractice.泛型.Employee
//        Employee robin = (Employee) employee;
//
//        /*
//        * 报错：编译时不报错，运行时报错，ArrayStoreException异常
//        * 数组里应该放Robin及其子类型，所以如果放置父类型就会报错
//        * */
//        //robinss[0] = new Robin();
//
//        // 不报错
//        robinss[0] = new Employee();
//
//        // 不报错
//        robinss[0] = new Manager();
//
//        // 坑里本来就是Employee类型，可以放进去子类（上转型），不能放进去父类（下转型）
//
//        // 所以协变是危险的，
//
//    }
//
//    private void testExtends() {
//        // 多态的体现
//        PhoneProduct product = new XiaoMiPowerProduct();
//        // 用在集合上就不行
//        /*
//         * 定义一个父类的泛型引用 products
//         * */
//        List<PhoneProduct> products = new ArrayList<>();
//        // 发现它可以装任何子类
//        products.add(new XiaoMiPowerProduct());
//        products.add(new HuaWeiPowerProduct());
//        List<XiaoMiPowerProduct> productList = new ArrayList<>();
//        // 改变引用，指向自己的子类泛型引用 --- 报错了
//        products = productList;
//        // 这时，我们想想，XiaoMiPowerProduct里装的肯定是PhoneProduct，为什么不行呢，因为泛型不支持协变
//        // 假如支持，想象一下，我们products.get(0)时所做的操作其实是把真正的XiaoMiPowerProduct转变为PhoneProduct，这样的操作是安全的
//        // 但是product.add()操作呢？对于products来说，它只知道自己内部装的是PhoneProduct的子类，具体是什么？不知道。
//        // 所有就有可能装错，本来装的都是XiaoMiProduct，突然来了个HuaWeiProduct，这样后期使用时肯定会报错（? extends T一般都是作为方法的参数来使用的）。
//        //
//        // 看一下开头说的话：明明装的是自己的子类，凭什么不让我用类似多态（上转型）的方式使用？
//        // 于是就出现了通配符：extends
//        List<? extends PhoneProduct> products2 = new ArrayList<>();
//        // 此时可以使用父类的泛型引用指向子类的泛型引用
//        products2 = productList;
//        // products2不知道自己get出来的是谁，但肯定是自己的子类，并且在使用的过程中不会报错，因为多态（上转型）
//        PhoneProduct product2 = products2.get(0);
//        // 如果productList本身装的是HuaWei，你现在装进去一个XiaoMi，后期别人使用原始的productList肯定会报错
//        products2.add(new XiaoMiPowerProduct());
//        //
//        PhoneProduct product1 = new PhoneProduct() {
//            @Override
//            public void productFeatures() {
//
//            }
//        };
//        // 同理
//        products2.add(product1);
//    }
//
//
//    void setAAA(List<? extends Employee> list) {
//    }
//
//    public static void main(String[] args) {
//        Object o = new String();
////        ClassCastException: java.lang.Object cannot be cast to java.lang.String
////        String s = (String) new Object();
////        TestFanxing.testComp(new AA());
////        testComp(new Employee());
//        TestFanxing testFanxing = new TestFanxing();
//        testFanxing.testFanxing();
//    }
//
//    public static <T extends Comparable<T>> void testComp(T t) {
//
//    }
//
//    public void operationProducts(){
//        TestFanxing t = new TestFanxing();
//        /*
//        * 场景一：有小米集合、华为集合，现在想定义一个方法：
//        * 传小米集合时遍历执行所有小米实例的方法
//        * 传华为集合时遍历执行所有华为实例的方法
//        * */
//        List<XiaoMiPowerProduct> xiaoMiPowerProducts = new ArrayList<>();
//        List<HuaWeiPowerProduct> huaWeiPowerProducts = new ArrayList<>();
//        // 【1】执行完productDoSth后，xiaoMiPowerProducts集合里多了个华为产
//        // 品，那么后期使用xiaoMiPowerProducts时就会存在报错的风险，并且编译器
//        // 是无法知道我们传的是什么类型的集合，它只知道是子类。
//        t.productDoSth(xiaoMiPowerProducts);
//        t.productDoSth(huaWeiPowerProducts);
//
//        // 定义一个通用的存放商品的集合
//        List<PhoneProduct> products = new ArrayList<>();
//        // 往products集合中添加小米商品
//        t.addXiaoMiProduct(products);
//        // 往products集合中添加华为商品
//        t.addHuaWeiProduct(products);
//
//    }
//
//    /*
//    * ? extends T 的使用场景
//    * List<? extends PhoneProduct> products = new ArrayList<XiaoMiPowerProduct>()
//    * */
//    public void productDoSth(List<? extends PhoneProduct> products){
//        for (PhoneProduct product : products) {
//            product.productFeatures();
//        }
//        /*
//         * 假设 ? extends T 支持写操作，那么我们进行追加华为产品操作
//         * 可是，如果此时传过来的products是List<XiaoMiPowerProduct>类型的呢？
//         * 此时我们给小米集合里添加了一个华为产品，这是执行完毕回到【1】
//         * */
//        products.add(new HuaWeiPowerProduct());
//    }
//
//    /*
//    * ? super T的使用场景
//    * List<? super XiaoMiPowerProduct> products = new ArrayList<PhoneProduct>()
//    * 添加小米手机的操作
//    * 因为现在传过来的不是小米集合，而是一个通用的集合，那么通用的集合肯定能装各种手机
//    * */
//    public void addXiaoMiProduct(List<? super XiaoMiPowerProduct> products){
//        XiaoMiPowerProduct xiaoMiPowerProduct = new XiaoMiPowerProduct();
//        products.add(xiaoMiPowerProduct);
//
//        // 默认得到的是Object类型，那么是否可以进行强转呢？
//        // products里边装的是各种手机的集合，你知道第n个元素装的是什么类型的吗？
//        // 所以这里无法做强转，具体说应该是强转有风险，这里不是绝对的上转型
//        Object object = products.get(0);
//    }
//
//    /*
//    * 添加华为手机的操作
//    * */
//    public void addHuaWeiProduct(List<? super HuaWeiPowerProduct> products){
//        HuaWeiPowerProduct huaWeiPowerProduct = new HuaWeiPowerProduct();
//        products.add(huaWeiPowerProduct);
//    }
//
//}
//
//class AA implements Comparable<AA>{
//    @Override
//    public int compareTo(AA o) {
//        return 0;
//    }
//}
//class BB implements Comparable<Integer>{
//    @Override
//    public int compareTo(Integer o) {
//        return 0;
//    }
//}
//
//class OriginMan{}
//
//interface RobinWoman {
//
//}
//
//class Robin extends OriginMan implements Comparable<Integer> {
//
//    @Override
//    public int compareTo(Integer o) {
//        return 0;
//    }
//}
//
//class Employee extends Robin {
//}
//
//class Manager extends Employee implements RobinWoman {
//}
//
//class CEO extends Manager {
//}
//
//
