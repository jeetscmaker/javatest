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
        Map<String, Double> expectedResult = setCreditRatingAvgAmtMap();
        Map<String, Double> actualResult = AverageAmountComputation.groupByCreditRating(companyList);
        assertTrue(expectedResult.equals(actualResult));
    }

    private Map<String, Double> setCreditRatingAvgAmtMap() {
        Map<String, Double> expectedResult = new HashMap<>();
        expectedResult.put("Aa", 6.072247691133928E8);
        expectedResult.put("a", 8.034010304357143E7);
        expectedResult.put("A", 3.3622099871939844E8);
        expectedResult.put("B", 4.0642396571250004E8);
        expectedResult.put("Aaa-", 1.0415861383571428E8);
        expectedResult.put("BBB", -1.0376293541461623E19);
        expectedResult.put("NR", 6.27451862880357E8);
        expectedResult.put("AAA+", 2.14113993713050291E18);
        expectedResult.put("Aaa+", 7.76482469192857E8);
        expectedResult.put("-", 733073.1571428571);
        return expectedResult;
    }

    private Map<String, Double> setCountryAvgAmtMap() {
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
