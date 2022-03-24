package oks04;

import java.util.ArrayList;
import java.util.List;

import oks04.OsobniCislo;

/**
 * Třída pro přípravu seznamu testovacích dat
 * 
 * účel třídy je, že lze z vnějšku (z validátoru) vnutit jiná testovací data
 * 
 * @author P.Herout
 *
 */
public class TestovaciData {
  
  /**
   * Připraví libovolné množství testovacích dat, což jsou řetězce (řádky), 
   * jaké by se načítaly z textového souboru
   * 
   * dělení do skupin "bakaláři", ..., "magistři" a "chybně zadané" je pouze pro přehlednost
   *  a na poskytování dat nemá vliv  
   *  
   * @return seznam předgenerovaných osobních čísel ze vstupních řádek testovacích dat
   */
  public static List<OsobniCislo> getTestovaciData() {
    List<OsobniCislo> testovaciData = new ArrayList<>();
    // bakaláři
    testovaciData.add(new OsobniCislo("Novák, Josef, fav, 2014, b, p"));
    testovaciData.add(new OsobniCislo("Aldus, Pavel, fav, 2014, B, p"));
    testovaciData.add(new OsobniCislo("Želé, Jakub, fav, 2014, b, P, i"));
    testovaciData.add(new OsobniCislo("Divoký, René, fav, 2014, B, P, I, něco navíc"));

    // navazující

    testovaciData.add(new OsobniCislo("Platnost, Karel, fav, 2014, n, p"));
    testovaciData.add(new OsobniCislo("Plát, Josef, Fav, 2014, n, p"));
    testovaciData.add(new OsobniCislo("Plátno, Miloš, FAv, 2014, n, p"));
    testovaciData.add(new OsobniCislo("Plankton, Richard, FAV, 2014, n, p"));
    testovaciData.add(new OsobniCislo("Plachta, Jiří, fav, 2014, N, p"));
    testovaciData.add(new OsobniCislo("Plášť, Rudolf, fav, 2014, n, P"));
    testovaciData.add(new OsobniCislo("Plahočení, Petr, fav, 2014, n, k"));
    testovaciData.add(new OsobniCislo("Plánička, Jan, fav, 2014, n, K"));
    testovaciData.add(new OsobniCislo("Platno, Václav, fav, 2014, N, k"));
    testovaciData.add(new OsobniCislo("Placebo, Jindřich, fav, 2014, N, K"));
    testovaciData.add(new OsobniCislo("Plaňka, David, fav, 2014, n, p"));
    testovaciData.add(new OsobniCislo("Plat, Michal, fav, 2014, n, p"));
    testovaciData.add(new OsobniCislo("Plánička, Jaroslav, fav, 2014, n, p"));
    testovaciData.add(new OsobniCislo("Platnost, Alfréd, fav, 2014, n, p"));

    // doktorandi
    testovaciData.add(new OsobniCislo("Dlouhý, Roman, fav, 2014, p, p"));
    testovaciData.add(new OsobniCislo("Široký, Stanislav, fav, 2014, P, p"));
    testovaciData.add(new OsobniCislo("Bystrozraký, Martin, fav, 2014, P, P"));

    // magistři z FPR
    testovaciData.add(new OsobniCislo("Právník, René, FPR, 2014, m, p"));
    testovaciData.add(new OsobniCislo("Právník, Daniel, FPR, 2014, M, p"));
    testovaciData.add(new OsobniCislo("Právník, Alois, FPR, 2014, M, P, I"));

    // bakaláři z jiných fakult správně zadaní
    testovaciData.add(new OsobniCislo("Strojař, Pavel, fst, 2014, b, p"));
    testovaciData.add(new OsobniCislo("Pedagog, Pavel, FPE, 2014, b, p"));
    testovaciData.add(new OsobniCislo("Elektrikář, Pavel, fel, 2014, b, p"));
    testovaciData.add(new OsobniCislo("Ekonom, Pavel, fEk, 2014, b, p"));
    testovaciData.add(new OsobniCislo("Umělec, Pavel, fDU, 2014, b, p"));
    testovaciData.add(new OsobniCislo("Zdravotník, Pavel, fzS, 2014, b, p"));
    testovaciData.add(new OsobniCislo("Filosof, Pavel, fF, 2014, b, p"));

    // chybně zadané
    testovaciData.add(new OsobniCislo("Chybný, Radomil, fuj, 2014, b, p"));
    testovaciData.add(new OsobniCislo("Chybný, Dalimil, fav, 2014, x, p"));
    testovaciData.add(new OsobniCislo("Chybný, Čestmír, fav, 2014, b, x"));
    testovaciData.add(new OsobniCislo("Chybný, Vladan, fuj, 2014, x, x"));
    testovaciData.add(new OsobniCislo("Chybný, Břetislav, fav, 2014, b"));
    testovaciData.add(new OsobniCislo("Chybný, Pravoslav, fav, 2014"));
    testovaciData.add(new OsobniCislo("Chybný, Radovan, fav"));
    testovaciData.add(new OsobniCislo("Chybný, Ctirad"));
    testovaciData.add(new OsobniCislo("Chybný"));
    testovaciData.add(new OsobniCislo("Chybný, Drahoslav, fav, 14, b, p"));
    testovaciData.add(new OsobniCislo("Chybný, Vladislav, fav, 0x2014, b, p"));
    testovaciData.add(new OsobniCislo("Chybný, Sebastian, fav, 02014, b, p"));
    testovaciData.add(new OsobniCislo("Chybný, Slavomír, fav, 4, b, p"));

    return testovaciData;
  }

}
