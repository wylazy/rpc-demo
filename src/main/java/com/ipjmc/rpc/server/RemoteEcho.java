package com.ipjmc.rpc.server;

import com.ipjmc.rpc.common.Echo;

public class RemoteEcho implements Echo {

	@Override
	public String echo(String string) {
		return string;
	}

}
