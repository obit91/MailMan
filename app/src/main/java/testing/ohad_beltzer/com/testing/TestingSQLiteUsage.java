package testing.ohad_beltzer.com.testing;

/**
 * Created by user on 14/05/2015.
 */
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class TestingSQLiteUsage extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("MyActivity", "Inserting ..");
        db.addMsg(new Msg("0526626850", "Dad", "Test 456"));
        db.addMsg(new Msg("0526626853", "Roy", "Test 654"));

        // Reading all contacts
        Log.d("MyActivity", "Reading all contacts..");
        List<Msg> msgs = db.getAllMsgss();

        for (Msg msg : msgs) {
            String log = "Id: "+msg.getID()+" ,Name: " + msg.getName() + " ,Phone: " + msg.getNumber()
                    + " ,Message: " + msg.getMsg();
            // Writing Msgs to log
            Log.d("MyActivity", log);
        }
    }
}