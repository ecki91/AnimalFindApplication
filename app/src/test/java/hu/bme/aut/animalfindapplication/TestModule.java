package hu.bme.aut.animalfindapplication;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.animalfindapplication.model.animal.IAnimalDal;
import hu.bme.aut.animalfindapplication.model.animal.MockAnimalDal;
import hu.bme.aut.animalfindapplication.model.user.IUserDal;
import hu.bme.aut.animalfindapplication.model.user.MockUserDal;

@Module
public class TestModule {
    @Provides
    public IAnimalDal provideMockAnimalDal() {
        return new MockAnimalDal();
    }

    @Provides
    public IUserDal provideUserMockUserDal() {
        return new MockUserDal();
    }
}
