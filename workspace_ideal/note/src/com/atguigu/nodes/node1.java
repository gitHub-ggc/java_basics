package com.atguigu.nodes;

/**
 *  面试题集合
 *  1.同步:当有多个线程在段是是单独执行的
 *  2.异步:同一段程序有多个线程
 *  3.死锁:不同的线程分别占用对方需要的同步资源不放弃,都在等待对方放弃自己需要的同步资源,就形成死锁,
 *         出现死锁后,不会出现异常,不会出现提示,只是所有的线程都处于阻塞状态,无法继续,故我们使用死锁时要
 *         避免出现死锁
 *  4.线程通信涉及到的三个方法:
 *    wait():一旦执行此方法,当前线程就进入阻塞状态,并释放同步监视器
 *    notify():一旦执行此方法,就会唤醒被wait的一个线程,如果有多个线程被wait,机会唤醒优先级高的那个
 *    notifyAll();一旦执行此方法,就会唤醒所有被wait的线程
 *    说明:1.这三个方法必须使用在同步代码块中或者同步方法中
 *         2.三个方法的调用者必须是同步代码块或同步方法中的同步监视器
 *         3.这三个方法都定义在Java.lang.object类中
 *  5.sleep和wait()的异同??
 *     >1.sleep和wait都可以对线程进行阻塞
 *    >区别 : 1.声明的位置不一样,sleep是在Thread中声明,wait是在object
 *            2.使用范围不一样:sleep哪里需要哪里使用,wait只能在同步代码器中
 *            3.sleep仅仅是阻塞,而wait除了阻塞还能释放同步监视器
 *  6.创建多个线程有哪几种方式
 *   >4种:extends Thread,impelements Runnable,impelements callable,线程池
 *  7.如何理解实现callable接口的方式创建多线程比实现rannble接口创建多线程方式强大??
 *    1.call()可以有返回值
 *    2.call()可以抛出异常,被外面的操作捕获,获取异常信息
 *    3.call()支持泛型
 *  8.利用线程池创建多线程
 *   好处: 提高响应速度(减少创建新线程的时间)
 *         降低资源消耗(重复利用线程池中线程,不需要每次创建)
 *         便于线程管理
 *         corePoolSize:核心池的大小
 *         maximumPoolSize:最大线程数
 *         keepAliveTime:线程没有任务时最多保持多长时间停止
 * 9.常用类:
 *      何为编码,何为解码,何为日期格式化?解析?
 *      编码:字符串按照某种机制转化为机器语言字节
 *      解码:字节 ==> 字符串
 *      格式化:日期 ==>字符串
 *      解析:字符串 ==> 日期
 *      String:字符串,使用一对""引起来表示
 *            1.String声明为final的,不可被继承
 *            2.string实现了Serializable接口:表示字符串是支持序列化的
 *                    实现了Comparable接口:表示string可以比较大小
 *            3.string内部定义了final char[] value用于存储字符串数据
 *            4.string:代表不可变的字符序列,简称:不可变性
 *            体现:1.当对字符串重新赋值时,需要重写指定内存区域赋值,不能使用原有的value进行赋值
 *                 2.当对现有的字符串进行连接操作时,也需要重新指定内存区域赋值
 *                 3.当调用string.replqce方法修改指定的字符或者字符串时,也需要重新指定内存区域赋值
 *            5.通过字面量的方式(区别于new)给一个字符串赋值,此时字符串常量池中
 *            6.字符串常量池中是不会存储相同内容的字符串的
 *            结论:常量与常量的拼接结果在常量池中,结果还在常量池中,变量与常量的拼接结果在堆中,
 *                 如果拼接结果调用intern()方法,返回值就在常量池中
 *             二:常用的方法
 *                1.ttring.length
 *                2.charAt()
 *                3. isEmpty()
 *                4.toLowerCase():转化为小写,原来不可变
 *                5.trim()
 *                6.boolean equals:比较两个字符串的内容是否相同
 *                7.str1.compareTo(str2):比较字符串的大小,常用于字符串的排序;
 *                8.indexOf:寻找字符串,有就返回当前字符的索引,没有的话就返回-1
 *                9.str.replace(char odlchar , char newchar)
 *              三:与其它类型转化
 *                1.String --->基本数据类型,包装类,调用包装类的静态方法 : parseXXX(str) <==>String.valueOf(num)
 *                2.String -->char[]:调用string的toCharArray() <=></=>new String(arr)
 *                3.string-->byte:str.getBytes() <===></> new String(byte) ;
 *              四:String , StringBuffer , StringBuider三者异同
 *                  String:不可变的字符序列
 *                  StringBuffer:可变的字符序列,线程安全的,效率低
 *                  StringBuider:JDK5新增 可变序列 线程不安全,效率高
 *                  StringBuffer常用的方法:
 *                    1.append(xxx):字符串的拼接
 *                    2.delete(num,num):删除字符
 *                    3.reverse:翻转
 *                    对比String , StringBuffer , StringBuild效率高低:3 > 2 >1;
 *                    String ==> StringBuffer,StringBuider之间的转化
 *                       1.调用StringBuffer,StringBuild构造器
 *                     StringBuffer,StringBuider ==>   String之间的转化
 *                       1.调用String构造器
 *        2.Date类:Java.util.Date类
 *                  -------Java.sql.Date类
 *                 1.两个构造器的使用
 *                     构造器一:Date(),创建一个对应当前时间的Date对象
 *                     构造器二:创建指定毫秒数的Date对象
 *                 2.两个方法的使用
 *                    toString()//创建当前时间
 *                    getTime():获取当前Date()对象对应的毫秒数(时间戳)
 *                 3.Java.sql.Date:对应着数据库中日期类型的变量
 *                   >如何实例化:
 *                   >如何将Java.util.Date对象转换为Java.sql.Date对象
 *                      Java.util.Date time1 = new Java.util.Date();
 *                      Java.sql.Date time2 = new java.sql.Date(time1.getTime());
 *         3.SimpleDateFormat:时间日期 格式化
 *            用法: Date date = new Date();
 *                  SimpleDateFormat spt = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
 *                  1.spt.Format(date);//格式化时间
 *                  2. spt.parse("2019-01-23 21:33:59");//标准时间
 *         4.java.util.Calendar:日历类
 *         5.Instant
 *            Instant instant = Instant.now();//获取本初子午线对应的标准时间
 *         6.Java比较器:正常情况下,只能进行比较: == 或 !=,不能使用 > 或 <的
 *            但是实际开发中,我们需要对多个对象进行排序,言外之意,就需要比较对象的大小
 *            如何实现?使用两个接口中的任何一个:Comparable 或者 Comparator
 *             1.Comparable接口的使用:
 *                像String,包装类等实现了comparable接口,重写了compareTo(obj)方法,给出两个比较的对象
 *                像String,包装类重写compareTo()方法以后,进行了从小到大的排序
 *                重写compareTo(obj)规则:Arrays.sort()
 *                   如果当前对象this大于形参对象obj,则返回正整数
 *                   如果当前对象this小于性擦对象obj,则返回负整数
 *                   如果当前对象this等于形参对象obj,则返回零
 *             2.Comparator
 *             3.Comparable与Comparable的使用方法比较
 *                  >Comparator接口的方式一旦指定,保证Comparable接口实现类的对象在任何位置都可以比较大小
 *                  >Comparator接口属于临时性的比较
 *         7.System类,:比如系统Java版本
 *           Math,:绝对值,三角函数
 *           BigInteger:表示不可变的任意精度的整数
 *           BIgDecimal:表示不可变的任意精度的数字(小数)
 * 10.枚举类,注解(Annotation)
 *          枚举:1.当一个类的对象是有限个时,那么这个类就是枚举类,当需要定义一组常量时,强烈建议使用枚举类
 *                2.如果枚举类只有一个对象,则可以作为一种单列模式的实现方法
 *           如何定义枚举类?
 *                方式一:jdk5.0之前,自定义枚举类 (详见test5)
 *                方式二:jdk5.0之后,可以使用enum关键字定义枚举类
 *           常用的方法:
 *               1.values():返回一个枚举类的含所有子类的数组
 *               2.valueOf(String objName):返回枚举类中对象名是objName的对象
 *               3.toString():返回当前枚举类对象常量的名称
 *           注解: 示例一:生成文档相关的注解(dome6)
 *                 示例二:在编译时进行格式检查(JDK内置的三个基本注解)
 *                       @Override:限定重写父类方法,该注解只能用于方法
 *                       @deprecated :用于表示所修饰的元素(类,方法等)已过时,通常是因为所修饰的结构危险
 *                       @SupperssWarnings:抑制编辑器警告
 *                 示例三:跟踪代码依懒性,实现替代配置文件功能
 *                 如何自定义注解:参考(Annotation)
 *11.集合
 *         1.集合框架的概述:集合和数组都是对多个数据进行存储操作的结构,简称Java容器
 *         2.说明:此时的存储,主要指的是内存层面的存储,不涉及到持久化的存储(.txt,.jpg,.AVI,数据库中)
 *         3.数组在存储多个数据方面的特点
 *              >一旦初始化以后,其长度就确定了
 *              >数组一旦定义好,其元素的类型也就确定了,我们也只能操作指定类型的数据了,比如:String[] arr;int[] arr1;
 *              >缺点: 1.一旦初始化以后,其长度无法改变
 *                     2.获取数组中实际元素的个数的需求,数组没有现成的属性和方法
 *                     3.数组存储数据的特点是有限的,有序,可重复
 *         4.Collection接口:单列集合,用来存储一个一个的对象
 *               >list接口:存储有序的,可重复的数据, -->"动态"数组
 *                   >ArrayList:作为List的主要实现类,执行效率高,线程不安全,底层使用object[] elementData存储
 *                    LinkedList:底层使用双向链表存储,对于频繁的插入,删除操作,使用此类效率比ArrayList高
 *                    Vector:古老的实现类,线程安全,效率不高
 *               >Set接口:存储无序的,不可重复的数据
 *                    无序性:不等于随机性;无序存储,存储的数据在底层数组中并非按照数组索引的顺序添加,而是根据数据的hash
 *                           值决定的
 *                    不可重复性:保证添加的元素按照equals()判断时,不能返回true,即相同的元素只能添加一个
 *                   >HashSet:作为set接口的主要实现类;线程不安全,可以存储null值
 *                   LinkedHashSet:作为HashSet的子类:遍历其内部数据时,可以按照添加的顺序遍历
 *                   TreeSet:可以按照添加对象的属性,进行排序
 *            Map接口:双列集合,用来存储一对(key - value)一对数据 -->高中函数:y = f(x)
 *                  >HashMap:作为map的主要的实现类,线程不安全,效率高,存储null的key和value
 *                   HashMap的底层:数组+链表(jdk7及之前)
 *                                 数组+链表+红黑树(jdk 8)
 *                     LinkedHashMap:保证在遍历map元素时,可以按照添加的顺序实现遍历
 *                                  原因:在原有的hashmap底层结构基础上,添加一对指针,指向前一个和后一个元素
 *                                  对于频繁的遍历操作,此类执行效率高于Hashmap
 *                  >TreeMap:保证按照添加的key-value对进行排序,实现排序遍历.此时考虑key的自然排序或定制排序
 *                           底层使用红黑树
 *                  >Hashtable:作为古老的实现类,线程安全,效率低,不能存储null的key和value
 *                     >Properties:常用来处置配置文件.key和value都是String类型
 *            Collections接口定义的方法
 *         面试题:比较ArrayList,LinkedList,Vector三者的异同?
 *             答:同:三个类都是实现List接口,存储数据的特点相同:存储有序的,可重复的数据
 *                异:见上;
 *         面试题:1.HashMap的底层实现原理?
 *                2.HashMap和Hashtable的异同?
 *                3.CurrentHashMap与Hashtable的异同?(暂时不讲)
 *      二:Map结构的理解:
 *         Map中的key:无序的,不可重复的,使用Set存储所有的key ===> key所在的类要重写equals()和hashCode() --以hashmap为例
 *         Map中的value:无序的,可重复的,使用Collection存储所有的value ==>value所在的类要重写equals()方法
 *         一个键值对:key-value构成了一个Entry对象
 *         Map中的entry:无序的,不可重复的,使用Set存储所有的entry
 *     三:HashMap的底层实现原理?以jdk7为例说明:
 *       HashMap map = new HashMap();
 *       在实例化以后,底层创建了长度为16的一维数组Entry[] table
 *       ...可能执行过多次put...
 *       map.put(key1,value1):
 *       首先,调用key1所在类的hashCode()计算key1哈希值,此哈希值经过某种算法计算以后,得到在Entry数组中的存放位置.
 *        如果此位置上的数据为空,此时的key1-value1添加成功.  ----情况1
 *        如果此位置上的数据不为空(意味着此位置上存在一个或者多个数据(以链表形式存在)),比较key1和已经存在的一个或者多个
 *        数据的哈希值:
 *              如果key1的哈希值与已经存在的数据的哈希值都不相同,此时key1-value1添加成功. --------情况2
 *              如果key1的哈希值和已经存在的某一个数据(key2-value2)的哈希值相同,继续比较:调用key1所在类的equals(key2)
 *                  如果equals()返回false:此时key1-value1添加成功.  -----情况3
 *                  如果equals()返回true:使用value1替换value2.
 *          补充:关于情况2和情况3:此时key1-value1和原来的数据已链表的形式存储
 *          在不断的添加过程中,会涉及到扩容问题,默认的扩容方式:扩容为原来的2倍,并将原来的数据复制过来
 *          加载因子为:0.75,就是说当存储的数组长度大于16 x 0,75 = 12时,开始扩容为原来的2倍
 *        jdk8相比较于jdk7在底层实现方面的不同
 *           1.new HashMap():底层没有创建一个长度为16的数组
 *           2.jdk 8底层的数组是:Node[],而非Entry[]
 *           3.首次调用put()方法时,底层创建长度为16的数组
 *           4.jdk7底层结构只有:数组+链表.jdk8中底层结构:数组+链表+红黑树.
 *               当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组长度 > 64时,
 *               此时此索引位置上的所有数据改为使用红黑树存储.
 *      四.LinkedHashMap底层实现原理(了解)
 *    五.Map中的常用方法:
 *    六.遍历map集合的2中方法
 *      1.Map entrySet = map.entrySet();
 *      Iterator iterator1 = entrySet.iterator();
 *      while(iterator1.hasNet()){
 *          Object obj = iterator1.next();
 *          Map.Entry entry = (Map.Entry)obj;
 *          System.out.println(entry.getKey(),entry.getValue())
 *      }
 *      2.Set keySet = map.keySet();
 *        Iterator iterator2 = ketSet.iterator();
 *        while(iterator2.hashNet()){
 *            Object key = iterator2.next();
 *            Object value = map.get(key);
 *            System.out.printle(key + "====== " +  value);
 *        }
 *  泛型:
 *      1.接口,抽象类不能用泛型
 *      2.静态方法不能用泛型
 *      3.异常类不能用泛型
 *      4.不能直接new 泛型,除非强制转化为泛型 T[] ARR = new T();
 *      5.泛型方法可以声明为静态的,原因:泛型参数是在调用方法是确定的.并非在实例化类时确定
 *  二.泛型方法:在方法中出现了泛型的结构,泛型参数与类的泛型参数没有任何关系,
 *     换句话说,泛型方法所属的类是不是泛型类都没有关系
 *     public <E>List<E> copyFromArrayToList(E[] arr){
          ArrayList<E> list = new ArrayList<>();
         for(E e : arr){
           list.add(e);
        }
        return list;
     }
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class node1 {
}
