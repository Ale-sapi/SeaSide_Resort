/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seaside_resort;

/**
 *
 * @author Alessandro
 */
public class Camera 
{
    private int numeroCamera;
    private int numeroLetti;
    private float prezzo;
    private String livello;
    private String vista;
    private String Esterno;//Terrazzo o Giardino
    private boolean disponibile;
    private boolean tv;
    private boolean cassaforte;

    public Camera(int numeroCamera, int numeroLetti, float prezzo, String livello, String vista, String Esterno, boolean disponibile, boolean tv, boolean cassaforte) 
    {
        this.numeroCamera = numeroCamera;
        this.numeroLetti = numeroLetti;
        this.prezzo = prezzo;
        this.livello = livello;
        this.vista = vista;
        this.Esterno = Esterno;
        this.disponibile = disponibile;
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
        this.disponibile = camera.isDisponibile();
        this.tv = camera.isTv();
        this.cassaforte = camera.isCassaforte();
    }
    
    public int getNumeroCamera() 
    {
        return numeroCamera;
    }

    public void setNumeroCamera(int numeroCamera) 
    {
        this.numeroCamera = numeroCamera;
    }

    public int getNumeroLetti() 
    {
        return numeroLetti;
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

    public boolean isDisponibile() 
    {
        return disponibile;
    }

    public void setDisponibilita(boolean disponibile) 
    {
        this.disponibile = disponibile;
    }

    public boolean isTv() 
    {
        return tv;
    }

    public void setTv(boolean tv) 
    {
        this.tv = tv;
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
