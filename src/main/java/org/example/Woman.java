package org.example;

public class Woman extends Person{

    public Woman(String firstName, String lastName, int age, Person partner) {
        super(firstName, lastName, age, partner);
    }

    @Override
    public boolean isRetired() {
        return this.getAge() >= 60;
    }

    @Override
    public String getGender() {
        return "female";
    }

    @Override
    public void setNewLastName(Person newPartner) {
        setLastName(newPartner.getLastName());
        System.out.printf("%s (maiden name: %s) has registered new male partner %s\n",
                getFullName(), initLastName, newPartner.getFullName());
    }

    @Override
    public void revertName() {
        System.out.printf("Last name of %s will be set to initial one: %s\n",
                getFullName(), this.initLastName);
        setLastName(initLastName);
    }
}
