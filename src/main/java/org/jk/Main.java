package org.jk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static final String FILE_PATH = "src/test/resources/FILE.DAT";
    static List<Company> companies = new ArrayList<Company>();

    public static void main(String[] args) {
        readFromFile();
        Map<String, Double> map = groupByCountry();
        Map<String, Double> map2 = groupByCity();
        System.out.println(map);
        System.out.println(map2);
    }

    private static Map<String, Double> groupByCity() {
        // Determining average amount grouped by city
        Map<String, Double> map2 = companies.stream()
                .filter(c -> isNotEmpty(c.getCity()))
                .collect(Collectors.groupingBy(Company::getCity, Collectors.averagingDouble(Company::getAmount)));
        return map2;
    }

    private static Map<String, Double> groupByCountry() {
        // Determining average amount grouped by country
        Map<String, Double> map = companies.stream()
                .filter(c -> isNotEmpty(c.getCountry()))
                .collect(
                        Collectors.groupingBy(Company::getCountry, Collectors.averagingDouble(Company::getAmount)));
        return map;
    }


    private static void readFromFile() {
        try {
            Files.lines(Paths.get(FILE_PATH)).skip(1).forEach(line -> {
                String[] arr = line.split("\t");
                Company company = setCompanyData(arr);
                companies.add(company);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Boolean isNotEmpty(String country) {
        return (!country.equals("") && country != null);
    }

    /**
     * @param arr
     * @return
     */
    private static Company setCompanyData(String[] arr) {
        Company company = new Company();
        company.setCompanyCode(arr[0]);
        company.setAccount(arr[1]);
        company.setCity(arr[2]);
        company.setCountry(arr[3]);
        company.setCurrency(arr[4]);
        company.setCreditRating(arr[5]);
        company.setAmount(amountInEuro(Double.parseDouble(arr[6]), arr[4]));
        return company;
    }

    /**
     * Convert the amount in Euros from the given currency.
     *
     * @param am       amount to be converted
     * @param currency the currency such as USD, GBP etc.
     * @return
     */
    private static double amountInEuro(double am, String currency) {
        double amount;
        switch (currency) {
            case "EUR":
                amount = 1.12 * am;
                break;
            case "GBP":
                amount = 1.26 * am;
                break;
            case "CHF":
                amount = 1.04 * am;
            default:
                amount = am;
        }
        return amount;
    }
}
