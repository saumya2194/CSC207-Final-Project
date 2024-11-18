
package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Researcher extends User {
    String affiliation;
    List<ResearchStudy> myStudies; // research studies created by this Researcher.

    public Researcher(String name, String password, String email) {
        super(name, password, email);
        this.myStudies = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    // Not sure why this setter below is not working.
//    public void setMyStudies() {
//        this.myStudies = new ArrayList<>();
//
//    }

    @Override
    public String getPassword() {
        return this.password;
    }
    public String getAffiliation() {
        return this.affiliation;
    }

    public void makeStudy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title of your research study: ");
        String studyTitle = scanner.nextLine();
        System.out.println("Please provide the details of your study: ");
        String details = scanner.nextLine();
        ResearchStudy myStudy = new ResearchStudy(studyTitle, details);
        myStudy.studyContact = this.email;
        this.myStudies.add(myStudy);
    }

    public List<ResearchStudy> getMyStudies() {
        return myStudies;
    }
}

