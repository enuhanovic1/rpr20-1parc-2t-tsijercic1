package ba.unsa.etf.rpr;

public class TecniSastojak extends Sastojak {
    public TecniSastojak(String naziv, int kolicina) {
        super(naziv, kolicina);
    }

    @Override
    public String toString() {
        return kolicina + " dl " + naziv;
    }
}
