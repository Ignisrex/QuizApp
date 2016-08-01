package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int score = 0;//Used to keep track of the number of correct answers

    /* In question one there are multiple right answer and as such I decided to award one point for each correct answer
        (this is indicated to the user via the instructions at the top).
        I chose to do this because based of rubric for the project which states radio buttons should be used
        for questions with one correct answer and checkboxes should be used with question with multiple it only seemed appropriate.
     */
    public void checkQuestion1(View view1, View view2,View view3, View view4) {
        if (!(((CheckBox) view3).isChecked() || ((CheckBox) view4).isChecked())) {
            if (((CheckBox) view1).isChecked()) {
                score = score + 1;
            }
            if (((CheckBox) view2).isChecked()) {
                score = score + 1;
            }
        }
    }
    public void checkQuestion2(String text){
        if(text.equalsIgnoreCase(getString(R.string.answer_q2))){
            score = score+1;
        }
    }

    public void checkQuestion3(View view){
        if(((RadioButton) view).isChecked()) {
            score = score + 1;
        }
    }

    public void checkQuestion4(View view){
        if(((RadioButton) view).isChecked()) {
            score = score + 1;
        }

    }

    public void checkQuestion5(int year){
        if(year == 2012){
            score =score+1;
        }
    }

    //Used to Tally and display results
     public void tallyScore(View view){
         checkQuestion1(findViewById(R.id.pulp_fiction),findViewById(R.id.reservoir_dogs),findViewById(R.id.fargo),findViewById(R.id.gone_girls));

        EditText q2Answer = (EditText) findViewById(R.id.question_2_answer);
         if (q2Answer != null ) {
             String text = q2Answer.getText().toString();
             checkQuestion2(text);
         }

         checkQuestion3(findViewById(R.id.question_3_answer));
         checkQuestion4(findViewById(R.id.question_4_answer));

         EditText q5Answer = (EditText) findViewById(R.id.question_5_answer);
         if(q5Answer != null && !TextUtils.isEmpty(q5Answer.getText())) {
           int year =  Integer.parseInt(q5Answer.getText().toString());
             checkQuestion5(year);
         }

         String message = getString(R.string.format_message, score, 6);
         Toast.makeText(MainActivity.this,message, Toast.LENGTH_LONG).show();
         score = 0;
     }
    //Got icon online. Author: Freepik.

}
