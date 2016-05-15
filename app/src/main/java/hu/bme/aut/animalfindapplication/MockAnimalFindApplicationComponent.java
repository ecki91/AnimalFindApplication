package hu.bme.aut.animalfindapplication;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.animalfindapplication.interactor.InteractorModule;
import hu.bme.aut.animalfindapplication.model.MockModelModule;
import hu.bme.aut.animalfindapplication.network.mock.MockNetworkModule;
import hu.bme.aut.animalfindapplication.ui.UIModule;

/**
 * Created by Norbert on 2016. 04. 23..
 */
@Singleton
@Component(modules = {UIModule.class, InteractorModule.class, MockModelModule.class, MockNetworkModule.class})
public interface MockAnimalFindApplicationComponent extends AnimalFindApplicationComponent {
}
