import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
      //  ArrayList<Competitor> array = Competitor.input("/Users/alexeriomenco/Desktop/nik/lab0Opt/src/MOCK_DATA.csv");
        ArrayList<Competitor> array = Competitor.input("/Users/alexeriomenco/Desktop/nik/labASDClab1/src/MOCK_DATA.csv");
        ArrayList<Competitor> ar = Competitor.input("Chickie;Hoggan;Madagascar;1989;47;IM/nChickie;Hoggan;Madagascar;1989;47;IM");
        Competitor.output(array, "/Users/alexeriomenco/Desktop/nik/labASDClab1/src/MOCK_DATA2.csv");
        Competitor.output(ar);
        ArrayList<Competitor> array2 = Competitor.input("/Users/alexeriomenco/Desktop/nik/labASDClab1/src/MOCK_DATA2.csv");
        Competitor.output(array2);
    }
}