package Kolekcija;

import mojPaket.GeometrijskiOblik;

public class MojaKolekcijaGO {
	int size = 0;
	Cvor prvi;
	Cvor poslednji;

	public void ubaciNaPocetak(GeometrijskiOblik go) {
		Cvor c;
		c = new Cvor();
		c.setPodatak(go);

		c.setSledeci(prvi);
		c.setPrethodni(null);
		if (prvi != null) {
			prvi.setPrethodni(c);
		} else {
			poslednji = c;
		}
		prvi = c;
		size++;
	}

	public void ubaciNaKraj(GeometrijskiOblik go) {
		Cvor c;
		c = new Cvor();
		c.setPodatak(go);

		c.setPrethodni(poslednji);
		c.setSledeci(null);
		if (poslednji != null) {
			poslednji.setSledeci(c);
		} else {
			prvi = c;
		}
		poslednji = c;
		size++;
	}

	public Cvor izbaciSaPocetka() {
		Cvor pom = prvi;
		if (prvi == null) {
			return null;
		}
		if (prvi.sledeci != null) {
			prvi = prvi.sledeci;
			prvi.prethodni = null;
		} else {
			prvi = null;
			poslednji = null;
		}
		size--;
		return pom;		
	}

	public Cvor izbaciSaKraja() {
		Cvor pom = poslednji;
		if (poslednji == null) {
			return null;
		}
		if (poslednji.prethodni != null) {
			poslednji = poslednji.prethodni;
			poslednji.sledeci = null;
		} else {
			prvi = null;
			poslednji = null;
		}
		size--;
		return pom;
		
	}

	public void ispisiPrviIPoslednji() {
		String prviS = "";
		String poslednjiS = "";
		if (prvi != null)
			prviS = prvi.getPodatak().toString();
		if (poslednji != null)
			poslednjiS = poslednji.getPodatak().toString();

		System.out.println("Prvi: " + prviS + " Poslednji: " + poslednjiS);
	}

	public boolean izbaciGeometrijskiOblik(GeometrijskiOblik go) {
		if (prvi == null) {
			return false;
		}
		if (prvi.getPodatak().uporediOblike(go)) {
			izbaciSaPocetka();
			return true;
		}
		if (poslednji.getPodatak().uporediOblike(go)) {
			izbaciSaKraja();
			return true;
		}
		Cvor pom = prvi;
		while (pom.sledeci != null) {
			if (pom.sledeci.getPodatak().uporediOblike(go)) {
				if (pom.sledeci.sledeci != null) {
					pom.sledeci.sledeci.prethodni = pom;
				}
				pom.sledeci = pom.sledeci.sledeci;
				size--;
				return true;
			}
			pom = pom.sledeci;
		}
		return false;

	}
	
	public boolean ubaciNaPozicijuAkoNePostoji(GeometrijskiOblik go,int ind){
		Cvor c;
		c = new Cvor();
		c.setPodatak(go);

		if(postojiUListi(go))
			return false;
		if(!validanIndex(ind)){
			throw new IndexOutOfBoundsException("Prosledjen je index manji od nule ili veci od velicine liste");
		}
		if(ind==0){
			ubaciNaPocetak(go);
		}
		if(ind==size){
			ubaciNaKraj(go);
		}
		
		int brojac = 0;
		Cvor pom = prvi;		
		while(brojac!=ind-1){
			pom = pom.sledeci;
			brojac ++;
		}
		if(pom.sledeci!=null){
			pom.sledeci.prethodni = c;
		}
		c.sledeci = pom.sledeci;
		pom.sledeci = c;
		c.prethodni = pom;
		size++;
		return true;		
	}
	
	
	
	private boolean validanIndex(int ind) {
		if(ind>-1 && ind<=size)
			return true;
		return false;
	}

	public boolean postojiUListi(GeometrijskiOblik go){
		Cvor pom = prvi;
		while (pom != null) {
			if (pom.getPodatak().uporediOblike(go)) {
				return true;				
			}
			pom = pom.sledeci;
		}
		return false;
	}

	public void prikaziOblikeTipa(GeometrijskiOblik go) {
		Cvor pom = prvi;
		String s = "Podaci za geometrijske oblike tipa "
				+ go.vratiNazivOblika() + " :\n";
		while (pom != null) {
			if (pom.getPodatak().vratiNazivOblika()
					.equals(go.vratiNazivOblika())) {
				s += pom.getPodatak() + "\n";
				
			}
			pom = pom.sledeci;
		}
		System.out.println(s);
	}
	
	public void prikaziListu(){
		System.out.println(this.toString());
	}
	
	public void prikaziListuUnazad(){
		Cvor pom = poslednji;
		String s = "Podaci:\n";
		while (pom != null) {
			s += pom.getPodatak() + "\n";
			pom = pom.prethodni;
		}
		System.out.println(s);
	}
	

	public String toString() {
		Cvor pom = prvi;
		String s = "Podaci:\n";
		while (pom != null) {
			s += pom.getPodatak() + "\n";
			pom = pom.sledeci;
		}
		return s;
	}
	
	public int vratiVelicinu(){
		return this.size;
	}

}
