/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seaside_resort;

import java.util.ArrayList;

/**
 *
 * @author Alessandro
 */
public class Gestione 
{
    private static final int MAX_CAMERE = 200;
    private static int numCamere=0;

    public Gestione() 
    {
    }
    
    ArrayList<Camera>camere=new ArrayList<>();
    public void aggiungiCamera(Camera camera)
    {
        if (numCamere>=MAX_CAMERE)
        {
            camere.add(camera);
            System.out.println("Camera numero"+camera.getNumeroCamera()+"Aggiunta");
        }
        else
            System.out.println("Non Funzia");
//Todo: Eccezione num max camere
    }
    public void rimuoviCamera (int numCamera)
    {
        camere.remove(cercaCamera(numCamera));
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
    
}
