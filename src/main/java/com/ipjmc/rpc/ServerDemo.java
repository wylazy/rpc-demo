package com.ipjmc.rpc;

import com.ipjmc.rpc.client.RPC;
import com.ipjmc.rpc.common.Calculator;
import com.ipjmc.rpc.common.Echo;
import com.ipjmc.rpc.common.impl.CalculatorImpl;
import com.ipjmc.rpc.common.impl.EchoImpl;
import com.ipjmc.rpc.server.RPCServer;
import com.ipjmc.rpc.server.Server;

public class ServerDemo {

	public static void main(String[] args) {  
        Server server = RPC.getRPCServer();
        server.register(Calculator.class, CalculatorImpl.class);  
    //    server.register(Echo.class, EchoImpl.class);  
    }  
}
