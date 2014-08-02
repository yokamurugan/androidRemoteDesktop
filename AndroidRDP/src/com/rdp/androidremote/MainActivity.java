package com.rdp.androidremote;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends Activity {
	public static final String MESSAGE = null;
	private TCPClient mTcpClient = null;
 
    Button connect;
    TextView status;
    EditText getip;
    String IP;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		connect=(Button)findViewById(R.id.button1);
		status=(TextView)findViewById(R.id.textView2);
		getip=(EditText)findViewById(R.id.editText1);
		mTcpClient = null;
        // connect to the server
       status.setText(getDeviceName());
        connect.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 IP=getip.getText().toString();
				Intent i=new Intent(getApplicationContext(),RDPLiveScreen.class);
				i.putExtra(MESSAGE, IP);
				startActivity(i);
			   /**  if(mTcpClient.status){
			    	 status.setText("STATUS\nConnected");
			     }else{
			    	 status.setText("STATUS\nNo Machine found");
			     }**/
			}
		});
      
	}


public String getDeviceName() {
  String manufacturer = Build.MANUFACTURER;
  String model = Build.MODEL;
  if (model.startsWith(manufacturer)) {
    return capitalize(model);
  } else {
    return capitalize(manufacturer) + " " + model;
  }
}


private String capitalize(String s) {
  if (s == null || s.length() == 0) {
    return "";
  }
  char first = s.charAt(0);
  if (Character.isUpperCase(first)) {
    return s;
  } else {
    return Character.toUpperCase(first) + s.substring(1);
  }
} 


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	    
}
