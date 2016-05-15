package hu.bme.aut.animalfindapplication.interactor;

import javax.inject.Inject;

import hu.bme.aut.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.model.animal.Animal;
import hu.bme.aut.animalfindapplication.model.animal.IAnimalDal;
import hu.bme.aut.animalfindapplication.model.user.IUserDal;
import hu.bme.aut.animalfindapplication.network.AnimalFindApi;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Norbert on 2016. 04. 22..
 */
public class AnimalDetailsInteractor {

    @Inject
    protected IUserDal user;

    @Inject
    protected IAnimalDal animal;

    @Inject
    AnimalFindApi animalFindApi;

    public AnimalDetailsInteractor() {
        AnimalFindApplication.injector.inject(this);
    }

    public void modifyAnimal(Animal animalToMofify) {
        if((user.getLoggedInUser()).equals(animalToMofify.getContactName())) {
            animal.updateAnimal(animalToMofify);
        }
    };

    public void modifyAnimalInNetwork(Animal animalToMofify) throws Exception {
        Response response;
        Call call = animalFindApi.updateAnimalPost(animalToMofify);
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute with post!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error with post!");
        }


    }

}
