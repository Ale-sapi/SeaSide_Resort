/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seaside_resort;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Classe che rappresenta una camera all'interno di un resort.
 * Contiene informazioni sulla camera e le relative prenotazioni.
 * 
 * @author Alessandro
 */
public class Camera 
{
    /**
     * Lista delle prenotazioni relative a questa camera.
     */
    ArrayList<Prenotazione>prenotazioni=new ArrayList<>();;
    private final int numeroCamera;
    private static int numsuccessivo=1;
    int numeroLetti;
    private String livello;
    private String vista;
    private String Esterno;//Terrazzo o Giardino
    private boolean disponibile;
    private boolean tv;
    private boolean cassaforte;

    /**
     * Costruttore della classe Camera.
     * 
     * @param numeroLetti Numero di letti nella camera.
     * @param livello Livello della camera.
     * @param vista Vista dalla camera.
     * @param Esterno Tipo di esterno associato alla camera (Terrazzo o Giardino).
     * @param disponibile Disponibilità della camera.
     * @param tv Presenza di una TV nella camera.
     * @param cassaforte Presenza di una cassaforte nella camera.
     */
    public Camera(int numeroLetti, String livello, String vista, String Esterno, boolean disponibile, boolean tv, boolean cassaforte) 
    {
        if (numsuccessivo==17||numsuccessivo==13||numsuccessivo==113||numsuccessivo==117)
            numsuccessivo++;
        this.numeroCamera = numsuccessivo;
        numsuccessivo++;
        this.numeroLetti = numeroLetti;
        this.livello = livello;
        this.vista = vista;
        this.Esterno = Esterno;
        this.disponibile = disponibile;
        this.tv = tv;
        this.cassaforte = cassaforte;
    }
    /**
     * Costruttore della classe Camera per Copiare.
     * 
     * @param numeroCamera Numero camera.
     * @param numeroSuccessivo Numero camera successivo.
     * @param numeroLetti Numero di letti nella camera.
     * @param livello Livello della camera.
     * @param vista Vista dalla camera.
     * @param Esterno Tipo di esterno associato alla camera (Terrazzo o Giardino).
     * @param disponibile Disponibilità della camera.
     * @param tv Presenza di una TV nella camera.
     * @param cassaforte Presenza di una cassaforte nella camera.
     */
    public Camera(int numeroCamera,int numeroSuccessivo, int numeroLetti, String livello, String vista, String Esterno, boolean disponibile, boolean tv, boolean cassaforte) 
    {
        this.numeroCamera = numeroCamera;
        numsuccessivo=numeroSuccessivo;
        this.numeroLetti = numeroLetti;
        this.livello = livello;
        this.vista = vista;
        this.Esterno = Esterno;
        this.disponibile = disponibile;
        this.tv = tv;
        this.cassaforte = cassaforte;
        
    }
    /**
     * Costruttore di copia della classe Camera.
     * 
     * @param camera Camera da copiare.
     */
    public Camera(Camera camera) 
    {
        this.numeroCamera = camera.getNumeroCamera();
        this.numeroLetti = camera.getNumeroLetti();
        this.livello = camera.getLivello();
        this.vista = camera.getVista();
        this.Esterno = camera.getEsterno();
        this.tv = camera.isTv();
        this.cassaforte = camera.isCassaforte();
        this.prenotazioni=camera.getprenotazioni();
        this.disponibile=camera.getDisponibilita();
    }
    
    /**
     * Metodo per modificare i dettagli della camera.
     * 
     * @param numeroLetti Nuovo numero di letti nella camera.
     * @param livello Nuovo livello della camera.
     * @param tv Nuova presenza di una TV nella camera.
     * @param cassaforte Nuova presenza di una cassaforte nella camera.
     * @param disponibile Nuova disponibilità della camera.
     */
    public void modificaCamera(int numeroLetti, String livello, boolean tv, boolean cassaforte, boolean disponibile) 
    {
        setNumeroLetti(numeroLetti);
        setLivello(livello);
        setTv(tv);
        setCassaforte(cassaforte);
        setDisponibilita(disponibile);
    }

    /**
     * Restituisce il numero della camera.
     * 
     * @return Numero della camera.
     */
    public int getNumSuccessivo() 
    {
        return numsuccessivo;
    }
    
    
    /**
     * Restituisce il numero della camera.
     * 
     * @return Numero della camera.
     */
    public int getNumeroCamera() 
    {
        return numeroCamera;
    }

    /**
     * Restituisce il numero di letti nella camera.
     * 
     * @return Numero di letti nella camera.
     */
    public int getNumeroLetti() 
    {
        return numeroLetti;
    }

    /**
     * Restituisce la disponibilità della camera.
     * 
     * @return true se la camera è disponibile, altrimenti false.
     */
    public boolean getDisponibilita() 
    {
        return disponibile;
    }
    
    /**
     * Imposta il numero di letti nella camera.
     * 
     * @param numeroLetti Nuovo numero di letti nella camera.
     */
    public void setNumeroLetti(int numeroLetti) 
    {
        this.numeroLetti = numeroLetti;
    }

    /**
     * Restituisce il livello della camera.
     * 
     * @return Livello della camera.
     */
    public String getLivello() {
        return livello;
    }

