package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] payload;

	public Message(byte[] payload)  {
		this.payload = payload;
		if (payload.length > 128) {
			throw new IllegalArgumentException("For lang payload");
		}
		// TODO: check for length within boundary
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload; 
	}

	public byte[] encapsulate() {
		
		byte[] encoded = new byte[128];
		encoded[0] = (byte) payload.length;
		for (int i=0; i< payload.length; i++) {
			encoded[i+1] = payload[i];
		}	
		return encoded;
		
		// TODO
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format
		
	}

	public void decapsulate(byte[] received) {

		int receivedLength = received[0];
		payload = new byte[receivedLength];
		for (int i= 0; i< receivedLength; i++) {
			payload[i] = received[i+1];
		}
		
		// TODO
		// decapsulate the data contained in the received byte array and store it 
		// in the payload of this message

		
	}
}
