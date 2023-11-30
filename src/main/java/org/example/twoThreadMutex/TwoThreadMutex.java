package org.example.twoThreadMutex;

public class TwoThreadMutex {
    private static boolean thread1wantstoenter = false;
    private static boolean thread2wantstoenter = false;

    private static final boolean completed = true;

    public static void main(String[] args) {
        System.out.println("main start");
        startThreads();
        System.out.println("main finish");
    }

    private static void startThreads() {
        Thread t1 = new Thread(TwoThreadMutex::Thread1);
        Thread t2 = new Thread(TwoThreadMutex::Thread2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void Thread1() {
        do {
            thread1wantstoenter = true;
            while (thread2wantstoenter) {
                // gives access to other thread
                // wait for random amount of time
                thread1wantstoenter = false;
                thread1wantstoenter = true;
            }
            // critical section
            for (int i = 0; i < 10; i++) {
                System.out.println("thread 1=" + i);
            }
            thread1wantstoenter = false;
        } while (completed == false);
    }
    private static void Thread2() {
        do {
            thread2wantstoenter = true;
            while (thread1wantstoenter) {
                thread2wantstoenter = false;
                thread2wantstoenter = true;
            }
            // critical section
            for (int i = 0; i < 10; i++) {
                System.out.println("thread 2=" + i);
            }
            thread2wantstoenter = false;
        } while (completed == false);
    }

    private static void p0() {

    }
}
