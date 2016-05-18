package hu.bme.aut.animalfindapplication;


import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.animalfindapplication.interactor.InteractorModule;
import hu.bme.aut.animalfindapplication.network.mock.MockNetworkModule;
import hu.bme.aut.animalfindapplication.tests.TestNetwork;
import hu.bme.aut.animalfindapplication.ui.UIModule;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, UIModule.class})
public interface TestComponent extends AnimalFindApplicationComponent{
    void inject(TestNetwork testNetwork);
}
