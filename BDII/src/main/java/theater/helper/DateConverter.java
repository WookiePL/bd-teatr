package theater.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Singleton class, which converts date from String to SQL date format
 * @author Lukasz Janas
 */
public class DateConverter {

    private static DateConverter instance = null;

    private DateConverter() {}

    public static DateConverter getInstance() {
        if (instance == null) {
            instance = new DateConverter();
        }
        return instance;
    }

    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * @param dateAsString
     * @return date in SQL format
     */
    public java.sql.Date stringToDate(String dateAsString) {
        Date parsed = new Date();
        try {
            parsed = format.parse(dateAsString);
        } catch (ParseException e) {
            System.out.println("Podano złą datę na wejściu metody stringToDate(String) :(");
            e.printStackTrace();
        }
        java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
        return sqlDate;
    }


}
