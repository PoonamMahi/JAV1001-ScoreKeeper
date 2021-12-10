package com.poonammahi.jav1001_scorekeeper;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;


public class ScoreKeeperFragment extends Fragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private Button team1IncreaseButton, team1DecreaseButton, team2IncreaseButton, team2DecreaseButton;
    private RadioGroup increaseScoreBy;
    private TextView displayScore_team1;
    private TextView displayScore_team2;
    int choosedScore=1;
    //following variables are by default 0 and will keep track of total scores of both teams respectively
    int totalScoreteam1=0;
    int totalScoreteam2=0;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myLayout = inflater.inflate(R.layout.fragment_score_keeper, container, false);

        //declare the views
        //for the buttons
        team1IncreaseButton=myLayout.findViewById(R.id.add_team1);
        team1DecreaseButton=myLayout.findViewById(R.id.sub_team1);
        team2IncreaseButton=myLayout.findViewById(R.id.add_team2);
        team2DecreaseButton=myLayout.findViewById(R.id.sub_team2);
        //for radiogroup
       increaseScoreBy=myLayout.findViewById(R.id.increaseScoreBy);

        //have the view listen for an event
        //onClick for the buttons
        team1IncreaseButton.setOnClickListener(this); //this (activity/class) needs to implement the listener
        team1DecreaseButton.setOnClickListener(this);
        team2IncreaseButton.setOnClickListener(this);
        team2DecreaseButton.setOnClickListener(this);

        displayScore_team1=myLayout.findViewById(R.id.displayScore_team1); //creating object of textview(team1)
        displayScore_team2=myLayout.findViewById(R.id.displayScore_team2); //creating object of textview(team2)

        //onChecked for the radiogroup
        increaseScoreBy.setOnCheckedChangeListener(this);
        return myLayout;
    }


    @Override
    public void onClick(View view) {

        String team1ScoreString=String.valueOf(displayScore_team1.getText()); //getting value of textview and making sure its string
        totalScoreteam1=Integer.parseInt(team1ScoreString); //converting value in textview to int so that we can perform add/sub operation

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