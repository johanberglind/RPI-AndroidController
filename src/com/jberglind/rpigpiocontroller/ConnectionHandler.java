package com.jberglind.rpigpiocontroller;

import android.os.AsyncTask;
import android.util.Log;

public class ConnectionHandler extends AsyncTask<String, Void, String> {

	@Override
	protected String doInBackground(String... input) {

		String socketresponse = null;
		String command = input[0];
		String ip = input[1];
		String port_string = input[2];
		int port = Integer.parseInt(port_string);

		SocketBuddy sbuddy = new SocketBuddy();

		if (command.equals("status")) {
			socketresponse = sbuddy.status(command, ip, port);
			Log.d("Conhandler", socketresponse);
			return socketresponse;
		}

		else {
			sbuddy.sendStream(command, ip, port);
			return socketresponse;

		}
	}

}