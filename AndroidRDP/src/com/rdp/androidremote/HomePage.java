package com.rdp.androidremote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HomePage extends Activity implements OnClickListener {
Button Mouse,KeyBoard,LiveScreen;
TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_page);
		Mouse=(Button)findViewById(R.id.BtnMouse);
		KeyBoard=(Button)findViewById(R.id.BtnKeyBoard);
		LiveScreen=(Button)findViewById(R.id.BtnLiveScreen);
		Mouse.setOnClickListener(this);
		KeyBoard.setOnClickListener(this);
		LiveScreen.setOnClickListener(this);
		tv=(TextView)findViewById(R.id.textView1);
		Display display = getWindowManager().getDefaultDisplay(); 
		int width = display.getWidth();
		int height = display.getHeight();
		tv.setText("Width :"+width+"\n"+"Height :"+height);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_page, menu);
		
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	switch(v.getId()){
	case R.id.BtnMouse:
		Intent intent=new Intent(getApplicationContext(),RDPMouse.class);
		startActivity(intent);
		break;
	case R.id.BtnKeyBoard:
		Intent intent1=new Intent(getApplicationContext(),RDPKeyBoard.class);
		startActivity(intent1);
		break;
	case R.id.BtnLiveScreen:
		Intent intent2=new Intent(getApplicationContext(),RDPLiveScreen.class);
		startActivity(intent2);
		break;
	}
	}

}
