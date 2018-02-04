package com.example.isla_subbook;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import android.app.Activity;

/**
 * Created by JC on 2/3/2018.
 */

public class SubAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    private ArrayList<String> names;
    private ArrayList<String> dates;
    private ArrayList<String> prices;
    private ArrayList<String> comments;

    public SubAdapter(Context c, ArrayList<String> n, ArrayList<String> d, ArrayList<String> p, ArrayList<String> o){
        names = n;
        dates = d;
        prices = p;
        comments = o;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
       return names.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View v = mInflater.inflate(R.layout.sub_list, parent, false);
        TextView nameView = (TextView) v.findViewById(R.id.nameView);
        TextView dateView = (TextView) v.findViewById(R.id.dateView);
        TextView priceView = (TextView) v.findViewById(R.id.monthlychargeView);
        TextView commentView = (TextView) v.findViewById(R.id.commentView);

        String name = names.get(position);
        String date = dates.get(position);
        String price = prices.get(position);
        String comment = comments.get(position);

        nameView.setText(name);
        dateView.setText(date);
        priceView.setText(price);
        commentView.setText(comment);

        return v;

    }
}
