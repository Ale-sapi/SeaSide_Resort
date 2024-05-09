/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seaside_resort;

import Input.ConsoleInput;
import eccezioni.*;
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
    public Gestione() 
    {
    }
    
    ArrayList<Camera>camere=new ArrayList<>();
    ArrayList<Prenotazione>prenotazioni=new ArrayList<>();
    
    /**
     * Aggiunge una nuova camera al resort.
     * @param camera La camera da aggiungere.
     * @throws EccezioneNumeroMaxCamereRaggiunto Viene lanciata se il numero massimo di camere è stato raggiunto.
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
     * @throws EccezioneCameraNonTrovata Viene lanciata se la camera specificata non è stata trovata.
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
     * @throws EccezioneCameraNonTrovata Viene lanciata se la camera specificata non è stata trovata.
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
     * @throws EccezioneCameraNonTrovata Viene lanciata se non viene trovata una camera disponibile per la prenotazione.
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
     * @throws EccezioneNumeroMaxPrenotazioniRaggiunto Viene lanciata se il numero massimo di prenotazioni è stato raggiunto.
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
     * @throws EccezionePrenotazioneNonTrovata Viene lanciata se la prenotazione specificata non è stata trovata.
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
     * @throws EccezionePrenotazioneNonTrovata Viene lanciata se la prenotazione specificata non è stata trovata.
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
     * @throws IOException Viene lanciata se si verifica un errore di input/output.
     * @throws EccezionePrenotazioneNonTrovata Viene lanciata se la prenotazione specificata non è stata trovata.
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
     * @throws EccezioneCameraNonTrovata Viene lanciata se non viene trovata una camera per la prenotazione approvata.
     * @throws EccezionePrenotazioneNonTrovata Viene lanciata se la prenotazione specificata non è stata trovata.
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

    public static int getNumCamere() {
        return numCamere;
    }

    public static int getNumPrenotazioni() {
        return numPrenotazioni;
    }
    
    // Metodo per ordinare le prenotazioni per data di check-in
    public List<Prenotazione> ordinaPrenotazioniPerCheckIn() 
    {
        List<Prenotazione> copiaPrenotazioni = new ArrayList<>(prenotazioni);
        Collections.sort(copiaPrenotazioni, Comparator.comparing(prenotazione -> prenotazione.getCheckIN()));
        return copiaPrenotazioni;
    }
    
    // Metodo per ordinare le prenotazioni per nome del cliente
    public List<Prenotazione> ordinaPrenotazioniPerNomeCliente() 
    {
        List<Prenotazione> copiaPrenotazioni = new ArrayList<>(prenotazioni);
        Collections.sort(copiaPrenotazioni, Comparator.comparing(prenotazione -> prenotazione.getNomeCliente()));
        return copiaPrenotazioni;
    }
    
    // Metodo per ordinare le camere per livello
    public List<Camera> ordinaCamerePerLivello() 
    {
        List<Camera> copiaCamere = new ArrayList<>(camere);
        Collections.sort(copiaCamere, Comparator.comparing(camera -> camera.getLivello()));
        return copiaCamere;
    }

    // Metodo per ordinare le camere per numero di letti
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
     * @throws EccezioneCameraNonTrovata Viene lanciata se la camera specificata non è stata trovata.
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
     * @throws EccezionePrenotazioneNonTrovata Viene lanciata se la prenotazione specificata non è stata trovata.
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
     * @throws EccezionePrenotazioneNonTrovata Viene lanciata se non viene trovata una prenotazione da approvare.
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
    
        public void importaCSV(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String rigaLetta;
        try {
            while ((rigaLetta = reader.readLine()) != null) {
                String[] datiCamera = rigaLetta.split(";");
                int numeroCamera = Integer.parseInt(datiCamera[0]);
                int numSuccessivo =Integer.parseInt(datiCamera[1]);
                int numeroLetti = Integer.parseInt(datiCamera[2]);
                String livello = datiCamera[3];
                String vista = datiCamera [4];
                String esterno = datiCamera [5];
                boolean disponibile = Boolean.parseBoolean(datiCamera[6]);
                boolean tv = Boolean.parseBoolean(datiCamera[7]);
                boolean cassaforte = Boolean.parseBoolean(datiCamera[8]);
                Camera camera = new Camera(numeroCamera, numSuccessivo, numeroLetti, livello, vista, esterno, disponibile, tv, cassaforte);
                try 
                {
                    aggiungiCamera(camera);
                } 
                catch (EccezioneNumeroMaxCamereRaggiunto ex) 
                {
                    System.out.println("Numero massimo camera raggiunto");
                }
            }
        } 
        finally 
        {
            reader.close();
        }
    }

    public void esportaCSV(String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        try {
            for (Camera camera : camere) {
                //writer.write(camera.toCSV());
                writer.newLine();
            }
        } finally {
            writer.close();
        }
    }

    public void salvaGestione(String fileName) throws IOException, FileNotFoundException
    {
       ObjectOutputStream writer=new ObjectOutputStream(new FileOutputStream(fileName));
       writer.writeObject(this);
       writer.flush();
       writer.close();
    }

    public static Gestione caricaGestione(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
        try {
            Gestione gestione = (Gestione) inputStream.readObject();
            return gestione;
        } finally {
            inputStream.close();
        }
    }
}

