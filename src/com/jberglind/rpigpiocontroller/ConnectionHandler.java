package com.jberglind.rpigpiocontroller;

import android.os.AsyncTask;


public class ConnectionHandler extends AsyncTask<String, Void, String>{

	@Override
	protected String doInBackground(String... input) {

		String command = input[0];
		String ip = input[1];
		String port_string = input[2];
		int port = Integer.parseInt(port_string);
		
		SocketBuddy sbuddy = new SocketBuddy();
		sbuddy.sendStream(command, ip, port);
		return null;
		
	}
	
	
}