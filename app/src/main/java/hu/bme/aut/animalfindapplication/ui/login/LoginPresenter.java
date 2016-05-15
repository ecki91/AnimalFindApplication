package hu.bme.aut.animalfindapplication.ui.login;

import javax.inject.Inject;

import hu.bme.aut.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.interactor.LoginInteractor;
import hu.bme.aut.animalfindapplication.model.user.User;
import hu.bme.aut.animalfindapplication.ui.Presenter;

/**
 * Created by Norbert on 2016. 04. 10..
 */
public class LoginPresenter extends Presenter<LoginScreen> {


    @Inject
    protected LoginInteractor loginInteractor;

    public LoginPresenter() {
        AnimalFindApplication.injector.inject(this);
    }

    @Override
    public void attachScreen(LoginScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public boolean login(User user) {
        try {
            return loginInteractor.loginToNetwork(user);
        } catch (Exception ex) {
            return loginInteractor.login(user);
        }

    }

    public void logout() {

    }

    public void register(User user) {

        try {
            loginInteractor.registerToNetwork(user);
        } catch (Exception ex) {
            loginInteractor.register(user);
        }


    }


}
