package hu.bme.aut.animalfindapplication.model.user;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Norbert on 2016. 04. 23..
 */
public class MockUserDal implements IUserDal {
    private List<User> userList = new ArrayList<User>();
    private long idSequence;

    User loggedInUser = new User();
    public MockUserDal() {
        idSequence = 0;
        User user1 = new User();
        user1.setName("alma");
        user1.setPassword("alma");
        user1.setId(idSequence++);

        userList.add(user1);


    }

    @Override
    public void register(User user) {
        user.setId(idSequence++);
        userList.add(user);
    }

    @Override
    public boolean login(User user) {
        loggedInUser = user;
        for(User u : userList) {
            if((u.getName().equals(user.getName()) && (u.getPassword().equals(user.getPassword())))) {
                loggedInUser = user;
                return true;
            }
        }
        return false;
    }

    @Override
    public String getLoggedInUser() {
        if(loggedInUser == null) {
            return "";
        }
        return loggedInUser.getName();
    }
}
