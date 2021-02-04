package no.hvl.dat110.system.display;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCImpl;
import no.hvl.dat110.rpc.RPCUtils;

public class DisplayImpl implements RPCImpl {

	public void write(String message) {
		System.out.println("DISPLAY:" + message);
	}
	
	public byte[] invoke(byte[] request) {
		
		byte[] reply;
		byte rpcid = request[0];	
		
		// unmarshall
		
		int temp = RPCUtils.unmarshallInteger(request);
		
		// call
		
		write("" + temp);
		
		// marshall
		
		reply = RPCUtils.marshallVoid(rpcid);
		
		// TODO: 
		// implement unmarshalling, call, and marshall for write RPC method
		// look at how this is done int he SensorImpl for the read method
		
	
		
		return reply;
	}
}
