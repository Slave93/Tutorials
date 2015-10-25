package glavna;


import Kolekcija.MojaKolekcijaGO;
import mojPaket.GeometrijskiOblik;
import mojPaket.Krug;
import mojPaket.Pravougaonik;


public class RacunanjePovrsine {
    
    public static void main(String[] args) {
        Krug krug=new Krug(10);
        Krug krug2=new Krug(20);
        Krug krug3=new Krug(30);
        Krug krug4=new Krug(40);
        
        Pravougaonik prav = new Pravougaonik(6, 9);
        Pravougaonik prav2 = new Pravougaonik(7, 9);
        Pravougaonik prav3 = new Pravougaonik(8, 9);
        Pravougaonik prav4 = new Pravougaonik(9, 9);
        
        Pravougaonik kaoPrav2 = new Pravougaonik(7, 9);
      
        GeometrijskiOblik go;
        go=krug;
                
                
        //System.out.println("Povrsina geometrijskog oblika je: "+go.povrsina());
        
        MojaKolekcijaGO kolekcija = new MojaKolekcijaGO();
        kolekcija.ubaciNaPocetak(krug); 
        kolekcija.ubaciNaPocetak(krug2); 
        kolekcija.ubaciNaKraj(prav); 
        kolekcija.ubaciNaKraj(prav2);
        kolekcija.ubaciNaPocetak(prav3); 
        kolekcija.ubaciNaKraj(krug3); 
        
       /*
        kolekcija.prikaziOblikeTipa(new Pravougaonik());
        
        System.out.println("Moja kolekcija:\n"+kolekcija);
        kolekcija.ispisiPrviIPoslednji();
        
        System.out.println("##########################################");
        System.out.println(kolekcija.izbaciGeometrijskiOblik(kaoPrav2));
        System.out.println("##########################################");
        
        System.out.println("Moja kolekcija:\n"+kolekcija);
        kolekcija.ispisiPrviIPoslednji();
        
        */
        System.out.println(kolekcija.vratiVelicinu());
        System.out.println(kolekcija.ubaciNaPozicijuAkoNePostoji(new Krug(15), 2));
        kolekcija.ispisiPrviIPoslednji();
        System.out.println(kolekcija.vratiVelicinu());
        
        System.out.println("Moja kolekcija:\n"+kolekcija);
        
        
        
        
        
        
        
    }















}
