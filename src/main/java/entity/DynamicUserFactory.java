package entity;

public class DynamicUserFactory implements UserFactory {

    public User create(String name, String email, String password, String type){
        if (type.equalsIgnoreCase("Participant")){
            return new Participant(name, email, password);
        }
        else {
            return new Researcher(name, email, password);
        }
    }
}
