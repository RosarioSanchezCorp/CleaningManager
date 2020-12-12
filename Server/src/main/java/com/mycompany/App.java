package com.mycompany;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App 
{
    public static void main( String[] args ){
//        Server server = new Server();
//        server.start();
        try {
            ServerSocket ss = new ServerSocket(3333);
            System.out.println("The server is running");
            while(true){
                
                Socket s = null;
                
                try{
                    s = ss.accept();
                    ObjectInputStream in = new ObjectInputStream(s.getInputStream());
                    ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                    ClientHandler ch = new ClientHandler(s, in, out);
                    ch.start();
                }
                catch(Exception e){
                    s.close();
                    e.printStackTrace();
                }
            }
        } 
        catch (Exception e) {    
            e.printStackTrace();
        }
    }
}
