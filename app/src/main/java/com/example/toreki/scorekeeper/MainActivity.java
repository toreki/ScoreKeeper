package com.example.toreki.scorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TEAM_A_NAME = "com.example.toreki.scorekeeper.TEAM_A_NAME";
    public static final String TEAM_B_NAME = "com.example.toreki.scorekeeper.TEAM_B_NAME";

    String team_a_name = "";
    String team_b_name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();
        team_a_name = i.getStringExtra(MainActivity.TEAM_A_NAME);
        team_b_name = i.getStringExtra(MainActivity.TEAM_B_NAME);


        TextView setNameTeamA = (TextView) findViewById(R.id.edit_team_a_name);
        setNameTeamA.setText(team_a_name);

        TextView setNameTeamB = (TextView) findViewById(R.id.edit_team_b_name);
        setNameTeamB.setText(team_b_name);

        /**
         *  TODO back button clear goals and offsides, add all data to intent
         */
    }

    /**
     * call MatchActivity
    */
    public void goMatch(View view) {


        EditText editTextNameA = (EditText) findViewById(R.id.edit_team_a_name);
        String team_a_name = editTextNameA.getText().toString();
        EditText editTextNameB = (EditText) findViewById(R.id.edit_team_b_name);
        String team_b_name = editTextNameB.getText().toString();


        if ( (team_a_name.length() < 1 ) || (team_b_name.length() < 1) ) {
            Log.v("MainActivity", "goMatch some team name is null");
            Toast.makeText(this, getString(R.string.no_team_name), Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        else
        {
            Intent i = new Intent(this, MatchActivity.class);

            i.putExtra(TEAM_A_NAME, team_a_name);

            i.putExtra(TEAM_B_NAME, team_b_name);

            Log.v("MainActivity", "goMatch: " + team_a_name + " " + team_b_name);

            startActivity(i);
        }



    }
}
