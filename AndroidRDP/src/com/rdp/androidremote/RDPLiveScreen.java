package com.rdp.androidremote;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;



import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGestureListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class RDPLiveScreen extends Activity {
	ImageView iv;
	Handler handler;
	private TCPClient mTcpClient = null;
    private connectTask conctTask = null;
    int i=0,ii=0;
    String IP,name;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

	    //Remove notification bar
	    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

	   //set content view AFTER ABOVE sequence (to avoid crash)
	    this.setContentView(R.layout.activity_rdplive_screen);
		iv = (ImageView) findViewById(R.id.imageView1);
		iv.setScaleType(ScaleType.FIT_XY);
		Intent i=getIntent();
		IP=i.getStringExtra(MainActivity.MESSAGE);
		handler=new Handler();
		TextView tv=new TextView(getApplicationContext());
		name=getDeviceName();
		
		 mTcpClient = null;
	        // connect to the server
	        conctTask = new connectTask();
	        conctTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
	      
	        loadimage();
	        
		}
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        MenuInflater inflater = getMenuInflater();
	        inflater.inflate(R.layout.mainmenu, menu);
	        return true;
	    }
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item){            	
	           switch (item.getItemId()) {
	       
	        case R.id.KeyBoard:
	        	if(i==0){
	        	InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            	imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,1);
            	i=1;
	        	}else{
	        		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
	            	imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
	            	i=0;
	        	}
	        	break;
	        case R.id.DoubleClick:
	        	 if (mTcpClient != null) 
		            {
		                mTcpClient.sendMessage("doubleclick");
		            }
	        	 break;
	        case R.id.RightClick:
	        	if (mTcpClient != null) 
	            {
	                mTcpClient.sendMessage("rclick");
	            }
	        	break;
	        case R.id.Shutdown:
	        	if (mTcpClient != null) 
	            {
	                mTcpClient.sendMessage("shutdown");
	            }
	        	break;
	        case R.id.Restart:
	        	if (mTcpClient != null) 
	            {
	                mTcpClient.sendMessage("restart");
	            }
	        	break;
	        case R.id.LogOff:
	        	if (mTcpClient != null) 
	            {
	                mTcpClient.sendMessage("logoff");
	            }
	        	break;
	        default:
	            return super.onOptionsItemSelected(item);
	        }
			return true;
	    }
	    @Override
	    public boolean dispatchKeyEvent(KeyEvent KEvent) 
	    {
	        int keyaction = KEvent.getAction();
	        
	        if(keyaction == KeyEvent.ACTION_DOWN)
	        {
	            int keycode = KEvent.getKeyCode();
	            if(keycode==KeyEvent.KEYCODE_DEL){
	            	 if(mTcpClient!=null)
	 	            {
	 	            	mTcpClient.sendMessage("aj1");
	 	            	 Toast.makeText(getApplicationContext(), "aj1", Toast.LENGTH_LONG).show();
	 	            }	
	            }
	            int keyunicode = KEvent.getUnicodeChar(KEvent.getMetaState() );
	            char character = (char) keyunicode;
	            if(keyunicode!=0){
	            Toast.makeText(getApplicationContext(), String.valueOf(keyunicode), Toast.LENGTH_LONG).show();
	            if(mTcpClient!=null)
	            {
	            	mTcpClient.sendMessage("aj"+String.valueOf(keyunicode));
	            }
	        }
	        }


	        return super.dispatchKeyEvent(KEvent);
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


	    	public String capitalize(String s) {
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

	private void loadimage() {
		// TODO Auto-generated method stub
		 int filesize=1022386;
	        int bytesRead;
	        int currentTot = 0;
	        StrictMode.ThreadPolicy policy = 
     		    new StrictMode.ThreadPolicy.Builder().permitAll().build();      
     		        StrictMode.setThreadPolicy(policy);
	        try{
	        	
	        Socket socket = new Socket(IP,15123);
	        byte [] bytearray  = new byte [filesize];
	        InputStream is = socket.getInputStream();
	        FileOutputStream fos = new FileOutputStream(Environment.getExternalStorageDirectory().getAbsolutePath()+"/i.png");
	        BufferedOutputStream bos = new BufferedOutputStream(fos);
	        bytesRead = is.read(bytearray,0,bytearray.length);
	        currentTot = bytesRead;
	 
	        do {
	           bytesRead =
	              is.read(bytearray, currentTot, (bytearray.length-currentTot));
	           if(bytesRead >= 0) currentTot += bytesRead;
	        } while(bytesRead > -1);
	 
	        bos.write(bytearray, 0 , currentTot);
	        bos.flush();
	        bos.close();
	        socket.close();
	        File f=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/i.png");
	        iv.setImageURI(null);
	        iv.setImageURI(Uri.fromFile(f));
	        handler.postDelayed(run, 1500);
	        }catch(Exception e){
	        	
	        }
	}
	Runnable run=new Runnable(){

		@Override
		public void run() {
			//TODO Auto-generated method stub
			loadimage();
			if(ii==0){
				if (mTcpClient != null) 
	            {
	                mTcpClient.sendMessage("a!!!"+name);
	            }
				ii++;
			}
		    }
		
	};
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		finish();
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
	    int xx = (int)event.getX();
	    int yy = (int)event.getY();
	    switch (event.getAction()) {
	        case MotionEvent.ACTION_DOWN:
	        	int x1 = (int)event.getX();
	            int y1 = (int)event.getY();
	            String a1=(x1+"-"+y1);
	            
	            if (mTcpClient != null) 
	            {
	                mTcpClient.sendMessage("lcz"+a1);
	            }
	        case MotionEvent.ACTION_MOVE:
	        	float x = event.getX();
	            float y = event.getY();
	            String a=(x+"#"+y);
	            if (mTcpClient != null) 
	            {
	                mTcpClient.sendMessage(a);
	            }
	        case MotionEvent.ACTION_UP:
	        	
	    }
	return false;
	}

	public class connectTask extends AsyncTask<String,String,TCPClient> {
        @Override
        protected TCPClient doInBackground(String... message) 
        {
            //we create a TCPClient object and
            mTcpClient = new TCPClient(new TCPClient.OnMessageReceived() 
            {
                @Override
                //here the messageReceived method is implemented
                public void messageReceived(String message) 
                {
                	try
					{
                		//this method calls the onProgressUpdate
                		publishProgress(message);
                		if(message!=null)
                		{
                			System.out.println("Return Message from Socket::::: >>>>> "+message);
                		}
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
                }

			});
            mTcpClient.run(IP);
           return null;
        }
 
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
 
            //in the arrayList we add the messaged received from server
           
            
            // notify the adapter that the data set has changed. This means that new message received
            // from server was added to the list
          
        }
    }

    @Override
    protected void onDestroy()
    {
    	try
		{
    		System.out.println("onDestroy.");
			mTcpClient.sendMessage("bye");
			mTcpClient.stopClient();
			conctTask.cancel(true);
			conctTask = null;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
    	super.onDestroy();
    }

    
}