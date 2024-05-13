/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Classe utilizzata per acquisire dati di input
 * @author Studente
 */
public class ConsoleInput 
{
    private InputStreamReader reader;
    private BufferedReader tastiera;
    
    /**
     * Costruttore
     */
    public ConsoleInput()
    {
        reader=new InputStreamReader(System.in);
        tastiera=new BufferedReader(reader);
        
    }
    
    /**
     * Legge una stringa
     * @return La stringa letta
     * @throws IOException errore di input
     * @throws NumberFormatException input inserito non coerente 
     * 
     */
    public String readString() throws IOException, NumberFormatException
    {
        return tastiera.readLine();
    }
    
    /**
     * Legge un intero
     * @return Numero intero letto
     * @throws IOException errore di input
     * @throws NumberFormatException input inserito non coerente 
     * 
     */
    public int readInt() throws IOException, NumberFormatException
    {
        String s=tastiera.readLine();
        int x=Integer.parseInt(s);
        return x;
    }
    
    /**
     * Legge un numero short
     * @return Il numero short letto
     * @throws IOException errore di input
     * @throws NumberFormatException input inserito non coerente 
     * 
     */
    public short readShort() throws IOException, NumberFormatException
    {
        return Short.parseShort(tastiera.readLine());
    }
    
    /**
     * Legge un carattere
     * @return Il carattere letto
     * @throws IOException errore di input
     * @throws NumberFormatException input inserito non coerente 
     * 
     */
    public char readChar() throws IOException, NumberFormatException
    {
        return tastiera.readLine().charAt(0);
    }
    
    /**
     * Legge un numero long
     * @return Il numero long letto
     * @throws IOException errore di input
     * @throws NumberFormatException input inserito non coerente 
     * 
     */
    public Long readLong() throws IOException, NumberFormatException
    {
        return Long.parseLong(tastiera.readLine());
    }
    
    /**
     * Legge un numero float
     * @return Il numero float letto
     * @throws IOException errore di input
     * @throws NumberFormatException input inserito non coerente 
     * 
     */
    public float readFloat() throws IOException, NumberFormatException
    {
        return Float.parseFloat(tastiera.readLine());
    }
    
    /**
     * Legge un numero double
     * @return Il numero double letto
     * @throws IOException errore di input
     * @throws NumberFormatException input inserito non coerente 
     * 
     */
    public double readDouble() throws IOException, NumberFormatException
    {
        return Double.parseDouble(tastiera.readLine());
    }
    /**
     * Legge un valore booleano
     * @return Il valore booleano letto (true/false)
     * @throws IOException errore di input
     * @throws NumberFormatException input inserito non coerente 
     * 
     */
    public Boolean readBoolean() throws IOException, NumberFormatException
    {
        return Boolean.parseBoolean(tastiera.readLine());
    }
    
    /**
     * Legge un byte
     * @return Il byte letto
     * @throws IOException errore di input
     * @throws NumberFormatException input inserito non coerente 
     * 
     */
    public byte readByte() throws IOException, NumberFormatException
    {
        return Byte.parseByte(tastiera.readLine());
    }
    
    
}
