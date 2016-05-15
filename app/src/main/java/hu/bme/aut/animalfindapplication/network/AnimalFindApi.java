package hu.bme.aut.animalfindapplication.network;


import java.util.List;

import hu.bme.aut.animalfindapplication.model.animal.Animal;
import hu.bme.aut.animalfindapplication.model.user.User;
import hu.bme.aut.animalfindapplication.other.BreedSearch;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AnimalFindApi {
  
  /**
   * 
   * Create an Animal advertisement
   * @param animal Animal to save
   * @return Call<Void>
   */
  
  @POST("createAnimal")
  Call<Void> createAnimalPost(
          @Body Animal animal
  );

  
  /**
   * 
   * User creation was successful
   * @param user User to create
   * @return Call<Void>
   */
  
  @POST("createUser")
  Call<Void> createUserPost(
          @Body User user
  );

  
  /**
   * 
   * Delete the animal with the given id.
   * @param animalId Animal to delete
   * @return Call<Void>
   */
  
  @POST("deleteAnimal/{animalId}")
  Call<Void> deleteAnimalAnimalIdPost(
          @Path("animalId") Integer animalId
  );

  
  /**
   * 
   * Gets all animals
   * @return Call<List<Animal>>
   */
  
  @GET("getAllAnimals")
  Call<List<Animal>> getAllAnimalsGet();
    

  
  /**
   * 
   * Gets animals for the given breed
   * @return Call<List<Animal>>
   */
  
  @POST("getAnimalsForBreed")
  Call<List<Animal>> getAnimalsForBreedBreedPost(
          @Body BreedSearch breedSearch
  );

  
  /**
   * 
   * Login user with username and password
   * @param user User to login
   * @return Call<Void>
   */
  
  @POST("logIn")
  Call<Void> logInPost(
          @Body User user
  );

  
  /**
   * 
   * Update a the animal.
   * @param animal Animal to update
   * @return Call<Void>
   */
  
  @POST("updateAnimal")
  Call<Void> updateAnimalPost(
          @Body Animal animal
  );

  
}
