package com.qihoo.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HandlerThread implements Runnable {

	private Socket socket;
	
	public HandlerThread(Socket client) {
		socket = client;
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		//读取客户端数据
		try {
			DataInputStream input = new DataInputStream(socket.getInputStream());
			String clientInputStr = input.readUTF();
			//处理客户端数据
			System.out.println("客户端发送过来的内容：" + clientInputStr);
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			System.out.println("请输入：\t");
			String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
			out.writeUTF(line);
			out.close();
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					socket = null;
					e.printStackTrace();
				}
			}
		}
	}

}
