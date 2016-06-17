package application.hexindai.com.rxhexindai.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import application.hexindai.com.rxhexindai.manager.BidManage;


/**
 * Created by zry on 2015/9/28.
 */
public class HomepageProgressbar extends View {
    /***
     * 因为有个MPADDING是8  所以布局的时候要进来比设计标注的大8
     */
    private static final String LOG_TAG = HomepageProgressbar.class.getSimpleName();
    private static final int MPADDING = 8;
    //满了
    private final int FULL = 1;
    //预热
    private final int PREHEAT = 2;
    //已经开始
    private final int BEGUN = 3;
    private int currentState;
    private Paint mPaint;
    //默认最大值
    private float mMax = 100;
    //当前进度
    private float mProgress = 10;
    private int mPadding;
    private int bianju = 4;
    private int mWidth, mHeight;

    public HomepageProgressbar(Context context) {
        this(context, null);
    }

    public HomepageProgressbar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HomepageProgressbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPadding = dipToPx(MPADDING);
        mPaint = new Paint();
        initPaint();
    }

    private void initPaint() {
        mPaint.reset();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setColor(Color.TRANSPARENT);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectBlackBgWaiQuan = new RectF(mPadding - bianju, mPadding - bianju, mWidth - mPadding + bianju, mHeight - mPadding + bianju);
        int bgcolor;
        if (currentState == PREHEAT || currentState == BEGUN) {
            bgcolor = Color.rgb(236, 236, 236);
        } else {
            bgcolor = Color.rgb(223, 221, 221);
        }
        mPaint.setColor(bgcolor);
        mPaint.setStrokeWidth((float) 5.0);
        //背景圆
        canvas.drawArc(rectBlackBgWaiQuan, 0, 360, false, mPaint);
        if(currentState == FULL){
            return;
        }
        float section;
        if (currentState == PREHEAT) {
            section = 1;
        } else if (currentState == BEGUN) {
            section = mProgress / mMax;
        } else {
            section = 0;
        }
        mPaint.setColor(Color.rgb(0, 184, 195));
        if (currentState == PREHEAT) {
            section = 1;
        }
        canvas.drawArc(rectBlackBgWaiQuan, -90, section * 360, false, mPaint);
    }

    private int dipToPx(int dip) {
        float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f * (dip >= 0 ? 1 : -1));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthSpecMode == MeasureSpec.EXACTLY
                || widthSpecMode == MeasureSpec.AT_MOST) {
            mWidth = widthSpecSize;
           // Log.e(LOG_TAG, mWidth + " == mWidth");
        } else {
            mWidth = 0;
        }
        if (heightSpecMode == MeasureSpec.AT_MOST
                || heightSpecMode == MeasureSpec.UNSPECIFIED) {
            mHeight = dipToPx(15);
        } else {
            mHeight = heightSpecSize;
        }
        setMeasuredDimension(mWidth, mHeight);
    }

    /**
     * 设置当前进度
     *
     * @param progress between 0 and {@link #getMax()}
     */
    public synchronized void setProgress(float progress, int bidState) {
        if (mProgress == progress || progress > mMax) {
            return;
        } else {
            if (progress == getMax()) {
                currentState = FULL;
            } else {
                if (bidState == BidManage.Peheat) {
                    currentState = PREHEAT;
                } else if (bidState == BidManage.Tender) {
                    currentState = BEGUN;
                }
            }
            mProgress = progress;
            invalidate();
        }
    }

    public synchronized float getProgress() {
        return mProgress;
    }

    public synchronized float getMax() {
        return mMax;
    }

    public synchronized void setMax(float max) {
        if (max < 0) {
            max = 0;
        }
        if (max != mMax) {
            mMax = max;
            postInvalidate();
            if (mProgress > max) {
                mProgress = max;
            }
        }
    }
}
