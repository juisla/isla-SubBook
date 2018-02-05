package com.example.isla_subbook;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AddSub extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sub);

        Button confirmAddBtn = (Button) findViewById(R.id.confirmAddBtn);
        final EditText nameText = (EditText) findViewById(R.id.nameEntry);
        final EditText dateText = (EditText) findViewById(R.id.dateEntry);
        final EditText monthlychargeText = (EditText) findViewById(R.id.monthlychargeEntry);
        final EditText commentText = (EditText) findViewById(R.id.commentEntry);


        confirmAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameText.getText().toString();
                String date = dateText.getText().toString();
                Double monthlycharge = Double.valueOf(monthlychargeText.getText().toString());
                String comment = commentText.getText().toString();

                Subscription sub = new Subscription(name, date, monthlycharge, comment);

                Intent intent = new Intent();
                intent.putExtra("newSub", sub);
                intent.putExtra("newName", sub.getName());
                intent.putExtra("newDate", sub.getDate());
                intent.putExtra("newMonthlycharge", sub.getMonthlycharge());
                intent.putExtra("newComment", sub.getComment());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }

}











 /*
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

    */