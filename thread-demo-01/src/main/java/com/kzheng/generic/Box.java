package com.kzheng.generic;

public class Box <E>{
    private E first;

    public E getFirst() {
        return first;
    }

    public void setFirst(E first) {
        this.first = first;
    }

    public static void main(String[] args) {
        Box<Number> box1=new Box<>();
        box1.setFirst(100);
        showBox(box1);

        Box<Integer> box2=new Box<>();
        box2.setFirst(200);
        showBox(box2);
    }

    /**
     * \类型通配符
     * @param box
     */
    public static void showBox(Box<?> box){
        Object o=box.getFirst();
        System.out.println(o.toString());
    }

    /**
     * 类型通配符的上限
     * @param box
     */
    public static void showBox2(Box<? extends Number> box){
        Object o=box.getFirst();
        System.out.println(o.toString());
    }
}
