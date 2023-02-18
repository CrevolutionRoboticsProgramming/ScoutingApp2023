package com.example.actualscoutingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QRCommentsScreen extends AppCompatActivity {

// MORE IN DEPTH COMMENTS FOR REPEATED CODE IS ON AUTON SCREEN

    //creating variables for everything on the .xml file
    ImageButton autonBtn4, teleopBtn4, endgameBtn4, qrcodeBtn4;
    TextView autonTitleTxt4, teleopTitleTxt4, endgameTitleTxt4, qrcodeTitleTxt4, qrcodeTitleTxt, qrCommentsTitle;
    ImageView qrcodeScreenBackground, qrcodeHomeBtnPic, qrcodePic, qrcodeTitleUnderline, qrcodeGenerateBack, matchNextBack, qrCommentsTitleUnderline;
    Button generateQrcodeBtn, nextMatchBtn;
    EditText commentsBox;
    SharedPreferences sp;
    String commentInputString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcomments_screen);


        //get rid of action bar when running the app
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        //matching the variables created to the ids on the .xml files
        autonBtn4 = findViewById(R.id.autonUnclicked4);
        teleopBtn4 = findViewById(R.id.teleopUnclicked4);
        endgameBtn4 = findViewById(R.id.endgameUnclicked4);
        qrcodeBtn4 = findViewById(R.id.qrcodeClicked4);

        autonTitleTxt4 = findViewById(R.id.autonTitleText4);
        teleopTitleTxt4 = findViewById(R.id.teleopTitleText4);
        endgameTitleTxt4 = findViewById(R.id.endgameTitleText4);
        qrcodeTitleTxt4 = findViewById(R.id.qrcodeTitleText4);
        qrcodeTitleTxt = findViewById(R.id.qrcodeScreenTitle);
        qrCommentsTitle = findViewById(R.id.commentsTitle);

        qrcodeScreenBackground = findViewById(R.id.qrcodeBackground);
        qrcodeHomeBtnPic = findViewById(R.id.qrcodeHome);
        qrcodePic = findViewById(R.id.qrcode);
        qrcodeTitleUnderline = findViewById(R.id.qrcodeScreenTitleUnderline);
        qrcodeGenerateBack = findViewById(R.id.generateQrcodeBack);
        matchNextBack = findViewById(R.id.nextMatchBack);
        qrCommentsTitleUnderline = findViewById(R.id.commentsUnderline);

        generateQrcodeBtn = findViewById(R.id.generateQrcode);
        nextMatchBtn = findViewById(R.id.nextMatch);

        commentsBox = findViewById(R.id.comments);

        //getting shared preferences
        sp = getSharedPreferences("TeamData", MODE_PRIVATE);

        //when the screen is changed to the auton screen if there was any text or checks already inputed then they will replace the otherwise blank inputs
        SharedPreferences new_sp = getApplicationContext().getSharedPreferences("TeamData", MODE_PRIVATE);
        commentsBox.setText(new_sp.getString("Comments",""));


        //creating on click events

        //screen changing buttons
        qrcodeHomeBtnPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences
                commentInputString = commentsBox.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("Comments", commentInputString);
                editor.commit();

                //screen will be changed to the home screen
                Intent goToHomeScreen = new Intent(QRCommentsScreen.this, MainActivity.class);
                startActivity(goToHomeScreen);
            }
        });
        autonBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences
                commentInputString = commentsBox.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("Comments", commentInputString);
                editor.commit();

                //screen will be changed to the auton screen
                Intent goToAutonScreen = new Intent(QRCommentsScreen.this, AutonScreen.class);
                startActivity(goToAutonScreen);
            }
        });
        teleopBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences
                commentInputString = commentsBox.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("Comments", commentInputString);
                editor.commit();

                //screen will be changed to the teleop screen
                Intent goToTeleopScreen = new Intent(QRCommentsScreen.this, TeleopScreen.class);
                startActivity(goToTeleopScreen);
            }
        });
        endgameBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences
                commentInputString = commentsBox.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("Comments", commentInputString);
                editor.commit();

                //screen will be changed to the endgame screen
                Intent goToEndgameScreen = new Intent(QRCommentsScreen.this, EndScreen.class);
                startActivity(goToEndgameScreen);
            }
        });
        nextMatchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sp.edit();
                editor.putString("TeamNumber", "");
                editor.putString("MatchNumber", "");
                editor.putString("AutonCubesUpperScore", "");
                editor.putString("AutonCubesMiddleScore", "");
                editor.putString("AutonCubesLowerScore", "");
                editor.putString("AutonConesUpperScore", "");
                editor.putString("AutonConesMiddleScore", "");
                editor.putString("AutonConesLowerScore", "");
                editor.putString("AutonFieldDropsScore", "");
                editor.putString("AutonCommunityDropsScore", "");
                editor.putBoolean("AutonMobilityCheck", false);
                editor.putString("TeleopCubesUpperScore", "");
                editor.putString("TeleopCubesMiddleScore", "");
                editor.putString("TeleopCubesLowerScore", "");
                editor.putString("TeleopConesUpperScore", "");
                editor.putString("TeleopConesMiddleScore", "");
                editor.putString("TeleopConesLowerScore", "");
                editor.putString("TeleopFieldDropsScore", "");
                editor.putString("TeleopCommunityDropsScore", "");
                editor.putString("TeleopLoadingDropsScore", "");
                editor.putString("Comments", "");
                editor.putBoolean("AutonNoClimbAttempted", false);
                editor.putBoolean("AutonClimbAttemptedNotEngaged", false);
                editor.putBoolean("AutonClimbAttemptedEngaged", false);
                editor.putBoolean("EndgameNoClimbAttempted", false);
                editor.putBoolean("EndgameClimbAttemptedNotEngaged", false);
                editor.putBoolean("EndgameClimbAttemptedEngaged", false);
                editor.commit();


                Intent startNewMatch = new Intent(QRCommentsScreen.this, AutonScreen.class);
                startActivity(startNewMatch);
            }
        });

        generateQrcodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qrcodePic.setVisibility(View.INVISIBLE);
                commentInputString = commentsBox.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("Comments", commentInputString);
                editor.commit();
                SharedPreferences new_SP = getApplicationContext().getSharedPreferences("TeamData", MODE_PRIVATE);

                String TeamNumberInputString, MatchNumberInputString, ScoutingCommentsString, AutonUpperCubesInputScoreString, AutonMiddleCubesInputScoreString, AutonLowerCubesInputScoreString, AutonUpperConesInputScoreString, AutonMiddleConesInputScoreString, AutonLowerConesInputScoreString, AutonFieldDropsInputScoreString, AutonCommunityDropsInputScoreString, AutonMobilityPointString, TeleopUpperCubesInputScoreString, TeleopMiddleCubesInputScoreString, TeleopLowerCubesInputScoreString, TeleopUpperConesInputScoreString, TeleopMiddleConesInputScoreString, TeleopLowerConesInputScoreString, TeleopFieldDropsInputScoreString, TeleopCommunityDropsInputScoreString, TeleopLoadingDropsInputScoreString, AutonDocking, EndgameDocking;
                boolean AutonMobilityPointBoolean, AutonNoDockingBoolean, AutonNotEngagedDockingBoolean, AutonEngagedDockingBoolean, EndgameNoDockingBoolean, EndgameNotEngagedDockingBoolean, EndgameEngagedDockingBoolean;

                TeamNumberInputString = new_SP.getString("TeamNumber", "");
                MatchNumberInputString = new_SP.getString("MatchNumber", "");

                if(new_SP.getString("AutonCubesUpperScore", "").equals("")){
                    AutonUpperCubesInputScoreString = "0";
                } else {
                    AutonUpperCubesInputScoreString = new_SP.getString("AutonCubesUpperScore", "");
                }

                if(new_SP.getString("AutonCubesMiddleScore", "").equals("")){
                    AutonMiddleCubesInputScoreString = "0";
                } else {
                    AutonMiddleCubesInputScoreString = new_SP.getString("AutonCubesMiddleScore", "");
                }

                if(new_SP.getString("AutonCubesLowerScore", "").equals("")){
                    AutonLowerCubesInputScoreString = "0";
                } else {
                    AutonLowerCubesInputScoreString = new_SP.getString("AutonCubesLowerScore", "");
                }

                if(new_SP.getString("AutonConesUpperScore", "").equals("")){
                    AutonUpperConesInputScoreString = "0";
                } else {
                    AutonUpperConesInputScoreString = new_SP.getString("AutonConesUpperScore", "");
                }

                if(new_SP.getString("AutonConesMiddleScore", "").equals("")){
                    AutonMiddleConesInputScoreString = "0";
                } else {
                    AutonMiddleConesInputScoreString = new_SP.getString("AutonConesMiddleScore", "");
                }

                if(new_SP.getString("AutonConesLowerScore", "").equals("")){
                    AutonLowerConesInputScoreString = "0";
                } else {
                    AutonLowerConesInputScoreString = new_SP.getString("AutonConesLowerScore", "");
                }

                if(new_SP.getString("AutonFieldDropsScore", "").equals("")){
                    AutonFieldDropsInputScoreString = "0";
                } else {
                    AutonFieldDropsInputScoreString = new_SP.getString("AutonFieldDropsScore", "");
                }

                if(new_SP.getString("AutonCommunityDropsScore", "").equals("")){
                    AutonCommunityDropsInputScoreString = "0";
                } else {
                    AutonCommunityDropsInputScoreString = new_SP.getString("AutonCommunityDropsScore", "");
                }

                AutonMobilityPointBoolean = new_SP.getBoolean("AutonMobilityCheck", false);
                AutonNoDockingBoolean = new_SP.getBoolean("AutonNoClimbAttempted", false);
                AutonNotEngagedDockingBoolean = new_SP.getBoolean("AutonClimbAttemptedNotEngaged", false);
                AutonEngagedDockingBoolean = new_SP.getBoolean("AutonClimbAttemptedEngaged", false);

                if (AutonNoDockingBoolean == true) {
                    AutonDocking = "None";
                } else if (AutonNotEngagedDockingBoolean == true){
                    AutonDocking = "Not Engaged";
                } else if (AutonEngagedDockingBoolean == true){
                    AutonDocking = "Engaged";
                } else {
                    AutonDocking = "N/A";
                }

                if(AutonMobilityPointBoolean) {
                    AutonMobilityPointString = "Yes";
                }
                else {
                    AutonMobilityPointString = "No";
                }


                if(new_SP.getString("TeleopCubesUpperScore", "").equals("")){
                    TeleopUpperCubesInputScoreString = "0";
                } else {
                    TeleopUpperCubesInputScoreString = new_SP.getString("TeleopCubesUpperScore", "");
                }

                if(new_SP.getString("TeleopCubesMiddleScore", "").equals("")){
                    TeleopMiddleCubesInputScoreString = "0";
                } else {
                    TeleopMiddleCubesInputScoreString = new_SP.getString("TeleopCubesMiddleScore", "");
                }

                if(new_SP.getString("TeleopCubesLowerScore", "").equals("")){
                    TeleopLowerCubesInputScoreString = "0";
                } else {
                    TeleopLowerCubesInputScoreString = new_SP.getString("TeleopCubesLowerScore", "");
                }

                if(new_SP.getString("TeleopConesUpperScore", "").equals("")){
                    TeleopUpperConesInputScoreString = "0";
                } else {
                    TeleopUpperConesInputScoreString = new_SP.getString("TeleopConesUpperScore", "");
                }

                if(new_SP.getString("TeleopConesMiddleScore", "").equals("")){
                    TeleopMiddleConesInputScoreString = "0";
                } else {
                    TeleopMiddleConesInputScoreString = new_SP.getString("TeleopConesMiddleScore", "");
                }

                if(new_SP.getString("TeleopConesLowerScore", "").equals("")){
                    TeleopLowerConesInputScoreString = "0";
                } else {
                    TeleopLowerConesInputScoreString = new_SP.getString("TeleopConesLowerScore", "");
                }

                if(new_SP.getString("TeleopFieldDropsScore", "").equals("")){
                    TeleopFieldDropsInputScoreString = "0";
                } else {
                    TeleopFieldDropsInputScoreString = new_SP.getString("TeleopFieldDropsScore", "");
                }

                if(new_SP.getString("TeleopCommunityDropsScore", "").equals("")){
                    TeleopCommunityDropsInputScoreString = "0";
                } else {
                    TeleopCommunityDropsInputScoreString = new_SP.getString("TeleopCommunityDropsScore", "");
                }

                if(new_SP.getString("TeleopLoadingDropsScore", "").equals("")){
                    TeleopLoadingDropsInputScoreString = "0";
                } else {
                    TeleopLoadingDropsInputScoreString = new_SP.getString("TeleopLoadingDropsScore", "");
                }

                EndgameNoDockingBoolean = new_SP.getBoolean("EndgameNoClimbAttempted", false);
                EndgameNotEngagedDockingBoolean = new_SP.getBoolean("EndgameClimbAttemptedNotEngaged", false);
                EndgameEngagedDockingBoolean = new_SP.getBoolean("EndgameClimbAttemptedEngaged", false);

                if (EndgameNoDockingBoolean == true) {
                    EndgameDocking = "None";
                } else if (EndgameNotEngagedDockingBoolean == true){
                    EndgameDocking = "Not Engaged";
                } else if (EndgameEngagedDockingBoolean == true){
                    EndgameDocking = "Engaged";
                } else {
                    EndgameDocking = "N/A";
                }

                if(new_SP.getString("Comments", "").equals("")) {
                    ScoutingCommentsString = "N/A";
                }
                else{
                    ScoutingCommentsString = new_SP.getString("Comments", "");
                }

                String finalQrOutput = TeamNumberInputString
                        + ',' + MatchNumberInputString
                        + ',' + AutonUpperCubesInputScoreString
                        + ',' + AutonMiddleCubesInputScoreString
                        + ',' + AutonLowerCubesInputScoreString
                        + ',' + AutonUpperConesInputScoreString
                        + ',' + AutonMiddleConesInputScoreString
                        + ',' + AutonLowerConesInputScoreString
                        + ',' + AutonFieldDropsInputScoreString
                        + ',' + AutonCommunityDropsInputScoreString
                        + ',' + AutonDocking
                        + ',' + AutonMobilityPointString
                        + ',' + TeleopUpperCubesInputScoreString
                        + ',' + TeleopMiddleCubesInputScoreString
                        + ',' + TeleopLowerCubesInputScoreString
                        + ',' + TeleopUpperConesInputScoreString
                        + ',' + TeleopMiddleConesInputScoreString
                        + ',' + TeleopLowerConesInputScoreString
                        + ',' + TeleopFieldDropsInputScoreString
                        + ',' + TeleopCommunityDropsInputScoreString
                        + ',' + TeleopLoadingDropsInputScoreString
                        + ',' + EndgameDocking
                        + ',' + ScoutingCommentsString;

                MultiFormatWriter writer = new MultiFormatWriter();
                try {
                    BitMatrix matrix = writer.encode(finalQrOutput, BarcodeFormat.QR_CODE, 330, 330);
                    BarcodeEncoder encoder = new BarcodeEncoder();
                    Bitmap bitmap = encoder.createBitmap(matrix);
                    qrcodePic.setImageBitmap(bitmap);
                    qrcodePic.setVisibility(View.VISIBLE);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}