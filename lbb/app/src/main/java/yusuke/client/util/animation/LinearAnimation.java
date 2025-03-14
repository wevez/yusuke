package yusuke.client.util.animation;

public class LinearAnimation extends AnimationUtil {

    @Override
    public double calcPercent() {
        return tick;
    }
}
