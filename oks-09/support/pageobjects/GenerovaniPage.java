package oks09.support.pageobjects;

import jdk.jshell.execution.Util;
import oks09.support.basic.Const;
import oks09.support.utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerovaniPage extends PageObject {
  public static final String LABEL_FAKULTA = "label_fakulta";
  public static final String SELECT_FAKULTA = "fakulta";
  public static final String CHYBA_FAKULTA = "chyba_fakulta";

  public static final String LABEL_ROK = "label_rok_nastupu";
  public static final String INPUT_ROK = "rok_nastupu";
  public static final String CHYBA_ROK = "chyba_rok_nastupu";

  public static final String LABEL_TYP = "label_typ_studia";
  public static final String SELECT_TYP = "typ_studia";

  public static final String LABEL_PORADI = "label_poradove_cislo";
  public static final String INPUT_PORADI = "poradove_cislo";
  public static final String CHYBA_PORADI = "chyba_poradove_cislo";

  public static final String LABEL_FORMA = "label_forma_studia";
  public static final String RADBTN_FORM_PREZ = "forma_prezencni";
  public static final String LABEL_FORM_PREZ = "label_forma_prezencni";
  public static final String RADBTN_FORM_KOMB = "forma_kombinovana";
  public static final String LABEL_FORM_KOMB = "label_forma_kombinovana";
  public static final String RADBTN_FORM_DIST = "forma_distancni";
  public static final String LABEL_FORM_DIST = "label_forma_distancni";
  public static final String CHYBA_FORMA = "chyba_forma_studia";

  public static final String LABEL_ZAHR = "label_zahranicni";
  public static final String CHKBOX_ZAHR = "zahranicni";

  public static final String BUTTON_GENEROVANI = "generovani";
  public static final String BUTTON_MAZANI = "mazani";

  public static final String TEXT_VYSLEDEK = "vysledek";

  public static final String CHYBA_CELKOVA = "chyba_celkova";

  public ZalozkyPage zalozky = new ZalozkyPage();

  public static Map<String, String> NAZVY_VYBERU_TYP;

  static{
    nastavNazvyTypu();
  }

  private static void nastavNazvyTypu() {
    NAZVY_VYBERU_TYP = new HashMap<>();
    NAZVY_VYBERU_TYP.put("b", "bakalářský");
    NAZVY_VYBERU_TYP.put("n", "navazující");
    NAZVY_VYBERU_TYP.put("m", "magisterský");
    NAZVY_VYBERU_TYP.put("d", "doktorský");
  }

  /////////////////////////
  @FindBy(id=INPUT_ROK)
  private List<WebElement> inputRok;

  public void setRokNastupu(String rok) {
    WebElement vstup = getElement(inputRok, INPUT_ROK);
    vstup.clear();
    vstup.sendKeys(rok);
  }

  //////////////
  @FindBy(id=BUTTON_GENEROVANI)
  private List<WebElement> btnGenerovani;

  public GenerovaniPage clickGenerovani() {
    Utils.clickAndWaitURL(getElement(btnGenerovani, BUTTON_GENEROVANI), Const.URL_GENEROVANI);
    return new GenerovaniPage();
  }

  @FindBy(id=SELECT_FAKULTA)
  private List<WebElement> fakultaSelect;

  public void setFakulta(String zkratkaFakulty) {
    WebElement seznam = getElement(fakultaSelect, SELECT_FAKULTA);
    Select select = new Select(seznam);
    select.selectByVisibleText(Utils.NAZVY_VYBERU_FAKULTA.get(zkratkaFakulty));
  }

  @FindBy(id=SELECT_TYP)
  private List<WebElement> typSelect;

  public void setTyp(String typ) {
    WebElement seznam = getElement(typSelect, SELECT_TYP);
    Select select = new Select(seznam);
    select.selectByVisibleText(NAZVY_VYBERU_TYP.get(typ));
  }

  @FindBy(id=INPUT_PORADI)
  private List<WebElement> inputPoradi;

  public void setPoradi(String poradi) {
    WebElement input = getElement(inputPoradi, INPUT_PORADI);
    input.clear();
    input.sendKeys(poradi);
  }

  @FindBy(id=RADBTN_FORM_PREZ)
  private List<WebElement> radioPrez;

  @FindBy(id=RADBTN_FORM_KOMB)
  private List<WebElement> radioKomb;

  @FindBy(id=RADBTN_FORM_DIST)
  private List<WebElement> radioDist;

  public void setForma(String idForma) {
    WebElement radioButton = null;
    if(idForma.equals("p")){
      radioButton = getElement(radioPrez, RADBTN_FORM_PREZ);
    }else if(idForma.equals("k")){
      radioButton = getElement(radioKomb, RADBTN_FORM_KOMB);
    }else if(idForma.equals("d")){
      radioButton = getElement(radioDist, RADBTN_FORM_DIST);
    }
    if(!radioButton.isSelected()){
      radioButton.click();
    }
  }

  @FindBy(id=CHKBOX_ZAHR)
  private List<WebElement> checkboxZahr;

  public void setZahranicni(String zahr) {
    WebElement checkBox = getElement(checkboxZahr, CHKBOX_ZAHR);
    boolean isZahranicni = zahr.equals("i");
    if(checkBox.isSelected() != isZahranicni){
      checkBox.click();
    }
  }

  @FindBy(id=TEXT_VYSLEDEK)
  private List<WebElement> stringOsobniCislo;

  public String getGenerovaneCislo() {
    WebElement vysledek = getElement(stringOsobniCislo, TEXT_VYSLEDEK);;
    return vysledek.getText();
  }

}
