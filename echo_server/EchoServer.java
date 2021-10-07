import java.net.*;
import java.io.*;

public class EchoServer extends Thread {
 
    private DatagramSocket socket;
    private boolean running;
    private int count = 0;
 
    public EchoServer() {
        try {
			socket = new DatagramSocket(4445);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
    public void run() {
        running = true;
        try {
	        while (running) {
                   byte[] buf = new byte[256];

		    DatagramPacket packet 
	              = new DatagramPacket(buf, buf.length);
	            socket.receive(packet);
	            count++;
	            InetAddress address = packet.getAddress();
	            int port = packet.getPort();
	            packet = new DatagramPacket(buf, buf.length, address, port);
	            String received = new String(packet.getData(), 0, packet.getLength());
		    System.out.println("Message received: " + received + " " + count);

		            socket.send(packet);
			    packet = null;
	        	}//end while


	}//end try
        catch(SocketException se) {
        	se.printStackTrace();
        }
        catch(IOException io) {
        	io.printStackTrace();
        }
        socket.close();
    }
}//end class
