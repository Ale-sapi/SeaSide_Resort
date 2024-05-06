/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seaside_resort;
import java.util.ArrayList;
import java.util.List;
import Input.ConsoleInput;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import menu.Menu;
/**
 *
 * @author Alessandro
 */
public class App 
{
    private static final ConsoleInput consoleInput = new ConsoleInput();
    private static final Gestione gestione = new Gestione();
    private static final List<Utente> utenti = new ArrayList<>();
    private static Utente utenteAttuale = null;

    public static void main(String[] args) 
    {
        boolean esci = false;
        while (!esci) 
        {
            if (utenteAttuale == null) 
            {
                try 
                {
                    System.out.println("Benvenuto! Seleziona un'opzione:");
                    System.out.println("1. Login");
                    System.out.println("2. Registrazione");
                    System.out.println("3. Esci");
                    int scelta;

                        scelta = consoleInput.readInt();

                    switch (scelta) 
                    {
                        case 1:
                            login();
                            break;
                        case 2:
                            registrazione();
                            break;
                        case 3:
                            esci = true;
                            break;
                        default:
                            System.out.println("Scelta non valida. Riprova.");
                    }
                }
                catch (IOException ex) 
                {
                    System.out.println("Impossibile leggere da tastiera!");
                } 
                catch (NumberFormatException ex) 
                {
                    System.out.println("Errore! Devi inserire un numero!");
                }
            } 
            else 
            {
                switch (utenteAttuale.getRuolo()) 
                {
                    case "CEO":
                        CEOMenu();
                        break;
                    case "DIPENDENTE":
                        DipendenteMenu();
                        break;
                    case "CLIENTE":
                        ClienteMenu();
                        break;
                }
            }
        }
        System.out.println("Grazie per aver utilizzato l'applicazione.");
    }

    private static void login() 
    {
        try
        {
            System.out.println("Effettua il login:");
            System.out.print("Username: ");
            String username = consoleInput.readString();
            System.out.print("Password: ");
            String password = consoleInput.readString();
            for (Utente utente : utenti) 
            {
                if (utente.getUsername().equals(username) && utente.getPassword().equals(password)) 
                {
                    utenteAttuale = utente;
                    System.out.println("Login effettuato con successo.");
                    return;
                }
            }
            System.out.println("Credenziali non valide. Riprova.");
            }
            catch(IOException ex)
            {
                System.out.println("Impossibile leggere da tastiera!");
            }
            catch(NumberFormatException ex)
            {
                System.out.println("Errore! Devi inserire un numero!");
            }
        
    }

    private static void registrazione() 
    {
        try
        {
            System.out.println("Effettua la registrazione:");
            System.out.print("Username: ");
            String username = consoleInput.readString();
            System.out.print("Password: ");
            String password = consoleInput.readString();
            System.out.print("Ruolo (CEO, DIPENDENTE, CLIENTE): ");
            String ruolo = consoleInput.readString().toUpperCase();
            utenti.add(new Utente(username, password, ruolo));
            System.out.println("Registrazione completata con successo.");
        }
        catch(IOException ex)
        {
            System.out.println("Impossibile leggere da tastiera!");
        }
        catch(NumberFormatException ex)
        {
            System.out.println("Errore! Devi inserire un numero!");
        }
    }

    private static void CEOMenu() 
    {
        try
        {
            System.out.println("Menu CEO:");
            System.out.println("1. Aggiungi camera");
            System.out.println("2. Visualizza elenco prenotazioni ordinate per nome cliente");
            System.out.println("3. Promuovi dipendente");
            System.out.println("4. Logout");
            int scelta = consoleInput.readInt();
            switch (scelta) 
            {
            case 1:
                aggiungiCamera();
                break;
            case 2:
                visualizzaPrenotazioniPerNomeCliente();
                break;
            case 3:
                promuoviDipendente();
                break;
            case 4:
                utenteAttuale = null;
                System.out.println("Logout effettuato.");
                break;
            default:
                System.out.println("Scelta non valida. Riprova.");
            }
        }
        catch(IOException ex)
        {
            System.out.println("Impossibile leggere da tastiera!");
        }
        catch(NumberFormatException ex)
        {
            System.out.println("Errore! Devi inserire un numero!");
        }
    }

    private static void aggiungiCamera() {
        // Implementazione aggiunta camera
    }

    private static void visualizzaPrenotazioniPerNomeCliente() {
        // Implementazione visualizzazione prenotazioni
    }

    private static void promuoviDipendente() {
        // Implementazione promozione dipendente
    }

    private static void DipendenteMenu() 
    {
        try
        {
            System.out.println("Menu Dipendente:");
            System.out.println("1. Modifica prenotazione");
            System.out.println("2. Logout");
            int choice = consoleInput.readInt();
            switch (choice) 
            {
                case 1:
                    modificaPrenotazione();
                    break;
                case 2:
                    utenteAttuale = null;
                    System.out.println("Logout effettuato.");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
        catch(IOException ex)
        {
            System.out.println("Impossibile leggere da tastiera!");
        }
        catch(NumberFormatException ex)
        {
            System.out.println("Errore! Devi inserire un numero!");
        }
        
    }

    private static void modificaPrenotazione() {
        // Implementazione modifica prenotazione
    }

    private static void ClienteMenu() 
    {
        try
        {
            System.out.println("Menu Cliente:");
            System.out.println("1. Prenota camera");
            System.out.println("2. Logout");
            int choice = consoleInput.readInt();
            switch (choice) 
            {
                case 1:
                    prenotaCamera();
                    break;
                case 2:
                    utenteAttuale = null;
                    System.out.println("Logout effettuato.");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
        catch(IOException ex)
        {
            System.out.println("Impossibile leggere da tastiera!");
        }
        catch(NumberFormatException ex)
        {
            System.out.println("Errore! Devi inserire un numero!");
        }
        
    }

    private static void prenotaCamera() {
        // Implementazione prenotazione camera
    }
}
