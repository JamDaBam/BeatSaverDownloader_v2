package BeatsaverDownloader_v2.extensions.java.util.Date;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Extension
public class DateExtension {
    public static Date endOfDay(@This Date aDate) {
        final Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(aDate);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    @Extension
    public static Date of(int aYear, int aMonth, int aDay) {
        final Calendar cal = GregorianCalendar.getInstance();
        cal.set(aYear, aMonth - 1, aDay);
        return cal.getTime();
    }
}