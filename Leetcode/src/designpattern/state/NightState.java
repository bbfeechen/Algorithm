package designpattern.state;

public class NightState implements State {
    private static NightState singleton = new NightState();
    private NightState() { }
    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (9 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("Use(night)");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("Alarm(night)");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("Phone(night)");
    }

    public String toString() {
        return "[night]";
    }
}
