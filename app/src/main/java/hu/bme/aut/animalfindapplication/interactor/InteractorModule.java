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
    public AnimalCreateInteractor provideAnimalCreateInteractor() {
        return new AnimalCreateInteractor();
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

    @Provides
    @Singleton
    public AnimalDetailsInteractor provideAnimalDetailsInteractor() { return new AnimalDetailsInteractor();}

    @Provides
    @Singleton
    public AboutInteractor provideAboutInteractor() { return new AboutInteractor();}

}
