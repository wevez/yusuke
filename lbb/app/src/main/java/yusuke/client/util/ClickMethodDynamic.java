package yusuke.client.util;

import java.util.concurrent.ThreadLocalRandom;

public class ClickMethodDynamic {
    private int remainder = 0;
    private long time = System.currentTimeMillis();

    public int getClicks(double targetedCPS) {
        if (ThreadLocalRandom.current().nextDouble(1.0) > Math.sqrt(remainder + 4.0) / 3.0) { // choke (something around remainder = 9 forces it impossible)
            remainder++;
            return 0;
        } else {
            int ticks = (int) Math.round((System.currentTimeMillis() - time) / (1000.0 / (targetedCPS + remainder)));
            time += (ticks * (1000.0 / (targetedCPS + remainder)));
            remainder = 0;
            return ticks;
        }
    }

    public void reset(double targetedCPS) {
        time = System.currentTimeMillis() - (long) (1000.0 / targetedCPS); // resets so that the first hit is executed
        remainder = 0;
    }
}
