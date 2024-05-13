/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seaside_resort;

import Input.ConsoleInput;
import eccezioni.*;
import gestioneFile.FileException;
import gestioneFile.TextFile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe che gestisce le operazioni del resort.
 * Questa classe fornisce metodi per gestire le camere e le prenotazioni del resort.
 * Inoltre, fornisce metodi per effettuare operazioni come aggiungere, rimuovere, cercare e ordinare camere e prenotazioni.
 * Gli oggetti di questa classe rappresentano il sistema di gestione del resort.
 * I metodi di questa classe consentono di gestire le camere e le prenotazioni del resort.
 * Gli oggetti di questa classe vengono utilizzati per eseguire operazioni come aggiungere, rimuovere, cercare e ordinare camere e prenotazioni.
 * Questa classe rappresenta il sistema di gestione del resort.
 * @author Alessandro
 */
public class Gestione 
{
    private static final int MAX_CAMERE = 200;
    private static final int MAX_PRENOTAZIONI = 200;
    private static int numCamere=0;
    private static int numPrenotazioni=0;
    ConsoleInput consoleInput=new ConsoleInput();
    
    /***
     * Costruttore
     */
    public Gestione() 
    {
    }
    
    ArrayList<Camera>camere=new ArrayList<>();
    ArrayList<Prenotazione>prenotazioni=new ArrayList<>();
    
    /**
     * Aggiunge una nuova camera al resort.
     * @param camera La camera da aggiungere.
     * @throws EccezioneNumeroMaxCamereRaggiunto Viene sollevata se il numero massimo di camere è stato raggiunto.
     */
    public void aggiungiCamera(Camera camera) throws EccezioneNumeroMaxCamereRaggiunto
    {
        if (numCamere<=MAX_CAMERE)
        {
            camere.add(camera);
            numCamere++;
            System.out.println("Camera numero "+camera.getNumeroCamera()+" Aggiunta\n");
            System.out.println(camera.toString());
        }
        else
            throw new EccezioneNumeroMaxCamereRaggiunto();
    }
    
    /**
     * Rimuove una camera dal resort.
     * @param numCamera Il numero della camera da rimuovere.
     * @throws EccezioneCameraNonTrovata Viene sollevata se la camera specificata non è stata trovata.
     */
    public void rimuoviCamera (int numCamera) throws EccezioneCameraNonTrovata
    {
        Camera camera = cercaCamera(numCamera);
        if (camera != null) 
        {
            camere.remove(camera);
            numCamere--;
            System.out.println("Camera rimossa.");
        } 
        else 
        {
            throw new EccezioneCameraNonTrovata();
        }
    }
    
    /**
     * Cerca una camera per numero.
     * @param numero Il numero della camera da cercare.
     * @return La camera corrispondente al numero specificato.
     * @throws EccezioneCameraNonTrovata Viene sollevata se la camera specificata non è stata trovata.
     */
    public Camera cercaCamera(int numero) throws EccezioneCameraNonTrovata
    {
        for (Camera camera : camere) 
        {
            if (camera.getNumeroCamera()==numero) 
                {
                    return camera;
                }
        }
        throw new EccezioneCameraNonTrovata();
    }
    
    /**
     * Cerca la prima camera disponibile per una prenotazione.
     * @param prenotazione La prenotazione per cui cercare una camera disponibile.
     * @return La prima camera disponibile per la prenotazione specificata.
     * @throws EccezioneCameraNonTrovata Viene sollevata se non viene trovata una camera disponibile per la prenotazione.
     */
    public Camera cercaPrimaCameraDisponibile(Prenotazione prenotazione) throws EccezioneCameraNonTrovata
    {
        for (Camera camera : camere) 
        {
            if (camera.getNumeroLetti()==prenotazione.getNumeroOspiti()&&camera.getLivello()==prenotazione.getLivello()&&camera.getVista()==prenotazione.getVista()&&camera.getEsterno()==prenotazione.getEsterno()&&camera.isTv()==prenotazione.isTv()&&camera.isCassaforte()==prenotazione.isCassaforte()) 
                {
                    if(camera.isDisponibile(prenotazione.getCheckIN(), prenotazione.getCheckOUT()))
                        return camera;
                }
        }
        throw new EccezioneCameraNonTrovata();
    }
    
