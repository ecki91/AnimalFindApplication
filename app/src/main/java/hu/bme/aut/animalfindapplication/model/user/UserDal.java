package hu.bme.aut.animalfindapplication.model.user;

/**
 * Created by Norbert on 2016. 05. 15..
 */
public class UserDal implements IUserDal {

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
    public String getLoggedInUser() {

        return LogedInUser.find(LogedInUser.class, null).get(0).getName();
    }
}
