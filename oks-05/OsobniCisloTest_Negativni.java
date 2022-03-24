package oks05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OsobniCisloTest_Negativni {

    @Test
    void testToString_2() {
        OsobniCislo oc = new OsobniCislo(null);
        assertEquals("???xxxx? <= ? ? (chybně zadáno)", oc.toString(), "Chyba: Očekávaná textová reprezentace instance je jiná.");
    }

    @Test
    void testZpracujPrijmeni() {
        OsobniCislo oc = new OsobniCislo(null);
        assertEquals(Konstanty.ZNAK_CHYBY, oc.prijmeni, "Chyba: Očekávaný znak: " + Konstanty.ZNAK_CHYBY + ", Skutečný znak: " + oc.prijmeni);
    }

    @Test
    void testZpracujJmeno() {
        OsobniCislo oc = new OsobniCislo(null);
        assertEquals(Konstanty.ZNAK_CHYBY, oc.jmeno, "Chyba: Očekávaný znak: " + Konstanty.ZNAK_CHYBY + ", Skutečný znak: " + oc.jmeno);
    }

    @Test
    void testZpracujRokNastupu_1() {
        OsobniCislo oc = new OsobniCislo(null);
        assertEquals(Konstanty.ZNAK_CHYBY, oc.rokNastupu, "Chyba: Očekávaný znak: " + Konstanty.ZNAK_CHYBY + ", Skutečný znak: " + oc.rokNastupu);
    }

    @Test
    void testZpracujRokNastupu_2() {
        OsobniCislo oc = new OsobniCislo("Novák, Josef, fav, 014, b, p");
        assertEquals(Konstanty.ZNAK_CHYBY, oc.rokNastupu, "Chyba: Očekávaný znak: " + Konstanty.ZNAK_CHYBY + ", Skutečný znak: " + oc.rokNastupu);
    }

    @Test
    void testZpracujRokNastupu_3() {
        OsobniCislo oc = new OsobniCislo("Novák, Josef, fav, TEST, b, p");
        assertEquals(Konstanty.ZNAK_CHYBY, oc.rokNastupu, "Chyba: Očekávaný znak: " + Konstanty.ZNAK_CHYBY + ", Skutečný znak: " + oc.rokNastupu);
    }

    @Test
    void testZpracujFakulta() {
        OsobniCislo oc = new OsobniCislo(null);
        assertEquals(Konstanty.ZNAK_CHYBY, oc.fakulta, "Chyba: Očekávaný znak: " + Konstanty.ZNAK_CHYBY + ", Skutečný znak: " + oc.fakulta);
    }

   @Test
    void testNaplnAtributy() {
        OsobniCislo oc = new OsobniCislo("Novák, Josef, fav, 2014, b, p, h, h");
        assertTrue(oc.isPlatnyFormat(), "Chyba: Formát čísla je platný.");
    }

    @Test
    void testZpracujNepovinne() {
        OsobniCislo oc = new OsobniCislo(null);
        oc.zpracujNepovinne("n");
        assertEquals("n", oc.nepovinne, "Chyba: Očekávaný znak: n, Skutečný znak: " + oc.nepovinne);
    }

    @Test
    void testIsPlatneOsobniCislo_1() {
        OsobniCislo oc = new OsobniCislo("");
        assertFalse(oc.isPlatneOsobniCislo(), "Chyba: Formát osobního čísla není platný");
    }

    @Test
    void testIsPlatneOsobniCislo_2() {
        OsobniCislo oc = new OsobniCislo("Novák, Josef, fav, 2014, b, p");
        assertFalse(oc.isPlatneOsobniCislo(), "Chyba: Formát osobního čísla není platný");
    }
}
