package testing.ohad_beltzer.com.testing;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 14/05/2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "messageManager";

    // Contacts table name
    private static final String TABLE_MSGS = "messages";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";
    private static final String KEY_MSG = "sms_message";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MSGS_TABLE = "CREATE TABLE " + TABLE_MSGS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT," + KEY_MSG + " TEXT" + ")";
        db.execSQL(CREATE_MSGS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MSGS);

        // Create tables again
        onCreate(db);
    }

    // Adding new msg
    public void addMsg(Msg msg) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, msg.getName()); // Msg Name
        values.put(KEY_PH_NO, msg.getNumber()); // Msg Phone Number
        values.put(KEY_MSG, msg.getMsg()); // Msg text

        // Inserting Row
        db.insert(TABLE_MSGS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single msg
    public Msg getMsg(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_MSGS, new String[]{KEY_ID,
                        KEY_PH_NO, KEY_NAME, KEY_MSG}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Msg msg = new Msg(cursor.getString(1),
                cursor.getString(2), cursor.getString(3));
        msg.setID(Integer.parseInt(cursor.getString(0)));
        // return msg
        return msg;
    }

    // Getting All Msgs
    public List<Msg> getAllMsgss() {

        List<Msg> msgList = new ArrayList<Msg>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MSGS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Msg msg = new Msg();
                msg.setID(Integer.parseInt(cursor.getString(0)));
                msg.setNumber(cursor.getString(1));
                msg.setName(cursor.getString(2));
                msg.setMsg(cursor.getString(3));

                // Adding msg to list
                msgList.add(msg);

            } while (cursor.moveToNext());
        }

        // return msg list
        return msgList;
    }

    // Getting msgs Count
    public int getMsgsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_MSGS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    // Updating single msg
    public int updateMsg(Msg msg) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, msg.getName());
        values.put(KEY_PH_NO, msg.getNumber());
        values.put(KEY_MSG, msg.getMsg());

        // updating row
        return db.update(TABLE_MSGS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(msg.getID()) });
    }

    // Deleting single msg
    public void deleteMsg (Msg msg) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MSGS, KEY_ID + " = ?",
                new String[] { String.valueOf(msg.getID()) });
        db.close();
    }
}
