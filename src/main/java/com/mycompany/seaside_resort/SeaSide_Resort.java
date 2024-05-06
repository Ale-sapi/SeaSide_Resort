/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.seaside_resort;

import Input.ConsoleInput;
import menu.Menu;

/**
 *
 * @author Alessandro
 */
public class SeaSide_Resort {

    public static void main(String[] args) 
    {
        String[] vociMenu;
        int numeroVoci=11;
        vociMenu=new String[numeroVoci];
        Menu menu;
        int voceScelta;
        int esito;
        //Scanner tastiera=new Scanner(System.in);
        ConsoleInput tastiera=new ConsoleInput();
        Camera camera;
        String nomeFile="prenotazioni.csv";
        String nomeFileBinario="prenotazioni.bin";
        
        vociMenu[0]="\t-->";
        vociMenu[1]="\t-->";
        vociMenu[2]="\t-->";
        vociMenu[3]="\t-->";
        vociMenu[4]="\t-->";
        vociMenu[5]="\t-->";
        vociMenu[6]="\t-->";
        vociMenu[7]="\t-->";
        vociMenu[8]="\t-->";
        vociMenu[9]="\t-->";
        vociMenu[10]="\t-->";
        
        menu=new Menu(vociMenu);
       
        
        //Gestione menu
        do
        {
            System.out.println("Menu:");
            voceScelta=menu.sceltaMenu();
            switch (voceScelta) 
            {
                case 0:
                    Gestione G1=new Gestione();
                    camera=new Camera(2, 2000, "Superior", "Piscina", "Terrazzo", true, true, true);
                    G1.aggiungiCamera(camera);
                    Camera cm1=new Camera(G1.cercaCamera(1));
                    G1.rimuoviCamera(1);
                    break;
                    
                case 1:
                    
                    break;
                    
                case 2:
                    
                    break;
                    
                case 3:
                    
                    break;

                case 4:
                    
                    break;

                case 5:
                   
                    break;
                case 6:
                    
                    break;
                case 7:
                    
                    break;
                
                case 8:              
                    
                    break;
                case 9:
                    
                    break;
                case 10: 
                    
                    break;
            }  
        }while(voceScelta!=0); 
    }
}
