import Entities.ResearchStudy;
import Entities.Researcher;

public class Main {
    public static void main(String[] args) {
        Researcher myPI = new Researcher("Mike", "12345", "Mike@domain.ca");
        System.out.println("Your Username is: " + myPI.getName());
        ResearchStudy temp = new ResearchStudy("Neuroimaging research study",
                "Our lab at CAMH is looking for volunteers to enlist into our neuroimaging study.");

        // Researcher creates 2 studies on the platform
        myPI.makeStudy();
        System.out.println(temp.getTitle());
    }
}
