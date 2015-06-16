/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carsserveur.reseau;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Marc-Antoine
 */
public class Serveur {
    
    ServerSocket socketserver;
    Socket socketduserveur;
    Traitement mTrait;
    BufferedReader in = null;
    PrintWriter out;
    
    public Serveur(Socket socketduserveur) {
		
        this.socketduserveur = socketduserveur;
        
        try {

            
            System.out.println("Nouveau client connecté !");
            out = new PrintWriter(socketduserveur.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socketduserveur.getInputStream()));
            out.println("Vous êtes bien connecté sur le robot du projet Cars | Semaine Spé 2 2015 avec : \n");
            out.flush();
            
            Thread t = new Thread(new Reception(in));
            t.start();

        }catch (IOException e) {
                e.printStackTrace();
        }
    }
}