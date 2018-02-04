package com.example.isla_subbook;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SubBook extends AppCompatActivity {

    private static final String FILENAME = "newfile.sav";
    ListView view_subs;

    ///private ArrayList<String> sublist = new ArrayList<>();
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> dates = new ArrayList<>();
    private ArrayList<String> prices = new ArrayList<>();
    private ArrayList<String> comments = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_book);

        ListView view_subs = findViewById(R.id.oldsublist);
        Button AddSubBtn = (Button) findViewById(R.id.AddSubBtn);
        AddSubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /// add new subscription entry
                /// new activity
                Intent AddSubIntent = new Intent(getApplicationContext(),AddSub.class);
                startActivityForResult(AddSubIntent, 1);
            }
        });

        view_subs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent OtherTasksIntent = new Intent(getApplicationContext(), OtherSubTasks.class);
                OtherTasksIntent.putExtra("arrayPosition", position);
                OtherTasksIntent.putExtra("SubName", names.get(position));
                OtherTasksIntent.putExtra("SubDate", dates.get(position));
                OtherTasksIntent.putExtra("SubCharge", prices.get(position));
                OtherTasksIntent.putExtra("SubComment", comments.get(position));
                startActivityForResult(OtherTasksIntent, 2);
                ///startActivityForResult(OtherTasksIntent, 2);
            }
        });

        /*
        Button EditSubBtn = (Button) findViewById(R.id.EditSubBtn);
        EditSubBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                /// edit existing subscription
                /// new activity
            }
        });

        Button DeleteSubBtn = (Button) findViewById(R.id.DeleteSubBtn);
        DeleteSubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /// delete existing subscription
                /// new activity
            }
        });

    */
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        ListView view_subs = findViewById(R.id.oldsublist);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String name = data.getStringExtra("newName");
                String date = data.getStringExtra("newDate");
                String monthlycharge = data.getStringExtra("newMonthlycharge");
                String comment = data.getStringExtra("newComment");
                String newvalue = name + "\nDate Subscription started: " + date + "\nMonthly Charge: " + monthlycharge + "\n" + comment;
                names.add(name);
                dates.add(date);
                prices.add(monthlycharge);
                comments.add(comment);
                SubAdapter subAdapter = new SubAdapter(this, names, dates, prices, comments);
                view_subs.setAdapter(subAdapter);
                ///sublist.add(newvalue);
                ///adapter = new ArrayAdapter<>(SubBook.this, R.layout.sub_list, sublist);
                ///view_subs.setAdapter(adapter);
            }
        }
        if (requestCode == 2){
            if (resultCode == 10) {
                int pos = data.getIntExtra("ArrayPos", -1);
                String name = data.getStringExtra("editedName");
                String date = data.getStringExtra("editedDate");
                String monthlycharge = data.getStringExtra("editedMonthlycharge");
                String comment = data.getStringExtra("editedComment");
                names.set(pos, name);
                dates.set(pos, date);
                prices.set(pos, monthlycharge);
                comments.set(pos, comment);
                SubAdapter subAdapter = new SubAdapter(this, names, dates, prices, comments);
                view_subs.setAdapter(subAdapter);
            }
            else if (resultCode == 20){
                int pos = data.getIntExtra("ArrayPos", -1);
                names.remove(pos);
                dates.remove(pos);
                prices.remove(pos);
                comments.remove(pos);
                SubAdapter subAdapter = new SubAdapter(this, names, dates, prices, comments);
                view_subs.setAdapter(subAdapter);
            }
        }
    }

}
