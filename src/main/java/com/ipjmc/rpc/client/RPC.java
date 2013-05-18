package com.ipjmc.rpc.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.ipjmc.rpc.protocal.Invocation;
import com.ipjmc.rpc.protocal.RPCMethod;
import com.ipjmc.rpc.server.RPCServer;
import com.ipjmc.rpc.server.Server;

public class RPC {

	public static final int PORT = 6842;
	
	public static <T> T getProxy(final Class<T> clazz, String host, int port) {

		final Client client = new Client(host, port);
		
		InvocationHandler handler = new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				Invocation invo = new Invocation();
				invo.setInterfaces(clazz);
				invo.setMethod(new RPCMethod(method.getName(), method.getParameterTypes()));
				invo.setParams(args);
				client.invoke(invo);
				return invo.getResult();
			}
		};
		
		T t = (T) Proxy.newProxyInstance(RPC.class.getClassLoader(),
				new Class[] { clazz }, handler);
		return t;
	}
	
	public static Server getRPCServer() {
		Server server = new RPCServer();
		server.start();
		return server;
	}
}
