package hu.bme.aut.animalfindapplication.interactor;

import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.model.animal.Animal;
import hu.bme.aut.animalfindapplication.model.animal.IAnimalDal;
import hu.bme.aut.animalfindapplication.model.user.IUserDal;
import hu.bme.aut.animalfindapplication.network.AnimalFindApi;
import hu.bme.aut.animalfindapplication.other.BreedSearch;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Norbert on 2016. 04. 22..
 */
public class AnimalListInteractor {

    @Inject
    protected IUserDal user;

    @Inject
    protected IAnimalDal animal;

    @Inject
    AnimalFindApi animalFindApi;

    public AnimalListInteractor() {
        AnimalFindApplication.injector.inject(this);
    }

    public List<Animal> getAnimalList() {

        return animal.getAllAnimals();
    }

    public List<Animal> getAnimalListForBreed(String breed) {
        return animal.getAllAnimalsForBreed(breed);
    }

    public List<Animal> getAnimalListFromNetwork() throws Exception {
        Response<List<Animal>> response;

        Call<List<Animal>> call = animalFindApi.getAllAnimalsGet();
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error!");
        }
        return response.body();
    }

    public List<Animal> getAnimalListForBreedFromNetwork(String breed) throws Exception {
        Response<List<Animal>> response;
        BreedSearch breedSearch = new BreedSearch();
        breedSearch.setBreed(breed);
        Call<List<Animal>> call = animalFindApi.getAnimalsForBreedBreedPost(breedSearch);
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error!");
        }
        return response.body();
    }


}
