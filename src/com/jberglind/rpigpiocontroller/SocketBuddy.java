package com.jberglind.rpigpiocontroller;

import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import android.util.Log;


public class SocketBuddy {
	
	
	public void sendStream(String command, String ip, int port) {
		try {
			Socket s = new Socket();
			InetAddress address = InetAddress.getByName(ip);
			SocketAddress s_adress = new InetSocketAddress(address, port);
			s.connect(s_adress);
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			out.writeUTF(command);
			s.close();
		}
		catch (Exception e) {
			Log.d("SocketBuddy", "Connection Error");
		}
		
		
		}
	}


