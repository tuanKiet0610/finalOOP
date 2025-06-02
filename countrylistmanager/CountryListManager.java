package countrylistmanager;


import java.util.*;

public class CountryListManager {
    // Singleton pattern
    private static CountryListManager instance;

    private List<AbstractCountry> countryList;

    private CountryListManager() {
        countryList = new LinkedList<>();
    }

    public static CountryListManager getInstance() {
        if (instance == null) {
            instance = new CountryListManager();
        }
        return instance;
    }

    public List<AbstractCountry> getCountryList() {
        return this.countryList;
    }

    public void append(AbstractCountry country) {
        /* TODO */
        if (country != null) {
            countryList.add(country);
        }
    }

    public void add(AbstractCountry country, int index) {
        /* TODO */
        if (index >-1 & index<=countryList.size() & country!= null) {
            countryList.add(index,country);
        }
    }

    public void remove(int index) {
        /* TODO */
        if (index >-1& index<countryList.size()) {
            countryList.remove(index);
        }
    }

    public void remove(AbstractCountry country) {
        /* TODO */
        if (country!=null) {
            countryList.remove(country);
        }
    }

    public AbstractCountry countryAt(int index) {
        /* TODO */
        if (index>= 0 & index<countryList.size()) {
            return countryList.get(index);
        }
        return null;
    }

    public List<AbstractCountry> sortPopulationIncreasing() {
        List<AbstractCountry> newList = new LinkedList<>(this.countryList);
        Collections.sort(newList, new Comparator<AbstractCountry>() {
            @Override
            public int compare(AbstractCountry left, AbstractCountry right) {
                return left.getPopulation() - right.getPopulation();
            }
        });
        return newList;
    }

    public List<AbstractCountry> sortPopulationDecreasing() {
        List<AbstractCountry> newList = new LinkedList<>(this.countryList);
        Collections.sort(newList, new Comparator<AbstractCountry>() {
            @Override
            public int compare(AbstractCountry left, AbstractCountry right) {
                return right.getPopulation() - left.getPopulation();
            }
        });
        return newList;
    }

    public List<AbstractCountry> sortAreaIncreasing() {
        List<AbstractCountry> newList = new LinkedList<>(this.countryList);
        Collections.sort(newList, new Comparator<AbstractCountry>() {
            @Override
            public int compare(AbstractCountry left, AbstractCountry right) {
                return Double.compare(left.getArea(),right.getArea());
            }
        });
        return newList;
    }

    public List<AbstractCountry> sortAreaDecreasing() {
        List<AbstractCountry> newList = new LinkedList<>(this.countryList);
        Collections.sort(newList, new Comparator<AbstractCountry>() {
            @Override
            public int compare(AbstractCountry left, AbstractCountry right) {
                return Double.compare(right.getArea(),left.getArea());
            }
        });
        return newList;
    }

    public List<AbstractCountry> sortGdpIncreasing() {
        List<AbstractCountry> newList = new LinkedList<>(this.countryList);
        Collections.sort(newList, new Comparator<AbstractCountry>() {
            @Override
            public int compare(AbstractCountry left, AbstractCountry right) {
                return Double.compare(left.getGdp(),right.getGdp());
            }
        });
        return newList;
    }

    public List<AbstractCountry> sortGdpDecreasing() {
        List<AbstractCountry> newList = new LinkedList<>(this.countryList);
        Collections.sort(newList, new Comparator<AbstractCountry>() {
            @Override
            public int compare(AbstractCountry left, AbstractCountry right) {
                return Double.compare(right.getGdp(), left.getGdp());
            }
        });
        return newList;
    }

