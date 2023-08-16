package com.kzheng.generic;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/6/7 13:31
 */
public interface Worker<T> {
    void working(T name);

}