    /**
     * Prenota una nuova prenotazione.
     * @param prenotazione La prenotazione da aggiungere.
     * @throws EccezioneNumeroMaxPrenotazioniRaggiunto Viene sollevata se il numero massimo di prenotazioni è stato raggiunto.
     */
    public void Prenota(Prenotazione prenotazione) throws EccezioneNumeroMaxPrenotazioniRaggiunto
    {
        if (numPrenotazioni<=MAX_PRENOTAZIONI)
        {
            prenotazioni.add(prenotazione);
            numPrenotazioni++;
            System.out.println("Prenotazione numero"+prenotazione.getIdPrenotazione()+"Aggiunta");
        }
        else
            throw new EccezioneNumeroMaxPrenotazioniRaggiunto();
    }
    
    /**
     * Rimuove una prenotazione dal resort.
     * @param idPrenotazione L'ID della prenotazione da rimuovere.
     * @throws EccezionePrenotazioneNonTrovata Viene sollevata se la prenotazione specificata non è stata trovata.
     */
    public void rimuoviPrenotazione (int idPrenotazione) throws EccezionePrenotazioneNonTrovata
    {
        Prenotazione prenotazione = cercaPrenotazione(idPrenotazione);
        if (prenotazione != null) 
        {
            prenotazioni.remove(prenotazione);
            numPrenotazioni--;
            System.out.println("Prenotazione rimossa.");
        } 
        else 
        {
            throw new EccezionePrenotazioneNonTrovata();
        }
    }
    
    /**
     * Cerca una prenotazione per ID.
     * @param Id L'ID della prenotazione da cercare.
     * @return La prenotazione corrispondente all'ID specificato.
     * @throws EccezionePrenotazioneNonTrovata Viene sollevata se la prenotazione specificata non è stata trovata.
     */
    public Prenotazione cercaPrenotazione(int Id) throws EccezionePrenotazioneNonTrovata
    {
        for (Prenotazione prenotazione : prenotazioni) 
        {
            if (prenotazione.getIdPrenotazione()==Id) 
                {
                    return prenotazione;
                }
        }
        throw new EccezionePrenotazioneNonTrovata();
    }
    
    /**
     * Cerca una prenotazione per nome cliente.
     * @param nome Il nome del cliente associato alla prenotazione da cercare.
     * @return La prenotazione corrispondente al nome cliente specificato.
     * @throws IOException Viene sollevata se si verifica un errore di input/output.
     * @throws EccezionePrenotazioneNonTrovata Viene sollevata se la prenotazione specificata non è stata trovata.
     */
    public Prenotazione cercaPrenotazioneNomeCliente(String nome) throws IOException, EccezionePrenotazioneNonTrovata
    {
        for (Prenotazione prenotazione : prenotazioni) 
        {
            if (prenotazione.getNomeCliente().equals(nome)) 
                {
                    System.out.println(prenotazione.toString());
                    System.out.println("è questa la prenotazione che cercavi? (true/false)");
                    
                    boolean scelta=consoleInput.readBoolean();
                    if (scelta)
                        return prenotazione;                                      
                    
                }
        }
         throw new EccezionePrenotazioneNonTrovata();
    }
    
    /**
     * Approva o rifiuta una prenotazione.
     * @param id L'ID della prenotazione da approvare o rifiutare.
     * @param nuovoStato Il nuovo stato della prenotazione.
     * @param approvato True se la prenotazione è approvata, false altrimenti.
     * @throws EccezionePrenotazioneNonTrovata Viene sollevata se la prenotazione specificata non è stata trovata.
     */
    public void approvaRifiutaPrenotazione(int id, String nuovoStato, boolean approvato) throws EccezionePrenotazioneNonTrovata
    {
        Prenotazione p1=cercaPrenotazione(id);
        if(p1 != null)
        {
            if (approvato==true)
            {
                try {
                    Camera cameraDisponibile = cercaPrimaCameraDisponibile(p1);
                    p1.setNumeroCamera(cameraDisponibile.getNumeroCamera());
                    p1.setStatoPrenotazione("Approvata");
                    cameraDisponibile.aggiungiPrenotazione(p1);
                    } 
                catch (EccezioneCameraNonTrovata ex) 
                {
                    System.out.println("Errore: Nessuna camera disponibile");
                    p1.setStatoPrenotazione("Rifiutata: Camera non trovata");
                }
            }
            else
            {
                p1.setStatoPrenotazione(nuovoStato);
            }
            System.out.println("Stato aggiornato");
            System.out.println(p1.toString());
        }
        else
            throw new EccezionePrenotazioneNonTrovata();
    }
    
