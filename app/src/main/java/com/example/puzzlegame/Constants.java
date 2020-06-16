package com.example.puzzlegame;

public class Constants {

    public static int COLUMNS;
    public static int DIMENSIONS;
    public static int SCRREN_WIDTH;

    public static final String UP = "up";
    public static final String DOWN = "down";
    public static final String LEFT = "left";
    public static final String RIGHT = "right";

    public static final int  INTENT_REQUEST_EASY_CODE = 11;
    public static final int  INTENT_REQUEST_MEDIUM_CODE = 13;
    public static final int  INTENT_REQUEST_HARD_CODE = 15;
    public static final int  INTENT_REQUEST_EXPERT_CODE = 17;

    public static final int EASY_LEVELS = 24;
    public static final int MEDIUM_LEVELS = 24;
    public static final int HARD_LEVELS = 24;
    public static final int EXPERT_LEVELS = 24;

    public static String timeHandler(long time){
        int hours = (int) (time / 3600000);
        int minutes = (int) (time - hours * 3600000) / 60000;
        int seconds= (int)(time - hours*3600000- minutes*60000)/1000;

        String str_time = "";
        if(hours == 0){
            str_time = "";
        }
        else if(hours < 10){
            str_time += "0"+hours+":";
        }
        else{
            str_time += hours+":";
        }

        if(minutes == 0){
            str_time += "00:";
        }
        else if(minutes < 10){
            str_time += "0"+minutes+":";
        }
        else{
            str_time += minutes+":";
        }

        if(seconds == 0){
            str_time += "00";
        }
        else if(seconds < 10){
            str_time += "0"+seconds;
        }
        else{
            str_time += seconds;
        }
        return str_time;
    }


}
