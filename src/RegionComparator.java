import java.util.Comparator;

public class RegionComparator implements Comparator<Covid19Data> {
    public int compare(Covid19Data covidData1, Covid19Data covidData2){
        int result = covidData1.getRegion().compareToIgnoreCase(covidData2.getRegion());

        return result;

    }


}
