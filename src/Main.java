import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();

        ArrayList<Covid19Data> covid19Data = fileHandler.loadAllData();

        System.out.println("Hvad skal primær sortering være?");
        System.out.println("1. Region\n2. Aldersgruppe");
        Scanner userInput = new Scanner(System.in);
        int primærValg = userInput.nextInt();

        Comparator<Covid19Data> comparator = null;
        if (primærValg == 1){
            comparator = new RegionComparator(); //sortere efter region først
        } else if(primærValg == 2){
            comparator = new AldersGruppeComparator(); //sortere efter aldersgruppe først
        } else {
            System.out.println("Ugyldigt input, prøv igen.");
            userInput.nextInt();
        }

        System.out.println("Hvad skal sekundær sortering være?");
        System.out.println("1. Region\n2. Aldersgruppe");
        int sekundærValg = userInput.nextInt();

        if(sekundærValg == 1){
            comparator = comparator.thenComparing(new RegionComparator());
        } else if (sekundærValg == 2){
            comparator = comparator.thenComparing(new AldersGruppeComparator());
        } else {
            System.out.println("Ugyldigt input, prøv igen");
            userInput.nextInt();
        }

        Collections.sort(covid19Data,comparator);
        System.out.println("SUCCES: dataen er nu sorteret efter dine valg af primær- og sekundær sortering.");

        for (Covid19Data covid19Data2 : covid19Data){
            System.out.println(covid19Data2);
        }


    }

}
/*
------OPGAVE: BRUGER HAR MULIGHED FOR AT VÆLGE MELLEM AT SORTERE DATA EFTER REGION ELLER ALDERSGRUPPE----------
System.out.println("Hvad skal dataen sorteres efter?");
        System.out.println("1. Region\n2. Aldersgruppe");
        Scanner userInput = new Scanner(System.in);
        int userChoice = userInput.nextInt();

        if (userChoice == 1){
            Collections.sort(covid19Data,new RegionComparator()); //sortere efter region
        } else if(userChoice == 2){
            Collections.sort(covid19Data,new AldersGruppeComparator()); //sortere efter aldersgruppe
        } else {
            System.out.println("Ugyldigt input, prøv igen.");
            userInput.nextInt();
        }

        for (Covid19Data covid19Data2 : covid19Data){
            System.out.println(covid19Data2);
        }
 */
