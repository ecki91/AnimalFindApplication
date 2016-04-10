package hu.bme.aut.animalfindapplication.ui;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.animalfindapplication.ui.login.LoginPresenter;

/**
 * Created by Norbert on 2016. 04. 10..
 */
@Module
public class UIModule {

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter() {
        return new LoginPresenter();
    }
}
