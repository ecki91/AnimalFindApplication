package hu.bme.aut.animalfindapplication;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.animalfindapplication.interactor.AboutInteractor;
import hu.bme.aut.animalfindapplication.interactor.AnimalCreateInteractor;
import hu.bme.aut.animalfindapplication.interactor.AnimalDetailsInteractor;
import hu.bme.aut.animalfindapplication.interactor.AnimalListInteractor;
import hu.bme.aut.animalfindapplication.interactor.InteractorModule;
import hu.bme.aut.animalfindapplication.interactor.LoginInteractor;
import hu.bme.aut.animalfindapplication.model.ModelModule;
import hu.bme.aut.animalfindapplication.network.live.NetworkModule;
import hu.bme.aut.animalfindapplication.ui.UIModule;
import hu.bme.aut.animalfindapplication.ui.about.AboutFragment;
import hu.bme.aut.animalfindapplication.ui.about.AboutPresenter;
import hu.bme.aut.animalfindapplication.ui.animalCreate.AnimalCreateFragment;
import hu.bme.aut.animalfindapplication.ui.animalCreate.AnimalCreatePresenter;
import hu.bme.aut.animalfindapplication.ui.animalDetails.AnimalDetailsFragment;
import hu.bme.aut.animalfindapplication.ui.animalDetails.AnimalDetailsPresenter;
import hu.bme.aut.animalfindapplication.ui.animalList.AnimalListFragment;
import hu.bme.aut.animalfindapplication.ui.animalList.AnimalListPresenter;
import hu.bme.aut.animalfindapplication.ui.login.LoginActivity;
import hu.bme.aut.animalfindapplication.ui.login.LoginPresenter;

@Singleton
@Component(modules = {UIModule.class, InteractorModule.class, ModelModule.class, NetworkModule.class})
public interface AnimalFindApplicationComponent {

    void inject(AnimalCreateFragment animalCreateFragment);
    void inject(LoginActivity loginActivityActivity);
    void inject(AnimalListFragment animalListFragment);
    void inject(AnimalDetailsFragment animalDetailsFragment);
    void inject(AboutFragment aboutFragment);


    void inject(AnimalCreateInteractor animalCreateInteractor);
    void inject(AnimalListInteractor animalListInteractor);
    void inject(LoginInteractor loginInteractor);
    void inject(AnimalDetailsInteractor animalDetailsInteractor);
    void inject(AboutInteractor aboutInteractor);

    void inject(AnimalCreatePresenter animalCreatePresenter);
    void inject(AnimalListPresenter animalListPresenter);
    void inject(LoginPresenter loginPresenter);
    void inject(AnimalDetailsPresenter animalDetailsPresenter);
    void inject(AboutPresenter aboutPresenter);

}
