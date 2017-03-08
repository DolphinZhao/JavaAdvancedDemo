package com.qihoo.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static final int PORT = 12345; //监听的端口号
	
	public static void main(String[] args){
		System.out.println("服务器启动……\n");
		Server server = new Server();
		server.init();
	}
	
	public void init() {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			while(true) {
				Socket client = serverSocket.accept();
				//处理这次连接
				new HandlerThread(client);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
