package com.voidhug.listview.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.voidhug.listview.R;

import java.util.ArrayList;


public class Activity6 extends AppCompatActivity {
    private ListView list;
    private AddNumberBaseAdapter addNumberBaseAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);
        list = (ListView) findViewById(R.id.listView);
        addNumberBaseAdapter = new AddNumberBaseAdapter(this);
        list.setAdapter(addNumberBaseAdapter);
    }
}

class AddNumberBaseAdapter extends BaseAdapter {

    private ArrayList<String> text;
    private LayoutInflater mInflater;

    public AddNumberBaseAdapter(Context context) {
        text = new ArrayList<>();
        text.add("第一项"); // 默认只加载第一个 item
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return text.size();
    }

    @Override
    public Object getItem(int position) {
        return text.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.add_number, null);
            holder.imageButton = (ImageButton) convertView.findViewById(R.id.btn_add_number);
            holder.editText = (EditText) convertView.findViewById(R.id.edit_number);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        switch (position) {
            case 0 :
                holder.imageButton.setBackgroundResource(R.mipmap.add_number); // 第一项按钮则显示加号图片
                break;
            default:
                holder.imageButton.setBackgroundResource(R.mipmap.delete_number); // 超过了一项则显示减号图片
                break;
        }

        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    text.add("xxx");
                } else if (position > 0) {
                    text.remove(text.size() - 1);
                }
                notifyDataSetChanged();
            }
        });
        return convertView;
    }
}

final class ViewHolder {
    public EditText editText;
    public ImageButton imageButton;
}
