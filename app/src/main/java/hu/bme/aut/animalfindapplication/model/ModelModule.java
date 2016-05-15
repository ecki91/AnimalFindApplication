package hu.bme.aut.animalfindapplication.model;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.animalfindapplication.model.animal.AnimalDal;
import hu.bme.aut.animalfindapplication.model.animal.IAnimalDal;
import hu.bme.aut.animalfindapplication.model.user.IUserDal;
import hu.bme.aut.animalfindapplication.model.user.UserDal;

/**
 * Created by Norbert on 2016. 04. 22..
 */
@Module
public class ModelModule {

    @Provides
    @Singleton
    public IAnimalDal provideAnimal() {
        return new AnimalDal();
    }

    @Provides
    @Singleton
    public IUserDal provideUser() {
        return new UserDal();
    }
}
