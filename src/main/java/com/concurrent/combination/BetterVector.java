package com.concurrent.combination;

import java.util.Vector;

/**
 * 在现有的线程安全类中添加功能，继承安全类。扩展Vector并增加一个“若没有则添加”方法
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/9/10
 * Time: 21:11
 */
public class BetterVector<E> extends Vector<E> {

    public synchronized boolean putIfAbsent(E e) {
        boolean absent = !contains(e);
        if (absent) {
            add(e);
        }
        return absent;
    }


    public static void main(String[] args) {
        BetterVector<String> betterVector = new BetterVector<String>();

        betterVector.putIfAbsent("kris");
        System.out.println(betterVector.size());

    }
}