    /**
     * Restituisce il numero delle camera presenti.
     * 
     * @return Numero delle camere.
     */
    public static int getNumCamere() {
        return numCamere;
    }

    /**
     * Restituisce il numero delle prenotazioni presenti.
     * 
     * @return Numero delle prenotazioni.
     */
    public static int getNumPrenotazioni() {
        return numPrenotazioni;
    }
    
    /***
     * Metodo per ordinare le prenotazioni per data di check-in
     * @return prenotazioni ordinate per data di check-in
     */
    public List<Prenotazione> ordinaPrenotazioniPerCheckIn() 
    {
        List<Prenotazione> copiaPrenotazioni = new ArrayList<>(prenotazioni);
        Collections.sort(copiaPrenotazioni, Comparator.comparing(prenotazione -> prenotazione.getCheckIN()));
        return copiaPrenotazioni;
    }
        
    /***
     * Metodo per ordinare le prenotazioni per nome del cliente
     * @return prenotazioni ordinate per nome del cliente
     */
    public List<Prenotazione> ordinaPrenotazioniPerNomeCliente() 
    {
        List<Prenotazione> copiaPrenotazioni = new ArrayList<>(prenotazioni);
        Collections.sort(copiaPrenotazioni, Comparator.comparing(prenotazione -> prenotazione.getNomeCliente()));
        return copiaPrenotazioni;
    }
    
    /***
     * Metodo per ordinare le camere per livello
     * @return camere ordinate per livello
     */
    public List<Camera> ordinaCamerePerLivello() 
    {
        List<Camera> copiaCamere = new ArrayList<>(camere);
        Collections.sort(copiaCamere, Comparator.comparing(camera -> camera.getLivello()));
        return copiaCamere;
    }

    /***
     * Metodo per ordinare le camere per numero di letti
     * @return camere ordinate per numero di letti
     */
    public List<Camera> ordinaCamerePerNumeroLetti() 
    {
        List<Camera> copiaCamere = new ArrayList<>(camere);
        Collections.sort(copiaCamere, Comparator.comparingInt(camera -> camera.getNumeroLetti()));
        return copiaCamere;
    }  

    /**
     * Modifica i dettagli di una camera esistente.
     * @param numeroCamera Il numero della camera da modificare.
     * @param numeroLetti Il nuovo numero di letti della camera.
     * @param livello Il nuovo livello della camera.
     * @param tv True se la camera ha una TV, false altrimenti.
     * @param cassaforte True se la camera ha una cassaforte, false altrimenti.
     * @param disponibile True se la camera è disponibile, false altrimenti.
     * @throws EccezioneCameraNonTrovata Viene sollevata se la camera specificata non è stata trovata.
     */
    public void restrutturaCamera(int numeroCamera, int numeroLetti, String livello, boolean tv, boolean cassaforte, boolean disponibile) throws EccezioneCameraNonTrovata 
    {
    Camera camera = cercaCamera(numeroCamera);
    if (camera != null) 
    {
        camera.modificaCamera(numeroLetti, livello, tv, cassaforte, disponibile);
        System.out.println("Camera modificata con successo.");
    } 
    else 
    {
        throw new EccezioneCameraNonTrovata();
    }
}

