package com.xorange.zip;

import android.app.Activity;
import android.os.Bundle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputStream is = null;
        FileOutputStream os = null;
        try {
//            is = getApplicationContext().getAssets().open("中文.zip");
            is = new FileInputStream("file:///android_asset/" + "中文.zip");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            File file = new File(getApplicationContext().getFilesDir() + "/" + "中文.zip");
            file.createNewFile();
            os = new FileOutputStream(file);
            os.write(buffer);
            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
