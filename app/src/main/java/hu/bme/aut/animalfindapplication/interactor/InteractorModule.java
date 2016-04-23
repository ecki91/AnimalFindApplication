package hu.bme.aut.animalfindapplication.interactor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Norbert on 2016. 04. 22..
 */
@Module
public class InteractorModule {
    @Provides
    @Singleton
    public AnimalCreateOrModifyInteractor provideAnimalCreateOrModifyInteractor() {
        return new AnimalCreateOrModifyInteractor();
    }

    @Provides
    @Singleton
    public AnimalListInteractor provideAnimalListInteractor() {
        return new AnimalListInteractor();
    }

    @Provides
    @Singleton
    public LoginInteractor provideLoginInteractor() {
        return new LoginInteractor();
    }
}
