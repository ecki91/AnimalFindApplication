package hu.bme.aut.animalfindapplication.ui;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.animalfindapplication.ui.about.AboutPresenter;
import hu.bme.aut.animalfindapplication.ui.animalCreate.AnimalCreatePresenter;
import hu.bme.aut.animalfindapplication.ui.animalDetails.AnimalDetailsPresenter;
import hu.bme.aut.animalfindapplication.ui.animalList.AnimalListPresenter;
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

    @Provides
    @Singleton
    public AnimalListPresenter provideAnimalListPresenter() {
        return new AnimalListPresenter();
    }

    @Provides
    @Singleton
    public AnimalCreatePresenter provideAnimalCreatePresenter() {
        return new AnimalCreatePresenter();
    }

    @Provides
    @Singleton
    public AboutPresenter provideAboutPresenter() {
        return new AboutPresenter();
    }

    @Provides
    @Singleton
    public AnimalDetailsPresenter provideAnimalDetailsPresenter() {
        return new AnimalDetailsPresenter();
    }
}
