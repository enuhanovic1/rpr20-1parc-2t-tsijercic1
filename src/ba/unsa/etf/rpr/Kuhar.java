package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Kuhar {
    ArrayList<Recept> recepti;

    public Kuhar() {
        recepti = new ArrayList<>();
    }

    public void dodajRecept(Recept recept) {
        recepti.add(recept);
    }

    public Recept dajRecept(String nazivJela) {
        return recepti.stream()
                .filter(recept -> recept.getNazivJela().equals(nazivJela))
                .findFirst()
                .orElse(null);
    }

    public int brojRecepata() {
        return recepti.size();
    }

    public ArrayList<Recept> receptiSaSastojkom(Sastojak sastojak) {
        return recepti.stream()
                .filter(
                        recept ->
                                recept.getSastojci().stream()
                                        .anyMatch(sastojak1 -> sastojak.getNaziv().equals(sastojak1.getNaziv()))
                ).collect(Collectors.toCollection(ArrayList::new));
    }

    public Set<Sastojak> sviSastojci() {
        return recepti.stream().map(Recept::getSastojci).flatMap(Collection::stream).collect(Collectors.toCollection(TreeSet::new));
    }
    public ArrayList<Recept> filtriraj(Predicate<Recept> uslov) {
        return recepti.stream().filter(uslov).collect(Collectors.toCollection(ArrayList::new));
    }
}
