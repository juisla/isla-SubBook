package com.example.isla_subbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * Created by Julian Isla on 2/3/2018.
 * Custom adapter to display attributes of Subscription class in a Listview
 * implementation idea from android studio list tutorial video https://www.youtube.com/watch?v=rdGpT1pIJlw
 */

public class SubAdapter extends BaseAdapter {


    ///each array is an attribute from the Subscription class, displayed on a different text view
    LayoutInflater mInflater;
    private ArrayList<String> names;
    private ArrayList<String> dates;
    private ArrayList<Double> prices;
    private ArrayList<String> comments;

    public SubAdapter(Context c, ArrayList<String> n, ArrayList<String> d, ArrayList<Double> p, ArrayList<String> o){
        names = n;
        dates = d;
        prices = p;
        comments = o;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    ///default methods
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

    /**
     * set TextViews to display corresponding attributes
     * attribute fields are from provided arraylists
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View v = mInflater.inflate(R.layout.sub_list, parent, false);
        TextView nameView = (TextView) v.findViewById(R.id.nameView);
        TextView dateView = (TextView) v.findViewById(R.id.dateView);
        TextView priceView = (TextView) v.findViewById(R.id.monthlychargeView);
        TextView commentView = (TextView) v.findViewById(R.id.commentView);

        String name = names.get(position);
        String date = dates.get(position);
        Double price = prices.get(position);
        String comment = comments.get(position);

        nameView.setText(name);
        dateView.setText(date);
        priceView.setText(String.format("%.2f", price));
        commentView.setText(comment);

        return v;

    }
}
