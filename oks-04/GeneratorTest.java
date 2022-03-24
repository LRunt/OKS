package oks04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class GeneratorTest {

  private Generator generator;
  private List<List<OsobniCislo>> seznamyTypuStudia;
  private List<OsobniCislo> testovaciData;
  private ICteniDat ctenar;

  @BeforeEach
  public void setUp() {
    // příprava dat pro mock objekt
    testovaciData = TestovaciData.getTestovaciData();

    // příprava mock objektu
    ctenar = mock(ICteniDat.class);
    when(ctenar.nactiVsechnaOsobniCisla("vstup")).thenReturn(testovaciData);

    generator = new Generator(ctenar);
    seznamyTypuStudia = generator.zpracovani("vstup", "fav");
  }

  @Test
  void getSeznamTypuStudia_bakalari(){
    int pocet = seznamyTypuStudia.get(0).size();
    assertEquals(4, pocet);
  }

  @Test
  void getSeznamTypuStudia_navazujici(){
    int pocet = seznamyTypuStudia.get(1).size();
    assertEquals(14, pocet);
  }

  @Test
  void getSeznamTypuStudia_doktorandi(){
    int pocet = seznamyTypuStudia.get(2).size();
    assertEquals(3, pocet);
  }

  @Test
  void vytvorSeznamChybnychFormatu(){
    int pocet = generator.vytvorSeznamChybnychFormatu(testovaciData, "A").size();
    assertEquals(9, pocet);
  }

  @AfterEach
  public void tearDown() {
    verify(ctenar).nactiVsechnaOsobniCisla("vstup");
  }
}
