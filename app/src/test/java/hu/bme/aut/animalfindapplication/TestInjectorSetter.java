package hu.bme.aut.animalfindapplication;

import org.robolectric.RuntimeEnvironment;

public class TestInjectorSetter {
    public static AnimalFindApplication setTestInjector() {
        AnimalFindApplication application = (AnimalFindApplication) RuntimeEnvironment.application;
        application.setInjector(DaggerTestComponent.builder().testModule(new TestModule()).build());
        return application;
    }
}
