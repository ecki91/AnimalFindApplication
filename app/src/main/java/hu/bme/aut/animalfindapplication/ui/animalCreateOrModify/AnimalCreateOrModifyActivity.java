package hu.bme.aut.animalfindapplication.ui.animalCreateOrModify;

import android.app.Activity;
import android.os.Bundle;

import javax.inject.Inject;

import hu.bme.aut.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.R;
import hu.bme.aut.animalfindapplication.model.animal.Animal;
import hu.bme.aut.animalfindapplication.model.user.User;

public class AnimalCreateOrModifyActivity extends Activity implements AnimalCreateOrModifyScreen {

    @Inject
    protected AnimalCreateOrModifyPresenter animalCreateOrModifyPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_create_or_modify);
        AnimalFindApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void createAnimal(Animal animal) {

    }

    @Override
    public void modifyAnimal(Animal animal, User user) {

    }
}
