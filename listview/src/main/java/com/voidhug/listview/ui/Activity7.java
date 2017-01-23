package com.voidhug.listview.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.voidhug.listview.R;
import com.voidhug.listview.utils.Debug;

import java.util.ArrayList;


public class Activity7 extends AppCompatActivity {
    private ListView list;
    private SwitchControlAdapter adapter;
    private Button button;

    View.OnClickListener mDeleteOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_7);

        list = (ListView) findViewById(R.id.listView);

        adapter = new SwitchControlAdapter(this);
        list.setAdapter(adapter);
    }

    public void add_switch(View v) {
        adapter.getData().add("***");
        adapter.notifyDataSetChanged();
    }


    class SwitchControlAdapter extends BaseAdapter {
        private ArrayList<String> text;
        private LayoutInflater mInflater;

        public ArrayList getData() {
            return text;
        }

        public SwitchControlAdapter(Context context) {
            text = new ArrayList<>();
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
                convertView = mInflater.inflate(R.layout.switch_control, null);
                holder.textView = (TextView) convertView.findViewById(R.id.mTextView);
                holder.toggleButton = (ToggleButton) convertView.findViewById(R.id.mTogBtn);
                holder.imageButton = (ImageButton) convertView.findViewById(R.id.deleteBtn);
//                holder.imageButton.setOnClickListener(mDeleteOnClickListener);
//                holder.imageButton.setTag(position);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.textView.setText("开关" + (position + 1));
            holder.toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        Debug.log("第" + position + "开关 开");
                    } else {
                        Debug.log("第" + position + "开关 关");
                    }
                }
            });
            holder.imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    text.remove(position);
                    notifyDataSetChanged();
                }
            });
            return convertView;
        }
    }

    final class ViewHolder {
        public TextView textView;
        public ToggleButton toggleButton;
        public ImageButton imageButton;
    }
}


