package hu.bme.aut.animalfindapplication.ui.animalCreateOrModify;

import android.app.Activity;
import android.os.Bundle;

import javax.inject.Inject;

import hu.aut.bme.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.R;

public class AnimalCreateOrModifyActivity extends Activity {

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
}
