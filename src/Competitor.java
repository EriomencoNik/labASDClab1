import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.lang.String;

/*4. участники соревнования
        а) фамилия
        б) имя
        в) страна
        г) категория (IV, III, II, I, NM, IM)
        д) год рождения
        е) номер в таблице*/
public class Competitor implements Comparable {
    private String name;
    private String surname;
    private String country;
    private int yearOfBirthday;
    private Category category;
    private int numberInTable;

    public int getNumberInTable() {
        return numberInTable;
    }

    ///Constructor with no args
    public Competitor() {
    }

    ///Constructor with args
    public Competitor(String name, String surname, String country, int dateOfBirthday, Category category, int numberInTable) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.yearOfBirthday = dateOfBirthday;
        this.category = category;
        this.numberInTable = numberInTable;
    }

    ///Constructor from string
    public Competitor(String csvLine) {
        String[] arrParam = csvLine.split(";");
        name = arrParam[0];
        surname = arrParam[1];
        country = arrParam[2];
        yearOfBirthday = Integer.parseInt(arrParam[3]);
        numberInTable = Integer.parseInt(arrParam[4]);
        category = Category.valueOf(arrParam[5]);
    }

    ///Constructor copy
    public Competitor(Competitor comp) {
        this.name = comp.name;
        this.surname = comp.surname;
        this.country = comp.country;
        this.category = comp.category;
        this.yearOfBirthday = comp.yearOfBirthday;
        this.numberInTable = comp.numberInTable;
    }

    ///Copying method
    public static Competitor copy(Competitor comp) {
        String name = comp.name;
        String surname = comp.surname;
        String country = comp.country;
        Category category = comp.category;
        int yearOfBirthday = comp.yearOfBirthday;
        int numberInTable = comp.numberInTable;
        return new Competitor(name, surname, country, yearOfBirthday, category, numberInTable);
    }

    ///Equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Competitor that = (Competitor) o;
        return yearOfBirthday == that.yearOfBirthday &&
                numberInTable == that.numberInTable &&
                name.equals(that.name) &&
                surname.equals(that.surname) &&
                country.equals(that.country) &&
                category == that.category;
    }

    ///Input stream
    public static ArrayList<Competitor> input(String resource) {
        ArrayList<Competitor> competitorList = new ArrayList<>();
        if (resource.startsWith("/")) {
            File file = new File(resource);
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String st;
                while ((st = br.readLine()) != null) {
                    if (st.isEmpty()) {
                    } else {
                        competitorList.add(new Competitor(st));
                    }
                }
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
        } else {
            String[] array = resource.split("/n");
            for (String str : array) {
                competitorList.add(new Competitor(str));
            }
        }
        return competitorList;
    }

    ///Object to csv format
    ///Chickie;Hoggan;Madagascar;1989;47;IM
    public String competitorToString() {
        String name = this.name;
        String surname = this.surname;
        String country = this.country;
        String year = String.valueOf(this.yearOfBirthday);
        String number = String.valueOf(this.numberInTable);
        String category = String.valueOf(this.category);
        return new String(name + ";" + surname + ";" + country + ";" + year + ";" + number + ";" + category);
    }

    ///Output stream
    public static void output(ArrayList<Competitor> competitors, String resources) {
        if (resources.startsWith(".\\")) {
            File file = new File(resources);
            try {
                FileWriter fileWriter = new FileWriter(file);
                for (Competitor comp : competitors) {
                    fileWriter.write(comp.competitorToString() + "\n");
                }
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            System.out.println("Передаваемая строка не является путем к файлу");
        }
    }

    public static void output(ArrayList<Competitor> competitors) {
        for (Competitor comp : competitors) {
            System.out.println(comp.toString());
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, country, yearOfBirthday, category, numberInTable);
    }

    @Override
    public int compareTo(Object competitor) {
        int comparNumber = ((Competitor) competitor).getNumberInTable();
        return this.numberInTable - comparNumber;
    }

    @Override
    public String toString() {
        return "Competitor{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", country='" + country + '\'' +
                ", yearOfBirthday=" + yearOfBirthday +
                ", category=" + category +
                ", numberInTable=" + numberInTable +
                '}';
    }
}