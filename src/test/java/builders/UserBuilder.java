package builders;

import models.User;

public class UserBuilder {

    private final User user;

    public UserBuilder(){
        user = new User();
    }

    public UserBuilder withUsername(String username){
        user.setUsername(username);
        return this;
    }

    public UserBuilder withPassword(String password){
        user.setPassword(password);
        return this;
    }

    public User build(){
        return user;
    }
}
