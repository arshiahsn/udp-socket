import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String args[]) throws Exception{
        try{
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress IpAddress = InetAddress.getByName("localhost");

            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];

            String sentence = inFromUser.readLine();
            sendData = sentence.getBytes("US-ASCII");

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IpAddress, 9876);
            clientSocket.send(sendPacket);
            DatagramPacket receivePacket =  new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String modifiedSentence = new String(receivePacket.getData(), "US-ASCII");

            System.out.println("From the server: " + modifiedSentence);
            clientSocket.close();

        }
        catch(Exception e){

        }
    }
}
