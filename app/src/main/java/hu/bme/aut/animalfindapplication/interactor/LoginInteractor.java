package hu.bme.aut.animalfindapplication.interactor;

import javax.inject.Inject;

import hu.bme.aut.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.model.animal.IAnimalDal;
import hu.bme.aut.animalfindapplication.model.user.IUserDal;
import hu.bme.aut.animalfindapplication.model.user.User;
import hu.bme.aut.animalfindapplication.network.AnimalFindApi;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Norbert on 2016. 04. 11..
 */
public class LoginInteractor {

    @Inject
    protected IUserDal user;

    @Inject
    protected IAnimalDal animal;

    @Inject
    AnimalFindApi animalFindApi;

    public LoginInteractor() {
        AnimalFindApplication.injector.inject(this);
    }

    public boolean login(User userToLogin) {
        return user.login(userToLogin);
    }

    public boolean loginToNetwork(User userToLogin) throws Exception {
        Response<Void> response;

        Call<Void> call = animalFindApi.logInPost(userToLogin);
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute!");
        }
        if (response.code() != 200) {
            return false;
        }
        return true;
    }

    public void logut() {

    }

    public void register(User userToRegister) {
        user.register(userToRegister);
    }

    public void registerToNetwork(User userToRegister) throws Exception {
        Response<Void> response;

        Call<Void> call = animalFindApi.createUserPost(userToRegister);
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error!");
        }
    }
}
