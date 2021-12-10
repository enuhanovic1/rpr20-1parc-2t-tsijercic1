package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class Recept {
    private String nazivJela;
    private List<Sastojak> sastojci;
    private VrstaPripreme vrstaPripreme;
    private int podatak;

    public Recept(String nazivJela) {
        this.nazivJela = nazivJela;
        sastojci = new ArrayList<>();
        vrstaPripreme = VrstaPripreme.KUHANJE;
        podatak = 0;
    }

    public String getNazivJela() {
        return nazivJela;
    }

    public List<Sastojak> getSastojci() {
        return sastojci;
    }

    public VrstaPripreme getVrstaPripreme() {
        return vrstaPripreme;
    }

    public int getPodatak() {
        return podatak;
    }

    public void setNazivJela(String nazivJela) {
        this.nazivJela = nazivJela;
    }

    public void setVrstaPripreme(VrstaPripreme vrstaPripreme) {
        this.vrstaPripreme = vrstaPripreme;
    }

    public void setPodatak(int podatak) {
        this.podatak = podatak;
    }

    public void dodajSastojak(Sastojak novi) {
        for (Sastojak sastojak : sastojci) {
            if (sastojak.getNaziv().equals(novi.getNaziv()) && sastojak.getClass().equals(novi.getClass())) {
                sastojak.setKolicina(sastojak.getKolicina() + novi.getKolicina());
                return;
            }
        }
        sastojci.add(novi);
    }

    public void izbaciSastojak(Sastojak nezeljeni) throws NoSuchSastojakException {
        for (Sastojak sastojak : sastojci) {
            if (sastojak.getNaziv().equals(nezeljeni.getNaziv()) && sastojak.getClass().equals(nezeljeni.getClass())) {
                sastojci.remove(sastojak);
                return;
            }
        }
        throw new NoSuchSastojakException("Nepoznat sastojak " + nezeljeni.getNaziv());
    }

    @Override
    public String toString() {
        String ispis = "Recept za " + nazivJela + "\n";
        if (sastojci.size() == 0) ispis += "\n";
        for (Sastojak sastojak : sastojci) {
            ispis += sastojak + "\n";
        }
        if (vrstaPripreme == VrstaPripreme.PECENJE) ispis += "Peći na " + podatak + " stepeni";
        if (vrstaPripreme == VrstaPripreme.KUHANJE) ispis += "Kuhati " + podatak + " minuta";
        if (vrstaPripreme == VrstaPripreme.PRZENJE) ispis += "Pržiti " + podatak + " minuta";
        return ispis;
    }
}
