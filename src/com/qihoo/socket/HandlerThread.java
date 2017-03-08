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
		//��ȡ�ͻ�������
		try {
			DataInputStream input = new DataInputStream(socket.getInputStream());
			String clientInputStr = input.readUTF();
			//����ͻ�������
			System.out.println("�ͻ��˷��͹��������ݣ�" + clientInputStr);
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			System.out.println("�����룺\t");
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
