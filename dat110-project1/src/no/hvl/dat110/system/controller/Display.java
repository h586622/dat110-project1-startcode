package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class Display extends RPCStub {

	private byte RPCID = 1;

	public void write(String message) {

		int messageInt = Integer.parseInt(message);
		
		 byte[] byteMsg = RPCUtils.marshallInteger(RPCID, messageInt);
		 
		 byte[] response = rpcclient.call(byteMsg);
		 
		 RPCUtils.unmarshallVoid(response); 
		 
		// TODO
		// implement marshalling, call and unmarshalling for write RPC method

	}
}
