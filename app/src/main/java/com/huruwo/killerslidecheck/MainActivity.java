package com.huruwo.killerslidecheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.blankj.utilcode.util.TimeUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<TimePoint> timePoints = new ArrayList<>();
    long startTime = 0L;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //事件顺序 Activity--> Window-->DecorView --> 布局View

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        //从按下开始 0
        //从离开结束 1

        if(ev.getAction()==0){
            startTime = TimeUtils.getNowMills();
            timePoints.clear();
        }
        if(ev.getAction()==2){
            timePoints.add(new TimePoint(TimeUtils.getNowMills()-startTime,ev.getRawX(),ev.getRawY()));
        }

        if(ev.getAction()==1){
            timePoints.add(new TimePoint(TimeUtils.getNowMills()-startTime,ev.getRawX(),ev.getRawY()));
            String data = new Gson().toJson(timePoints);
            Log.e("xxx",data);
        }

        return super.dispatchTouchEvent(ev);
    }


}
