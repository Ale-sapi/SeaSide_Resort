/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seaside_resort;

import java.time.LocalDate;

/**
 *
 * @author Alessandro
 */
public class Prenotazione 
{
    private final int idPrenotazione;
    private static int numsuccessivo=1;
    private int numeroOspiti;
    private int numeroCamera;
    private float prezzo=0;
    private String nomeCliente;
    private String trattamento;
    private String statoPrenotazione;
    private String livello;
    private String vista;
    private String Esterno;//Terrazzo o Giardino
    private boolean tv;
    private boolean cassaforte;
    private int annoIN;
    private int meseIN;
    private int giornoIN;
    LocalDate checkIN=LocalDate.of(annoIN, meseIN, giornoIN);
    private int annoOUT;
    private int meseOUT;
    private int giornoOUT;
    LocalDate checkOUT=LocalDate.of(annoOUT, meseOUT, giornoOUT);

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

    public int getIdPrenotazione() {
        return idPrenotazione;
    }

    public int getNumeroCamera() {
        return numeroOspiti;
    }

    public void setNumeroCamera(int numeroCamera) {
        this.numeroCamera = numeroCamera;
    }
    
    public int getNumeroOspiti() {
        return numeroOspiti;
    }

    public void setNumeroOspiti(int numeroOspiti) {
        this.numeroOspiti = numeroOspiti;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTrattamento() {
        return trattamento;
    }

    public void setTrattamento(String trattamento) {
        this.trattamento = trattamento;
    }

    public String getStatoPrenotazione() {
        return statoPrenotazione;
    }

    public void setStatoPrenotazione(String statoPrenotazione) {
        this.statoPrenotazione = statoPrenotazione;
    }

    public String getLivello() {
        return livello;
    }

    public void setLivello(String livello) {
        this.livello = livello;
    }

    public String getVista() {
        return vista;
    }

    public void setVista(String vista) {
        this.vista = vista;
    }

    public String getEsterno() {
        return Esterno;
    }

    public void setEsterno(String Esterno) {
        this.Esterno = Esterno;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isCassaforte() {
        return cassaforte;
    }

    public void setCassaforte(boolean cassaforte) {
        this.cassaforte = cassaforte;
    }

    public int getAnnoIN() {
        return annoIN;
    }

    public void setAnnoIN(int annoIN) {
        this.annoIN = annoIN;
    }

    public int getMeseIN() {
        return meseIN;
    }

    public void setMeseIN(int meseIN) {
        this.meseIN = meseIN;
    }

    public int getGiornoIN() {
        return giornoIN;
    }

    public void setGiornoIN(int giornoIN) {
        this.giornoIN = giornoIN;
    }

    public LocalDate getCheckIN() {
        return checkIN;
    }

    public void setCheckIN(LocalDate checkIN) {
        this.checkIN = checkIN;
    }

    public int getAnnoOUT() {
        return annoOUT;
    }

    public void setAnnoOUT(int annoOUT) {
        this.annoOUT = annoOUT;
    }

    public int getMeseOUT() {
        return meseOUT;
    }

    public void setMeseOUT(int meseOUT) {
        this.meseOUT = meseOUT;
    }

    public int getGiornoOUT() {
        return giornoOUT;
    }

    public void setGiornoOUT(int giornoOUT) {
        this.giornoOUT = giornoOUT;
    }

    public LocalDate getCheckOUT() {
        return checkOUT;
    }

    public void setCheckOUT(LocalDate checkOUT) {
        this.checkOUT = checkOUT;
    }

    
    
}
