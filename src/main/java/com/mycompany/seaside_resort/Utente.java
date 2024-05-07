/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seaside_resort;

/**
 *
 * @author Alessandro
 */
public class Utente 
{
    private String username;
    private String password;
    private String ruolo;

    public Utente(String username, String password, String ruolo) {
        this.username = username;
        this.password = password;
        this.ruolo = ruolo;
    }

    public String getUsername() 
    {
        return username;
    }

    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getRuolo() 
    {
        return ruolo;
    }

    public void setRuolo(String ruolo) 
    {
        this.ruolo = ruolo;
    }

    @Override
    public String toString() 
    {
        return "Utente{" + "username=" + username + ", password=" + password + ", ruolo=" + ruolo + '}';
    }
    
}
