package com.huruwo.killerslidecheck;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class TouchView extends AppCompatTextView {


    public TouchView(@NonNull Context context) {
        super(context);
    }

    public TouchView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(200, 200);
    }

    float downX, downY;
    float moveX, moveY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            downX = event.getRawX();
            downY = event.getRawY();
        }
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            moveX = event.getRawX();
            moveY = event.getRawY();
            this.setX(getX() + (moveX - downX));
            this.setY(getY() + (moveY - downY));
            downX = moveX;
            downY = moveY;
        }
        this.setText("X:"+event.getRawX()+" Y:"+event.getRawY());
        return true;
    }

}
