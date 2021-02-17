package opdracht2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
// Dit is in samenwerking met Iwan van der Kolk gemaakt.

class VoetbalclubTest {
    @Test
    void nullNaam() {
        Voetbalclub test = new Voetbalclub(null);
        assertEquals("FC 0 0 0 0 0", test.toString());
    }

    @Test
    void legeNaam() {
        Voetbalclub test = new Voetbalclub("");
        assertEquals("FC 0 0 0 0 0", test.toString());
    }

    @Test
    void puntWinst() {
        Voetbalclub test = new Voetbalclub("Test");
        test.verwerkResultaat('w');
        assertEquals(3, test.aantalPunten());
    }

    @Test
    void puntGelijk() {
        Voetbalclub test = new Voetbalclub("Test");
        test.verwerkResultaat('g');
        assertEquals(1, test.aantalPunten());
    }

    @Test
    void puntVerlies() {
        Voetbalclub test = new Voetbalclub("Test");
        test.verwerkResultaat('v');
        assertEquals(0, test.aantalPunten());
    }

    @Test
    void puntVerkeerd() {
        Voetbalclub test = new Voetbalclub("Test");
        test.verwerkResultaat('x');
        assertEquals("Test 0 0 0 0 0", test.toString());
    }

    @Test
    void puntWinstString() {
        Voetbalclub test = new Voetbalclub("Test");
        test.verwerkResultaat('w');
        assertEquals("Test 1 1 0 0 3", test.toString());
    }

    @Test
    void puntGelijkString() {
        Voetbalclub test = new Voetbalclub("Test");
        test.verwerkResultaat('g');
        assertEquals("Test 1 0 1 0 1", test.toString());
    }

    @Test
    void puntVerliesString() {
        Voetbalclub test = new Voetbalclub("Test");
        test.verwerkResultaat('v');
        assertEquals("Test 1 0 0 1 0", test.toString());
    }

    @Test
    void puntAllemaalString() {
        Voetbalclub test = new Voetbalclub("Test");
        test.verwerkResultaat('w');
        test.verwerkResultaat('g');
        test.verwerkResultaat('v');
        assertEquals("Test 3 1 1 1 4", test.toString());
    }

    //Eis: Herhaaldelijk verwerken van deze resultaten moet zorgen voor een correcte optelling van wedstrijdaantallen en punten.
    //Oplossing: Veel random resultaten.
    @Test
    void meerdereResultaten() {
        int max = 25;
        int min = 0;

        Voetbalclub test = new Voetbalclub("Test");

        int random1 = (int)(Math.random() * (max - min + 1) + min);
        for(int nummer = 0; nummer < random1; nummer++) {
            test.verwerkResultaat('w');
        }

        int random2 = (int)(Math.random() * (max - min + 1) + min);
        for(int nummer = 0; nummer < random2; nummer++) {
            test.verwerkResultaat('g');
        }

        int random3 = (int)(Math.random() * (max - min + 1) + min);
        for(int nummer = 0; nummer < random3; nummer++) {
            test.verwerkResultaat('v');
        }

        int totaalRandomWedstrijden = random1 + random2 + random3;
        int totaalRandomPunten = random1*3 + random2;
        assertEquals("Test " + totaalRandomWedstrijden + " " + random1 + " " + random2 + " " + random3 + " " + totaalRandomPunten, test.toString());
    }




}