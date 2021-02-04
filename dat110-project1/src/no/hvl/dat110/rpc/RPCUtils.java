package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;

import no.hvl.dat110.TODO;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the 
	// RPC message syntax [rpcid,parameter/return value]
	
	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded = new byte[str.length()+1];
		
		encoded[0] = rpcid;
		
		for (int i = 0; i<str.length();i++) {
			encoded[i+1] = (byte) str.charAt(i);
		}

		return encoded;
	}

	public static String unmarshallString(byte[] data) {
		
		byte[] data2 = new byte[data.length-1];
		
		for (int i= 0; i< data2.length; i++) {
			data2[i] = data[i+1];
		}
	
		String decoded = new String(data2, java.nio.charset.StandardCharsets.UTF_8);

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded = new byte[1];
		encoded[0] = rpcid;



		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] encoded = new byte[5];
		encoded[0] = rpcid;
		
		byte[] test = ByteBuffer.allocate(4).putInt(x).array();
		
		for (int i=0;i<4;i++) {
			encoded[i+1] = test[i];
		}

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		byte[] riktig = new byte[4];
		
		for (int i=1;i<data.length;i++) {		
				riktig[i-1] = data[i];
		}
		
		int decoded = ByteBuffer.wrap(riktig).getInt();

		return decoded;
		
	

	}
}
