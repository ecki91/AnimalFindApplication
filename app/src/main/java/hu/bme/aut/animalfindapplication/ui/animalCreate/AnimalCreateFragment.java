
package hu.bme.aut.animalfindapplication.ui.animalCreate;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import javax.inject.Inject;

import hu.bme.aut.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.R;
import hu.bme.aut.animalfindapplication.model.animal.Animal;
import hu.bme.aut.animalfindapplication.ui.animalList.AnimalListFragment;


public class AnimalCreateFragment extends Fragment implements AnimalCreateScreen {
    @Inject
    protected AnimalCreatePresenter animalCreatePresenter;

    private EditText advertisementTitle;
    private Switch lostOrFind;
    private EditText advertisementDetails;
    private EditText species;
    private EditText breed;
    private EditText city;
    private EditText date;
    private EditText contactPhone;

    public AnimalCreateFragment() {
        AnimalFindApplication.injector.inject(this);
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        animalCreatePresenter.attachScreen(this);
    }

    @Override
    public void onDetach() {
        animalCreatePresenter.detachScreen();
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle inState) {
        View result = inflater.inflate(R.layout.animal_create, container, false);
        advertisementTitle = (EditText)result.findViewById(R.id.advertisementTitle);
        lostOrFind = (Switch)result.findViewById(R.id.lostOrFound);
        advertisementDetails = (EditText)result.findViewById(R.id.advertisementDescription);
        species = (EditText)result.findViewById(R.id.species);
        breed = (EditText)result.findViewById(R.id.breed);
        city = (EditText)result.findViewById(R.id.city);
        date = (EditText)result.findViewById(R.id.date);
        contactPhone = (EditText)result.findViewById(R.id.contactPhone);
        Button saveButton = (Button) result.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAnimal();
            }
        });

        return result;
    }

    private void createAnimal() {
        Animal animal = new Animal();
        animal.setAdvertisementTitle(advertisementTitle.getText().toString());
        if(lostOrFind.isChecked()) {
            animal.setLostOrFound("eltűnt");
        } else {
            animal.setLostOrFound("megtalált");
        }
        animal.setAdvertisementDescription(advertisementDetails.getText().toString());
        animal.setSpecies(species.getText().toString());
        animal.setBreed(breed.getText().toString());
        animal.setCity(city.getText().toString());
        animal.setDate(date.getText().toString());
        animal.setContactPhone(contactPhone.getText().toString());
        animalCreatePresenter.createAnimal(animal);
    }

    @Override
    public void getAnimals() {
        Fragment fragment = new AnimalListFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainContent, fragment).commit();
        getActivity().setTitle("Animals");
    }
}
