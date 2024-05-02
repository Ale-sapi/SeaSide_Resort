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
    private int idPrenotazione;
    private int numeroOspiti;
    private float prezzo;
    private String nomeCliente;
    private String trattamento;
    private String statoPrenotazione;
    private String livello;
    private String vista;
    private String Esterno;//Terrazzo o Giardino
    private boolean disponibile;
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

    public Prenotazione(int idPrenotazione, int numeroOspiti, float prezzo, String nomeCliente, String trattamento, String statoPrenotazione, String livello, String vista, String Esterno, boolean disponibile, boolean tv, boolean cassaforte, int annoIN, int meseIN, int giornoIN, int annoOUT, int meseOUT, int giornoOUT) 
    {
        this.idPrenotazione = idPrenotazione;
        this.numeroOspiti = numeroOspiti;
        this.prezzo = prezzo;
        this.nomeCliente = nomeCliente;
        this.trattamento = trattamento;
        this.statoPrenotazione = statoPrenotazione;
        this.livello = livello;
        this.vista = vista;
        this.Esterno = Esterno;
        this.disponibile = disponibile;
        this.tv = tv;
        this.cassaforte = cassaforte;
        this.annoIN = annoIN;
        this.meseIN = meseIN;
        this.giornoIN = giornoIN;
        this.annoOUT = annoOUT;
        this.meseOUT = meseOUT;
        this.giornoOUT = giornoOUT;
    }

    public int getIdPrenotazione() {
        return idPrenotazione;
    }

    public void setIdPrenotazione(int idPrenotazione) {
        this.idPrenotazione = idPrenotazione;
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

    public boolean isDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
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
