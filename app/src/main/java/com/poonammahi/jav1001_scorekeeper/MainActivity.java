package com.poonammahi.jav1001_scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    //integer which keep track of which radiobutton is selected i.e. 1,2,4 or 6
    //by default radiobutton 1 will be selected
    int choosedScore=1;
    //following variables are by default 0 and will keep track of total scores of both teams respectively
    int totalScoreteam1=0;
    int totalScoreteam2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declare the views
        //for the buttons
        Button team1IncreaseButton=findViewById(R.id.add_team1);
        Button team1DecreaseButton=findViewById(R.id.sub_team1);
        Button team2IncreaseButton=findViewById(R.id.add_team2);
        Button team2DecreaseButton=findViewById(R.id.sub_team2);
        //for radiogroup
        RadioGroup increaseScoreBy=findViewById(R.id.increaseScoreBy);

        //have the view listen for an event
        //onClick for the buttons
        team1IncreaseButton.setOnClickListener(this); //this (activity/class) needs to implement the listener
        team1DecreaseButton.setOnClickListener(this);
        team2IncreaseButton.setOnClickListener(this);
        team2DecreaseButton.setOnClickListener(this);

        //onChecked for the radiogroup
        increaseScoreBy.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View view) {

        TextView displayScore_team1=findViewById(R.id.displayScore_team1); //creating object of textview(team1)
        String team1ScoreString=String.valueOf(displayScore_team1.getText()); //getting value of textview and making sure its string
        totalScoreteam1=Integer.parseInt(team1ScoreString); //converting value in textview to int so that we can perform add/sub operation

        TextView displayScore_team2=findViewById(R.id.displayScore_team2); //creating object of textview(team2)
        String team2ScoreString=String.valueOf(displayScore_team2.getText()); //getting value of textview and making sure its string
        totalScoreteam2=Integer.parseInt(team2ScoreString); //converting value in textview to int so that we can perform add/sub operation

        //using swtich case to perform add or sub operation on click of button
        switch(view.getId()){
            case R.id.add_team1:  //onclick of add button of team1
                totalScoreteam1 += choosedScore;  //adding select value from the radiobutton to the final score
                break;
            case R.id.sub_team1: //onclick of sub button of team1
                totalScoreteam1 -= choosedScore;  //subtracting select value from the radiobutton to the final score
                break;
            case R.id.add_team2: //onclick of add button of team2
                totalScoreteam2 += choosedScore; //adding select value from the radiobutton to the final score
                break;
            case R.id.sub_team2: //onclick of sub button of team1
                totalScoreteam2 -= choosedScore; //subtracting select value from the radiobutton to the final score
                break;
        }
        if(totalScoreteam1<=0)  //if the score is less than 0
        {
            totalScoreteam1=0; //set it to 0
        }
        if(totalScoreteam2<=0)
        {
            totalScoreteam2=0;
        }
        displayScore_team1.setText(String.valueOf(totalScoreteam1)); //display the score(resulted value) in textview for team1
        displayScore_team2.setText(String.valueOf(totalScoreteam2)); //display the score(resulted value) in textview for team2
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        int checkedButton=radioGroup.getCheckedRadioButtonId();

        //switch statement get the value of which radiobutton is checked 
        switch(checkedId){
            case R.id.score1:
                choosedScore=1;
                break;
            case R.id.score2:
                choosedScore=2;
                break;
            case R.id.score3:
                choosedScore=4;
                break;
            case R.id.score4:
                choosedScore=6;
                break;
        }
    }

}