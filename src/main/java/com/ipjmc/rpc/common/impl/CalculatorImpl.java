package com.ipjmc.rpc.common.impl;

import com.ipjmc.rpc.common.Calculator;

public class CalculatorImpl implements Calculator {

	@Override
	public int add(int x, int y) {
		return x + y;
	}

}
