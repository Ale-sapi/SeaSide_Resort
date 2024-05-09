/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seaside_resort;

import java.time.LocalDate;
/**
 * Questa classe rappresenta una prenotazione presso il resort. Ogni prenotazione ha un identificatore univoco,
 * il numero di ospiti, il prezzo, il nome del cliente, il trattamento scelto, lo stato della prenotazione,
 * il livello della camera, la vista dalla camera, il tipo di esterno (Terrazzo o Giardino), la presenza di una TV,
 * la presenza di una cassaforte, la data di check-in e la data di check-out.
 * @author Alessandro
 */
public class Prenotazione 
{
    /**
     * Identificatore univoco della prenotazione.
     */
    private final int idPrenotazione;
    
    /**
     * Variabile statica per tenere traccia del numero successivo di prenotazione.
     */
    private static int numsuccessivo=1;
    
    /**
     * Numero di ospiti della prenotazione.
     */
    private int numeroOspiti;
    
    /**
     * Numero della camera associata alla prenotazione.
     */
    private int numeroCamera;
    
    /**
     * Prezzo della prenotazione.
     */
    private float prezzo=0;
    
    /**
     * Nome del cliente che ha effettuato la prenotazione.
     */
    private String nomeCliente;
    
    /**
     * Trattamento scelto per la prenotazione.
     */
    private String trattamento;
    
    /**
     * Stato attuale della prenotazione.
     */
    private String statoPrenotazione;
    
    /**
     * Livello della camera prenotata.
     */
    private String livello;
    
    /**
     * Vista dalla camera prenotata.
     */
    private String vista;
    
    /**
     * Tipo di esterno associato alla camera prenotata (Terrazzo o Giardino).
     */
    private String Esterno;
    
    /**
     * Indica se la camera prenotata include una TV.
     */
    private boolean tv;
    
    /**
     * Indica se la camera prenotata include una cassaforte.
     */
    private boolean cassaforte;
    
    /**
     * Anno di check-in della prenotazione.
     */
    private int annoIN;
    
    /**
     * Mese di check-in della prenotazione.
     */
    private int meseIN;
    
    /**
     * Giorno di check-in della prenotazione.
     */
    private int giornoIN;
    
    /**
     * Data di check-in della prenotazione.
     */
    LocalDate checkIN;
    
    /**
     * Anno di check-out della prenotazione.
     */
    private int annoOUT;
    
    /**
     * Mese di check-out della prenotazione.
     */
    private int meseOUT;
    
    /**
     * Giorno di check-out della prenotazione.
     */
    private int giornoOUT;
    
    /**
     * Data di check-out della prenotazione.
     */
    LocalDate checkOUT;

    /**
     * Costruttore della classe Prenotazione.
     * @param numeroOspiti Numero di ospiti della prenotazione.
     * @param nomeCliente Nome del cliente che ha effettuato la prenotazione.
     * @param trattamento Trattamento scelto per la prenotazione.
     * @param livello Livello della camera prenotata.
     * @param vista Vista dalla camera prenotata.
     * @param Esterno Tipo di esterno associato alla camera prenotata (Terrazzo o Giardino).
     * @param tv Indica se la camera prenotata include una TV.
     * @param cassaforte Indica se la camera prenotata include una cassaforte.
     * @param annoIN Anno di check-in della prenotazione.
     * @param meseIN Mese di check-in della prenotazione.
     * @param giornoIN Giorno di check-in della prenotazione.
     * @param annoOUT Anno di check-out della prenotazione.
     * @param meseOUT Mese di check-out della prenotazione.
     * @param giornoOUT Giorno di check-out della prenotazione.
     */
    public Prenotazione(int numeroOspiti, String nomeCliente, String trattamento, String livello, String vista, String Esterno, boolean tv, boolean cassaforte, int annoIN, int meseIN, int giornoIN, int annoOUT, int meseOUT, int giornoOUT)
    {
        this.idPrenotazione = numsuccessivo;
        numsuccessivo++;
        this.numeroOspiti = numeroOspiti;
        this.prezzo = prezzo;
        this.nomeCliente = nomeCliente;
        this.trattamento = trattamento;
        this.statoPrenotazione = "In Approvazione";
        this.livello = livello;
        this.vista = vista;
        this.Esterno = Esterno;
        this.tv = tv;
        this.cassaforte = cassaforte;
        this.annoIN = annoIN;
        this.meseIN = meseIN;
        this.giornoIN = giornoIN;
        checkIN=LocalDate.of(annoIN, meseIN, giornoIN);
        this.annoOUT = annoOUT;
        this.meseOUT = meseOUT;
        this.giornoOUT = giornoOUT;
        this.numeroCamera=0;
        checkOUT=LocalDate.of(annoOUT, meseOUT, giornoOUT);
    }

