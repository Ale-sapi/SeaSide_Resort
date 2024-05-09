/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seaside_resort;

import java.util.ArrayList;
import java.util.List;
import Input.ConsoleInput;
import eccezioni.EccezioneCameraNonTrovata;
import eccezioni.EccezioneNumeroMaxCamereRaggiunto;
import eccezioni.EccezioneNumeroMaxPrenotazioniRaggiunto;
import eccezioni.EccezionePrenotazioneNonTrovata;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDate;
import Menu.Menu;
import java.time.DateTimeException;

/**
 * Classe principale dell'applicazione Seaside Resort.
 * Questa classe gestisce il menu principale e le interazioni con gli utenti.
 * Permette agli utenti di accedere, registrarsi e navigare attraverso diversi menu in base al loro ruolo (CEO, DIPENDENTE o CLIENTE).
 * I menu comprendono opzioni per la gestione delle camere, delle prenotazioni e degli account degli utenti.
 * 
 * @author Alessandro
 */
public class App {
    private static final ConsoleInput consoleInput = new ConsoleInput();
    private static final Gestione gestione = new Gestione();
    private static final List<Utente> utenti = new ArrayList<>();
    private static Utente utenteAttuale = null;
    /**
     * Menu principale dell'applicazione.
     */
    private static final Menu mainMenu = new Menu(new String[]{
     "Esci",
     "Login", 
     "Registrazione",
    });
    /**
     * Menu per utenti CEO.
     */
    private static final Menu CEO_Menu = new Menu(new String[]{
            "Logout",
            "Aggiungi camera", 
            "Restruttura camera", 
            "Blocca o Sblocca la disponibilità di una camera",
            "Rimuovi camera", 
            "Cerca Camera", 
            "Visualizza Camere ordinate per Livello",
            "Visualizza Camere ordinate per numero Letti", 
            "Inserisci una Prenotazione",
            "Visualizza elenco prenotazioni ordinate alfabeticamente per nome cliente",
            "Visualizza elenco prenotazioni ordinate per data del checkIN",
            "Cerca Prenotazione con l'ID", 
            "Cerca Prenotazione con il nome del Cliente",
            "Rimuovi Prenotazione", 
            "Modifica una prenotazione", 
            "Approva o rifiuta una prenotazione",
            "Promuovi dipendente",
            
    });
    /**
        * Menu per utenti DIPENDENTE.
     */
    private static final Menu Dipendente_Menu = new Menu(new String[]{
            "Logout",
            "Blocca o Sblocca la disponibilità di una camera", 
            "Cerca Camera",
            "Visualizza Camere ordinate per Livello", 
            "Visualizza Camere ordinate per numero Letti",
            "Inserisci una Prenotazione", 
            "Visualizza elenco prenotazioni ordinate alfabeticamente per nome cliente",
            "Visualizza elenco prenotazioni ordinate per data del checkIN", 
            "Cerca Prenotazione con l'ID",
            "Cerca Prenotazione con il nome del Cliente", 
            "Modifica una prenotazione",
            "Approva o rifiuta una prenotazione",
    });
    /**
     * Menu per utenti CLIENTE.
     */
    private static final Menu Cliente_Menu = new Menu(new String[]{
            "Logout",
            "Effettua una Prenotazione", 
            "Modifica una prenotazione",
    });
    /**
     * Il metodo principale dell'applicazione.
     * Avvia il menu principale e gestisce le scelte dell'utente.
     * @param args gli argomenti della riga di comando
     */
    public static void main(String[] args) {
        utenti.add(new Utente("Admin", "Password", "CEO"));
        boolean esci = false;
        while (!esci) {
            int scelta = mainMenu.sceltaMenu();
            switch (scelta) {
                case 0:
                    esci = true;
                    break;
                case 1:
                    login();
                    break;
                case 2:
                    registrazione();
                    break;
                
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
        System.out.println("Grazie per aver utilizzato l'applicazione.");
    }
    /**
     * Permette a un utente di accedere.
     * Questo metodo richiede all'utente il nome utente e la password,
     * controlla se le credenziali sono valide e visualizza il menu corrispondente.
     */
    private static void login() {
        try {
            System.out.println("\nEffettua il login:\n");
            System.out.print("Username: ");
            String username = consoleInput.readString();
            System.out.print("Password: ");
            String password = consoleInput.readString();
            for (Utente utente : utenti) {
                if (utente.getUsername().equals(username) && utente.getPassword().equals(password)) {
                    utenteAttuale = utente;
                    System.out.println("\nLogin effettuato con successo.\n");
                    switch (utenteAttuale.getRuolo()) {
                        case "CEO":
                            CEO_Menu();
                            break;
                        case "DIPENDENTE":
                            DipendenteMenu();
                            break;
                        case "CLIENTE":
                            ClienteMenu();
                            break;
                    }
                    return;
                }
            }
            System.out.println("\nCredenziali non valide. Riprova.\n");
        } catch (IOException ex) {
            System.out.println("\nImpossibile leggere da tastiera!\n");
        } catch (NumberFormatException ex) {
            System.out.println("\nErrore! Devi inserire un numero!\n");
        }
    }
    /**
     * Permette a un nuovo utente di registrarsi.
     * Questo metodo richiede all'utente un nome utente e una password e lo registra come CLIENTE.
     * Registra l'utente come CLIENTE.
     */
    private static void registrazione() {
        try {
            System.out.println("\nEffettua la registrazione:\n");
            System.out.print("Username: ");
            String username = consoleInput.readString();
            System.out.print("Password: ");
            String password = consoleInput.readString();
            String ruolo = "CLIENTE";
            utenti.add(new Utente(username, password, ruolo));
            System.out.println("Registrazione completata con successo.");
        } catch (IOException ex) {
            System.out.println("Impossibile leggere da tastiera!");
        } catch (NumberFormatException ex) {
            System.out.println("Errore! Devi inserire un numero!");
        }
    }
/**
 * Questo metodo gestisce il menu delle funzionalità disponibili per l'utente CEO.
 */
    private static void CEO_Menu() {
        System.out.println("Menù");
        boolean esci = false;
        while (!esci) {
            int scelta = CEO_Menu.sceltaMenu();
            switch (scelta) {
                case 0:
                    utenteAttuale = null;
                    System.out.println("Logout effettuato.");
                    esci = true;
                    break;
                case 1:
                    aggiungiCamera();
                    break;
                case 2:
                    restrutturaCamera();
                    break;
                case 3:
                    bloccaSbloccaCamera();
                    break;
                case 4:
                    rimuoviCamera();
                    break;
                case 5:
                    cercaCamera();
                    break;
                case 6:
                    visualizzaCamerePerLivello();
                    break;
                case 7:
                    visualizzaCamerePerNumeroLetti();
                    break;
                case 8:
                    prenotaCamera(utenteAttuale.getUsername());
                    break;
                case 9:
                    visualizzaPrenotazioniPerNomeCliente();
                    break;
                case 10:
                    visualizzaPrenotazioniPerCheckIN();
                    break;
                case 11:
                    cercaPrenotazione();
                    break;
                case 12:
                    cercaPrenotazioneNomeCliente();
                    break;
                case 13:
                    rimuoviPrenotazione();
                    break;
                case 14:
                    modificaPrenotazione();
                    break;
                case 15:
                    approvaRifiutaPrenotazione();
                    break;
                case 16:
                    promuoviDipendente();
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }
/**
 * Questo metodo gestisce il menu delle funzionalità disponibili per l'utente Dipendente.
 */
    private static void DipendenteMenu() {
        boolean esci = false;
        while (!esci) {
            int scelta = Dipendente_Menu.sceltaMenu();
            switch (scelta) {
                case 0:
                    utenteAttuale = null;
                    System.out.println("Logout effettuato.");
                    esci = true;
                    break;
                case 1:
                    bloccaSbloccaCamera();
                    break;
                case 2:
                    cercaCamera();
                    break;
                case 3:
                    visualizzaCamerePerLivello();
                    break;
                case 4:
                    visualizzaCamerePerNumeroLetti();
                    break;
                case 5:
                    prenotaCamera(utenteAttuale.getUsername());
                    break;
                case 6:
                    visualizzaPrenotazioniPerNomeCliente();
                    break;
                case 7:
                    visualizzaPrenotazioniPerCheckIN();
                    break;
                case 8:
                    cercaPrenotazione();
                    break;
                case 9:
                    cercaPrenotazioneNomeCliente();
                    break;
                case 10:
                    modificaPrenotazione();
                    break;
                case 11:
                    approvaRifiutaPrenotazione();
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }
/**
 * Questo metodo gestisce il menu delle funzionalità disponibili per l'utente Cliente.
 */
    private static void ClienteMenu() {
        boolean esci = false;
        while (!esci) {
            int scelta = Cliente_Menu.sceltaMenu();
            switch (scelta) {
                case 0:
                    utenteAttuale = null;
                    System.out.println("Logout effettuato.");
                    esci = true;
                    break;
                case 1:
                    prenotaCamera(utenteAttuale.getUsername());
                    break;
                case 2:
                    modificaPrenotazione();
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }
 /**
 * Questo metodo gestisce la modifica di una prenotazione.
 */
    /**
 * Questo metodo consente di modificare una prenotazione esistente nel sistema.
 * Viene richiesto l'input all'utente per i dati da modificare.
 */
private static void modificaPrenotazione() {
    try {
        Prenotazione p1;
        System.out.println("\nModifica prenotazione:\n");
        if (utenteAttuale.getRuolo().equals("CEO") || utenteAttuale.getRuolo().equals("DIPENDENTE")) 
        {
            System.out.println("Inserisci l'ID o il nome della prenotazione da modificare: ");
            String input = consoleInput.readString();
            
            if (input.matches("\\d+")) 
            { // Verifica che l'input contenga uno o più numeri interi
                int id = Integer.parseInt(input);
                p1 = gestione.cercaPrenotazione(id);
            } 
            else 
            {
                String nomePrenotazione = input;
                p1 = gestione.cercaPrenotazioneNomeCliente(nomePrenotazione);
            }
            System.out.println(p1.toString());
        } 
        else 
        {
            String nomePrenotazione = utenteAttuale.getUsername();
            p1 = gestione.cercaPrenotazioneNomeCliente(nomePrenotazione);
        }

        System.out.println("Per non modificare un dato premere invio senza scrivere nulla");

        // Modifica del numero di ospiti
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

        // Modifica del trattamento
        System.out.println("Scegli il trattamento:");
        System.out.println("1. Mezza Pensione");
        System.out.println("2. Pensione Completa");
        System.out.println("3. All-Inclusive");
        System.out.println("4. Soft All-Inclusive");
        int sceltaTrattamento = consoleInput.readInt();
        String trattamento;
        switch (sceltaTrattamento) 
        {
            case 1:
                trattamento = "Mezza Pensione";
                break;
            case 2:
                trattamento = "Pensione Completa";
                break;
            case 3:
                trattamento = "All-Inclusive";
                break;
            case 4:
                trattamento = "Soft All-Inclusive";
                break;
            default:
                trattamento = p1.getTrattamento();
                break;
        }

        // Modifica del livello
        System.out.println("Scegli il livello:");
        System.out.println("1. standard");
        System.out.println("2. suite");
        System.out.println("3. superior");
        System.out.println("4. deluxe");
        int sceltaLivello = consoleInput.readInt();
        String livello;
        switch (sceltaLivello) 
        {
            case 1:
                livello = "standard";
                break;
            case 2:
                livello = "suite";
                break;
            case 3:
                livello = "superior";
                break;
            case 4:
                livello = "deluxe";
                break;
            default:
                livello = p1.getLivello();
                break;
        }

        // Modifica della vista
        System.out.println("Scegli la vista:");
        System.out.println("1. Mare");
        System.out.println("2. Piazzale");
        System.out.println("3. Piscina");
        int sceltaVista = consoleInput.readInt();
        String vista;
        switch (sceltaVista) 
        {
            case 1:
                vista = "Mare";
                break;
            case 2:
                vista = "Piazzale";
                break;
            case 3:
                vista = "Piscina";
                break;
            default:
                vista = p1.getVista();
                break;
        }

        // Modifica del tipo di esterno
        System.out.println("Scegli il tipo di esterno:");
        System.out.println("1. Terrazzo");
        System.out.println("2. Giardino");
        int sceltaEsterno = consoleInput.readInt();
        String esterno;
        switch (sceltaEsterno) 
        {
            case 1:
                esterno = "Terrazzo";
                break;
            case 2:
                esterno = "Giardino";
                break;
            default:
                esterno = p1.getEsterno();
                break;
        }

        // Modifica della TV inclusa
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

        // Modifica della cassaforte inclusa
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

        // Modifica della data di check-in
        System.out.println("Inserisci la data di check-in:");
        System.out.println("Anno [" + p1.getAnnoIN()+ "]:");
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
        
        // Modifica della data di check-out
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
        
        // Applicazione delle modifiche alla prenotazione
        gestione.modificaPrenotazione(p1.getIdPrenotazione(), numeroOspiti, p1.getPrezzo(), trattamento, livello, vista, esterno, tv, cassaforte, annoIN, meseIN, giornoIN, annoOUT, meseOUT, giornoOUT);
        
        // Calcolo del prezzo aggiornato e modifica della prenotazione con il nuovo prezzo
        float prezzo = calcolaPrezzo(gestione.cercaPrenotazione(p1.getIdPrenotazione()));
        gestione.modificaPrenotazione(p1.getIdPrenotazione(), numeroOspiti, prezzo, trattamento, livello, vista, esterno, tv, cassaforte, annoIN, meseIN, giornoIN, annoOUT, meseOUT, giornoOUT);
        
        // Stampa a video i dettagli della prenotazione modificata
        System.out.println(p1.toString());
        System.out.println("Prenotazione modificata");
    } 
    catch (IOException ex) 
    {
        System.out.println("Impossibile leggere da tastiera!");
    } 
    catch (EccezionePrenotazioneNonTrovata ex) 
    {
        System.out.println("Errore: Prenotazione inesistente");
    }
    catch (DateTimeException ex)
    {
        System.out.println("Errore: Data inserita non valida");
    }
}

/**
 * Questo metodo gestisce la restrutturazione di una camera.
 */
    /**
 * Questo metodo consente di modificare le informazioni di una camera esistente nel sistema.
 * L'utente inserisce i dati da modificare tramite l'interfaccia della console.
 */
private static void restrutturaCamera() {
    try {
        System.out.println("\nModifica camera:\n");
        System.out.println("Inserisci il numero della camera da modificare: ");
        int numeroCamera = consoleInput.readInt();
        Camera camera = gestione.cercaCamera(numeroCamera);
        System.out.println(camera.toString());

        System.out.println("Per non modificare un dato premere invio senza scrivere nulla");

        // Modifica del numero di letti
        System.out.print("Inserisci il numero di letti: ");
        String inputNumeroLetti = consoleInput.readString();
        int numeroLetti;
        if (!inputNumeroLetti.isEmpty()) {
            numeroLetti = Integer.parseInt(inputNumeroLetti);
        } else {
            numeroLetti = camera.getNumeroLetti();
        }

        // Modifica del livello
        System.out.print("Inserisci il livello (standard, suite, superior, deluxe): ");
        String livello = consoleInput.readString();
        if (livello.isEmpty() || !livello.equalsIgnoreCase("standard") && !livello.equalsIgnoreCase("suite") && !livello.equalsIgnoreCase("superior") && !livello.equalsIgnoreCase("deluxe")) {
            livello = camera.getLivello();
        }

        // Modifica della TV inclusa
        System.out.print("TV inclusa? (true/false): ");
        String inputTv = consoleInput.readString();
        boolean tv;
        if (!inputTv.isEmpty()) {
            tv = Boolean.parseBoolean(inputTv);
        } else {
            tv = camera.isTv();
        }

        // Modifica della cassaforte inclusa
        System.out.print("Cassaforte inclusa? (true/false): ");
        String inputCassaforte = consoleInput.readString();
        boolean cassaforte;
        if (!inputCassaforte.isEmpty()) {
            cassaforte = Boolean.parseBoolean(inputCassaforte);
        } else {
            cassaforte = camera.isCassaforte();
        }

        // Modifica della disponibilità
        System.out.print("Disponibile? (true/false): ");
        String inputDisponibile = consoleInput.readString();
        boolean disponibile;
        if (!inputDisponibile.isEmpty()) {
            disponibile = Boolean.parseBoolean(inputDisponibile);
        } else {
            disponibile = camera.getDisponibilita();
        }

        gestione.restrutturaCamera(numeroCamera, numeroLetti, livello, tv, cassaforte, disponibile);
    } catch (IOException ex) {
        System.out.println("Impossibile leggere da tastiera!");
    } catch (EccezioneCameraNonTrovata ex) {
        System.out.println("Errore: Camera non trovata");
    } catch (IllegalArgumentException ex) {
        System.out.println("Errore: Input non valido");
    }
}

/**
 * Questo metodo gestisce il blocco o lo sblocco di una camera.
 */
    private static void bloccaSbloccaCamera()
    {
        try 
        {
            System.out.println("\nBlocca camera:\n");
            System.out.println("Inserisci il numero della camera da modificare: ");
            int numeroCamera = consoleInput.readInt();
            Camera camera = gestione.cercaCamera(numeroCamera);
            System.out.println(camera.toString());
            if (camera.getDisponibilita()==true)
                camera.setDisponibilita(false);
            else
                camera.setDisponibilita(true);
        }
        catch (IOException ex) 
        {
            System.out.println("Impossibile leggere da tastiera!");
        } 
        catch (EccezioneCameraNonTrovata ex) 
        {
            System.out.println("Errore: Camera non trovata");
        }
    }
    
/**
 * Questo metodo consente di prenotare una camera nel sistema.
 *
 * @param nome Il nome del cliente che effettua la prenotazione.
 */
private static void prenotaCamera(String nome) {
    try {
        System.out.println("\nPrenota una camera:\n");

        System.out.print("Inserisci il numero di ospiti: ");
        int numeroOspiti = consoleInput.readInt();

        // Trattamento
        String trattamento;
        do {
            System.out.println("Seleziona il trattamento:");
            System.out.println("1. Mezza Pensione");
            System.out.println("2. Pensione Completa");
            System.out.println("3. All-Inclusive");
            System.out.println("4. Soft All-Inclusive");
            int sceltaTrattamento = consoleInput.readInt();
            switch (sceltaTrattamento) {
                case 1:
                    trattamento = "Mezza Pensione";
                    break;
                case 2:
                    trattamento = "Pensione Completa";
                    break;
                case 3:
                    trattamento = "All-Inclusive";
                    break;
                case 4:
                    trattamento = "Soft All-Inclusive";
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
                    trattamento = null;
            }
        } while (trattamento == null);

        // Livello
        String livello;
        do {
            System.out.println("Seleziona il livello:");
            System.out.println("1. standard");
            System.out.println("2. suite");
            System.out.println("3. superior");
            System.out.println("4. deluxe");
            int sceltaLivello = consoleInput.readInt();
            switch (sceltaLivello) {
                case 1:
                    livello = "standard";
                    break;
                case 2:
                    livello = "suite";
                    break;
                case 3:
                    livello = "superior";
                    break;
                case 4:
                    livello = "deluxe";
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
                    livello = null;
            }
        } while (livello == null);

        // Vista
        String vista;
        do {
            System.out.println("Seleziona la vista:");
            System.out.println("1. Mare");
            System.out.println("2. Piazzale");
            System.out.println("3. Piscina");
            int sceltaVista = consoleInput.readInt();
            switch (sceltaVista) {
                case 1:
                    vista = "Mare";
                    break;
                case 2:
                    vista = "Piazzale";
                    break;
                case 3:
                    vista = "Piscina";
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
                    vista = null;
            }
        } while (vista == null);

        // Esterno
        String esterno;
        do {
            System.out.println("Seleziona Esterno:");
            System.out.println("1. Terrazzo");
            System.out.println("2. Giardino");
            int sceltaEsterno = consoleInput.readInt();
            switch (sceltaEsterno) {
                case 1:
                    esterno = "Terrazzo";
                    break;
                case 2:
                    esterno = "Giardino";
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
                    esterno = null;
            }
        } while (esterno == null);

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

        Prenotazione p1 = new Prenotazione(numeroOspiti, nome, trattamento, livello, vista, esterno, tv, cassaforte, annoIN, meseIN, giornoIN, annoOUT, meseOUT, giornoOUT);
        float prezzo = calcolaPrezzo(p1);
        p1.setPrezzo(prezzo);
        gestione.Prenota(p1);
        System.out.println(p1.toString());
        System.out.println("Prenotazione inviata con successo");
    } 
    catch (IOException ex) 
    {
        System.out.println("Impossibile leggere da tastiera!");
    } 
    catch (EccezioneNumeroMaxPrenotazioniRaggiunto ex) 
    {
        System.out.println("Purtroppo la sua prenotazione non può essere accettata in quanto è stato raggiunto il numero massimo di prenotazioni");
    }
    catch (DateTimeException ex)
    {
        System.out.println("Errore: Data inserita non valida");
    }
}


/**
 * Questo metodo calcola il prezzo di una prenotazione in base ai suoi attributi.
 *
 * @param prenotazione La prenotazione di cui calcolare il prezzo
 * @return Il prezzo totale della prenotazione
 */
    public static float calcolaPrezzo(Prenotazione prenotazione) 
    {
        int ospiti = prenotazione.getNumeroOspiti();
        String trattamento = prenotazione.getTrattamento().toLowerCase();
        String livello = prenotazione.getLivello().toLowerCase();
        String vista = prenotazione.getVista().toLowerCase();
        String esterno = prenotazione.getEsterno().toLowerCase();
        boolean tv = prenotazione.isTv();
        boolean cassaforte = prenotazione.isCassaforte();
        int giorni = (int) ChronoUnit.DAYS.between(prenotazione.getCheckIN(), prenotazione.getCheckOUT()); //Metodo per calcolare la differenza tra due date
        giorni++;
        float prezzoTrattamento = 0;
        switch (trattamento) {
            case "mezza pensione":
                prezzoTrattamento = 10;
                break;
            case "pensione completa":
                prezzoTrattamento = 20;
                break;
            case "all-inclusive":
                prezzoTrattamento = 30;
                break;
            case "soft all-inclusive":
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
            case "mare":
                prezzoVista = 20;
                break;
            case "piazzale":
                prezzoVista = 5;
                break;
            case "piscina":
                prezzoVista = 10;
                break;
        }

        int prezzoEsterno = 0;
        switch (esterno) {
            case "terrazzo":
                prezzoEsterno = 7;
                break;
            case "giardino":
                prezzoEsterno = 15;
                break;
        }

        int prezzoTV = tv ? 5 : 0;
        int prezzoCassaforte = cassaforte ? 5 : 0;

        float prezzo = ((ospiti * (prezzoTrattamento + prezzoVista)) + prezzoLivello + prezzoTV + prezzoCassaforte + prezzoEsterno) * giorni;
        return prezzo;
    }
/**
 * Questo metodo aggiunge una nuova camera al sistema.
 */
    private static void aggiungiCamera() {
        try {
            System.out.println("\nAggiungi una Camera\n");
            System.out.print("Inserisci il numero di letti della nuova camera: ");
            int numeroLetti = consoleInput.readInt();

            // Livello
            String livello;
            do {
                System.out.println("Seleziona il livello della nuova camera:");
                System.out.println("1. standard");
                System.out.println("2. suite");
                System.out.println("3. superior");
                System.out.println("4. deluxe");
                System.out.print("Scelta: ");
                int sceltaLivello = consoleInput.readInt();
                switch (sceltaLivello) {
                    case 1:
                        livello = "standard";
                        break;
                    case 2:
                        livello = "suite";
                        break;
                    case 3:
                        livello = "superior";
                        break;
                    case 4:
                        livello = "deluxe";
                        break;
                    default:
                        System.out.println("Scelta non valida. Riprova.");
                        livello = null;
                }
            } while (livello == null);

            // Vista
            String vista;
            do {
                System.out.println("Seleziona la vista della nuova camera:");
                System.out.println("1. Mare");
                System.out.println("2. Piazzale");
                System.out.println("3. Piscina");
                System.out.print("Scelta: ");
                int sceltaVista = consoleInput.readInt();
                switch (sceltaVista) {
                    case 1:
                        vista = "Mare";
                        break;
                    case 2:
                        vista = "Piazzale";
                        break;
                    case 3:
                        vista = "Piscina";
                        break;
                    default:
                        System.out.println("Scelta non valida. Riprova.");
                        vista = null;
                }
            } while (vista == null);

            // Esterno
            String esterno;
            do {
                System.out.println("Seleziona il tipo di esterno:");
                System.out.println("1. Terrazzo");
                System.out.println("2. Giardino");
                System.out.print("Scelta: ");
                int sceltaEsterno = consoleInput.readInt();
                switch (sceltaEsterno) {
                    case 1:
                        esterno = "Terrazzo";
                        break;
                    case 2:
                        esterno = "Giardino";
                        break;
                    default:
                        System.out.println("Scelta non valida. Riprova.");
                        esterno = null;
                }
            } while (esterno == null);

            System.out.print("La camera ha una TV? (true/false): ");
            boolean tv = consoleInput.readBoolean();
            System.out.print("La camera è dotata di Cassaforte? (true/false): ");
            boolean cassaforte = consoleInput.readBoolean();

            // Chiamata al metodo aggiungiCamera con i valori inseriti
            gestione.aggiungiCamera(new Camera(numeroLetti, livello, vista, esterno, true, tv, cassaforte));
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile leggere da tastiera!");
        } 
        catch (NumberFormatException ex) 
        {
            System.out.println("Errore! Devi inserire un numero valido!");
        } 
        catch (IllegalArgumentException ex) 
        {
            System.out.println("Errore! Valore non valido!");
        } 
        catch (EccezioneNumeroMaxCamereRaggiunto ex) 
        {
            System.out.println("Mi spiace informarla che non c'è più posto per costruire un'altra camera.");
        }
    }

/**
 * Questo metodo rimuove una camera dal sistema.
 */
    private static void rimuoviCamera()
    {
        System.out.println("\nRimuovi una camera\n");
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
        catch (EccezioneCameraNonTrovata ex) 
        {
            System.out.println("Errore: Camera non trovata");
        }
        
    }
/**
 * Questo metodo cerca una camera nel sistema in base al numero specificato.
 */
    private static void cercaCamera()
    {
        try 
        {
            System.out.println("\nCerca una camera\n");
            System.out.println("Inserire il numero della camera che si vuole cercare");
            int numero=consoleInput.readInt();
            Camera cam1;
            cam1=gestione.cercaCamera(numero);
            System.out.println(cam1.toString());
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile leggere da tastiera!");
        } 
        catch (NumberFormatException ex) 
        {
            System.out.println("Errore! Devi inserire un numero valido!");
        } 
        catch (EccezioneCameraNonTrovata ex) 
        {
            System.out.println("Errore: Camera non trovata");
        }
        
    }
/**
 * Questo metodo visualizza tutte le prenotazioni ordinate per nome cliente.
 */
    private static void visualizzaPrenotazioniPerNomeCliente() 
    {
        System.out.println("\nVisualizza Prenotazioni Per Nome Cliente\n");
        ArrayList<Prenotazione>pren;
        pren = (ArrayList<Prenotazione>) gestione.ordinaPrenotazioniPerNomeCliente();
        for (Prenotazione prenotazione : pren)
            { 
                System.out.println(prenotazione.toString());
            }
    }
/**
 * Questo metodo visualizza tutte le prenotazioni ordinate per data di check-in.
 */
    private static void visualizzaPrenotazioniPerCheckIN() 
    {
        System.out.println("\nVisualizza Prenotazioni Per CheckIN\n");
        ArrayList<Prenotazione>pren;
        pren = (ArrayList<Prenotazione>) gestione.ordinaPrenotazioniPerCheckIn();
        for (Prenotazione prenotazione : pren)
            { 
                System.out.println(prenotazione.toString());
            }
    }
/**
 * Questo metodo visualizza tutte le camere ordinate per numero di letti.
 */
    private static void visualizzaCamerePerNumeroLetti() 
    {
        System.out.println("\nVisualizza Camere Per Numero Letti\n");
        ArrayList<Camera>cam;
        cam = (ArrayList<Camera>) gestione.ordinaCamerePerNumeroLetti();
        for (Camera camera : cam)
            { 
                System.out.println(camera.toString());
            }
    }
/**
 * Questo metodo visualizza tutte le camere ordinate per livello.
 */
    private static void visualizzaCamerePerLivello() 
    {
        System.out.println("\nVisualizza Camere Per Livello\n");
        ArrayList<Camera>cam;
        cam = (ArrayList<Camera>) gestione.ordinaCamerePerLivello();
        for (Camera camera : cam)
            { 
                System.out.println(camera.toString());
            }
    }
/**
 * Questo metodo promuove un dipendente a un nuovo ruolo specificato.
 */
    private static void promuoviDipendente() {
    try {
        System.out.println("\nPromuovi un dipendente\n");
        System.out.println("Inserire lo UserName del dipendente");
        String name = consoleInput.readString();
        boolean found = false; // Per tenere traccia se l'utente è stato trovato o meno
        for (Utente utente : utenti) {
            if (utente.getUsername().equalsIgnoreCase(name)) { // Utilizzo di equalsIgnoreCase per confrontare le stringhe
                found = true;
                System.out.println("L'utente attuale è di tipo " + utente.getRuolo() + ". Vuoi promuoverlo?");
                int promozione;
                do {
                    System.out.println("Inserisci il tipo di promozione");
                    System.out.println("\n1: CLIENTE\n2: DIPENDENTE\n3: CEO");
                    System.out.print("Scelta: ");
                    promozione = consoleInput.readInt();
                } while (promozione < 1 || promozione > 3);
                switch (promozione) {
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
                System.out.println("Utente promosso\n");
            }
        }
        if (!found) { // Se l'utente non è stato trovato, stampa un messaggio appropriato
            System.out.println("L'utente cercato non si è ancora registrato");
        }

    } catch (IOException ex) {
        System.out.println("Impossibile leggere da tastiera!");
    } catch (NumberFormatException ex) {
        System.out.println("Errore! Devi inserire un numero valido!");
    }
}

/**
 * Questo metodo rimuove una prenotazione dal sistema.
 */
    private static void rimuoviPrenotazione() 
    {
        try 
        {
            System.out.println("\nRimuovi una prenotazione\n");
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
        catch (EccezionePrenotazioneNonTrovata ex) 
        {
            System.out.println("Errore prenotazione inesistente");
        }

    }
/**
 * Questo metodo cerca una prenotazione nel sistema in base all'ID specificato.
 */
    private static void cercaPrenotazione()
    {
        try 
        {
            System.out.println("\nCerca una prenotazione\n");
            System.out.println("Inserire l'id della prenotazione che si vuole cercare");
            int numero=consoleInput.readInt();
            Prenotazione p1;
            p1=gestione.cercaPrenotazione(numero);
            System.out.println(p1.toString());
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile leggere da tastiera!");
        } 
        catch (NumberFormatException ex) 
        {
            System.out.println("Errore! Devi inserire un numero valido!");
        } 
        catch (EccezionePrenotazioneNonTrovata ex) 
        {
            System.out.println("Errore: Prenotazione non trovata");
        }
        
    }
/**
 * Questo metodo cerca una prenotazione nel sistema in base al nome del cliente.
 */
    private static void cercaPrenotazioneNomeCliente()
    {
        try 
        {
            System.out.println("\nCerca una prenotazione con il nome del cliente\n");
            System.out.println("Inserire il nome del cliente che ha prenotato");
            String nome=consoleInput.readString();
            Prenotazione p1;
            p1=gestione.cercaPrenotazioneNomeCliente(nome);
            System.out.println(p1.toString());
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile leggere da tastiera!");
        } 
        catch (NumberFormatException ex) 
        {
            System.out.println("Errore! Devi inserire un numero valido!");
        } 
        catch (EccezionePrenotazioneNonTrovata ex) 
        {
            System.out.println("Errore: Prenotazione non trovata");
        }
        
    }
/**
 * Questo metodo approva o rifiuta una prenotazione nel sistema.
 */
    private static void approvaRifiutaPrenotazione()
    {
        try
        {
            System.out.println("\nApprova o Rifiuta Prenotazione\n");
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
                System.out.println(p1.toString());
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
        catch (EccezionePrenotazioneNonTrovata ex) 
        {
            System.out.println("Errore: Prenotazione inesistente");
        }
        
            
    }
}
