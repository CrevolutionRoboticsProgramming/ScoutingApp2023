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

public class AutonScreen extends AppCompatActivity {

// MORE IN DEPTH COMMENTS FOR REPEATED CODE IS ON HERE IN AUTON SCREEN

    //creating variables for everything on the .xml file
    ImageButton autonBtn1, teleopBtn1, endgameBtn1, qrcodeBtn1;
    TextView autonTitleTxt1, teleopTitleTxt1, endgameTitleTxt1, qrcodeTitleTxt1, autonTitleTxt, matchNumTitle1, teamNumTitle1, autonMatchInfoBack, scoringTitleTxt1, upperTitleTxt1, middleTitleTxt1, lowerTitleTxt1, loadsTitleTxt1, dockingTitleTxt1;
    ImageView autonScreenBackground, autonHomeBtnPic, autonTitleUnderline, matchNumBack1, teamNumBack1, upperPlus1, upperMinus1, middlePlus1, middleMinus1, lowerPlus1, lowerMinus1;
    EditText matchNumInput1, teamNumInput1, upperInput1, middleInput1, lowerInput1;
    CheckBox groundCheck1, humanCheck1, mobilityPointCheck;
    RadioGroup docking1;
    RadioButton noAttemptOption1, attemptNoEngageOption1, engagedOption1;
    SharedPreferences sp;
    String teamNumberInputString, matchNumberInputString, autonUpperInputScoreString, autonMiddleInputScoreString, autonLowerInputScoreString;
    Boolean autonGroundLoadsBoolean, autonHumanLoadsBoolean, autonMobilityPointBoolean;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auton_screen);


        //get rid of action bar when running the app
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        //matching the variables created to the ids on the .xml files
        autonBtn1 = findViewById(R.id.autonClicked);
        teleopBtn1 = findViewById(R.id.teleopUnclicked);
        endgameBtn1 = findViewById(R.id.endgameUnclicked);
        qrcodeBtn1 = findViewById(R.id.qrcodeUnclicked);

        autonTitleTxt1 = findViewById(R.id.autonTitleText);
        teleopTitleTxt1 = findViewById(R.id.teleopTitleText);
        endgameTitleTxt1 = findViewById(R.id.endgameTitleText);
        qrcodeTitleTxt1 = findViewById(R.id.qrcodeTitleText);
        autonTitleTxt = findViewById(R.id.autonScreenTitle);
        matchNumTitle1 = findViewById(R.id.autonMatchNumberTitle);
        teamNumTitle1 = findViewById(R.id.autonTeamNumberTitle);
        autonMatchInfoBack = findViewById(R.id.autonInputBack);
        scoringTitleTxt1 = findViewById(R.id.autonScoringTitle);
        upperTitleTxt1 = findViewById(R.id.autonUpperTitle);
        middleTitleTxt1 = findViewById(R.id.autonMiddleTitle);
        lowerTitleTxt1 = findViewById(R.id.autonLowerTitle);
        loadsTitleTxt1 = findViewById(R.id.autonLoadsTitle);
        dockingTitleTxt1 = findViewById(R.id.autonDockingTitle);

        autonScreenBackground = findViewById(R.id.autonBackground);
        autonHomeBtnPic = findViewById(R.id.autonHome);
        autonTitleUnderline = findViewById(R.id.autonScreenTitleUnderline);
        matchNumBack1 = findViewById(R.id.autonMatchNumBack);
        teamNumBack1 = findViewById(R.id.autonTeamNumBack);
        upperPlus1 = findViewById(R.id.autonUpperPlus);
        upperMinus1 = findViewById(R.id.autonUpperMinus);
        middlePlus1 = findViewById(R.id.autonMiddlePlus);
        middleMinus1 = findViewById(R.id.autonMiddleMinus);
        lowerPlus1 = findViewById(R.id.autonLowerPlus);
        lowerMinus1 = findViewById(R.id.autonLowerMinus);

        matchNumInput1 = findViewById(R.id.autonMatchNumInput);
        teamNumInput1 = findViewById(R.id.autonTeamNumInput);
        upperInput1 = findViewById(R.id.autonUpperInput);
        middleInput1 = findViewById(R.id.autonMiddleInput);
        lowerInput1 = findViewById(R.id.autonLowerInput);

        groundCheck1 = findViewById(R.id.autonGroundCheck);
        humanCheck1 = findViewById(R.id.autonHumanCheck);
        mobilityPointCheck = findViewById(R.id.autonMobilityCheck);

        docking1 = findViewById(R.id.g);

        noAttemptOption1 = findViewById(R.id.ges);
        attemptNoEngageOption1 = findViewById(R.id.ws);
        engagedOption1 = findViewById(R.id.dj);

        //getting shared preferences
        sp = getSharedPreferences("TeamData", MODE_PRIVATE);

        //when the screen is changed to the auton screen if there was any text or checks already inputed then they will replace the otherwise blank inputs
        SharedPreferences new_sp = getApplicationContext().getSharedPreferences("TeamData", MODE_PRIVATE);
        teamNumInput1.setText(new_sp.getString("TeamNumber", ""));
        matchNumInput1.setText(new_sp.getString("MatchNumber", ""));
        upperInput1.setText(new_sp.getString("AutonUpperScore", ""));
        middleInput1.setText(new_sp.getString("AutonMiddleScore", ""));
        lowerInput1.setText(new_sp.getString("AutonLowerScore", ""));
        groundCheck1.setChecked(new_sp.getBoolean("AutonGroundCheck", false));
        humanCheck1.setChecked(new_sp.getBoolean("AutonHumanCheck", false));
        mobilityPointCheck.setChecked(new_sp.getBoolean("AutonMobilityCheck", false));


        //creating on click events

        //screen changing buttons
        autonHomeBtnPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences

                //making the inputs into a string for the sp
                teamNumberInputString = teamNumInput1.getText().toString();
                matchNumberInputString = matchNumInput1.getText().toString();
                autonUpperInputScoreString = upperInput1.getText().toString();
                autonMiddleInputScoreString = middleInput1.getText().toString();
                autonLowerInputScoreString = lowerInput1.getText().toString();
                //check box inputs turned into a boolean
                if (groundCheck1.isChecked()) {
                    autonGroundLoadsBoolean = true;
                }
                else {
                    autonGroundLoadsBoolean = false;
                }
                if (humanCheck1.isChecked()) {
                    autonHumanLoadsBoolean  = true;
                }
                else {
                    autonHumanLoadsBoolean = false;
                }
                if (mobilityPointCheck.isChecked()) {
                    autonMobilityPointBoolean  = true;
                }
                else {
                    autonMobilityPointBoolean = false;
                }
                //creating a editor for the sp and naming it editor
                SharedPreferences.Editor editor = sp.edit();
                //using the editor to store the strings and booleans in the sp (green) that can be called from other screens aswell
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putString("MatchNumber", matchNumberInputString);
                editor.putString("AutonUpperScore", autonUpperInputScoreString);
                editor.putString("AutonMiddleScore", autonMiddleInputScoreString);
                editor.putString("AutonLowerScore", autonLowerInputScoreString);
                editor.putBoolean("AutonGroundCheck", autonGroundLoadsBoolean);
                editor.putBoolean("AutonHumanCheck", autonHumanLoadsBoolean);
                editor.putBoolean("AutonMobilityCheck", autonMobilityPointBoolean);
                //updates all the sp
                editor.commit();

                //screen will be changed to the home screen
                Intent goToHomeScreen = new Intent(AutonScreen.this, MainActivity.class);
                startActivity(goToHomeScreen);
            }
        });
        teleopBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences
                teamNumberInputString = teamNumInput1.getText().toString();
                matchNumberInputString = matchNumInput1.getText().toString();
                autonUpperInputScoreString = upperInput1.getText().toString();
                autonMiddleInputScoreString = middleInput1.getText().toString();
                autonLowerInputScoreString = lowerInput1.getText().toString();
                if (groundCheck1.isChecked()) {
                    autonGroundLoadsBoolean = true;
                }
                else {
                    autonGroundLoadsBoolean = false;
                }
                if (humanCheck1.isChecked()) {
                    autonHumanLoadsBoolean  = true;
                }
                else {
                    autonHumanLoadsBoolean = false;
                }
                if (mobilityPointCheck.isChecked()) {
                    autonMobilityPointBoolean  = true;
                }
                else {
                    autonMobilityPointBoolean = false;
                }
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putString("MatchNumber", matchNumberInputString);
                editor.putString("AutonUpperScore", autonUpperInputScoreString);
                editor.putString("AutonMiddleScore", autonMiddleInputScoreString);
                editor.putString("AutonLowerScore", autonLowerInputScoreString);
                editor.putBoolean("AutonGroundCheck", autonGroundLoadsBoolean);
                editor.putBoolean("AutonHumanCheck", autonHumanLoadsBoolean);
                editor.putBoolean("AutonMobilityCheck", autonMobilityPointBoolean);
                editor.commit();

                //screen will be changed to the teloep screen
                Intent goToTeleopScreen = new Intent(AutonScreen.this, TeleopScreen.class);
                startActivity(goToTeleopScreen);
            }
        });
        endgameBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences
                teamNumberInputString = teamNumInput1.getText().toString();
                matchNumberInputString = matchNumInput1.getText().toString();
                autonUpperInputScoreString = upperInput1.getText().toString();
                autonMiddleInputScoreString = middleInput1.getText().toString();
                autonLowerInputScoreString = lowerInput1.getText().toString();
                if (groundCheck1.isChecked()) {
                    autonGroundLoadsBoolean = true;
                }
                else {
                    autonGroundLoadsBoolean = false;
                }
                if (humanCheck1.isChecked()) {
                    autonHumanLoadsBoolean  = true;
                }
                else {
                    autonHumanLoadsBoolean = false;
                }
                if (mobilityPointCheck.isChecked()) {
                    autonMobilityPointBoolean  = true;
                }
                else {
                    autonMobilityPointBoolean = false;
                }
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putString("MatchNumber", matchNumberInputString);
                editor.putString("AutonUpperScore", autonUpperInputScoreString);
                editor.putString("AutonMiddleScore", autonMiddleInputScoreString);
                editor.putString("AutonLowerScore", autonLowerInputScoreString);
                editor.putBoolean("AutonGroundCheck", autonGroundLoadsBoolean);
                editor.putBoolean("AutonHumanCheck", autonHumanLoadsBoolean);
                editor.putBoolean("AutonMobilityCheck", autonMobilityPointBoolean);
                editor.commit();

                //screen will be changed to endgame screen
                Intent goToEndgameScreen = new Intent(AutonScreen.this, EndScreen.class);
                startActivity(goToEndgameScreen);
            }
        });
        qrcodeBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences
                teamNumberInputString = teamNumInput1.getText().toString();
                matchNumberInputString = matchNumInput1.getText().toString();
                autonUpperInputScoreString = upperInput1.getText().toString();
                autonMiddleInputScoreString = middleInput1.getText().toString();
                autonLowerInputScoreString = lowerInput1.getText().toString();
                if (groundCheck1.isChecked()) {
                    autonGroundLoadsBoolean = true;
                }
                else {
                    autonGroundLoadsBoolean = false;
                }
                if (humanCheck1.isChecked()) {
                    autonHumanLoadsBoolean  = true;
                }
                else {
                    autonHumanLoadsBoolean = false;
                }
                if (mobilityPointCheck.isChecked()) {
                    autonMobilityPointBoolean  = true;
                }
                else {
                    autonMobilityPointBoolean = false;
                }
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putString("MatchNumber", matchNumberInputString);
                editor.putString("AutonUpperScore", autonUpperInputScoreString);
                editor.putString("AutonMiddleScore", autonMiddleInputScoreString);
                editor.putString("AutonLowerScore", autonLowerInputScoreString);
                editor.putBoolean("AutonGroundCheck", autonGroundLoadsBoolean);
                editor.putBoolean("AutonHumanCheck", autonHumanLoadsBoolean);
                editor.putBoolean("AutonMobilityCheck", autonMobilityPointBoolean);
                editor.commit();

                //screen will be changed to the qrcomment screen
                Intent goToQrcodeScreen = new Intent(AutonScreen.this, QRCommentsScreen.class);
                startActivity(goToQrcodeScreen);
            }
        });

        //score changing button on click methods
        upperPlus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //creating a variable for the pieces scored
                int autonUpperPiecesScored;

                //if there is noting inputed yet the variable will be set to 0
                if(upperInput1.getText().toString().equals("")) {
                    autonUpperPiecesScored = 0;
                } else {
                    //if there is something inputed it will get the number and set the variable to it
                    autonUpperPiecesScored = Integer.parseInt(upperInput1.getText().toString());
                }
                if(autonUpperPiecesScored >= 0) {
                    //if the number is above or = to 0 then the variable will increase by 1
                    autonUpperPiecesScored++;
                }
                //string created that stores the pieces scored variable (empty string needed since cant directly set a string to a variable)
                String autonUpperPiecesString = "" + autonUpperPiecesScored;
                //setting the input to the string storing the pieces scored so it shows up on the screen
                upperInput1.setText(autonUpperPiecesString);
            }
        });

        upperMinus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int autonUpperPiecesScored;
                if(upperInput1.getText().toString().equals("")) {
                    autonUpperPiecesScored = 0;
                } else {
                    autonUpperPiecesScored = Integer.parseInt(upperInput1.getText().toString());
                }
                if(autonUpperPiecesScored > 0) {
                    //if the number is above 0 the number can go one lower but otherwise nothing will happen if it is already at 0 since you don't want negative numbers
                    autonUpperPiecesScored--;
                }
                String autonUpperPiecesString = "" + autonUpperPiecesScored;
                upperInput1.setText(autonUpperPiecesString);
            }
        });

        middlePlus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int autonMiddlePiecesScored;

                if(middleInput1.getText().toString().equals("")) {
                    autonMiddlePiecesScored = 0;
                } else {
                    autonMiddlePiecesScored = Integer.parseInt(middleInput1.getText().toString());
                }
                if(autonMiddlePiecesScored >= 0) {
                    autonMiddlePiecesScored++;
                }
                String autonMiddlePiecesString = "" + autonMiddlePiecesScored;
                middleInput1.setText(autonMiddlePiecesString);
            }
        });

        middleMinus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int autonMiddlePiecesScored;
                if(middleInput1.getText().toString().equals("")) {
                    autonMiddlePiecesScored = 0;
                } else {
                    autonMiddlePiecesScored = Integer.parseInt(middleInput1.getText().toString());
                }
                if(autonMiddlePiecesScored > 0) {
                    autonMiddlePiecesScored--;
                }
                String autonMiddlePiecesString = "" + autonMiddlePiecesScored;
                middleInput1.setText(autonMiddlePiecesString);
            }
        });

        lowerPlus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int autonLowerPiecesScored;

                if(lowerInput1.getText().toString().equals("")) {
                    autonLowerPiecesScored = 0;
                } else {
                    autonLowerPiecesScored = Integer.parseInt(lowerInput1.getText().toString());
                }
                if(autonLowerPiecesScored >= 0) {
                    autonLowerPiecesScored++;
                }
                String autonLowerPiecesString = "" + autonLowerPiecesScored;
                lowerInput1.setText(autonLowerPiecesString);
            }
        });

        lowerMinus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int autonLowerPiecesScored;
                if(upperInput1.getText().toString().equals("")) {
                    autonLowerPiecesScored = 0;
                } else {
                    autonLowerPiecesScored = Integer.parseInt(lowerInput1.getText().toString());
                }
                if(autonLowerPiecesScored > 0) {
                    autonLowerPiecesScored--;
                }
                String autonLowerPiecesString = "" + autonLowerPiecesScored;
                lowerInput1.setText(autonLowerPiecesString);
            }
        });

    }
}


