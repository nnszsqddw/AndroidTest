package com.voidhug.listview.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.voidhug.listview.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Activity4 extends AppCompatActivity {
    private String[] chineseWords = new String[] {"苹果", "香蕉", "西瓜"};
    private String[] englishWords = new String[] {"apple", "banana", "watermelon"};
    private int[] imageIds = new int[] {R.mipmap.apple, R.mipmap.banana, R.mipmap.watermelon};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        List<Map<String, Object>> listItems = new ArrayList<>();
        for (int i = 0; i < chineseWords.length; i++) {
            Map<String, Object> listItem = new HashMap<>();
            listItem.put("image", imageIds[i]);
            listItem.put("chinese", chineseWords[i]);
            listItem.put("english", englishWords[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems, R.layout.simple_item,
                                                        new String[] {"image", "chinese", "english"},
                                                        new int[] {R.id.image, R.id.chinese, R.id.english});
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(simpleAdapter);
    }
}
