import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBean;
import org.example.Man;
import org.example.Person;
import org.example.Woman;
import org.example.utils.CSVFileReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

@Test(groups = "minimalTest")
public class TestIsRetired
{
    private enum IsRetiredExpectedStatus
    {
        TRUE,
        FALSE
    }

    @DataProvider
    public Object[][] testDataMan() {
        return new Object[][]{
                {"Kelsey", "Gardner", 43, null, IsRetiredExpectedStatus.FALSE},
                {"Christopher", "Glisson", 89, null, IsRetiredExpectedStatus.TRUE},
                {"Winston", "Cox", 65, null, IsRetiredExpectedStatus.TRUE},
        };
    }

    @Test(dataProvider = "testDataMan", groups = "smokeTest")
    public void testIsRetiredMan(String firstName, String lastName, Integer age, Person partner,
                                 IsRetiredExpectedStatus expectedStatus) {

        Man man = new Man(firstName, lastName, age, partner);

        if (expectedStatus == IsRetiredExpectedStatus.TRUE) {
            Assert.assertTrue(man.isRetired());
        } else {
            Assert.assertFalse(man.isRetired());
        }
    }

    static public class TestDataRecord extends CsvToBean
    {
        @CsvBindByName(column = "first_name")
        private String firstName;

        @CsvBindByName(column = "last_name")
        private String lastName;

        @CsvBindByName(column = "age")
        private Integer age;

        @CsvBindByName(column = "expected_status")
        private String expectedStatus;
    }

    @DataProvider
    public Object[][] parseData() {
        List<TestDataRecord> list = CSVFileReader
                .csvToDataProvider(TestDataRecord.class, "./src/test/resources/personsParsData.csv");
        return list.stream()
                .map(item -> new Object[]{
                        item.firstName,
                        item.lastName,
                        item.age,
                        IsRetiredExpectedStatus.valueOf(item.expectedStatus)
                })
                .toArray(Object[][]::new);
    }

    @Test(dataProvider = "parseData", priority = 1)
    public void testIsRetiredWoman(String firstName, String lastName, Integer age,
                                   IsRetiredExpectedStatus expectedStatus) {
        Woman woman = new Woman(firstName, lastName, age, null);

        if (expectedStatus == IsRetiredExpectedStatus.TRUE) {
            Assert.assertTrue(woman.isRetired());
        } else {
            Assert.assertFalse(woman.isRetired());
        }
    }
}
