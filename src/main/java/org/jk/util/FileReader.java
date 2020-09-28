package org.jk.util;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.jk.entity.Company;
import org.jk.exception.FileReadException;

public class FileReader {
    public static List<Company> readFromFile(String filePath) {
        List<Company> companies = new ArrayList<>();
        try {
            Files.lines(Paths.get(filePath)).skip(1).forEach(line -> {
                String[] arr = line.split("\t");
                Company company = Company.setCompanyData(arr);
                companies.add(company);
            });
        } catch (Exception e) {
            throw new FileReadException(e.getMessage());
        }
        return companies;
    }
}
