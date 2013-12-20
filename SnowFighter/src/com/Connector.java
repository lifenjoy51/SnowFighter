package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connector {
	Socket socket;
	BufferedReader bufferedReader;
	PrintWriter printWriter;

	public Connector(MainPanel panel) {
		bufferedReader = null;
		printWriter = null;
		try {
			socket = new Socket("58.123.141.190", 8840);

			ServerController chattingInputReader = new ServerController(socket, panel);
			Thread thread = new Thread(chattingInputReader);
			thread.start();

			bufferedReader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			printWriter = new PrintWriter(socket.getOutputStream(), true);
			/*
			 * while (true) { String str = bufferedReader.readLine(); }
			 */
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void write(String msg) throws IOException {
		printWriter.println(msg);
	}

	public String read() {
		return "";
	}
}
