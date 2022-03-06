package oks02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Junit testy tridy OsobniCislo
 *
 * @author Lukas Runt
 * @version 1.0 (03-03-2022)
 */
class OsobniCisloTest {
    private OsobniCislo oc;

    @BeforeEach
    public void setUp() {
        oc = new OsobniCislo("Novák, Josef, fav, 2014, b, 0123, p, i");
    }

    @Test
    void getOsobniCislo_1() {
        oc.vysledek = "A14B0123P";
        assertEquals("A14B0123P", oc.getOsobniCislo());
    }

    @Test
    void isPlatneOsobniCislo_1() {
        oc.platnyFormat = false;
        assertFalse(oc.isPlatneOsobniCislo());
    }

    @Test
    void isPlatneOsobniCislo_2() {
        oc.platnyFormat = true;
        assertTrue(oc.isPlatneOsobniCislo());
    }

    @Test
    void isPlatnyFormat_1() {
        oc.platnyFormat = false;
        assertFalse(oc.isPlatnyFormat());
    }

    @Test
    void isPlatnyFormat_2() {
        oc.platnyFormat = true;
        assertTrue(oc.isPlatnyFormat());
    }

    @Test
    void getTypStudia() {
        oc.typStudia = TypStudia.DOKTORSKY;
        assertEquals(TypStudia.DOKTORSKY, oc.getTypStudia());
    }

    @Test
    void getFakulta() {
        oc.fakulta = "A";
        assertEquals("A", oc.getFakulta());
    }

    @Test
    void zpracujPrijmeni_1() {
        oc.zpracujPrijmeni("Novák");
        assertEquals("NOVÁK", oc.prijmeni);
    }

    @Test
    void zpracujPrijmeni_2() {
        oc.zpracujPrijmeni(null);
        assertEquals(Konstanty.ZNAK_CHYBY, oc.prijmeni);
    }

    @Test
    void zpracujJmeno_1() {
        oc.zpracujJmeno("Josef");
        assertEquals("Josef", oc.jmeno);
    }

    @Test
    void zpracujJmeno_2() {
        oc.zpracujJmeno(null);
        assertEquals(Konstanty.PRAZDNY, oc.jmeno);
    }

    @Test
    void zpracujRokNastupu_1() {
        oc.zpracujRokNastupu("2014");
        assertEquals("14", oc.rokNastupu);
    }

    @Test
    void zpracujRokNastupu_2() {
        oc.zpracujRokNastupu(null);
        assertEquals(Konstanty.ZNAK_CHYBY, oc.rokNastupu);
    }

    @Test
    void zpracujRokNastupu_3() {
        assertThrows(NumberFormatException.class, () -> oc.zpracujRokNastupu("ABCD"));
    }

    @Test
    void chybnyRokNastupu() {
        oc.chybnyRokNastupu();
        assertEquals(Konstanty.ZNAK_CHYBY, oc.rokNastupu);
    }

    @Test
    void zpracujFakulta_1() {
        oc.zpracujFakulta("FAV");
        assertEquals("A", oc.fakulta);
    }

    @Test
    void zpracujFakulta_2() {
        oc.zpracujFakulta(null);
        assertEquals(Konstanty.PRAZDNY, oc.fakulta);
    }

    @Test
    void zpracujTypStudia_1() {
       oc.zpracujTypStudia("B");
       assertEquals(TypStudia.BAKALARSKY, oc.typStudia);
    }

    @Test
    void zpracujTypStudia_2() {
        oc.zpracujTypStudia(null);
        assertEquals(TypStudia.NEPLATNY, oc.typStudia);
    }

    @Test
    void zpracujFormaStudia_1() {
        oc.zpracujFormaStudia("P");
        assertEquals("P", oc.formaStudia);
    }

    @Test
    void zpracujFormaStudia_2() {
        oc.zpracujFormaStudia(null);
        assertEquals(Konstanty.PRAZDNY, oc.formaStudia);
    }

    @Test
    void zpracujNepovinne_1() {
        oc.zpracujNepovinne("I");
        assertEquals("I", oc.nepovinne);
    }

    @Test
    void zpracujNepovinne_2() {
        oc.zpracujNepovinne(null);
        assertEquals(Konstanty.PRAZDNY, oc.nepovinne);
    }

    @Test
    void osobniCislo() {
        oc = new OsobniCislo("Novák, Josef, fav, 2014, b, 0123, p, i");
        assertEquals("A14B0123P", oc.vysledek);
    }
}