package countrylistmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 6) {
                    continue;
                }

                if (dataList.get(0).equals("code")) {
                    continue;
                }

                CountryData newCountryData = new CountryData.CountryDataBuilder(dataList.get(0))
                        .setName(dataList.get(1))
                        .setPopulation(Integer.parseInt(dataList.get(2)))
                        .setArea(Double.parseDouble(dataList.get(3)))
                        .setGdp(Double.parseDouble(dataList.get(4)))
                        .build();
                CountryListManager.getInstance().append(CountryFactory.getInstance().createCountry(dataList.get(5), newCountryData));

                /* TODO
                * Từ dữ liệu nhận được, tạo các đối tượng Country và đưa và CountryListManager để quản lý. 
                */
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void main(String[] args) {
        System.out.println("\n===============================");
        init();
        testOriginalData();
        AbstractCountry testCountry = CountryListManager.getInstance().countryAt(5);
        System.out.println("\nGetting the country at index 5");
        System.out.println(testCountry);
        System.out.println("Removing the country at index 5");
        CountryListManager.getInstance().remove(5);
        testOriginalData();
        System.out.println("\nAdding the country back");
        CountryListManager.getInstance().add(testCountry,5);
        testOriginalData();
        System.out.println("\nRemoving Pakistan country");
        CountryListManager.getInstance().remove(testCountry);
        testOriginalData();
        CountryListManager.getInstance().add(testCountry,5);
        /* TODO */
        System.out.println("\n===============================");
        testSortPopulationIncreasing();
        testSortPopulationDecreasing();

        System.out.println("\n===============================");
        testSortAreaIncreasing();
        testSortAreaDecreasing();

        System.out.println("\n===============================");
        testSortGdpIncreasing();
        testSortGdpDecreasing();

        System.out.println("\n===============================");
        testFilterContinent("Asia");
        testFilterContinent("North America");
        testFilterContinent("South America");
        testFilterContinent("Oceania");
        testFilterContinent("Africa");
        testFilterContinent("Europe");

        System.out.println("\n===============================");
        testFilterCountriesMostPopulous();
        testFilterCountriesLeastPopulous();

        System.out.println("\n===============================");
        testFilterCountriesLargestArea();
        testFilterCountriesSmallestArea();

        System.out.println("\n===============================");
        testFilterCountriesHighestGdp();
        testFilterCountriesLowestGdp();
    }

    public static void init() {
        String filePath = "C:\\Program Files\\JAVAOOP\\JAVAOOP\\src\\brocode\\src\\finalOOP\\src\\countrylistmanager\\countries.csv";
        readListData(filePath);
    }

    public static void testOriginalData() {
        String codes = CountryListManager.getInstance().codeOfCountriesToString(CountryListManager.getInstance().getCountryList());
        System.out.print(codes);
    }

    public static void testSortPopulationIncreasing() {
        /* TODO */
        System.out.println(CountryListManager.codeOfCountriesToString(CountryListManager.getInstance().sortPopulationIncreasing()));
    }

    public static void testSortPopulationDecreasing() {
        /* TODO */
        System.out.println(CountryListManager.codeOfCountriesToString(CountryListManager.getInstance().sortPopulationDecreasing()));
    }

    public static void testSortAreaIncreasing() {
        /* TODO */
        System.out.println(CountryListManager.codeOfCountriesToString(CountryListManager.getInstance().sortAreaIncreasing()));
    }

    public static void testSortAreaDecreasing() {
        /* TODO */
        System.out.println(CountryListManager.codeOfCountriesToString(CountryListManager.getInstance().sortAreaDecreasing()));
    }

    public static void testSortGdpIncreasing() {
        /* TODO */
        System.out.println(CountryListManager.codeOfCountriesToString(CountryListManager.getInstance().sortGdpIncreasing()));
    }

    public static void testSortGdpDecreasing() {
        /* TODO */
        System.out.println(CountryListManager.codeOfCountriesToString(CountryListManager.getInstance().sortGdpDecreasing()));
    }

    public static void testFilterContinent(String continent) {
        /* TODO */
        System.out.println(CountryListManager.codeOfCountriesToString(CountryListManager.getInstance().filterContinent(continent)));
    }

    public static void testFilterCountriesMostPopulous() {
        List<AbstractCountry> countries = CountryListManager.getInstance().sortPopulationDecreasing();
        List<AbstractCountry> nMostPopulousCountries = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nMostPopulousCountries.add(countries.get(i));
        }
        String codeString = CountryListManager.getInstance().codeOfCountriesToString(nMostPopulousCountries);
        System.out.println(codeString);
    }

    public static void testFilterCountriesLeastPopulous() {
        List<AbstractCountry> countries = CountryListManager.getInstance().sortPopulationIncreasing();
        List<AbstractCountry> nLeastPopulousCountries = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nLeastPopulousCountries.add(countries.get(i));
        }

        String codeString = CountryListManager.getInstance().codeOfCountriesToString(nLeastPopulousCountries);
        System.out.println(codeString);
    }

    public static void testFilterCountriesLargestArea() {
        /* TODO */
        System.out.println(CountryListManager.codeOfCountriesToString(CountryListManager.getInstance().filterCountriesLargestArea(5)));
    }

    public static void testFilterCountriesSmallestArea() {
        /* TODO */
        System.out.println(CountryListManager.codeOfCountriesToString(CountryListManager.getInstance().filterCountriesSmallestArea(5)));
    }

    public static void testFilterCountriesHighestGdp() {
        /* TODO */
        System.out.println(CountryListManager.codeOfCountriesToString(CountryListManager.getInstance().filterCountriesHighestGdp(5)));
    }

    public static void testFilterCountriesLowestGdp() {
        /* TODO */
        System.out.println(CountryListManager.codeOfCountriesToString(CountryListManager.getInstance().filterCountriesLowestGdp(5)));
    }

}
