
package mojPaket;

public abstract class GeometrijskiOblik {
    
    abstract public double povrsina();
    
    abstract public double obim();
    
    abstract public String vratiNazivOblika();
    
    abstract public String vratiDimenzije();
    
    public boolean uporediOblike(GeometrijskiOblik o2){
    	if(this.vratiNazivOblika().equals(o2.vratiNazivOblika()) && this.vratiDimenzije().equals(o2.vratiDimenzije())){
    		return true;
    	}   	
    	return false;
    }
    

}
