package hu.bme.aut.animalfindapplication;

import com.orm.SugarApp;

import hu.bme.aut.animalfindapplication.ui.UIModule;

/**
 * Created by Norbert on 2016. 04. 10..
 */
public class AnimalFindApplication extends SugarApp {

    public static AnimalFindApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerAnimalFindApplicationComponent.builder().uIModule(new UIModule()).build();
    }

    public void setInjector(AnimalFindApplicationComponent injector) {
        AnimalFindApplication.injector = injector;
    }

    public AnimalFindApplicationComponent getInjector() {
        return injector;
    }
}
