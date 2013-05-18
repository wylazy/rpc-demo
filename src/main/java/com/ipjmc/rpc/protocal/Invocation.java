package com.ipjmc.rpc.protocal;

import java.io.Serializable;
import java.util.Arrays;

public class Invocation implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Class interfaces;
	private RPCMethod method;
	private Object[] params;
	private Object result;
	
	
	/**
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(Object result) {
		this.result = result;
	}
	/**
	 * @return the interfaces
	 */
	public Class getInterfaces() {
		return interfaces;
	}
	/**
	 * @param interfaces the interfaces to set
	 */
	public void setInterfaces(Class interfaces) {
		this.interfaces = interfaces;
	}
	/**
	 * @return the method
	 */
	public RPCMethod getMethod() {
		return method;
	}
	/**
	 * @param method the method to set
	 */
	public void setMethod(RPCMethod method) {
		this.method = method;
	}
	/**
	 * @return the params
	 */
	public Object[] getParams() {
		return params;
	}
	/**
	 * @param params the params to set
	 */
	public void setParams(Object[] params) {
		this.params = params;
	}
	@Override
	public String toString() {
		return interfaces.getName()+"."+method.getMethodName()+"("+Arrays.toString(params)+")";
	}
	
}
