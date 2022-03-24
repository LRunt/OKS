package oks05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OsobniCisloTest_PozitivniFinalni {
    private OsobniCislo oc;

    @BeforeEach
    void setUp() {
        oc = new OsobniCislo("Novák, Josef, fav, 2014, b, p");
        oc.generujOsobniCislo("0226");
    }

    @Test
    void testCompareTo_1() {
        OsobniCislo oc2 = new OsobniCislo("Dvořák, Josef, fav, 2014, b, p");
        assertEquals(1, oc.compareTo(oc2), "Chyba: první je větší");
    }

    @Test
    void testCompareTo_2() {
        OsobniCislo oc2 = new OsobniCislo("Novák, František, fav, 2014, b, p");
        assertEquals(1, oc.compareTo(oc2), "Chyba: první je větší");
    }

    @Test
    void testIsPlatneOsobniCislo_2() {
        assertTrue(oc.isPlatneOsobniCislo(), "Chyba: Formát čísla je platný");
    }

    @Test
    void testGetTypStudia() {
        assertEquals(TypStudia.BAKALARSKY ,oc.getTypStudia(), "Chyba: Vrácený typ studia je jiný než se očekávalo.");
    }

    @Test
    void testGetFakulta() {
        assertEquals("A", oc.getFakulta(), "Chyba: Vrácená fakulta byla jiná než očekávaná.");
    }

    @Test
    void testNaplnAtributy() {
        assertTrue(oc.isPlatnyFormat(), "Chyba: Formát čísla je platný.");
    }
}
