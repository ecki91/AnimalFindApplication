package hu.bme.aut.animalfindapplication;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.animalfindapplication.interactor.AnimalCreateOrModifyInteractor;
import hu.bme.aut.animalfindapplication.interactor.AnimalListInteractor;
import hu.bme.aut.animalfindapplication.interactor.InteractorModule;
import hu.bme.aut.animalfindapplication.interactor.LoginInteractor;
import hu.bme.aut.animalfindapplication.model.ModelModule;
import hu.bme.aut.animalfindapplication.ui.UIModule;
import hu.bme.aut.animalfindapplication.ui.animalCreateOrModify.AnimalCreateOrModifyActivity;
import hu.bme.aut.animalfindapplication.ui.animalCreateOrModify.AnimalCreateOrModifyPresenter;
import hu.bme.aut.animalfindapplication.ui.animalList.AnimalListActivity;
import hu.bme.aut.animalfindapplication.ui.animalList.AnimalListPresenter;
import hu.bme.aut.animalfindapplication.ui.login.LoginActivity;
import hu.bme.aut.animalfindapplication.ui.login.LoginPresenter;

@Singleton
@Component(modules = {UIModule.class, InteractorModule.class, ModelModule.class})
public interface AnimalFindApplicationComponent {

    void inject(AnimalCreateOrModifyActivity animalCreateOrModifyActivity);
    void inject(LoginActivity loginActivityActivity);
    void inject(AnimalListActivity animalListActivity);


    void inject(AnimalCreateOrModifyInteractor animalCreateOrModifyInteractor);
    void inject(AnimalListInteractor animalListInteractor);
    void inject(LoginInteractor loginInteractor);

    void inject(AnimalCreateOrModifyPresenter animalCreateOrModifyPresenter);
    void inject(AnimalListPresenter animalListPresenter);
    void inject(LoginPresenter loginPresenter);

}
