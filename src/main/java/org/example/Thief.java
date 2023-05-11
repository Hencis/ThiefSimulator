package org.example;

public class Thief implements Runnable {

    private int minRange;
    private int maxRange;
    private int safeCode;

    public Thief(int minRange, int maxRange, int safeCode) {
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.safeCode = safeCode;
    }

    @Override
    public String toString() {
        return "Thief{" +
                "minRange=" + minRange +
                ", maxRange=" + maxRange +
                ", safeCode=" + safeCode +
                '}';
    }

    /*This method is an override for the run method, which checks in sections all the numbers between two integer type numbers
        and finds out the "safe code", then exists.
        */
    public void run() {
        System.out.println("Thief checking after the code...");
        for (int i = minRange; i <= maxRange; i++) {
            if (i == safeCode) {
                System.out.println("The thief got the gold.");
                Police.captured = false;
                break;
            }
        }
    }
}

