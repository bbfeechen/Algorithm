package agile_principles_practice_pattern;

import java.util.Date;

public class DateUtil {
    public static boolean IsInPayPeriod(Date theDate, Date startDate, Date endDate) {
        return theDate.after(startDate) && (theDate.before(endDate));
    }
}
