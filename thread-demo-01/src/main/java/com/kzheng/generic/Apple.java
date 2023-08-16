package com.kzheng.generic;

public class Apple<T,E> implements Generator<T> {
    private T key;
    private E value;

    public Apple(T key, E value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public T getKey(){
        return key;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Apple<String,Integer> apple=new Apple<>("count",100);
        System.out.println(apple.getKey()+"="+apple.getValue());

    }
}
