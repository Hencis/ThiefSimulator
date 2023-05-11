package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class Police {

    private static final Integer SAFE_PASSWORD = 1000;

    public static boolean captured = true;

    public static void main(String[] args) throws InterruptedException {

        List<Thief> thieves = createThieves(4, 100000);
        List<Thread> thiefThreads = new ArrayList<>();
        for (Thief thief : thieves) {
            Thread thread = new Thread(thief);
            thread.start();
            thiefThreads.add(thread);
        }

        Thread.sleep(100);
        if (captured) {
            System.out.println("Arrested.");
        } else {
            System.out.println("The police failed.");
        }

        for (Thread thread : thiefThreads) {
            thread.stop();
        }

    }

    private static List<Thief> createThieves(int thievesNum, int end) {
        int iteration = end / thievesNum;
        List<Thief> thieves = new ArrayList<>();
        for (int i = 0; i < thievesNum; i++) {
            if (i == 0) {
                thieves.add(new Thief(i + 1, iteration, SAFE_PASSWORD));
            } else {
                thieves.add(new Thief(i * iteration + 1, (i + 1) * iteration, SAFE_PASSWORD));
            }
        }
        return thieves;
    }
}