    /**
     * Modifica i dettagli di una prenotazione esistente.
     * @param idPrenotazione L'ID della prenotazione da modificare.
     * @param numeroOspiti Il nuovo numero di ospiti della prenotazione.
     * @param prezzo Il nuovo prezzo della prenotazione.
     * @param trattamento Il nuovo trattamento della prenotazione.
     * @param livello Il nuovo livello della prenotazione.
     * @param vista La nuova vista della prenotazione.
     * @param esterno La nuova posizione esterna della prenotazione.
     * @param tv True se la prenotazione ha una TV, false altrimenti.
     * @param cassaforte True se la prenotazione ha una cassaforte, false altrimenti.
     * @param annoIN L'anno di check-in della prenotazione.
     * @param meseIN Il mese di check-in della prenotazione.
     * @param giornoIN Il giorno di check-in della prenotazione.
     * @param annoOUT L'anno di check-out della prenotazione.
     * @param meseOUT Il mese di check-out della prenotazione.
     * @param giornoOUT Il giorno di check-out della prenotazione.
     * @throws EccezionePrenotazioneNonTrovata Viene sollevata se la prenotazione specificata non è stata trovata.
     */
    public void modificaPrenotazione(int idPrenotazione, int numeroOspiti, float prezzo, String trattamento, String livello, String vista, String esterno, boolean tv, boolean cassaforte, int annoIN, int meseIN, int giornoIN, int annoOUT, int meseOUT, int giornoOUT) throws EccezionePrenotazioneNonTrovata 
    {
        Prenotazione prenotazione = cercaPrenotazione(idPrenotazione);
        if (prenotazione != null) 
        {
            prenotazione.setNumeroOspiti(numeroOspiti);
            prenotazione.setPrezzo(prezzo);
            prenotazione.setTrattamento(trattamento);
            prenotazione.setLivello(livello);
            prenotazione.setVista(vista);
            prenotazione.setEsterno(esterno);
            prenotazione.setTv(tv);
            prenotazione.setCassaforte(cassaforte);
            prenotazione.setAnnoIN(annoIN);
            prenotazione.setMeseIN(meseIN);
            prenotazione.setGiornoIN(giornoIN);
            prenotazione.setAnnoOUT(annoOUT);
            prenotazione.setMeseOUT(meseOUT);
            prenotazione.setGiornoOUT(giornoOUT);
            prenotazione.setCheckIN(LocalDate.of(annoIN, meseIN, giornoIN));
            prenotazione.setCheckOUT(LocalDate.of(annoOUT, meseOUT, giornoOUT));
            System.out.println("Prenotazione modificata con successo.");
        } 
        else 
        {
            throw new EccezionePrenotazioneNonTrovata();
        }
    }
    
    /**
     * Cerca la prima prenotazione da approvare.
     * @return La prima prenotazione da approvare.
     * @throws EccezionePrenotazioneNonTrovata Viene sollevata se non viene trovata una prenotazione da approvare.
     */
    public Prenotazione cercaPrimaPrenotazioneDaApprovare() throws EccezionePrenotazioneNonTrovata
    {
        for (Prenotazione prenotazione : prenotazioni) 
        {
            if (prenotazione.getStatoPrenotazione().equals("In Approvazione")) 
                {
                    return prenotazione;
                }
        }
        throw new EccezionePrenotazioneNonTrovata();
    }
    
    /**
     * Importa le camere da un file CSV specificato.
     *
     * @param fileName il nome del file CSV da cui importare le camere
     * @throws IOException se si verifica un errore di I/O durante la lettura del file
     */
    public void importaCamereCSV(String fileName) throws IOException 
    {
        TextFile f1=new TextFile(fileName, 'R');
        String rigaLetta;
        String[] datiCamera;
        int numeroCamera, numSuccessivo, numeroLetti;
        String livello, vista, esterno;
        boolean disponibile, tv, cassaforte;
        Camera cam;
        try 
        {
            while (true) 
            {
                rigaLetta=f1.fromFile();
                datiCamera = rigaLetta.split(";");
                numeroCamera = Integer.parseInt(datiCamera[0]);
                numSuccessivo =Integer.parseInt(datiCamera[1]);
                numeroLetti = Integer.parseInt(datiCamera[2]);
                livello = datiCamera[3];
                vista = datiCamera [4];
                esterno = datiCamera [5];
                disponibile = Boolean.parseBoolean(datiCamera[6]);
                tv = Boolean.parseBoolean(datiCamera[7]);
                cassaforte = Boolean.parseBoolean(datiCamera[8]);
                cam = new Camera(numeroCamera, numSuccessivo, numeroLetti, livello, vista, esterno, disponibile, tv, cassaforte);
                try 
                {
                    aggiungiCamera(cam);
                } 
                catch (EccezioneNumeroMaxCamereRaggiunto ex) 
                {
                    System.out.println("Numero massimo camera raggiunto");
                } 
            }
        }
        catch (FileException ex) 
        { 
            //E' finito il file di testo
            f1.close();
        }
    }

