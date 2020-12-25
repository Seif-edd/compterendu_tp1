/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static final int port = 1200;

    public static void main(String[] args) throws Exception {

        // Listen to a specific port

        ServerSocket s = new ServerSocket(port);
        System.out.println("Waiting for connection");
        Socket socClient = s.accept(); // Accept a client socket
        System.out.println("Connection established");

        // Initialize in / out

        BufferedReader inServer = new BufferedReader(new InputStreamReader(socClient.getInputStream()));
        PrintWriter outServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socClient.getOutputStream())), true);

       String str = inServer.readLine(); // lecture du message envoyé par le client
        int nombre=0;
        try{
            nombre=Integer.parseInt(str);
            }catch (Exception e){
                System.out.println("L'entrée du clavier n'est pas un entier");
            }
        for(int i=2;i<=nombre;i++){
            if(Premier(i))
                System.out.println(i);
        }

        // Close in / out
        inServer.close();
        outServer.close();

        // Close client socket
        socClient.close();
    }
    static boolean Premier(int n)
 {
 boolean r; 
 r = true;
 int i=2;
 while(i<=n/2 && r==true){
 if (n%2 == 0)
 r = false;
 i++;
 }
 return(r);
 }
}
