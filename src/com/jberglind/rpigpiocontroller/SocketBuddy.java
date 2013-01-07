package com.jberglind.rpigpiocontroller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
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
	
	public String status(String command, String ip, int port) {
		try {
			
			Socket s = new Socket();
			InetAddress address = InetAddress.getByName(ip);
			SocketAddress s_adress = new InetSocketAddress(address, port);
			s.connect(s_adress);
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			out.writeUTF(command);
			
			BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String line = null;
			line = input.readLine();
			Log.d("Socketbuddy - Response:", line);
			return line;
		}
		
		catch (Exception e) {
			Log.d("SocketBuddy", "Connection Error");
			return "Connection Error...";
		}
	}
	
	}


