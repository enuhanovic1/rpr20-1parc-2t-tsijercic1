package ba.unsa.etf.rpr;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Kuhar {
    private List<Recept> recepti;

    public Kuhar() {
        recepti = new ArrayList<>();
    }

    void dodajRecept(Recept recept) {
        recepti.add(recept);
    }

    int brojRecepata() {
        return recepti.size();
    }

    Recept dajRecept(String naziv) {
        for (Recept recept : recepti) {
            if (recept.getNazivJela().equals(naziv)) return recept;
        }
        return null;
    }

    ArrayList<Recept> receptiSaSastojkom(Sastojak sastojak) {
        ArrayList<Recept> trazeni = new ArrayList<>();
        for (Recept recept : recepti) {
            if (recept.contains(sastojak)) trazeni.add(recept);
        }
        return trazeni;
    }

    Set<Sastojak> sviSastojci() {
        Set<Sastojak> svi = new TreeSet<>();
        for (Recept recept : recepti) {
            for (Sastojak sastojak : recept.getSastojci()) {
                svi.add(sastojak);
            }
        }
        return svi;
    }

    ArrayList<Recept> filtriraj(Predicate<Recept> fun) {
        return (ArrayList<Recept>) recepti.stream().filter(fun).collect(Collectors.toList());
    }
}
