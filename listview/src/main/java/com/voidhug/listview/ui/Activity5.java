package com.voidhug.listview.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.voidhug.listview.R;


public class Activity5 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        ListView list = (ListView) findViewById(R.id.list);
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return 40;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LinearLayout line = new LinearLayout(Activity5.this);
                line.setOrientation(LinearLayout.HORIZONTAL);
                ImageView image = new ImageView(Activity5.this);
                image.setImageResource(R.mipmap.ic_launcher);
                TextView text = new TextView(Activity5.this);
                text.setText("第" + (position + 1) + "个列表项");
                text.setTextSize(20);
                text.setTextColor(Color.RED);
                line.addView(image);
                line.addView(text);
                return line;
            }
        };
        list.setAdapter(adapter);
    }
}
