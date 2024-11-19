package entity;

public interface UserFactory {

    User create(String name, String email, String password, String type);
}
