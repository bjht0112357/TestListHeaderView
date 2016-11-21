package com.pengguichu.testlistheaderview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by guichupeng on 2016/10/17.
 */
public class MyAdapter extends BaseAdapter {
    private List<String> data;
    private Context context;
    private Holder holder = null;
    public MyAdapter(List<String> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.listview_item, null);
            holder.textView = (TextView) convertView.findViewById(R.id.listview_item_tv);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.textView.setText(data.get(position));
        return convertView;
    }
    private class Holder {
        TextView textView;
    }
    //刷新list
    public void initData(List<String> data){
        this.data=data;
        notifyDataSetChanged();
    }
}
