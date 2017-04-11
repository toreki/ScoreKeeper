package com.example.toreki.scorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MatchActivity extends AppCompatActivity {

    String team_a_name = "";
    String team_b_name = "";

    //count goals for teams
    int goalTeamA = 0;
    int goalTeamB = 0;

    //count offsides for teams
    int offsideTeamA = 0;
    int offsideTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        if( savedInstanceState != null ) {
            goalTeamA = savedInstanceState.getInt( "goalTeamA" );
            goalTeamB = savedInstanceState.getInt( "goalTeamB" );
            offsideTeamA = savedInstanceState.getInt( "offsideTeamA" );
            offsideTeamB = savedInstanceState.getInt( "offsideTeamB" );
        }

        // Get the Intent that started this activity and extract the string
        Intent i = getIntent();
        team_a_name = i.getStringExtra(MainActivity.TEAM_A_NAME);
        team_b_name = i.getStringExtra(MainActivity.TEAM_B_NAME);

        TextView setNameTeamA = (TextView) findViewById(R.id.team_a_name);
        setNameTeamA.setText(team_a_name);

        TextView setNameTeamB = (TextView) findViewById(R.id.team_b_name);
        setNameTeamB.setText(team_b_name);

        Log.v("MatchActivity", "onCreate: "+ team_a_name + " " + team_b_name);

        displayForTeamA();
        displayForTeamB();

    }

    @Override
    protected void onSaveInstanceState( Bundle outPut ) {
        outPut.putInt( "goalTeamA", goalTeamA );
        outPut.putInt( "goalTeamB", goalTeamB );
        outPut.putInt( "offsideTeamA", offsideTeamA );
        outPut.putInt( "offsideTeamB", offsideTeamB );
        super.onSaveInstanceState( outPut );
    }

    /**
     *  call MainActivity
     */
    public void goMain(View view) {
        Log.v("MatchActivity", "goMain");
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra(MainActivity.TEAM_A_NAME, team_a_name);
        i.putExtra(MainActivity.TEAM_B_NAME, team_b_name);
        startActivity(i);
    }

    /**
     * Increase goals Team A
     */
    public void addGoalA(View view) {
        goalTeamA = goalTeamA + 1;
        Log.v("MatchActivity", "addGoalA: "+ goalTeamA);
        displayForTeamA();

    }

    /**
     * Increase offside Team A
     */
    public void addOffsideA(View view) {
        offsideTeamA = offsideTeamA + 1;
        Log.v("MatchActivity", "addOffsideA: "+ offsideTeamA);
        displayForTeamA();
    }

    /**
     * Display goals for Team A
     */
    public void displayForTeamA() {
        Log.v("MatchActivity", "displayForTeamA");
        TextView setGoalTeamA = (TextView) findViewById(R.id.team_a_goal);
        setGoalTeamA.setText(String.valueOf(goalTeamA));

        TextView setOffsideTeamA = (TextView) findViewById(R.id.team_a_offside);
        String offsideString = getString(R.string.team_a_offside_data, offsideTeamA );
        setOffsideTeamA.setText(String.valueOf(offsideString));
    }

    /**
     * Increase goals Team B
     */
    public void addGoalB(View view) {
        goalTeamB = goalTeamB + 1;
        Log.v("MatchActivity", "addGoalB: "+ goalTeamB);
        displayForTeamB();
    }

    /**
     * Increase offside Team B
     */
    public void addOffsideB(View view) {
        offsideTeamB = offsideTeamB + 1;
        Log.v("MatchActivity", "addOffsideB: "+ offsideTeamB);
        displayForTeamB();
    }

    /**
     * Display goals for Team B
     */
    public void displayForTeamB() {
        Log.v("MatchActivity", "displayForTeamB");
        TextView setGoalTeamB = (TextView) findViewById(R.id.team_b_goal);
        setGoalTeamB.setText(String.valueOf(goalTeamB));

        TextView setOffsideTeamB = (TextView) findViewById(R.id.team_b_offside);
        String offsideString = getString(R.string.team_b_offside_data, offsideTeamB );
        setOffsideTeamB.setText(String.valueOf(offsideString));
    };

    /**
     * Reset all teams score
     */
    public void resetScore(View view) {
        Log.v("MatchActivity", "resetScore");
        goalTeamA = 0;
        goalTeamB = 0;
        offsideTeamA = 0;
        offsideTeamB = 0;
        displayForTeamA();
        displayForTeamB();
    }

}