    /**
     * Importa le prenotazioni da un file CSV specificato.
     *
     * @param fileName il nome del file CSV da cui importare le prenotazioni
     * @throws IOException se si verifica un errore di I/O durante la lettura del file
     */
    public void importaPrenotazioniCSV(String fileName) throws IOException
    {
        TextFile f1=new TextFile(fileName, 'R');
        String rigaLetta;
        String[] datiPrenotazione;
        int idPrenotazione, numsuccessivo, numeroOspiti, numeroCamera, annoIN, meseIN, giornoIN, annoOUT, meseOUT, giornoOUT;
        float prezzo;
        String nomeCliente, trattamento, statoPrenotazione, livello, vista, Esterno;
        Boolean tv, cassaforte;
        Prenotazione prenotazione;
        try 
        {
            while (true) 
            {
                rigaLetta=f1.fromFile();
                datiPrenotazione = rigaLetta.split(";");
                idPrenotazione = Integer.parseInt(datiPrenotazione[0]);
                numsuccessivo = Integer.parseInt(datiPrenotazione[1]);
                numeroOspiti = Integer.parseInt(datiPrenotazione[2]);
                prezzo = Float.parseFloat(datiPrenotazione[3]);
                nomeCliente = datiPrenotazione[4];
                trattamento = datiPrenotazione[5];
                statoPrenotazione = datiPrenotazione[6];
                livello = datiPrenotazione[7];
                vista = datiPrenotazione[8];
                Esterno = datiPrenotazione[9];
                tv = Boolean.parseBoolean(datiPrenotazione[10]);
                cassaforte = Boolean.parseBoolean(datiPrenotazione[11]);
                annoIN = Integer.parseInt(datiPrenotazione[12]);
                meseIN = Integer.parseInt(datiPrenotazione[13]);
                giornoIN = Integer.parseInt(datiPrenotazione[13]);
                annoOUT = Integer.parseInt(datiPrenotazione[13]);
                meseOUT = Integer.parseInt(datiPrenotazione[13]);
                giornoOUT = Integer.parseInt(datiPrenotazione[13]);
                prenotazione = new Prenotazione(idPrenotazione, numsuccessivo, numeroOspiti, prezzo, nomeCliente, trattamento, livello, vista, Esterno, tv, cassaforte, annoIN, meseIN, giornoIN, annoOUT, meseOUT, giornoOUT);
                try
                {
                    Prenota(prenotazione);
                } 
                catch (EccezioneNumeroMaxPrenotazioniRaggiunto ex) 
                {
                    System.out.println("Numero massimo prenotazioni raggiunto");
                }
            }
        }
        catch (FileException ex) 
        { 
            //E' finito il file di testo
            f1.close();
        }
            
    }
        
    /**
     * Importa gli utenti da un file CSV specificato.
     *
     * @param fileName il nome del file CSV da cui importare gli utenti
     * @param utenti la lista in cui aggiungere gli utenti importati
     * @throws IOException se si verifica un errore di I/O durante la lettura del file
     */
    public void importaUtenteCSV (String fileName, List<Utente> utenti) throws IOException
    {
        TextFile f1 = new TextFile(fileName, 'R');
        String rigaLetta;
        String[] datiUtente;
        String username, password, ruolo;
        Utente utente;
        try {
                while (true)
                {

                    rigaLetta=f1.fromFile();
                    datiUtente = rigaLetta.split(";");
                    username = datiUtente[0];
                    password = datiUtente[1];
                    ruolo = datiUtente[2];
                    utente = new Utente(username, password, ruolo);
                    utenti.add(utente);
                }
            }
        catch (FileException ex) 
            {
                //E' finito il file di testo
                f1.close();
            }
    }
    
