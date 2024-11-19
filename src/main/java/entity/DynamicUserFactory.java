package entity;

public class DynamicUserFactory implements UserFactory {

    public User create(String name, String password, String type){
        if (type.equalsIgnoreCase("Participant")){
            return new Participant(name, password);
        }
        else {
            return new Researcher(name, password);
        }
    }
}
