
package Kolekcija;

import mojPaket.GeometrijskiOblik;

public class Cvor {
    GeometrijskiOblik podatak;
    Cvor sledeci;
    Cvor prethodni;

    public GeometrijskiOblik getPodatak() {
        return podatak;
    }

    public void setPodatak(GeometrijskiOblik podatak) {
        this.podatak = podatak;
    }

    public Cvor getSledeci() {
        return sledeci;
    }

    public void setSledeci(Cvor sledeci) {
        this.sledeci = sledeci;
    }

	public Cvor getPrethodni() {
		return prethodni;
	}

	public void setPrethodni(Cvor prethodni) {
		this.prethodni = prethodni;
	}
    
    







}
