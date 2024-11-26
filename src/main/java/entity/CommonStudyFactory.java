package entity;

public User create(String name, String password){
    return new CommonUser(name, password);
}

