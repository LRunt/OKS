package oks03;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PripravaDatovehoZdroje {

    private static List<String> nacteniSouboru(){
        List<String> platneRadky = new ArrayList<>();

        //String soubor = System.getProperty("datovy.zdroj.oks03");
        String soubor = "priklady-oks-03.txt";

        try {
            List<String> seznamRadek = Files.readAllLines(Paths.get(soubor));
            for(String radka : seznamRadek) {
                if(!radka.contains("#") && !radka.equals("")){
                    platneRadky.add(radka);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return platneRadky;
    }

    static List<Object[]> listDvojiceBooleanString(){
        List<String> radky = nacteniSouboru();
        List<Object[]> generovano = new ArrayList<>();

        for(String radka : radky) {
            String[] rozdeleno = radka.split(";");
            Object[] dvojice = new Object[2];
            dvojice[0] = rozdeleno[0];
            dvojice[1] = rozdeleno[1];
            generovano.add(dvojice);
        }

        return generovano;
    }
}
