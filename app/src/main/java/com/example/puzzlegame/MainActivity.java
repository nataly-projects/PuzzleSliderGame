package com.example.puzzlegame;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private TextView  easy, medium, hard, expert;
    private AdView adView;
    private InterstitialAd interstitialAd;
    private String activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Puzzle Game");

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Constants.SCRREN_WIDTH = metrics.widthPixels;

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        easy = findViewById(R.id.easy);
        medium = findViewById(R.id.medium);
        hard = findViewById(R.id.hard);
        expert = findViewById(R.id.expert);

        interstitialAd.setAdListener(new AdListener()
                                     {
                                         @Override
                                         public void onAdClosed() {
                                             interstitialAd.loadAd(new AdRequest.Builder().build());
                                             Log.d("Mydebug", "activity: " + activity)
;                                             startLevelActivity();
                                             //startActivity(new Intent(MainActivity.this, GameActivity.class));
                                         }
                                     }

        );

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity = "easy";
                if(interstitialAd.isLoaded()){
                    interstitialAd.show();
                }


                //startActivity(new Intent(MainActivity.this, EasyLevelActivity.class));
            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, MediumLevelActivity.class));
                activity = "medium";
                if(interstitialAd.isLoaded()){
                    interstitialAd.show();
                }

            }
        });

        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity = "hard";
                if(interstitialAd.isLoaded()){
                    interstitialAd.show();
                }
                //startActivity(new Intent(MainActivity.this, HardLevelActivity.class));
            }
        });

        expert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity = "expert";
                if(interstitialAd.isLoaded()){
                    interstitialAd.show();
                }
                //startActivity(new Intent(MainActivity.this, ExpertLevelActivity.class));
            }
        });
    }

    private void startLevelActivity(){

        switch (activity){
            case "easy":
                startActivity(new Intent(MainActivity.this, EasyLevelActivity.class));
                break;

            case "medium":
                startActivity(new Intent(MainActivity.this, MediumLevelActivity.class));
                break;

            case "hard":
                startActivity(new Intent(MainActivity.this, HardLevelActivity.class));
                break;

            case "expert":
                startActivity(new Intent(MainActivity.this, ExpertLevelActivity.class));
                break;
        }
    }
}