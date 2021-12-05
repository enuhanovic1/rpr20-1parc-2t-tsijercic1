package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.Set;
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
        return null;
    }

    public int brojRecepata() {
        return recepti.size();
    }

    public ArrayList<Recept> receptiSaSastojkom(Sastojak sastojak) {
        return recepti;
    }

    public Set<Sastojak> sviSastojci() {
        return null;
    }
    public ArrayList<Recept> filtriraj(Predicate<Recept> uslov) {
        return recepti.stream().filter(uslov).collect(Collectors.toCollection(ArrayList::new));
    }
}
