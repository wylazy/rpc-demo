package com.ipjmc.rpc.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;

import com.alibaba.fastjson.JSON;
import com.ipjmc.rpc.protocal.Invocation;

public class Client {
	private String host;
	private int port;
	private Socket socket;
	private PrintWriter printer;
	private BufferedReader reader;

	public String getHost() {
		return host;
	}


	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}

	public Client(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void init() throws UnknownHostException, IOException {
		socket = new Socket(host, port);
		printer = new PrintWriter(socket.getOutputStream());
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	public void invoke(Invocation invo) throws UnknownHostException, IOException, ClassNotFoundException {
		init();
		
		printer.println(JSON.toJSONString(invo));
		printer.flush();
		
		Invocation result = JSON.parseObject(reader.readLine(), invo.getClass());
		invo.setResult(result.getResult());
	}

}