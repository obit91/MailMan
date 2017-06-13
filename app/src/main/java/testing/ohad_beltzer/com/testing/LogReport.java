package testing.ohad_beltzer.com.testing;

import android.util.Log;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by user on 13/05/2015.
 */
public class LogReport extends TimerTask {

    public void run() {
        Calendar date = Calendar.getInstance();
        Log.v("MyActivity", "Generating report at " + date.get(date.HOUR_OF_DAY) + ":" + date.get(date.MINUTE) + ":" + date.get(date.SECOND));
    }
}

class logTimer {
    public static void main (String[] args) {
        Timer timer = new Timer();
        Calendar c = Calendar.getInstance();
//        Log.v("MyActivity", "c value: " + c.toString());
//        Log.v("MyActivity", "c value: " + c.get(c.HOUR_OF_DAY));
//        c.add(Calendar.HOUR_OF_DAY, 2);
//        Log.v("MyActivity", "c value: " + c.toString());
//        Log.v("MyActivity", "c value: " + c.get(c.HOUR_OF_DAY));
        Log.v("MyActivity", "currently" + c.get(c.HOUR_OF_DAY) + ":" + c.get(c.MINUTE) + ":" + c.get(c.SECOND));
        c.set(c.HOUR_OF_DAY,18);
        c.set(c.MINUTE,28);
        c.set(c.SECOND, 45);
        Log.v("MyActivity", "report should appear at: " + c.get(c.HOUR_OF_DAY) + ":" + c.get(c.MINUTE) + ":" + c.get(c.SECOND));
        // Schedule to run every Sunday in midnight
        timer.schedule(new LogReport(),
                c.getTime());
//        Log.v("MyActivity", "Starting at " + date.HOUR + ":" + date.MINUTE + ":" + date.SECOND);
    }
}
