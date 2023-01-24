package com.example.actualscoutingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class EndScreen extends AppCompatActivity {

// MORE IN DEPTH COMMENTS FOR REPEATED CODE IS ON AUTON SCREEN

    //creating variables for everything on the .xml file
    ImageButton autonBtn3, teleopBtn3, endgameBtn3, qrcodeBtn3;
    TextView autonTitleTxt3, teleopTitleTxt3, endgameTitleTxt3, qrcodeTitleTxt3, endgameTitleTxt, matchNumTitle3, teamNumTitle3, endgameMatchInfoBack, scoringTitleTxt3, upperTitleTxt3, middleTitleTxt3, lowerTitleTxt3, loadsTitleTxt3, dockingTitleTxt3;
    ImageView endgameScreenBackground, endgameHomeBtnPic, endgameTitleUnderline, matchNumBack3, teamNumBack3, upperPlus3, upperMinus3, middlePlus3, middleMinus3, lowerPlus3, lowerMinus3;
    EditText matchNumInput3, teamNumInput3, upperInput3, middleInput3, lowerInput3;
    CheckBox groundCheck3, humanCheck3;
    RadioGroup docking3;
    RadioButton noAttemptOption3, attemptNoEngageOption3, engagedOption3;
    SharedPreferences sp;
    String teamNumberInputString, matchNumberInputString, endgameUpperInputScoreString, endgameMiddleInputScoreString, endgameLowerInputScoreString;
    Boolean endgameGroundLoadsBoolean, endgameHumanLoadsBoolean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);


        //get rid of action bar when running the app
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        //matching the variables created to the ids on the .xml files
        autonBtn3 = findViewById(R.id.autonUnclicked3);
        teleopBtn3 = findViewById(R.id.teleopUnclicked3);
        endgameBtn3 = findViewById(R.id.endgameClicked3);
        qrcodeBtn3 = findViewById(R.id.qrcodeUnclicked3);

        autonTitleTxt3 = findViewById(R.id.autonTitleText3);
        teleopTitleTxt3 = findViewById(R.id.teleopTitleText3);
        endgameTitleTxt3 = findViewById(R.id.endgameTitleText3);
        qrcodeTitleTxt3 = findViewById(R.id.qrcodeTitleText3);
        endgameTitleTxt = findViewById(R.id.endgameScreenTitle);
        matchNumTitle3 = findViewById(R.id.endgameMatchNumberTitle);
        teamNumTitle3 = findViewById(R.id.endgameTeamNumberTitle);
        endgameMatchInfoBack = findViewById(R.id.endgameInputBack);
        scoringTitleTxt3 = findViewById(R.id.endgameScoringTitle);
        upperTitleTxt3 = findViewById(R.id.endgameUpperTitle);
        middleTitleTxt3 = findViewById(R.id.endgameMiddleTitle);
        lowerTitleTxt3 = findViewById(R.id.endgameLowerTitle);
        loadsTitleTxt3 = findViewById(R.id.endgameLoadsTitle);
        dockingTitleTxt3 = findViewById(R.id.endgameDockingTitle);

        endgameScreenBackground = findViewById(R.id.endgameBackground);
        endgameHomeBtnPic = findViewById(R.id.endgameHome);
        endgameTitleUnderline = findViewById(R.id.endgameScreenTitleUnderline);
        matchNumBack3 = findViewById(R.id.endgameMatchNumBack);
        teamNumBack3 = findViewById(R.id.endgameTeamNumBack);
        upperPlus3 = findViewById(R.id.endgameUpperPlus);
        upperMinus3 = findViewById(R.id.endgameUpperMinus);
        middlePlus3 = findViewById(R.id.endgameMiddlePlus);
        middleMinus3 = findViewById(R.id.endgameMiddleMinus);
        lowerPlus3 = findViewById(R.id.endgameLowerPlus);
        lowerMinus3 = findViewById(R.id.endgameLowerMinus);

        matchNumInput3 = findViewById(R.id.endgameMatchNumInput);
        teamNumInput3 = findViewById(R.id.endgameTeamNumInput);
        upperInput3 = findViewById(R.id.endgameUpperInput);
        middleInput3 = findViewById(R.id.endgameMiddleInput);
        lowerInput3 = findViewById(R.id.endgameLowerInput);

        groundCheck3 = findViewById(R.id.endgameGroundCheck);
        humanCheck3 = findViewById(R.id.endgameHumanCheck);

        docking3 = findViewById(R.id.endgameDockingOptions);

        noAttemptOption3 = findViewById(R.id.endgameNoAttempt);
        attemptNoEngageOption3 = findViewById(R.id.endgameDockedNotEngagedOption);
        engagedOption3 = findViewById(R.id.endgameDockedEngagedOption);


        //getting shared preferences
        sp = getSharedPreferences("TeamData", MODE_PRIVATE);

        //when the screen is changed to the auton screen if there was any text or checks already inputed then they will replace the otherwise blank inputs
        SharedPreferences new_sp = getApplicationContext().getSharedPreferences("TeamData", MODE_PRIVATE);
        teamNumInput3.setText(new_sp.getString("TeamNumber", ""));
        matchNumInput3.setText(new_sp.getString("MatchNumber", ""));
        upperInput3.setText(new_sp.getString("EndgameUpperScore", ""));
        middleInput3.setText(new_sp.getString("EndgameMiddleScore", ""));
        lowerInput3.setText(new_sp.getString("EndgameLowerScore", ""));
        groundCheck3.setChecked(new_sp.getBoolean("EndgameGroundCheck", false));
        humanCheck3.setChecked(new_sp.getBoolean("EndgameHumanCheck", false));



        //creating on click events

        //screen changing buttons
        endgameHomeBtnPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences
                teamNumberInputString = teamNumInput3.getText().toString();
                matchNumberInputString = matchNumInput3.getText().toString();
                endgameUpperInputScoreString = upperInput3.getText().toString();
                endgameMiddleInputScoreString = middleInput3.getText().toString();
                endgameLowerInputScoreString = lowerInput3.getText().toString();
                if (groundCheck3.isChecked()) {
                    endgameGroundLoadsBoolean = true;
                }
                else {
                    endgameGroundLoadsBoolean = false;
                }
                if (humanCheck3.isChecked()) {
                    endgameHumanLoadsBoolean  = true;
                }
                else {
                    endgameHumanLoadsBoolean = false;
                }
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putString("MatchNumber", matchNumberInputString);
                editor.putString("EndgameUpperScore", endgameUpperInputScoreString);
                editor.putString("EndgameMiddleScore", endgameMiddleInputScoreString);
                editor.putString("EndgameLowerScore", endgameLowerInputScoreString);
                editor.putBoolean("EndgameGroundCheck", endgameGroundLoadsBoolean);
                editor.putBoolean("EndgameHumanCheck", endgameHumanLoadsBoolean);
                editor.commit();

                //screen will be changed to the home screen
                Intent goToHomeScreen = new Intent(EndScreen.this, MainActivity.class);
                startActivity(goToHomeScreen);
            }
        });
        autonBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences
                teamNumberInputString = teamNumInput3.getText().toString();
                matchNumberInputString = matchNumInput3.getText().toString();
                endgameUpperInputScoreString = upperInput3.getText().toString();
                endgameMiddleInputScoreString = middleInput3.getText().toString();
                endgameLowerInputScoreString = lowerInput3.getText().toString();
                if (groundCheck3.isChecked()) {
                    endgameGroundLoadsBoolean = true;
                }
                else {
                    endgameGroundLoadsBoolean = false;
                }
                if (humanCheck3.isChecked()) {
                    endgameHumanLoadsBoolean  = true;
                }
                else {
                    endgameHumanLoadsBoolean = false;
                }
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putString("MatchNumber", matchNumberInputString);
                editor.putString("EndgameUpperScore", endgameUpperInputScoreString);
                editor.putString("EndgameMiddleScore", endgameMiddleInputScoreString);
                editor.putString("EndgameLowerScore", endgameLowerInputScoreString);
                editor.putBoolean("EndgameGroundCheck", endgameGroundLoadsBoolean);
                editor.putBoolean("EndgameHumanCheck", endgameHumanLoadsBoolean);
                editor.commit();

                //screen will be changed to auton screen
                Intent goToAutonScreen = new Intent(EndScreen.this, AutonScreen.class);
                startActivity(goToAutonScreen);
            }
        });
        teleopBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences
                teamNumberInputString = teamNumInput3.getText().toString();
                matchNumberInputString = matchNumInput3.getText().toString();
                endgameUpperInputScoreString = upperInput3.getText().toString();
                endgameMiddleInputScoreString = middleInput3.getText().toString();
                endgameLowerInputScoreString = lowerInput3.getText().toString();
                if (groundCheck3.isChecked()) {
                    endgameGroundLoadsBoolean = true;
                }
                else {
                    endgameGroundLoadsBoolean = false;
                }
                if (humanCheck3.isChecked()) {
                    endgameHumanLoadsBoolean  = true;
                }
                else {
                    endgameHumanLoadsBoolean = false;
                }
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putString("MatchNumber", matchNumberInputString);
                editor.putString("EndgameUpperScore", endgameUpperInputScoreString);
                editor.putString("EndgameMiddleScore", endgameMiddleInputScoreString);
                editor.putString("EndgameLowerScore", endgameLowerInputScoreString);
                editor.putBoolean("EndgameGroundCheck", endgameGroundLoadsBoolean);
                editor.putBoolean("EndgameHumanCheck", endgameHumanLoadsBoolean);
                editor.commit();

                //screen will be changed to teleop screen
                Intent goToTeleopScreen = new Intent(EndScreen.this, TeleopScreen.class);
                startActivity(goToTeleopScreen);
            }
        });
        qrcodeBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences
                teamNumberInputString = teamNumInput3.getText().toString();
                matchNumberInputString = matchNumInput3.getText().toString();
                endgameUpperInputScoreString = upperInput3.getText().toString();
                endgameMiddleInputScoreString = middleInput3.getText().toString();
                endgameLowerInputScoreString = lowerInput3.getText().toString();
                if (groundCheck3.isChecked()) {
                    endgameGroundLoadsBoolean = true;
                }
                else {
                    endgameGroundLoadsBoolean = false;
                }
                if (humanCheck3.isChecked()) {
                    endgameHumanLoadsBoolean  = true;
                }
                else {
                    endgameHumanLoadsBoolean = false;
                }
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putString("MatchNumber", matchNumberInputString);
                editor.putString("EndgameUpperScore", endgameUpperInputScoreString);
                editor.putString("EndgameMiddleScore", endgameMiddleInputScoreString);
                editor.putString("EndgameLowerScore", endgameLowerInputScoreString);
                editor.putBoolean("EndgameGroundCheck", endgameGroundLoadsBoolean);
                editor.putBoolean("EndgameHumanCheck", endgameHumanLoadsBoolean);
                editor.commit();

                //screen will be changed to qrcode screen
                Intent goToQrcodeScreen = new Intent(EndScreen.this, QRCommentsScreen.class);
                startActivity(goToQrcodeScreen);
            }
        });


        //score changing button on click methods
        upperPlus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int endgameUpperPiecesScored;

                if(upperInput3.getText().toString().equals("")) {
                    endgameUpperPiecesScored = 0;
                } else {
                    endgameUpperPiecesScored = Integer.parseInt(upperInput3.getText().toString());
                }
                if(endgameUpperPiecesScored >= 0) {
                    endgameUpperPiecesScored++;
                }
                String endgameUpperPiecesString = "" + endgameUpperPiecesScored;
                upperInput3.setText(endgameUpperPiecesString);
            }
        });

        upperMinus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int endgameUpperPiecesScored;
                if(upperInput3.getText().toString().equals("")) {
                    endgameUpperPiecesScored = 0;
                } else {
                    endgameUpperPiecesScored = Integer.parseInt(upperInput3.getText().toString());
                }
                if(endgameUpperPiecesScored > 0) {
                    endgameUpperPiecesScored--;
                }
                String endgameUpperPiecesString = "" + endgameUpperPiecesScored;
                upperInput3.setText(endgameUpperPiecesString);
            }
        });

        middlePlus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int endgameMiddlePiecesScored;

                if(middleInput3.getText().toString().equals("")) {
                    endgameMiddlePiecesScored = 0;
                } else {
                    endgameMiddlePiecesScored = Integer.parseInt(middleInput3.getText().toString());
                }
                if(endgameMiddlePiecesScored >= 0) {
                    endgameMiddlePiecesScored++;
                }
                String endgameMiddlePiecesString = "" + endgameMiddlePiecesScored;
                middleInput3.setText(endgameMiddlePiecesString);
            }
        });

        middleMinus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int endgameMiddlePiecesScored;
                if(middleInput3.getText().toString().equals("")) {
                    endgameMiddlePiecesScored = 0;
                } else {
                    endgameMiddlePiecesScored = Integer.parseInt(middleInput3.getText().toString());
                }
                if(endgameMiddlePiecesScored > 0) {
                    endgameMiddlePiecesScored--;
                }
                String endgameMiddlePiecesString = "" + endgameMiddlePiecesScored;
                middleInput3.setText(endgameMiddlePiecesString);
            }
        });

        lowerPlus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int endgameLowerPiecesScored;

                if(lowerInput3.getText().toString().equals("")) {
                    endgameLowerPiecesScored = 0;
                } else {
                    endgameLowerPiecesScored = Integer.parseInt(lowerInput3.getText().toString());
                }
                if(endgameLowerPiecesScored >= 0) {
                    endgameLowerPiecesScored++;
                }
                String endgameLowerPiecesString = "" + endgameLowerPiecesScored;
                lowerInput3.setText(endgameLowerPiecesString);
            }
        });

        lowerMinus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int endgameLowerPiecesScored;
                if(upperInput3.getText().toString().equals("")) {
                    endgameLowerPiecesScored = 0;
                } else {
                    endgameLowerPiecesScored = Integer.parseInt(lowerInput3.getText().toString());
                }
                if(endgameLowerPiecesScored > 0) {
                    endgameLowerPiecesScored--;
                }
                String endgameLowerPiecesString = "" + endgameLowerPiecesScored;
                lowerInput3.setText(endgameLowerPiecesString);
            }
        });
    }
}