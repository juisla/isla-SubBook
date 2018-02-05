package com.example.isla_subbook;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class SubBook extends AppCompatActivity {

    private static final String FILENAME = "testfile.sav";
    private ListView view_subs;

    private ArrayList<Subscription> sublist = new ArrayList<>();
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> dates = new ArrayList<>();
    private ArrayList<Double> prices = new ArrayList<>();
    private ArrayList<String> comments = new ArrayList<>();
    private double total = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sub_book);

        view_subs = findViewById(R.id.oldsublist);
        loadFromFile();
        if(sublist.size() > 0) {
            SubAdapter subAdapter = new SubAdapter(this, names, dates, prices, comments);
            view_subs.setAdapter(subAdapter);
            for(int i = 0; i < prices.size(); i++){
                total += prices.get(i);
            }
            TextView totalcost = (TextView) findViewById(R.id.totalcost);
            totalcost.setText(String.format("%.2f", total));
        }
        Button AddSubBtn = (Button) findViewById(R.id.AddSubBtn);
        AddSubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AddSubIntent = new Intent(getApplicationContext(), AddSub.class);
                startActivityForResult(AddSubIntent, 1);
            }
        });

        view_subs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent OtherTasksIntent = new Intent(getApplicationContext(), OtherSubTasks.class);
                OtherTasksIntent.putExtra("SubtoEdit", sublist.get(position));
                OtherTasksIntent.putExtra("arrayPosition", position);
                OtherTasksIntent.putExtra("SubName", names.get(position));
                OtherTasksIntent.putExtra("SubDate", dates.get(position));
                OtherTasksIntent.putExtra("SubCharge", prices.get(position));
                OtherTasksIntent.putExtra("SubComment", comments.get(position));
                startActivityForResult(OtherTasksIntent, 2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Subscription sub = (Subscription)data.getSerializableExtra("newSub");

                sublist.add(sub);
                names.add(sub.getName());
                dates.add(sub.getDate());

                prices.add(sub.getMonthlycharge());
                total += (sub.getMonthlycharge());
                TextView totalcost = (TextView) findViewById(R.id.totalcost);
                totalcost.setText(String.format("%.2f", total));
                comments.add(sub.getComment());

                SubAdapter subAdapter = new SubAdapter(this, names, dates, prices, comments);
                view_subs.setAdapter(subAdapter);
                saveInFile();
            }
        }
        if (requestCode == 2) {
            if (resultCode == 10) {
                Subscription sub = (Subscription)data.getSerializableExtra("editedSub");
                int pos = data.getIntExtra("ArrayPos", -1);

                sublist.set(pos, sub);
                names.set(pos, sub.getName());
                dates.set(pos, sub.getDate());
                total -= prices.get(pos);
                prices.set(pos, (sub.getMonthlycharge()));
                total += prices.get(pos);
                TextView totalcost = (TextView) findViewById(R.id.totalcost);
                totalcost.setText(String.format("%.2f", total));
                comments.set(pos, sub.getComment());
                SubAdapter subAdapter = new SubAdapter(this, names, dates, prices, comments);
                view_subs.setAdapter(subAdapter);
                saveInFile();

            } else if (resultCode == 20) {
                int pos = data.getIntExtra("ArrayPos", -1);
                sublist.remove(pos);
                names.remove(pos);
                dates.remove(pos);
                total -= prices.get(pos);
                TextView totalcost = (TextView) findViewById(R.id.totalcost);
                totalcost.setText(String.format("%.2f", total));
                prices.remove(pos);
                comments.remove(pos);
                SubAdapter subAdapter = new SubAdapter(this, names, dates, prices, comments);
                view_subs.setAdapter(subAdapter);
                saveInFile();
            }
        }
    }

    private void loadFromFile(){
        try{
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            Type listType = new TypeToken<ArrayList<Subscription>>(){}.getType();

            sublist = gson.fromJson(in, listType);
            for(int i = 0; i < sublist.size(); i++){
                Subscription sub = sublist.get(i);
                names.add(sub.getName());
                dates.add(sub.getDate());
                prices.add(sub.getMonthlycharge());
                comments.add(sub.getComment());
            }


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            sublist = new ArrayList<>();
            names = new ArrayList<>();
            dates = new ArrayList<>();
            prices = new ArrayList<>();
            comments = new ArrayList<>();
            e.printStackTrace();
        }
    }


    private void saveInFile() {
        try{
            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();

            gson.toJson(sublist, out);

            out.flush();

        } catch (FileNotFoundException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.i("In Destroy method","The app is closing");
    }
}



