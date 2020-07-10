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

public class ExpertPuzzleActivity extends AppCompatActivity {

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
    private boolean visibility = false, isPlay = true;
    private static Animation blinkAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_puzzle);

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
        Constants.COLUMNS = 6;
        Constants.DIMENSIONS = Constants.COLUMNS * Constants.COLUMNS;
        gridView = findViewById(R.id.grid);
        gridView.setNumColumns(Constants.COLUMNS);
        gridView.setActivity("veryHard");
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

                case "25":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(25));
                    button.setBackground(drawable);
                    break;

                case "26":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(26));
                    button.setBackground(drawable);
                    break;

                case "27":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(27));
                    button.setBackground(drawable);
                    break;

                case "28":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(28));
                    button.setBackground(drawable);
                    break;

                case "29":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(29));
                    button.setBackground(drawable);
                    break;

                case "30":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(30));
                    button.setBackground(drawable);
                    break;

                case "31":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(31));
                    button.setBackground(drawable);
                    break;

                case "32":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(32));
                    button.setBackground(drawable);
                    break;

                case "33":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(33));
                    button.setBackground(drawable);
                    break;

                case "34":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(34));
                    button.setBackground(drawable);
                    break;

                case "35":
                    drawable = new BitmapDrawable(context.getResources(),chunkedImage.get(35));
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
            case 4:
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

            case 5:
                if(direction.equals(Constants.LEFT)){
                    swap(context, position, -1);
                }
                else if(direction.equals(Constants.DOWN)){
                    swap(context, position, Constants.COLUMNS);
                }
                break;

            case 6:
            case 12:
            case 18:
            case 24:
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

            case 7:
            case 8:
            case 9:
            case 10:
            case 13:
            case 14:
            case 15:
            case 16:
            case 19:
            case 20:
            case 21:
            case 22:
            case 25:
            case 26:
            case 27:
            case 28:
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

            case 11:
            case 17:
            case 23:
            case 29:
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

            case 30:
                if(direction.equals(Constants.UP)){
                    swap(context, position, -Constants.COLUMNS);
                }
                else if(direction.equals(Constants.RIGHT)){
                    swap(context, position, 1);
                }
                break;

            case 31:
            case 32:
            case 33:
            case 34:
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

            case 35:
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
        if(level.equals("taj")) {
            image.setImageResource(R.drawable.taj);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.taj);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("machu")) {
            image.setImageResource(R.drawable.machu);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.machu);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("corcovado")) {
            image.setImageResource(R.drawable.corcovado);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.corcovado);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("china")) {
            image.setImageResource(R.drawable.china);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.china);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("statue")) {
            image.setImageResource(R.drawable.statue);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.statue);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("sydney")) {
            image.setImageResource(R.drawable.sydney);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sydney);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("cobra")) {
            image.setImageResource(R.drawable.cobra);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cobra);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("twin")) {
            image.setImageResource(R.drawable.twin);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.twin);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("niagara")) {
            image.setImageResource(R.drawable.niagara);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.niagara);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("geyser")) {
            image.setImageResource(R.drawable.geyser);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.geyser);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("frida")) {
            image.setImageResource(R.drawable.frida);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.frida);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("napoleon")) {
            image.setImageResource(R.drawable.napoleon);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.napoleon);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("michael")) {
            image.setImageResource(R.drawable.michael);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.michael);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("van")) {
            image.setImageResource(R.drawable.van);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.van);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("shout")) {
            image.setImageResource(R.drawable.shout);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.shout);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("dali")) {
            image.setImageResource(R.drawable.dali);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dali);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("bob")) {
            image.setImageResource(R.drawable.bob);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bob);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("bigben")) {
            image.setImageResource(R.drawable.bigben);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bigben);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("maya")) {
            image.setImageResource(R.drawable.maya);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maya);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("america")) {
            image.setImageResource(R.drawable.america);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.america);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("haifa")) {
            image.setImageResource(R.drawable.haifa);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.haifa);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("kremlin")) {
            image.setImageResource(R.drawable.kremlin);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.kremlin);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("disneyland")) {
            image.setImageResource(R.drawable.disneyland);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.disneyland);
            width = bitmap.getWidth()/Constants.COLUMNS;
            height = bitmap.getHeight()/Constants.COLUMNS;
        }
        else if(level.equals("pakistan")) {
            image.setImageResource(R.drawable.pakistan);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pakistan);
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