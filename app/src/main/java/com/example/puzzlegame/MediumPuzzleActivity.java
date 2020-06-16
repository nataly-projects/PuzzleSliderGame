package com.example.puzzlegame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MediumPuzzleActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_medium_puzzle);

        images = new ArrayList<>();
        intent = getIntent();
        level = intent.getStringExtra("level");
        image = findViewById(R.id.image);
        fullImage = findViewById(R.id.fullImage);
        timer = findViewById(R.id.timer);
        //pp = findViewById(R.id.pp);
        finish = findViewById(R.id.finish);

        timer.setBase(SystemClock.elapsedRealtime());
        timer.start();

        blinkAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);

     /*   pp.setOnClickListener(new View.OnClickListener() {
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
        Constants.COLUMNS = 4;
        Constants.DIMENSIONS = Constants.COLUMNS * Constants.COLUMNS;
        gridView = findViewById(R.id.grid);
        gridView.setNumColumns(Constants.COLUMNS);
        gridView.setActivity("medium");
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
                    break;

                case "2":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(2));
                    button.setBackground(drawable);
                    break;

                case "3":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(3));
                    button.setBackground(drawable);
                    break;

                case "4":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(4));
                    button.setBackground(drawable);
                    break;

                case "5":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(5));
                    button.setBackground(drawable);
                    break;

                case "6":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(6));
                    button.setBackground(drawable);
                    break;

                case "7":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(7));
                    button.setBackground(drawable);
                    break;

                case "8":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(8));
                    button.setBackground(drawable);
                    break;

                case "9":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(9));
                    button.setBackground(drawable);
                    break;

                case "10":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(10));
                    button.setBackground(drawable);
                    break;

                case "11":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(11));
                    button.setBackground(drawable);
                    break;

                case "12":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(12));
                    button.setBackground(drawable);
                    break;

                case "13":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(13));
                    button.setBackground(drawable);
                    break;

                case "14":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(14));
                    button.setBackground(drawable);
                    break;

                case "15":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(15));
                    button.setBackground(drawable);
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

        switch (position){
            case 0:
                if(direction.equals(Constants.RIGHT)){
                    swap(context, position, 1);
                }
                else if(direction.equals(Constants.DOWN)){
                    swap(context, position, Constants.COLUMNS);
                }
                break;

            case 1:
                if(direction.equals(Constants.RIGHT)){
                    swap(context, position, 1);
                }
                else if(direction.equals(Constants.DOWN)){
                    swap(context, position, Constants.COLUMNS);
                }
                else if(direction.equals(Constants.LEFT)){
                    swap(context, position, -1);
                }
                break;

            case 2:
                if(direction.equals(Constants.DOWN)){
                    swap(context, position, Constants.COLUMNS);
                }
                else if(direction.equals(Constants.LEFT)){
                    swap(context, position, -1);
                }
                if(direction.equals(Constants.RIGHT)){
                    swap(context, position, 1);
                }
                break;

            case 3:
                 if(direction.equals(Constants.LEFT)){
                    swap(context, position, -1);
                }
                else if(direction.equals(Constants.DOWN)){
                    swap(context, position, Constants.COLUMNS);
                }
                break;

            case 4:
                if(direction.equals(Constants.RIGHT)){
                    swap(context, position, 1);
                }
                else if(direction.equals(Constants.DOWN)){
                    swap(context, position, Constants.COLUMNS);
                }
                else if(direction.equals(Constants.UP)){
                    swap(context, position, -Constants.COLUMNS);
                }
                break;

            case 5:
            case 6:
            case 9:
            case 10:
                if(direction.equals(Constants.RIGHT)){
                    swap(context, position, 1);
                }
                else if(direction.equals(Constants.UP)){
                    swap(context, position, -Constants.COLUMNS);
                }
                else if(direction.equals(Constants.LEFT)){
                    swap(context, position, -1);
                }
                else if(direction.equals(Constants.DOWN)){
                    swap(context, position, Constants.COLUMNS);
                }
                break;

            case 7:
                if(direction.equals(Constants.DOWN)){
                    swap(context, position, Constants.COLUMNS);
                }
                else if(direction.equals(Constants.LEFT)){
                    swap(context, position, -1);
                }
                else if(direction.equals(Constants.UP)){
                    swap(context, position, -Constants.COLUMNS);
                }
                break;

            case 8:
                if(direction.equals(Constants.DOWN)){
                    swap(context, position, Constants.COLUMNS);
                }
                else if(direction.equals(Constants.UP)){
                    swap(context, position, -Constants.COLUMNS);
                }
                else if(direction.equals(Constants.RIGHT)){
                    swap(context, position, 1);
                }
                break;

            case 11:
                if(direction.equals(Constants.DOWN)){
                    swap(context, position, Constants.COLUMNS);
                }
                else if(direction.equals(Constants.UP)){
                    swap(context, position, -Constants.COLUMNS);
                }
                else if(direction.equals(Constants.LEFT)){
                    swap(context, position, -1);
                }
                break;

            case 12:
                if(direction.equals(Constants.UP)){
                    swap(context, position, -Constants.COLUMNS);
                }
                else if(direction.equals(Constants.RIGHT)){
                    swap(context, position, 1);
                }
                break;

            case 13:
            case 14:
                if(direction.equals(Constants.UP)){
                    swap(context, position, -Constants.COLUMNS);
                }
                else if(direction.equals(Constants.RIGHT)){
                    swap(context, position, 1);
                }
                else if(direction.equals(Constants.LEFT)){
                    swap(context, position, -1);
                }
                break;

            case 15:
                if(direction.equals(Constants.UP)){
                    swap(context, position, -Constants.COLUMNS);
                }
                else if(direction.equals(Constants.LEFT)){
                    swap(context, position, -1);
                }
                break;
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
            }, 3000);
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
        if(level.equals("sunset")) {
            image.setImageResource(R.drawable.sunset);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sunset);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("park")) {
            image.setImageResource(R.drawable.park);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.park);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("tree")) {
            image.setImageResource(R.drawable.tree);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tree);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("star")) {
            image.setImageResource(R.drawable.star);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.star);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("volcano")) {
            image.setImageResource(R.drawable.volcano);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.volcano);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("ice")) {
            image.setImageResource(R.drawable.ice);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ice);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("waterfall")) {
            image.setImageResource(R.drawable.waterfall);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.waterfall);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("lighthouse")) {
            image.setImageResource(R.drawable.lighthouse);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lighthouse);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("zohar")) {
            image.setImageResource(R.drawable.zohar);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.zohar);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("salt")) {
            image.setImageResource(R.drawable.salt);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.salt);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("antartica")) {
            image.setImageResource(R.drawable.antartica);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.antartica);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("avatar")) {
            image.setImageResource(R.drawable.avatar);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.avatar);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("color")) {
            image.setImageResource(R.drawable.color);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.color);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("toros")) {
            image.setImageResource(R.drawable.toros);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.toros);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("punta")) {
            image.setImageResource(R.drawable.punta);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.punta);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("elevator")) {
            image.setImageResource(R.drawable.elevator);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.elevator);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("lake")) {
            image.setImageResource(R.drawable.lake);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lake);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("church")) {
            image.setImageResource(R.drawable.church);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.church);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("monument")) {
            image.setImageResource(R.drawable.monument);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.monument);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("easter")) {
            image.setImageResource(R.drawable.easter);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.easter);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("barcelona")) {
            image.setImageResource(R.drawable.barcelona);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.barcelona);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("greece")) {
            image.setImageResource(R.drawable.greece);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.greece);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("batad")) {
            image.setImageResource(R.drawable.batad);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batad);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("cambodia")) {
            image.setImageResource(R.drawable.cambodia);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cambodia);
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