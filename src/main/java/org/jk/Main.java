package org.jk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        try {
            List<Company> companies = new ArrayList<Company>();
            Files.lines(Paths.get("src/test/resources/FILE.DAT")).skip(1).forEach(line -> {
                String[] arr = line.split("\t");
                Company company = setCompanyData(arr);
                System.out.println(company);
            });

            // Determining average amount grouped by country
            Map<String, Double> map = companies.stream()
                    .filter(c -> isNotEmpty(c.getCountry()))
                    .collect(
                            Collectors.groupingBy(Company::getCountry, Collectors.averagingDouble(Company::getAmount)));

            // Determining average amount grouped by city
            Map<String, Double> map2 = companies.stream()
                    .filter(c -> isNotEmpty(c.getCity()))
                    .collect(Collectors.groupingBy(Company::getCity, Collectors.averagingDouble(Company::getAmount)));
            System.out.println(map);
            System.out.println(map2);
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
