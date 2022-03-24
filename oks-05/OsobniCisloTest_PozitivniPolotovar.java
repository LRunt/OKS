package oks05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OsobniCisloTest_PozitivniPolotovar {
    private OsobniCislo oc;

    @BeforeEach
    void setUp() {
        oc = new OsobniCislo("Novák, Josef, fav, 2014, b, p");
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
    void testToString_1() {
        assertEquals("A14BxxxxP <= NOVÁK Josef", oc.toString(), "Chyba: Očekávaná textová reprezentace instance je jiná.");
    }

    @Test
    void testGetOsobniCislo() {
        assertEquals("A14BxxxxP", oc.getOsobniCislo(), "Chyba: Vrácené osobní číslo je jiné než očekávané.");
    }

    @Test
    void testIsPlatneOsobniCislo_1() {
        oc.generujOsobniCislo("0226");
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