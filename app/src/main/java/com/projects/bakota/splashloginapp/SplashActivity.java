package com.projects.bakota.splashloginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    public static final String MY_PREFS = "SharedPreferences";
    public static final String FIRST_TIME = "SharedPreferencesFirst";
    private boolean firtsTime = false ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();


        Thread t = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            wait(15000);
                            finish();
                        } catch (Exception e) {

                        }
                    }
                }

        );

        t.start();

        startActivity(new Intent(SplashActivity.this, MainActivity.class));

       // TentativeLoginDirect();
    }

    public boolean firstTime(){
        SharedPreferences prefs = getSharedPreferences(FIRST_TIME, 0);
        return prefs.getBoolean("firstTime", false);

    }

    private void TentativeLoginDirect() {
        SharedPreferences prefs = getSharedPreferences(MY_PREFS, 0);
        final   String thisUsername = prefs.getString("username", "");
        final  String thisPassword = prefs.getString("password", "");
        boolean thisRemember = prefs.getBoolean("remember", false);
        if(firstTime()) {

            //c'est sa première fois d'ouvrir l'appli
            //on le renvoi vers la page d'inscription
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        }else if(thisRemember){

            // il veut rester connecter
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        } else {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        }
    }



}
