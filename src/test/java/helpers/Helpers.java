package helpers;

import tests.SetupConfiguration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Helpers extends SetupConfiguration {

    public String todayDateFromPattern(String pattern)
    {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }

    public static String generateString() {
        String uuid = UUID.randomUUID().toString();
        return "-" + uuid;
    }

}