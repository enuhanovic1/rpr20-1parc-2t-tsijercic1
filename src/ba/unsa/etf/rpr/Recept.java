package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

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
        sastojci.stream()
                .filter(s -> s.equals(sastojak))
                .findFirst()
                .ifPresentOrElse(
                        sastojak1 -> sastojak1.setKolicina(sastojak1.getKolicina() + sastojak.getKolicina()),
                        () -> sastojci.add(sastojak)
                );
    }

    public void izbaciSastojak(Sastojak sastojak) {
        sastojci.remove(
                sastojci.stream()
                        .filter(sastojak1 -> sastojak1.equals(sastojak))
                        .findFirst().orElseThrow(() -> new NoSuchSastojakException("Nepoznat sastojak " + sastojak.getNaziv()))
        );
    }

    @Override
    public String toString() {
        return "Recept za " + getNazivJela() + "\n" +
                sastojci.stream().map(sastojak -> sastojak + "\n").collect(Collectors.joining()) +
                (sastojci.size() == 0 ? "\n" : "") +
                vrstaPripreme.toString() +
                ((!vrstaPripreme.equals(VrstaPripreme.PECENJE)) ? "" : " na") +
                " " +
                getPodatak() + " " +
                ((!vrstaPripreme.equals(VrstaPripreme.PECENJE)) ? "minuta" : "stepeni");
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
