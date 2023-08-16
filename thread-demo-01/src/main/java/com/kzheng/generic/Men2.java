package com.kzheng.generic;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/6/14 15:49
 */
public class Men2<Men2> extends AbstractMen implements People2<Men2>{
    @Override
    public void eat(Men2 e) {
        System.out.println(e.toString());
    }
}
