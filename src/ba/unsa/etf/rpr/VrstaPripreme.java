package ba.unsa.etf.rpr;

public enum VrstaPripreme {
    PECENJE("Peći"),
    KUHANJE("Kuhati"),
    PRZENJE("Pržiti");

    private String sta;
    VrstaPripreme(String sta) {
        this.sta = sta;
    }

    @Override
    public String toString() {
        return sta;
    }
}
