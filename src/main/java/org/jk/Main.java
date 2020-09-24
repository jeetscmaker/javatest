package org.jk;

import org.jk.entity.Company;
import org.jk.util.FileReader;
import org.jk.util.Util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Company> companies = FileReader.readFromFile();
        Map<String, Double> map = groupByCountry(companies);
        Map<String, Double> map2 = groupByCity(companies);
        System.out.println(map);
        System.out.println(map2);
    }

    /* Average amount in EURO grouped by country */
    public static Map<String, Double> groupByCountry(List<Company> companies) {
        Map<String, Double> averageAmountByCountry = companies.stream()
                .filter(c -> Util.isNotEmpty(c.getCountry()))
                .collect(
                        Collectors.groupingBy(Company::getCountry, Collectors.averagingDouble(Company::getAmount)));
        return averageAmountByCountry;
    }

    /* Average amount in EURO grouped by city */
    public static Map<String, Double> groupByCity(List<Company> companies) {
        Map<String, Double> averageAmountByCity = companies.stream()
                .filter(c -> Util.isNotEmpty(c.getCity()))
                .collect(Collectors.groupingBy(Company::getCity, Collectors.averagingDouble(Company::getAmount)));
        return averageAmountByCity;
    }
}
