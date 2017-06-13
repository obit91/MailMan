package testing.ohad_beltzer.com.testing;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by user on 07/05/2015.
 */
public class FileAccessor {

    final static String filename = "msgsOnRoute";
    File filesDir;
    Context myContext;
    final File file = new File (filesDir,filename);

    public FileAccessor (Context context, File file) {
        this.myContext = context;
        this.filesDir = file;
    }

    protected void updateFile(String output) {

        entryCheck();

        String data = output;
        FileOutputStream fos;

        try {
            fos = myContext.openFileOutput(filename, Context.MODE_PRIVATE);
            fos.write(data.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        exitCheck();
    }

    protected String readFile() {

        entryCheck();

        String line = "";
        FileInputStream fis;

        try {
            fis = myContext.openFileInput(filename);
        } catch (Exception e) {
            e.printStackTrace();
            return("An error has occurred whilst opening the file.");
        }

        InputStreamReader inputStreamReader = new InputStreamReader(fis);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder sb = new StringBuilder();
        try {
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return("An error has occurred whilst reading the file.");
        }

        try {
            bufferedReader.close();
            inputStreamReader.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
            return("An error has occurred whilst closing the file/buffer/reader.");
        }

        exitCheck();
        /**
         * wtf
         */
        line = sb.toString();

        return line;
    }

    protected void entryCheck() {

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void exitCheck() {
        if (file.length() == 1) {
            try {
                file.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
