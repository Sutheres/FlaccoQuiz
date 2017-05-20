package com.example.android.flaccoquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean isQuestionOneCorrect;
    boolean isQuestionTwoCorrect;
    boolean isQuestionThreeCorrect;
    boolean isQuestionFourCorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }




    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean radioButtonChecked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.flacco:
                if (radioButtonChecked)
                    isQuestionOneCorrect = true;
                    break;
            case R.id.luck:
                if (radioButtonChecked)
                    isQuestionOneCorrect = false;
                    break;
            case R.id.aRod:
                if (radioButtonChecked)
                    isQuestionOneCorrect = false;
                    break;
            case R.id.marino:
                if (radioButtonChecked)
                    isQuestionOneCorrect = false;
                break;
        }
    }


    public void onCheckboxClicked(View view) {
        CheckBox bradyCheckbox = (CheckBox)findViewById(R.id.brady_checkbox);
        CheckBox warnerCheckbox = (CheckBox)findViewById(R.id.warner_checkbox);
        CheckBox montanaCheckbox = (CheckBox)findViewById(R.id.montana_checkbox);
        CheckBox flaccoCheckbox = (CheckBox)findViewById(R.id.flacco_checkbox);

         if (warnerCheckbox.isChecked() && montanaCheckbox.isChecked() && flaccoCheckbox.isChecked() && !bradyCheckbox.isChecked()) {
            isQuestionTwoCorrect = true;
        } else {
             isQuestionTwoCorrect = false;
         }
    }




    public void gradeQuiz(View view) {

        int numScore = 0;

        if (isQuestionOneCorrect){
            numScore = numScore + 1;
        }

        if (isQuestionTwoCorrect) {
            numScore = numScore + 1;
        }

        final EditText mvpField = (EditText) findViewById(R.id.sbmvp_field);
        if(mvpField.getText().toString().equals("Joe Flacco") || mvpField.getText().toString().equals("joe flacco") || mvpField.getText().toString().equals("Flacco") || mvpField.getText().toString().equals("flacco")) {
            isQuestionThreeCorrect = true;
        } else {
            isQuestionThreeCorrect = false;
        }





        if (isQuestionThreeCorrect) {
            numScore = numScore + 1;
        }


        final EditText draftedField = (EditText) findViewById(R.id.draft_field);
        if(draftedField.getText().toString().equals("Ravens") || draftedField.getText().toString().equals("ravens")) {
            isQuestionFourCorrect = true;
        } else {
            isQuestionFourCorrect = false;
        }


        if (isQuestionFourCorrect) {
            numScore = numScore + 1;
        }






        Toast.makeText(this,"Quiz score: " + Integer.toString(numScore) + "/4", Toast.LENGTH_SHORT).show();
    }

}
