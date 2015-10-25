
package mojPaket;

public class Krug extends GeometrijskiOblik {
   double poluprecnik;
   final double pi=3.1415;

    public Krug(double poluprecnik) {
        this.poluprecnik = poluprecnik;
    }

    @Override
    public double povrsina() {
        double povrsina=poluprecnik*poluprecnik*pi;
        return povrsina;
    }

    @Override
    public double obim() {
        double obim=pi*2*poluprecnik;
        return obim;
    }

    @Override
    public String toString() {
        return "Krug: r= "+poluprecnik;
    }

	@Override
	public String vratiNazivOblika() {
		return "krug";
	}

	@Override
	public String vratiDimenzije() {
		return "Polupreènik: "+poluprecnik;
	}
   
   






}
