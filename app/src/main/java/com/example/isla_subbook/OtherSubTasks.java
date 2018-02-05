package com.example.isla_subbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * OtherSubTasks class used to handle a list item click from SubBook
 * takes position value to modify arraylists at the position of the item
 * that was clicked
 * display the values of clicked item to view details of subscription
 * then take any changes and pass them back to SubBook to be modified
 */

public class OtherSubTasks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_sub_tasks);

        final int position = getIntent().getIntExtra("arrayPosition", -1);
        final Subscription sub = (Subscription)getIntent().getSerializableExtra("SubtoEdit") ;
        String subName = getIntent().getExtras().getString("SubName");
        String subDate = getIntent().getExtras().getString("SubDate");
        Double subCharge = getIntent().getExtras().getDouble("SubCharge");
        String subComment = getIntent().getExtras().getString("SubComment");

        final EditText editName = (EditText) findViewById(R.id.editName);
        final EditText editDate = (EditText) findViewById(R.id.editDate);
        final EditText editMonthlycharge = (EditText) findViewById(R.id.editMonthlycharge);
        final EditText editComment = (EditText) findViewById(R.id.editComment);

        editName.setText(subName);
        editDate.setText(subDate);
        editMonthlycharge.setText(String.format("%.2f", subCharge));
        editComment.setText(subComment);

        /*
         * Edit Subscription Button
         * takes the values currently in the EditText's
         * and passes them through intents back to SubBook with activity result 10
         * and a position value to edit arrayLists at position
         */

        Button EditBtn = (Button) findViewById(R.id.EditSubBtn);
        EditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sub.setName(editName.getText().toString());
                sub.setDate(editDate.getText().toString());
                sub.setMonthlycharge(Double.valueOf(editMonthlycharge.getText().toString()));
                sub.setComment(editComment.getText().toString());

                Intent intent = new Intent();
                intent.putExtra("editedSub", sub);
                intent.putExtra("ArrayPos", position);
                intent.putExtra("editedName", sub.getName());
                intent.putExtra("editedDate", sub.getDate());
                intent.putExtra("editedMonthlycharge", sub.getMonthlycharge());
                intent.putExtra("editedComment", sub.getComment());
                setResult(10, intent);
                finish();

            }
        });

        /*
         * Delete Subscription Button
         * returns position to SubBook so it can delete values at position
         * in the arraylists
         * returns activity result 20
         */

        Button DeleteBtn = (Button) findViewById(R.id.DeleteSubBtn);
        DeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent();
                intent.putExtra("ArrayPos", position);
                setResult(20, intent);
                finish();
            }
        });

    }
}
