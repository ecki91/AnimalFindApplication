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
public class AnimalCreateInteractor {

    @Inject
    protected IUserDal user;

    @Inject
    protected IAnimalDal animal;

    @Inject
    AnimalFindApi animalFindApi;

    public AnimalCreateInteractor() {
        AnimalFindApplication.injector.inject(this);
    }

    public void createAnimal(Animal animalToCreate) {
        animalToCreate.setContactName(user.getLoggedInUser());
        animal.createAnimal(animalToCreate);
    }

    public void createAnimalToNetwork(Animal animalToCreate) throws Exception {
        Response response;
        Call call = animalFindApi.createAnimalPost(animalToCreate);
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute!");
        }
        if(response.code() != 200) {
            throw new Exception("Network error!");
        }
    }

}
