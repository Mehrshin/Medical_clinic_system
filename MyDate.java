import java.time.LocalDateTime;

/**
 * Purpose: create the Date class
 * 
 * @version 1.0
 * @since 2023-06-27
 * @author Shirin , Megan, Hossein
 */

// class declaration
public class MyDate {
    // data member
    private int day;
    private int month;
    private int year;

    // default constructor
    public MyDate() {
        this.day = 1;
        this.month = 1;
        this.year = 1900;
    }

    // parameterized constructor
    public MyDate(int aDay, int aMonth, int aYear) {
        setDate(aDay, aMonth, aYear);
    }

    public void setDate(int theDay, int theMonth, int theYear) {
        if (theDay > 0 && theDay < 31) {
            this.day = theDay;
        } else {
            this.day = 1;
        }

        if (theMonth > 0 && theMonth < 12) {
            this.month = theMonth;
        } else {
            this.month = 1;
        }

        if (theYear <= LocalDateTime.now().getYear()) {
            this.year = theYear;
        } else {
            this.year = 1900;
        }
    }

    // accessors methods
    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public static MyDate changeStringToMyDate(String stringDate) {
        try {
            String[] date = stringDate.split("-");
            String day = date[0];
            String month = date[1];
            String year = date[2];
            MyDate returningDate = new MyDate(Integer.valueOf(day), Integer.valueOf(month), Integer.valueOf(year));
            return returningDate;
        } catch (IndexOutOfBoundsException iobe) {
            System.out.println("Invalid date format. Default date inserted.");
            return new MyDate();
        } catch (NumberFormatException nfe) {
            System.out.println("You must enter integers in the given format(dd-mm-yyyy)");
            return new MyDate();
        }
    }

    @Override
    public String toString() {
        String str = "";
        if (this.day < 10) {
            str = "0";
        }
        str = str + day + "-";

        if (this.month < 10) {
            str = str + "0";
        }
        str = str + month + "-" + year;

        return str;
    }

}
