package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //değişken isimlerinde java'da camelCase yazılır.
        String ortaMetin = "İlginizi Çekebilir";
        String altMetin = "Vade Süresi";

        System.out.println(ortaMetin);

        // Integer
        int vade = 12;

        // Double
        double dolarDun = 28.05;
        double dolarBugun = 28.05;

        // String
        String okYonu = "";

        //Boolean
        boolean dolarDustuMu = false;

        // If - Else If - Else
        if (dolarBugun<dolarDun){ //false
            okYonu = "down.svg";
            dolarDustuMu = true;
            System.out.println(okYonu);
        } else if (dolarBugun>dolarDun) { //false
            okYonu = "up.svg";
            dolarDustuMu = false;
            System.out.println(okYonu);
        } else { // Mevcut şartlarda buraya girecek
            okYonu = "equal.svg";
            dolarDustuMu = false;
            System.out.println(okYonu);
        }

        // Array
        String[] krediler = {"Hızlı Kredi", "Maaşını Halkbanktan","Mutlu Emekli"};

        // For Döngüsü
        for (int i = 0; i < krediler.length; i++){
            System.out.println(krediler[i]);
        }
        /*
        Yukarıdaki for döngüsünün sırayla yaptığı iş
        System.out.println(krediler[0]);
        System.out.println(krediler[1]);
        System.out.println(krediler[2]);
         */
    }
}