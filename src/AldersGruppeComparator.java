import java.util.Comparator;

public class AldersGruppeComparator implements Comparator<Covid19Data> {
    public int compare(Covid19Data covid19Data1, Covid19Data covid19Data2){
        int result = covid19Data1.getAldersgruppe().compareToIgnoreCase(covid19Data2.getAldersgruppe());

        return result;

    }

}
