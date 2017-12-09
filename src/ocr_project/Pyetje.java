package ocr_project;

import java.util.ArrayList;

/**
 *
 * @author Orges
 */
public class Pyetje 
{   
    private static final String HAPSIRE = " ";
    private static final String STRING_BOSH = "";
    
    private String indeksi;
    private String pyetja;
    private ArrayList<String> alternativat;
    private ArrayList<String> pergjigjet;
    private int pike;
    
    ///Konstruktori default
    public Pyetje()
    {
        indeksi = "-1";
        pyetja = "";
        alternativat = new ArrayList<String>();
        pergjigjet = new ArrayList<String>();
        pike = 0;
    }
    
    // Konstruktori me parametra
    public Pyetje( String indeksi, String pyetja, ArrayList<String> alternativat, ArrayList<String> pergjigjet, int pike )
    {   
        this.indeksi = indeksi;
        this.pyetja = pyetja;
        this.alternativat = alternativat;
        this.pergjigjet = pergjigjet;
        this.pike = pike;
    }
    
    // Vendos indeksin e pyetjes
    public void setIndeksin( String indeksi )
    {
        this.indeksi = indeksi;
    }
    
    // Kthen indeksin e pyetjes
    public String getIndeksi()
    {
        return this.indeksi;
    }
    
    // Vendos pyetjen
    public void setPyetjen( String pyetja )
    {
        this.pyetja = pyetja;
    }
    
    // Kthen pyetjen
    public String getPyetjen()
    {
        return this.pyetja;
    }
    
    // Vendos alternativat - 
    public void setAlternativat( ArrayList<String> alternativat)
    {
        this.alternativat = alternativat;
    }
    
    // Kthen arraylisten me alternativa
    public ArrayList<String> getAlternativat()
    {
        return this.alternativat;
    }
    
    /// Vendos pergjigjet
    public void setPergjigjet( ArrayList< String > pergjigjet )
    {
        this.pergjigjet = pergjigjet;
    }
    
    // Kthen arraylist me pergjigje
    public ArrayList< String > getPergjigjet()
    {
        return this.pergjigjet;
    }
    
    // Vendos piket e pyetjes
    public void setPiket( int pike )
    {
        this.pike = pike;
    }
    
    // kthen piket e pyetjes
    public int getPiket()
    {
        return this.pike;
    }
    
    // Krahason nese kjo pyetje eshte e njejte me nje pyetje tjeter
    public boolean Equals( Pyetje p1 )
    {
        boolean eshteENjejte = true;
        
        // Nese pyetjet kane indekse te ndryshme
        if( p1.getIndeksi().replace( HAPSIRE, STRING_BOSH ).equals( this.indeksi.replace(HAPSIRE, STRING_BOSH ) ) == false )
        {
            eshteENjejte = false;
        }
        
        // Nese pytjet kane pyetjen e ndryshme
        if( p1.getPyetjen().replace( HAPSIRE, STRING_BOSH ).equals( this.pyetja.replace(HAPSIRE, STRING_BOSH )) == false )
        {
            eshteENjejte = false;
        }
        
        // Nese pyetjet kane numer alternativash te ndryshem
        if( p1.getAlternativat().size() != this.alternativat.size() )
        {
            eshteENjejte = false;
        }
        
        // Nese pyetjet kane numer pergjigjesh te ndryshme
        if( p1.getPergjigjet().size() != this.pergjigjet.size() ) 
        {
            eshteENjejte = false;
        }
        
        // Nese nuk ka pike te njejta
        if( p1.getPiket() != this.pike )
        {
            eshteENjejte = false;
        }
        return eshteENjejte;
    }
}
