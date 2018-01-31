package com.example.isla_subbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class AddSub extends AppCompatActivity {

    private EditText nameText;
    private EditText dateText;
    private EditText monthlychargeText;
    private EditText commentText;

    public ArrayList<Subscription> sublist = (ArrayList<Subscription>) getIntent().getSerializableExtra("sublist");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sub);

        nameText = (EditText) findViewById(R.id.nameEntry);
        dateText = (EditText) findViewById(R.id.dateEntry);
        monthlychargeText = (EditText) findViewById(R.id.monthlychargeEntry);
        commentText = (EditText) findViewById(R.id.commentEntry);

        Button confirmAddBtn = (Button) findViewById(R.id.confirmAddBtn);
        confirmAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK);
                String name = nameText.getText().toString();

                String datestring = dateText.getText().toString();
                DateFormat dateformat = new SimpleDateFormat("YYYY/MM/dd", Locale.CANADA);
                Date date = null;
                try {
                    date = dateformat.parse(datestring);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                String monthlychargestring = monthlychargeText.getText().toString();
                Float monthlycharge = Float.valueOf(monthlychargestring);

                String comment = commentText.getText().toString();

                Subscription newsub = new Subscription(name, date, monthlycharge, comment);

                sublist.add(newsub);

            }
        });


    }
}