    /**
     * Imposta il livello della camera.
     * 
     * @param livello Nuovo livello della camera.
     */
    public void setLivello(String livello) 
    {
        this.livello = livello;
    }

    /**
     * Restituisce la vista dalla camera.
     * 
     * @return Vista dalla camera.
     */
    public String getVista() 
    {
        return vista;
    }

    /**
     * Imposta la vista dalla camera.
     * 
     * @param vista Nuova vista dalla camera.
     */
    public void setVista(String vista) 
    {
        this.vista = vista;
    }

    /**
     * Restituisce il tipo di esterno associato alla camera.
     * 
     * @return Tipo di esterno associato alla camera.
     */
    public String getEsterno() {
        return Esterno;
    }

    /**
     * Imposta il tipo di esterno associato alla camera.
     * 
     * @param Esterno Nuovo tipo di esterno associato alla camera.
     */
    public void setEsterno(String Esterno) 
    {
        this.Esterno = Esterno;
    }

    /**
     * Verifica la disponibilità della camera per le date specificate.
     * 
     * @param dataInizio Data di inizio del periodo di prenotazione.
     * @param dataFine Data di fine del periodo di prenotazione.
     * @return true se la camera è disponibile per il periodo specificato, altrimenti false.
     */
    public boolean isDisponibile(LocalDate dataInizio, LocalDate dataFine) 
    {
        // Controlla se ci sono prenotazioni che si sovrappongono all'intervallo specificato
        for (Prenotazione prenotazione : prenotazioni) 
        {
            if ((disponibile==false) || (prenotazione.getCheckIN()==dataInizio) || (prenotazione.getCheckOUT()==dataFine) || (prenotazione.getCheckIN().isBefore(dataInizio) && prenotazione.getCheckOUT().isAfter(dataInizio))|| (prenotazione.getCheckIN().isAfter(dataInizio) && prenotazione.getCheckOUT().isBefore(dataFine)) || (prenotazione.getCheckIN().isBefore(dataInizio) && prenotazione.getCheckIN().isAfter(dataFine))|| (prenotazione.getCheckIN().isAfter(dataInizio) && prenotazione.getCheckIN().isBefore(dataFine)))
            {
                // La camera non è disponibile per le date specificate
                return false;
            }
        }
        // La camera è disponibile per le date specificate
        return true;
    }

    /**
     * Aggiunge una prenotazione alla lista delle prenotazioni di questa camera.
     * 
     * @param prenotazione Prenotazione da aggiungere.
     */
    public void aggiungiPrenotazione(Prenotazione prenotazione) 
    {
        prenotazioni.add(prenotazione);
    }
    
    /**
     * Restituisce la lista delle prenotazioni relative a questa camera.
     * 
     * @return Lista delle prenotazioni relative a questa camera.
     */
    public ArrayList<Prenotazione> getprenotazioni() 
    {
        return prenotazioni;
    }

    /**
     * Verifica la presenza di una TV nella camera.
     * 
     * @return true se la camera ha una TV, altrimenti false.
     */
    public boolean isTv() 
    {
        return tv;
    }

    /**
     * Imposta la presenza di una TV nella camera.
     * 
     * @param tv true se la camera ha una TV, altrimenti false.
     */
    public void setTv(boolean tv) 
    {
        this.tv = tv;
    }

    /**
     * Imposta la disponibilità della camera.
     * 
     * @param disponibile true se la camera è disponibile, altrimenti false.
     */
    public void setDisponibilita(boolean disponibile) 
    {
        this.disponibile = disponibile;
    }
    
    /**
     * Verifica la presenza di una cassaforte nella camera.
     * 
     * @return true se la camera ha una cassaforte, altrimenti false.
     */
    public boolean isCassaforte() 
    {
        return cassaforte;
    }

    /**
     * Imposta la presenza di una cassaforte nella camera.
     * 
     * @param cassaforte true se la camera ha una cassaforte, altrimenti false.
     */
    public void setCassaforte(boolean cassaforte) 
    {
        this.cassaforte = cassaforte;
    }

    /**
     * Restituisce una rappresentazione in formato stringa dell'oggetto Camera.
     * 
     * @return Una stringa che rappresenta l'oggetto Camera.
     */
    @Override
    public String toString() 
    {
        return "Camera{" + "numeroCamera=" + numeroCamera + ", numeroLetti=" + numeroLetti + ", livello=" + livello + ", vista=" + vista + ", Esterno=" + Esterno + ", disponibile=" + disponibile + ", tv=" + tv + ", cassaforte=" + cassaforte + '}'+"\n";
    }
    
    /***
     * Ridefinito il metodo equals per confrontare due camere
     * @param object Oggetto da confrontare, nel nostro caso una camera
     * @return true (Se i due oggetti sono uguali) or false (Se i due oggetti sono diversi)
     */
    @Override 
    public boolean equals(Object object)
    {
        Camera camera;
        camera=(Camera)object;
        if (camera.getDisponibilita()==getDisponibilita()&&camera.getEsterno().equalsIgnoreCase(getEsterno())&&camera.getNumeroLetti()==getNumeroLetti()&&camera.getLivello().equalsIgnoreCase(getLivello())&&camera.getVista().equalsIgnoreCase(getVista())&&camera.isTv()==isTv()&&camera.isCassaforte()==isCassaforte())
            return true;
        else
            return false;
    }  
}

