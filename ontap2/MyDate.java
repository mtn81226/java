public class MyDate {
    private int year, month, day;

    public static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", 
                                           "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    public static final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", 
                                         "Thursday", "Friday", "Saturday"};
    public static final int[] DAYS_IN_MONTHS = {31, 28, 31, 30, 31, 30, 
                                                31, 31, 30, 31, 30, 31};

    public MyDate(int year, int month, int day) {
        setDate(year, month, day);
    }

    public void setDate(int year, int month, int day) {
        if (!isValidDate(year, month, day)) {
            throw new IllegalArgumentException("Invalid year, month, or day!");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setYear(int year) {
        if (year < 1 || year > 9999) {
            throw new IllegalArgumentException("Invalid year!");
        }
        this.year = year;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month!");
        }
        this.month = month;
    }

    public void setDay(int day) {
        int dayMax = DAYS_IN_MONTHS[this.month - 1];
        if (isLeapYear(this.year) && this.month == 2) {
            dayMax = 29;
        }
        if (day < 1 || day > dayMax) {
            throw new IllegalArgumentException("Invalid day!");
        }
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static boolean isValidDate(int year, int month, int day) {
        if (year < 1 || year > 9999 || month < 1 || month > 12) {
            return false;
        }
        int dayMax = DAYS_IN_MONTHS[month - 1];
        if (isLeapYear(year) && month == 2) {
            dayMax = 29;
        }
        return day >= 1 && day <= dayMax;
    }

    public static int getDayOfWeek(int year, int month, int day) {
        int[] T = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        if (month < 3) {
            year -= 1;
        }
        return (year + year / 4 - year / 100 + year / 400 + T[month - 1] + day) % 7;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s %d", 
                             DAYS[getDayOfWeek(year, month, day)], 
                             day, 
                             MONTHS[month - 1], 
                             year);
    }

    public MyDate nextDay() {
        if (day < DAYS_IN_MONTHS[month - 1] || (month == 2 && day == 28 && isLeapYear(year))) {
            day++;
        } else if (day == 28 && month == 2 && isLeapYear(year)) {
            day++;
        } else {
            day = 1;
            nextMonth();
        }
        return this;
    }

    public MyDate nextMonth() {
        if (month < 12) {
            month++;
        } else {
            month = 1;
            nextYear();
        }
        int dayMax = DAYS_IN_MONTHS[month - 1];
        if (month == 2 && isLeapYear(year)) {
            dayMax = 29;
        }
        if (day > dayMax) {
            day = dayMax;
        }
        return this;
    }

    public MyDate nextYear() {
        if (year < 9999) {
            year++;
            if (month == 2 && day == 29 && !isLeapYear(year)) {
                day = 28;
            }
        } else {
            throw new IllegalStateException("Year out of range!");
        }
        return this;
    }

    public MyDate previousDay() {
        if (day > 1) {
            day--;
        } else {
            previousMonth();
            day = DAYS_IN_MONTHS[month - 1];
            if (month == 2 && isLeapYear(year)) {
                day = 29;
            }
        }
        return this;
    }

    public MyDate previousMonth() {
        if (month > 1) {
            month--;
        } else {
            month = 12;
            previousYear();
        }
        int dayMax = DAYS_IN_MONTHS[month - 1];
        if (month == 2 && isLeapYear(year)) {
            dayMax = 29;
        }
        if (day > dayMax) {
            day = dayMax;
        }
        return this;
    }

    public MyDate previousYear() {
        if (year > 1) {
            year--;
            if (month == 2 && day == 29 && !isLeapYear(year)) {
                day = 28;
            }
        } else {
            throw new IllegalStateException("Year out of range!");
        }
        return this;
    }

   
    
}
