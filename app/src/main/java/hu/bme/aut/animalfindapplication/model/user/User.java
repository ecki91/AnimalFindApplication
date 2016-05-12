package hu.bme.aut.animalfindapplication.model.user;

import com.orm.SugarRecord;

public class User extends SugarRecord implements IUserDal {
    private String name;
    private String password;

    public User() {

    }

    public User(String name, int age, String username, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String username, String password) {
        this.password = password;
        this.name = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public void register(User user) {
        user.save();
    }

    @Override
    public boolean login(User user) {
        for(User u : User.find(User.class, null, null, null, null, null)) {
            if((u.getName().equals(user.getName()) && (u.getPassword().equals(user.getPassword())))) {
                LogedInUser.deleteAll(LogedInUser.class);
                LogedInUser logedInUser = new LogedInUser();
                logedInUser.setName(user.getName());
                logedInUser.save();
                return true;
            }
        }
        return false;
    }

    @Override
    public User getLoggedInUser() {
        User logedInUser = new User();
        logedInUser.setName(LogedInUser.find(LogedInUser.class, null).get(0).getName());
        return logedInUser;
    }
}
