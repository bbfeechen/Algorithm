package agile_principles_practice_pattern.affiliations;

import java.util.Date;

public class ServiceCharge {
    private final Date time;
    private final double charge;

    public ServiceCharge(Date time, double charge) {
        this.time = time;
        this.charge = charge;
    }
}
