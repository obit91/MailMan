package testing.ohad_beltzer.com.testing;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import java.io.File;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void testConnection(View view) {

//        File filesLoc = this.getFilesDir();

        /**
         * working with text files
         */
//
//        FileAccessor file = new FileAccessor(this,filesLoc);
//
//        file.updateFile("chen123");
//
        /**
         * experimenting with services
         */
//        Intent intent = new Intent(this, PostingLogsService.class);
//        intent.putExtra("files_directory",filesLoc);
//        startService(intent);

//        logTimer.main(null);
//
        /**
         * experimenting with SQLite
         */

//        Intent intent = new Intent(this, TestingSQLiteUsage.class);
//        startActivity(intent);

        /**
         * experimenting with contact information
         */

    }
}
