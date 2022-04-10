package oks08.support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Utils {
  public static Map<String, String> NAZVY_VYBERU_FAKULTA;

  static {
    nastavNazvyVyberu();
  }

  private static void nastavNazvyVyberu() {
    NAZVY_VYBERU_FAKULTA = new HashMap<>();
    NAZVY_VYBERU_FAKULTA.put("N", " --- neuvedeno ---");
    NAZVY_VYBERU_FAKULTA.put("FAV", "FAV - Fakulta aplikovaných věd");
    NAZVY_VYBERU_FAKULTA.put("FDU", "FDU - Fakulta designu a umění Ladislava Sutnara");
    NAZVY_VYBERU_FAKULTA.put("FEK", "FEK - Fakulta ekonomická");
    NAZVY_VYBERU_FAKULTA.put("FEL", "FEL - Fakulta elektrotechnická");
    NAZVY_VYBERU_FAKULTA.put("FF", "FF - Fakulta filosofická");
    NAZVY_VYBERU_FAKULTA.put("FPE", "FPE - Fakulta pedagogická");
    NAZVY_VYBERU_FAKULTA.put("FPR", "FPR - Fakulta právnická");
    NAZVY_VYBERU_FAKULTA.put("FST", "FST - Fakulta strojní");
    NAZVY_VYBERU_FAKULTA.put("FZS", "FZS - Fakulta zdravotnických studií");
  }

  // Typ studia
  public static final String TYP_B = "bakalářský";
  public static final String TYP_N = "navazující";
  public static final String TYP_P = "doktorský";
  public static final String TYP_M = "magisterský";

  /**
   * Natazeni stranky daneho URL a cekani na zobrazeni
   *
   * @param url URL pozadovane stranky
   */
  public static void getURLAndWait(String url) {
    Drivers.getDriver().get(url);
    (new WebDriverWait(Drivers.getDriver(), Const.TIMEOUT)).until(
            ExpectedConditions.urlToBe(url));
  }

  /**
   * Klik na element a cekani na zobrazeni prislusne stranky
   *
   * @param element element, na ktery se klika
   * @param expectedURL URL pozadovane stranky
   */
  public static void clickAndWaitURL(WebElement element, String expectedURL) {
    element.click();
    (new WebDriverWait(Drivers.getDriver(), Const.TIMEOUT)).until(
            ExpectedConditions.urlToBe(expectedURL));
  }

  /**
   * Kliknuti na tlacitko a cekani na obnoveni stranky Generovani
   *
   * @param id ID tlacitka
   */
  public static void stiskniTlacitkoACekej(String id) {
    WebElement button= Drivers.getDriver().findElement(By.id(id));
    clickAndWaitURL(button, Const.URL_GENEROVANI);
  }

  /**
   * Nastaveni fakulty ve vyberovem seznamu
   * pouzije se NAZVY_VYBERU_FAKULTA ze Settings
   *
   * @param zkratkaFakulty tripismenna zkratka fakulty nebo "FF"
   */
  public static void setFakulta(String zkratkaFakulty) {
    WebElement seznam = Drivers.getDriver().findElement(By.name(Id.GEN_SELECT_FAKULTA));
    Select select = new Select(seznam);
    select.selectByVisibleText(NAZVY_VYBERU_FAKULTA.get(zkratkaFakulty));
  }

  /**
   * Nastaveni roku nastupu
   *
   * @param rok rok nastupu
   */
  public static void setRok(String rok) {
    WebElement input = Drivers.getDriver().findElement(By.id(Id.GEN_INPUT_ROK));
    input.clear();
    input.sendKeys(rok);
  }

  /**
   * Nastaveni typu studia
   *
   * @param typ bude zadan pomoci konstant z Const - TYP_B apod.
   */
  public static void setTyp(String typ) {
    WebElement seznam = Drivers.getDriver().findElement(By.name(Id.GEN_SELECT_TYP));
    Select select = new Select(seznam);
    select.selectByVisibleText(typ);
  }

  /**
   * Nastveni poradoveho cisla
   *
   * @param poradi poradove cislo
   */
  public static void setPoradi(String poradi) {
    WebElement input = Drivers.getDriver().findElement(By.id(Id.GEN_INPUT_PORADI));
    input.clear();
    input.sendKeys(poradi);
  }

  /**
   * Nastaveni formy studia
   *
   * @param idForma ID konkretniho radiobuttonu
   */
  public static void setForma(String idForma) {
    WebElement radioButton = Drivers.getDriver().findElement(By.id(idForma));
    if(!radioButton.isSelected()){
      radioButton.click();
    }
  }

  /**
   * Generovani vysledneho osobniho cisla tlacitkem Generovani
   */
  public static void generujCislo() {
    stiskniTlacitkoACekej(Id.GEN_BUTTON_GENEROVANI);
  }

  /**
   * Vrati vygenerovane osobni cislo
   * @return
   */
  public static String getVysledek() {
    WebElement vysledek = Drivers.getDriver().findElement(By.id(Id.GEN_TEXT_VYSLEDEK));
    return vysledek.getText();
  }

  /**
   * Vymazani celeho formulare tlacitkem Vymaz
   */
  public static void vymazFormular() {
    stiskniTlacitkoACekej(Id.GEN_BUTTON_MAZANI);
  }

  /**
   * Je zobrazeno generovane osobni cislo
   *
   * @return true - je zobrazeno, false - neni zobrazeno
   */
  public static boolean isVysledekZobrazen() {
    List<WebElement> vysledek = Drivers.getDriver().findElements(By.id(Id.GEN_TEXT_VYSLEDEK));
    return vysledek.size() > 0;
  }

  /**
   * Generovani cisla a vraceni vysledku
   * predpoklada se, ze pri generovani nedojde k chybe
   *
   * @return vygenerovane osobni cislo
   */
  public static String generujCisloAVratVysledek() {
    generujCislo();
    return getVysledek();
  }

  /**
   * Nastaveni / shozeni priznaku zahranicniho studenta
   *
   * @param zahr true - nastavit, false - shodit
   */
  public static void setZahranicni(boolean zahr) {
    WebElement checkBox = Drivers.getDriver().findElement(By.id(Id.GEN_CHKBOX_ZAHR));
    if(checkBox.isSelected() != zahr){
      checkBox.click();
    }
  }

  /**
   * Je zobrazena chyba konkretniho ID
   *
   * @param id ID chyby
   * @return true - chyba je zobrazena, false - neni zobrazena
   */
  public static boolean isZobrazenaChyba(String id) {
    List<WebElement> text = Drivers.getDriver().findElements(By.id(id));
    return text.size() > 0;
  }

  /**
   * Je nastaven priznak zahranicniho studenta
   *
   * @return true - je nastaven, false - neni nastaven
   */
  public static boolean isZahranicni() {
    WebElement checkBox = Drivers.getDriver().findElement(By.id(Id.GEN_CHKBOX_ZAHR));
    return checkBox.isSelected();
  }
}
