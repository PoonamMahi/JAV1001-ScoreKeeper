package com.poonammahi.jav1001_scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private int choosedScore;
    //private int totalScoreteam1=0;
    //private int totalScoreteam2=0;
    private RadioGroup increaseScoreBy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declare the views
        Button team1IncreaseButton=findViewById(R.id.add_team1);
        Button team1DecreaseButton=findViewById(R.id.sub_team1);
        Button team2IncreaseButton=findViewById(R.id.add_team2);
        Button team2DecreaseButton=findViewById(R.id.sub_team2);

       increaseScoreBy=findViewById(R.id.increaseScoreBy);

        //have the view listen for an event
        //onClick for the buttons
        team1IncreaseButton.setOnClickListener(this); //this (activity/class) needs to implement the listener
        team1DecreaseButton.setOnClickListener(this);
        team2IncreaseButton.setOnClickListener(this);
        team2DecreaseButton.setOnClickListener(this);

        increaseScoreBy.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        TextView displayScore_team1=findViewById(R.id.displayScore_team1);
        String team1ScoreString=String.valueOf(displayScore_team1.getText());
        int team1FinalScore=Integer.parseInt(team1ScoreString);

        TextView displayScore_team2=findViewById(R.id.displayScore_team2);
        String team2ScoreString=String.valueOf(displayScore_team2.getText());
        int team2FinalScore=Integer.parseInt(team2ScoreString);

        switch(view.getId()){
            case R.id.add_team1:
                team1FinalScore += choosedScore;
                break;
            case R.id.sub_team1:
                team1FinalScore -= choosedScore;
                break;
            case R.id.add_team2:
                team2FinalScore += choosedScore;
                break;
            case R.id.sub_team2:
                team2FinalScore -= choosedScore;
                break;
        }

        displayScore_team1.setText(String.valueOf(team1FinalScore));
        displayScore_team2.setText(String.valueOf(team2FinalScore));
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        int checkedButton=increaseScoreBy.getCheckedRadioButtonId();
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