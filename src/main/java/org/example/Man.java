package org.example;

public class Man extends Person {

    public Man(String firstName, String lastName, int age, Person partner) {
        super(firstName, lastName, age, partner);
    }

    @Override
    public boolean isRetired() {
        return this.getAge() >= 65;
    }

    @Override
    public String getGender() {
        return "male";
    }

    @Override
    public void setNewLastName(Person newPartner) {
        newPartner.setLastName(getLastName());
        System.out.printf("%s has registered new female partner %s (maiden name: %s)\n",
                this.getFullName(), newPartner.getFullName(), newPartner.initLastName);
    }

    @Override
    public void revertName() {
        System.out.printf("Last name of %s will be set to initial one: %s\n",
                getPartner().getFullName(), getPartner().initLastName);
        getPartner().setLastName(getPartner().initLastName);
    }
}
