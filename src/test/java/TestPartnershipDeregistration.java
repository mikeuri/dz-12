import org.example.Person;
import org.testdata.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = "minimalTest")
public class TestPartnershipDeregistration extends TestData
{
    @Test(groups = "smokeTest")
    public void testDeregistrationForWomanWithReverting() {

        woman1.registerPartnership(man5);
        Person woman1FormerPartner = woman1.getPartner();
        woman1.deRegisterPartnership(true);

        Assert.assertNull(woman1.getPartner());
        Assert.assertNull(woman1FormerPartner.getPartner());
        Assert.assertEquals(woman1.getLastName(), woman1.initLastName);
    }

    @Test (priority = 1)
    public void testDeregistrationForWomanWithoutReverting() {

        woman3.registerPartnership(man4);
        Person woman3FormerPartner = woman3.getPartner();
        woman3.deRegisterPartnership(false);

        Assert.assertNull(woman3.getPartner());
        Assert.assertNull(woman3FormerPartner.getPartner());
        Assert.assertNotEquals(woman3.getLastName(), woman3.initLastName);
    }

    @Test (priority = 2)
    public void testDeregistrationForManWithReverting() {
        Person man1FormerPartner = man1.getPartner();
        man1.deRegisterPartnership(true);

        Assert.assertNull(man1.getPartner());
        Assert.assertNull(man1FormerPartner.getPartner());
        Assert.assertEquals(man1FormerPartner.getLastName(), man1FormerPartner.initLastName);
    }
}
