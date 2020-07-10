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

public class HardPuzzleActivity extends AppCompatActivity {

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
    private ImageView image, fullImage;
    private static Animation blinkAnim;
    private boolean visibility = false, isPlay = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_puzzle);

        images = new ArrayList<>();
        intent = getIntent();
        level = intent.getStringExtra("level");
        image = findViewById(R.id.image);
        fullImage = findViewById(R.id.fullImage);
        timer = findViewById(R.id.timer);
        finish = findViewById(R.id.finish);

        timer.setBase(SystemClock.elapsedRealtime());
        timer.start();

        blinkAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);


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
        Constants.COLUMNS = 5;
        Constants.DIMENSIONS = Constants.COLUMNS * Constants.COLUMNS;
        gridView = findViewById(R.id.grid);
        gridView.setNumColumns(Constants.COLUMNS);
        gridView.setActivity("hard");
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

                case "16":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(16));
                    button.setBackground(drawable);
                    break;

                case "17":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(17));
                    button.setBackground(drawable);
                    break;

                case "18":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(18));
                    button.setBackground(drawable);
                    break;

                case "19":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(19));
                    button.setBackground(drawable);
                    break;

                case "20":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(20));
                    button.setBackground(drawable);
                    break;

                case "21":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(21));
                    button.setBackground(drawable);
                    break;

                case "22":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(22));
                    button.setBackground(drawable);
                    break;

                case "23":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(23));
                    button.setBackground(drawable);
                    break;

                case "24":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(24));
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
            case 2:
            case 3:
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

            case 4:
                if(direction.equals(Constants.LEFT)){
                    swap(context, position, -1);
                }
                else if(direction.equals(Constants.DOWN)){
                    swap(context, position, Constants.COLUMNS);
                }
                break;

            case 5:
            case 10:
            case 15:
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

            case 6:
            case 7:
            case 8:
            case 11:
            case 12:
            case 13:
            case 16:
            case 17:
            case 18:
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

            case 9:
            case 14:
            case 19:
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

            case 20:
                if(direction.equals(Constants.UP)){
                    swap(context, position, -Constants.COLUMNS);
                }
                else if(direction.equals(Constants.RIGHT)){
                    swap(context, position, 1);
                }
                break;

            case 21:
            case 22:
            case 23:
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

            case 24:
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
     if(level.equals("pisa")) {
         image.setImageResource(R.drawable.pisa);
         bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pisa);
         width = bitmap.getWidth()/Constants.COLUMNS;
         height = bitmap.getHeight()/Constants.COLUMNS;
     }
     else if(level.equals("colosseum")) {
         image.setImageResource(R.drawable.colosseum);
         bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.colosseum);
         width = bitmap.getWidth()/Constants.COLUMNS;
         height = bitmap.getHeight()/Constants.COLUMNS;
     }
     else if(level.equals("eiffel")) {
         image.setImageResource(R.drawable.eiffel);
         bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.eiffel);
         width = bitmap.getWidth()/Constants.COLUMNS;
         height = bitmap.getHeight()/Constants.COLUMNS;
     }
     else if(level.equals("pyramid")) {
         image.setImageResource(R.drawable.pyramid);
         bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pyramid);
         width = bitmap.getWidth()/Constants.COLUMNS;
         height = bitmap.getHeight()/Constants.COLUMNS;
     }
     else if(level.equals("hollywood")) {
         image.setImageResource(R.drawable.hollywood);
         bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hollywood);
         width = bitmap.getWidth()/Constants.COLUMNS;
         height = bitmap.getHeight()/Constants.COLUMNS;
     }
     else if(level.equals("dead")) {
         image.setImageResource(R.drawable.dead);
         bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dead);
         width = bitmap.getWidth()/Constants.COLUMNS;
         height = bitmap.getHeight()/Constants.COLUMNS;
     }
     else if(level.equals("saara")) {
         image.setImageResource(R.drawable.saara);
         bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.saara);
         width = bitmap.getWidth()/Constants.COLUMNS;
         height = bitmap.getHeight()/Constants.COLUMNS;
     }
     else if(level.equals("madagascar")) {
         image.setImageResource(R.drawable.madagascar);
         bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.madagascar);
         width = bitmap.getWidth()/Constants.COLUMNS;
         height = bitmap.getHeight()/Constants.COLUMNS;
     }
     else if(level.equals("lemur")) {
         image.setImageResource(R.drawable.lemur);
         bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lemur);
         width = bitmap.getWidth()/Constants.COLUMNS;
         height = bitmap.getHeight()/Constants.COLUMNS;
     }
     else if(level.equals("singapore")) {
         image.setImageResource(R.drawable.singapore);
         bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.singapore);
         width = bitmap.getWidth()/Constants.COLUMNS;
         height = bitmap.getHeight()/Constants.COLUMNS;
     }
     else if(level.equals("garden")) {
         image.setImageResource(R.drawable.garden);
         bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.garden);
         width = bitmap.getWidth()/Constants.COLUMNS;
         height = bitmap.getHeight()/Constants.COLUMNS;
     }
     else if(level.equals("cherry")) {
         image.setImageResource(R.drawable.cherry);
         bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cherry);
         width = bitmap.getWidth()/Constants.COLUMNS;
         height = bitmap.getHeight()/Constants.COLUMNS;
     }
     else if(level.equals("japan")) {
         image.setImageResource(R.drawable.japan);
         bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.japan);
         width = bitmap.getWidth()/Constants.COLUMNS;
         height = bitmap.getHeight()/Constants.COLUMNS;
     }
     else if(level.equals("ice")) {
         image.setImageResource(R.drawable.iceb);
         bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.iceb);
         width = bitmap.getWidth()/Constants.COLUMNS;
         height = bitmap.getHeight()/Constants.COLUMNS;
     }
     else if(level.equals("rocket")) {
         image.setImageResource(R.drawable.rocket);
         bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rocket);
         width = bitmap.getWidth()/Constants.COLUMNS;
         height = bitmap.getHeight()/Constants.COLUMNS;
     }
     else if(level.equals("bodha")) {
         image.setImageResource(R.drawable.bodha);
         bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bodha);
         width = bitmap.getWidth()/Constants.COLUMNS;
         height = bitmap.getHeight()/Constants.COLUMNS;
     }
     else if(level.equals("think")) {
         image.setImageResource(R.drawable.think);
         bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.think);
         width = bitmap.getWidth()/Constants.COLUMNS;
         height = bitmap.getHeight()/Constants.COLUMNS;
     }
     else if(level.equals("egypt")) {
         image.setImageResource(R.drawable.egypt);
         bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.egypt);
         width = bitmap.getWidth()/Constants.COLUMNS;
         height = bitmap.getHeight()/Constants.COLUMNS;
     }
     else if(level.equals("eli")) {
         image.setImageResource(R.drawable.eli);
         bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.eli);
         width = bitmap.getWidth()/Constants.COLUMNS;
         height = bitmap.getHeight()/Constants.COLUMNS;
     }
     else if(level.equals("holocaust")) {
         image.setImageResource(R.drawable.holocaust);
         bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.holocaust);
         width = bitmap.getWidth()/Constants.COLUMNS;
         height = bitmap.getHeight()/Constants.COLUMNS;
     }
     else if(level.equals("army")) {
         image.setImageResource(R.drawable.army);
         bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.army);
         width = bitmap.getWidth()/Constants.COLUMNS;
         height = bitmap.getHeight()/Constants.COLUMNS;
     }
     else if(level.equals("women")) {
         image.setImageResource(R.drawable.women);
         bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.women);
         width = bitmap.getWidth()/Constants.COLUMNS;
         height = bitmap.getHeight()/Constants.COLUMNS;
     }
     else if(level.equals("dubai")) {
         image.setImageResource(R.drawable.dubai);
         bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dubai);
         width = bitmap.getWidth()/Constants.COLUMNS;
         height = bitmap.getHeight()/Constants.COLUMNS;
     }
     else if(level.equals("louvre")) {
         image.setImageResource(R.drawable.louvre);
         bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.louvre);
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