    /**
     * Esporta le camere in un file CSV specificato.
     *
     * @param fileName il nome del file CSV in cui esportare le camere
     * @throws IOException se si verifica un errore di I/O durante la scrittura del file
     * @throws FileException se si verifica un errore generico di file, nel nostro caso quando finisce
     */
    public void esportaCamereCSV(String fileName) throws IOException, FileException 
    {
        TextFile f1=new TextFile(fileName,'W');
        String datiCamera;
       
        for (Camera camera : camere) 
        {
                datiCamera=camera.getNumeroCamera()+";"+camera.getNumSuccessivo()+";"+camera.getNumeroLetti()+";"+camera.getLivello()+";"+camera.getVista()+";"+camera.getEsterno()+";"+camera.getDisponibilita()+";"+camera.isTv()+";"+camera.isCassaforte();
                f1.toFile(datiCamera);
        
        }
        f1.close();
    }

    /**
     * Esporta le prenotazioni in un file CSV.
     *
     * @param fileName Nome del file CSV in cui esportare le prenotazioni.
     * @throws IOException     Se si verifica un errore di I/O durante la scrittura del file.
     * @throws FileException   Se si verifica un errore generico di file, nel nostro caso quando finisce
     */
    public void esportaPrenotazioniCSV(String fileName) throws IOException, FileException 
    {
        TextFile f1=new TextFile(fileName,'W');
        String datiPrenotazione;
       
            for (Prenotazione prenotazione : prenotazioni) 
            {
                datiPrenotazione=(prenotazione.getIdPrenotazione()+";"+prenotazione.getNumSuccessivo()+";"+prenotazione.getNumeroOspiti()+";"+prenotazione.getPrezzo()+";"+prenotazione.getNomeCliente()+";"+prenotazione.getTrattamento()+";"+prenotazione.getLivello()+";"+prenotazione.getVista()+";"+prenotazione.getEsterno()+";"+prenotazione.isTv()+";"+prenotazione.isCassaforte()+";"+prenotazione.getAnnoIN()+";"+prenotazione.getMeseIN()+";"+prenotazione.getGiornoIN()+";"+prenotazione.getAnnoOUT()+";"+prenotazione.getMeseOUT()+";"+prenotazione.getGiornoOUT());
                f1.toFile(datiPrenotazione);
            }
        f1.close();
    }
    
    /**
     * Esporta gli utenti in un file CSV.
     *
     * @param fileName Nome del file CSV in cui esportare gli utenti.
     * @param utenti   Lista degli utenti da esportare.
     * @throws IOException     Se si verifica un errore di I/O durante la scrittura del file.
     * @throws FileException   Se si verifica un errore durante la chiusura del file.
     */
    public void esportaUtentiCSV(String fileName, List<Utente> utenti) throws IOException, FileException 
    {
        TextFile f1=new TextFile(fileName,'W');
        String datiUtente;
            for (Utente utente : utenti) 
            {
                datiUtente=(utente.getUsername()+";"+utente.getPassword()+";"+utente.getRuolo());
                f1.toFile(datiUtente);
            }
        f1.close();
    }
    
    /**
     * Salva lo stato della gestione in un file.
     *
     * @param fileName Nome del file in cui salvare lo stato della gestione.
     * @throws IOException     Se si verifica un errore di I/O durante la scrittura del file.
     * @throws FileNotFoundException Se il file specificato non viene trovato.
     */
    public void salvaGestione(String fileName) throws IOException, FileNotFoundException
    {
       ObjectOutputStream writer=new ObjectOutputStream(new FileOutputStream(fileName));
       writer.writeObject(this);
       writer.flush();
       writer.close();
    }

    /**
     * Carica lo stato della gestione da un file.
     *
     * @param fileName Nome del file da cui caricare lo stato della gestione.
     * @return Oggetto di tipo Gestione contenente lo stato caricato.
     * @throws FileNotFoundException Se il file specificato non viene trovato.
     * @throws IOException     Se si verifica un errore di I/O durante la lettura del file.
     * @throws ClassNotFoundException Se la classe caricata non viene trovata.
     */
    public static Gestione caricaGestione(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException 
    {
        Gestione gestione;
        ObjectInputStream reader=new ObjectInputStream(new FileInputStream(fileName));
        gestione=(Gestione)reader.readObject();
        reader.close();
        return gestione;
    }
}

