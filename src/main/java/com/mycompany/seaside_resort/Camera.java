/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seaside_resort;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Alessandro
 */
public class Camera 
{
    ArrayList<Prenotazione>prenotazioni=new ArrayList<>();;
    private final int numeroCamera;
    private static int numsuccessivo=1;
    private int numeroLetti;
    private float prezzo;
    private String livello;
    private String vista;
    private String Esterno;//Terrazzo o Giardino
    private boolean disponibile;
    private boolean tv;
    private boolean cassaforte;

    public Camera(int numeroLetti, float prezzo, String livello, String vista, String Esterno, boolean disponibile, boolean tv, boolean cassaforte) 
    {
        if (numsuccessivo==17||numsuccessivo==13||numsuccessivo==113||numsuccessivo==117)
            numsuccessivo++;
        this.numeroCamera = numsuccessivo;
        numsuccessivo++;
        this.numeroLetti = numeroLetti;
        this.prezzo = prezzo;
        this.livello = livello;
        this.vista = vista;
        this.Esterno = Esterno;
        this.tv = tv;
        this.cassaforte = cassaforte;
    }

    public Camera(Camera camera) 
    {
        this.numeroCamera = camera.getNumeroCamera();
        this.numeroLetti = camera.getNumeroLetti();
        this.prezzo = camera.getPrezzo();
        this.livello = camera.getLivello();
        this.vista = camera.getVista();
        this.Esterno = camera.getEsterno();
        this.tv = camera.isTv();
        this.cassaforte = camera.isCassaforte();
        this.prenotazioni=camera.getprenotazioni();
        this.disponibile=camera.getDisponibilita();
    }
    
    public void modificaCamera(int numeroLetti, float prezzo, String livello, boolean tv, boolean cassaforte, boolean disponibile) 
    {
        setNumeroLetti(numeroLetti);
        setLivello(livello);
        setTv(tv);
        setCassaforte(cassaforte);
        setDisponibilita(disponibile);
    }

    public int getNumeroCamera() 
    {
        return numeroCamera;
    }

    public int getNumeroLetti() 
    {
        return numeroLetti;
    }

    public boolean getDisponibilita() 
    {
        return disponibile;
    }
    
    public void setNumeroLetti(int numeroLetti) 
    {
        this.numeroLetti = numeroLetti;
    }

    public float getPrezzo() 
    {
        return prezzo;
    }

    public void setPrezzo(float prezzo) 
    {
        this.prezzo = prezzo;
    }

    public String getLivello() {
        return livello;
    }

    public void setLivello(String livello) 
    {
        this.livello = livello;
    }

    public String getVista() 
    {
        return vista;
    }

    public void setVista(String vista) 
    {
        this.vista = vista;
    }

    public String getEsterno() {
        return Esterno;
    }

    public void setEsterno(String Esterno) 
    {
        this.Esterno = Esterno;
    }

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

    public void aggiungiPrenotazione(Prenotazione prenotazione) 
    {
        prenotazioni.add(prenotazione);
    }
    
    public ArrayList<Prenotazione> getprenotazioni() 
    {
        return prenotazioni;
    }

    public boolean isTv() 
    {
        return tv;
    }

    public void setTv(boolean tv) 
    {
        this.tv = tv;
    }

    public void setDisponibilita(boolean disponibile) 
    {
        this.disponibile = disponibile;
    }
    
    public boolean isCassaforte() 
    {
        return cassaforte;
    }

    public void setCassaforte(boolean cassaforte) 
    {
        this.cassaforte = cassaforte;
    }

    @Override
    public String toString() 
    {
        return "Camera{" + "numeroCamera=" + numeroCamera + ", numeroLetti=" + numeroLetti + ", prezzo=" + prezzo + ", livello=" + livello + ", vista=" + vista + ", Esterno=" + Esterno + ", disponibile=" + disponibile + ", tv=" + tv + ", cassaforte=" + cassaforte + '}';
    }
    
    
    
}
