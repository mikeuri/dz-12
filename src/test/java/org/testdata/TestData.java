package org.testdata;

import org.example.Man;
import org.example.Woman;

public class TestData {
    //adding men
    protected Man man1 = new Man("Kelsey", "Gardner", 43, null);
    protected Man man2 = new Man("Christopher", "Glisson", 89, null);
    protected Man man3 = new Man("Winston", "Cox", 65, null);
    protected Man man4 = new Man("Mark", "Brown", 30, null);
    protected Man man5 = new Man("Dwayne", "Preston", 30, null);

    //adding women
    protected Woman woman1 = new Woman("Penelope", "Marshall", 60, null);
    protected Woman woman2 = new Woman("Belinda", "Stephens", 42, man1); //adding partner on init
    protected Woman woman3 = new Woman("Rebecca", "Blanton", 86, null);
    protected Woman woman4 = new Woman("Roberta", "Peters", 28, null);
    protected Woman woman5 = new Woman("Victoria", "Hoffman", 25, null);
}
