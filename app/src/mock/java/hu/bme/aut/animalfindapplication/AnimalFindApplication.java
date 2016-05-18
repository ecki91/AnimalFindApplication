package hu.bme.aut.animalfindapplication;

import android.app.Application;

import hu.bme.aut.animalfindapplication.ui.UIModule;

/**
 * Created by Norbert on 2016. 04. 10..
 */
public class AnimalFindApplication extends Application {

    public static AnimalFindApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerMockAnimalFindApplicationComponent.builder().uIModule(new UIModule()).build();
    }

    public void setInjector(AnimalFindApplicationComponent injector) {
        AnimalFindApplication.injector = injector;
    }

    public AnimalFindApplicationComponent getInjector() {
        return injector;
    }
}
