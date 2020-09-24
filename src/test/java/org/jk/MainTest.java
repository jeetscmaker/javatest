package org.jk;

import com.sun.istack.internal.NotNull;
import org.jk.entity.Company;
import org.jk.util.FileReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainTest {
    List<Company> companyList;
    @Before
    public void init(){
        companyList = FileReader.readFromFile();
    }

    @Test
    public void test_groupByCountry(){
        Map<String, Double> expectedResult = setCountryAvgAmtMap();
        Map<String, Double> actualResult = Main.groupByCountry(companyList);
        Assert.assertTrue(expectedResult.equals(actualResult));
    }

    @Test
    public void test_groupByCity(){
        //TODO similar test as done for groupByCountry.
    }

    @NotNull
    public static Map<String, Double> setCountryAvgAmtMap() {
        Map<String, Double> expectedResult = new HashMap<>();
        expectedResult.put("NOR", 6.963759410333333E8);
        expectedResult.put("RUS", 1.121708149E8);
        expectedResult.put("IRL", 5.897011590999999E8);
        expectedResult.put("USA", 4776788.659294);
        expectedResult.put("UK", 0.009961674610773722);
        expectedResult.put("DK", 6.1037790515E8);
        expectedResult.put("IND", 8.362118899E8);
        return expectedResult;
    }
}
