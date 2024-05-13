/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.seaside_resort;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alessandro
 */
public class CameraTest {
    
    public CameraTest() {
    }

    
    
    
    /**
     * Test of modificaCamera method, of class Camera.
     */
    @org.junit.jupiter.api.Test
    
    public void testModificaCamera() 
    {
        
        // Creazione di una camera
        Camera camera = new Camera(2, "Standard", "Vista mare", "Terrazzo", true, true, true);
    
        // Modifica dei dettagli della camera
        camera.modificaCamera(3, "Deluxe", false, true, false);

        // Creazione di una nuova camera con i nuovi dati
        Camera nuovaCamera = new Camera(3, "Deluxe", "Vista mare", "Terrazzo", false, false, true);
        
        // Verifica della corretta modifica dei dettagli
        assertEquals(nuovaCamera,camera);
        
    }
    
    
    
    /**
     * Test of getNumSuccessivo method, of class Camera.
     */
    @org.junit.jupiter.api.Test
    public void testGetNumSuccessivo() 
    {
        // Creazione di una camera
        Camera camera = new Camera(2, "Standard", "Vista mare", "Terrazzo", true, true, true);
        
        // Verifica del numero successivo
        assertEquals(camera.getNumeroCamera()+1, camera.getNumSuccessivo());
    }

    /**
     * Test of getNumeroCamera method, of class Camera.
     */
    @org.junit.jupiter.api.Test
    public void testGetNumeroCamera() 
    {
        // Creazione di una camera
        Camera camera = new Camera(2, "Standard", "Vista mare", "Terrazzo", true, true, true);
        
        // Verifica del numero della camera
        assertEquals(camera.getNumSuccessivo()-1, camera.getNumeroCamera());
    }

    /**
     * Test of getNumeroLetti method, of class Camera.
     */
    @org.junit.jupiter.api.Test
    public void testGetNumeroLetti() 
    {
        // Creazione di una camera
        Camera camera = new Camera(2, "Standard", "Vista mare", "Terrazzo", true, true, true);
        
        // Verifica del numero di letti
        assertEquals(2, camera.getNumeroLetti());
    }

    /**
     * Test of getDisponibilita method, of class Camera.
     */
    @org.junit.jupiter.api.Test
    public void testGetDisponibilita() 
    {
        // Creazione di una camera
        Camera camera = new Camera(2, "Standard", "Vista mare", "Terrazzo", true, true, true);
        
        // Verifica della disponibilità
        assertTrue(camera.getDisponibilita());
    }

    /**
     * Test of setNumeroLetti method, of class Camera.
     */
    @org.junit.jupiter.api.Test
    public void testSetNumeroLetti() 
    {
        // Creazione di una camera
        Camera camera = new Camera(2, "Standard", "Vista mare", "Terrazzo", true, true, true);
        
        // Impostazione di un nuovo numero di letti
        camera.setNumeroLetti(3);
        
        // Verifica della corretta impostazione del numero di letti
        assertEquals(3, camera.getNumeroLetti());
    }

    /**
     * Test of getLivello method, of class Camera.
     */
    @org.junit.jupiter.api.Test
    public void testGetLivello() 
    {
        // Creazione di una camera
        Camera camera = new Camera(2, "Standard", "Vista mare", "Terrazzo", true, true, true);
        
        // Verifica del livello della camera
        assertEquals("Standard", camera.getLivello());
    }

    /**
     * Test of setLivello method, of class Camera.
     */
    @org.junit.jupiter.api.Test
    public void testSetLivello() 
    {
        // Creazione di una camera
        Camera camera = new Camera(2, "Standard", "Vista mare", "Terrazzo", true, true, true);
        
        // Impostazione di un nuovo livello
        camera.setLivello("Deluxe");
        
        // Verifica della corretta impostazione del livello
        assertEquals("Deluxe", camera.getLivello());
    }

    /**
     * Test of getVista method, of class Camera.
     */
    @org.junit.jupiter.api.Test
    public void testGetVista() 
    {
        // Creazione di una camera
        Camera camera = new Camera(2, "Standard", "Vista mare", "Terrazzo", true, true, true);
        
        // Verifica della vista dalla camera
        assertEquals("Vista mare", camera.getVista());
    }

    /**
     * Test of setVista method, of class Camera.
     */
    @org.junit.jupiter.api.Test
    public void testSetVista() 
    {
        // Creazione di una camera
        Camera camera = new Camera(2, "Standard", "Vista mare", "Terrazzo", true, true, true);
        
        // Impostazione di una nuova vista
        camera.setVista("Vista giardino");
        
        // Verifica della corretta impostazione della vista
        assertEquals("Vista giardino", camera.getVista());
    }

    /**
     * Test of getEsterno method, of class Camera.
     */
    @org.junit.jupiter.api.Test
    public void testGetEsterno() 
    {
        // Creazione di una camera
        Camera camera = new Camera(2, "Standard", "Vista mare", "Terrazzo", true, true, true);
        
        // Verifica del tipo di esterno
        assertEquals("Terrazzo", camera.getEsterno());
    }

    /**
     * Test of setEsterno method, of class Camera.
     */
    @org.junit.jupiter.api.Test
    public void testSetEsterno() 
    {
        // Creazione di una camera
        Camera camera = new Camera(2, "Standard", "Vista mare", "Terrazzo", true, true, true);
        
        // Impostazione di un nuovo tipo di esterno
        camera.setEsterno("Giardino");
        
        // Verifica della corretta impostazione del tipo di esterno
        assertEquals("Giardino", camera.getEsterno());
    }

