package ba.unsa.etf.rpr;

import java.util.ArrayList;

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
}
