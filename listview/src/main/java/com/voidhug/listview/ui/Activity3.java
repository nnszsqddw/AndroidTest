package com.voidhug.listview.ui;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;


public class Activity3 extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] arr = {"苹果", "香蕉", "西瓜"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, arr);
        setListAdapter(adapter);
    }
}
