package com.ipjmc.rpc.common.impl;

import com.ipjmc.rpc.common.Echo;

public class EchoImpl implements Echo {

	@Override
	public String echo(String string) {
		return string;
	}

}
