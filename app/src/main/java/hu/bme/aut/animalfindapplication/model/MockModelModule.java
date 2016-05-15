package hu.bme.aut.animalfindapplication.model;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.animalfindapplication.model.animal.IAnimalDal;
import hu.bme.aut.animalfindapplication.model.animal.MockAnimalDal;
import hu.bme.aut.animalfindapplication.model.user.IUserDal;
import hu.bme.aut.animalfindapplication.model.user.MockUserDal;

/**
 * Created by Norbert on 2016. 04. 23..
 */
@Module
public class MockModelModule {

    @Provides
    @Singleton
    public IAnimalDal provideMockAnimal() {
        return new MockAnimalDal();
    }

    @Provides
    @Singleton
    public IUserDal provideUserMockUser() {
        return new MockUserDal();
    }
}
