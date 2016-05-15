package hu.bme.aut.animalfindapplication.model.user;

/**
 * Created by Norbert on 2016. 04. 22..
 */
public interface IUserDal {

    void register(User user);

    boolean login(User user);

    String getLoggedInUser();
}
