package agile_principles_practice_pattern;

import java.util.Date;

public class TimeCard {
    private final Date date;
    private final double hours;

    public TimeCard(Date date, double hours) {
        this.date = date;
        this.hours = hours;
    }

    public double hours() {
        return hours;
    }

    public Date date() {
        return date;
    }
}
