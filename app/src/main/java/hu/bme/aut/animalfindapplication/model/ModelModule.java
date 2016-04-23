package hu.bme.aut.animalfindapplication.model;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.animalfindapplication.model.animal.User;
import hu.bme.aut.animalfindapplication.model.user.Animal;

/**
 * Created by Norbert on 2016. 04. 22..
 */
@Module
public class ModelModule {

    @Provides
    @Singleton
    public Animal provideAnimal() {
        return new Animal();
    }

    @Provides
    @Singleton
    public User provideUser() {
        return new User();
    }
}
