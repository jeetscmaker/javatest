package org.jk.util;

import org.jk.entity.Company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private static final String FILE_PATH = "src/test/resources/FILE.DAT";

    public static List<Company> readFromFile() {
        List<Company> companies = new ArrayList<>();
        try {
            Files.lines(Paths.get(FILE_PATH)).skip(1).forEach(line -> {
                String[] arr = line.split("\t");
                Company company = Company.setCompanyData(arr);
                companies.add(company);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return companies;
    }
}
