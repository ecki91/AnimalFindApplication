package hu.bme.aut.animalfindapplication.ui.animalList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.R;
import hu.bme.aut.animalfindapplication.model.Animal;

public class AnimalListActivity extends AppCompatActivity implements AnimalListScreen {

    @Inject
    protected AnimalListPresenter animalListPresenter;

    private ListView lvAnimals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        AnimalFindApplication.injector.inject(this);
        lvAnimals = (ListView) findViewById(R.id.animalList);
    }

    @Override
    protected void onStart() {
        super.onStart();
        animalListPresenter.attachScreen(this);
        animalListPresenter.getAnimals();
    }

    @Override
    protected void onStop() {
        super.onStop();
        animalListPresenter.detachScreen();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void showAnimalList(List<Animal> animalList) {
        lvAnimals.setAdapter(new AnimalListAdapter(this, animalList));
        Log.i(this.getClass().getName(), "AnimalListActivity Works!");
    }
}
