package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.Objects;

public class Recept {
    private String nazivJela;
    private ArrayList<Sastojak> sastojci;
    private VrstaPripreme vrstaPripreme;
    private int podatak;

    public Recept(String nazivJela) {
        this.nazivJela = nazivJela;
        this.sastojci = new ArrayList<>();
        this.vrstaPripreme = VrstaPripreme.KUHANJE;
    }

    public String getNazivJela() {
        return nazivJela;
    }

    public void setNazivJela(String nazivJela) {
        this.nazivJela = nazivJela;
    }

    public ArrayList<Sastojak> getSastojci() {
        return sastojci;
    }

    public void setSastojci(ArrayList<Sastojak> sastojci) {
        this.sastojci = sastojci;
    }

    public VrstaPripreme getVrstaPripreme() {
        return vrstaPripreme;
    }

    public void setVrstaPripreme(VrstaPripreme vrstaPripreme) {
        this.vrstaPripreme = vrstaPripreme;
    }

    public int getPodatak() {
        return podatak;
    }

    public void setPodatak(int podatak) {
        this.podatak = podatak;
    }

    public void dodajSastojak(Sastojak sastojak) {
        if (sastojci.contains(sastojak)) {
            Sastojak kojiMijenjamo = sastojci.get(sastojci.indexOf(sastojak));
            kojiMijenjamo.setKolicina(kojiMijenjamo.getKolicina() + sastojak.getKolicina());
        } else {
            sastojci.add(sastojak);
        }
    }

    public void izbaciSastojak(Sastojak sastojak) {
        if (!sastojci.contains(sastojak)) {
            throw new NoSuchSastojakException("Nepoznat sastojak " + sastojak.getNaziv());
        } else {
            sastojci.remove(sastojak);
        }
    }

    @Override
    public String toString() {
        String result = "Recept za " + getNazivJela() + "\n";
        for (Sastojak sastojak : sastojci) {
            result += sastojak + "\n";
        }
        result += sastojci.size() == 0 ? "\n" : "";
        boolean notPecenje = (!vrstaPripreme.equals(VrstaPripreme.PECENJE));
        result += vrstaPripreme.toString() +(notPecenje?"":" na")+ " " + getPodatak() + " " +
                (notPecenje ? "minuta" : "stepeni");
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recept recept = (Recept) o;

        return Objects.equals(nazivJela, recept.nazivJela);
    }

    @Override
    public int hashCode() {
        return nazivJela != null ? nazivJela.hashCode() : 0;
    }
}
