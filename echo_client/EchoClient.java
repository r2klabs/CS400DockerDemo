
import java.net.*;
import java.io.*;

public class EchoClient {
    private DatagramSocket socket;
    private InetAddress address;
 
    private byte[] buf;
 
    public EchoClient(String a) {
        try{
	    	socket = new DatagramSocket();
	        address = InetAddress.getByName(a);
	        System.out.println("Echo Client Ready");
        }
        catch(SocketException se) {
        	se.printStackTrace();
        }
        catch(IOException io) {
        	io.printStackTrace();
        }
    }//end EchoClient
 
    public String sendEcho(String msg) {
        buf = msg.getBytes();
        DatagramPacket packet 
          = new DatagramPacket(buf, buf.length, address, 4445);
        String received = null;
        try {
	        socket.send(packet);
	        packet = new DatagramPacket(buf, buf.length);
	        socket.receive(packet);
	        received = new String(
	          packet.getData(), 0, packet.getLength());
	        
	        System.out.println("Client Received: " + received);
	       
        }
        catch(SocketException se) {
        	se.printStackTrace();
        }
        catch(IOException io) {
        	io.printStackTrace();
        }
        return received;
    }//end sendEcho
 
    public void close() {
        socket.close();
    }
}
