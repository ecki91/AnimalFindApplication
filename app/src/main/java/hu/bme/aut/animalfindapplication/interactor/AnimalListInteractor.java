package hu.bme.aut.animalfindapplication.interactor;

import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.model.animal.Animal;
import hu.bme.aut.animalfindapplication.model.animal.IAnimalDal;
import hu.bme.aut.animalfindapplication.model.user.IUserDal;

/**
 * Created by Norbert on 2016. 04. 22..
 */
public class AnimalListInteractor {

    @Inject
    protected IUserDal user;

    @Inject
    protected IAnimalDal animal;

    public AnimalListInteractor() {
        AnimalFindApplication.injector.inject(this);
    }

    public List<Animal> getAnimalList() {

        return animal.listAllAnimals();
    }
}
