/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.seaside_resort;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alessandro
 */
public class PrenotazioneTest {
    
    public PrenotazioneTest() {
    }

    /**
     * Test of getIdPrenotazione method, of class Prenotazione.
     */
    @Test
    public void testGetIdPrenotazione() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        assertEquals(prenotazione.getNumSuccessivo()-1, prenotazione.getIdPrenotazione());
    }

    /**
     * Test of getNumSuccessivo method, of class Prenotazione.
     */
    @Test
    public void testGetNumSuccessivo() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        assertEquals(prenotazione.getIdPrenotazione()+1, prenotazione.getNumSuccessivo());
    }

    /**
     * Test of getNumeroCamera method, of class Prenotazione.
     */
    @Test
    public void testGetNumeroCamera() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        prenotazione.setNumeroCamera(2);
        assertEquals(2, prenotazione.getNumeroCamera());
    }

    /**
     * Test of setNumeroCamera method, of class Prenotazione.
     */
    @Test
    public void testSetNumeroCamera() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        prenotazione.setNumeroCamera(3);
        assertEquals(3, prenotazione.getNumeroCamera());
    }

    /**
     * Test of getNumeroOspiti method, of class Prenotazione.
     */
    @Test
    public void testGetNumeroOspiti() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        assertEquals(2, prenotazione.getNumeroOspiti());
    }

    /**
     * Test of setNumeroOspiti method, of class Prenotazione.
     */
    @Test
    public void testSetNumeroOspiti() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        prenotazione.setNumeroOspiti(3);
        assertEquals(3, prenotazione.getNumeroOspiti());
    }

    /**
     * Test of getPrezzo method, of class Prenotazione.
     */
    @Test
    public void testGetPrezzo() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        assertEquals(0.0f, prenotazione.getPrezzo());
    }

    /**
     * Test of setPrezzo method, of class Prenotazione.
     */
    @Test
    public void testSetPrezzo() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        prenotazione.setPrezzo(100.0f);
        assertEquals(100.0f, prenotazione.getPrezzo());
    }

    /**
     * Test of getNomeCliente method, of class Prenotazione.
     */
    @Test
    public void testGetNomeCliente() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        assertEquals("Mario Rossi", prenotazione.getNomeCliente());
    }

    /**
     * Test of setNomeCliente method, of class Prenotazione.
     */
    @Test
    public void testSetNomeCliente() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        prenotazione.setNomeCliente("Giuseppe Verdi");
        assertEquals("Giuseppe Verdi", prenotazione.getNomeCliente());
    }

    /**
     * Test of getTrattamento method, of class Prenotazione.
     */
    @Test
    public void testGetTrattamento() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        assertEquals("Pensione completa", prenotazione.getTrattamento());
    }

    /**
     * Test of setTrattamento method, of class Prenotazione.
     */
    @Test
    public void testSetTrattamento() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        prenotazione.setTrattamento("Solo pernottamento");
        assertEquals("Solo pernottamento", prenotazione.getTrattamento());
    }

    /**
     * Test of getStatoPrenotazione method, of class Prenotazione.
     */
    @Test
    public void testGetStatoPrenotazione() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        assertEquals("In Approvazione", prenotazione.getStatoPrenotazione());
    }

    /**
     * Test of setStatoPrenotazione method, of class Prenotazione.
     */
    @Test
    public void testSetStatoPrenotazione() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        prenotazione.setStatoPrenotazione("Confermata");
        assertEquals("Confermata", prenotazione.getStatoPrenotazione());
    }

    /**
     * Test of getLivello method, of class Prenotazione.
     */
    @Test
    public void testGetLivello() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        assertEquals("Standard", prenotazione.getLivello());
    }

    /**
     * Test of setLivello method, of class Prenotazione.
     */
    @Test
    public void testSetLivello() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        prenotazione.setLivello("Superior");
        assertEquals("Superior", prenotazione.getLivello());
    }

    /**
     * Test of getVista method, of class Prenotazione.
     */
    @Test
    public void testGetVista() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        assertEquals("Vista mare", prenotazione.getVista());
    }

    /**
     * Test of setVista method, of class Prenotazione.
     */
    @Test
    public void testSetVista() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        prenotazione.setVista("Vista montagna");
        assertEquals("Vista montagna", prenotazione.getVista());
    }

    /**
     * Test of getEsterno method, of class Prenotazione.
     */
    @Test
    public void testGetEsterno() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        assertEquals("Terrazzo", prenotazione.getEsterno());
    }

    /**
     * Test of setEsterno method, of class Prenotazione.
     */
    @Test
    public void testSetEsterno() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        prenotazione.setEsterno("Giardino");
        assertEquals("Giardino", prenotazione.getEsterno());
    }

    /**
     * Test of isTv method, of class Prenotazione.
     */
    @Test
    public void testIsTv() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        assertTrue(prenotazione.isTv());
    }

    /**
     * Test of setTv method, of class Prenotazione.
     */
    @Test
    public void testSetTv() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        prenotazione.setTv(false);
        assertFalse(prenotazione.isTv());
    }

    /**
     * Test of isCassaforte method, of class Prenotazione.
     */
    @Test
    public void testIsCassaforte() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        assertTrue(prenotazione.isCassaforte());
    }

    /**
     * Test of setCassaforte method, of class Prenotazione.
     */
    @Test
    public void testSetCassaforte() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        prenotazione.setCassaforte(false);
        assertFalse(prenotazione.isCassaforte());
    }

    /**
     * Test of getAnnoIN method, of class Prenotazione.
     */
    @Test
    public void testGetAnnoIN() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        prenotazione.setAnnoIN(2025);
        assertEquals(2025, prenotazione.getAnnoIN());
    }

    /**
     * Test of setAnnoIN method, of class Prenotazione.
     */
    @Test
    public void testSetAnnoIN() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        prenotazione.setAnnoIN(2025);
        assertEquals(2025, prenotazione.getAnnoIN());
    }

    /**
     * Test of getMeseIN method, of class Prenotazione.
     */
    @Test
    public void testGetMeseIN() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        assertEquals(5, prenotazione.getMeseIN());
    }

    /**
     * Test of setMeseIN method, of class Prenotazione.
     */
    @Test
    public void testSetMeseIN() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        prenotazione.setMeseIN(6);
        assertEquals(6, prenotazione.getMeseIN());
    }

    /**
     * Test of getGiornoIN method, of class Prenotazione.
     */
    @Test
    public void testGetGiornoIN() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        assertEquals(1, prenotazione.getGiornoIN());
    }

    /**
     * Test of setGiornoIN method, of class Prenotazione.
     */
    @Test
    public void testSetGiornoIN() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        prenotazione.setGiornoIN(2);
        assertEquals(2, prenotazione.getGiornoIN());
    }

    /**
     * Test of getCheckIN method, of class Prenotazione.
     */
    @Test
    public void testGetCheckIN() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        assertEquals(LocalDate.of(2024, 5, 1), prenotazione.getCheckIN());
    }

    /**
     * Test of setCheckIN method, of class Prenotazione.
     */
    @Test
    public void testSetCheckIN() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        prenotazione.setCheckIN(LocalDate.of(2024, 5, 2));
        assertEquals(LocalDate.of(2024, 5, 2), prenotazione.getCheckIN());
    }

    /**
     * Test of getAnnoOUT method, of class Prenotazione.
     */
    @Test
    public void testGetAnnoOUT() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        assertEquals(2024, prenotazione.getAnnoOUT());
    }

    /**
     * Test of setAnnoOUT method, of class Prenotazione.
     */
    @Test
    public void testSetAnnoOUT() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        prenotazione.setAnnoOUT(2025);
        assertEquals(2025, prenotazione.getAnnoOUT());
    }

    /**
     * Test of getMeseOUT method, of class Prenotazione.
     */
    @Test
    public void testGetMeseOUT() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        assertEquals(5, prenotazione.getMeseOUT());
    }

    /**
     * Test of setMeseOUT method, of class Prenotazione.
     */
    @Test
    public void testSetMeseOUT() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        prenotazione.setMeseOUT(6);
        assertEquals(6, prenotazione.getMeseOUT());
    }

    /**
     * Test of getGiornoOUT method, of class Prenotazione.
     */
    @Test
    public void testGetGiornoOUT() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        assertEquals(5, prenotazione.getGiornoOUT());
    }

    /**
     * Test of setGiornoOUT method, of class Prenotazione.
     */
    @Test
    public void testSetGiornoOUT() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        prenotazione.setGiornoOUT(6);
        assertEquals(6, prenotazione.getGiornoOUT());
    }

    /**
     * Test of getCheckOUT method, of class Prenotazione.
     */
    @Test
    public void testGetCheckOUT() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        assertEquals(LocalDate.of(2024, 5, 5), prenotazione.getCheckOUT());
    }

    /**
     * Test of setCheckOUT method, of class Prenotazione.
     */
    @Test
    public void testSetCheckOUT() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        prenotazione.setCheckOUT(LocalDate.of(2024, 5, 6));
        assertEquals(LocalDate.of(2024, 5, 6), prenotazione.getCheckOUT());
    }

    /**
     * Test of toString method, of class Prenotazione.
     */
    @Test
    public void testToString() 
    {
        Prenotazione prenotazione = new Prenotazione(2, "Mario Rossi", "Pensione completa", "Standard", "Vista mare", "Terrazzo", true, true, 2024, 5, 1, 2024, 5, 5);
        String expectedString = "Prenotazione{idPrenotazione="+prenotazione.getIdPrenotazione()+", numeroOspiti=2, numeroCamera=0, prezzo=0.0, nomeCliente=Mario Rossi, trattamento=Pensione completa, statoPrenotazione=In Approvazione, livello=Standard, vista=Vista mare, Esterno=Terrazzo, tv=true, cassaforte=true, checkIN=2024-05-01, checkOUT=2024-05-05}\n";
        assertEquals(expectedString, prenotazione.toString());
    }
    
}
