/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.seaside_resort;

import Input.ConsoleInput;
import eccezioni.FileException;
import java.io.IOException;
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
        
        vociMenu[0]="\t--> Esci";
        vociMenu[1]="\t--> Visualizza tutti i volumi presenti";
        vociMenu[2]="\t--> Aggiungi volume";
        vociMenu[3]="\t--> Visualizza volume (ripiano, posizione) ";
        vociMenu[4]="\t--> Elimina volume (ripiano, posizione)";
        vociMenu[5]="\t--> Mostra libri di un autore";
        vociMenu[6]="\t--> Mostra libri presenti in ordine alfabetico di titolo";
        vociMenu[7]="\t--> Esporta i volumi su file CSV";
        vociMenu[8]="\t--> Importa i volumi da file CSV";
        vociMenu[9]="\t--> Salva dati scaffale";
        vociMenu[10]="\t--> Carica dati scaffale";
        
        menu=new Menu(vociMenu);
       
        
        //Gestione menu
        do
        {
            System.out.println("Menu:");
            voceScelta=menu.sceltaMenu();
            switch (voceScelta) 
            {
                case 0:
                    
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