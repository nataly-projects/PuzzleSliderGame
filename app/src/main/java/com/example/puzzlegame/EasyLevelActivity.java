package com.example.puzzlegame;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EasyLevelActivity extends AppCompatActivity {

    private CardView c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14,
                    c15, c16, c17, c18, c19, c20, c21, c22, c23, c24;

    private TextView n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14,
            n15, n16, n17, n18, n19, n20, n21, n22, n23, n24;

    private TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14,
            t15, t16, t17, t18, t19, t20, t21, t22, t23, t24, counterText;

    private ImageView i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14,
            i15, i16, i17, i18, i19, i20, i21, i22, i23, i24;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_level);

        final SharedPreferences sp = getSharedPreferences("MyPref", 0);

        initUI();


        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EasyLevelActivity.this, EasyPuzzleActivity.class);
                intent.putExtra("level", "monkey");
                startActivityForResult(intent, Constants.INTENT_REQUEST_EASY_CODE);

            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c2Sp = sp.getInt("c2", 0);
                if(c2Sp == 1 || sp.getInt("c1", 0) == 1){
                    Intent intent = new Intent(EasyLevelActivity.this, EasyPuzzleActivity.class);
                    intent.putExtra("level", "parrot");
                    startActivityForResult(intent, Constants.INTENT_REQUEST_EASY_CODE);

                }
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c3Sp = sp.getInt("c3", 0);
                if(c3Sp == 1 || sp.getInt("c2", 0) == 1){
                    Intent intent = new Intent(EasyLevelActivity.this, EasyPuzzleActivity.class);
                    intent.putExtra("level", "tiger");
                    startActivityForResult(intent, Constants.INTENT_REQUEST_EASY_CODE);
                }
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c4Sp = sp.getInt("c4", 0);
                if(c4Sp == 1 || sp.getInt("c3", 0) == 1){
                    Intent intent = new Intent(EasyLevelActivity.this, EasyPuzzleActivity.class);
                    intent.putExtra("level", "giraff");
                    startActivityForResult(intent, Constants.INTENT_REQUEST_EASY_CODE);
                }
            }
        });

        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c5Sp = sp.getInt("c5", 0);
                if(c5Sp == 1 || sp.getInt("c4", 0) == 1){
                    Intent intent = new Intent(EasyLevelActivity.this, EasyPuzzleActivity.class);
                    intent.putExtra("level", "lion");
                    startActivityForResult(intent, Constants.INTENT_REQUEST_EASY_CODE);
                }
            }
        });

        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c6Sp = sp.getInt("c6", 0);
                if(c6Sp == 1 || sp.getInt("c5", 0) == 1){
                    Intent intent = new Intent(EasyLevelActivity.this, EasyPuzzleActivity.class);
                    intent.putExtra("level", "pinguin");
                    startActivityForResult(intent, Constants.INTENT_REQUEST_EASY_CODE);
                }
            }
        });

        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c7Sp = sp.getInt("c7", 0);
                if(c7Sp == 1 || sp.getInt("c6", 0) == 1){
                    Intent intent = new Intent(EasyLevelActivity.this, EasyPuzzleActivity.class);
                    intent.putExtra("level", "bird");
                    startActivityForResult(intent, Constants.INTENT_REQUEST_EASY_CODE);
                }
            }
        });

        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c8Sp = sp.getInt("c8", 0);
                if(c8Sp == 1 || sp.getInt("c7", 0) == 1){
                    Intent intent = new Intent(EasyLevelActivity.this, EasyPuzzleActivity.class);
                    intent.putExtra("level", "elephant");
                    startActivityForResult(intent, Constants.INTENT_REQUEST_EASY_CODE);
                }
            }
        });

        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c9Sp = sp.getInt("c9", 0);
                if(c9Sp == 1 || sp.getInt("c8", 0) == 1){
                    Intent intent = new Intent(EasyLevelActivity.this, EasyPuzzleActivity.class);
                    intent.putExtra("level", "dolphin");
                    startActivityForResult(intent, Constants.INTENT_REQUEST_EASY_CODE);
                }
            }
        });

        c10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c10Sp = sp.getInt("c10", 0);
                if(c10Sp == 1 || sp.getInt("c9", 0) == 1){
                    Intent intent = new Intent(EasyLevelActivity.this, EasyPuzzleActivity.class);
                    intent.putExtra("level", "mona");
                    startActivityForResult(intent, Constants.INTENT_REQUEST_EASY_CODE);
                }
            }
        });

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c11Sp = sp.getInt("c11", 0);
                if(c11Sp == 1 || sp.getInt("c10", 0) == 1){
                    Intent intent = new Intent(EasyLevelActivity.this, EasyPuzzleActivity.class);
                    intent.putExtra("level", "cafe");
                    startActivityForResult(intent, Constants.INTENT_REQUEST_EASY_CODE);
                }
            }
        });

        c12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c12Sp = sp.getInt("c12", 0);
                if(c12Sp == 1 || sp.getInt("c11", 0) == 1){
                    Intent intent = new Intent(EasyLevelActivity.this, EasyPuzzleActivity.class);
                    intent.putExtra("level", "chapel");
                    startActivityForResult(intent, Constants.INTENT_REQUEST_EASY_CODE);
                }
            }
        });

        c13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c13Sp = sp.getInt("c13", 0);
                if(c13Sp == 1 || sp.getInt("c12", 0) ==1){
                    Intent intent = new Intent(EasyLevelActivity.this, EasyPuzzleActivity.class);
                    intent.putExtra("level", "night");
                    startActivityForResult(intent, Constants.INTENT_REQUEST_EASY_CODE);
                }
            }
        });

        c14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c14Sp = sp.getInt("c14", 0);
                if(c14Sp == 1 || sp.getInt("c13", 0) == 1){
                    Intent intent = new Intent(EasyLevelActivity.this, EasyPuzzleActivity.class);
                    intent.putExtra("level", "kiss");
                    startActivityForResult(intent, Constants.INTENT_REQUEST_EASY_CODE);
                }
            }
        });

        c15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c15Sp = sp.getInt("c15", 0);
                if(c15Sp == 1 || sp.getInt("c14", 0) == 1){
                    Intent intent = new Intent(EasyLevelActivity.this, EasyPuzzleActivity.class);
                    intent.putExtra("level", "flower");
                    startActivityForResult(intent, Constants.INTENT_REQUEST_EASY_CODE);
                }
            }
        });

        c16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c16Sp = sp.getInt("c16", 0);
                if(c16Sp == 1 || sp.getInt("c15", 0) == 1){
                    Intent intent = new Intent(EasyLevelActivity.this, EasyPuzzleActivity.class);
                    intent.putExtra("level", "storm");
                    startActivityForResult(intent, Constants.INTENT_REQUEST_EASY_CODE);
                }
            }
        });

        c17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c17Sp = sp.getInt("c17", 0);
                if(c17Sp == 1 || sp.getInt("c16", 0) == 1){
                    Intent intent = new Intent(EasyLevelActivity.this, EasyPuzzleActivity.class);
                    intent.putExtra("level", "girl");
                    startActivityForResult(intent, Constants.INTENT_REQUEST_EASY_CODE);
                }
            }
        });

        c18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c18Sp = sp.getInt("c18", 0);
                if(c18Sp == 1 || sp.getInt("c17", 0) ==1){
                    Intent intent = new Intent(EasyLevelActivity.this, EasyPuzzleActivity.class);
                    intent.putExtra("level", "mogli");
                    startActivityForResult(intent, Constants.INTENT_REQUEST_EASY_CODE);
                }
            }
        });

        c19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c19Sp = sp.getInt("c19", 0);
                if(c19Sp == 1 || sp.getInt("c18", 0) == 1){
                    Intent intent = new Intent(EasyLevelActivity.this, EasyPuzzleActivity.class);
                    intent.putExtra("level", "lion_king");
                    startActivityForResult(intent, Constants.INTENT_REQUEST_EASY_CODE);
                }
            }
        });

        c20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c20Sp = sp.getInt("c20", 0);
                if(c20Sp == 1 || sp.getInt("c19", 0) == 1){
                    Intent intent = new Intent(EasyLevelActivity.this, EasyPuzzleActivity.class);
                    intent.putExtra("level", "aladin");
                    startActivityForResult(intent, Constants.INTENT_REQUEST_EASY_CODE);
                }
            }
        });

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c21Sp = sp.getInt("c21", 0);
                if(c21Sp == 1 || sp.getInt("c20", 0) == 1){
                    Intent intent = new Intent(EasyLevelActivity.this, EasyPuzzleActivity.class);
                    intent.putExtra("level", "mulan");
                    startActivityForResult(intent, Constants.INTENT_REQUEST_EASY_CODE);
                }
            }
        });

        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c22Sp = sp.getInt("c22", 0);
                if(c22Sp == 1 || sp.getInt("c21", 0) == 1){
                    Intent intent = new Intent(EasyLevelActivity.this, EasyPuzzleActivity.class);
                    intent.putExtra("level", "toy");
                    startActivityForResult(intent, Constants.INTENT_REQUEST_EASY_CODE);
                }
            }
        });

        c23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c23Sp = sp.getInt("c23", 0);
                if(c23Sp == 1 || sp.getInt("c22", 0) == 1){
                    Intent intent = new Intent(EasyLevelActivity.this, EasyPuzzleActivity.class);
                    intent.putExtra("level", "moana");
                    startActivityForResult(intent, Constants.INTENT_REQUEST_EASY_CODE);
                }
            }
        });

        c24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c24Sp = sp.getInt("c24", 0);
                if(c24Sp == 1 || sp.getInt("c23", 0) == 1){
                    Intent intent = new Intent(EasyLevelActivity.this, EasyPuzzleActivity.class);
                    intent.putExtra("level", "frozen");
                    startActivityForResult(intent, Constants.INTENT_REQUEST_EASY_CODE);
                }
            }
        });

    }

    private void initUI(){
        counterText = findViewById(R.id.counter);
        c1 = findViewById(R.id.c1);
        t1 = findViewById(R.id.t1);

        c2 = findViewById(R.id.c2);
        n2 = findViewById(R.id.n2);
        t2 = findViewById(R.id.t2);
        i2 = findViewById(R.id.i2);

        c3 = findViewById(R.id.c3);
        n3 = findViewById(R.id.n3);
        t3 = findViewById(R.id.t3);
        i3 = findViewById(R.id.i3);

        c4 = findViewById(R.id.c4);
        n4 = findViewById(R.id.n4);
        t4 = findViewById(R.id.t4);
        i4 = findViewById(R.id.i4);

        c5 = findViewById(R.id.c5);
        n5 = findViewById(R.id.n5);
        t5 = findViewById(R.id.t5);
        i5 = findViewById(R.id.i5);

        c6 = findViewById(R.id.c6);
        n6 = findViewById(R.id.n6);
        t6 = findViewById(R.id.t6);
        i6 = findViewById(R.id.i6);

        c7 = findViewById(R.id.c7);
        n7 = findViewById(R.id.n7);
        t7 = findViewById(R.id.t7);
        i7 = findViewById(R.id.i7);

        c8 = findViewById(R.id.c8);
        n8 = findViewById(R.id.n8);
        t8 = findViewById(R.id.t8);
        i8 = findViewById(R.id.i8);

        c9 = findViewById(R.id.c9);
        t9 = findViewById(R.id.t9);
        n9 = findViewById(R.id.n9);
        i9 = findViewById(R.id.i9);

        c10 = findViewById(R.id.c10);
        t10 = findViewById(R.id.t10);
        n10 = findViewById(R.id.n10);
        i10 = findViewById(R.id.i10);

        c11 = findViewById(R.id.c11);
        t11 = findViewById(R.id.t11);
        n11 = findViewById(R.id.n11);
        i11 = findViewById(R.id.i11);

        c12 = findViewById(R.id.c12);
        t12 = findViewById(R.id.t12);
        n12 = findViewById(R.id.n12);
        i12 = findViewById(R.id.i12);

        c13 = findViewById(R.id.c13);
        t13 = findViewById(R.id.t13);
        n13 = findViewById(R.id.n13);
        i13 = findViewById(R.id.i13);

        c14 = findViewById(R.id.c14);
        t14 = findViewById(R.id.t14);
        n14 = findViewById(R.id.n14);
        i14 = findViewById(R.id.i14);

        c15 = findViewById(R.id.c15);
        t15 = findViewById(R.id.t15);
        n15 = findViewById(R.id.n15);
        i15 = findViewById(R.id.i15);

        c16 = findViewById(R.id.c16);
        t16 = findViewById(R.id.t16);
        n16 = findViewById(R.id.n16);
        i16 = findViewById(R.id.i16);

        c17 = findViewById(R.id.c17);
        t17 = findViewById(R.id.t17);
        n17 = findViewById(R.id.n17);
        i17 = findViewById(R.id.i17);

        c18 = findViewById(R.id.c18);
        t18 = findViewById(R.id.t18);
        n18 = findViewById(R.id.n18);
        i18 = findViewById(R.id.i18);

        c19 = findViewById(R.id.c19);
        t19 = findViewById(R.id.t19);
        n19 = findViewById(R.id.n19);
        i19 = findViewById(R.id.i19);

        c20 = findViewById(R.id.c20);
        t20 = findViewById(R.id.t20);
        n20 = findViewById(R.id.n20);
        i20 = findViewById(R.id.i20);

        c21 = findViewById(R.id.c21);
        t21 = findViewById(R.id.t21);
        n21 = findViewById(R.id.n21);
        i21 = findViewById(R.id.i21);

        c22 = findViewById(R.id.c22);
        t22 = findViewById(R.id.t22);
        n22 = findViewById(R.id.n22);
        i22 = findViewById(R.id.i22);

        c23 = findViewById(R.id.c23);
        t23 = findViewById(R.id.t23);
        n23 = findViewById(R.id.n23);
        i23 = findViewById(R.id.i23);

        c24 = findViewById(R.id.c24);
        t24 = findViewById(R.id.t24);
        n24 = findViewById(R.id.n24);
        i24 = findViewById(R.id.i24);

        readFromSP();
    }

    private void readFromSP(){

        SharedPreferences sp = getSharedPreferences("MyPref", 0);

        String counter_str = sp.getString("easy_counter", "00"+"/"+Constants.EASY_LEVELS);
        counterText.setText(counter_str);

        int c1Sp = sp.getInt("c1", 0);
        if(c1Sp == 1){
            t1.setVisibility(View.VISIBLE);
            n2.setVisibility(View.VISIBLE);
            i2.setVisibility(View.INVISIBLE);
            String time = sp.getString("c1_time_str", "");
            t1.setText(time);
        }

        int c2Sp = sp.getInt("c2", 0);
        if(c2Sp == 1){
            t2.setVisibility(View.VISIBLE);
            n3.setVisibility(View.VISIBLE);
            i3.setVisibility(View.INVISIBLE);
            String time = sp.getString("c2_time_str", "");
            t2.setText(time);
        }

        int c3Sp = sp.getInt("c3", 0);
        if(c3Sp == 1){
            t3.setVisibility(View.VISIBLE);
            n4.setVisibility(View.VISIBLE);
            i4.setVisibility(View.INVISIBLE);
            String time = sp.getString("c3_time_str", "");
            t3.setText(time);
        }

        int c4Sp = sp.getInt("c4", 0);
        if(c4Sp == 1){
            t4.setVisibility(View.VISIBLE);
            n5.setVisibility(View.VISIBLE);
            i5.setVisibility(View.INVISIBLE);
            String time = sp.getString("c4_time_str", "");
            t4.setText(time);
        }

        int c5Sp = sp.getInt("c5", 0);
        if(c5Sp == 1){
            t5.setVisibility(View.VISIBLE);
            n6.setVisibility(View.VISIBLE);
            i6.setVisibility(View.INVISIBLE);
            String time = sp.getString("c5_time_str", "");
            t5.setText(time);
        }

        int c6Sp = sp.getInt("c6", 0);
        if(c6Sp == 1){
            t6.setVisibility(View.VISIBLE);
            n7.setVisibility(View.VISIBLE);
            i7.setVisibility(View.INVISIBLE);
            String time = sp.getString("c6_time_str", "");
            t6.setText(time);
        }

        int c7Sp = sp.getInt("c7", 0);
        if(c7Sp == 1){
            t7.setVisibility(View.VISIBLE);
            n8.setVisibility(View.VISIBLE);
            i8.setVisibility(View.INVISIBLE);
            String time = sp.getString("c7_time_str", "");
            t7.setText(time);
        }

        int c8Sp = sp.getInt("c8", 0);
        if(c8Sp == 1){
            t8.setVisibility(View.VISIBLE);
            n9.setVisibility(View.VISIBLE);
            i9.setVisibility(View.INVISIBLE);
            String time = sp.getString("c8_time_str", "");
            t8.setText(time);
        }

        int c9Sp = sp.getInt("c9", 0);
        if(c9Sp == 1){
            t9.setVisibility(View.VISIBLE);
            n10.setVisibility(View.VISIBLE);
            i10.setVisibility(View.INVISIBLE);
            String time = sp.getString("c9_time_str", "");
            t9.setText(time);
        }

        int c10Sp = sp.getInt("c10", 0);
        if(c10Sp == 1){
            t10.setVisibility(View.VISIBLE);
            n11.setVisibility(View.VISIBLE);
            i11.setVisibility(View.INVISIBLE);
            String time = sp.getString("c10_time_str", "");
            t10.setText(time);
        }

        int c11Sp = sp.getInt("c11", 0);
        if(c11Sp == 1){
            t11.setVisibility(View.VISIBLE);
            n12.setVisibility(View.VISIBLE);
            i12.setVisibility(View.INVISIBLE);
            String time = sp.getString("c11_time_str", "");
            t11.setText(time);
        }

        int c12Sp = sp.getInt("c12", 0);
        if(c12Sp == 1){
            t12.setVisibility(View.VISIBLE);
            n13.setVisibility(View.VISIBLE);
            i13.setVisibility(View.INVISIBLE);
            String time = sp.getString("c12_time_str", "");
            t12.setText(time);
        }

        int c13Sp = sp.getInt("c13", 0);
        if(c13Sp == 1){
            t13.setVisibility(View.VISIBLE);
            n14.setVisibility(View.VISIBLE);
            i14.setVisibility(View.INVISIBLE);
            String time = sp.getString("c13_time_str", "");
            t13.setText(time);
        }

        int c14Sp = sp.getInt("c14", 0);
        if(c14Sp == 1){
            t14.setVisibility(View.VISIBLE);
            n15.setVisibility(View.VISIBLE);
            i15.setVisibility(View.INVISIBLE);
            String time = sp.getString("c14_time_str", "");
            t14.setText(time);
        }

        int c15Sp = sp.getInt("c15", 0);
        if(c15Sp == 1){
            t15.setVisibility(View.VISIBLE);
            n16.setVisibility(View.VISIBLE);
            i16.setVisibility(View.INVISIBLE);
            String time = sp.getString("c15_time_str", "");
            t15.setText(time);
        }

        int c16Sp = sp.getInt("c16", 0);
        if(c16Sp == 1){
            t16.setVisibility(View.VISIBLE);
            n17.setVisibility(View.VISIBLE);
            i17.setVisibility(View.INVISIBLE);
            String time = sp.getString("c16_time_str", "");
            t16.setText(time);
        }

        int c17Sp = sp.getInt("c17", 0);
        if(c17Sp == 1){
            t17.setVisibility(View.VISIBLE);
            n18.setVisibility(View.VISIBLE);
            i18.setVisibility(View.INVISIBLE);
            String time = sp.getString("c17_time_str", "");
            t17.setText(time);
        }

        int c18Sp = sp.getInt("c18", 0);
        if(c18Sp == 1){
            t18.setVisibility(View.VISIBLE);
            n19.setVisibility(View.VISIBLE);
            i19.setVisibility(View.INVISIBLE);
            String time = sp.getString("c18_time_str", "");
            t18.setText(time);
        }

        int c19Sp = sp.getInt("c19", 0);
        if(c19Sp == 1){
            t19.setVisibility(View.VISIBLE);
            n20.setVisibility(View.VISIBLE);
            i20.setVisibility(View.INVISIBLE);
            String time = sp.getString("c19_time_str", "");
            t19.setText(time);
        }

        int c20Sp = sp.getInt("c20", 0);
        if(c20Sp == 1){
            t20.setVisibility(View.VISIBLE);
            n21.setVisibility(View.VISIBLE);
            i21.setVisibility(View.INVISIBLE);
            String time = sp.getString("c20_time_str", "");
            t20.setText(time);
        }

        int c21Sp = sp.getInt("c21", 0);
        if(c21Sp == 1){
            t21.setVisibility(View.VISIBLE);
            n22.setVisibility(View.VISIBLE);
            i22.setVisibility(View.INVISIBLE);
            String time = sp.getString("c21_time_str", "");
            t21.setText(time);
        }

        int c22Sp = sp.getInt("c22", 0);
        if(c22Sp == 1){
            t22.setVisibility(View.VISIBLE);
            n23.setVisibility(View.VISIBLE);
            i23.setVisibility(View.INVISIBLE);
            String time = sp.getString("c22_time_str", "");
            t22.setText(time);
        }

        int c23Sp = sp.getInt("c23", 0);
        if(c23Sp == 1){
            t23.setVisibility(View.VISIBLE);
            n24.setVisibility(View.VISIBLE);
            i24.setVisibility(View.INVISIBLE);
            String time = sp.getString("c23_time_str", "");
            t23.setText(time);
        }

        int c24Sp = sp.getInt("c24", 0);
        if(c24Sp == 1){
            t24.setVisibility(View.VISIBLE);
            String time = sp.getString("c24_time_str", "");
            t24.setText(time);
        }
    }

    private String counterHandle(){
        SharedPreferences sp = getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = sp.edit();
        String counter_str = "";

        counter = sp.getInt("int_counter_easy", 0);
        counter += 1;
        editor.commit();
        editor.putInt("int_counter_easy", counter);
        if(counter < 10){
            counter_str += "0" + counter;
        }
        else {
            counter_str += counter;
        }
        counter_str += "/"+Constants.EASY_LEVELS;
        editor.putString("easy_counter", counter_str);
        editor.commit();
        counterText.setText(counter_str);
        return counter_str;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        SharedPreferences sp = getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = sp.edit();

        if(requestCode == Constants.INTENT_REQUEST_EASY_CODE && resultCode == RESULT_OK && data != null){
            String picture = data.getStringExtra("level");
            long time = data.getLongExtra("time", 0);

            switch (picture){
                case "monkey":
                    t1.setVisibility(View.VISIBLE);
                    n2.setVisibility(View.VISIBLE);
                    i2.setVisibility(View.INVISIBLE);
                    int c1Sp = sp.getInt("c1", 0);
                    if(c1Sp == 0){
                        editor.putInt("c1", 1);
                        editor.commit();
                        counterHandle();
                    }
                    long c1TimeSp = sp.getLong("c1_time", 0);

                    if(c1TimeSp > time || c1TimeSp == 0){
                        editor.putLong("c1_time", time);
                        editor.putString("c1_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t1.setText(Constants.timeHandler(time));
                    }
                    break;

                case "parrot":
                    t2.setVisibility(View.VISIBLE);
                    n3.setVisibility(View.VISIBLE);
                    i3.setVisibility(View.INVISIBLE);
                    int c2Sp = sp.getInt("c2", 0);
                    if(c2Sp == 0){
                        editor.putInt("c2", 1);
                        editor.commit();
                        counterHandle();
                    }
                    long c2TimeSp = sp.getLong("c2_time", 0);

                    if(c2TimeSp > time || c2TimeSp == 0){
                        editor.putLong("c2_time", time);
                        editor.putString("c2_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t2.setText(Constants.timeHandler(time));
                    }
                    break;

                case "tiger":
                    n4.setVisibility(View.VISIBLE);
                    i4.setVisibility(View.INVISIBLE);
                    t3.setVisibility(View.VISIBLE);
                    int c3Sp = sp.getInt("c3", 0);
                    if(c3Sp == 0){
                        editor.putInt("c3", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c3TimeSp = sp.getLong("c3_time", 0);

                    if(c3TimeSp > time || c3TimeSp == 0){
                        editor.putLong("c3_time", time);
                        editor.putString("c3_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t3.setText(Constants.timeHandler(time));
                    }
                    break;

                case "giraff":
                    n5.setVisibility(View.VISIBLE);
                    i5.setVisibility(View.INVISIBLE);
                    t4.setVisibility(View.VISIBLE);
                    int c4Sp = sp.getInt("c4", 0);
                    if(c4Sp == 0){
                        editor.putInt("c4", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c4TimeSp = sp.getLong("c4_time", 0);

                    if(c4TimeSp > time || c4TimeSp == 0){
                        editor.putLong("c4_time", time);
                        editor.putString("c4_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t4.setText(Constants.timeHandler(time));
                    }
                    break;

                case "lion":
                    n6.setVisibility(View.VISIBLE);
                    i6.setVisibility(View.INVISIBLE);
                    t5.setVisibility(View.VISIBLE);
                    int c5Sp = sp.getInt("c5", 0);
                    if(c5Sp == 0){
                        editor.putInt("c5", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c5TimeSp = sp.getLong("c5_time", 0);

                    if(c5TimeSp > time || c5TimeSp == 0){
                        editor.putLong("c5_time", time);
                        editor.putString("c5_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t5.setText(Constants.timeHandler(time));
                    }
                    break;

                case "pinguin":
                    n7.setVisibility(View.VISIBLE);
                    i7.setVisibility(View.INVISIBLE);
                    t6.setVisibility(View.VISIBLE);
                    int c6Sp = sp.getInt("c6", 0);
                    if(c6Sp == 0){
                        editor.putInt("c6", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c6TimeSp = sp.getLong("c6_time", 0);

                    if(c6TimeSp > time || c6TimeSp == 0){
                        editor.putLong("c6_time", time);
                        editor.putString("c6_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t6.setText(Constants.timeHandler(time));
                    }
                    break;

                case "bird":
                    n8.setVisibility(View.VISIBLE);
                    i8.setVisibility(View.INVISIBLE);
                    t7.setVisibility(View.VISIBLE);
                    int c7Sp = sp.getInt("c7", 0);
                    if(c7Sp == 0){
                        editor.putInt("c7", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c7TimeSp = sp.getLong("c7_time", 0);

                    if(c7TimeSp > time || c7TimeSp == 0){
                        editor.putLong("c7_time", time);
                        editor.putString("c7_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t7.setText(Constants.timeHandler(time));
                    }
                    break;

                case "elephant":
                    n9.setVisibility(View.VISIBLE);
                    i9.setVisibility(View.INVISIBLE);
                    t8.setVisibility(View.VISIBLE);
                    int c8Sp = sp.getInt("c8", 0);
                    if(c8Sp == 0){
                        editor.putInt("c8", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c8TimeSp = sp.getLong("c8_time", 0);

                    if(c8TimeSp > time || c8TimeSp == 0){
                        editor.putLong("c8_time", time);
                        editor.putString("c8_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t8.setText(Constants.timeHandler(time));
                    }
                    break;

                case "dolphin":
                    n10.setVisibility(View.VISIBLE);
                    i10.setVisibility(View.INVISIBLE);
                    t9.setVisibility(View.VISIBLE);
                    int c9Sp = sp.getInt("c9", 0);
                    if(c9Sp == 0){
                        editor.putInt("c9", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c9TimeSp = sp.getLong("c9_time", 0);

                    if(c9TimeSp > time || c9TimeSp == 0){
                        editor.putLong("c9_time", time);
                        editor.putString("c9_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t9.setText(Constants.timeHandler(time));
                    }
                    break;

                case "cafe":
                    n12.setVisibility(View.VISIBLE);
                    i12.setVisibility(View.INVISIBLE);
                    t11.setVisibility(View.VISIBLE);
                    int c11Sp = sp.getInt("c11", 0);
                    if(c11Sp == 0){
                        editor.putInt("c11", 1);
                        editor.commit();
                        counterHandle();
                    }
                    long c11TimeSp = sp.getLong("c11_time", 0);

                    if(c11TimeSp > time || c11TimeSp == 0){
                        editor.putLong("c11_time", time);
                        editor.putString("c11_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t11.setText(Constants.timeHandler(time));
                    }
                    break;

                case "girl":
                    n18.setVisibility(View.VISIBLE);
                    i18.setVisibility(View.INVISIBLE);
                    t17.setVisibility(View.VISIBLE);
                    int c17Sp = sp.getInt("c17", 0);
                    if(c17Sp == 0){
                        editor.putInt("c17", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c17TimeSp = sp.getLong("c17_time", 0);

                    if(c17TimeSp > time || c17TimeSp == 0){
                        editor.putLong("c17_time", time);
                        editor.putString("c17_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t17.setText(Constants.timeHandler(time));
                    }
                    break;

                case "mona":
                    n11.setVisibility(View.VISIBLE);
                    i11.setVisibility(View.INVISIBLE);
                    t10.setVisibility(View.VISIBLE);
                    int c10Sp = sp.getInt("c10", 0);
                    if(c10Sp == 0){
                        editor.putInt("c10", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c10TimeSp = sp.getLong("c10_time", 0);

                    if(c10TimeSp > time || c10TimeSp == 0){
                        editor.putLong("c10_time", time);
                        editor.putString("c10_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t10.setText(Constants.timeHandler(time));
                    }
                    break;

                case "chapel":
                    n13.setVisibility(View.VISIBLE);
                    i13.setVisibility(View.INVISIBLE);
                    t12.setVisibility(View.VISIBLE);
                    int c12Sp = sp.getInt("c12", 0);
                    if(c12Sp == 0){
                        editor.putInt("c12", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c12TimeSp = sp.getLong("c12_time", 0);

                    if(c12TimeSp > time || c12TimeSp == 0){
                        editor.putLong("c12_time", time);
                        editor.putString("c12_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t12.setText(Constants.timeHandler(time));
                    }
                    break;

                case "night":
                    n14.setVisibility(View.VISIBLE);
                    i14.setVisibility(View.INVISIBLE);
                    t13.setVisibility(View.VISIBLE);
                    int c13Sp = sp.getInt("c13", 0);
                    if(c13Sp == 0){
                        editor.putInt("c13", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c13TimeSp = sp.getLong("c13_time", 0);

                    if(c13TimeSp > time || c13TimeSp == 0){
                        editor.putLong("c13_time", time);
                        editor.putString("c13_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t13.setText(Constants.timeHandler(time));
                    }
                    break;

                case "kiss":
                    n15.setVisibility(View.VISIBLE);
                    i15.setVisibility(View.INVISIBLE);
                    t14.setVisibility(View.VISIBLE);
                    int c14Sp = sp.getInt("c14", 0);
                    if(c14Sp == 0){
                        editor.putInt("c14", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c14TimeSp = sp.getLong("c14_time", 0);

                    if(c14TimeSp > time || c14TimeSp == 0){
                        editor.putLong("c14_time", time);
                        editor.putString("c14_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t14.setText(Constants.timeHandler(time));
                    }
                    break;

                case "flower":
                    n16.setVisibility(View.VISIBLE);
                    i16.setVisibility(View.INVISIBLE);
                    t15.setVisibility(View.VISIBLE);
                    int c15Sp = sp.getInt("c15", 0);
                    if(c15Sp == 0){
                        editor.putInt("c15", 1);
                        editor.commit();
                        counterHandle();
                    }
                    long c15TimeSp = sp.getLong("c15_time", 0);

                    if(c15TimeSp > time || c15TimeSp == 0){
                        editor.putLong("c15_time", time);
                        editor.putString("c15_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t15.setText(Constants.timeHandler(time));
                    }
                    break;

                case "storm":
                    n17.setVisibility(View.VISIBLE);
                    i17.setVisibility(View.INVISIBLE);
                    t16.setVisibility(View.VISIBLE);
                    int c16Sp = sp.getInt("c16", 0);
                    if(c16Sp == 0){
                        editor.putInt("c16", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c16TimeSp = sp.getLong("c16_time", 0);

                    if(c16TimeSp > time || c16TimeSp == 0){
                        editor.putLong("c16_time", time);
                        editor.putString("c16_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t16.setText(Constants.timeHandler(time));
                    }
                    break;

                case "mogli":
                    n19.setVisibility(View.VISIBLE);
                    i19.setVisibility(View.INVISIBLE);
                    t18.setVisibility(View.VISIBLE);
                    int c18Sp = sp.getInt("c18", 0);
                    if(c18Sp == 0){
                        editor.putInt("c18", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c18TimeSp = sp.getLong("c18_time", 0);

                    if(c18TimeSp > time || c18TimeSp == 0){
                        editor.putLong("c18_time", time);
                        editor.putString("c18_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t18.setText(Constants.timeHandler(time));
                    }
                    break;

                case "lion_king":
                    n20.setVisibility(View.VISIBLE);
                    i20.setVisibility(View.INVISIBLE);
                    t19.setVisibility(View.VISIBLE);
                    int c19Sp = sp.getInt("c19", 0);
                    if(c19Sp == 0){
                        editor.putInt("c19", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c19TimeSp = sp.getLong("c19_time", 0);

                    if(c19TimeSp > time || c19TimeSp == 0){
                        editor.putLong("c19_time", time);
                        editor.putString("c19_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t19.setText(Constants.timeHandler(time));
                    }
                    break;

                case "aladin":
                    n21.setVisibility(View.VISIBLE);
                    i21.setVisibility(View.INVISIBLE);
                    t20.setVisibility(View.VISIBLE);
                    int c20Sp = sp.getInt("c20", 0);
                    if(c20Sp == 0){
                        editor.putInt("c20", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c20TimeSp = sp.getLong("c20_time", 0);

                    if(c20TimeSp > time || c20TimeSp == 0){
                        editor.putLong("c20_time", time);
                        editor.putString("c20_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t20.setText(Constants.timeHandler(time));
                    }
                    break;

                case "mulan":
                    n22.setVisibility(View.VISIBLE);
                    i22.setVisibility(View.INVISIBLE);
                    t21.setVisibility(View.VISIBLE);
                    int c21Sp = sp.getInt("c21", 0);
                    if(c21Sp == 0){
                        editor.putInt("c21", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c21TimeSp = sp.getLong("c21_time", 0);

                    if(c21TimeSp > time || c21TimeSp == 0){
                        editor.putLong("c21_time", time);
                        editor.putString("c21_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t21.setText(Constants.timeHandler(time));
                    }
                    break;


                case "toy":
                    n23.setVisibility(View.VISIBLE);
                    i23.setVisibility(View.INVISIBLE);
                    t22.setVisibility(View.VISIBLE);
                    int c22Sp = sp.getInt("c22", 0);
                    if(c22Sp == 0){
                        editor.putInt("c22", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c22TimeSp = sp.getLong("c22_time", 0);

                    if(c22TimeSp > time || c22TimeSp == 0){
                        editor.putLong("c22_time", time);
                        editor.putString("c22_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t22.setText(Constants.timeHandler(time));
                    }
                    break;

                case "moana":
                    n24.setVisibility(View.VISIBLE);
                    i24.setVisibility(View.INVISIBLE);
                    t23.setVisibility(View.VISIBLE);
                    int c23Sp = sp.getInt("c23", 0);
                    if(c23Sp == 0){
                        editor.putInt("c23", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c23TimeSp = sp.getLong("c23_time", 0);

                    if(c23TimeSp > time || c23TimeSp == 0){
                        editor.putLong("c23_time", time);
                        editor.putString("c23_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t23.setText(Constants.timeHandler(time));
                    }
                    break;

                case "frozen":
                    t24.setVisibility(View.VISIBLE);
                    int c24Sp = sp.getInt("c24", 0);
                    if(c24Sp == 0){
                        editor.putInt("c24", 1);
                        editor.commit();
                        counterHandle();
                    }

                    long c24TimeSp = sp.getLong("c24_time", 0);

                    if(c24TimeSp > time || c24TimeSp == 0){
                        editor.putLong("c24_time", time);
                        editor.putString("c24_time_str", Constants.timeHandler(time));
                        editor.commit();
                        t24.setText(Constants.timeHandler(time));
                    }
                    break;
            }
        }
    }

}