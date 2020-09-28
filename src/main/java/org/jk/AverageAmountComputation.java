package org.jk;

import org.jk.entity.Company;
import org.jk.util.FileReader;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class AverageAmountComputation {
    private static final String FILE_PATH = "src/main/resources/FILE.DAT";

    public static void main(String[] args) {
        List<Company> companies = FileReader.readFromFile(FILE_PATH);
        Map<String, Double> map = groupByCountry(companies);
        Map<String, Double> map2 = groupByCreditRating(companies);
        System.out.println(map);
        System.out.println(map2);
    }

    /* Average amount in EURO grouped by country */
    public static Map<String, Double> groupByCountry(List<Company> companies) {
        Map<String, Double> averageAmountByCountry = companies.stream()
                .filter(c -> isNotEmpty(c.getCountry()))
                .collect(
                        Collectors.groupingBy(Company::getCountry, Collectors.averagingDouble(Company::getAmount)));
        return averageAmountByCountry;
    }

    /* Average amount in EURO grouped by Credit rating */
    public static Map<String, Double> groupByCreditRating(List<Company> companies) {
        Map<String, Double> averageAmountByCreditRating = companies.stream()
                .filter(c -> isNotEmpty(c.getCreditRating()))
                .collect(Collectors.groupingBy(Company::getCreditRating, Collectors.averagingDouble(Company::getAmount)));
        return averageAmountByCreditRating;
    }
}
