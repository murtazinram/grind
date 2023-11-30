package org.example.twoThreadMutex;

public class TwoThreadMutex1 {
    private static boolean flag0 = false;
    private static boolean flag1 = false;
    private static int turn = 0;
    public static void main(String[] args) {
        System.out.println("main start");
        Thread t1 = new Thread(TwoThreadMutex1::p0);
        Thread t2 = new Thread(TwoThreadMutex1::p1);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main finish");
    }

    private static void p0() {
        flag0 = true;
        while (flag1) {
            if (turn != 0) {
                flag0 = false;
                while (turn != 0) {
                    System.out.println("busy 1");
                }
                flag0 = true;
            }
        }
        // критическая секция
        for (int i = 0; i < 10; i++) {
            System.out.println("thread 1=" + i);
        }
        turn = 1;
        flag0 = false;
        // конец критической секции
    }

    private static void p1() {
        flag1 = true;
        while (flag0) {
            if (turn != 1) {
                flag1 = false;
                while (turn != 1) {
                    System.out.println("busy 1");
                }
                flag1 = true;
            }
        }
        // критическая секция
        for (int i = 0; i < 10; i++) {
            System.out.println("thread 2=" + i);
        }
        turn = 0;
        flag1 = false;
        // конец критической секции
    }
}
