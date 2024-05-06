package eccezioni;

/**
 *
 * @author Alessandro
 */
public class FileException extends Exception
{
    private String motivoEccezione;
    
    public FileException(String motivo)
    {
        motivoEccezione=motivo;
    }
    
    public String toString()
    {
        return motivoEccezione;
    }
    
    
}
