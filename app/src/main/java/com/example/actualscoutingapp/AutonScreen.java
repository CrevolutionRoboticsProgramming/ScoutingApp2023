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
    TextView autonTitleTxt1, teleopTitleTxt1, endgameTitleTxt1, qrcodeTitleTxt1, autonTitleTxt, matchNumTitle1, teamNumTitle1, autonMatchInfoBack, scoringCubesTitleTxt1, upperCubesTitleTxt1, middleCubesTitleTxt1, lowerCubesTitleTxt1, scoringConesTitleTxt1, upperConesTitleTxt1, middleConesTitleTxt1, lowerConesTitleTxt1, dockingTitleTxt1, fieldDropsTitleTxt1, communityDropsTitleTxt1;
    ImageView autonScreenBackground, autonHomeBtnPic, autonTitleUnderline, matchNumBack1, teamNumBack1, upperCubesPlus1, upperCubesMinus1, middleCubesPlus1, middleCubesMinus1, lowerCubesPlus1, lowerCubesMinus1, upperConesPlus1, upperConesMinus1, middleConesPlus1, middleConesMinus1, lowerConesPlus1, lowerConesMinus1, fieldDropsPlus1, fieldDropsMinus1, communityDropsPlus1, communityDropsMinus1;
    EditText matchNumInput1, teamNumInput1, upperCubesInput1, middleCubesInput1, lowerCubesInput1, upperConesInput1, middleConesInput1, lowerConesInput1, fieldDropsInput1, communityDropsInput1;
    CheckBox mobilityPointCheck;
    RadioGroup docking1;
    RadioButton noAttemptOption1, attemptNoEngageOption1, engagedOption1;
    SharedPreferences sp;
    String teamNumberInputString, matchNumberInputString, autonUpperCubesInputScoreString, autonMiddleCubesInputScoreString, autonLowerCubesInputScoreString, autonUpperConesInputScoreString, autonMiddleConesInputScoreString, autonLowerConesInputScoreString, autonFieldDropsInputScoreString, autonCommunityDropsInputScoreString;
    Boolean autonMobilityPointBoolean, autonNoDockingBoolean, autonDockingNotEngagedBoolean, autonDockingEngagedBoolean;



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
        scoringCubesTitleTxt1 = findViewById(R.id.autonCubesScoringTitle);
        upperCubesTitleTxt1 = findViewById(R.id.autonCubesUpperTitle);
        middleCubesTitleTxt1 = findViewById(R.id.autonCubesMiddleTitle);
        lowerCubesTitleTxt1 = findViewById(R.id.autonCubesLowerTitle);
        scoringConesTitleTxt1 = findViewById(R.id.autonConesScoringTitle);
        upperConesTitleTxt1 = findViewById(R.id.autonConesUpperTitle);
        middleConesTitleTxt1 = findViewById(R.id.autonConesMiddleTitle);
        lowerConesTitleTxt1 = findViewById(R.id.autonConesLowerTitle);
        dockingTitleTxt1 = findViewById(R.id.autonDockingTitle);
        fieldDropsTitleTxt1 = findViewById(R.id.autonFieldDropsTitle);
        communityDropsTitleTxt1 = findViewById(R.id.autonCommunityDropsTitle);

        autonScreenBackground = findViewById(R.id.autonBackground);
        autonHomeBtnPic = findViewById(R.id.autonHome);
        autonTitleUnderline = findViewById(R.id.autonScreenTitleUnderline);
        matchNumBack1 = findViewById(R.id.autonMatchNumBack);
        teamNumBack1 = findViewById(R.id.autonTeamNumBack);
        upperCubesPlus1 = findViewById(R.id.autonCubesUpperPlus);
        upperCubesMinus1 = findViewById(R.id.autonCubesUpperMinus);
        middleCubesPlus1 = findViewById(R.id.autonCubesMiddlePlus);
        middleCubesMinus1 = findViewById(R.id.autonCubesMiddleMinus);
        lowerCubesPlus1 = findViewById(R.id.autonCubesLowerPlus);
        lowerCubesMinus1 = findViewById(R.id.autonCubesLowerMinus);
        upperConesPlus1 = findViewById(R.id.autonConesUpperPlus);
        upperConesMinus1 = findViewById(R.id.autonConesUpperMinus);
        middleConesPlus1 = findViewById(R.id.autonConesMiddlePlus);
        middleConesMinus1 = findViewById(R.id.autonConesMiddleMinus);
        lowerConesPlus1 = findViewById(R.id.autonConesLowerPlus);
        lowerConesMinus1 = findViewById(R.id.autonConesLowerMinus);
        fieldDropsPlus1 = findViewById(R.id.autonFieldDropsPlus);
        fieldDropsMinus1 = findViewById(R.id.autonFieldDropsMinus);
        communityDropsPlus1 = findViewById(R.id.autonCommunityDropsPlus);
        communityDropsMinus1 = findViewById(R.id.autonCommunityDropsMinus);


        matchNumInput1 = findViewById(R.id.autonMatchNumInput);
        teamNumInput1 = findViewById(R.id.autonTeamNumInput);
        upperCubesInput1 = findViewById(R.id.autonCubesUpperInput);
        middleCubesInput1 = findViewById(R.id.autonCubesMiddleInput);
        lowerCubesInput1 = findViewById(R.id.autonCubesLowerInput);
        upperConesInput1 = findViewById(R.id.autonConesUpperInput);
        middleConesInput1 = findViewById(R.id.autonConesMiddleInput);
        lowerConesInput1 = findViewById(R.id.autonConesLowerInput);
        fieldDropsInput1 = findViewById(R.id.autonFieldDropsInput);
        communityDropsInput1 = findViewById(R.id.autonCommunityDropsInput);

        mobilityPointCheck = findViewById(R.id.autonMobilityCheck);

        docking1 = findViewById(R.id.autonDockingOptions);

        noAttemptOption1 = findViewById(R.id.autonNoAttemptOption);
        attemptNoEngageOption1 = findViewById(R.id.autonDockedNotEngagedOption);
        engagedOption1 = findViewById(R.id.autonDockedEngagedOption);

        //getting shared preferences
        sp = getSharedPreferences("TeamData", MODE_PRIVATE);

        //when the screen is changed to the auton screen if there was any text or checks already inputed then they will replace the otherwise blank inputs
        SharedPreferences new_sp = getApplicationContext().getSharedPreferences("TeamData", MODE_PRIVATE);
        teamNumInput1.setText(new_sp.getString("TeamNumber", ""));
        matchNumInput1.setText(new_sp.getString("MatchNumber", ""));
        upperCubesInput1.setText(new_sp.getString("AutonCubesUpperScore", ""));
        middleCubesInput1.setText(new_sp.getString("AutonCubesMiddleScore", ""));
        lowerCubesInput1.setText(new_sp.getString("AutonCubesLowerScore", ""));
        upperConesInput1.setText(new_sp.getString("AutonConesUpperScore", ""));
        middleConesInput1.setText(new_sp.getString("AutonConesMiddleScore", ""));
        lowerConesInput1.setText(new_sp.getString("AutonConesLowerScore", ""));
        fieldDropsInput1.setText(new_sp.getString("AutonFieldDropsScore", ""));
        communityDropsInput1.setText(new_sp.getString("AutonCommunityDropsScore", ""));
        mobilityPointCheck.setChecked(new_sp.getBoolean("AutonMobilityCheck", false));
        noAttemptOption1.setChecked(new_sp.getBoolean("AutonNoClimbAttempted", false));
        attemptNoEngageOption1.setChecked(new_sp.getBoolean("AutonClimbAttemptedNotEngaged", false));
        engagedOption1.setChecked(new_sp.getBoolean("AutonClimbAttemptedEngaged", false));



        //creating on click events

        //screen changing buttons
        autonHomeBtnPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences

                //making the inputs into a string for the sp
                teamNumberInputString = teamNumInput1.getText().toString();
                matchNumberInputString = matchNumInput1.getText().toString();
                autonUpperCubesInputScoreString = upperCubesInput1.getText().toString();
                autonMiddleCubesInputScoreString = middleCubesInput1.getText().toString();
                autonLowerCubesInputScoreString = lowerCubesInput1.getText().toString();
                autonUpperConesInputScoreString = upperConesInput1.getText().toString();
                autonMiddleConesInputScoreString = middleConesInput1.getText().toString();
                autonLowerConesInputScoreString = lowerConesInput1.getText().toString();
                autonFieldDropsInputScoreString = fieldDropsInput1.getText().toString();
                autonCommunityDropsInputScoreString = communityDropsInput1.getText().toString();
                //check box inputs turned into a boolean
                if (mobilityPointCheck.isChecked()) {
                    autonMobilityPointBoolean  = true;
                }
                else {
                    autonMobilityPointBoolean = false;
                }


                if (noAttemptOption1.isChecked()){
                    autonNoDockingBoolean = true;
                }
                else {
                    autonNoDockingBoolean = false;
                }
                if (attemptNoEngageOption1.isChecked()){
                    autonDockingNotEngagedBoolean = true;
                }
                else {
                    autonDockingNotEngagedBoolean = false;
                }
                if (engagedOption1.isChecked()){
                    autonDockingEngagedBoolean = true;
                }
                else {
                    autonDockingEngagedBoolean = false;
                }
                //creating a editor for the sp and naming it editor
                SharedPreferences.Editor editor = sp.edit();
                //using the editor to store the strings and booleans in the sp (green) that can be called from other screens aswell
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putString("MatchNumber", matchNumberInputString);
                editor.putString("AutonCubesUpperScore", autonUpperCubesInputScoreString);
                editor.putString("AutonCubesMiddleScore", autonMiddleCubesInputScoreString);
                editor.putString("AutonCubesLowerScore", autonLowerCubesInputScoreString);
                editor.putString("AutonConesUpperScore", autonUpperConesInputScoreString);
                editor.putString("AutonConesMiddleScore", autonMiddleConesInputScoreString);
                editor.putString("AutonConesLowerScore", autonLowerConesInputScoreString);
                editor.putString("AutonFieldDropsScore", autonFieldDropsInputScoreString);
                editor.putString("AutonCommunityDropsScore", autonCommunityDropsInputScoreString);
                editor.putBoolean("AutonMobilityCheck", autonMobilityPointBoolean);
                editor.putBoolean("AutonNoClimbAttempted", autonNoDockingBoolean);
                editor.putBoolean("AutonClimbAttemptedNotEngaged", autonDockingNotEngagedBoolean);
                editor.putBoolean("AutonClimbAttemptedEngaged", autonDockingEngagedBoolean);
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
                autonUpperCubesInputScoreString = upperCubesInput1.getText().toString();
                autonMiddleCubesInputScoreString = middleCubesInput1.getText().toString();
                autonLowerCubesInputScoreString = lowerCubesInput1.getText().toString();
                autonUpperConesInputScoreString = upperConesInput1.getText().toString();
                autonMiddleConesInputScoreString = middleConesInput1.getText().toString();
                autonLowerConesInputScoreString = lowerConesInput1.getText().toString();
                autonFieldDropsInputScoreString = fieldDropsInput1.getText().toString();
                autonCommunityDropsInputScoreString = communityDropsInput1.getText().toString();

                if (mobilityPointCheck.isChecked()) {
                    autonMobilityPointBoolean  = true;
                }
                else {
                    autonMobilityPointBoolean = false;
                }

                if (noAttemptOption1.isChecked()){
                    autonNoDockingBoolean = true;
                }
                else {
                    autonNoDockingBoolean = false;
                }
                if (attemptNoEngageOption1.isChecked()){
                    autonDockingNotEngagedBoolean = true;
                }
                else {
                    autonDockingNotEngagedBoolean = false;
                }
                if (engagedOption1.isChecked()){
                    autonDockingEngagedBoolean = true;
                }
                else {
                    autonDockingEngagedBoolean = false;
                }
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putString("MatchNumber", matchNumberInputString);
                editor.putString("AutonCubesUpperScore", autonUpperCubesInputScoreString);
                editor.putString("AutonCubesMiddleScore", autonMiddleCubesInputScoreString);
                editor.putString("AutonCubesLowerScore", autonLowerCubesInputScoreString);
                editor.putString("AutonConesUpperScore", autonUpperConesInputScoreString);
                editor.putString("AutonConesMiddleScore", autonMiddleConesInputScoreString);
                editor.putString("AutonConesLowerScore", autonLowerConesInputScoreString);
                editor.putString("AutonFieldDropsScore", autonFieldDropsInputScoreString);
                editor.putString("AutonCommunityDropsScore", autonCommunityDropsInputScoreString);
                editor.putBoolean("AutonMobilityCheck", autonMobilityPointBoolean);
                editor.putBoolean("AutonNoClimbAttempted", autonNoDockingBoolean);
                editor.putBoolean("AutonClimbAttemptedNotEngaged", autonDockingNotEngagedBoolean);
                editor.putBoolean("AutonClimbAttemptedEngaged", autonDockingEngagedBoolean);
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
                autonUpperCubesInputScoreString = upperCubesInput1.getText().toString();
                autonMiddleCubesInputScoreString = middleCubesInput1.getText().toString();
                autonLowerCubesInputScoreString = lowerCubesInput1.getText().toString();
                autonUpperConesInputScoreString = upperConesInput1.getText().toString();
                autonMiddleConesInputScoreString = middleConesInput1.getText().toString();
                autonLowerConesInputScoreString = lowerConesInput1.getText().toString();
                autonFieldDropsInputScoreString = fieldDropsInput1.getText().toString();
                autonCommunityDropsInputScoreString = communityDropsInput1.getText().toString();

                if (mobilityPointCheck.isChecked()) {
                    autonMobilityPointBoolean  = true;
                }
                else {
                    autonMobilityPointBoolean = false;
                }

                if (noAttemptOption1.isChecked()){
                    autonNoDockingBoolean = true;
                }
                else {
                    autonNoDockingBoolean = false;
                }
                if (attemptNoEngageOption1.isChecked()){
                    autonDockingNotEngagedBoolean = true;
                }
                else {
                    autonDockingNotEngagedBoolean = false;
                }
                if (engagedOption1.isChecked()){
                    autonDockingEngagedBoolean = true;
                }
                else {
                    autonDockingEngagedBoolean = false;
                }
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putString("MatchNumber", matchNumberInputString);
                editor.putString("AutonCubesUpperScore", autonUpperCubesInputScoreString);
                editor.putString("AutonCubesMiddleScore", autonMiddleCubesInputScoreString);
                editor.putString("AutonCubesLowerScore", autonLowerCubesInputScoreString);
                editor.putString("AutonConesUpperScore", autonUpperConesInputScoreString);
                editor.putString("AutonConesMiddleScore", autonMiddleConesInputScoreString);
                editor.putString("AutonConesLowerScore", autonLowerConesInputScoreString);
                editor.putString("AutonFieldDropsScore", autonFieldDropsInputScoreString);
                editor.putString("AutonCommunityDropsScore", autonCommunityDropsInputScoreString);
                editor.putBoolean("AutonMobilityCheck", autonMobilityPointBoolean);
                editor.putBoolean("AutonNoClimbAttempted", autonNoDockingBoolean);
                editor.putBoolean("AutonClimbAttemptedNotEngaged", autonDockingNotEngagedBoolean);
                editor.putBoolean("AutonClimbAttemptedEngaged", autonDockingEngagedBoolean);
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
                autonUpperCubesInputScoreString = upperCubesInput1.getText().toString();
                autonMiddleCubesInputScoreString = middleCubesInput1.getText().toString();
                autonLowerCubesInputScoreString = lowerCubesInput1.getText().toString();
                autonUpperConesInputScoreString = upperConesInput1.getText().toString();
                autonMiddleConesInputScoreString = middleConesInput1.getText().toString();
                autonLowerConesInputScoreString = lowerConesInput1.getText().toString();
                autonFieldDropsInputScoreString = fieldDropsInput1.getText().toString();
                autonCommunityDropsInputScoreString = communityDropsInput1.getText().toString();

                if (mobilityPointCheck.isChecked()) {
                    autonMobilityPointBoolean  = true;
                }
                else {
                    autonMobilityPointBoolean = false;
                }

                if (noAttemptOption1.isChecked()){
                    autonNoDockingBoolean = true;
                }
                else {
                    autonNoDockingBoolean = false;
                }
                if (attemptNoEngageOption1.isChecked()){
                    autonDockingNotEngagedBoolean = true;
                }
                else {
                    autonDockingNotEngagedBoolean = false;
                }
                if (engagedOption1.isChecked()){
                    autonDockingEngagedBoolean = true;
                }
                else {
                    autonDockingEngagedBoolean = false;
                }
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putString("MatchNumber", matchNumberInputString);
                editor.putString("AutonCubesUpperScore", autonUpperCubesInputScoreString);
                editor.putString("AutonCubesMiddleScore", autonMiddleCubesInputScoreString);
                editor.putString("AutonCubesLowerScore", autonLowerCubesInputScoreString);
                editor.putString("AutonConesUpperScore", autonUpperConesInputScoreString);
                editor.putString("AutonConesMiddleScore", autonMiddleConesInputScoreString);
                editor.putString("AutonConesLowerScore", autonLowerConesInputScoreString);
                editor.putString("AutonFieldDropsScore", autonFieldDropsInputScoreString);
                editor.putString("AutonCommunityDropsScore", autonCommunityDropsInputScoreString);
                editor.putBoolean("AutonMobilityCheck", autonMobilityPointBoolean);
                editor.putBoolean("AutonNoClimbAttempted", autonNoDockingBoolean);
                editor.putBoolean("AutonClimbAttemptedNotEngaged", autonDockingNotEngagedBoolean);
                editor.putBoolean("AutonClimbAttemptedEngaged", autonDockingEngagedBoolean);
                editor.commit();

                //screen will be changed to the qrcomment screen
                Intent goToQrcodeScreen = new Intent(AutonScreen.this, QRCommentsScreen.class);
                startActivity(goToQrcodeScreen);
            }
        });

        //score changing button on click methods
        upperCubesPlus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //creating a variable for the pieces scored
                int autonUpperCubesScored;

                //if there is noting inputed yet the variable will be set to 0
                if(upperCubesInput1.getText().toString().equals("")) {
                    autonUpperCubesScored = 0;
                } else {
                    //if there is something inputed it will get the number and set the variable to it
                    autonUpperCubesScored = Integer.parseInt(upperCubesInput1.getText().toString());
                }
                if(autonUpperCubesScored >= 0) {
                    //if the number is above or = to 0 then the variable will increase by 1
                    autonUpperCubesScored++;
                }
                //string created that stores the pieces scored variable (empty string needed since cant directly set a string to a variable)
                String autonUpperCubesString = "" + autonUpperCubesScored;
                //setting the input to the string storing the pieces scored so it shows up on the screen
                upperCubesInput1.setText(autonUpperCubesString);
            }
        });

        upperCubesMinus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int autonUpperCubesScored;
                if(upperCubesInput1.getText().toString().equals("")) {
                    autonUpperCubesScored = 0;
                } else {
                    autonUpperCubesScored = Integer.parseInt(upperCubesInput1.getText().toString());
                }
                if(autonUpperCubesScored > 0) {
                    //if the number is above 0 the number can go one lower but otherwise nothing will happen if it is already at 0 since you don't want negative numbers
                    autonUpperCubesScored--;
                }
                String autonUpperCubesString = "" + autonUpperCubesScored;
                upperCubesInput1.setText(autonUpperCubesString);
            }
        });

        middleCubesPlus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int autonMiddleCubesScored;

                if(middleCubesInput1.getText().toString().equals("")) {
                    autonMiddleCubesScored = 0;
                } else {
                    autonMiddleCubesScored = Integer.parseInt(middleCubesInput1.getText().toString());
                }
                if(autonMiddleCubesScored >= 0) {
                    autonMiddleCubesScored++;
                }
                String autonMiddleCubesString = "" + autonMiddleCubesScored;
                middleCubesInput1.setText(autonMiddleCubesString);
            }
        });

        middleCubesMinus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int autonMiddleCubesScored;
                if(middleCubesInput1.getText().toString().equals("")) {
                    autonMiddleCubesScored = 0;
                } else {
                    autonMiddleCubesScored = Integer.parseInt(middleCubesInput1.getText().toString());
                }
                if(autonMiddleCubesScored > 0) {
                    autonMiddleCubesScored--;
                }
                String autonMiddleCubesString = "" + autonMiddleCubesScored;
                middleCubesInput1.setText(autonMiddleCubesString);
            }
        });

        lowerCubesPlus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int autonLowerCubesScored;

                if(lowerCubesInput1.getText().toString().equals("")) {
                    autonLowerCubesScored = 0;
                } else {
                    autonLowerCubesScored = Integer.parseInt(lowerCubesInput1.getText().toString());
                }
                if(autonLowerCubesScored >= 0) {
                    autonLowerCubesScored++;
                }
                String autonLowerCubesString = "" + autonLowerCubesScored;
                lowerCubesInput1.setText(autonLowerCubesString);
            }
        });

        lowerCubesMinus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int autonLowerCubesScored;
                if(upperCubesInput1.getText().toString().equals("")) {
                    autonLowerCubesScored = 0;
                } else {
                    autonLowerCubesScored = Integer.parseInt(lowerCubesInput1.getText().toString());
                }
                if(autonLowerCubesScored > 0) {
                    autonLowerCubesScored--;
                }
                String autonLowerCubesString = "" + autonLowerCubesScored;
                lowerCubesInput1.setText(autonLowerCubesString);
            }
        });

        upperConesPlus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //creating a variable for the pieces scored
                int autonUpperConesScored;

                //if there is noting inputed yet the variable will be set to 0
                if(upperConesInput1.getText().toString().equals("")) {
                    autonUpperConesScored = 0;
                } else {
                    //if there is something inputed it will get the number and set the variable to it
                    autonUpperConesScored = Integer.parseInt(upperConesInput1.getText().toString());
                }
                if(autonUpperConesScored >= 0) {
                    //if the number is above or = to 0 then the variable will increase by 1
                    autonUpperConesScored++;
                }
                //string created that stores the pieces scored variable (empty string needed since cant directly set a string to a variable)
                String autonUpperConesString = "" + autonUpperConesScored;
                //setting the input to the string storing the pieces scored so it shows up on the screen
                upperConesInput1.setText(autonUpperConesString);
            }
        });

        upperConesMinus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int autonUpperConesScored;
                if(upperConesInput1.getText().toString().equals("")) {
                    autonUpperConesScored = 0;
                } else {
                    autonUpperConesScored = Integer.parseInt(upperConesInput1.getText().toString());
                }
                if(autonUpperConesScored > 0) {
                    //if the number is above 0 the number can go one lower but otherwise nothing will happen if it is already at 0 since you don't want negative numbers
                    autonUpperConesScored--;
                }
                String autonUpperConesString = "" + autonUpperConesScored;
                upperConesInput1.setText(autonUpperConesString);
            }
        });

        middleConesPlus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int autonMiddleConesScored;

                if(middleConesInput1.getText().toString().equals("")) {
                    autonMiddleConesScored = 0;
                } else {
                    autonMiddleConesScored = Integer.parseInt(middleConesInput1.getText().toString());
                }
                if(autonMiddleConesScored >= 0) {
                    autonMiddleConesScored++;
                }
                String autonMiddleConesString = "" + autonMiddleConesScored;
                middleConesInput1.setText(autonMiddleConesString);
            }
        });

        middleConesMinus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int autonMiddleConesScored;
                if(middleConesInput1.getText().toString().equals("")) {
                    autonMiddleConesScored = 0;
                } else {
                    autonMiddleConesScored = Integer.parseInt(middleConesInput1.getText().toString());
                }
                if(autonMiddleConesScored > 0) {
                    autonMiddleConesScored--;
                }
                String autonMiddleConesString = "" + autonMiddleConesScored;
                middleConesInput1.setText(autonMiddleConesString);
            }
        });

        lowerConesPlus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int autonLowerConesScored;

                if(lowerConesInput1.getText().toString().equals("")) {
                    autonLowerConesScored = 0;
                } else {
                    autonLowerConesScored = Integer.parseInt(lowerConesInput1.getText().toString());
                }
                if(autonLowerConesScored >= 0) {
                    autonLowerConesScored++;
                }
                String autonLowerConesString = "" + autonLowerConesScored;
                lowerConesInput1.setText(autonLowerConesString);
            }
        });

        lowerConesMinus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int autonLowerConesScored;
                if(upperConesInput1.getText().toString().equals("")) {
                    autonLowerConesScored = 0;
                } else {
                    autonLowerConesScored = Integer.parseInt(lowerConesInput1.getText().toString());
                }
                if(autonLowerConesScored > 0) {
                    autonLowerConesScored--;
                }
                String autonLowerConesString = "" + autonLowerConesScored;
                lowerConesInput1.setText(autonLowerConesString);
            }
        });

        fieldDropsPlus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int autonFieldDropsScore;

                if(fieldDropsInput1.getText().toString().equals("")) {
                    autonFieldDropsScore = 0;
                } else {
                    autonFieldDropsScore = Integer.parseInt(fieldDropsInput1.getText().toString());
                }
                if(autonFieldDropsScore >= 0) {
                    autonFieldDropsScore++;
                }
                String autonFieldDropsString = "" + autonFieldDropsScore;
                fieldDropsInput1.setText(autonFieldDropsString);
            }
        });

        fieldDropsMinus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int autonFieldDropsScore;
                if(fieldDropsInput1.getText().toString().equals("")) {
                    autonFieldDropsScore = 0;
                } else {
                    autonFieldDropsScore = Integer.parseInt(fieldDropsInput1.getText().toString());
                }
                if(autonFieldDropsScore > 0) {
                    autonFieldDropsScore--;
                }
                String autonFieldDropsString = "" + autonFieldDropsScore;
                fieldDropsInput1.setText(autonFieldDropsString);
            }
        });

        communityDropsPlus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int autonCommunityDropsScore;

                if(communityDropsInput1.getText().toString().equals("")) {
                    autonCommunityDropsScore = 0;
                } else {
                    autonCommunityDropsScore = Integer.parseInt(communityDropsInput1.getText().toString());
                }
                if(autonCommunityDropsScore >= 0) {
                    autonCommunityDropsScore++;
                }
                String autonCommunityDropsString = "" + autonCommunityDropsScore;
                communityDropsInput1.setText(autonCommunityDropsString);
            }
        });

        communityDropsMinus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int autonCommunityDropsScore;
                if(communityDropsInput1.getText().toString().equals("")) {
                    autonCommunityDropsScore = 0;
                } else {
                    autonCommunityDropsScore = Integer.parseInt(communityDropsInput1.getText().toString());
                }
                if(autonCommunityDropsScore > 0) {
                    autonCommunityDropsScore--;
                }
                String autonCommunityDropsString = "" + autonCommunityDropsScore;
                communityDropsInput1.setText(autonCommunityDropsString);
            }
        });

    }
}


