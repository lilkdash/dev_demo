package com.kzheng.generic;

/**
 * 子类也是泛型类，子类和父类的泛型类型要一致
 *  错误：class ChildFirst<T> extends Parent<E>
 *  也可以写成：class ChildFirst<T,E,K> extends Parent<T> {
 * @param <T>
 */
public class ChildFirst<T> extends Parent<T> {

    @Override
    public T getValue() {
        return super.getValue();
    }
}
