package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class Sensor extends RPCStub {

	private byte RPCID = 1;
	
	public int read() {
		
		byte[] rpcrequest = RPCUtils.marshallVoid(RPCID);
		
		byte[] data = rpcclient.call(rpcrequest);
		
		int temp = RPCUtils.unmarshallInteger(data);
		
		// TODO
		// implement marshalling, call and unmarshalling for read RPC method
		
		return temp;
	}
	
}