    public List<AbstractCountry> filterContinent(String continent) {
        List<AbstractCountry> list = null;
        switch (continent) {
            case "Asia":
                list = new ArrayList<>();
                for (AbstractCountry country : countryList) {
                    if (country instanceof AsiaCountry) {
                        list.add(country);
                    }
                }
                break;
            case "North America":
                list = new ArrayList<>();
                for (AbstractCountry country : countryList) {
                    if (country instanceof NorthAmericaCountry) {
                        list.add(country);
                    }
                }
                break;
            case "South America":
                list = new ArrayList<>();
                for (AbstractCountry country : countryList) {
                    if (country instanceof SouthAmericaCountry) {
                        list.add(country);
                    }
                }
                break;
            case "Africa":
                list = new ArrayList<>();
                for (AbstractCountry country : countryList) {
                    if (country instanceof AfricaCountry) {
                        list.add(country);
                    }
                }
                break;
            case "Europe":
                list = new ArrayList<>();
                for (AbstractCountry country : countryList) {
                    if (country instanceof EuropeCountry) {
                        list.add(country);
                    }
                }
                break;
            case "Oceania":
                list = new ArrayList<>();
                for (AbstractCountry country : countryList) {
                    if (country instanceof OceaniaCountry) {
                        list .add(country);
                    }
                }
        }
        return list;
    }

    public List<AbstractCountry> filterCountriesMostPopulous(int howMany) {
        AbstractCountry[] array = new AbstractCountry[countryList.size()];
        for (int i = 0; i < countryList.size(); i++) {
            array[i] = sortPopulationDecreasing().get(i);
        }
        array = Arrays.copyOf(array,howMany);
        List<AbstractCountry> result = new LinkedList<>();
        return Arrays.asList(array);
    }

    public List<AbstractCountry> filterCountriesLeastPopulous(int howMany) {
        AbstractCountry[] array = new AbstractCountry[countryList.size()];
        for (int i = 0; i < countryList.size(); i++) {
            array[i] = sortPopulationIncreasing().get(i);
        }
        array = Arrays.copyOf(array,howMany);
        List<AbstractCountry> result = new LinkedList<>();
        return Arrays.asList(array);
    }

    public List<AbstractCountry> filterCountriesLargestArea(int howMany) {
        AbstractCountry[] array = new AbstractCountry[countryList.size()];
        for (int i = 0; i < countryList.size(); i++) {
            array[i] = sortAreaDecreasing().get(i);
        }
        array = Arrays.copyOf(array,howMany);
        List<AbstractCountry> result = new LinkedList<>();
        return Arrays.asList(array);
    }

    public List<AbstractCountry> filterCountriesSmallestArea(int howMany) {
        AbstractCountry[] array = new AbstractCountry[countryList.size()];
        for (int i = 0; i < countryList.size(); i++) {
            array[i] = sortAreaIncreasing().get(i);
        }
        array = Arrays.copyOf(array,howMany);
        List<AbstractCountry> result = new LinkedList<>();
        return Arrays.asList(array);
    }

    public List<AbstractCountry> filterCountriesHighestGdp(int howMany) {
        AbstractCountry[] array = new AbstractCountry[countryList.size()];
        for (int i = 0; i < countryList.size(); i++) {
            array[i] = sortGdpDecreasing().get(i);
        }
        array = Arrays.copyOf(array,howMany);
        List<AbstractCountry> result = new LinkedList<>();
        return Arrays.asList(array);
    }

    public List<AbstractCountry> filterCountriesLowestGdp(int howMany) {
        AbstractCountry[] array = new AbstractCountry[countryList.size()];
        for (int i = 0; i < countryList.size(); i++) {
            array[i] = sortGdpIncreasing().get(i);
        }
        array = Arrays.copyOf(array,howMany);
        List<AbstractCountry> result = new LinkedList<>();
        return Arrays.asList(array);
    }

    public static String codeOfCountriesToString(List<AbstractCountry> countryList) {
        StringBuilder codeOfCountries = new StringBuilder();
        codeOfCountries.append("[");
        for (AbstractCountry country : countryList) {
            codeOfCountries.append(country.getCode()).append(" ");
        }
        return codeOfCountries.toString().trim() + "]";
    }

    public static void print(List<AbstractCountry> countryList) {
        StringBuilder countriesString = new StringBuilder();
        countriesString.append("[");
        for (AbstractCountry country : countryList) {
            countriesString.append(country.toString()).append("\n");
        }
        System.out.print(countriesString.toString().trim() + "]");
    }

}
