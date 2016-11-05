package com.xorange.waveanimation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;


public class MainActivity extends Activity {
    private ImageView mNormal, mWave1, mWave2, mWave3;

    private AnimationSet mAnimationSet1, mAnimationSet2, mAnimationSet3;

    private static final int OFFSET = 600;  //每个动画的播放时间间隔
    private static final int MSG_WAVE2_ANIMATION = 2;
    private static final int MSG_WAVE3_ANIMATION = 3;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_WAVE2_ANIMATION:
                    mWave2.startAnimation(mAnimationSet2);
                    break;
                case MSG_WAVE3_ANIMATION:
                    mWave3.startAnimation(mAnimationSet3);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNormal = (ImageView) findViewById(R.id.normal);
        mWave1 = (ImageView) findViewById(R.id.wave1);
        mWave2 = (ImageView) findViewById(R.id.wave2);
        mWave3 = (ImageView) findViewById(R.id.wave3);

        mAnimationSet1 = initAnimationSet();
        mAnimationSet2 = initAnimationSet();
        mAnimationSet3 = initAnimationSet();

        mNormal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        showWaveAnimation();
                        break;
                    case MotionEvent.ACTION_UP:
                        clearWaveAnimation();
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        clearWaveAnimation();
                }
                return true;
            }
        });
    }

    private AnimationSet initAnimationSet() {
        // AnimationSet提供了一个把多个动画组合成一个组合的机制,
        // 并可设置组中动画的时序关系, 如同时播放, 顺序播放等。
        AnimationSet as = new AnimationSet(true);
        // 缩放动画效果
        ScaleAnimation sa = new ScaleAnimation(
                1f     // 动画起始时 X 坐标上的伸缩尺寸
                , 2.3f // 动画结束时 X 坐标上的伸缩尺寸
                , 1f   // 动画起始时 Y 坐标上的伸缩尺寸
                , 2.3f // 动画结束时 Y 坐标上的伸缩尺寸
                , ScaleAnimation.RELATIVE_TO_SELF // 动画在X轴相对于物件位置类型: 相对于自身
                , 0.5f                            // 动画相对于物件的X坐标的开始位置
                , ScaleAnimation.RELATIVE_TO_SELF // 动画在Y轴相对于物件位置类型:相对于自身
                , 0.5f                            // 动画相对于物件的Y坐标的开始位置
        );
        sa.setDuration(OFFSET * 3); // 设置动画持续时间
        sa.setRepeatCount(Animation.INFINITE);// 设置循环
        // 透明度动画效果
        AlphaAnimation aa = new AlphaAnimation(
                1      // 动画起始时 透明度
                , 0.1f // 动画结束时 透明度
        );
        aa.setDuration(OFFSET * 3); // 设置动画持续时间
        aa.setRepeatCount(Animation.INFINITE);//设置循环
        as.addAnimation(sa);
        as.addAnimation(aa);
        return as;
    }

    private void showWaveAnimation() {
        mWave1.startAnimation(mAnimationSet1);
        mHandler.sendEmptyMessageDelayed(MSG_WAVE2_ANIMATION, OFFSET);
        mHandler.sendEmptyMessageDelayed(MSG_WAVE3_ANIMATION, OFFSET * 2);
    }

    private void clearWaveAnimation() {
        mWave1.clearAnimation();
        mWave2.clearAnimation();
        mWave3.clearAnimation();
    }
}
