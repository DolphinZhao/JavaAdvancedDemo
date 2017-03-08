package com.qihoo.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static final int PORT = 12345; //�����Ķ˿ں�
	
	public static void main(String[] args){
		System.out.println("��������������\n");
		Server server = new Server();
		server.init();
	}
	
	public void init() {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			while(true) {
				Socket client = serverSocket.accept();
				//�����������
				new HandlerThread(client);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
