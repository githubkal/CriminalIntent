package android.bignerdranch.criminalintent;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

public class Crime {
    private UUID mId;       // holds the crime id
    private String mTitle;  // the title of the crime
    private Date mDate;     // the date of the crime
    private boolean mSolved;// is the crime solved?

    public Crime() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getID() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public void setTime(int hour, int min) {
        mDate.setHours(hour);
        mDate.setMinutes(min);
    }

    public int getHour() {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(mDate);
        return calendar.get(Calendar.HOUR);
    }

    public int getMinute() {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(mDate);
        return calendar.get(Calendar.MINUTE);
    }
}

