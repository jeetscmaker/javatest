package org.jk.util;

import org.jk.entity.Company;
import org.jk.exception.FileReadException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestFileReader {
    private static final String FILE_PATH = "src/test/resources/FILE.DAT";
    List<Company> companies;
    @Before
    public void init(){
        companies = new ArrayList<>();
        setupData();
    }

    @Test
    public void test_readFromFile(){
        List<Company> companyList = FileReader.readFromFile(FILE_PATH);
        Company actual = companyList.get(0);
        Company expected = companies.get(0);
        assertEquals(expected.getCompanyCode(), actual.getCompanyCode());
        assertEquals(expected.getAccount(), actual.getAccount());
        assertEquals(expected.getCity(), actual.getCity());
        assertEquals(expected.getCountry(), actual.getCountry());
        assertEquals(expected.getCreditRating(), actual.getCreditRating());
        assertEquals(expected.getCurrency(), actual.getCurrency());
    }

    @Test(expected = FileReadException.class)
    public void test_readFromFile_Error(){
       FileReader.readFromFile(null);
    }

    private void setupData() {
        Company com = new Company();
        com.setCompanyCode("2305");
        com.setAccount("1702200");
        com.setCountry("IRL");
        com.setCity("Dublin");
        com.setCreditRating("Aa");
        com.setCurrency("CHF");
        com.setAmount(572106536.9);
        companies.add(com);
    }
}
