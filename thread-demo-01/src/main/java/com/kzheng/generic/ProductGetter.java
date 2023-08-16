package com.kzheng.generic;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * 抽奖器
 * @param <T>
 */
public class ProductGetter<T> {
    Random random=new Random();
    //奖品
    private  T product;
    //奖品池
    ArrayList<T> list=new ArrayList<>();
    public void addProduct(T t){
        list.add(t);
    }
    //抽奖
    public T getProduct(){
        product=list.get(random.nextInt(list.size()));
        return product;
    }

    /**
     *
     * 泛型方法
     * @param list
     * @param <E>
     * @return
     */
    public  <E> E getProduct(ArrayList<E> list){
        return list.get(random.nextInt(list.size()));
    }

    /**
     * 静态泛型方法
     * @param e
     * @param t
     * @param k
     * @param <E>
     * @param <T>
     * @param <K>
     */
    public  static <E,T,K> void printType(E e,T t,K k){
        System.out.println(e+"\t"+e.getClass().getSimpleName());
        System.out.println(t+"\t"+t.getClass().getSimpleName());
        System.out.println(k+"\t"+k.getClass().getSimpleName());
    }

    /**
     * 泛型可变参数的定义
     * @param e
     * @param <E>
     */
    public static <E> void print(E...e){
        for (int i = 0; i <e.length ; i++) {
            System.out.println(e[i]);
        }

    }
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException {
        ProductGetter<String> stringPG=new ProductGetter<>();
        String[] stringProducts={"苹果手机","华为手机","咖啡机","扫地机器人"};
        for (int i = 0; i <stringProducts.length; i++) {
            stringPG.addProduct(stringProducts[i]);
        }
        String product = stringPG.getProduct();
        System.out.println("恭喜你，抽中了："+product);
        System.out.println("-------------------------------------");
        ProductGetter<Integer> integerPG=new ProductGetter<>();
        Integer[] integerProducts={100,1000,2000,3000};
        for (int i = 0; i <integerProducts.length; i++) {
            integerPG.addProduct(integerProducts[i]);
        }
        Integer product2 = integerPG.getProduct();
        System.out.println("恭喜你，抽中了："+product2+"元");
        System.out.println("-------------------------------------");

        ArrayList<String> strList=new ArrayList<>();
        strList.addAll(Arrays.asList(stringProducts));
        String product1=stringPG.getProduct(strList);
        System.out.println(product1+"\t"+product1.getClass().getSimpleName());
        System.out.println("-------------------------------------");

        ProductGetter.printType(1,"20",false);
        System.out.println("-------------------------------------");

        ProductGetter.print(1,true,3,"2");

        System.out.println("-------------------------------------");
        String sc="123";
        setString(sc);
        System.out.println(sc);

        Date date=new Date();
        System.out.println(date);
        setDate(date);
        System.out.println(date);
        System.out.println("-------------------------------------");

        ArrayList<Integer> intList2=new ArrayList<>();
        ArrayList<String> strList2 = new ArrayList<>();
        System.out.println(intList2.getClass().getSimpleName());
        System.out.println(strList2.getClass().getSimpleName());
        System.out.println(intList2.getClass()==strList2.getClass());

        System.out.println("-------------------------------------");
        //泛型与反射
        //通过类
        Person p = Person.class.newInstance();
        System.out.println(p);

        //Student类的实例化
        Person student01= new Person();

        //方法一：通过getclass()
        Class<? extends Person> s1 = student01.getClass();
        System.out.println(s1);

        //方法二：通过class属性
        Class<Person> s2 = Person.class;
        System.out.println(s2);

        //方法三：通过Class.forname()
        System.out.println(Class.forName("com.kzheng.generic.Person"));

        //方法三：通过构造器
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor();
        Person person = constructor.newInstance();
        System.out.println(person);

        System.out.println("-------------------------------------");
        Constructor<Person> constructor2 = personClass.getConstructor(new Class[]{String.class});
        Person person2 = constructor2.newInstance("张三");
        System.out.println(person2);
        System.out.println(person2.getName());
        System.out.println("-------------------------------------");
    }
    public static void setString(String s){
        s+="T";
    }
    public static void setDate(Date date){
        date.setMonth(1);
    }
}
