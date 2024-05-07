/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seaside_resort;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Alessandro
 */
public class Gestione 
{
    private static final int MAX_CAMERE = 200;
    private static final int MAX_PRENOTAZIONI = 200;
    private static int numCamere=0;
    private static int numPrenotazioni=0;
    
    public Gestione() 
    {
    }
    
    ArrayList<Camera>camere=new ArrayList<>();
    ArrayList<Prenotazione>prenotazioni=new ArrayList<>();
    public void aggiungiCamera(Camera camera)
    {
        if (numCamere<=MAX_CAMERE)
        {
            camere.add(camera);
            numCamere++;
            System.out.println("Camera numero"+camera.getNumeroCamera()+"Aggiunta");
        }
        else
            System.out.println("Non Funzia");
//Todo: Eccezione num max camere
    }
    public void rimuoviCamera (int numCamera)
    {
        camere.remove(cercaCamera(numCamera));
        numCamere--;
        System.out.println("rimossa");
    }
//Todo: Eccezione camera non trovata o camera null
    public Camera cercaCamera(int numero)
    {
        for (Camera camera : camere) {
        if (camera.getNumeroCamera()==numero) 
            {
                return camera;
            }
        }
        return null;
    }
//Todo: Eccezione camera non trovata o camera null
    public Camera cercaPrimaCameraDisponibile(Prenotazione prenotazione)
    {
        for (Camera camera : camere) 
        {
            if (camera.getNumeroLetti()==prenotazione.getNumeroOspiti()&&camera.getLivello()==prenotazione.getLivello()&&camera.getVista()==prenotazione.getVista()&&camera.getEsterno()==prenotazione.getEsterno()&&camera.isTv()==prenotazione.isTv()&&camera.isCassaforte()==prenotazione.isCassaforte()) 
                {
                    if(camera.isDisponibile(prenotazione.getCheckIN(), prenotazione.getCheckOUT()))
                        return camera;
                }
        }
        return null;
    }
//Todo: Eccezione camera non trovata o camera null
    public void Prenota(Prenotazione prenotazione)
    {
        if (numPrenotazioni<=MAX_PRENOTAZIONI)
        {
            prenotazioni.add(prenotazione);
            numPrenotazioni++;
            System.out.println("Prenotazione numero"+prenotazione.getIdPrenotazione()+"Aggiunta");
        }
        else
            System.out.println("Non Funzia");
    }
//Todo: Eccezione num max prenotazioni
        public void rimuoviPrenotazione (int idPrenotazione)
    {
        prenotazioni.remove(cercaPrenotazione(idPrenotazione));
        numPrenotazioni--;
        System.out.println("rimossa");
    }
//Todo: Eccezione prenotazione non trovata o prenotazione null
    public Prenotazione cercaPrenotazione(int Id)
    {
        for (Prenotazione prenotazione : prenotazioni) 
        {
            if (prenotazione.getIdPrenotazione()==Id) 
                {
                    return prenotazione;
                }
        }
        return null;
    }
//Todo: Eccezione prenotazione non trovata o prenotazione null
    public Prenotazione cercaPrenotazioneNomeCliente(String nome)
    {
        for (Prenotazione prenotazione : prenotazioni) 
        {
            if (prenotazione.getNomeCliente()==nome) 
                {
                    return prenotazione;
                }
        }
        return null;
    }
//Todo: Eccezione prenotazione non trovata o prenotazione null
    public void approvaRifiutaPrenotazione(int id, String nuovoStato, boolean approvato)
    {
        Prenotazione p1=cercaPrenotazione(id);
        if (approvato==true)
        {
            Camera cameraDisponibile = cercaPrimaCameraDisponibile(p1);
            if (cameraDisponibile!=null)
            {
                p1.setNumeroCamera(cameraDisponibile.getNumeroCamera());
                p1.setStatoPrenotazione("Approvata");
                cameraDisponibile.aggiungiPrenotazione(p1);
            }
            else 
                System.out.println("Errore: Nessuna camera disponibile");
                p1.setStatoPrenotazione("Rifiutata: Camera non trovata");
        }
        else
        {
            p1.setStatoPrenotazione(nuovoStato);
        }
        System.out.println("Stato aggiornato");
    }
//Todo: Eccezione prenotazione non trovata o prenotazione null

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

    public  void restrutturaCamera(int numeroCamera, int numeroLetti, String livello, boolean tv, boolean cassaforte, boolean disponibile)
    {
        Camera camera = cercaCamera(numeroCamera);
        if (camera != null) 
        {
            camera.modificaCamera(numeroLetti, livello, tv, cassaforte, disponibile);
            System.out.println("Camera modificata con successo.");
        } 
        else 
        {
            System.out.println("Camera non trovata.");
        }
    }
    
    public void modificaPrenotazione(int idPrenotazione, int numeroOspiti, float prezzo, String trattamento, String livello, String vista, String esterno, boolean tv, boolean cassaforte, int annoIN, int meseIN, int giornoIN, int annoOUT, int meseOUT, int giornoOUT) 
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
            System.out.println("Prenotazione non trovata.");
        }
    }
    
    public Prenotazione cercaPrimaPrenotazioneDaApprovare()
    {
        for (Prenotazione prenotazione : prenotazioni) 
        {
            if (prenotazione.getStatoPrenotazione()=="In Approvazione") 
                {
                    return prenotazione;
                }
        }
        return null;
    }
}
