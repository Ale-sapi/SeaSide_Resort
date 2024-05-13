/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioneFile;

import gestioneFile.TextFile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe utilizzata per la lettura e scrittura su file
 * @author Alessandro
 */
public class TextFile 
{
    private char mode;
    private BufferedReader reader;
    private BufferedWriter writer;
    
    /**
    * Costruttore per creare un oggetto TextFile per la lettura o scrittura di un file.
    * 
    * @param fileName Nome del file
    * @param mode Modalità di apertura del file ('R' per lettura, 'W' per scrittura)
    * @throws FileNotFoundException Se il file specificato non viene trovato
    * @throws IOException Se si verifica un errore di I/O durante l'apertura del file
    */
    public TextFile(String fileName, char mode) throws FileNotFoundException, IOException
    {
        this.mode='R';
        if(mode=='W' || mode=='w')
            this.mode='W';
        
        if(this.mode=='R')
        {
            reader=new BufferedReader(new FileReader(fileName));
        }
            
        
        else
        {
            writer=new BufferedWriter(new FileWriter(fileName));
        }
    
    }
    
    /**
    * Costruttore per creare un oggetto TextFile per la lettura o scrittura di un file.
    * 
    * @param fileName Nome del file
    * @param mode Modalità di apertura del file ('R' per lettura, 'W' per scrittura)
    * @param append True se si desidera aggiungere al file, false altrimenti
    * @throws FileNotFoundException Se il file specificato non viene trovato
    * @throws IOException Se si verifica un errore di I/O durante l'apertura del file
    */
    public TextFile(String fileName, char mode, boolean append) throws FileNotFoundException, IOException
    {
        
        this.mode='R';
        if(mode=='W' || mode=='w')
            this.mode='W';
        
        if(this.mode=='R')
        {
            reader=new BufferedReader(new FileReader(fileName));
        }
            
        
        else
        {
            writer=new BufferedWriter(new FileWriter(fileName, append));
        }
    
    }
    
    /**
    * Scrive una linea nel file aperto in modalità scrittura.
    * 
    * @param line La linea da scrivere nel file
    * @throws FileException Se il file è aperto in modalità lettura
    * @throws IOException Se si verifica un errore di I/O durante la scrittura nel file
    */
    public void toFile(String line) throws FileException, IOException
    {
        if (mode=='R')
        {
            throw new FileException("il file è aperto in lettura!!!");
        }
        else
            writer.write(line);
            writer.newLine();
    }
    
    /**
    * Legge una linea dal file aperto in modalità lettura.
    * 
    * @return La linea letta dal file
    * @throws FileException Se il file è aperto in modalità scrittura o se si raggiunge la fine del file
    * @throws IOException Se si verifica un errore di I/O durante la lettura dal file
    */
    public String fromFile() throws FileException, IOException
    {
        String line;
        if (mode=='W')
        {
            throw new FileException("il file è aperto in scrittura");
        }
        else
            line=reader.readLine();
        
        if(line==null)
            throw new FileException("fine del file");
        return line;
    }
    
    /**
    * Chiude il file aperto.
    * 
    * @throws IOException Se si verifica un errore durante la chiusura del file
    */
    public void close() throws IOException
    {
        if(mode=='R')
        {
            reader.close();
        }
        else
            writer.close();
    }
    
    
    
    
}
