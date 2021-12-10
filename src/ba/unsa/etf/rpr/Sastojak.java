package ba.unsa.etf.rpr;

public abstract class Sastojak implements Comparable<Sastojak> {
    String naziv;
    int kolicina;

    public Sastojak(String naziv, int kolicina) {
        this.naziv = naziv;
        this.kolicina = kolicina;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public int compareTo(Sastojak o) {
        if (kolicina < o.getKolicina()) return -1;
        if (kolicina > o.getKolicina()) return 1;
        return 0;
    }
}