    /**
     * Restituisce l'identificatore univoco della prenotazione.
     * @return Identificatore univoco della prenotazione.
     */
    public int getIdPrenotazione() {
        return idPrenotazione;
    }

    /**
     * Restituisce il numero della camera associata alla prenotazione.
     * @return Numero della camera associata alla prenotazione.
     */
    public int getNumeroCamera() {
        return numeroOspiti;
    }

    /**
     * Imposta il numero della camera associata alla prenotazione.
     * @param numeroCamera Numero della camera associata alla prenotazione.
     */
    public void setNumeroCamera(int numeroCamera) {
        this.numeroCamera = numeroCamera;
    }
    
    /**
     * Restituisce il numero di ospiti della prenotazione.
     * @return Numero di ospiti della prenotazione.
     */
    public int getNumeroOspiti() {
        return numeroOspiti;
    }

    /**
     * Imposta il numero di ospiti della prenotazione.
     * @param numeroOspiti Numero di ospiti della prenotazione.
     */
    public void setNumeroOspiti(int numeroOspiti) {
        this.numeroOspiti = numeroOspiti;
    }

    /**
     * Restituisce il prezzo della prenotazione.
     * @return Prezzo della prenotazione.
     */
    public float getPrezzo() {
        return prezzo;
    }

    /**
     * Imposta il prezzo della prenotazione.
     * @param prezzo Prezzo della prenotazione.
     */
    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    /**
     * Restituisce il nome del cliente che ha effettuato la prenotazione.
     * @return Nome del cliente che ha effettuato la prenotazione.
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * Imposta il nome del cliente che ha effettuato la prenotazione.
     * @param nomeCliente Nome del cliente che ha effettuato la prenotazione.
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * Restituisce il trattamento scelto per la prenotazione.
     * @return Trattamento scelto per la prenotazione.
     */
    public String getTrattamento() {
        return trattamento;
    }

    /**
     * Imposta il trattamento scelto per la prenotazione.
     * @param trattamento Trattamento scelto per la prenotazione.
     */
    public void setTrattamento(String trattamento) {
        this.trattamento = trattamento;
    }

    /**
     * Restituisce lo stato attuale della prenotazione.
     * @return Stato attuale della prenotazione.
     */
    public String getStatoPrenotazione() {
        return statoPrenotazione;
    }

    /**
     * Imposta lo stato attuale della prenotazione.
     * @param statoPrenotazione Stato attuale della prenotazione.
     */
    public void setStatoPrenotazione(String statoPrenotazione) {
        this.statoPrenotazione = statoPrenotazione;
    }

    /**
     * Restituisce il livello della camera prenotata.
     * @return Livello della camera prenotata.
     */
    public String getLivello() {
        return livello;
    }

    /**
     * Imposta il livello della camera prenotata.
     * @param livello Livello della camera prenotata.
     */
    public void setLivello(String livello) {
        this.livello = livello;
    }

    /**
     * Restituisce la vista dalla camera prenotata.
     * @return Vista dalla camera prenotata.
     */
    public String getVista() {
        return vista;
    }

    /**
     * Imposta la vista dalla camera prenotata.
     * @param vista Vista dalla camera prenotata.
     */
    public void setVista(String vista) {
        this.vista = vista;
    }

    /**
     * Restituisce il tipo di esterno associato alla camera prenotata (Terrazzo o Giardino).
     * @return Tipo di esterno associato alla camera prenotata.
     */
    public String getEsterno() {
        return Esterno;
    }

    /**
     * Imposta il tipo di esterno associato alla camera prenotata (Terrazzo o Giardino).
     * @param Esterno Tipo di esterno associato alla camera prenotata.
     */
    public void setEsterno(String Esterno) {
        this.Esterno = Esterno;
    }

    /**
     * Verifica se la camera prenotata include una TV.
     * @return true se la camera prenotata include una TV, altrimenti false.
     */
    public boolean isTv() {
        return tv;
    }

    /**
     * Imposta la presenza o meno di una TV nella camera prenotata.
     * @param tv true se la camera prenotata include una TV, altrimenti false.
     */
    public void setTv(boolean tv) {
        this.tv = tv;
    }

    /**
     * Verifica se la camera prenotata include una cassaforte.
     * @return true se la camera prenotata include una cassaforte, altrimenti false.
     */
    public boolean isCassaforte() {
        return cassaforte;
    }

