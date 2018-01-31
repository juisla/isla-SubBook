package com.example.isla_subbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class SubBook extends AppCompatActivity {

    private static final String FILENAME = "newfile.sav";
    private ListView oldSubList;

    public ArrayList<Subscription> sublist = new ArrayList<Subscription>();
    public ArrayAdapter<Subscription> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_book);


        oldSubList = (ListView) findViewById(R.id.oldsublist);
        final Button AddSubBtn = (Button) findViewById(R.id.AddSubBtn);
        AddSubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /// add new subscription entry
                /// new activity
                Intent AddSubIntent = new Intent(getApplicationContext(),AddSub.class);
                AddSubIntent.putExtra("sublist", sublist);
                startActivity(AddSubIntent);
                adapter.notifyDataSetChanged();
            }
        });

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

    }
}
