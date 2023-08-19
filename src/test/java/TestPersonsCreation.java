import org.example.Man;
import org.example.Person;
import org.example.Woman;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@Test(groups = "minimalTest")
public class TestPersonsCreation
{
    @DataProvider
    public Object[][] testDataMan() {
        return new Object[][]{
                {"Kelsey", "Gardner", 43, null, "male"},
                {"Christopher", "Glisson", 89, null, "male"},
        };
    }

    @Test(dataProvider = "testDataMan", groups = "smokeTest")
    public void testManParameters(String name, String lastName, Integer age, Person partner, String expectedGender) {
        Man man = new Man(name, lastName, age, partner);

        Assert.assertEquals(man.getLastName(), lastName);
        Assert.assertEquals(man.getFullName(), name + " " + lastName);
        Assert.assertEquals(man.getAge(), age);
        Assert.assertNull(man.getPartner());
        Assert.assertEquals(man.getGender(), expectedGender);
    }

    @DataProvider
    public Object[][] testDataWoman() {
        return new Object[][]{
                {"Penelope", "Marshall", 60, null, "female"},
                {"Belinda", "Stephens", 42, null, "female"},
        };
    }

    @Test (dataProvider = "testDataWoman", priority = 1)
    public void testWomanParameters(String name, String lastName, Integer age, Person partner, String expectedGender) {
        Woman woman = new Woman(name, lastName, age, partner);

        Assert.assertEquals(woman.getLastName(), lastName);
        Assert.assertEquals(woman.getFullName(), name + " " + lastName);
        Assert.assertEquals(woman.getAge(), age);
        Assert.assertNull(woman.getPartner());
        Assert.assertEquals(woman.getGender(), expectedGender);
    }

    @Test (priority = 2)
    public void testPartnersAfterInitialisation() {
        Man man1 = new Man("Kelsey", "Gardner", 43, null);
        Woman woman2 = new Woman("Belinda", "Stephens", 42, man1); //adding partner on init

        Assert.assertEquals(woman2.getPartner(), man1);
        Assert.assertEquals(man1.getPartner(), woman2);
    }
}
