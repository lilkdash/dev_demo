package com.kzheng.generic;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/6/7 13:23
 */
public  class Men<T> extends Person2  implements Worker<T>{



    public static void main(String[] args) {
        Men men = new Men();
        men.print(1);
        men.working(1);
        men.laugh();
        Worker worker=new Men();
        ((Men) worker).print(1);
        Person2 p=new Men();
        ((Men) p).working("kz");
    }

    @Override
    public void working(T name) {
        System.out.println(String.valueOf(name)+":i am working ");
    }

    @Override
    public void print(Object o) {

    }
}
