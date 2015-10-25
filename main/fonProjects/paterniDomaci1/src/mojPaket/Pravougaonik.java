
package mojPaket;

import javax.print.attribute.standard.Sides;

public class Pravougaonik extends GeometrijskiOblik{

    double duzina;
    double visina;

    public Pravougaonik(){
    	
    }
    
    public Pravougaonik(double duzina, double visina) {
        this.duzina = duzina;
        this.visina = visina;
    }
    
    
    
    @Override
    public double povrsina() {
      double povrsina=duzina*visina;
      return povrsina;
    }

    @Override
    public double obim() {
        double obim=2*duzina+2*visina;
        return obim;
    }
    
    public String toString() {
        return "Pravougaonik: duzina= "+duzina+"\nVisina= "+visina;        
    }

	@Override
	public String vratiNazivOblika() {
		return "pravougaonik";
	}



	@Override
	public String vratiDimenzije() {
		return "Duzina: "+duzina+" Visina: "+visina;
	}





}
