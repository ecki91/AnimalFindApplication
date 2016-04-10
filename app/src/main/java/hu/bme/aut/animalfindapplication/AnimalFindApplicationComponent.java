package hu.bme.aut.animalfindapplication;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.animalfindapplication.ui.UIModule;
import hu.bme.aut.animalfindapplication.ui.login.LoginActivity;

@Singleton
@Component(modules = {UIModule.class})
public interface AnimalFindApplicationComponent {
    void inject(LoginActivity loginActivityActivity);
}
