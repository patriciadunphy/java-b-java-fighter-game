package org.program.ui;

public class Sleep {
    /**
     * method to delay the ouput
     * @param ms
     */
    public static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
