package hu.bme.aut.animalfindapplication.ui.about;

import javax.inject.Inject;

import hu.bme.aut.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.interactor.AboutInteractor;
import hu.bme.aut.animalfindapplication.ui.Presenter;

/**
 * Created by Norbert on 2016. 04. 22..
 */
public class AboutPresenter extends Presenter<AboutScreen> {

    @Inject
    protected AboutInteractor aboutInteractor;

    public AboutPresenter() {
        AnimalFindApplication.injector.inject(this);
    }


}
