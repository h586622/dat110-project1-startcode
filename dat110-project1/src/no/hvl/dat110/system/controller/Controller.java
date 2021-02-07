package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCClient;
import no.hvl.dat110.rpc.RPCServerStopStub;

public class Controller  {
	
	private static int N = 5;
	
	public static void main (String[] args)  {
		
		Display display;
		Sensor sensor;
		
		RPCClient displayclient,sensorclient;
		
		System.out.println("Controller starting ...");
				
		RPCServerStopStub stopdisplay = new RPCServerStopStub();
		RPCServerStopStub stopsensor = new RPCServerStopStub();
		
		displayclient = new RPCClient(Common.DISPLAYHOST,Common.DISPLAYPORT);
		sensorclient = new RPCClient(Common.SENSORHOST,Common.SENSORPORT);
		
		
		displayclient.connect();
		sensorclient.connect();
		
		display = new Display();
		sensor = new Sensor();
		
		displayclient.register(display);
		sensorclient.register(sensor);
		
		// TODO
		// connect to sensor and display RPC servers
		// create local display and sensor objects
		// register display and sensor objects in the RPC layer
		
		
		
		// register stop methods in the RPC layer
		displayclient.register(stopdisplay);
		sensorclient.register(stopsensor);
		
		// TODO:
		// loop while reading from sensor and write to display via RPC
		

		for (int i = 0; i<10; i++) {
			String message ="" +  sensor.read();		
			display.write(message);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
			}
		}
		
		
		stopdisplay.stop();
		stopsensor.stop();
	
		displayclient.disconnect();
		sensorclient.disconnect();
		
		System.out.println("Controller stopping ...");
		
	}
}
