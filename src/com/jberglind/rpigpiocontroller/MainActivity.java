package com.jberglind.rpigpiocontroller;

import java.util.concurrent.ExecutionException;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	ConnectionHandler conhandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		settingsManager();


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void buttonCurrentStatus(View view) {
		EditText ip_addr = (EditText) findViewById(R.id.ipText);
		EditText port_nr = (EditText) findViewById(R.id.portText);

		String ip = ip_addr.getText().toString();
		String port_string = port_nr.getText().toString();

		String[] com_info = { "status", ip, port_string };
		
		conhandler = new ConnectionHandler();
		try {
			String conresp = conhandler.execute(com_info).get();
			if (conresp.equals("on")) {
				Toast.makeText(this, "It's currently on!", Toast.LENGTH_SHORT).show();
			}
			else if (conresp.equals("off")) {
				Toast.makeText(this, "It's currently off!", Toast.LENGTH_SHORT).show();
			}
			else {
				Toast.makeText(this, "Connection error!", Toast.LENGTH_SHORT).show();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
		

		
		
	}
	
	public void exitApp(View view) {
		finish();
	}
	
	
	public void buttonOn(View view) {
		Boolean on_or_off = true;
		buttonHandler(on_or_off);
		
	}
	
	public void buttonOff(View view) {
		Boolean on_or_off = false; 
		buttonHandler(on_or_off);
	}
	
	private void settingsManager() {
		
		String ip_text = getPreferences(MODE_PRIVATE).getString("IP", "");
		String port_text = getPreferences(MODE_PRIVATE).getString("PORT", "");
		
		EditText ipTextField = (EditText)findViewById(R.id.ipText);
		EditText portTextField = (EditText)findViewById(R.id.portText);
		
		ipTextField.setText(ip_text);
		portTextField.setText(port_text);
		
		
		
	}
	
	
	private void buttonHandler(Boolean on_or_off) {
		if (on_or_off) {
			EditText ip_addr = (EditText) findViewById(R.id.ipText);
			EditText port_nr = (EditText) findViewById(R.id.portText);

			String ip = ip_addr.getText().toString();
			String port_string = port_nr.getText().toString();

			Toast.makeText(this, "ON Command sent!", Toast.LENGTH_SHORT).show();

			String[] com_info = { "on", ip, port_string };

			conhandler = new ConnectionHandler();
			conhandler.execute(com_info);

			
		}
		else {
			
			
			EditText ip_addr = (EditText) findViewById(R.id.ipText);
			EditText port_nr = (EditText) findViewById(R.id.portText);

			String ip = ip_addr.getText().toString();
			String port_string = port_nr.getText().toString();

			Toast.makeText(this, "OFF Command sent!", Toast.LENGTH_SHORT).show();

			String[] com_info = { "off", ip, port_string };

			conhandler = new ConnectionHandler();
			conhandler.execute(com_info);

		}
	}
	

	
	public void saveDetails(View view) {
		
		EditText ip_addr = (EditText) findViewById(R.id.ipText);
		EditText port_nr = (EditText) findViewById(R.id.portText);
		
		SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
		editor.putString("IP", ip_addr.getText().toString());
		editor.putString("PORT", port_nr.getText().toString());
		editor.commit();
		
		
		
		Toast.makeText(this, "Details saved!", Toast.LENGTH_SHORT).show();
		
	}
	
	public void contactMe(MenuItem menuitem) {
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"));
		startActivity(browserIntent);
		
	}
	
	public void helpHandler(MenuItem menuitem) {
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/johanberglind/RPI-AndroidController/issues"));
		startActivity(browserIntent);
	}
	
	

}
