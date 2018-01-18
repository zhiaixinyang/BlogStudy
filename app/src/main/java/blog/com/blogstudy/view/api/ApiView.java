package blog.com.blogstudy.view.api;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import blog.com.blogstudy.R;

/**
 * Created by MDove on 18/1/18.
 */

public class ApiView extends View {
    private Resources mResources;
    private Path mPathRect1, mPathCircle1;
    private Path mPathRect2, mPathCircle2;
    private Path mPathRect3, mPathCircle3;
    private Path mPathRect4, mPathCircle4;
    private Paint mRectPaint1, mCirclePaint1;
    private Paint mRectPaint2, mCirclePaint2;
    private Paint mRectPaint3, mCirclePaint3;
    private Paint mRectPaint4, mCirclePaint4;

    public ApiView(Context context) {
        super(context, null);
    }

    public ApiView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mResources = context.getResources();

        mPathRect1 = new Path();
        mPathRect2 = new Path();
        mPathRect3 = new Path();
        mPathRect4 = new Path();

        mPathCircle1 = new Path();
        mPathCircle2 = new Path();
        mPathCircle3 = new Path();
        mPathCircle4 = new Path();

        //第一个Path相关的Api展示
        mPathRect1.moveTo(100, 100);
        mPathRect1.lineTo(300, 100);
        mPathRect1.lineTo(300, 200);
        mPathRect1.lineTo(100, 200);
        mPathRect1.lineTo(100, 100);
        /**
         *  Path.Direction：用来指定Path的闭合方向
         *  CCW：表示逆时针    CW：表示顺时针
         */
        mPathCircle1.addCircle(300, 150, 50, Path.Direction.CCW);
        //Path.FillType.WINDING：两个Path所在区域
        mPathRect1.setFillType(Path.FillType.WINDING);
        mPathCircle1.setFillType(Path.FillType.WINDING);

        mRectPaint1 = new Paint();
        mRectPaint1.setColor(ContextCompat.getColor(context, R.color.black));
        mRectPaint1.setStyle(Paint.Style.FILL);
        mCirclePaint1 = new Paint();
        mCirclePaint1.setColor(ContextCompat.getColor(context, R.color.black));
        mCirclePaint1.setStyle(Paint.Style.FILL);

        //第二个Path相关的Api展示
        mPathRect1.moveTo(500, 100);
        mPathRect1.lineTo(800, 100);
        mPathRect1.lineTo(800, 200);
        mPathRect1.lineTo(500, 200);
        mPathRect1.lineTo(500, 100);
        /**
         *  Path.Direction：用来指定Path的闭合方向
         *  CCW：表示逆时针    CW：表示顺时针
         */
        mPathCircle2.addCircle(800, 150, 50, Path.Direction.CCW);
        //Path.FillType.EVEN_ODD：两个Path所在并且不相交的区域
        mPathRect1.setFillType(Path.FillType.EVEN_ODD);
        mPathCircle2.setFillType(Path.FillType.EVEN_ODD);

        mRectPaint2 = new Paint();
        mRectPaint2.setColor(ContextCompat.getColor(context, R.color.red));
        mRectPaint2.setStyle(Paint.Style.FILL);
        mCirclePaint2 = new Paint();
        mCirclePaint2.setColor(ContextCompat.getColor(context, R.color.red));
        mCirclePaint2.setStyle(Paint.Style.FILL);

        //第三个Path相关的Api展示
        mPathRect3.moveTo(100, 500);
        mPathRect3.lineTo(300, 500);
        mPathRect3.lineTo(300, 600);
        mPathRect3.lineTo(100, 500);
        mPathRect3.lineTo(500, 100);
        /**
         *  Path.Direction：用来指定Path的闭合方向
         *  CCW：表示逆时针    CW：表示顺时针
         */
        mPathCircle1.addCircle(800, 150, 50, Path.Direction.CCW);
        //Path.FillType.EVEN_ODD：两个Path所在并且不相交的区域
        mPathRect1.setFillType(Path.FillType.EVEN_ODD);
        mPathCircle1.setFillType(Path.FillType.EVEN_ODD);

        mRectPaint2 = new Paint();
        mRectPaint2.setColor(ContextCompat.getColor(context, R.color.red));
        mRectPaint2.setStyle(Paint.Style.FILL);
        mCirclePaint2 = new Paint();
        mCirclePaint2.setColor(ContextCompat.getColor(context, R.color.red));
        mCirclePaint2.setStyle(Paint.Style.FILL);
    }
}
