package com.example.puzzlegame;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class HardLevelActivity extends AppCompatActivity implements RewardedVideoAdListener {

        private CardView c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14,
             c15, c16, c17, c18, c19, c20, c21, c22, c23, c24;

        private TextView n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14,
                n15, n16, n17, n18, n19, n20, n21, n22, n23, n24;

        private TextView toUnlock2, toUnlock3, toUnlock4, toUnlock5, toUnlock6, toUnlock7, toUnlock8, toUnlock9,
            toUnlock10, toUnlock11, toUnlock12, toUnlock13, toUnlock14, toUnlock15, toUnlock16, toUnlock17,
            toUnlock18, toUnlock19, toUnlock20, toUnlock21, toUnlock22, toUnlock23, toUnlock24;

        private TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14,
                t15, t16, t17, t18, t19, t20, t21, t22, t23, t24, counterText, starsText;

        private ImageView i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14,
                i15, i16, i17, i18, i19, i20, i21, i22, i23, i24;

        private LinearLayout l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17,
            l18, l19, l20, l21, l22, l23, l24;

        private int counter, stars;
        private Dialog dialog;
        private RewardedVideoAd rewardAd;
        private InterstitialAd interstitialAd;
        private String level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_level);

        final SharedPreferences sp = getSharedPreferences("MyPref", 0);
        stars = sp.getInt("hard_counter_stars", 0);
        dialog = new Dialog(this);
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        rewardAd = MobileAds.getRewardedVideoAdInstance(this);
        rewardAd.setRewardedVideoAdListener(this);
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        initUI();

        interstitialAd.setAdListener(new AdListener()
                                     {
                                         @Override
                                         public void onAdClosed() {
                                             interstitialAd.loadAd(new AdRequest.Builder().build());
                                             startLevelActivity();
                                         }
                                     }

        );

        starsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.star_popup_layout);
                dialog.setCancelable(false);
                ImageView closeButton = dialog.findViewById(R.id.close_button);
                TextView rate3 = dialog.findViewById(R.id.text_rate3);
                TextView rate4 = dialog.findViewById(R.id.text_rate4);
                TextView rate5 = dialog.findViewById(R.id.text_rate5);
                rate3.setText("if time >= 02:30 minutes.");
                rate4.setText("if 01:40m <= time < 02:30 minutes.");
                rate5.setText("if time < 01:40 minutes.");
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level = "1";
                if(interstitialAd.isLoaded()){
                    interstitialAd.show();
                }
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp.getInt("hard_counter_stars", 0) >= 4){
                    level = "2";
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                }
                else{
                    dialog.setContentView(R.layout.level_popup);
                    dialog.setCancelable(false);
                    ImageView closeButton = dialog.findViewById(R.id.close_button);
                    TextView text = dialog.findViewById(R.id.message);
                    TextView close = dialog.findViewById(R.id.close);
                    TextView star = dialog.findViewById(R.id.star);
                    String message = "You need " + (Integer.parseInt(toUnlock2.getText().toString())- stars) + " more stars to unlock this level. To earn more stars you need to replay the levels for which you earned less than 5 stars.";
                    text.setText(message);

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    star.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //show reward ad.
                            loadRewardAd();
                        }
                    });
                    dialog.show();
                }
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp.getInt("hard_counter_stars", 0) >= 8){
                    level = "3";
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                }
                else{
                    dialog.setContentView(R.layout.level_popup);
                    dialog.setCancelable(false);
                    ImageView closeButton = dialog.findViewById(R.id.close_button);
                    TextView text = dialog.findViewById(R.id.message);
                    TextView close = dialog.findViewById(R.id.close);
                    TextView star = dialog.findViewById(R.id.star);
                    String message = "You need " + (Integer.parseInt(toUnlock3.getText().toString())- stars) + " more stars to unlock this level. To earn more stars you need to replay the levels for which you earned less than 5 stars.";
                    text.setText(message);

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    star.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //show reward ad.
                            loadRewardAd();
                        }
                    });
                    dialog.show();
                }
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp.getInt("hard_counter_stars", 0) >= 12){
                    level = "4";
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                }
                else{
                    dialog.setContentView(R.layout.level_popup);
                    dialog.setCancelable(false);
                    ImageView closeButton = dialog.findViewById(R.id.close_button);
                    TextView text = dialog.findViewById(R.id.message);
                    TextView close = dialog.findViewById(R.id.close);
                    TextView star = dialog.findViewById(R.id.star);
                    String message = "You need " + (Integer.parseInt(toUnlock4.getText().toString())- stars) + " more stars to unlock this level. To earn more stars you need to replay the levels for which you earned less than 5 stars.";
                    text.setText(message);

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    star.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //show reward ad.
                            loadRewardAd();
                        }
                    });
                    dialog.show();
                }
            }
        });

        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp.getInt("hard_counter_stars", 0) >= 16){
                    level = "5";
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                }
                else{
                    dialog.setContentView(R.layout.level_popup);
                    dialog.setCancelable(false);
                    ImageView closeButton = dialog.findViewById(R.id.close_button);
                    TextView text = dialog.findViewById(R.id.message);
                    TextView close = dialog.findViewById(R.id.close);
                    TextView star = dialog.findViewById(R.id.star);
                    String message = "You need " + (Integer.parseInt(toUnlock5.getText().toString())- stars) + " more stars to unlock this level. To earn more stars you need to replay the levels for which you earned less than 5 stars.";
                    text.setText(message);

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    star.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //show reward ad.
                            loadRewardAd();
                        }
                    });
                    dialog.show();
                }
            }
        });

        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp.getInt("hard_counter_stars", 0) >= 20){
                    level = "6";
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                }
                else{
                    dialog.setContentView(R.layout.level_popup);
                    dialog.setCancelable(false);
                    ImageView closeButton = dialog.findViewById(R.id.close_button);
                    TextView text = dialog.findViewById(R.id.message);
                    TextView close = dialog.findViewById(R.id.close);
                    TextView star = dialog.findViewById(R.id.star);
                    String message = "You need " + (Integer.parseInt(toUnlock6.getText().toString())- stars) + " more stars to unlock this level. To earn more stars you need to replay the levels for which you earned less than 5 stars.";
                    text.setText(message);

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    star.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //show reward ad.
                            loadRewardAd();
                        }
                    });
                    dialog.show();
                }
            }
        });

        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp.getInt("hard_counter_stars", 0) >= 24){
                    level = "7";
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                }
                else {
                    dialog.setContentView(R.layout.level_popup);
                    dialog.setCancelable(false);
                    ImageView closeButton = dialog.findViewById(R.id.close_button);
                    TextView text = dialog.findViewById(R.id.message);
                    TextView close = dialog.findViewById(R.id.close);
                    TextView star = dialog.findViewById(R.id.star);
                    String message = "You need " + (Integer.parseInt(toUnlock7.getText().toString()) - stars) + " more stars to unlock this level. To earn more stars you need to replay the levels for which you earned less than 5 stars.";
                    text.setText(message);

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    star.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //show reward ad.
                            loadRewardAd();
                        }
                    });
                    dialog.show();
                }
            }
        });

        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp.getInt("hard_counter_stars", 0) >= 28){
                    level = "8";
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                }
                else{
                    dialog.setContentView(R.layout.level_popup);
                    dialog.setCancelable(false);
                    ImageView closeButton = dialog.findViewById(R.id.close_button);
                    TextView text = dialog.findViewById(R.id.message);
                    TextView close = dialog.findViewById(R.id.close);
                    TextView star = dialog.findViewById(R.id.star);
                    String message = "You need " + (Integer.parseInt(toUnlock8.getText().toString())- stars) + " more stars to unlock this level. To earn more stars you need to replay the levels for which you earned less than 5 stars.";
                    text.setText(message);

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    star.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //show reward ad.
                            loadRewardAd();
                        }
                    });
                    dialog.show();
                }
            }
        });

        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp.getInt("hard_counter_stars", 0) >= 32){
                    level = "9";
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                }
                else{
                    dialog.setContentView(R.layout.level_popup);
                    dialog.setCancelable(false);
                    ImageView closeButton = dialog.findViewById(R.id.close_button);
                    TextView text = dialog.findViewById(R.id.message);
                    TextView close = dialog.findViewById(R.id.close);
                    TextView star = dialog.findViewById(R.id.star);
                    String message = "You need " + (Integer.parseInt(toUnlock9.getText().toString())- stars) + " more stars to unlock this level. To earn more stars you need to replay the levels for which you earned less than 5 stars.";
                    text.setText(message);

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    star.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //show reward ad.
                            loadRewardAd();
                        }
                    });
                    dialog.show();
                }
            }
        });

        c10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp.getInt("hard_counter_stars", 0) >= 36){
                    level = "10";
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                }
                else {
                    dialog.setContentView(R.layout.level_popup);
                    dialog.setCancelable(false);
                    ImageView closeButton = dialog.findViewById(R.id.close_button);
                    TextView text = dialog.findViewById(R.id.message);
                    TextView close = dialog.findViewById(R.id.close);
                    TextView star = dialog.findViewById(R.id.star);
                    String message = "You need " + (Integer.parseInt(toUnlock10.getText().toString()) - stars) + " more stars to unlock this level. To earn more stars you need to replay the levels for which you earned less than 5 stars.";
                    text.setText(message);

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    star.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //show reward ad.
                            loadRewardAd();
                        }
                    });
                    dialog.show();
                }
            }
        });

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp.getInt("hard_counter_stars", 0) >= 40){
                    level = "11";
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                }
                else{
                    dialog.setContentView(R.layout.level_popup);
                    dialog.setCancelable(false);
                    ImageView closeButton = dialog.findViewById(R.id.close_button);
                    TextView text = dialog.findViewById(R.id.message);
                    TextView close = dialog.findViewById(R.id.close);
                    TextView star = dialog.findViewById(R.id.star);
                    String message = "You need " + (Integer.parseInt(toUnlock11.getText().toString()) - stars) + " more stars to unlock this level. To earn more stars you need to replay the levels for which you earned less than 5 stars.";
                    text.setText(message);

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    star.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //show reward ad.
                            loadRewardAd();
                        }
                    });
                    dialog.show();
                }
            }
        });

        c12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp.getInt("hard_counter_stars", 0) >= 44){
                    level = "12";
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                }
                else{
                    dialog.setContentView(R.layout.level_popup);
                    dialog.setCancelable(false);
                    ImageView closeButton = dialog.findViewById(R.id.close_button);
                    TextView text = dialog.findViewById(R.id.message);
                    TextView close = dialog.findViewById(R.id.close);
                    TextView star = dialog.findViewById(R.id.star);
                    String message = "You need " + (Integer.parseInt(toUnlock12.getText().toString()) - stars) + " more stars to unlock this level. To earn more stars you need to replay the levels for which you earned less than 5 stars.";
                    text.setText(message);

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    star.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //show reward ad.
                            loadRewardAd();
                        }
                    });
                    dialog.show();
                }
            }
        });

        c13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp.getInt("hard_counter_stars", 0) >= 48){
                    level = "13";
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                }
                else{
                    dialog.setContentView(R.layout.level_popup);
                    dialog.setCancelable(false);
                    ImageView closeButton = dialog.findViewById(R.id.close_button);
                    TextView text = dialog.findViewById(R.id.message);
                    TextView close = dialog.findViewById(R.id.close);
                    TextView star = dialog.findViewById(R.id.star);
                    String message = "You need " + (Integer.parseInt(toUnlock13.getText().toString()) - stars) + " more stars to unlock this level. To earn more stars you need to replay the levels for which you earned less than 5 stars.";
                    text.setText(message);

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    star.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //show reward ad.
                            loadRewardAd();
                        }
                    });
                    dialog.show();
                }
            }
        });

        c14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp.getInt("hard_counter_stars", 0) >= 52){
                    level = "14";
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                }
                else{
                    dialog.setContentView(R.layout.level_popup);
                    dialog.setCancelable(false);
                    ImageView closeButton = dialog.findViewById(R.id.close_button);
                    TextView text = dialog.findViewById(R.id.message);
                    TextView close = dialog.findViewById(R.id.close);
                    TextView star = dialog.findViewById(R.id.star);
                    String message = "You need " + (Integer.parseInt(toUnlock14.getText().toString()) - stars) + " more stars to unlock this level. To earn more stars you need to replay the levels for which you earned less than 5 stars.";
                    text.setText(message);

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    star.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //show reward ad.
                            loadRewardAd();
                        }
                    });
                    dialog.show();
                }
            }
        });

        c15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp.getInt("hard_counter_stars", 0) >= 56){
                    level = "15";
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                }
                else{
                    dialog.setContentView(R.layout.level_popup);
                    dialog.setCancelable(false);
                    ImageView closeButton = dialog.findViewById(R.id.close_button);
                    TextView text = dialog.findViewById(R.id.message);
                    TextView close = dialog.findViewById(R.id.close);
                    TextView star = dialog.findViewById(R.id.star);
                    String message = "You need " + (Integer.parseInt(toUnlock15.getText().toString()) - stars) + " more stars to unlock this level. To earn more stars you need to replay the levels for which you earned less than 5 stars.";
                    text.setText(message);

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    star.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //show reward ad.
                            loadRewardAd();
                        }
                    });
                    dialog.show();
                }
            }
        });

        c16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp.getInt("hard_counter_stars", 0) >= 60){
                    level = "16";
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                }
                else{
                    dialog.setContentView(R.layout.level_popup);
                    dialog.setCancelable(false);
                    ImageView closeButton = dialog.findViewById(R.id.close_button);
                    TextView text = dialog.findViewById(R.id.message);
                    TextView close = dialog.findViewById(R.id.close);
                    TextView star = dialog.findViewById(R.id.star);
                    String message = "You need " + (Integer.parseInt(toUnlock16.getText().toString()) - stars) + " more stars to unlock this level. To earn more stars you need to replay the levels for which you earned less than 5 stars.";
                    text.setText(message);

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    star.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //show reward ad.
                            loadRewardAd();
                        }
                    });
                    dialog.show();
                }
            }
        });

        c17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp.getInt("hard_counter_stars", 0) >= 64){
                    level = "17";
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                }
                else{
                    dialog.setContentView(R.layout.level_popup);
                    dialog.setCancelable(false);
                    ImageView closeButton = dialog.findViewById(R.id.close_button);
                    TextView text = dialog.findViewById(R.id.message);
                    TextView close = dialog.findViewById(R.id.close);
                    TextView star = dialog.findViewById(R.id.star);
                    String message = "You need " + (Integer.parseInt(toUnlock17.getText().toString()) - stars) + " more stars to unlock this level. To earn more stars you need to replay the levels for which you earned less than 5 stars.";
                    text.setText(message);

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    star.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //show reward ad.
                            loadRewardAd();
                        }
                    });
                    dialog.show();
                }
            }
        });

        c18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp.getInt("hard_counter_stars", 0) >= 68){
                    level = "18";
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                }
                else{
                    dialog.setContentView(R.layout.level_popup);
                    dialog.setCancelable(false);
                    ImageView closeButton = dialog.findViewById(R.id.close_button);
                    TextView text = dialog.findViewById(R.id.message);
                    TextView close = dialog.findViewById(R.id.close);
                    TextView star = dialog.findViewById(R.id.star);
                    String message = "You need " + (Integer.parseInt(toUnlock18.getText().toString()) - stars) + " more stars to unlock this level. To earn more stars you need to replay the levels for which you earned less than 5 stars.";
                    text.setText(message);

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    star.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //show reward ad.
                            loadRewardAd();
                        }
                    });
                    dialog.show();
                }
            }
        });

        c19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp.getInt("hard_counter_stars", 0) >= 72){
                    level = "19";
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                }
                else{
                    dialog.setContentView(R.layout.level_popup);
                    dialog.setCancelable(false);
                    ImageView closeButton = dialog.findViewById(R.id.close_button);
                    TextView text = dialog.findViewById(R.id.message);
                    TextView close = dialog.findViewById(R.id.close);
                    TextView star = dialog.findViewById(R.id.star);
                    String message = "You need " + (Integer.parseInt(toUnlock19.getText().toString()) - stars) + " more stars to unlock this level. To earn more stars you need to replay the levels for which you earned less than 5 stars.";
                    text.setText(message);

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    star.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //show reward ad.
                            loadRewardAd();
                        }
                    });
                    dialog.show();
                }
            }
        });

        c20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp.getInt("hard_counter_stars", 0) >= 76){
                    level = "20";
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                }
                else{
                    dialog.setContentView(R.layout.level_popup);
                    dialog.setCancelable(false);
                    ImageView closeButton = dialog.findViewById(R.id.close_button);
                    TextView text = dialog.findViewById(R.id.message);
                    TextView close = dialog.findViewById(R.id.close);
                    TextView star = dialog.findViewById(R.id.star);
                    String message = "You need " + (Integer.parseInt(toUnlock20.getText().toString()) - stars) + " more stars to unlock this level. To earn more stars you need to replay the levels for which you earned less than 5 stars.";
                    text.setText(message);

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    star.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //show reward ad.
                            loadRewardAd();
                        }
                    });
                    dialog.show();
                }
            }
        });

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp.getInt("hard_counter_stars", 0) >= 80){
                    level = "21";
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                }
                else{
                    dialog.setContentView(R.layout.level_popup);
                    dialog.setCancelable(false);
                    ImageView closeButton = dialog.findViewById(R.id.close_button);
                    TextView text = dialog.findViewById(R.id.message);
                    TextView close = dialog.findViewById(R.id.close);
                    TextView star = dialog.findViewById(R.id.star);
                    String message = "You need " + (Integer.parseInt(toUnlock21.getText().toString()) - stars) + " more stars to unlock this level. To earn more stars you need to replay the levels for which you earned less than 5 stars.";
                    text.setText(message);

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    star.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //show reward ad.
                            loadRewardAd();
                        }
                    });
                    dialog.show();
                }
            }
        });

        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp.getInt("hard_counter_stars", 0) >= 84){
                    level = "22";
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                }
                else{
                    dialog.setContentView(R.layout.level_popup);
                    dialog.setCancelable(false);
                    ImageView closeButton = dialog.findViewById(R.id.close_button);
                    TextView text = dialog.findViewById(R.id.message);
                    TextView close = dialog.findViewById(R.id.close);
                    TextView star = dialog.findViewById(R.id.star);
                    String message = "You need " + (Integer.parseInt(toUnlock22.getText().toString()) - stars) + " more stars to unlock this level. To earn more stars you need to replay the levels for which you earned less than 5 stars.";
                    text.setText(message);

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    star.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //show reward ad.
                            loadRewardAd();
                        }
                    });
                    dialog.show();
                }
            }
        });

        c23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp.getInt("hard_counter_stars", 0) >= 88){
                    level = "23";
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                }
                else{
                    dialog.setContentView(R.layout.level_popup);
                    dialog.setCancelable(false);
                    ImageView closeButton = dialog.findViewById(R.id.close_button);
                    TextView text = dialog.findViewById(R.id.message);
                    TextView close = dialog.findViewById(R.id.close);
                    TextView star = dialog.findViewById(R.id.star);
                    String message = "You need " + (Integer.parseInt(toUnlock23.getText().toString()) - stars) + " more stars to unlock this level. To earn more stars you need to replay the levels for which you earned less than 5 stars.";
                    text.setText(message);

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    star.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //show reward ad.
                            loadRewardAd();
                        }
                    });
                    dialog.show();
                }
            }
        });

        c24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp.getInt("hard_counter_stars", 0) >= 92){
                    level = "24";
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                }
                else{
                    dialog.setContentView(R.layout.level_popup);
                    dialog.setCancelable(false);
                    ImageView closeButton = dialog.findViewById(R.id.close_button);
                    TextView text = dialog.findViewById(R.id.message);
                    TextView close = dialog.findViewById(R.id.close);
                    TextView star = dialog.findViewById(R.id.star);
                    String message = "You need " + (Integer.parseInt(toUnlock24.getText().toString()) - stars) + " more stars to unlock this level. To earn more stars you need to replay the levels for which you earned less than 5 stars.";
                    text.setText(message);

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    star.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //show reward ad.
                            loadRewardAd();
                        }
                    });
                    dialog.show();
                }
            }
        });

    }

    private void initUI(){

        counterText = findViewById(R.id.counter);
        starsText = findViewById(R.id.stars);
        c1 = findViewById(R.id.c1);
        t1 = findViewById(R.id.t1);
        l1 = findViewById(R.id.rate1);

        c2 = findViewById(R.id.c2);
        n2 = findViewById(R.id.n2);
        t2 = findViewById(R.id.t2);
        i2 = findViewById(R.id.i2);
        l2 = findViewById(R.id.rate2);
        toUnlock2 = findViewById(R.id.toUnlock2);

        c3 = findViewById(R.id.c3);
        n3 = findViewById(R.id.n3);
        t3 = findViewById(R.id.t3);
        i3 = findViewById(R.id.i3);
        l3 = findViewById(R.id.rate3);
        toUnlock3 = findViewById(R.id.toUnlock3);

        c4 = findViewById(R.id.c4);
        n4 = findViewById(R.id.n4);
        t4 = findViewById(R.id.t4);
        i4 = findViewById(R.id.i4);
        l4 = findViewById(R.id.rate4);
        toUnlock4 = findViewById(R.id.toUnlock4);

        c5 = findViewById(R.id.c5);
        n5 = findViewById(R.id.n5);
        t5 = findViewById(R.id.t5);
        i5 = findViewById(R.id.i5);
        l5 = findViewById(R.id.rate5);
        toUnlock5 = findViewById(R.id.toUnlock5);

        c6 = findViewById(R.id.c6);
        n6 = findViewById(R.id.n6);
        t6 = findViewById(R.id.t6);
        i6 = findViewById(R.id.i6);
        l6 = findViewById(R.id.rate6);
        toUnlock6 = findViewById(R.id.toUnlock6);

        c7 = findViewById(R.id.c7);
        n7 = findViewById(R.id.n7);
        t7 = findViewById(R.id.t7);
        i7 = findViewById(R.id.i7);
        l7 = findViewById(R.id.rate7);
        toUnlock7 = findViewById(R.id.toUnlock7);

        c8 = findViewById(R.id.c8);
        n8 = findViewById(R.id.n8);
        t8 = findViewById(R.id.t8);
        i8 = findViewById(R.id.i8);
        l8 = findViewById(R.id.rate8);
        toUnlock8 = findViewById(R.id.toUnlock8);

        c9 = findViewById(R.id.c9);
        t9 = findViewById(R.id.t9);
        n9 = findViewById(R.id.n9);
        i9 = findViewById(R.id.i9);
        l9 = findViewById(R.id.rate9);
        toUnlock9 = findViewById(R.id.toUnlock9);

        c10 = findViewById(R.id.c10);
        t10 = findViewById(R.id.t10);
        n10 = findViewById(R.id.n10);
        i10 = findViewById(R.id.i10);
        l10 = findViewById(R.id.rate10);
        toUnlock10 = findViewById(R.id.toUnlock10);

        c11 = findViewById(R.id.c11);
        t11 = findViewById(R.id.t11);
        n11 = findViewById(R.id.n11);
        i11 = findViewById(R.id.i11);
        l11 = findViewById(R.id.rate11);
        toUnlock11 = findViewById(R.id.toUnlock11);

        c12 = findViewById(R.id.c12);
        t12 = findViewById(R.id.t12);
        n12 = findViewById(R.id.n12);
        i12 = findViewById(R.id.i12);
        l12 = findViewById(R.id.rate12);
        toUnlock12 = findViewById(R.id.toUnlock12);

        c13 = findViewById(R.id.c13);
        t13 = findViewById(R.id.t13);
        n13 = findViewById(R.id.n13);
        i13 = findViewById(R.id.i13);
        l13 = findViewById(R.id.rate13);
        toUnlock13 = findViewById(R.id.toUnlock13);

        c14 = findViewById(R.id.c14);
        t14 = findViewById(R.id.t14);
        n14 = findViewById(R.id.n14);
        i14 = findViewById(R.id.i14);
        l14 = findViewById(R.id.rate14);
        toUnlock14 = findViewById(R.id.toUnlock14);

        c15 = findViewById(R.id.c15);
        t15 = findViewById(R.id.t15);
        n15 = findViewById(R.id.n15);
        i15 = findViewById(R.id.i15);
        l15 = findViewById(R.id.rate15);
        toUnlock15 = findViewById(R.id.toUnlock15);

        c16 = findViewById(R.id.c16);
        t16 = findViewById(R.id.t16);
        n16 = findViewById(R.id.n16);
        i16 = findViewById(R.id.i16);
        l16 = findViewById(R.id.rate16);
        toUnlock16 = findViewById(R.id.toUnlock16);

        c17 = findViewById(R.id.c17);
        t17 = findViewById(R.id.t17);
        n17 = findViewById(R.id.n17);
        i17 = findViewById(R.id.i17);
        l17 = findViewById(R.id.rate17);
        toUnlock17 = findViewById(R.id.toUnlock17);

        c18 = findViewById(R.id.c18);
        t18 = findViewById(R.id.t18);
        n18 = findViewById(R.id.n18);
        i18 = findViewById(R.id.i18);
        l18 = findViewById(R.id.rate18);
        toUnlock18 = findViewById(R.id.toUnlock18);

        c19 = findViewById(R.id.c19);
        t19 = findViewById(R.id.t19);
        n19 = findViewById(R.id.n19);
        i19 = findViewById(R.id.i19);
        l19 = findViewById(R.id.rate19);
        toUnlock19 = findViewById(R.id.toUnlock19);

        c20 = findViewById(R.id.c20);
        t20 = findViewById(R.id.t20);
        n20 = findViewById(R.id.n20);
        i20 = findViewById(R.id.i20);
        l20 = findViewById(R.id.rate20);
        toUnlock20 = findViewById(R.id.toUnlock20);

        c21 = findViewById(R.id.c21);
        t21 = findViewById(R.id.t21);
        n21 = findViewById(R.id.n21);
        i21 = findViewById(R.id.i21);
        l21 = findViewById(R.id.rate21);
        toUnlock21 = findViewById(R.id.toUnlock21);

        c22 = findViewById(R.id.c22);
        t22 = findViewById(R.id.t22);
        n22 = findViewById(R.id.n22);
        i22 = findViewById(R.id.i22);
        l22 = findViewById(R.id.rate22);
        toUnlock22 = findViewById(R.id.toUnlock22);

        c23 = findViewById(R.id.c23);
        t23 = findViewById(R.id.t23);
        n23 = findViewById(R.id.n23);
        i23 = findViewById(R.id.i23);
        l23 = findViewById(R.id.rate23);
        toUnlock23 = findViewById(R.id.toUnlock23);

        c24 = findViewById(R.id.c24);
        t24 = findViewById(R.id.t24);
        n24 = findViewById(R.id.n24);
        i24 = findViewById(R.id.i24);
        l24 = findViewById(R.id.rate24);
        toUnlock24 = findViewById(R.id.toUnlock24);

        readFromSP();
    }

    private void readFromSP(){

        SharedPreferences sp = getSharedPreferences("MyPref", 0);

        String counter_str = sp.getString("hard_counter", "00"+"/"+Constants.HARD_LEVELS);
        counterText.setText(counter_str);

        int stars = sp.getInt("hard_counter_stars", 0);
        starsText.setText(String.valueOf(stars));

        int c1Sp = sp.getInt("hc1", 0);
        if(stars >= 4){
            n2.setVisibility(View.VISIBLE);
            i2.setVisibility(View.INVISIBLE);
            toUnlock2.setVisibility(View.INVISIBLE);
        }
        if(c1Sp == 1){
            t1.setVisibility(View.VISIBLE);
            String time = sp.getString("hc1_time_str", "");
            t1.setText(time);
            int c1_stars = sp.getInt("hard_c1_stars", 0);
            ImageView c1_star5 = findViewById(R.id.c1_star5);
            ImageView c1_star4 = findViewById(R.id.c1_star4);
            switch (c1_stars){
                case 5:
                    l1.setVisibility(View.VISIBLE);
                    c1_star4.setImageResource(R.drawable.ic_full_star);
                    c1_star5.setImageResource(R.drawable.ic_full_star);
                    break;

                case 4:
                    l1.setVisibility(View.VISIBLE);
                    c1_star5.setImageResource(R.drawable.ic_empty_star);
                    c1_star4.setImageResource(R.drawable.ic_full_star);
                    break;

                case 3:
                    l1.setVisibility(View.VISIBLE);
                    c1_star4.setImageResource(R.drawable.ic_empty_star);
                    c1_star5.setImageResource(R.drawable.ic_empty_star);
                    break;
            }
        }

        int c2Sp = sp.getInt("hc2", 0);
        if(stars >= 8){
            n3.setVisibility(View.VISIBLE);
            i3.setVisibility(View.INVISIBLE);
            toUnlock3.setVisibility(View.INVISIBLE);
        }
        if(c2Sp == 1){
            t2.setVisibility(View.VISIBLE);
            String time = sp.getString("hc2_time_str", "");
            t2.setText(time);
            int c2_stars = sp.getInt("hard_c2_stars", 0);
            ImageView c2_star5 = findViewById(R.id.c2_star5);
            ImageView c2_star4 = findViewById(R.id.c2_star4);
            switch (c2_stars){
                case 5:
                    l2.setVisibility(View.VISIBLE);
                    c2_star4.setImageResource(R.drawable.ic_full_star);
                    c2_star5.setImageResource(R.drawable.ic_full_star);
                    break;

                case 4:
                    l2.setVisibility(View.VISIBLE);
                    c2_star5.setImageResource(R.drawable.ic_empty_star);
                    c2_star4.setImageResource(R.drawable.ic_full_star);
                    break;

                case 3:
                    l2.setVisibility(View.VISIBLE);
                    c2_star4.setImageResource(R.drawable.ic_empty_star);
                    c2_star5.setImageResource(R.drawable.ic_empty_star);
                    break;
            }
        }

        int c3Sp = sp.getInt("hc3", 0);
        if(stars >= 12){
            n4.setVisibility(View.VISIBLE);
            i4.setVisibility(View.INVISIBLE);
            toUnlock4.setVisibility(View.INVISIBLE);
        }
        if(c3Sp == 1){
            t3.setVisibility(View.VISIBLE);
            String time = sp.getString("hc3_time_str", "");
            t3.setText(time);
            int c3_stars = sp.getInt("hard_c3_stars", 0);
            ImageView c3_star5 = findViewById(R.id.c3_star5);
            ImageView c3_star4 = findViewById(R.id.c3_star4);
            switch (c3_stars){
                case 5:
                    l3.setVisibility(View.VISIBLE);
                    c3_star4.setImageResource(R.drawable.ic_full_star);
                    c3_star5.setImageResource(R.drawable.ic_full_star);
                    break;

                case 4:
                    l3.setVisibility(View.VISIBLE);
                    c3_star5.setImageResource(R.drawable.ic_empty_star);
                    c3_star4.setImageResource(R.drawable.ic_full_star);
                    break;

                case 3:
                    l3.setVisibility(View.VISIBLE);
                    c3_star4.setImageResource(R.drawable.ic_empty_star);
                    c3_star5.setImageResource(R.drawable.ic_empty_star);
                    break;
            }
        }

        int c4Sp = sp.getInt("hc4", 0);
        if(stars >= 16){
            n5.setVisibility(View.VISIBLE);
            i5.setVisibility(View.INVISIBLE);
            toUnlock5.setVisibility(View.INVISIBLE);
        }
        if(c4Sp == 1){
            t4.setVisibility(View.VISIBLE);
            String time = sp.getString("hc4_time_str", "");
            t4.setText(time);
            int c4_stars = sp.getInt("hard_c4_stars", 0);
            ImageView c4_star5 = findViewById(R.id.c4_star5);
            ImageView c4_star4 = findViewById(R.id.c4_star4);
            switch (c4_stars){
                case 5:
                    l4.setVisibility(View.VISIBLE);
                    c4_star4.setImageResource(R.drawable.ic_full_star);
                    c4_star5.setImageResource(R.drawable.ic_full_star);
                    break;

                case 4:
                    l4.setVisibility(View.VISIBLE);
                    c4_star5.setImageResource(R.drawable.ic_empty_star);
                    c4_star4.setImageResource(R.drawable.ic_full_star);
                    break;

                case 3:
                    l4.setVisibility(View.VISIBLE);
                    c4_star4.setImageResource(R.drawable.ic_empty_star);
                    c4_star5.setImageResource(R.drawable.ic_empty_star);
                    break;
            }
        }

        int c5Sp = sp.getInt("hc5", 0);
        if(stars >= 20){
            n6.setVisibility(View.VISIBLE);
            i6.setVisibility(View.INVISIBLE);
            toUnlock6.setVisibility(View.INVISIBLE);
        }
        if(c5Sp == 1){
            t5.setVisibility(View.VISIBLE);
            String time = sp.getString("hc5_time_str", "");
            t5.setText(time);
            int c5_stars = sp.getInt("hard_c5_stars", 0);
            ImageView c5_star5 = findViewById(R.id.c5_star5);
            ImageView c5_star4 = findViewById(R.id.c5_star4);
            switch (c5_stars){
                case 5:
                    l5.setVisibility(View.VISIBLE);
                    c5_star4.setImageResource(R.drawable.ic_full_star);
                    c5_star5.setImageResource(R.drawable.ic_full_star);
                    break;

                case 4:
                    l5.setVisibility(View.VISIBLE);
                    c5_star5.setImageResource(R.drawable.ic_empty_star);
                    c5_star4.setImageResource(R.drawable.ic_full_star);
                    break;

                case 3:
                    l5.setVisibility(View.VISIBLE);
                    c5_star4.setImageResource(R.drawable.ic_empty_star);
                    c5_star5.setImageResource(R.drawable.ic_empty_star);
                    break;
            }
        }

        int c6Sp = sp.getInt("hc6", 0);
        if(stars >= 24){
            n7.setVisibility(View.VISIBLE);
            i7.setVisibility(View.INVISIBLE);
            toUnlock7.setVisibility(View.INVISIBLE);
        }
        if(c6Sp == 1){
            t6.setVisibility(View.VISIBLE);
            String time = sp.getString("hc6_time_str", "");
            t6.setText(time);
            int c6_stars = sp.getInt("hard_c6_stars", 0);
            ImageView c6_star5 = findViewById(R.id.c6_star5);
            ImageView c6_star4 = findViewById(R.id.c6_star4);
            switch (c6_stars){
                case 5:
                    l6.setVisibility(View.VISIBLE);
                    c6_star4.setImageResource(R.drawable.ic_full_star);
                    c6_star5.setImageResource(R.drawable.ic_full_star);
                    break;

                case 4:
                    l6.setVisibility(View.VISIBLE);
                    c6_star5.setImageResource(R.drawable.ic_empty_star);
                    c6_star4.setImageResource(R.drawable.ic_full_star);
                    break;

                case 3:
                    l6.setVisibility(View.VISIBLE);
                    c6_star4.setImageResource(R.drawable.ic_empty_star);
                    c6_star5.setImageResource(R.drawable.ic_empty_star);
                    break;
            }
        }

        int c7Sp = sp.getInt("hc7", 0);
        if(stars >= 28){
            n8.setVisibility(View.VISIBLE);
            i8.setVisibility(View.INVISIBLE);
            toUnlock8.setVisibility(View.INVISIBLE);
        }
        if(c7Sp == 1){
            t7.setVisibility(View.VISIBLE);
            String time = sp.getString("hc7_time_str", "");
            t7.setText(time);
            int c7_stars = sp.getInt("hard_c7_stars", 0);
            ImageView c7_star5 = findViewById(R.id.c7_star5);
            ImageView c7_star4 = findViewById(R.id.c7_star4);
            switch (c7_stars){
                case 5:
                    l7.setVisibility(View.VISIBLE);
                    c7_star4.setImageResource(R.drawable.ic_full_star);
                    c7_star5.setImageResource(R.drawable.ic_full_star);
                    break;

                case 4:
                    l7.setVisibility(View.VISIBLE);
                    c7_star5.setImageResource(R.drawable.ic_empty_star);
                    c7_star4.setImageResource(R.drawable.ic_full_star);
                    break;

                case 3:
                    l7.setVisibility(View.VISIBLE);
                    c7_star4.setImageResource(R.drawable.ic_empty_star);
                    c7_star5.setImageResource(R.drawable.ic_empty_star);
                    break;
            }
        }

        int c8Sp = sp.getInt("hc8", 0);
        if(stars >= 32){
            n9.setVisibility(View.VISIBLE);
            i9.setVisibility(View.INVISIBLE);
            toUnlock9.setVisibility(View.INVISIBLE);
        }
        if(c8Sp == 1){
            t8.setVisibility(View.VISIBLE);
            String time = sp.getString("hc8_time_str", "");
            t8.setText(time);
            int c8_stars = sp.getInt("hard_c8_stars", 0);
            ImageView c8_star5 = findViewById(R.id.c8_star5);
            ImageView c8_star4 = findViewById(R.id.c8_star4);
            switch (c8_stars){
                case 5:
                    l8.setVisibility(View.VISIBLE);
                    c8_star4.setImageResource(R.drawable.ic_full_star);
                    c8_star5.setImageResource(R.drawable.ic_full_star);
                    break;

                case 4:
                    l8.setVisibility(View.VISIBLE);
                    c8_star5.setImageResource(R.drawable.ic_empty_star);
                    c8_star4.setImageResource(R.drawable.ic_full_star);
                    break;

                case 3:
                    l8.setVisibility(View.VISIBLE);
                    c8_star4.setImageResource(R.drawable.ic_empty_star);
                    c8_star5.setImageResource(R.drawable.ic_empty_star);
                    break;
            }
        }

        int c9Sp = sp.getInt("hc9", 0);
        if(stars >= 36){
            n10.setVisibility(View.VISIBLE);
            i10.setVisibility(View.INVISIBLE);
            toUnlock10.setVisibility(View.INVISIBLE);
        }
        if(c9Sp == 1){
            t9.setVisibility(View.VISIBLE);
            String time = sp.getString("hc9_time_str", "");
            t9.setText(time);
            int c9_stars = sp.getInt("hard_c9_stars", 0);
            ImageView c9_star5 = findViewById(R.id.c9_star5);
            ImageView c9_star4 = findViewById(R.id.c9_star4);
            switch (c9_stars){
                case 5:
                    l9.setVisibility(View.VISIBLE);
                    c9_star4.setImageResource(R.drawable.ic_full_star);
                    c9_star5.setImageResource(R.drawable.ic_full_star);
                    break;

                case 4:
                    l9.setVisibility(View.VISIBLE);
                    c9_star5.setImageResource(R.drawable.ic_empty_star);
                    c9_star4.setImageResource(R.drawable.ic_full_star);
                    break;

                case 3:
                    l9.setVisibility(View.VISIBLE);
                    c9_star4.setImageResource(R.drawable.ic_empty_star);
                    c9_star5.setImageResource(R.drawable.ic_empty_star);
                    break;
            }
        }

        int c10Sp = sp.getInt("hc10", 0);
        if(stars >= 40){
            n11.setVisibility(View.VISIBLE);
            i11.setVisibility(View.INVISIBLE);
            toUnlock11.setVisibility(View.INVISIBLE);
        }
        if(c10Sp == 1){
            t10.setVisibility(View.VISIBLE);
            String time = sp.getString("hc10_time_str", "");
            t10.setText(time);
            int c10_stars = sp.getInt("hard_c10_stars", 0);
            ImageView c10_star5 = findViewById(R.id.c10_star5);
            ImageView c10_star4 = findViewById(R.id.c10_star4);
            switch (c10_stars){
                case 5:
                    l10.setVisibility(View.VISIBLE);
                    c10_star4.setImageResource(R.drawable.ic_full_star);
                    c10_star5.setImageResource(R.drawable.ic_full_star);
                    break;

                case 4:
                    l10.setVisibility(View.VISIBLE);
                    c10_star5.setImageResource(R.drawable.ic_empty_star);
                    c10_star4.setImageResource(R.drawable.ic_full_star);
                    break;

                case 3:
                    l10.setVisibility(View.VISIBLE);
                    c10_star4.setImageResource(R.drawable.ic_empty_star);
                    c10_star5.setImageResource(R.drawable.ic_empty_star);
                    break;
            }
        }

        int c11Sp = sp.getInt("hc11", 0);
        if(stars >= 44){
            n12.setVisibility(View.VISIBLE);
            i12.setVisibility(View.INVISIBLE);
            toUnlock12.setVisibility(View.INVISIBLE);
        }
        if(c11Sp == 1){
            t11.setVisibility(View.VISIBLE);
            String time = sp.getString("hc11_time_str", "");
            t11.setText(time);
            int c11_stars = sp.getInt("hard_c11_stars", 0);
            ImageView c11_star5 = findViewById(R.id.c11_star5);
            ImageView c11_star4 = findViewById(R.id.c11_star4);
            switch (c11_stars){
                case 5:
                    l11.setVisibility(View.VISIBLE);
                    c11_star4.setImageResource(R.drawable.ic_full_star);
                    c11_star5.setImageResource(R.drawable.ic_full_star);
                    break;

                case 4:
                    l11.setVisibility(View.VISIBLE);
                    c11_star5.setImageResource(R.drawable.ic_empty_star);
                    c11_star4.setImageResource(R.drawable.ic_full_star);
                    break;

                case 3:
                    l11.setVisibility(View.VISIBLE);
                    c11_star4.setImageResource(R.drawable.ic_empty_star);
                    c11_star5.setImageResource(R.drawable.ic_empty_star);
                    break;
            }
        }

        int c12Sp = sp.getInt("hc12", 0);
        if(stars >= 48){
            n13.setVisibility(View.VISIBLE);
            i13.setVisibility(View.INVISIBLE);
            toUnlock13.setVisibility(View.INVISIBLE);
        }
        if(c12Sp == 1){
            t12.setVisibility(View.VISIBLE);
            String time = sp.getString("hc12_time_str", "");
            t12.setText(time);
            int c12_stars = sp.getInt("hard_c12_stars", 0);
            ImageView c12_star5 = findViewById(R.id.c12_star5);
            ImageView c12_star4 = findViewById(R.id.c12_star4);
            switch (c12_stars){
                case 5:
                    l12.setVisibility(View.VISIBLE);
                    c12_star4.setImageResource(R.drawable.ic_full_star);
                    c12_star5.setImageResource(R.drawable.ic_full_star);
                    break;

                case 4:
                    l12.setVisibility(View.VISIBLE);
                    c12_star5.setImageResource(R.drawable.ic_empty_star);
                    c12_star4.setImageResource(R.drawable.ic_full_star);
                    break;

                case 3:
                    l12.setVisibility(View.VISIBLE);
                    c12_star4.setImageResource(R.drawable.ic_empty_star);
                    c12_star5.setImageResource(R.drawable.ic_empty_star);
                    break;
            }
        }

        int c13Sp = sp.getInt("hc13", 0);
        if(stars >= 52){
            n14.setVisibility(View.VISIBLE);
            i14.setVisibility(View.INVISIBLE);
            toUnlock14.setVisibility(View.INVISIBLE);
        }
        if(c13Sp == 1){
            t13.setVisibility(View.VISIBLE);
            String time = sp.getString("hc13_time_str", "");
            t13.setText(time);
            int c13_stars = sp.getInt("hard_c13_stars", 0);
            ImageView c13_star5 = findViewById(R.id.c13_star5);
            ImageView c13_star4 = findViewById(R.id.c13_star4);
            switch (c13_stars){
                case 5:
                    l13.setVisibility(View.VISIBLE);
                    c13_star4.setImageResource(R.drawable.ic_full_star);
                    c13_star5.setImageResource(R.drawable.ic_full_star);
                    break;

                case 4:
                    l13.setVisibility(View.VISIBLE);
                    c13_star5.setImageResource(R.drawable.ic_empty_star);
                    c13_star4.setImageResource(R.drawable.ic_full_star);
                    break;

                case 3:
                    l13.setVisibility(View.VISIBLE);
                    c13_star4.setImageResource(R.drawable.ic_empty_star);
                    c13_star5.setImageResource(R.drawable.ic_empty_star);
                    break;
            }
        }

        int c14Sp = sp.getInt("hc14", 0);
        if(stars >= 56){
            n15.setVisibility(View.VISIBLE);
            i15.setVisibility(View.INVISIBLE);
            toUnlock15.setVisibility(View.INVISIBLE);
        }
        if(c14Sp == 1){
            t14.setVisibility(View.VISIBLE);
            String time = sp.getString("hc14_time_str", "");
            t14.setText(time);
            int c14_stars = sp.getInt("hard_c14_stars", 0);
            ImageView c14_star5 = findViewById(R.id.c14_star5);
            ImageView c14_star4 = findViewById(R.id.c14_star4);
            switch (c14_stars){
                case 5:
                    l14.setVisibility(View.VISIBLE);
                    c14_star4.setImageResource(R.drawable.ic_full_star);
                    c14_star5.setImageResource(R.drawable.ic_full_star);
                    break;

                case 4:
                    l14.setVisibility(View.VISIBLE);
                    c14_star5.setImageResource(R.drawable.ic_empty_star);
                    c14_star4.setImageResource(R.drawable.ic_full_star);
                    break;

                case 3:
                    l14.setVisibility(View.VISIBLE);
                    c14_star4.setImageResource(R.drawable.ic_empty_star);
                    c14_star5.setImageResource(R.drawable.ic_empty_star);
                    break;
            }
        }

        int c15Sp = sp.getInt("hc15", 0);
        if(stars >= 60){
            n16.setVisibility(View.VISIBLE);
            i16.setVisibility(View.INVISIBLE);
            toUnlock16.setVisibility(View.INVISIBLE);
        }
        if(c15Sp == 1){
            t15.setVisibility(View.VISIBLE);
            String time = sp.getString("hc15_time_str", "");
            t15.setText(time);
            int c15_stars = sp.getInt("hard_c15_stars", 0);
            ImageView c15_star5 = findViewById(R.id.c15_star5);
            ImageView c15_star4 = findViewById(R.id.c15_star4);
            switch (c15_stars){
                case 5:
                    l15.setVisibility(View.VISIBLE);
                    c15_star4.setImageResource(R.drawable.ic_full_star);
                    c15_star5.setImageResource(R.drawable.ic_full_star);
                    break;

                case 4:
                    l15.setVisibility(View.VISIBLE);
                    c15_star5.setImageResource(R.drawable.ic_empty_star);
                    c15_star4.setImageResource(R.drawable.ic_full_star);
                    break;

                case 3:
                    l15.setVisibility(View.VISIBLE);
                    c15_star4.setImageResource(R.drawable.ic_empty_star);
                    c15_star5.setImageResource(R.drawable.ic_empty_star);
                    break;
            }
        }

        int c16Sp = sp.getInt("hc16", 0);
        if(stars >= 64){
            n17.setVisibility(View.VISIBLE);
            i17.setVisibility(View.INVISIBLE);
            toUnlock17.setVisibility(View.INVISIBLE);
        }
        if(c16Sp == 1){
            t16.setVisibility(View.VISIBLE);
            String time = sp.getString("hc16_time_str", "");
            t16.setText(time);
            int c16_stars = sp.getInt("hard_c16_stars", 0);
            ImageView c16_star5 = findViewById(R.id.c16_star5);
            ImageView c16_star4 = findViewById(R.id.c16_star4);
            switch (c16_stars){
                case 5:
                    l16.setVisibility(View.VISIBLE);
                    c16_star4.setImageResource(R.drawable.ic_full_star);
                    c16_star5.setImageResource(R.drawable.ic_full_star);
                    break;

                case 4:
                    l16.setVisibility(View.VISIBLE);
                    c16_star5.setImageResource(R.drawable.ic_empty_star);
                    c16_star4.setImageResource(R.drawable.ic_full_star);
                    break;

                case 3:
                    l16.setVisibility(View.VISIBLE);
                    c16_star4.setImageResource(R.drawable.ic_empty_star);
                    c16_star5.setImageResource(R.drawable.ic_empty_star);
                    break;
            }
        }

        int c17Sp = sp.getInt("hc17", 0);
        if(stars >= 68){
            n18.setVisibility(View.VISIBLE);
            i18.setVisibility(View.INVISIBLE);
            toUnlock18.setVisibility(View.INVISIBLE);
        }
        if(c17Sp == 1){
            t17.setVisibility(View.VISIBLE);
            String time = sp.getString("hc17_time_str", "");
            t17.setText(time);
            int c17_stars = sp.getInt("hard_c17_stars", 0);
            ImageView c17_star5 = findViewById(R.id.c17_star5);
            ImageView c17_star4 = findViewById(R.id.c17_star4);
            switch (c17_stars){
                case 5:
                    l17.setVisibility(View.VISIBLE);
                    c17_star4.setImageResource(R.drawable.ic_full_star);
                    c17_star5.setImageResource(R.drawable.ic_full_star);
                    break;

                case 4:
                    l17.setVisibility(View.VISIBLE);
                    c17_star5.setImageResource(R.drawable.ic_empty_star);
                    c17_star4.setImageResource(R.drawable.ic_full_star);
                    break;

                case 3:
                    l17.setVisibility(View.VISIBLE);
                    c17_star4.setImageResource(R.drawable.ic_empty_star);
                    c17_star5.setImageResource(R.drawable.ic_empty_star);
                    break;
            }
        }

        int c18Sp = sp.getInt("hc18", 0);
        if(stars >= 72){
            n19.setVisibility(View.VISIBLE);
            i19.setVisibility(View.INVISIBLE);
            toUnlock19.setVisibility(View.INVISIBLE);
        }
        if(c18Sp == 1){
            t18.setVisibility(View.VISIBLE);
            String time = sp.getString("hc18_time_str", "");
            t18.setText(time);
            int c18_stars = sp.getInt("hard_c18_stars", 0);
            ImageView c18_star5 = findViewById(R.id.c18_star5);
            ImageView c18_star4 = findViewById(R.id.c18_star4);
            switch (c18_stars){
                case 5:
                    l18.setVisibility(View.VISIBLE);
                    c18_star4.setImageResource(R.drawable.ic_full_star);
                    c18_star5.setImageResource(R.drawable.ic_full_star);
                    break;

                case 4:
                    l18.setVisibility(View.VISIBLE);
                    c18_star5.setImageResource(R.drawable.ic_empty_star);
                    c18_star4.setImageResource(R.drawable.ic_full_star);
                    break;

                case 3:
                    l18.setVisibility(View.VISIBLE);
                    c18_star4.setImageResource(R.drawable.ic_empty_star);
                    c18_star5.setImageResource(R.drawable.ic_empty_star);
                    break;
            }
        }

        int c19Sp = sp.getInt("hc19", 0);
        if(stars >= 76){
            n20.setVisibility(View.VISIBLE);
            i20.setVisibility(View.INVISIBLE);
            toUnlock20.setVisibility(View.INVISIBLE);
        }
        if(c19Sp == 1){
            t19.setVisibility(View.VISIBLE);
            String time = sp.getString("hc19_time_str", "");
            t19.setText(time);
            int c19_stars = sp.getInt("hard_c19_stars", 0);
            ImageView c19_star5 = findViewById(R.id.c19_star5);
            ImageView c19_star4 = findViewById(R.id.c19_star4);
            switch (c19_stars){
                case 5:
                    l19.setVisibility(View.VISIBLE);
                    c19_star4.setImageResource(R.drawable.ic_full_star);
                    c19_star5.setImageResource(R.drawable.ic_full_star);
                    break;

                case 4:
                    l19.setVisibility(View.VISIBLE);
                    c19_star5.setImageResource(R.drawable.ic_empty_star);
                    c19_star4.setImageResource(R.drawable.ic_full_star);
                    break;

                case 3:
                    l19.setVisibility(View.VISIBLE);
                    c19_star4.setImageResource(R.drawable.ic_empty_star);
                    c19_star5.setImageResource(R.drawable.ic_empty_star);
                    break;
            }
        }

        int c20Sp = sp.getInt("hc20", 0);
        if(stars >= 80){
            n21.setVisibility(View.VISIBLE);
            i21.setVisibility(View.INVISIBLE);
            toUnlock21.setVisibility(View.INVISIBLE);
        }
        if(c20Sp == 1){
            t20.setVisibility(View.VISIBLE);
            String time = sp.getString("hc20_time_str", "");
            t20.setText(time);
            int c20_stars = sp.getInt("hard_c20_stars", 0);
            ImageView c20_star5 = findViewById(R.id.c20_star5);
            ImageView c20_star4 = findViewById(R.id.c20_star4);
            switch (c20_stars){
                case 5:
                    l20.setVisibility(View.VISIBLE);
                    c20_star4.setImageResource(R.drawable.ic_full_star);
                    c20_star5.setImageResource(R.drawable.ic_full_star);
                    break;

                case 4:
                    l20.setVisibility(View.VISIBLE);
                    c20_star5.setImageResource(R.drawable.ic_empty_star);
                    c20_star4.setImageResource(R.drawable.ic_full_star);
                    break;

                case 3:
                    l20.setVisibility(View.VISIBLE);
                    c20_star4.setImageResource(R.drawable.ic_empty_star);
                    c20_star5.setImageResource(R.drawable.ic_empty_star);
                    break;
            }
        }

        int c21Sp = sp.getInt("hc21", 0);
        if(stars >= 84){
            n22.setVisibility(View.VISIBLE);
            i22.setVisibility(View.INVISIBLE);
            toUnlock22.setVisibility(View.INVISIBLE);
        }
        if(c21Sp == 1){
            t21.setVisibility(View.VISIBLE);
            String time = sp.getString("hc21_time_str", "");
            t21.setText(time);
            int c21_stars = sp.getInt("hard_c21_stars", 0);
            ImageView c21_star5 = findViewById(R.id.c21_star5);
            ImageView c21_star4 = findViewById(R.id.c21_star4);
            switch (c21_stars){
                case 5:
                    l21.setVisibility(View.VISIBLE);
                    c21_star4.setImageResource(R.drawable.ic_full_star);
                    c21_star5.setImageResource(R.drawable.ic_full_star);
                    break;

                case 4:
                    l21.setVisibility(View.VISIBLE);
                    c21_star5.setImageResource(R.drawable.ic_empty_star);
                    c21_star4.setImageResource(R.drawable.ic_full_star);
                    break;

                case 3:
                    l21.setVisibility(View.VISIBLE);
                    c21_star4.setImageResource(R.drawable.ic_empty_star);
                    c21_star5.setImageResource(R.drawable.ic_empty_star);
                    break;
            }
        }

        int c22Sp = sp.getInt("hc22", 0);
        if(stars >= 88){
            n23.setVisibility(View.VISIBLE);
            i23.setVisibility(View.INVISIBLE);
            toUnlock23.setVisibility(View.INVISIBLE);
        }
        if(c22Sp == 1){
            t22.setVisibility(View.VISIBLE);
            String time = sp.getString("hc22_time_str", "");
            t22.setText(time);
            int c22_stars = sp.getInt("hard_c22_stars", 0);
            ImageView c22_star5 = findViewById(R.id.c22_star5);
            ImageView c22_star4 = findViewById(R.id.c22_star4);
            switch (c22_stars){
                case 5:
                    l22.setVisibility(View.VISIBLE);
                    c22_star4.setImageResource(R.drawable.ic_full_star);
                    c22_star5.setImageResource(R.drawable.ic_full_star);
                    break;

                case 4:
                    l22.setVisibility(View.VISIBLE);
                    c22_star5.setImageResource(R.drawable.ic_empty_star);
                    c22_star4.setImageResource(R.drawable.ic_full_star);
                    break;

                case 3:
                    l22.setVisibility(View.VISIBLE);
                    c22_star4.setImageResource(R.drawable.ic_empty_star);
                    c22_star5.setImageResource(R.drawable.ic_empty_star);
                    break;
            }
        }

        int c23Sp = sp.getInt("hc23", 0);
        if(stars >= 92){
            n24.setVisibility(View.VISIBLE);
            i24.setVisibility(View.INVISIBLE);
            toUnlock24.setVisibility(View.INVISIBLE);
        }
        if(c23Sp == 1){
            t23.setVisibility(View.VISIBLE);
            String time = sp.getString("hc23_time_str", "");
            t23.setText(time);
            int c23_stars = sp.getInt("hard_c23_stars", 0);
            ImageView c23_star5 = findViewById(R.id.c23_star5);
            ImageView c23_star4 = findViewById(R.id.c23_star4);
            switch (c23_stars){
                case 5:
                    l23.setVisibility(View.VISIBLE);
                    c23_star4.setImageResource(R.drawable.ic_full_star);
                    c23_star5.setImageResource(R.drawable.ic_full_star);
                    break;

                case 4:
                    l23.setVisibility(View.VISIBLE);
                    c23_star5.setImageResource(R.drawable.ic_empty_star);
                    c23_star4.setImageResource(R.drawable.ic_full_star);
                    break;

                case 3:
                    l23.setVisibility(View.VISIBLE);
                    c23_star4.setImageResource(R.drawable.ic_empty_star);
                    c23_star5.setImageResource(R.drawable.ic_empty_star);
                    break;
            }
        }

        int c24Sp = sp.getInt("hc24", 0);
        if(c24Sp == 1){
            t24.setVisibility(View.VISIBLE);
            String time = sp.getString("hc24_time_str", "");
            t24.setText(time);
            int c24_stars = sp.getInt("hard_c24_stars", 0);
            ImageView c24_star5 = findViewById(R.id.c24_star5);
            ImageView c24_star4 = findViewById(R.id.c24_star4);
            switch (c24_stars){
                case 5:
                    l24.setVisibility(View.VISIBLE);
                    c24_star4.setImageResource(R.drawable.ic_full_star);
                    c24_star5.setImageResource(R.drawable.ic_full_star);
                    break;

                case 4:
                    l24.setVisibility(View.VISIBLE);
                    c24_star5.setImageResource(R.drawable.ic_empty_star);
                    c24_star4.setImageResource(R.drawable.ic_full_star);
                    break;

                case 3:
                    l24.setVisibility(View.VISIBLE);
                    c24_star4.setImageResource(R.drawable.ic_empty_star);
                    c24_star5.setImageResource(R.drawable.ic_empty_star);
                    break;
            }
        }
    }

    private void counterHandle(){
        SharedPreferences sp = getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = sp.edit();
        String counter_str = "";

        counter = sp.getInt("int_counter_hard", 0);
        counter += 1;
        editor.commit();
        editor.putInt("int_counter_hard", counter);
        if(counter < 10){
            counter_str += "0" + counter;
        }
        else {
            counter_str += counter;
        }
        counter_str += "/"+Constants.HARD_LEVELS;
        editor.putString("hard_counter", counter_str);
        editor.commit();
        counterText.setText(counter_str);
    }

    private int getRate(long time){
        //5 stars = > time less than 01:40 seconds.
        //4 stars = > time more than 01:40 seconds and less than 02:30 seconds.
        //3 stars = > time more than 02:30 seconds.

        SharedPreferences sp = getSharedPreferences("MyPref", 0);

        int hours = (int) (time / 3600000);
        int minutes = (int) (time - hours * 3600000) / 60000;
        int seconds= (int)(time - hours*3600000- minutes*60000)/1000;

        int rate;
        stars = sp.getInt("hard_counter_stars", 0);

        if((hours == 0 && minutes == 0 && seconds < 60) || (hours == 0 && minutes == 1 && seconds < 40)){
            rate = 5;
        }
        else if((hours == 0 && minutes == 1 && seconds >= 40) || (hours == 0 && minutes == 2 && seconds < 30)){
            rate = 4;
        }
        else {
            rate = 3;
        }

        return rate;
    }

    private void unlockLevels(){
        if(stars >= 4){
            n2.setVisibility(View.VISIBLE);
            i2.setVisibility(View.INVISIBLE);
            toUnlock2.setVisibility(View.INVISIBLE);
        }

        if(stars >= 8){
            n3.setVisibility(View.VISIBLE);
            i3.setVisibility(View.INVISIBLE);
            toUnlock3.setVisibility(View.INVISIBLE);
        }

        if(stars >= 12){
            n4.setVisibility(View.VISIBLE);
            i4.setVisibility(View.INVISIBLE);
            toUnlock4.setVisibility(View.INVISIBLE);
        }
        if(stars >= 16){
            n5.setVisibility(View.VISIBLE);
            i5.setVisibility(View.INVISIBLE);
            toUnlock5.setVisibility(View.INVISIBLE);
        }
        if(stars >= 20){
            n6.setVisibility(View.VISIBLE);
            i6.setVisibility(View.INVISIBLE);
            toUnlock6.setVisibility(View.INVISIBLE);
        }
        if(stars >= 24){
            n7.setVisibility(View.VISIBLE);
            i7.setVisibility(View.INVISIBLE);
            toUnlock7.setVisibility(View.INVISIBLE);
        }
        if(stars >= 28){
            n8.setVisibility(View.VISIBLE);
            i8.setVisibility(View.INVISIBLE);
            toUnlock8.setVisibility(View.INVISIBLE);
        }
        if(stars >= 32){
            n9.setVisibility(View.VISIBLE);
            i9.setVisibility(View.INVISIBLE);
            toUnlock9.setVisibility(View.INVISIBLE);
        }
        if(stars >= 36){
            n10.setVisibility(View.VISIBLE);
            i10.setVisibility(View.INVISIBLE);
            toUnlock10.setVisibility(View.INVISIBLE);
        }
        if(stars >= 40){
            n11.setVisibility(View.VISIBLE);
            i11.setVisibility(View.INVISIBLE);
            toUnlock11.setVisibility(View.INVISIBLE);
        }
        if(stars >= 44){
            n12.setVisibility(View.VISIBLE);
            i12.setVisibility(View.INVISIBLE);
            toUnlock12.setVisibility(View.INVISIBLE);
        }
        if(stars >= 48){
            n13.setVisibility(View.VISIBLE);
            i13.setVisibility(View.INVISIBLE);
            toUnlock13.setVisibility(View.INVISIBLE);
        }
        if(stars >= 52){
            n14.setVisibility(View.VISIBLE);
            i14.setVisibility(View.INVISIBLE);
            toUnlock14.setVisibility(View.INVISIBLE);
        }
        if(stars >= 56){
            n15.setVisibility(View.VISIBLE);
            i15.setVisibility(View.INVISIBLE);
            toUnlock15.setVisibility(View.INVISIBLE);
        }
        if(stars >= 60){
            n16.setVisibility(View.VISIBLE);
            i16.setVisibility(View.INVISIBLE);
            toUnlock16.setVisibility(View.INVISIBLE);
        }
        if(stars >= 64){
            n17.setVisibility(View.VISIBLE);
            i17.setVisibility(View.INVISIBLE);
            toUnlock17.setVisibility(View.INVISIBLE);
        }
        if(stars >= 68){
            n18.setVisibility(View.VISIBLE);
            i18.setVisibility(View.INVISIBLE);
            toUnlock18.setVisibility(View.INVISIBLE);
        }
        if(stars >= 72){
            n19.setVisibility(View.VISIBLE);
            i19.setVisibility(View.INVISIBLE);
            toUnlock19.setVisibility(View.INVISIBLE);
        }
        if(stars >= 76){
            n20.setVisibility(View.VISIBLE);
            i20.setVisibility(View.INVISIBLE);
            toUnlock20.setVisibility(View.INVISIBLE);
        }
        if(stars >= 80){
            n21.setVisibility(View.VISIBLE);
            i21.setVisibility(View.INVISIBLE);
            toUnlock21.setVisibility(View.INVISIBLE);
        }
        if(stars >= 84){
            n22.setVisibility(View.VISIBLE);
            i22.setVisibility(View.INVISIBLE);
            toUnlock22.setVisibility(View.INVISIBLE);
        }
        if(stars >= 88){
            n23.setVisibility(View.VISIBLE);
            i23.setVisibility(View.INVISIBLE);
            toUnlock23.setVisibility(View.INVISIBLE);
        }
        if(stars >= 92){
            n24.setVisibility(View.VISIBLE);
            i24.setVisibility(View.INVISIBLE);
            toUnlock24.setVisibility(View.INVISIBLE);
        }
    }

    private void loadRewardAd(){
        rewardAd.loadAd("ca-app-pub-3940256099942544/5224354917",
                new AdRequest.Builder().build());
    }

    private void startLevelActivity() {
        final SharedPreferences sp = getSharedPreferences("MyPref", 0);

        switch (level) {
            case "1":
                Intent intent = new Intent(HardLevelActivity.this, HardPuzzleActivity.class);
                intent.putExtra("level", "pisa");
                startActivityForResult(intent, Constants.INTENT_REQUEST_HARD_CODE);
                break;

            case "2":
                Intent intent2 = new Intent(HardLevelActivity.this, HardPuzzleActivity.class);
                intent2.putExtra("level", "colosseum");
                startActivityForResult(intent2, Constants.INTENT_REQUEST_HARD_CODE);
                break;

            case "3":
                Intent intent3 = new Intent(HardLevelActivity.this, HardPuzzleActivity.class);
                intent3.putExtra("level", "eiffel");
                startActivityForResult(intent3, Constants.INTENT_REQUEST_HARD_CODE);
                break;

            case "4":
                Intent intent4 = new Intent(HardLevelActivity.this, HardPuzzleActivity.class);
                intent4.putExtra("level", "pyramid");
                startActivityForResult(intent4, Constants.INTENT_REQUEST_HARD_CODE);
                break;

            case "5":
                Intent intent5 = new Intent(HardLevelActivity.this, HardPuzzleActivity.class);
                intent5.putExtra("level", "hollywood");
                startActivityForResult(intent5, Constants.INTENT_REQUEST_HARD_CODE);
                break;

            case "6":
                Intent intent6 = new Intent(HardLevelActivity.this, HardPuzzleActivity.class);
                intent6.putExtra("level", "dead");
                startActivityForResult(intent6, Constants.INTENT_REQUEST_HARD_CODE);
                break;

            case "7":
                Intent intent7 = new Intent(HardLevelActivity.this, HardPuzzleActivity.class);
                intent7.putExtra("level", "saara");
                startActivityForResult(intent7, Constants.INTENT_REQUEST_HARD_CODE);
                break;

            case "8":
                Intent intent8 = new Intent(HardLevelActivity.this, HardPuzzleActivity.class);
                intent8.putExtra("level", "madagascar");
                startActivityForResult(intent8, Constants.INTENT_REQUEST_HARD_CODE);
                break;

            case "9":
                Intent intent9 = new Intent(HardLevelActivity.this, HardPuzzleActivity.class);
                intent9.putExtra("level", "lemur");
                startActivityForResult(intent9, Constants.INTENT_REQUEST_HARD_CODE);
                break;

            case "10":
                Intent intent10 = new Intent(HardLevelActivity.this, HardPuzzleActivity.class);
                intent10.putExtra("level", "singapore");
                startActivityForResult(intent10, Constants.INTENT_REQUEST_HARD_CODE);
                break;

            case "11":
                Intent intent11 = new Intent(HardLevelActivity.this, HardPuzzleActivity.class);
                intent11.putExtra("level", "garden");
                startActivityForResult(intent11, Constants.INTENT_REQUEST_HARD_CODE);
                break;

            case "12":
                Intent intent12 = new Intent(HardLevelActivity.this, HardPuzzleActivity.class);
                intent12.putExtra("level", "cherry");
                startActivityForResult(intent12, Constants.INTENT_REQUEST_HARD_CODE);
                break;

            case "13":
                Intent intent13 = new Intent(HardLevelActivity.this, HardPuzzleActivity.class);
                intent13.putExtra("level", "japan");
                startActivityForResult(intent13, Constants.INTENT_REQUEST_HARD_CODE);
                break;

            case "14":
                Intent intent14 = new Intent(HardLevelActivity.this, HardPuzzleActivity.class);
                intent14.putExtra("level", "ice");
                startActivityForResult(intent14, Constants.INTENT_REQUEST_HARD_CODE);
                break;

            case "15":
                Intent intent15 = new Intent(HardLevelActivity.this, HardPuzzleActivity.class);
                intent15.putExtra("level", "rocket");
                startActivityForResult(intent15, Constants.INTENT_REQUEST_HARD_CODE);
                break;

            case "16":
                Intent intent16 = new Intent(HardLevelActivity.this, HardPuzzleActivity.class);
                intent16.putExtra("level", "bodha");
                startActivityForResult(intent16, Constants.INTENT_REQUEST_HARD_CODE);
                break;

            case "17":
                Intent intent17 = new Intent(HardLevelActivity.this, HardPuzzleActivity.class);
                intent17.putExtra("level", "think");
                startActivityForResult(intent17, Constants.INTENT_REQUEST_HARD_CODE);
                break;

            case "18":
                Intent intent18 = new Intent(HardLevelActivity.this, HardPuzzleActivity.class);
                intent18.putExtra("level", "egypt");
                startActivityForResult(intent18, Constants.INTENT_REQUEST_HARD_CODE);
                break;

            case "19":
                Intent intent19 = new Intent(HardLevelActivity.this, HardPuzzleActivity.class);
                intent19.putExtra("level", "eli");
                startActivityForResult(intent19, Constants.INTENT_REQUEST_HARD_CODE);
                break;

            case "20":
                Intent intent20 = new Intent(HardLevelActivity.this, HardPuzzleActivity.class);
                intent20.putExtra("level", "holocaust");
                startActivityForResult(intent20, Constants.INTENT_REQUEST_HARD_CODE);
                break;

            case "21":
                Intent intent21 = new Intent(HardLevelActivity.this, HardPuzzleActivity.class);
                intent21.putExtra("level", "army");
                startActivityForResult(intent21, Constants.INTENT_REQUEST_HARD_CODE);
                break;

            case "22":
                Intent intent22 = new Intent(HardLevelActivity.this, HardPuzzleActivity.class);
                intent22.putExtra("level", "women");
                startActivityForResult(intent22, Constants.INTENT_REQUEST_HARD_CODE);
                break;

            case "23":
                Intent intent23 = new Intent(HardLevelActivity.this, HardPuzzleActivity.class);
                intent23.putExtra("level", "dubai");
                startActivityForResult(intent23, Constants.INTENT_REQUEST_HARD_CODE);
                break;

            case "24":
                Intent intent24 = new Intent(HardLevelActivity.this, HardPuzzleActivity.class);
                intent24.putExtra("level", "louvre");
                startActivityForResult(intent24, Constants.INTENT_REQUEST_HARD_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        SharedPreferences sp = getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = sp.edit();

        if(requestCode == Constants.INTENT_REQUEST_HARD_CODE && resultCode == RESULT_OK && data != null){
            String picture = data.getStringExtra("level");
            long time = data.getLongExtra("time", 0);

            switch (picture){

                case "pisa":
                    t1.setVisibility(View.VISIBLE);
                    int c1Sp = sp.getInt("hc1", 0);
                    if(c1Sp == 0){
                        editor.putInt("hc1", 1);
                        editor.commit();
                        counterHandle();
                    }
                    long c1TimeSp = sp.getLong("hc1_time", 0);

                    if(c1TimeSp > time || c1TimeSp == 0){
                        editor.putLong("hc1_time", time);
                        editor.putString("hc1_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t1.setText(Constants.timeHandler(time));
                    }
                    ImageView c1_star5 = findViewById(R.id.c1_star5);
                    ImageView c1_star4 = findViewById(R.id.c1_star4);
                    int c1_rate = getRate(time);
                    int c1_stars = sp.getInt("hard_c1_stars", 0);

                    if(c1_rate - c1_stars > 0){
                        stars += (c1_rate - c1_stars);
                        editor.putInt("hard_counter_stars", stars);
                        editor.putInt("hard_c1_stars", c1_rate);
                        editor.commit();
                        starsText.setText(String.valueOf(stars));
                        switch (c1_rate){
                            case 5:
                                l1.setVisibility(View.VISIBLE);
                                c1_star4.setImageResource(R.drawable.ic_full_star);
                                c1_star5.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 4:
                                l1.setVisibility(View.VISIBLE);
                                c1_star5.setImageResource(R.drawable.ic_empty_star);
                                c1_star4.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 3:
                                l1.setVisibility(View.VISIBLE);
                                c1_star4.setImageResource(R.drawable.ic_empty_star);
                                c1_star5.setImageResource(R.drawable.ic_empty_star);
                                break;
                        }
                    }
                    if(stars >= 4){
                        n2.setVisibility(View.VISIBLE);
                        i2.setVisibility(View.INVISIBLE);
                        toUnlock2.setVisibility(View.INVISIBLE);
                    }
                    break;

                case "colosseum":
                    t2.setVisibility(View.VISIBLE);
                    int c2Sp = sp.getInt("hc2", 0);
                    if(c2Sp == 0){
                        editor.putInt("hc2", 1);
                        editor.commit();
                        counterHandle();
                    }
                    long c2TimeSp = sp.getLong("hc2_time", 0);

                    if(c2TimeSp > time || c2TimeSp == 0){
                        editor.putLong("hc2_time", time);
                        editor.putString("hc2_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t2.setText(Constants.timeHandler(time));
                    }

                    ImageView c2_star5 = findViewById(R.id.c2_star5);
                    ImageView c2_star4 = findViewById(R.id.c2_star4);
                    int c2_rate = getRate(time);
                    int c2_stars = sp.getInt("hard_c2_stars", 0);

                    if(c2_rate - c2_stars > 0){
                        stars += (c2_rate - c2_stars);
                        editor.putInt("hard_counter_stars", stars);
                        editor.putInt("hard_c2_stars", c2_rate);
                        editor.commit();
                        starsText.setText(String.valueOf(stars));
                        switch (c2_rate){
                            case 5:
                                l2.setVisibility(View.VISIBLE);
                                c2_star4.setImageResource(R.drawable.ic_full_star);
                                c2_star5.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 4:
                                l2.setVisibility(View.VISIBLE);
                                c2_star5.setImageResource(R.drawable.ic_empty_star);
                                c2_star4.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 3:
                                l2.setVisibility(View.VISIBLE);
                                c2_star4.setImageResource(R.drawable.ic_empty_star);
                                c2_star5.setImageResource(R.drawable.ic_empty_star);
                                break;
                        }
                    }
                    if(stars >= 8){
                        n3.setVisibility(View.VISIBLE);
                        i3.setVisibility(View.INVISIBLE);
                        toUnlock3.setVisibility(View.INVISIBLE);
                    }
                    break;

                case "eiffel":
                    t3.setVisibility(View.VISIBLE);
                    int c3Sp = sp.getInt("hc3", 0);
                    if(c3Sp == 0){
                        editor.putInt("hc3", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c3TimeSp = sp.getLong("hc3_time", 0);

                    if(c3TimeSp > time || c3TimeSp == 0){
                        editor.putLong("hc3_time", time);
                        editor.putString("hc3_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t3.setText(Constants.timeHandler(time));
                    }
                    ImageView c3_star5 = findViewById(R.id.c3_star5);
                    ImageView c3_star4 = findViewById(R.id.c3_star4);
                    int c3_rate = getRate(time);
                    int c3_stars = sp.getInt("hard_c3_stars", 0);

                    if(c3_rate - c3_stars > 0){
                        stars += (c3_rate - c3_stars);
                        editor.putInt("hard_counter_stars", stars);
                        editor.putInt("hard_c3_stars", c3_rate);
                        editor.commit();
                        starsText.setText(String.valueOf(stars));
                        switch (c3_rate){
                            case 5:
                                l3.setVisibility(View.VISIBLE);
                                c3_star4.setImageResource(R.drawable.ic_full_star);
                                c3_star5.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 4:
                                l3.setVisibility(View.VISIBLE);
                                c3_star5.setImageResource(R.drawable.ic_empty_star);
                                c3_star4.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 3:
                                l3.setVisibility(View.VISIBLE);
                                c3_star4.setImageResource(R.drawable.ic_empty_star);
                                c3_star5.setImageResource(R.drawable.ic_empty_star);
                                break;
                        }
                    }
                    if(stars >= 12){
                        n4.setVisibility(View.VISIBLE);
                        i4.setVisibility(View.INVISIBLE);
                        toUnlock4.setVisibility(View.INVISIBLE);
                    }
                    break;

                case "pyramid":
                    t4.setVisibility(View.VISIBLE);
                    int c4Sp = sp.getInt("hc4", 0);
                    if(c4Sp == 0){
                        editor.putInt("hc4", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c4TimeSp = sp.getLong("hc4_time", 0);

                    if(c4TimeSp > time || c4TimeSp == 0){
                        editor.putLong("hc4_time", time);
                        editor.putString("hc4_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t4.setText(Constants.timeHandler(time));
                    }
                    ImageView c4_star5 = findViewById(R.id.c4_star5);
                    ImageView c4_star4 = findViewById(R.id.c4_star4);
                    int c4_rate = getRate(time);
                    int c4_stars = sp.getInt("hard_c4_stars", 0);

                    if(c4_rate - c4_stars > 0){
                        stars += (c4_rate - c4_stars);
                        editor.putInt("hard_counter_stars", stars);
                        editor.putInt("hard_c4_stars", c4_rate);
                        editor.commit();
                        starsText.setText(String.valueOf(stars));
                        switch (c4_rate){
                            case 5:
                                l4.setVisibility(View.VISIBLE);
                                c4_star4.setImageResource(R.drawable.ic_full_star);
                                c4_star5.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 4:
                                l4.setVisibility(View.VISIBLE);
                                c4_star5.setImageResource(R.drawable.ic_empty_star);
                                c4_star4.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 3:
                                l4.setVisibility(View.VISIBLE);
                                c4_star4.setImageResource(R.drawable.ic_empty_star);
                                c4_star5.setImageResource(R.drawable.ic_empty_star);
                                break;
                        }
                    }
                    if(stars >= 16){
                        n5.setVisibility(View.VISIBLE);
                        i5.setVisibility(View.INVISIBLE);
                        toUnlock5.setVisibility(View.INVISIBLE);
                    }
                    break;

                case "hollywood":
                    t5.setVisibility(View.VISIBLE);
                    int c5Sp = sp.getInt("hc5", 0);
                    if(c5Sp == 0){
                        editor.putInt("hc5", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c5TimeSp = sp.getLong("hc5_time", 0);

                    if(c5TimeSp > time || c5TimeSp == 0){
                        editor.putLong("hc5_time", time);
                        editor.putString("hc5_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t5.setText(Constants.timeHandler(time));
                    }
                    ImageView c5_star5 = findViewById(R.id.c5_star5);
                    ImageView c5_star4 = findViewById(R.id.c5_star4);
                    int c5_rate = getRate(time);
                    int c5_stars = sp.getInt("hard_c5_stars", 0);

                    if(c5_rate - c5_stars > 0){
                        stars += (c5_rate - c5_stars);
                        editor.putInt("hard_counter_stars", stars);
                        editor.putInt("hard_c5_stars", c5_rate);
                        editor.commit();
                        starsText.setText(String.valueOf(stars));
                        switch (c5_rate){
                            case 5:
                                l5.setVisibility(View.VISIBLE);
                                c5_star4.setImageResource(R.drawable.ic_full_star);
                                c5_star5.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 4:
                                l5.setVisibility(View.VISIBLE);
                                c5_star5.setImageResource(R.drawable.ic_empty_star);
                                c5_star4.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 3:
                                l5.setVisibility(View.VISIBLE);
                                c5_star4.setImageResource(R.drawable.ic_empty_star);
                                c5_star5.setImageResource(R.drawable.ic_empty_star);
                                break;
                        }
                    }
                    if(stars >= 20){
                        n6.setVisibility(View.VISIBLE);
                        i6.setVisibility(View.INVISIBLE);
                        toUnlock6.setVisibility(View.INVISIBLE);
                    }
                    break;

                case "dead":
                    t6.setVisibility(View.VISIBLE);
                    int c6Sp = sp.getInt("hc6", 0);
                    if(c6Sp == 0){
                        editor.putInt("hc6", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c6TimeSp = sp.getLong("hc6_time", 0);

                    if(c6TimeSp > time || c6TimeSp == 0){
                        editor.putLong("hc6_time", time);
                        editor.putString("hc6_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t6.setText(Constants.timeHandler(time));
                    }

                    ImageView c6_star5 = findViewById(R.id.c6_star5);
                    ImageView c6_star4 = findViewById(R.id.c6_star4);
                    int c6_rate = getRate(time);
                    int c6_stars = sp.getInt("hard_c6_stars", 0);

                    if(c6_rate - c6_stars > 0){
                        stars += (c6_rate - c6_stars);
                        editor.putInt("hard_counter_stars", stars);
                        editor.putInt("hard_c6_stars", c6_rate);
                        editor.commit();
                        starsText.setText(String.valueOf(stars));
                        switch (c6_rate){
                            case 5:
                                l6.setVisibility(View.VISIBLE);
                                c6_star4.setImageResource(R.drawable.ic_full_star);
                                c6_star5.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 4:
                                l6.setVisibility(View.VISIBLE);
                                c6_star5.setImageResource(R.drawable.ic_empty_star);
                                c6_star4.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 3:
                                l6.setVisibility(View.VISIBLE);
                                c6_star4.setImageResource(R.drawable.ic_empty_star);
                                c6_star5.setImageResource(R.drawable.ic_empty_star);
                                break;
                        }
                    }
                    if(stars >= 24){
                        n7.setVisibility(View.VISIBLE);
                        i7.setVisibility(View.INVISIBLE);
                        toUnlock7.setVisibility(View.INVISIBLE);
                    }
                    break;

                case "saara":
                    t7.setVisibility(View.VISIBLE);
                    int c7Sp = sp.getInt("hc7", 0);
                    if(c7Sp == 0){
                        editor.putInt("hc7", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c7TimeSp = sp.getLong("hc7_time", 0);

                    if(c7TimeSp > time || c7TimeSp == 0){
                        editor.putLong("hc7_time", time);
                        editor.putString("hc7_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t7.setText(Constants.timeHandler(time));
                    }

                    ImageView c7_star5 = findViewById(R.id.c7_star5);
                    ImageView c7_star4 = findViewById(R.id.c7_star4);
                    int c7_rate = getRate(time);
                    int c7_stars = sp.getInt("hard_c7_stars", 0);

                    if(c7_rate - c7_stars > 0){
                        stars += (c7_rate - c7_stars);
                        editor.putInt("hard_counter_stars", stars);
                        editor.putInt("hard_c7_stars", c7_rate);
                        editor.commit();
                        starsText.setText(String.valueOf(stars));
                        switch (c7_rate){
                            case 5:
                                l7.setVisibility(View.VISIBLE);
                                c7_star4.setImageResource(R.drawable.ic_full_star);
                                c7_star5.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 4:
                                l7.setVisibility(View.VISIBLE);
                                c7_star5.setImageResource(R.drawable.ic_empty_star);
                                c7_star4.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 3:
                                l7.setVisibility(View.VISIBLE);
                                c7_star4.setImageResource(R.drawable.ic_empty_star);
                                c7_star5.setImageResource(R.drawable.ic_empty_star);
                                break;
                        }
                    }
                    if(stars >= 28){
                        n8.setVisibility(View.VISIBLE);
                        i8.setVisibility(View.INVISIBLE);
                        toUnlock8.setVisibility(View.INVISIBLE);
                    }
                    break;

                case "madagascar":
                    t8.setVisibility(View.VISIBLE);
                    int c8Sp = sp.getInt("hc8", 0);
                    if(c8Sp == 0){
                        editor.putInt("hc8", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c8TimeSp = sp.getLong("hc8_time", 0);

                    if(c8TimeSp > time || c8TimeSp == 0){
                        editor.putLong("hc8_time", time);
                        editor.putString("hc8_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t8.setText(Constants.timeHandler(time));
                    }
                    ImageView c8_star5 = findViewById(R.id.c8_star5);
                    ImageView c8_star4 = findViewById(R.id.c8_star4);
                    int c8_rate = getRate(time);
                    int c8_stars = sp.getInt("hard_c8_stars", 0);

                    if(c8_rate - c8_stars > 0){
                        stars += (c8_rate - c8_stars);
                        editor.putInt("hard_counter_stars", stars);
                        editor.putInt("hard_c8_stars", c8_rate);
                        editor.commit();
                        starsText.setText(String.valueOf(stars));
                        switch (c8_rate){
                            case 5:
                                l8.setVisibility(View.VISIBLE);
                                c8_star4.setImageResource(R.drawable.ic_full_star);
                                c8_star5.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 4:
                                l8.setVisibility(View.VISIBLE);
                                c8_star5.setImageResource(R.drawable.ic_empty_star);
                                c8_star4.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 3:
                                l8.setVisibility(View.VISIBLE);
                                c8_star4.setImageResource(R.drawable.ic_empty_star);
                                c8_star5.setImageResource(R.drawable.ic_empty_star);
                                break;
                        }
                    }
                    if(stars >= 32){
                        n9.setVisibility(View.VISIBLE);
                        i9.setVisibility(View.INVISIBLE);
                        toUnlock9.setVisibility(View.INVISIBLE);
                    }
                    break;

                case "lemur":
                    t9.setVisibility(View.VISIBLE);
                    int c9Sp = sp.getInt("hc9", 0);
                    if(c9Sp == 0){
                        editor.putInt("hc9", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c9TimeSp = sp.getLong("hc9_time", 0);

                    if(c9TimeSp > time || c9TimeSp == 0){
                        editor.putLong("hc9_time", time);
                        editor.putString("hc9_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t9.setText(Constants.timeHandler(time));
                    }
                    ImageView c9_star5 = findViewById(R.id.c9_star5);
                    ImageView c9_star4 = findViewById(R.id.c9_star4);
                    int c9_rate = getRate(time);
                    int c9_stars = sp.getInt("hard_c9_stars", 0);

                    if(c9_rate - c9_stars > 0){
                        stars += (c9_rate - c9_stars);
                        editor.putInt("hard_counter_stars", stars);
                        editor.putInt("hard_c9_stars", c9_rate);
                        editor.commit();
                        starsText.setText(String.valueOf(stars));
                        switch (c9_rate){
                            case 5:
                                l9.setVisibility(View.VISIBLE);
                                c9_star4.setImageResource(R.drawable.ic_full_star);
                                c9_star5.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 4:
                                l9.setVisibility(View.VISIBLE);
                                c9_star5.setImageResource(R.drawable.ic_empty_star);
                                c9_star4.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 3:
                                l9.setVisibility(View.VISIBLE);
                                c9_star4.setImageResource(R.drawable.ic_empty_star);
                                c9_star5.setImageResource(R.drawable.ic_empty_star);
                                break;
                        }
                    }
                    if(stars >= 36){
                        n10.setVisibility(View.VISIBLE);
                        i10.setVisibility(View.INVISIBLE);
                        toUnlock10.setVisibility(View.INVISIBLE);
                    }
                    break;

                case "garden":
                    t11.setVisibility(View.VISIBLE);
                    int c11Sp = sp.getInt("hc11", 0);
                    if(c11Sp == 0){
                        editor.putInt("hc11", 1);
                        editor.commit();
                        counterHandle();
                    }
                    long c11TimeSp = sp.getLong("hc11_time", 0);

                    if(c11TimeSp > time || c11TimeSp == 0){
                        editor.putLong("hc11_time", time);
                        editor.putString("hc11_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t11.setText(Constants.timeHandler(time));
                    }

                    ImageView c11_star5 = findViewById(R.id.c11_star5);
                    ImageView c11_star4 = findViewById(R.id.c11_star4);
                    int c11_rate = getRate(time);
                    int c11_stars = sp.getInt("hard_c11_stars", 0);

                    if(c11_rate - c11_stars > 0){
                        stars += (c11_rate - c11_stars);
                        editor.putInt("hard_counter_stars", stars);
                        editor.putInt("hard_c11_stars", c11_rate);
                        editor.commit();
                        starsText.setText(String.valueOf(stars));
                        switch (c11_rate){
                            case 5:
                                l11.setVisibility(View.VISIBLE);
                                c11_star4.setImageResource(R.drawable.ic_full_star);
                                c11_star5.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 4:
                                l11.setVisibility(View.VISIBLE);
                                c11_star5.setImageResource(R.drawable.ic_empty_star);
                                c11_star4.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 3:
                                l11.setVisibility(View.VISIBLE);
                                c11_star4.setImageResource(R.drawable.ic_empty_star);
                                c11_star5.setImageResource(R.drawable.ic_empty_star);
                                break;
                        }
                    }
                    if(stars >= 44){
                        n12.setVisibility(View.VISIBLE);
                        i12.setVisibility(View.INVISIBLE);
                        toUnlock12.setVisibility(View.INVISIBLE);
                    }
                    break;

                case "antartica":
                    t17.setVisibility(View.VISIBLE);
                    int c17Sp = sp.getInt("hc17", 0);
                    if(c17Sp == 0){
                        editor.putInt("hc17", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c17TimeSp = sp.getLong("hc17_time", 0);

                    if(c17TimeSp > time || c17TimeSp == 0){
                        editor.putLong("hc17_time", time);
                        editor.putString("hc17_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t17.setText(Constants.timeHandler(time));
                    }
                    ImageView c17_star5 = findViewById(R.id.c17_star5);
                    ImageView c17_star4 = findViewById(R.id.c17_star4);
                    int c17_rate = getRate(time);
                    int c17_stars = sp.getInt("hard_c17_stars", 0);

                    if(c17_rate - c17_stars > 0){
                        stars += (c17_rate - c17_stars);
                        editor.putInt("hard_counter_stars", stars);
                        editor.putInt("hard_c17_stars", c17_rate);
                        editor.commit();
                        starsText.setText(String.valueOf(stars));
                        switch (c17_rate){
                            case 5:
                                l17.setVisibility(View.VISIBLE);
                                c17_star4.setImageResource(R.drawable.ic_full_star);
                                c17_star5.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 4:
                                l17.setVisibility(View.VISIBLE);
                                c17_star5.setImageResource(R.drawable.ic_empty_star);
                                c17_star4.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 3:
                                l17.setVisibility(View.VISIBLE);
                                c17_star4.setImageResource(R.drawable.ic_empty_star);
                                c17_star5.setImageResource(R.drawable.ic_empty_star);
                                break;
                        }
                    }
                    if(stars >= 68){
                        n18.setVisibility(View.VISIBLE);
                        i18.setVisibility(View.INVISIBLE);
                        toUnlock18.setVisibility(View.INVISIBLE);
                    }
                    break;

                case "singapore":
                    t10.setVisibility(View.VISIBLE);
                    int c10Sp = sp.getInt("hc10", 0);
                    if(c10Sp == 0){
                        editor.putInt("hc10", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c10TimeSp = sp.getLong("hc10_time", 0);

                    if(c10TimeSp > time || c10TimeSp == 0){
                        editor.putLong("hc10_time", time);
                        editor.putString("hc10_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t10.setText(Constants.timeHandler(time));
                    }

                    ImageView c10_star5 = findViewById(R.id.c10_star5);
                    ImageView c10_star4 = findViewById(R.id.c10_star4);
                    int c10_rate = getRate(time);
                    int c10_stars = sp.getInt("hard_c10_stars", 0);

                    if(c10_rate - c10_stars > 0){
                        stars += (c10_rate - c10_stars);
                        editor.putInt("hard_counter_stars", stars);
                        editor.putInt("hard_c10_stars", c10_rate);
                        editor.commit();
                        starsText.setText(String.valueOf(stars));
                        switch (c10_rate){
                            case 5:
                                l10.setVisibility(View.VISIBLE);
                                c10_star4.setImageResource(R.drawable.ic_full_star);
                                c10_star5.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 4:
                                l10.setVisibility(View.VISIBLE);
                                c10_star5.setImageResource(R.drawable.ic_empty_star);
                                c10_star4.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 3:
                                l10.setVisibility(View.VISIBLE);
                                c10_star4.setImageResource(R.drawable.ic_empty_star);
                                c10_star5.setImageResource(R.drawable.ic_empty_star);
                                break;
                        }
                    }
                    if(stars >= 40){
                        n11.setVisibility(View.VISIBLE);
                        i11.setVisibility(View.INVISIBLE);
                        toUnlock11.setVisibility(View.INVISIBLE);
                    }
                    break;

                case "cherry":
                    t12.setVisibility(View.VISIBLE);
                    int c12Sp = sp.getInt("hc12", 0);
                    if(c12Sp == 0){
                        editor.putInt("hc12", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c12TimeSp = sp.getLong("hc12_time", 0);

                    if(c12TimeSp > time || c12TimeSp == 0){
                        editor.putLong("hc12_time", time);
                        editor.putString("hc12_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t12.setText(Constants.timeHandler(time));
                    }
                    ImageView c12_star5 = findViewById(R.id.c12_star5);
                    ImageView c12_star4 = findViewById(R.id.c12_star4);
                    int c12_rate = getRate(time);
                    int c12_stars = sp.getInt("hard_c12_stars", 0);

                    if(c12_rate - c12_stars > 0){
                        stars += (c12_rate - c12_stars);
                        editor.putInt("hard_counter_stars", stars);
                        editor.putInt("hard_c12_stars", c12_rate);
                        editor.commit();
                        starsText.setText(String.valueOf(stars));
                        switch (c12_rate){
                            case 5:
                                l12.setVisibility(View.VISIBLE);
                                c12_star4.setImageResource(R.drawable.ic_full_star);
                                c12_star5.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 4:
                                l12.setVisibility(View.VISIBLE);
                                c12_star5.setImageResource(R.drawable.ic_empty_star);
                                c12_star4.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 3:
                                l12.setVisibility(View.VISIBLE);
                                c12_star4.setImageResource(R.drawable.ic_empty_star);
                                c12_star5.setImageResource(R.drawable.ic_empty_star);
                                break;
                        }
                    }
                    if(stars >= 48){
                        n13.setVisibility(View.VISIBLE);
                        i13.setVisibility(View.INVISIBLE);
                        toUnlock13.setVisibility(View.INVISIBLE);
                    }
                    break;

                case "japan":
                    t13.setVisibility(View.VISIBLE);
                    int c13Sp = sp.getInt("hc13", 0);
                    if(c13Sp == 0){
                        editor.putInt("hc13", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c13TimeSp = sp.getLong("hc13_time", 0);

                    if(c13TimeSp > time || c13TimeSp == 0){
                        editor.putLong("hc13_time", time);
                        editor.putString("hc13_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t13.setText(Constants.timeHandler(time));
                    }

                    ImageView c13_star5 = findViewById(R.id.c13_star5);
                    ImageView c13_star4 = findViewById(R.id.c13_star4);
                    int c13_rate = getRate(time);
                    int c13_stars = sp.getInt("hard_c13_stars", 0);

                    if(c13_rate - c13_stars > 0){
                        stars += (c13_rate - c13_stars);
                        editor.putInt("hard_counter_stars", stars);
                        editor.putInt("hard_c13_stars", c13_rate);
                        editor.commit();
                        starsText.setText(String.valueOf(stars));
                        switch (c13_rate){
                            case 5:
                                l13.setVisibility(View.VISIBLE);
                                c13_star4.setImageResource(R.drawable.ic_full_star);
                                c13_star5.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 4:
                                l13.setVisibility(View.VISIBLE);
                                c13_star5.setImageResource(R.drawable.ic_empty_star);
                                c13_star4.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 3:
                                l13.setVisibility(View.VISIBLE);
                                c13_star4.setImageResource(R.drawable.ic_empty_star);
                                c13_star5.setImageResource(R.drawable.ic_empty_star);
                                break;
                        }
                    }
                    if(stars >= 52){
                        n14.setVisibility(View.VISIBLE);
                        i14.setVisibility(View.INVISIBLE);
                        toUnlock14.setVisibility(View.INVISIBLE);
                    }
                    break;

                case "ice":
                    t14.setVisibility(View.VISIBLE);
                    int c14Sp = sp.getInt("hc14", 0);
                    if(c14Sp == 0){
                        editor.putInt("hc14", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c14TimeSp = sp.getLong("hc14_time", 0);

                    if(c14TimeSp > time || c14TimeSp == 0){
                        editor.putLong("hc14_time", time);
                        editor.putString("hc14_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t14.setText(Constants.timeHandler(time));
                    }
                    ImageView c14_star5 = findViewById(R.id.c14_star5);
                    ImageView c14_star4 = findViewById(R.id.c14_star4);
                    int c14_rate = getRate(time);
                    int c14_stars = sp.getInt("hard_c14_stars", 0);

                    if(c14_rate - c14_stars > 0){
                        stars += (c14_rate - c14_stars);
                        editor.putInt("hard_counter_stars", stars);
                        editor.putInt("hard_c14_stars", c14_rate);
                        editor.commit();
                        starsText.setText(String.valueOf(stars));
                        switch (c14_rate){
                            case 5:
                                l14.setVisibility(View.VISIBLE);
                                c14_star4.setImageResource(R.drawable.ic_full_star);
                                c14_star5.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 4:
                                l14.setVisibility(View.VISIBLE);
                                c14_star5.setImageResource(R.drawable.ic_empty_star);
                                c14_star4.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 3:
                                l14.setVisibility(View.VISIBLE);
                                c14_star4.setImageResource(R.drawable.ic_empty_star);
                                c14_star5.setImageResource(R.drawable.ic_empty_star);
                                break;
                        }
                    }
                    if(stars >= 56){
                        n15.setVisibility(View.VISIBLE);
                        i15.setVisibility(View.INVISIBLE);
                        toUnlock15.setVisibility(View.INVISIBLE);
                    }
                    break;

                case "rocket":
                    t15.setVisibility(View.VISIBLE);
                    int c15Sp = sp.getInt("hc15", 0);
                    if(c15Sp == 0){
                        editor.putInt("hc15", 1);
                        editor.commit();
                        counterHandle();
                    }
                    long c15TimeSp = sp.getLong("hc15_time", 0);

                    if(c15TimeSp > time || c15TimeSp == 0){
                        editor.putLong("hc15_time", time);
                        editor.putString("hc15_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t15.setText(Constants.timeHandler(time));
                    }
                    ImageView c15_star5 = findViewById(R.id.c15_star5);
                    ImageView c15_star4 = findViewById(R.id.c15_star4);
                    int c15_rate = getRate(time);
                    int c15_stars = sp.getInt("hard_c15_stars", 0);

                    if(c15_rate - c15_stars > 0){
                        stars += (c15_rate - c15_stars);
                        editor.putInt("hard_counter_stars", stars);
                        editor.putInt("hard_c15_stars", c15_rate);
                        editor.commit();
                        starsText.setText(String.valueOf(stars));
                        switch (c15_rate){
                            case 5:
                                l15.setVisibility(View.VISIBLE);
                                c15_star4.setImageResource(R.drawable.ic_full_star);
                                c15_star5.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 4:
                                l15.setVisibility(View.VISIBLE);
                                c15_star5.setImageResource(R.drawable.ic_empty_star);
                                c15_star4.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 3:
                                l15.setVisibility(View.VISIBLE);
                                c15_star4.setImageResource(R.drawable.ic_empty_star);
                                c15_star5.setImageResource(R.drawable.ic_empty_star);
                                break;
                        }
                    }
                    if(stars >= 60){
                        n16.setVisibility(View.VISIBLE);
                        i16.setVisibility(View.INVISIBLE);
                        toUnlock16.setVisibility(View.INVISIBLE);
                    }
                    break;

                case "bodha":
                    t16.setVisibility(View.VISIBLE);
                    int c16Sp = sp.getInt("hc16", 0);
                    if(c16Sp == 0){
                        editor.putInt("hc16", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c16TimeSp = sp.getLong("hc16_time", 0);

                    if(c16TimeSp > time || c16TimeSp == 0){
                        editor.putLong("hc16_time", time);
                        editor.putString("hc16_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t16.setText(Constants.timeHandler(time));
                    }

                    ImageView c16_star5 = findViewById(R.id.c16_star5);
                    ImageView c16_star4 = findViewById(R.id.c16_star4);
                    int c16_rate = getRate(time);
                    int c16_stars = sp.getInt("hard_c16_stars", 0);

                    if(c16_rate - c16_stars > 0){
                        stars += (c16_rate - c16_stars);
                        editor.putInt("hard_counter_stars", stars);
                        editor.putInt("hard_c16_stars", c16_rate);
                        editor.commit();
                        starsText.setText(String.valueOf(stars));
                        switch (c16_rate){
                            case 5:
                                l16.setVisibility(View.VISIBLE);
                                c16_star4.setImageResource(R.drawable.ic_full_star);
                                c16_star5.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 4:
                                l16.setVisibility(View.VISIBLE);
                                c16_star5.setImageResource(R.drawable.ic_empty_star);
                                c16_star4.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 3:
                                l16.setVisibility(View.VISIBLE);
                                c16_star4.setImageResource(R.drawable.ic_empty_star);
                                c16_star5.setImageResource(R.drawable.ic_empty_star);
                                break;
                        }
                    }
                    if(stars >= 64){
                        n17.setVisibility(View.VISIBLE);
                        i17.setVisibility(View.INVISIBLE);
                        toUnlock17.setVisibility(View.INVISIBLE);
                    }
                    break;

                case "egypt":
                    t18.setVisibility(View.VISIBLE);
                    int c18Sp = sp.getInt("hc18", 0);
                    if(c18Sp == 0){
                        editor.putInt("hc18", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c18TimeSp = sp.getLong("hc18_time", 0);

                    if(c18TimeSp > time || c18TimeSp == 0){
                        editor.putLong("hc18_time", time);
                        editor.putString("hc18_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t18.setText(Constants.timeHandler(time));
                    }
                    ImageView c18_star5 = findViewById(R.id.c18_star5);
                    ImageView c18_star4 = findViewById(R.id.c18_star4);
                    int c18_rate = getRate(time);
                    int c18_stars = sp.getInt("hard_c18_stars", 0);

                    if(c18_rate - c18_stars > 0){
                        stars += (c18_rate - c18_stars);
                        editor.putInt("hard_counter_stars", stars);
                        editor.putInt("hard_c18_stars", c18_rate);
                        editor.commit();
                        starsText.setText(String.valueOf(stars));
                        switch (c18_rate){
                            case 5:
                                l18.setVisibility(View.VISIBLE);
                                c18_star4.setImageResource(R.drawable.ic_full_star);
                                c18_star5.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 4:
                                l18.setVisibility(View.VISIBLE);
                                c18_star5.setImageResource(R.drawable.ic_empty_star);
                                c18_star4.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 3:
                                l18.setVisibility(View.VISIBLE);
                                c18_star4.setImageResource(R.drawable.ic_empty_star);
                                c18_star5.setImageResource(R.drawable.ic_empty_star);
                                break;
                        }
                    }
                    if(stars >= 72){
                        n19.setVisibility(View.VISIBLE);
                        i19.setVisibility(View.INVISIBLE);
                        toUnlock19.setVisibility(View.INVISIBLE);
                    }
                    break;

                case "eli":
                    t19.setVisibility(View.VISIBLE);
                    int c19Sp = sp.getInt("hc19", 0);
                    if(c19Sp == 0){
                        editor.putInt("hc19", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c19TimeSp = sp.getLong("hc19_time", 0);

                    if(c19TimeSp > time || c19TimeSp == 0){
                        editor.putLong("hc19_time", time);
                        editor.putString("hc19_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t19.setText(Constants.timeHandler(time));
                    }
                    ImageView c19_star5 = findViewById(R.id.c19_star5);
                    ImageView c19_star4 = findViewById(R.id.c19_star4);
                    int c19_rate = getRate(time);
                    int c19_stars = sp.getInt("hard_c19_stars", 0);

                    if(c19_rate - c19_stars > 0){
                        stars += (c19_rate - c19_stars);
                        editor.putInt("hard_counter_stars", stars);
                        editor.putInt("hard_c19_stars", c19_rate);
                        editor.commit();
                        starsText.setText(String.valueOf(stars));
                        switch (c19_rate){
                            case 5:
                                l19.setVisibility(View.VISIBLE);
                                c19_star4.setImageResource(R.drawable.ic_full_star);
                                c19_star5.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 4:
                                l19.setVisibility(View.VISIBLE);
                                c19_star5.setImageResource(R.drawable.ic_empty_star);
                                c19_star4.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 3:
                                l19.setVisibility(View.VISIBLE);
                                c19_star4.setImageResource(R.drawable.ic_empty_star);
                                c19_star5.setImageResource(R.drawable.ic_empty_star);
                                break;
                        }
                    }
                    if(stars >= 76){
                        n20.setVisibility(View.VISIBLE);
                        i20.setVisibility(View.INVISIBLE);
                        toUnlock20.setVisibility(View.INVISIBLE);
                    }
                    break;

                case "holocaust":
                    t20.setVisibility(View.VISIBLE);
                    int c20Sp = sp.getInt("hc20", 0);
                    if(c20Sp == 0){
                        editor.putInt("hc20", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c20TimeSp = sp.getLong("hc20_time", 0);

                    if(c20TimeSp > time || c20TimeSp == 0){
                        editor.putLong("hc20_time", time);
                        editor.putString("hc20_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t20.setText(Constants.timeHandler(time));
                    }
                    ImageView c20_star5 = findViewById(R.id.c20_star5);
                    ImageView c20_star4 = findViewById(R.id.c20_star4);
                    int c20_rate = getRate(time);
                    int c20_stars = sp.getInt("hard_c20_stars", 0);

                    if(c20_rate - c20_stars > 0){
                        stars += (c20_rate - c20_stars);
                        editor.putInt("hard_counter_stars", stars);
                        editor.putInt("hard_c20_stars", c20_rate);
                        editor.commit();
                        starsText.setText(String.valueOf(stars));
                        switch (c20_rate){
                            case 5:
                                l20.setVisibility(View.VISIBLE);
                                c20_star4.setImageResource(R.drawable.ic_full_star);
                                c20_star5.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 4:
                                l20.setVisibility(View.VISIBLE);
                                c20_star5.setImageResource(R.drawable.ic_empty_star);
                                c20_star4.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 3:
                                l20.setVisibility(View.VISIBLE);
                                c20_star4.setImageResource(R.drawable.ic_empty_star);
                                c20_star5.setImageResource(R.drawable.ic_empty_star);
                                break;
                        }
                    }
                    if(stars >= 80){
                        n21.setVisibility(View.VISIBLE);
                        i21.setVisibility(View.INVISIBLE);
                        toUnlock21.setVisibility(View.INVISIBLE);
                    }
                    break;

                case "army":
                    t21.setVisibility(View.VISIBLE);
                    int c21Sp = sp.getInt("hc21", 0);
                    if(c21Sp == 0){
                        editor.putInt("hc21", 1);
                        editor.commit();
                    }

                    long c21TimeSp = sp.getLong("hc21_time", 0);

                    if(c21TimeSp > time || c21TimeSp == 0){
                        editor.putLong("hc21_time", time);
                        editor.putString("hc21_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t21.setText(Constants.timeHandler(time));
                    }
                    ImageView c21_star5 = findViewById(R.id.c21_star5);
                    ImageView c21_star4 = findViewById(R.id.c21_star4);
                    int c21_rate = getRate(time);
                    int c21_stars = sp.getInt("hard_c21_stars", 0);

                    if(c21_rate - c21_stars > 0){
                        stars += (c21_rate - c21_stars);
                        editor.putInt("hard_counter_stars", stars);
                        editor.putInt("hard_c21_stars", c21_rate);
                        editor.commit();
                        starsText.setText(String.valueOf(stars));
                        switch (c21_rate){
                            case 5:
                                l21.setVisibility(View.VISIBLE);
                                c21_star4.setImageResource(R.drawable.ic_full_star);
                                c21_star5.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 4:
                                l21.setVisibility(View.VISIBLE);
                                c21_star5.setImageResource(R.drawable.ic_empty_star);
                                c21_star4.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 3:
                                l21.setVisibility(View.VISIBLE);
                                c21_star4.setImageResource(R.drawable.ic_empty_star);
                                c21_star5.setImageResource(R.drawable.ic_empty_star);
                                break;
                        }
                    }
                    if(stars >= 84){
                        n22.setVisibility(View.VISIBLE);
                        i22.setVisibility(View.INVISIBLE);
                        toUnlock22.setVisibility(View.INVISIBLE);
                    }
                    break;


                case "women":
                    t22.setVisibility(View.VISIBLE);
                    int c22Sp = sp.getInt("hc22", 0);
                    if(c22Sp == 0){
                        editor.putInt("hc22", 1);
                        editor.commit();
                    }

                    long c22TimeSp = sp.getLong("hc22_time", 0);

                    if(c22TimeSp > time || c22TimeSp == 0){
                        editor.putLong("hc22_time", time);
                        editor.putString("hc22_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t22.setText(Constants.timeHandler(time));
                    }
                    ImageView c22_star5 = findViewById(R.id.c22_star5);
                    ImageView c22_star4 = findViewById(R.id.c22_star4);
                    int c22_rate = getRate(time);
                    int c22_stars = sp.getInt("hard_c22_stars", 0);

                    if(c22_rate - c22_stars > 0){
                        stars += (c22_rate - c22_stars);
                        editor.putInt("hard_counter_stars", stars);
                        editor.putInt("hard_c22_stars", c22_rate);
                        editor.commit();
                        starsText.setText(String.valueOf(stars));
                        switch (c22_rate){
                            case 5:
                                l22.setVisibility(View.VISIBLE);
                                c22_star4.setImageResource(R.drawable.ic_full_star);
                                c22_star5.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 4:
                                l22.setVisibility(View.VISIBLE);
                                c22_star5.setImageResource(R.drawable.ic_empty_star);
                                c22_star4.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 3:
                                l22.setVisibility(View.VISIBLE);
                                c22_star4.setImageResource(R.drawable.ic_empty_star);
                                c22_star5.setImageResource(R.drawable.ic_empty_star);
                                break;
                        }
                    }
                    if(stars >= 88){
                        n23.setVisibility(View.VISIBLE);
                        i23.setVisibility(View.INVISIBLE);
                        toUnlock23.setVisibility(View.INVISIBLE);
                    }
                    break;

                case "dubai":
                    t23.setVisibility(View.VISIBLE);
                    int c23Sp = sp.getInt("c23", 0);
                    if(c23Sp == 0){
                        editor.putInt("c23", 1);
                        editor.commit();
                    }

                    long c23TimeSp = sp.getLong("c23_time", 0);

                    if(c23TimeSp > time || c23TimeSp == 0){
                        editor.putLong("c23_time", time);
                        editor.putString("c23_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t23.setText(Constants.timeHandler(time));
                    }
                    ImageView c23_star5 = findViewById(R.id.c23_star5);
                    ImageView c23_star4 = findViewById(R.id.c23_star4);
                    int c23_rate = getRate(time);
                    int c23_stars = sp.getInt("hard_c23_stars", 0);

                    if(c23_rate - c23_stars > 0){
                        stars += (c23_rate - c23_stars);
                        editor.putInt("hard_counter_stars", stars);
                        editor.putInt("hard_c23_stars", c23_rate);
                        editor.commit();
                        starsText.setText(String.valueOf(stars));
                        switch (c23_rate){
                            case 5:
                                l23.setVisibility(View.VISIBLE);
                                c23_star4.setImageResource(R.drawable.ic_full_star);
                                c23_star5.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 4:
                                l23.setVisibility(View.VISIBLE);
                                c23_star5.setImageResource(R.drawable.ic_empty_star);
                                c23_star4.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 3:
                                l23.setVisibility(View.VISIBLE);
                                c23_star4.setImageResource(R.drawable.ic_empty_star);
                                c23_star5.setImageResource(R.drawable.ic_empty_star);
                                break;
                        }
                    }
                    if(stars >= 92){
                        n24.setVisibility(View.VISIBLE);
                        i24.setVisibility(View.INVISIBLE);
                        toUnlock24.setVisibility(View.INVISIBLE);
                    }
                    break;

                case "louvre":
                    t24.setVisibility(View.VISIBLE);
                    int c24Sp = sp.getInt("hc24", 0);
                    if(c24Sp == 0){
                        editor.putInt("hc24", 1);
                        editor.commit();
                    }

                    long c24TimeSp = sp.getLong("hc24_time", 0);

                    if(c24TimeSp > time || c24TimeSp == 0){
                        editor.putLong("hc24_time", time);
                        editor.putString("hc24_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t24.setText(Constants.timeHandler(time));
                    }
                    ImageView c24_star5 = findViewById(R.id.c24_star5);
                    ImageView c24_star4 = findViewById(R.id.c24_star4);
                    int c24_rate = getRate(time);
                    int c24_stars = sp.getInt("hard_c24_stars", 0);

                    if(c24_rate - c24_stars > 0){
                        stars += (c24_rate - c24_stars);
                        editor.putInt("hard_counter_stars", stars);
                        editor.putInt("hard_c24_stars", c24_rate);
                        editor.commit();
                        starsText.setText(String.valueOf(stars));
                        switch (c24_rate){
                            case 5:
                                l24.setVisibility(View.VISIBLE);
                                c24_star4.setImageResource(R.drawable.ic_full_star);
                                c24_star5.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 4:
                                l24.setVisibility(View.VISIBLE);
                                c24_star5.setImageResource(R.drawable.ic_empty_star);
                                c24_star4.setImageResource(R.drawable.ic_full_star);
                                break;

                            case 3:
                                l24.setVisibility(View.VISIBLE);
                                c24_star4.setImageResource(R.drawable.ic_empty_star);
                                c24_star5.setImageResource(R.drawable.ic_empty_star);
                                break;
                        }
                    }
                    break;
            }
            unlockLevels();
        }
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        rewardAd.show();
    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        SharedPreferences sp = getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = sp.edit();

        stars += 1;
        editor.putInt("hard_counter_stars", stars);
        editor.commit();
        starsText.setText(String.valueOf(stars));
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    public void onRewardedVideoCompleted() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        unlockLevels();
    }
}