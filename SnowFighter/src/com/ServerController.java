package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import obj.Snow;

public class ServerController implements Runnable {
	private Socket socket;
	private MainPanel panel;
	
	public ServerController(Socket socket,MainPanel panel) {
		this.socket = socket;
		this.panel = panel;
	}

	@Override
	public void run() {
		BufferedReader bufferedReader = null;
		PrintWriter printWriter = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			printWriter = new PrintWriter(socket.getOutputStream(), true);
			while (true) {
				String str = bufferedReader.readLine();
				if (str == null) {
					System.out.println("연결이 종료되었습니다.");
					break;
				}
				
				// 서버로직
				String[] resValues = str.split("\\^");
				String resCommand = resValues[0];
				if("throw".equals(resCommand)){
					String resPlayer = resValues[1];
					String resSnowSpeed = resValues[2];				
					
					Snow snow = new Snow(panel.players.get(resPlayer), resSnowSpeed);
					panel.snows.add(snow);
					System.out.println();	
				}else if("move".equals(resCommand)){
					String resPlayer = resValues[1];
					String resDx = resValues[2];
					String resDy = resValues[3];				
					int dx = Integer.parseInt(resDx);
					int dy = Integer.parseInt(resDy);
					
					panel.players.get(resPlayer).move(dx, dy);
				}
					else{
					
				
					System.out.println("unknown command!");
				}
				
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (printWriter != null) {
				printWriter.close();
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