    /**
     * Imposta la presenza o meno di una cassaforte nella camera prenotata.
     * @param cassaforte true se la camera prenotata include una cassaforte, altrimenti false.
     */
    public void setCassaforte(boolean cassaforte) {
        this.cassaforte = cassaforte;
    }

    /**
     * Restituisce l'anno di check-in della prenotazione.
     * @return Anno di check-in della prenotazione.
     */
    public int getAnnoIN() {
        return annoIN;
    }

    /**
     * Imposta l'anno di check-in della prenotazione.
     * @param annoIN Anno di check-in della prenotazione.
     */
    public void setAnnoIN(int annoIN) {
        this.annoIN = annoIN;
    }

    /**
     * Restituisce il mese di check-in della prenotazione.
     * @return Mese di check-in della prenotazione.
     */
    public int getMeseIN() {
        return meseIN;
    }

    /**
     * Imposta il mese di check-in della prenotazione.
     * @param meseIN Mese di check-in della prenotazione.
     */
    public void setMeseIN(int meseIN) {
        this.meseIN = meseIN;
    }

    /**
     * Restituisce il giorno di check-in della prenotazione.
     * @return Giorno di check-in della prenotazione.
     */
    public int getGiornoIN() {
        return giornoIN;
    }

    /**
     * Imposta il giorno di check-in della prenotazione.
     * @param giornoIN Giorno di check-in della prenotazione.
     */
    public void setGiornoIN(int giornoIN) {
        this.giornoIN = giornoIN;
    }

    /**
     * Restituisce la data di check-in della prenotazione.
     * @return Data di check-in della prenotazione.
     */
    public LocalDate getCheckIN() {
        return checkIN;
    }

    /**
     * Imposta la data di check-in della prenotazione.
     * @param checkIN Data di check-in della prenotazione.
     */
    public void setCheckIN(LocalDate checkIN) {
        this.checkIN = checkIN;
    }

    /**
     * Restituisce l'anno di check-out della prenotazione.
     * @return Anno di check-out della prenotazione.
     */
    public int getAnnoOUT() {
        return annoOUT;
    }

    /**
     * Imposta l'anno di check-out della prenotazione.
     * @param annoOUT Anno di check-out della prenotazione.
     */
    public void setAnnoOUT(int annoOUT) {
        this.annoOUT = annoOUT;
    }

    /**
     * Restituisce il mese di check-out della prenotazione.
     * @return Mese di check-out della prenotazione.
     */
    public int getMeseOUT() {
        return meseOUT;
    }

    /**
     * Imposta il mese di check-out della prenotazione.
     * @param meseOUT Mese di check-out della prenotazione.
     */
    public void setMeseOUT(int meseOUT) {
        this.meseOUT = meseOUT;
    }

    /**
     * Restituisce il giorno di check-out della prenotazione.
     * @return Giorno di check-out della prenotazione.
     */
    public int getGiornoOUT() {
        return giornoOUT;
    }

    /**
     * Imposta il giorno di check-out della prenotazione.
     * @param giornoOUT Giorno di check-out della prenotazione.
     */
    public void setGiornoOUT(int giornoOUT) {
        this.giornoOUT = giornoOUT;
    }

    /**
     * Restituisce la data di check-out della prenotazione.
     * @return Data di check-out della prenotazione.
     */
    public LocalDate getCheckOUT() {
        return checkOUT;
    }

    /**
     * Imposta la data di check-out della prenotazione.
     * @param checkOUT Data di check-out della prenotazione.
     */
    public void setCheckOUT(LocalDate checkOUT) {
        this.checkOUT = checkOUT;
    }

    /**
     * Restituisce una rappresentazione in formato stringa dell'oggetto Prenotazione.
     * @return Una stringa che rappresenta l'oggetto Prenotazione.
     */
    @Override
    public String toString() {
        return "Prenotazione{" + "idPrenotazione=" + idPrenotazione + ", numeroOspiti=" + numeroOspiti + ", numeroCamera=" + numeroCamera + ", prezzo=" + prezzo + ", nomeCliente=" + nomeCliente + ", trattamento=" + trattamento + ", statoPrenotazione=" + statoPrenotazione + ", livello=" + livello + ", vista=" + vista + ", Esterno=" + Esterno + ", tv=" + tv + ", cassaforte=" + cassaforte + ", checkIN=" + checkIN + ", checkOUT=" + checkOUT + '}'+"\n";
    }
}