    /**
     * Test of isDisponibile method, of class Camera.
     */
    @org.junit.jupiter.api.Test
    public void testIsDisponibile() 
    {
        // Creazione di una camera
        Camera camera = new Camera(2, "Standard", "Vista mare", "Terrazzo", true, true, true);
        //Creazione di una prenotazione
        Prenotazione prenotazione = new Prenotazione(2,"Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
                
        // Impostazione delle prenotazioni per la camera
        camera.aggiungiPrenotazione(prenotazione);
        
        // Verifica che la camera sia disponibile per le date specificate
        assertTrue(camera.isDisponibile(LocalDate.of(2024, 5, 6), LocalDate.of(2024, 5, 10)));
        
        // Verifica che la camera non sia disponibile per le date specificate
        assertFalse(camera.isDisponibile(LocalDate.of(2024, 5, 2), LocalDate.of(2024, 5, 4)));
    }

    /**
     * Test of aggiungiPrenotazione method, of class Camera.
     */
    @org.junit.jupiter.api.Test
    public void testAggiungiPrenotazione() 
    {
        // Creazione di una camera
        Camera camera = new Camera(2, "Standard", "Vista mare", "Terrazzo", true, true, true);
        
        // Creazione di una prenotazione
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        
        // Aggiunta della prenotazione alla camera
        camera.aggiungiPrenotazione(prenotazione);
        
        // Verifica che la prenotazione sia stata aggiunta correttamente
        assertEquals(1, camera.getprenotazioni().size());
    }

    /**
     * Test of getprenotazioni method, of class Camera.
     */
    @org.junit.jupiter.api.Test
    public void testGetprenotazioni() 
    {
        // Creazione di una camera
        Camera camera = new Camera(2, "Standard", "Vista mare", "Terrazzo", true, true, true);
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        
        // Creazione di una lista di prenotazioni
        ArrayList<Prenotazione> prenotazioni = new ArrayList<>();
        prenotazioni.add(prenotazione);
        // Impostazione delle prenotazioni per la camera
        camera.aggiungiPrenotazione(prenotazione);
        
        // Verifica che il metodo getprenotazioni restituisca correttamente la lista di prenotazioni
        assertEquals(prenotazioni, camera.getprenotazioni());
    }

    /**
     * Test of isTv method, of class Camera.
     */
    @org.junit.jupiter.api.Test
    public void testIsTv() 
    {
        // Creazione di una camera con TV
        Camera camera1 = new Camera(2, "Standard", "Vista mare", "Terrazzo", true, true, true);
        // Creazione di una camera senza TV
        Camera camera2 = new Camera(2, "Standard", "Vista mare", "Terrazzo", true, false, true);
        
        // Verifica della presenza di TV nelle camere
        assertTrue(camera1.isTv());
        assertFalse(camera2.isTv());
    }

    /**
     * Test of setTv method, of class Camera.
     */
    @org.junit.jupiter.api.Test
    public void testSetTv() 
    {
        // Creazione di una camera
        Camera camera = new Camera(2, "Standard", "Vista mare", "Terrazzo", true, true, true);
        
        // Impostazione di una nuova presenza di TV
        camera.setTv(false);
        
        // Verifica della corretta impostazione della presenza di TV
        assertFalse(camera.isTv());
    }

    /**
     * Test of setDisponibilita method, of class Camera.
     */
    @org.junit.jupiter.api.Test
    public void testSetDisponibilita() 
    {
        // Creazione di una camera
        Camera camera = new Camera(2, "Standard", "Vista mare", "Terrazzo", true, true, true);
        
        // Impostazione di una nuova disponibilità
        camera.setDisponibilita(false);
        
        // Verifica della corretta impostazione della disponibilità
        assertFalse(camera.getDisponibilita());
    }

    /**
     * Test of isCassaforte method, of class Camera.
     */
    @org.junit.jupiter.api.Test
    public void testIsCassaforte() 
    {
        // Creazione di una camera con cassaforte
        Camera camera1 = new Camera(2, "Standard", "Vista mare", "Terrazzo", true, true, true);
        // Creazione di una camera senza cassaforte
        Camera camera2 = new Camera(2, "Standard", "Vista mare", "Terrazzo", true, true, false);
        
        // Verifica della presenza di cassaforte nelle camere
        assertTrue(camera1.isCassaforte());
        assertFalse(camera2.isCassaforte());
    }

    /**
     * Test of setCassaforte method, of class Camera.
     */
    @org.junit.jupiter.api.Test
    public void testSetCassaforte() 
    {
        // Creazione di una camera
        Camera camera = new Camera(2, "Standard", "Vista mare", "Terrazzo", true, true, true);
        
        // Impostazione di una nuova presenza di cassaforte
        camera.setCassaforte(false);
        
        // Verifica della corretta impostazione della presenza di cassaforte
        assertFalse(camera.isCassaforte());
    }

    /**
     * Test of toString method, of class Camera.
     */
    @org.junit.jupiter.api.Test
    public void testToString() 
    {
        // Creazione di una camera
        Camera camera = new Camera(2, "Standard", "Vista mare", "Terrazzo", true, true, true);
        
        // Verifica della rappresentazione in stringa della camera
        assertEquals("Camera{numeroCamera="+camera.getNumeroCamera()+", numeroLetti=2, livello=Standard, vista=Vista mare, Esterno=Terrazzo, disponibile=true, tv=true, cassaforte=true}\n", camera.toString());
    }
    
}
