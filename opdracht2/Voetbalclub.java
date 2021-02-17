package opdracht2;

public class Voetbalclub {
    private int aantalGewonnen;
    private int aantalGelijk;
    private int aantalVerloren;
    private String clubNaam = "FC";

    public Voetbalclub(String clubNaam) {
        if(clubNaam!=null && !clubNaam.equals("")){
            this.clubNaam = clubNaam;
        }
    }

    public void verwerkResultaat(char ch) {
        if (ch == 'w')
            aantalGewonnen = aantalGewonnen + 1;
        if (ch == 'g')
            aantalGelijk = aantalGelijk + 1;
        if (ch == 'v')
            aantalVerloren = aantalVerloren + 1;
    }

    public int aantalPunten() {
        return (aantalGewonnen * 3 + aantalGelijk);
    }

    public int aantalGespeeld() {
        return (aantalGewonnen + aantalGelijk + aantalVerloren);
    }

    @Override
    public String toString() {
        return clubNaam + " "
                + aantalGespeeld() + " "
                + aantalGewonnen + " "
                + aantalGelijk + " "
                + aantalVerloren + " "
                + aantalPunten();
    }
}
