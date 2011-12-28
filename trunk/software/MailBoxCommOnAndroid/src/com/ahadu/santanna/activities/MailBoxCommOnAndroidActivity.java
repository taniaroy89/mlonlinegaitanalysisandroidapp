package com.ahadu.santanna.activities;

import com.ahadu.santanna.objects.MailBox;
import com.ahadu.santanna.objects.Point;
import com.ahadu.santanna.objects.Producer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

public class MailBoxCommOnAndroidActivity extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        CommView comm = new CommView(this);
        setContentView(comm);
    }
    
    public class CommView extends View{
    	
		DisplayMetrics metrics = new DisplayMetrics();
    	WindowManager windowManager;
    	MailBox<Point> mbx;
    	Producer producer; 
    	Paint paint;
    	double x = 0;
//    	int x = (metrics.widthPixels - (int)(paint.getTextSize() + 0.5))/2;
    	double y = 0;
    	Rect dirty;
		Paint rectPaint;
		Point temp;
    	public CommView(Context context) {
			super(context);
			getWindowManager().getDefaultDisplay().getMetrics(metrics);
			mbx = new MailBox<Point>();
			paint = new Paint();
			paint.setColor(Color.RED);
			paint.setTextSize(30);
			dirty = new Rect();
			rectPaint = new Paint();
			rectPaint.setColor(Color.YELLOW);
			producer = new Producer(mbx);
			producer.start();
			temp = new Point(x, y);
		}
    	
    	@Override
		protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);
			temp = mbx.get();
			
			
			y = metrics.heightPixels/ 2 - 100 + temp.getY()* 50; 
			if( x < metrics.widthPixels){
				x = temp.getX();
			}else{
				x = temp.getX()% metrics.widthPixels;
			}
			canvas.drawCircle((float)x, (float)y, (float)10, rectPaint);
			canvas.drawText(mbx.get().toString(), (float)x, (float)y + 50, paint);
//			dirty.left = 0;
//			dirty.right = metrics.widthPixels;
//			dirty.top = y;
//			dirty.bottom = y + 50;
//			canvas.drawRect(dirty, rectPaint);
			invalidate();
		}
    	
    }
}