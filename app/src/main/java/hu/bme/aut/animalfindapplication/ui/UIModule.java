package hu.bme.aut.animalfindapplication.ui;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.animalfindapplication.ui.animalCreateOrModify.AnimalCreateOrModifyPresenter;
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
    public AnimalCreateOrModifyPresenter provideAnimalCreateOrModifyPresenter() {
        return new AnimalCreateOrModifyPresenter();
    }
}
