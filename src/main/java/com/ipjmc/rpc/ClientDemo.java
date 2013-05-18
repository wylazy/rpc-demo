package com.ipjmc.rpc;

import com.ipjmc.rpc.client.RPC;
import com.ipjmc.rpc.common.Calculator;
import com.ipjmc.rpc.common.Echo;

public class ClientDemo {

	public static void main(String[] args) {  
        //Echo echo = RPC.getProxy(Echo.class, "127.0.0.1", RPC.PORT);     
       // System.out.println(echo.echo("hello,hello"));  
		
		Calculator cal = RPC.getProxy(Calculator.class, "127.0.0.1", RPC.PORT);
		System.out.println(cal.add(2, 5));
    }  
}
