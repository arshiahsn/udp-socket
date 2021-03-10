import java.io.*;
import java.net.*;

public class UDPServer {
    public static void main(String args[]) throws Exception{
        try{
            DatagramSocket serverSocket = new DatagramSocket(9876);

            while(true){
                byte[] receiveData = new byte[1024];
                byte[] sendData = new byte[1024];

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String sentence = new String(receivePacket.getData(), "US-ASCII");
                InetAddress IpAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();

                String upperString = sentence.toUpperCase();
                System.out.println(upperString);
                sendData = upperString.getBytes("US-ASCII");

                DatagramPacket sendpacket = new DatagramPacket(sendData, sendData.length, IpAddress, port);
                serverSocket.send(sendpacket);

            }


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
