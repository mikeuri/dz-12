import org.testdata.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = "minimalTest")
public class TestPartnershipRegistration extends TestData
{
    @Test(groups = "smokeTest")
    public void testPartnershipRegistrationWoman() {
        woman1.registerPartnership(man3); //Man man3 = new Man("Winston", "Cox", 65, null);
        Assert.assertEquals(woman1.getPartner(), man3);
        Assert.assertEquals(man3.getPartner(), woman1);
        Assert.assertEquals(woman1.getLastName(), man3.getLastName());
    }

    @Test (priority = 1)
    public void testPartnershipRegistrationMan() {
        man2.registerPartnership(woman3);
        Assert.assertEquals(man2.getPartner(), woman3);
        Assert.assertEquals(woman3.getPartner(), man2);
        Assert.assertEquals(woman3.getLastName(), man2.getLastName());
    }

    @Test (priority = 2)
    public void testRegistrationIfSomeoneHasPartner() {
        //registration partnership for woman if some person already has partner which is not allowed CASE1
        woman1.registerPartnership(man4); //woman has partner, men doesn't have
        Assert.assertNotEquals(woman1.getPartner(), man4);

        //registration partnership for woman if some person already has partner which is not allowed CASE2
        woman4.registerPartnership(man2); //woman doesn't have partner, men has
        Assert.assertNotEquals(woman4.getPartner(), man2);

        //registration partnership for man if some person already has partner which is not allowed CASE1
        man4.registerPartnership(woman1); //man doesn't have, woman has partner
        Assert.assertNotEquals(man4.getPartner(), woman1);

        //registration partnership for man if some person already has partner which is not allowed CASE1
        man2.registerPartnership(woman4); //man has partner, woman doesn't have
        Assert.assertNotEquals(man2.getPartner(), woman4);
    }

    @Test (priority = 3)
    public void testRegistrationTheSameGender() {
        //registration partnership of the same gender for woman (which is not allowed)
        woman4.registerPartnership(woman5);
        Assert.assertNotEquals(woman4.getPartner(), woman5);

        //registration partnership of the same gender for man (which is not allowed)
        man4.registerPartnership(man5);
        Assert.assertNotEquals(man4.getPartner(), man4);
    }
}
