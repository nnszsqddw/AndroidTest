package com.voidhug.listview.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.voidhug.listview.R;


public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        ListView list1 = (ListView) findViewById(R.id.list1);
        String[] arr1 = {"孙悟空", "猪八戒", "牛魔王"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.array_item, arr1);
        list1.setAdapter(adapter1);

        ListView list2 = (ListView) findViewById(R.id.list2);
        String[] arr2 = {"苹果", "香蕉", "西瓜"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.array_item, arr2);
        list2.setAdapter(adapter2);
    }
}
