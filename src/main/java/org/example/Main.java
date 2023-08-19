package org.example;

public class Main {
    public static void main(String[] args) {
        //adding men
        Man man1 = new Man("Kelsey", "Gardner", 43, null);
        Man man2 = new Man("Christopher", "Glisson", 89, null);
        Man man3 = new Man("Winston", "Cox", 65, null);
        Man man4 = new Man("Mark", "Brown", 30, null);
        Man man5 = new Man("Dwayne", "Preston", 30, null);

        //adding women
        Woman woman1 = new Woman("Penelope", "Marshall", 60, null);
        Woman woman2 = new Woman("Belinda", "Stephens", 42, man1); //adding partner on init
        Woman woman3 = new Woman("Rebecca", "Blanton", 86, null);
        Woman woman4 = new Woman("Roberta", "Peters", 28, null);
        Woman woman5 = new Woman("Victoria", "Hoffman", 25, null);

        //checking the calculation of isRetired for men
        System.out.println(man1.getFullName() + " is " + man1.getAge() + " and is retired: " + man1.isRetired());
        System.out.println(man3.getFullName() + " is " + man3.getAge() + " and is retired: " + man3.isRetired());
        System.out.println("----------------------------------------------------------------------------");

        //checking the calculation of isRetired for women
        System.out.println(woman1.getFullName() + " is " + woman1.getAge() + " and is retired: " + woman1.isRetired());
        System.out.println(woman2.getFullName() + " is " + woman2.getAge() + " and is retired: " + woman2.isRetired());
        System.out.println("----------------------------------------------------------------------------");

        //checking partners that were set during initialisation
        System.out.println("Partner of " + woman2.getFullName() + " is "+ woman2.getPartner().getFullName());
        System.out.println("Partner of " + woman2.getPartner().getFullName() + " is "+
                woman2.getPartner().getPartner().getFullName());
        System.out.println("----------------------------------------------------------------------------");

        //registration partnership for woman
        woman1.registerPartnership(man3);
        System.out.println("Partner of " + woman1.getFullName() + " is "+ woman1.getPartner().getFullName());
        System.out.println("Partner of " + woman1.getPartner().getFullName() + " is "+
                woman1.getPartner().getPartner().getFullName());
        System.out.println("-------------------------------------");

        //registration partnership for man
        man2.registerPartnership(woman3);
        System.out.println("Partner of " + man2.getFullName() + " is "+ man2.getPartner().getFullName());
        System.out.println("Partner of " + man2.getPartner().getFullName() + " is "+
                man2.getPartner().getPartner().getFullName());
        System.out.println("----------------------------------------------------------------------------");

        //registration partnership for woman if some person already has partner
        woman1.registerPartnership(man4); //woman has partner, men doesn't have
        woman4.registerPartnership(man2); //woman doesn't have partner, men has
        System.out.println("-------------------------------------");

        //registration partnership for man if some person already has partner
        man4.registerPartnership(woman1); //men doesn't have, woman has partner
        man2.registerPartnership(woman4); //men doesn't have, woman has partner
        System.out.println("-------------------------------------");

        //registration partnership of the same gender (which is not allowed)
        woman4.registerPartnership(woman5);
        man4.registerPartnership(man5);
        System.out.println("----------------------------------------------------------------------------");

        //deregistration partnership for woman with reverting name
        woman1.deRegisterPartnership(true);
        System.out.println("Partner of " + woman1.getFullName() + " is "+ woman1.getPartner());
        System.out.println("Partner of " + man3.getFullName() + " is "+ man3.getPartner());
        System.out.println("-------------------------------------");

        //deregistration partnership for woman without reverting name
        woman3.deRegisterPartnership(false);
        System.out.println("Partner of " + woman3.getFullName() + " is "+ woman3.getPartner());
        System.out.println("Partner of " + man2.getFullName() + " is "+ man2.getPartner());
        System.out.println("-------------------------------------");

        //deregistration partnership for man with reverting female partner's name
        man1.deRegisterPartnership(true);
        System.out.println("Partner of " + man1.getFullName() + " is "+ man1.getPartner());
        System.out.println("Partner of " + woman2.getFullName() + " is "+ woman2.getPartner());
        System.out.println("-------------------------------------");

        //deregistration partnership for man without reverting female partner's name
        man1.registerPartnership(woman2); //fixture to get precondition
        man1.deRegisterPartnership(false);
        System.out.println("Partner of " + man1.getFullName() + " is "+ man1.getPartner());
        System.out.println("Partner of " + woman2.getFullName() + " is "+ woman2.getPartner());
        System.out.println("-------------------------------------");
    }
}
