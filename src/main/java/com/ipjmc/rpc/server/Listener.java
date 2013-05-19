package com.ipjmc.rpc.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.alibaba.fastjson.JSON;
import com.ipjmc.rpc.protocal.Invocation;

public class Listener extends Thread {
	private ServerSocket socket;
	private Server server;

	public Listener(Server server) {
		this.server = server;
	}

	@Override
	public void run() {

		System.out.println("启动服务器中，打开端口" + server.getPort());
		try {
			socket = new ServerSocket(server.getPort());
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		while (server.isRunning()) {
			try {
				
				Socket client = socket.accept();
				BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
				Invocation invo = JSON.parseObject(reader.readLine(), Invocation.class);
				
				server.call(invo);
				
				PrintWriter printer = new PrintWriter(client.getOutputStream());
				printer.write(JSON.toJSONString(invo));
				
				printer.flush();
				printer.close();
				reader.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		try {
			if (socket != null && !socket.isClosed())
				socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
