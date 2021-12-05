package ba.unsa.etf.rpr;

public abstract class Sastojak implements Comparable<Sastojak>{
    private String naziv;
    private int kolicina;

    public Sastojak(String naziv, int kolicina) {
        this.naziv = naziv;
        this.kolicina = kolicina;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sastojak)) return false;

        Sastojak sastojak = (Sastojak) o;
        if (!((this instanceof PraskastiSastojak && sastojak instanceof PraskastiSastojak)
                || (this instanceof TecniSastojak && sastojak instanceof TecniSastojak))) {
            return false;
        }
        return getNaziv() != null ? getNaziv().equals(sastojak.getNaziv()) : sastojak.getNaziv() == null;
    }

    @Override
    public int hashCode() {
        return getNaziv() != null ? getNaziv().hashCode() : 0;
    }

    @Override
    public int compareTo(Sastojak o) {
        if (getKolicina() == o.getKolicina()) {
            if (getNaziv().equals(o.getNaziv())) {
                return 0;
            }
            return -1;
        }
        return Integer.compare(getKolicina(), o.getKolicina());
    }
}
