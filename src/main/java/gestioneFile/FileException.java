package gestioneFile;

/**
 * Eccezione sollevata quando si verifica un errore generico con i file
 * Principalmente usata quando si raggiunge la fine di un file
 * @author Alessandro
 */
public class FileException extends Exception
{
    /***
     * Motivo del sollevamento dell'eccezione
     */
    private String motivoEccezione;
    
    /***
     * Costruttore
     * @param motivo Motivo del sollevamento dell'eccezione
     */
    public FileException(String motivo)
    {
        motivoEccezione=motivo;
    }
    
    /***
     * Metodo per restituire un motivo
     * @return Motivo del sollevamento dell'eccezione
     */
    public String toString()
    {
        return motivoEccezione;
    }
    
    
}
