package blog.com.blogstudy.view.path;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by admin on 18/1/16.
 */

public class DynamicHeartView extends View {

    private static final String TAG = "DynamicHeartView";
    private static final int PATH_WIDTH = 2;
    // 起始点
    private static final int[] START_POINT = new int[]{
            300, 300
    };
    // 爱心下端点
    private static final int[] BOTTOM_POINT = new int[]{
            300, 400
    };
    // 左侧控制点
    private static final int[] LEFT_CONTROL_POINT = new int[]{
            150, 250
    };
    // 右侧控制点
    private static final int[] RIGHT_CONTROL_POINT = new int[]{
            450, 250
    };

    private PathMeasure mPathMeasure;
    private Paint mPaint;
    private Paint mPaintL,mPaintR;
    private Path mPath;
    private float[] mCurrentPosition = new float[2];

    public DynamicHeartView(Context context) {
        super(context, null);
    }

    public DynamicHeartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(PATH_WIDTH);
        mPaint.setColor(Color.RED);

        mPaintR = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintR.setStyle(Paint.Style.FILL);
        mPaintR.setStrokeWidth(PATH_WIDTH);
        mPaintR.setColor(Color.BLACK);

        mPaintL = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintL.setStyle(Paint.Style.FILL);
        mPaintL.setStrokeWidth(PATH_WIDTH);
        mPaintL.setColor(Color.YELLOW);

        mPath = new Path();
        mPath.moveTo(START_POINT[0], START_POINT[1]);
        mPath.quadTo(RIGHT_CONTROL_POINT[0], RIGHT_CONTROL_POINT[1], BOTTOM_POINT[0],
                BOTTOM_POINT[1]);
        mPath.quadTo(LEFT_CONTROL_POINT[0], LEFT_CONTROL_POINT[1], START_POINT[0], START_POINT[1]);
//        mPath.moveTo(100, 100);
//        RectF rectF1 = new RectF(100, 100, 400, 400);
//        RectF rectF2 = new RectF(400, 100, 700, 400);
//        mPath.addArc(rectF1, 180, 180);
//        mPath.addArc(rectF2, 180, 180);
//        mPath.quadTo(500, 500, 400, 550);
//        mPath.quadTo(300, 400, 100, 250);

        mPathMeasure = new PathMeasure(mPath, true);
        mCurrentPosition = new float[2];
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        canvas.drawPath(mPath, mPaint);

        canvas.drawCircle(RIGHT_CONTROL_POINT[0], RIGHT_CONTROL_POINT[1], 5, mPaintR);
        canvas.drawCircle(LEFT_CONTROL_POINT[0], LEFT_CONTROL_POINT[1], 5, mPaintL);

        // 绘制对应目标
        canvas.drawCircle(mCurrentPosition[0], mCurrentPosition[1], 10, mPaint);
    }

    // 开启路径动画
    public void startPathAnim(long duration) {
        // 0 － getLength()
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, mPathMeasure.getLength());
        valueAnimator.setDuration(duration);
        // 减速插值器
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (Float) animation.getAnimatedValue();
                // 获取当前点坐标封装到mCurrentPosition
                mPathMeasure.getPosTan(value, mCurrentPosition, null);
                postInvalidate();
            }
        });
        valueAnimator.start();

    }
}
