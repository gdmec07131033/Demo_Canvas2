package cn.edu.gdmec.s07131033.demo_canvas2;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends Activity {
	private List<PointF> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }
    private class MyView extends View
    {
    	Paint paint = new Paint();

		public MyView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			list = new ArrayList<PointF>();
			
			paint.setColor(Color.GREEN);
			
			paint.setStrokeWidth(5);
		}
    	
		@Override
		protected void onDraw(Canvas canvas) {
			for(PointF f : list)
			{
				canvas.drawPoint(f.x, f.y, paint);
			}
		}
		
		@Override
		public boolean onTouchEvent(MotionEvent event) {
			PointF point = new PointF(event.getX(),event.getY());
			
			list.add(point);
			
			invalidate();//通知重绘界面
			
			return true;
		}
    }

    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
