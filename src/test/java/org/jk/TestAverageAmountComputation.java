package org.jk;

import org.jk.entity.Company;
import org.jk.util.FileReader;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestAverageAmountComputation {
    private static final String FILE_PATH = "src/main/resources/FILE.DAT";
    List<Company> companyList;

    @Before
    public void init() {
        companyList = FileReader.readFromFile(FILE_PATH);
    }

    @Test
    public void test_groupByCountry() {
        Map<String, Double> expectedResult = setCountryAvgAmtMap();
        Map<String, Double> actualResult = AverageAmountComputation.groupByCountry(companyList);
        assertTrue(expectedResult.equals(actualResult));
    }

    @Test
    public void test_groupByCreditRating() {

    }

    public static Map<String, Double> setCountryAvgAmtMap() {
        Map<String, Double> expectedResult = new HashMap<>();
        expectedResult.put("NOR", 7.282878567202381E8);
        expectedResult.put("RUS", 1.0415861383571428E8);
        expectedResult.put("IRL", 6.072247691133928E8);
        expectedResult.put("USA", -3.6234675858792218E17);
        expectedResult.put("UK", -5665007.254685973);
        expectedResult.put("DK", 6.27451862880357E8);
        expectedResult.put("IND", 7.76482469192857E8);
        return expectedResult;
    }
}
