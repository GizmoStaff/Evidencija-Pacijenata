
package evidencijapacijenata;


public class Pacijent {
  private  String ime;
  private String prezime; 
  private String adresa;
  public  String  spol []={"Muško","Žensko","Neodređeno"};
   private String kontak_podaci;
   public int MBO_pacijenta;
   public  String  krvna_grupa []={"A+","A-","B+","B-","AB+","AB-","0+","0-"};
   
   
   
    public Pacijent () {
        this.ime = ime;
        this.prezime = prezime;
        this.spol = spol;
        this.krvna_grupa=krvna_grupa;
        this.adresa=adresa;
        this.kontak_podaci=kontak_podaci;
        this.MBO_pacijenta=MBO_pacijenta;
    }

  

  public String getIme(String ime) {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime(String prezime) {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    
      public String getAdresa(String adresa) {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    
    
     public String getKontakPodaci(String kontak_podaci) {
        return kontak_podaci;
    }

    public void setKontakPodaci(String kontak_podaci) {
        this.kontak_podaci = kontak_podaci;
    }
     
    
}