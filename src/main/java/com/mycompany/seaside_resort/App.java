/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seaside_resort;
import java.util.ArrayList;
import java.util.List;
import Input.ConsoleInput;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                    System.out.print("\nScelta: ");
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

    private static void DipendenteMenu() 
    {
        try
        {
            System.out.println("Menu Dipendente:");
            System.out.println("1. Modifica prenotazione");
            System.out.println("2. Logout");
            System.out.println("\nScelta: ");
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
    
    private static void modificaPrenotazione() 
    {
    try {
        System.out.println("Modifica prenotazione:");
        System.out.println("Inserisci l'ID o il nome della prenotazione da modificare: ");
        String input = consoleInput.readString();
        Prenotazione p1;
        if (input.matches("\\d+")) // Verifica che l'input contenga uno o più numeri interi
        {
            int id = Integer.parseInt(input);
            p1 = gestione.cercaPrenotazione(id);
        } else {
            String nomePrenotazione = input;
            p1 = gestione.cercaPrenotazioneNomeCliente(nomePrenotazione);
        }
        p1.toString();

        System.out.println("Per non modificare un dato premere invio senza scrivere nulla");

        System.out.print("Inserisci il numero di ospiti [" + p1.getNumeroOspiti() + "]: ");
        String inputNumeroOspiti = consoleInput.readString();
        int numeroOspiti;
        if (!inputNumeroOspiti.isEmpty()) 
        {
            numeroOspiti = Integer.parseInt(inputNumeroOspiti);
        } 
        else 
        {
            numeroOspiti = p1.getNumeroOspiti();
        }

        System.out.print("Inserisci il prezzo [" + p1.getPrezzo() + "]: ");
        String inputPrezzo = consoleInput.readString(); //Aquisisco  uno stringa
        float prezzo;
        if (!inputPrezzo.isEmpty()) //Controllo che non sia vuota
        {
            prezzo = Float.parseFloat(inputPrezzo); //Trasformo la stringa nel tipo di dato che mi serve
        } 
        else 
        {
            prezzo = p1.getPrezzo(); //Se vuota rimetto il vecchio valore di prenotazione
        }

        System.out.print("Inserisci il trattamento [" + p1.getTrattamento() + "]: ");
        String trattamento = consoleInput.readString();
        if (trattamento.isEmpty()) 
        {
            trattamento = p1.getTrattamento();
        }

        System.out.print("Inserisci il livello [" + p1.getLivello() + "]: ");
        String livello = consoleInput.readString();
        if (livello.isEmpty()) 
        {
            livello = p1.getLivello();
        }

        System.out.print("Inserisci la vista [" + p1.getVista() + "]: ");
        String vista = consoleInput.readString();
        if (vista.isEmpty()) 
        {
            vista = p1.getVista();
        }

        System.out.print("Inserisci Esterno [" + p1.getEsterno() + "]: ");
        String esterno = consoleInput.readString();
        if (esterno.isEmpty()) 
        {
            esterno = p1.getEsterno();
        }

        System.out.print("TV inclusa? (true/false) [" + p1.isTv() + "]: ");
        String inputTv = consoleInput.readString();
        boolean tv;
        if (!inputTv.isEmpty()) 
        {
            tv = Boolean.parseBoolean(inputTv);
        } 
        else 
        {
            tv = p1.isTv();
        }

        System.out.print("Cassaforte inclusa? (true/false) [" + p1.isCassaforte() + "]: ");
        String inputCassaforte = consoleInput.readString();
        boolean cassaforte;
        if (!inputCassaforte.isEmpty()) 
        {
            cassaforte = Boolean.parseBoolean(inputCassaforte);
        } 
        else 
        {
            cassaforte = p1.isCassaforte();
        }

        System.out.println("Inserisci la data di check-in:");
        System.out.println("Anno[" + p1.getAnnoIN()+ "]:");
        String inputAnnoIN = consoleInput.readString();
        int annoIN;
        if (!inputAnnoIN.isEmpty()) 
        {
            annoIN = Integer.parseInt(inputAnnoIN);
        } 
        else 
        {
            annoIN = p1.getAnnoIN();
        }

        System.out.println("Mese [" + p1.getMeseIN() + "]: ");
        String inputMeseIN = consoleInput.readString();
        int meseIN;
        if (!inputMeseIN.isEmpty()) 
        {
            meseIN = Integer.parseInt(inputMeseIN);
        } 
        else 
        {
            meseIN = p1.getMeseIN();
        }

        System.out.println("Giorno [" + p1.getGiornoIN() + "]: ");
        String inputGiornoIN = consoleInput.readString();
        int giornoIN;
        if (!inputGiornoIN.isEmpty()) 
        {
            giornoIN = Integer.parseInt(inputGiornoIN);
        } 
        else 
        {
            giornoIN = p1.getGiornoIN();
        }
        
        
        System.out.println("Inserisci la data di check-out:");
        System.out.println("Anno [" + p1.getAnnoOUT() + "]: ");
        String inputAnnoOUT = consoleInput.readString();
        int annoOUT;
        if (!inputAnnoOUT.isEmpty()) 
        {
            annoOUT = Integer.parseInt(inputAnnoOUT);
        } 
        else 
        {
            annoOUT = p1.getAnnoOUT();
        }

        System.out.println("Mese [" + p1.getMeseOUT() + "]: ");
        String inputMeseOUT = consoleInput.readString();
        int meseOUT;
        if (!inputMeseOUT.isEmpty()) 
        {
            meseOUT = Integer.parseInt(inputMeseOUT);
        } 
        else 
        {
            meseOUT = p1.getMeseOUT();
        }

        System.out.println("Giorno [" + p1.getGiornoOUT() + "]: ");
        String inputGiornoOUT = consoleInput.readString();
        int giornoOUT;
        if (!inputGiornoOUT.isEmpty()) 
        {
            giornoOUT = Integer.parseInt(inputGiornoOUT);
        } 
        else 
        {
            giornoOUT = p1.getGiornoOUT();
        }


        gestione.modificaPrenotazione(p1.getIdPrenotazione(), numeroOspiti, prezzo, trattamento, livello, vista, esterno, tv, cassaforte, annoIN, meseIN, giornoIN, annoOUT, meseOUT, giornoOUT);
        System.out.println("Prenotazione modificata");
    } 
    catch (IOException ex) 
    {
        System.out.println("Impossibile leggere da tastiera!");
    }
}
    private static void restrutturaCamera()
    {
        try 
        {
            System.out.println("Modifica camera:");
            System.out.println("Inserisci il numero della camera da modificare: ");
            int numeroCamera = consoleInput.readInt();
            Camera camera = gestione.cercaCamera(numeroCamera);
            camera.toString();

            System.out.println("Per non modificare un dato premere invio senza scrivere nulla");

            System.out.print("Inserisci il numero di letti: ");
            String inputNumeroLetti = consoleInput.readString();
            int numeroLetti;
            if (!inputNumeroLetti.isEmpty()) 
            {
                numeroLetti = Integer.parseInt(inputNumeroLetti);
            } 
            else 
            {
                numeroLetti = camera.getNumeroLetti();
            }

            System.out.print("Inserisci il livello: ");
            String livello = consoleInput.readString();
            if (livello.isEmpty()) 
            {
                livello = camera.getLivello();
            }

            System.out.print("TV inclusa? (true/false): ");
            String inputTv = consoleInput.readString();
            boolean tv;
            if (!inputTv.isEmpty()) 
            {
                tv = Boolean.parseBoolean(inputTv);
            } 
            else 
            {
                tv = camera.isTv();
            }

            System.out.print("Cassaforte inclusa? (true/false): ");
            String inputCassaforte = consoleInput.readString();
            boolean cassaforte;
            if (!inputCassaforte.isEmpty()) 
            {
                cassaforte = Boolean.parseBoolean(inputCassaforte);
            } 
            else 
            {
                cassaforte = camera.isCassaforte();
            }

            System.out.print("Disponibile? (true/false): ");
            String inputDisponibile = consoleInput.readString();
            boolean disponibile;
            if (!inputDisponibile.isEmpty()) 
            {
                disponibile = Boolean.parseBoolean(inputDisponibile);
            } 
            else 
            {
                disponibile = camera.getDisponibilita();
            }

            gestione.restrutturaCamera(numeroCamera, numeroLetti, livello, tv, cassaforte, disponibile);
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile leggere da tastiera!");
        }
        
        
    }
    private static void bloccaSbloccaCamera()
    {
        try 
        {
            System.out.println("Blocca camera:");
            System.out.println("Inserisci il numero della camera da modificare: ");
            int numeroCamera = consoleInput.readInt();
            Camera camera = gestione.cercaCamera(numeroCamera);
            camera.toString();
            if (camera.getDisponibilita()==true)
                camera.setDisponibilita(false);
            else
                camera.setDisponibilita(true);
        }
        catch (IOException ex) 
        {
            System.out.println("Impossibile leggere da tastiera!");
        }
    }
    private static void prenotaCamera() 
    {
    try {
        System.out.println("Prenota una camera:");
        
        System.out.print("Nome: ");
        String nome = consoleInput.readString();
        
        System.out.print("Inserisci il numero di ospiti: ");
        int numeroOspiti = consoleInput.readInt();
        
        System.out.print("Inserisci il trattamento: ");
        String trattamento = consoleInput.readString();
        
        System.out.print("Inserisci il livello: ");
        String livello = consoleInput.readString();
        
        System.out.print("Inserisci la vista: ");
        String vista = consoleInput.readString();
        
        System.out.print("Inserisci Esterno: ");
        int scelta;
            do
            {
                System.out.println("Inserisci il tipo di esterno\n1:Terrazzo\n2:Giardino");
                scelta=consoleInput.readInt();
            }while (scelta!=1||scelta!=2);
            String esterno;
            if (scelta==1)
                esterno = "Terrazzo";
            else
                esterno = "Giardino";
        
        System.out.print("TV inclusa? (true/false): ");
        boolean tv = consoleInput.readBoolean();
        
        System.out.print("Cassaforte inclusa? (true/false): ");
        boolean cassaforte = consoleInput.readBoolean();
        
        System.out.println("Inserisci la data di check-in:");
        System.out.print("Anno: ");
        int annoIN = consoleInput.readInt();
        System.out.print("Mese: ");
        int meseIN = consoleInput.readInt();
        System.out.print("Giorno: ");
        int giornoIN = consoleInput.readInt();
        
        System.out.println("Inserisci la data di check-out:");
        System.out.print("Anno: ");
        int annoOUT = consoleInput.readInt();
        System.out.print("Mese: ");
        int meseOUT = consoleInput.readInt();
        System.out.print("Giorno: ");
        int giornoOUT = consoleInput.readInt();
        
        Prenotazione p1=new Prenotazione(numeroOspiti,nome,trattamento,livello,vista,esterno,tv,cassaforte,annoIN,meseIN,giornoIN,annoOUT,meseOUT,giornoOUT);
        float prezzo = calcolaPrezzo(p1);
        p1.setPrezzo(prezzo);
        gestione.Prenota(p1);
        p1.toString();
        System.out.println("Prenotazione inviata con successo");
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile leggere da tastiera!");
        }
    }
    public static float calcolaPrezzo(Prenotazione prenotazione) 
    {
        int ospiti = prenotazione.getNumeroOspiti();
        String trattamento = prenotazione.getTrattamento();
        String livello = prenotazione.getLivello();
        String vista = prenotazione.getVista();
        String esterno = prenotazione.getEsterno();
        boolean tv = prenotazione.isTv();
        boolean cassaforte = prenotazione.isCassaforte();
        int giorni = (int) ChronoUnit.DAYS.between(prenotazione.getCheckIN(), prenotazione.getCheckOUT()); //Metodo per calcolare la differenza tra due date

        float prezzoTrattamento = 0;
        switch (trattamento) {
            case "Mezza Pensione":
                prezzoTrattamento = 10;
                break;
            case "Pensione Completa":
                prezzoTrattamento = 20;
                break;
            case "All-Inclusive":
                prezzoTrattamento = 30;
                break;
            case "Soft All-Inclusive":
                prezzoTrattamento = 50;
                break;
        }

        int prezzoLivello = 0;
        switch (livello) {
            case "standard":
                prezzoLivello = 10;
                break;
            case "suite":
                prezzoLivello = 15;
                break;
            case "superior":
                prezzoLivello = 30;
                break;
            case "deluxe":
                prezzoLivello = 50;
                break;
        }

        int prezzoVista = 0;
        switch (vista) {
            case "Mare":
                prezzoVista = 20;
                break;
            case "Piazzale":
                prezzoVista = 5;
                break;
            case "Piscina":
                prezzoVista = 10;
                break;
        }

        int prezzoEsterno = 0;
        switch (esterno) {
            case "Terrazzo":
                prezzoEsterno = 7;
                break;
            case "Giardino":
                prezzoEsterno = 15;
                break;
        }

        int prezzoTV = tv ? 5 : 0;
        int prezzoCassaforte = cassaforte ? 5 : 0;

        float prezzo = ((ospiti * (prezzoTrattamento + prezzoVista)) + prezzoLivello + prezzoTV + prezzoCassaforte + prezzoEsterno) * giorni;
        return prezzo;
    }
    private static void aggiungiCamera() 
    {
        try 
        {
            System.out.print("Inserisci il numero di letti della nuova camera: ");
            int numeroLetti = consoleInput.readInt();

            System.out.print("Inserisci il prezzo della nuova camera: ");
            float prezzo = consoleInput.readFloat();

            System.out.print("Inserisci il livello della nuova camera: ");
            String livello = consoleInput.readString();

            System.out.print("Inserisci la vista della nuova camera: ");
            String vista = consoleInput.readString();

            System.out.print("La camera possiede un Terrazzo o Giardino annesso?\n1:Terrazzo\n2:Giardino\n3:Altro");
            int scelta;
            do
            {
                System.out.println("Inserisci il tipo di esterno");
                scelta=consoleInput.readInt();
            }while (scelta!=1||scelta!=2||scelta!=3);
            String esterno;
            if (scelta==1)
                esterno = "Terrazzo";
            else if (scelta==2)
                esterno = "Giardino";
            else
                System.out.println("Inserire il tipo di esterno della camera");
                esterno=consoleInput.readString();
            System.out.print("La camera ha una tv? (true/false): ");
                boolean tv = consoleInput.readBoolean();
            System.out.print("La camera è dotata di Cassaforte? (true/false): ");
                boolean cassaforte = consoleInput.readBoolean();
            // Chiamata al metodo aggiungiCamera con i valori inseriti
            gestione.aggiungiCamera(new Camera(numeroLetti, livello, vista, esterno, true, tv, cassaforte));
            System.out.println("Camera aggiunta con successo!");
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile leggere da tastiera!");
        } 
        catch (NumberFormatException ex) 
        {
            System.out.println("Errore! Devi inserire un numero valido!");
        } catch (IllegalArgumentException ex) 
        {
            System.out.println("Errore! Valore non valido!");
        }
    }
    
    private static void rimuoviCamera()
    {
        System.out.println("Inserire il numero della camera che si vuole eliminare");
        int numero;
        try 
        {
            numero = consoleInput.readInt();
            gestione.rimuoviCamera(numero);
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile leggere da tastiera!");
        } 
        catch (NumberFormatException ex) 
        {
            System.out.println("Errore! Devi inserire un numero valido!");
        }
        
    }
    
    private static void cercaCamera()
    {
        try 
        {
            System.out.println("Inserire il numero della camera che si vuole cercare");
            int numero=consoleInput.readInt();
            Camera cam1;
            cam1=gestione.cercaCamera(numero);
            cam1.toString();
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile leggere da tastiera!");
        } 
        catch (NumberFormatException ex) 
        {
            System.out.println("Errore! Devi inserire un numero valido!");
        }
        
    }
    
    private static void visualizzaPrenotazioniPerNomeCliente() 
    {
        ArrayList<Prenotazione>pren;
        pren = (ArrayList<Prenotazione>) gestione.ordinaPrenotazioniPerNomeCliente();
        for (Prenotazione prenotazione : pren)
            { 
                prenotazione.toString();
            }
    }
    
    private static void visualizzaPrenotazioniPerCheckIN() 
    {
        ArrayList<Prenotazione>pren;
        pren = (ArrayList<Prenotazione>) gestione.ordinaPrenotazioniPerCheckIn();
        for (Prenotazione prenotazione : pren)
            { 
                prenotazione.toString();
            }
    }

    private static void visualizzaCamerePerNumeroLetti() 
    {
        ArrayList<Camera>cam;
        cam = (ArrayList<Camera>) gestione.ordinaCamerePerNumeroLetti();
        for (Camera camera : cam)
            { 
                camera.toString();
            }
    }
    private static void visualizzaCamerePerLivello() 
    {
        ArrayList<Camera>cam;
        cam = (ArrayList<Camera>) gestione.ordinaCamerePerLivello();
        for (Camera camera : cam)
            { 
                camera.toString();
            }
    }
    private static void promuoviDipendente() 
    {
        try 
        {
            System.out.println("Inserire lo UserName del dipendente");
            String Name=consoleInput.readString();
            for (Utente utente : utenti)
            { 
                if (utente.getUsername()==Name)
                {
                    System.out.println("L'utente attuale è di tipo"+utente.getRuolo()+". Vuoi promuoverlo?");
                    int promozione;
                    do
                    {
                        System.out.println("Inserisci il tipo di promozione");
                        promozione=consoleInput.readInt();
                    }while (promozione!=1||promozione!=2||promozione!=3);
                    switch (promozione) 
                    {
                        case 1:
                            utente.setRuolo("CLIENTE");
                            break;
                        case 2:
                            utente.setRuolo("DIPENDENTE");
                            break;
                        case 3:
                            utente.setRuolo("CEO");
                            break;
                    }
                    utente.toString();
                }
                
                else
                    System.out.println("L'utente cercato non si è ancora registrato");
            }
            
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile leggere da tastiera!");
        } 
        catch (NumberFormatException ex) 
        {
            System.out.println("Errore! Devi inserire un numero valido!");
        }
    }
    private static void rimuoviPrenotazione() 
    {
        try 
        {
            System.out.println("Inserisci l'ID o il nome della prenotazione da modificare: ");
            String input = consoleInput.readString();
            Prenotazione p1;
            if (input.matches("\\d+")) // Verifica che l'input contenga uno o più numeri interi
            {
                int id = Integer.parseInt(input);
                p1 = gestione.cercaPrenotazione(id);
            } else {
                String nomePrenotazione = input;
                p1 = gestione.cercaPrenotazioneNomeCliente(nomePrenotazione);
            }
            gestione.rimuoviPrenotazione(p1.getIdPrenotazione());
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile leggere da tastiera!");
        } 
        catch (NumberFormatException ex) 
        {
            System.out.println("Errore! Devi inserire un numero valido!");
        }

    }
    
    private static void cercaPrenotazione()
    {
        try 
        {
            System.out.println("Inserire l'id della prenotazione che si vuole cercare");
            int numero=consoleInput.readInt();
            Prenotazione p1;
            p1=gestione.cercaPrenotazione(numero);
            p1.toString();
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile leggere da tastiera!");
        } 
        catch (NumberFormatException ex) 
        {
            System.out.println("Errore! Devi inserire un numero valido!");
        }
        
    }
    
    private static void cercaPrenotazioneNomeCliente()
    {
        try 
        {
            System.out.println("Inserire il nome del cliente che ha prenotato");
            String nome=consoleInput.readString();
            Prenotazione p1;
            p1=gestione.cercaPrenotazioneNomeCliente(nome);
            p1.toString();
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile leggere da tastiera!");
        } 
        catch (NumberFormatException ex) 
        {
            System.out.println("Errore! Devi inserire un numero valido!");
        }
        
    }
    
    private static void approvaRifiutaPrenotazione()
    {
        try
        {
            System.out.println("Approva o Rifiuta Prenotazione");
            System.out.println("Inserisci il numero della prenotazione oppure premi invio per cercare la prima disponibile");
            String inputID = consoleInput.readString();
                int ID;
                Prenotazione p1;
                if (!inputID.isEmpty()) 
                {
                    ID = Integer.parseInt(inputID);
                } 
                else 
                {
                    ID = gestione.cercaPrimaPrenotazioneDaApprovare().getIdPrenotazione();
                }
                p1=gestione.cercaPrenotazione(ID);
                p1.toString();
                System.out.println("Vuoi Approvare?(true/false)");
                boolean appro=consoleInput.readBoolean();
                String nuovoStato="Approvata";
                if (appro)
                {

                }
                else
                {
                    int motivo;
                    do
                    {
                        System.out.println("Inserisci il motivo del rifiuto");
                        motivo=consoleInput.readInt();
                    }while (motivo!=1||motivo!=2||motivo!=3);
                    switch (motivo) 
                    {
                        case 1:
                            nuovoStato="Rifiutata: Overbooking";
                            break;
                        case 2:
                            nuovoStato="Rifiutata: Prenotazione non conforme";
                            break;
                        case 3:
                            nuovoStato="Rifiutata: Altro";
                            break;
                    }
                }
            gestione.approvaRifiutaPrenotazione(ID, nuovoStato,appro);
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile leggere da tastiera!");
        } 
        catch (NumberFormatException ex) 
        {
            System.out.println("Errore! Devi inserire un numero valido!");
        }
        
            
    }
}
