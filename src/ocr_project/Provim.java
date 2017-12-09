package ocr_project;

import java.util.ArrayList;

/**
 *
 * @author Orges
 */
public class Provim 
{
    private String kodi;
    private String formatiDates;
    private String emriStudentit;
    private String mbiemriStudentit;
    private String atesia;
    private String tekstiNeKoke;
    private String tekstiNeFund;
    private String qendra; 
    private int  niveli; 
    private ArrayList< Pyetje > pyetjet;
    private int totaliPikeve;
    private int piketEStudentit;
    
    // Konstruktori default
    public Provim()
    {
        this.kodi = "";
        this.formatiDates = "dd-MM-yy";
        this.emriStudentit = "";
        this.mbiemriStudentit = "";
        this.atesia = "";
        this.tekstiNeKoke = "";
        this.tekstiNeFund = "";
        this.qendra = "";
        this.niveli = 0;
        this.totaliPikeve = 0;
        this.piketEStudentit = 0;
        this.pyetjet = new ArrayList< Pyetje >();
    }
    
    // Kontruktori me parametra
    public Provim( String kodi, String formatiDates, String emriStudentit,String mbiemriStudentit, String atesia, String tekstiNeFund, String tekstiNeKoke, String qendra, int niveli, int totaliPikeve, int piketEStudentit, ArrayList< Pyetje > pyetjet  )
    {
        this.kodi = kodi;
        this.formatiDates = formatiDates;
        this.emriStudentit = emriStudentit;
        this.mbiemriStudentit = mbiemriStudentit;
        this.atesia = atesia;
        this.tekstiNeFund = tekstiNeFund;
        this.tekstiNeKoke = tekstiNeKoke;
        this.qendra = qendra;
        this.piketEStudentit = piketEStudentit;
        this.totaliPikeve = totaliPikeve;
        this.niveli = niveli;
        this.pyetjet = pyetjet;
    }
    
    public void setKodi( String kodi )
    {
        this.kodi = kodi;
    }
    
    public String getKodi()
    {
        return this.kodi;
    }
    
    public void setFormatiDates( String formati )
    {
        this.formatiDates = formati;
    }
    
    public String getFormatiDates()
    {
        return this.formatiDates;
    }
    
    public void setEmri( String emri )
    {
        this.emriStudentit = emri;
    }
    
    public String getEmri()
    {
        return this.emriStudentit;
    }
    
    public void setMbiemri( String mbiemri )
    {
        this.mbiemriStudentit = mbiemri;
    }
    
    public String getMbiemri()
    {
        return this.mbiemriStudentit;
    }
    
    public void setAtesia( String atesia )
    {
        this.atesia = atesia;
    }
    
    public String getAtesia()
    {
        return this.atesia;
    }
    
    public void setTekstiNeFund( String teksti )
    {
        this.tekstiNeFund = teksti;
    }
    
    public String getTektsiNeFund()
    {
        return this.tekstiNeFund;
    }
    
    public void setTekstiNeKoke( String teksti )
    {
        this.tekstiNeKoke = teksti;
    }
    
    public String getTekstiNeKoke()
    {
        return this.tekstiNeKoke;
    }
    
    public void setQendra( String qendra )
    {
        this.qendra = qendra;
    }
    
    public String getQendra()
    {
        return this.qendra;
    }
    
    public void setPiketEStudentit( int piket )
    {
        this.piketEStudentit = piket;
    }
    
    public int getPiketEStudentit()
    {
        return this.piketEStudentit;
    }
    
    public void setPiketTotale( int piket )
    {
        this.totaliPikeve = piket;
    }
    
    public int getPiketTotale()
    {
        return this.totaliPikeve;
    }
    
    public void setPyetjet( ArrayList< Pyetje > pyetjet )
    {
        this.pyetjet = pyetjet;
    }
    
    
    public ArrayList< Pyetje > getPyetjet()
    {
        return this.pyetjet;
    }
}

