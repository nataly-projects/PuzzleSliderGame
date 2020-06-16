package com.example.puzzlegame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EasyPuzzleActivity extends AppCompatActivity {

    private static String[] tileList;
    private static GridView gridView;
    private static int columnWidth, columnHeight;
    private static String level;
    private static List<Integer> images;
    private static Activity activity;
    private static Intent intent;
    private static boolean isSolved = false;
    private static ArrayList<Bitmap> chunkedImage;

    private static Chronometer timer;
    private static TextView finish;
    private ImageView image, fullImage, pp;
    private boolean visibility = false, isPlay = true;
    private static Animation blinkAnim;
    private long lastPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);

        images = new ArrayList<>();
        intent = getIntent();
        level = intent.getStringExtra("level");
        image = findViewById(R.id.image);
        fullImage = findViewById(R.id.fullImage);
        timer = findViewById(R.id.timer);
        finish = findViewById(R.id.finish);
        //pp = findViewById(R.id.pp);

        timer.setBase(SystemClock.elapsedRealtime());
        timer.start();

        blinkAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);

    /*    pp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isPlay){
                    lastPause = SystemClock.elapsedRealtime();
                    timer.stop();
                    isPlay = false;
                    pp.setImageResource(R.drawable.ic_play);
                }
                else{
                    if (lastPause != 0){
                        timer.setBase(timer.getBase() + SystemClock.elapsedRealtime() - lastPause);
                    }
                    else{
                        timer.setBase(SystemClock.elapsedRealtime());
                    }
                    timer.start();
                    isPlay = true;
                    pp.setImageResource(R.drawable.ic_pause);
                }
            }
        }); */

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(visibility){
                    fullImage.setVisibility(View.INVISIBLE);
                    visibility = false;
                }
                else{
                    visibility = true;
                    fullImage.setVisibility(View.VISIBLE);
                    fullImage.setImageDrawable(image.getDrawable());
                }
            }

        });

        fullImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(visibility){
                    fullImage.setVisibility(View.INVISIBLE);
                    visibility = false;
                }
            }
        });

        activity = this;
        init();
        shuffle();
        setDimensions();
        splitImage();
    }

    private void init() {
        Constants.COLUMNS = 3;
        Constants.DIMENSIONS = Constants.COLUMNS * Constants.COLUMNS;
        gridView = findViewById(R.id.grid);
        gridView.setNumColumns(Constants.COLUMNS);
        gridView.setActivity("easy");
        tileList = new String[Constants.DIMENSIONS];

        for (int i = 0; i < Constants.DIMENSIONS; i++) {
            tileList[i] = String.valueOf(i);
        }
    }

    private void shuffle(){

        int index;
        String temp;
        Random random = new Random();

        for(int i = tileList.length-1; i > 0; i--){
            index = random.nextInt(i+1);
            temp = tileList[index];
            tileList[index] = tileList[i];
            tileList[i] = temp;
        }
    }

    private static void display(Context context){
        ArrayList<Button> buttons = new ArrayList<>();
        Button button;
        Drawable drawable;
        for(int i = 0; i < tileList.length; i++){
            button = new Button(context);

            switch (tileList[i]){
                case "0":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(0));
                    button.setBackground(drawable);
                    break;

                case "1":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(1));
                    button.setBackground(drawable);
                    //button.setBackgroundResource(images.get(1));
                    break;

                case "2":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(2));
                    button.setBackground(drawable);
                    //button.setBackgroundResource(images.get(2));
                    break;

                case "3":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(3));
                    button.setBackground(drawable);
                    //button.setBackgroundResource(images.get(3));
                    break;

                case "4":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(4));
                    button.setBackground(drawable);
                    //button.setBackgroundResource(images.get(4));
                    break;

                case "5":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(5));
                    button.setBackground(drawable);
                    //button.setBackgroundResource(images.get(5));
                    break;

                case "6":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(6));
                    button.setBackground(drawable);
                    //button.setBackgroundResource(images.get(6));
                    break;

                case "7":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(7));
                    button.setBackground(drawable);
                    //button.setBackgroundResource(images.get(7));
                    break;

                case "8":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(8));
                    button.setBackground(drawable);
                    //button.setBackgroundResource(images.get(8));
                    break;
            }

            buttons.add(button);
        }
        gridView.setAdapter(new Adapter(buttons, columnWidth, columnHeight));
    }

    private int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");

        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }

        return result;
    }

    private void setDimensions() {
        ViewTreeObserver viewTreeObserver = gridView.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                gridView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int displayWidth = gridView.getMeasuredWidth();
                int displayHeight = gridView.getMeasuredHeight();

                int statusbarHeight = getStatusBarHeight(getApplicationContext());
                int requiredHeight = displayHeight - statusbarHeight;

                columnWidth = displayWidth/Constants.COLUMNS;
                columnHeight = requiredHeight/Constants.COLUMNS;

                display(getApplicationContext());
            }
        });
    }

    public static void moveTiles(Context context, String direction, int position){

        if(position == 0){

            if(direction.equals(Constants.RIGHT)){
                swap(context, position, 1);
            }
            else if(direction.equals(Constants.DOWN)){
                swap(context, position, Constants.COLUMNS);
            }
        }

        else if(position == 1){
            if(direction.equals(Constants.RIGHT)){
                swap(context, position, 1);
            }
            else if(direction.equals(Constants.DOWN)){
                swap(context, position, Constants.COLUMNS);
            }
            else if(direction.equals(Constants.LEFT)){
                swap(context, position, -1);
            }
        }
        else if(position == 2){

            if(direction.equals(Constants.DOWN)){
                swap(context, position, Constants.COLUMNS);
            }
            else if(direction.equals(Constants.LEFT)){
                swap(context, position, -1);
            }
        }
        else if(position == 3){
            if(direction.equals(Constants.RIGHT)){
                swap(context, position, 1);
            }
            else if(direction.equals(Constants.DOWN)){
                swap(context, position, Constants.COLUMNS);
            }
            else if(direction.equals(Constants.UP)){
                swap(context, position, -Constants.COLUMNS);
            }
        }
        else if(position == 4){
            if(direction.equals(Constants.RIGHT)){
                swap(context, position, 1);
            }
            else if(direction.equals(Constants.DOWN)){
                swap(context, position, Constants.COLUMNS);
            }
            else if(direction.equals(Constants.UP)){
                swap(context, position, -Constants.COLUMNS);
            }
            else if(direction.equals(Constants.LEFT)){
                swap(context, position, -1);
            }
        }

        else if(position == 5){
            if(direction.equals(Constants.LEFT)){
                swap(context, position, -1);
            }
            else if(direction.equals(Constants.DOWN)){
                swap(context, position, Constants.COLUMNS);
            }
            else if(direction.equals(Constants.UP)){
                swap(context, position, -Constants.COLUMNS);
            }
        }

        else if(position == 6){
            if(direction.equals(Constants.RIGHT)){
                swap(context, position, 1);
            }
            else if(direction.equals(Constants.UP)){
                swap(context, position, -Constants.COLUMNS);
            }
        }
        else if(position == 7){
            if(direction.equals(Constants.RIGHT)){
                swap(context, position, 1);
            }
            else if(direction.equals(Constants.LEFT)){
                swap(context, position, -1);
            }
            else if(direction.equals(Constants.UP)){
                swap(context, position, -Constants.COLUMNS);
            }
        }
        else if(position == 8){
            if(direction.equals(Constants.LEFT)){
                swap(context, position, -1);
            }
            else if(direction.equals(Constants.UP)){
                swap(context, position, -Constants.COLUMNS);
            }
        }

    }

    private static void swap(Context context, int currentPosition, int swap){
        String newPosition = tileList[currentPosition+swap];
        tileList[currentPosition+swap] = tileList[currentPosition];
        tileList[currentPosition] = newPosition;
        display(context);

        isSolved();
        if(isSolved){
            timer.stop();
            final long time = SystemClock.elapsedRealtime() - timer.getBase();
            timer.setVisibility(View.INVISIBLE);
            finish.setVisibility(View.VISIBLE);
            finish.startAnimation(blinkAnim);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    intent.putExtra("level", level);
                    intent.putExtra("time", time);
                    activity.setResult(Activity.RESULT_OK, intent);
                    activity.finish();
                }
            }, 2000);
        }
    }

    private static void isSolved() {

        boolean solved = false;

        for (int i = 0; i < tileList.length; i++) {
            if (tileList[i].equals(String.valueOf(i))) {
                solved = true;
            } else {
                solved = false;
                break;
            }
        }
        isSolved = solved;
    }


    private void splitImage() {
        Bitmap bitmap = null;
        int width = 0;
        int height = 0;

        // Getting the scaled bitmap of the source image
        if(level.equals("lion")) {
            image.setImageResource(R.drawable.lion);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lion);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("monkey")) {
            image.setImageResource(R.drawable.monkey);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.monkey);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("parrot")) {
            image.setImageResource(R.drawable.parrot);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.parrot);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("tiger")) {
            image.setImageResource(R.drawable.tiger);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tiger);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("giraff")) {
            image.setImageResource(R.drawable.giraffe);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.giraffe);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("pinguin")) {
            image.setImageResource(R.drawable.pinguin);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pinguin);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("bird")) {
            image.setImageResource(R.drawable.bird);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bird);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("elephant")) {
            image.setImageResource(R.drawable.elephant);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.elephant);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("dolphin")) {
            image.setImageResource(R.drawable.dolphin);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dolphin);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }

        else if(level.equals("chapel")) {
            image.setImageResource(R.drawable.chapel);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.chapel);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("cafe")) {
            image.setImageResource(R.drawable.cafe);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cafe);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("mona")) {
            image.setImageResource(R.drawable.mona);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mona);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("girl")) {
            image.setImageResource(R.drawable.girl);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.girl);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("flower")) {
            image.setImageResource(R.drawable.flower);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.flower);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("kiss")) {
            image.setImageResource(R.drawable.kiss);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.kiss);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("storm")) {
            image.setImageResource(R.drawable.storm);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.storm);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("night")) {
            image.setImageResource(R.drawable.night);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.night);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("mogli")) {
            image.setImageResource(R.drawable.mogli);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mogli);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("lion_king")) {
            image.setImageResource(R.drawable.lion_king);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lion_king);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("aladin")) {
            image.setImageResource(R.drawable.aladin);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.aladin);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("mulan")) {
            image.setImageResource(R.drawable.mulan);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mulan);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("toy")) {
            image.setImageResource(R.drawable.toy);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.toy);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("moana")) {
            image.setImageResource(R.drawable.moana);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.moana);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("frozen")) {
            image.setImageResource(R.drawable.frozen);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.frozen);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }

        // To store all the small image chunks in bitmap format in this list
        chunkedImage = new ArrayList<Bitmap>(Constants.DIMENSIONS);

        // picture perfectly splits into square chunks
        int yCoord = 0;
        for (int y = 0; y < Constants.COLUMNS; ++y) {
            int xCoord = 0;
            for (int x = 0; x < Constants.COLUMNS; ++x) {
                chunkedImage.add(Bitmap.createBitmap(bitmap, xCoord, yCoord, width, height));
                xCoord += width;
            }
            yCoord += height;
        }

    }

}