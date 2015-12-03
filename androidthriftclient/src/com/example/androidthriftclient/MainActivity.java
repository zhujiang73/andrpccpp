package com.example.androidthriftclient;

import java.io.InputStream;
import java.lang.ref.WeakReference;

import org.apache.thrift.TApplicationException;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import tutorial.Calculator;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    static  final int HANDLER_RPC = 2000;
    static  final int HANDLER_RPC_ERR = 2002;
    
    static  String  str_ret_rpc = new String();
    
    static TextView  textip;
    static EditText  editip;
    static EditText  edit01;		
    static TextView  textadd;
    static EditText  edit02;		    
    static EditText  edit03;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textip = (TextView) findViewById(R.id.textViewip);
		editip = (EditText) findViewById(R.id.editTextip);
		edit01 = (EditText) findViewById(R.id.editText01);		
		textadd = (TextView) findViewById(R.id.textViewadd);
		edit02 = (EditText) findViewById(R.id.editText02);		
        final Button button = (Button) findViewById(R.id.button1);
		edit03 = (EditText) findViewById(R.id.editText03);	
		
  	    textip.setText("server ip:");
    	editip.setText("192.168.0.100");
    	edit01.setText("1");
    	textadd.setText("  +");
    	edit02.setText("1");
     
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	rpc_client();
            }
        });
		
	}

    static class MrcvHandler extends Handler {
        WeakReference<MainActivity>  m_activity;

        MrcvHandler(MainActivity  activity) {
        	m_activity = new WeakReference<MainActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
        	MainActivity activity = m_activity.get();
            switch (msg.what) {
                case HANDLER_RPC:
                	
                	edit03.setText(str_ret_rpc);
                	
                    break;
                case HANDLER_RPC_ERR:
                    String str_txt = msg.getData().getString("debug");
                    Toast.makeText(activity, str_txt, Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };

    MrcvHandler handler_rpc = new MrcvHandler(this);

	
	private  void  rpc_client()
	{		
           	Editable  edit = editip.getText();
           	
           	final String  str_ip  = edit.toString();
           	
           	final int   a = Integer.valueOf(edit01.getText().toString()); 
           	final int   b = Integer.valueOf(edit02.getText().toString()); 
            	
            //Toast.makeText(this, str_ip, Toast.LENGTH_LONG).show();		
            
            new Thread(new Runnable() {
                public void run() {
                    String  str_debug = null;
                    //int clientTimeout = 30*1000;
                    TTransport transport;

                    try {                        
                        int  port = 9090;

						transport = new TFramedTransport(new TSocket(str_ip, port));

                        TProtocol protocol = new TBinaryProtocol(transport);
                        Calculator.Client client = new Calculator.Client(protocol);
                        transport.open();
                        
                        int  ret = client.add(a, b);
                        
                        str_ret_rpc = Integer.toString(ret);

                        Message msg = new Message();
                        msg.what = HANDLER_RPC;
                        handler_rpc.sendMessage(msg);

                        transport.close();
                        
                    } catch (TException e) {
                        if (e instanceof TApplicationException && ((TApplicationException) e).getType() == TApplicationException.MISSING_RESULT) {
                            Log.d("rcv debug", "The result of function is NULL");
                            str_debug = "rcv result NULL !";
                        } else {
                            e.printStackTrace();
                            str_debug = "rcv exception !";
                        }
                    }

                    if (str_debug != null)  {
                        Message msg_err = new Message();
                        msg_err.what = HANDLER_RPC_ERR;
                        Bundle bundle = new Bundle();
                        bundle.putString("debug", str_debug);
                        msg_err.setData(bundle);
                        handler_rpc.sendMessage(msg_err);
                    }
                }
            }).start();            
            
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
