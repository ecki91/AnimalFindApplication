package hu.bme.aut.animalfindapplication.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.BuildConfig;
import hu.bme.aut.animalfindapplication.RobolectricDaggerTestRunner;
import hu.bme.aut.animalfindapplication.TestComponent;
import hu.bme.aut.animalfindapplication.TestInjectorSetter;
import hu.bme.aut.animalfindapplication.model.animal.Animal;
import hu.bme.aut.animalfindapplication.model.user.User;
import hu.bme.aut.animalfindapplication.network.AnimalFindApi;
import hu.bme.aut.animalfindapplication.network.mock.NetworkMock;
import hu.bme.aut.animalfindapplication.other.BreedSearch;
import retrofit2.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Norbert on 2016. 05. 16..
 */
@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk=21)
public class TestNetwork {
    @Inject
    protected AnimalFindApi animalFindApi;

    @Before
    public void setUp() throws Exception {
        AnimalFindApplication app = TestInjectorSetter.setTestInjector();
        ((TestComponent) app.getInjector()).inject(this);
    }

    @Test
    public void testIfApiInjectionWasOk() throws Exception {
        assertNotEquals(null, animalFindApi);
    }

    @Test
    public void testGetAllAnimalsGet () throws Exception {
        if(BuildConfig.FLAVOR.equals("mock")) {
            NetworkMock.deleteAnimalList();
            Response response = animalFindApi.getAllAnimalsGet().execute();
            List<Animal> animalList = (List<Animal>)response.body();
            assertEquals(3, animalList.size());
        }

    }

    @Test
    public void testCreateAnimalPost () throws Exception {
        if(BuildConfig.FLAVOR.equals("mock")) {
            NetworkMock.deleteAnimalList();
            Response response = animalFindApi.getAllAnimalsGet().execute();
            List<Animal> animalList = (List<Animal>)response.body();
            int size = animalList.size();

            Animal animalToCreate = new Animal();
            animalToCreate.setAdvertisementTitle("testtesttest");
            animalFindApi.createAnimalPost(animalToCreate).execute();
            Response response2 = animalFindApi.getAllAnimalsGet().execute();
            List<Animal> animalList2 = (List<Animal>)response2.body();
            assertEquals(size+1, animalList2.size());
        }

    }

    @Test
    public void testUpdateAnimal() throws Exception {
        if(BuildConfig.FLAVOR.equals("mock")) {
            User u = new User();
            u.setName("alma");
            NetworkMock.deleteAnimalList();
            NetworkMock.setLoggedInUser(u);
            Response response = animalFindApi.getAllAnimalsGet().execute();
            List<Animal> animalList = (List<Animal>)response.body();
            int i = 0;
            for (Animal animal : animalList) {
                animal.setAdvertisementTitle(String.valueOf(i++));
                animalFindApi.updateAnimalPost(animal).execute();
            }

            Response response2 = animalFindApi.getAllAnimalsGet().execute();
            List<Animal> animalList2 = (List<Animal>)response2.body();
            i = 0;
            for(Animal animal : animalList2) {
                assertEquals(String.valueOf(i++), animal.getAdvertisementTitle());
            }
        }

    }

    @Test
    public void testGetAnimalsForBreed() throws Exception {
        if(BuildConfig.FLAVOR.equals("mock")) {
            NetworkMock.deleteAnimalList();
            BreedSearch breedSearch = new BreedSearch();
            breedSearch.setBreed("házi");
            Response response = animalFindApi.getAnimalsForBreedBreedPost(breedSearch).execute();
            List<Animal> animalList = (List<Animal>)response.body();

            for(Animal a : animalList) {
                assertEquals("házi", a.getBreed());
            }
        }

    }

    @Test
    public void testGetAnimalsForNotExistingBreed() throws Exception {
        if(BuildConfig.FLAVOR.equals("mock")) {
            NetworkMock.deleteAnimalList();
            BreedSearch breedSearch = new BreedSearch();
            breedSearch.setBreed("asdasdasdasd");
            Response response = animalFindApi.getAnimalsForBreedBreedPost(breedSearch).execute();
            List<Animal> animalList = (List<Animal>)response.body();
            assertEquals(0, animalList.size());
        }
    }

    @Test
    public void testRegisterAndLogin() throws Exception  {
        if(BuildConfig.FLAVOR.equals("mock")) {
            User user = new User();
            user.setName("teszt123");
            user.setPassword("pass123");
            animalFindApi.createUserPost(user).execute();
            animalFindApi.logInPost(user).execute();
            assertEquals("teszt123", NetworkMock.getLoggedInUser().getName());
        }
    }

    @Test
    public void testLoginWithNotExistingUser() throws Exception {
        if(BuildConfig.FLAVOR.equals("mock")) {
            User user = new User();
            user.setName("tutututu");
            user.setPassword("pass123");
            animalFindApi.logInPost(user).execute();
            assertNotEquals("tutututu", NetworkMock.getLoggedInUser().getName());
        }
    }
}
