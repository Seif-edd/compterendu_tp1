/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.io.*;
import java.net.Socket;

public class Client {
    static final int port = 1200;

    public static void main(String[] args) throws Exception {

        System.out.println("connection request");

        //Create a client socket
        Socket socket = new Socket("127.0.0.1", port);
        System.out.println("Connection established");

        // create in / out
        BufferedReader inClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outClient = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

        BufferedReader keybord=new BufferedReader(new InputStreamReader(System.in));
        // permet de lire à partir d'un clavier
        System.out.println("Taper un entier ");
        String ch = keybord.readLine();
        outClient.println(ch); 

        //close in / out
        inClient.close();
        outClient.close();

        // close client socket
        socket.close();
    }
    
}
