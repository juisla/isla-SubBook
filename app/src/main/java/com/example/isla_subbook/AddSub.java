package com.example.isla_subbook;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * AddSub class used to handle a button press from SubBook
 * Edittexts to fill in fields of information to display in SubBook
 * create new Subscription object with the information entered
 * then pass intents back with result from activity
 */

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
                /*
                 * referenced https://stackoverflow.com/questions/2736389/how-to-pass-an-object-from-one-activity-to-another-on-android
                 * to pass object of custom class through intent
                 */
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