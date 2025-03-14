package yusuke.client.util;

import lombok.Setter;

@Setter
public class TimerUtil {
    public long time;
    
    public TimerUtil() {
        super();
        this.time = System.currentTimeMillis();
    }
    
    public boolean hasTimeElapsed(final double delay, final boolean reset) {
        if (System.currentTimeMillis() - this.time >= delay) {
            if (reset) {
                this.reset();
            }
            return true;
        }
        return false;
    }
    
    public long getTime() {
        return System.currentTimeMillis() - this.time;
    }
    
    public void reset() {
        this.time = System.currentTimeMillis();
    }

}
