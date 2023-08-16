package com.kzheng.generic;

/**
 * 泛型类派生子类时，如果子类不是泛型类，父类要明确泛型的数据类型
 */
public class ChildSecond extends Parent<Integer> {
    @Override
    public Integer getValue() {
        return super.getValue();
    }
    @Override
    public void setValue(Integer value) {
        super.setValue(value);
    }
}
