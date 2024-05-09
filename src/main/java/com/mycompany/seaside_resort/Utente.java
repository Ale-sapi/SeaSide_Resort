/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seaside_resort;

/**
 * Classe che rappresenta un utente del sistema.
 * Contiene le informazioni di base dell'utente come username, password e ruolo.
 * 
 * @author Alessandro
 */
public class Utente 
{
    private String username; // Username dell'utente
    private String password; // Password dell'utente
    private String ruolo;    // Ruolo dell'utente (es. "amministratore", "utente normale")

    /**
     * Costruttore della classe Utente.
     * 
     * @param username Username dell'utente.
     * @param password Password dell'utente.
     * @param ruolo Ruolo dell'utente.
     */
    public Utente(String username, String password, String ruolo) {
        this.username = username;
        this.password = password;
        this.ruolo = ruolo;
    }

    /**
     * Restituisce l'username dell'utente.
     * 
     * @return L'username dell'utente.
     */
    public String getUsername() 
    {
        return username;
    }

    /**
     * Imposta l'username dell'utente.
     * 
     * @param username Il nuovo username dell'utente.
     */
    public void setUsername(String username) 
    {
        this.username = username;
    }

    /**
     * Restituisce la password dell'utente.
     * 
     * @return La password dell'utente.
     */
    public String getPassword() 
    {
        return password;
    }

    /**
     * Imposta la password dell'utente.
     * 
     * @param password La nuova password dell'utente.
     */
    public void setPassword(String password) 
    {
        this.password = password;
    }

    /**
     * Restituisce il ruolo dell'utente.
     * 
     * @return Il ruolo dell'utente.
     */
    public String getRuolo() 
    {
        return ruolo;
    }

    /**
     * Imposta il ruolo dell'utente.
     * 
     * @param ruolo Il nuovo ruolo dell'utente.
     */
    public void setRuolo(String ruolo) 
    {
        this.ruolo = ruolo;
    }

    /**
     * Restituisce una rappresentazione in formato stringa dell'oggetto Utente.
     * 
     * @return Una stringa che rappresenta l'oggetto Utente.
     */
    @Override
    public String toString() 
    {
        return "Utente{" + "username=" + username + ", password=" + password + ", ruolo=" + ruolo + '}';
    }
    
}

