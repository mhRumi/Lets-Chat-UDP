/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychatapp.newtorking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rumi
 */
public class messageTransmitter extends Thread{
    
    String message, hostname;
    int port;
    writableGUI gui;
    
    //
     private DatagramSocket socket;
    private boolean running;
    private byte[] buf;
    //
    
    public messageTransmitter()
    {
        
    }
    
    public messageTransmitter(String message, String hostname, int port)
    {
        this.message = message;
        this.hostname = hostname;
        this.port = port;
    }
    
    @Override
    public void run()
    {
        
//        try {
//        Socket s = new Socket(hostname, port);
//        s.getOutputStream().write(message.getBytes());
//        s.close();
//        } catch (IOException ex) {
//            Logger.getLogger(messageTransmitter.class.getName()).log(Level.SEVERE, null, ex);
//        }

      

        try {
              socket = new DatagramSocket();
              buf = message.getBytes();
    DatagramPacket packet
            = new DatagramPacket(buf, buf.length, InetAddress.getByName(hostname), this.port);
    socket.send(packet);

            } catch (IOException ex) {
                Logger.getLogger(messageTransmitter.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        
        
      
    
}
