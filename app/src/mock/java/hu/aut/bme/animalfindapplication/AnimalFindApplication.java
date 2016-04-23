package hu.aut.bme.animalfindapplication;

import android.app.Application;

import hu.bme.aut.animalfindapplication.AnimalFindApplicationComponent;
import hu.bme.aut.animalfindapplication.DaggerMockAnimalFindApplicationComponent;
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
}
