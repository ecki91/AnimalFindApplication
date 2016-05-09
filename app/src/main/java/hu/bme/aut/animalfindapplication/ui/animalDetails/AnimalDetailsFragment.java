
package hu.bme.aut.animalfindapplication.ui.animalDetails;


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


public class AnimalDetailsFragment extends Fragment implements AnimalDetailsScreen {
    @Inject
    protected AnimalDetailsPresenter animalDetailsPresenter;

    private EditText advertisementTitle;
    private Switch lostOrFind;
    private EditText advertisementDetails;
    private EditText species;
    private EditText breed;
    private EditText city;
    private EditText date;
    private EditText contactName;
    private EditText contactPhone;

    private Animal animal;

    public AnimalDetailsFragment() {
        AnimalFindApplication.injector.inject(this);
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        animalDetailsPresenter.attachScreen(this);
    }

    @Override
    public void onDetach() {
        animalDetailsPresenter.detachScreen();
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle inState) {
        View result = inflater.inflate(R.layout.animal_details, container, false);
        advertisementTitle = (EditText)result.findViewById(R.id.advertisementTitle);
        lostOrFind = (Switch)result.findViewById(R.id.lostOrFound);
        advertisementDetails = (EditText)result.findViewById(R.id.advertisementDescription);
        species = (EditText)result.findViewById(R.id.species);
        breed = (EditText)result.findViewById(R.id.breed);
        city = (EditText)result.findViewById(R.id.city);
        date = (EditText)result.findViewById(R.id.date);
        contactName = (EditText)result.findViewById(R.id.contactName);
        contactPhone = (EditText)result.findViewById(R.id.contactPhone);
        Button modifyButton = (Button) result.findViewById(R.id.modifyButton);
        animal = (Animal) this.getArguments().getSerializable("animal");
        modifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyAnimal();
            }
        });
        advertisementTitle.setText(animal.getAdvertisementTitle());
        lostOrFind.setText(animal.getLostOrFound());
        advertisementDetails.setText(animal.getAdvertisementDescription());
        species.setText(animal.getSpecies());
        breed.setText(animal.getBreed());
        city.setText(animal.getCity());
        date.setText(animal.getDate());
        contactName.setText(animal.getContactName());
        contactPhone.setText(animal.getContactPhone());
        return result;
    }

    private void modifyAnimal() {
        Animal animalToUpdate = new Animal();
        animalToUpdate.setId(animal.getId());
        animalToUpdate.setAdvertisementTitle(advertisementTitle.getText().toString());
        if(lostOrFind.isChecked()) {
            animalToUpdate.setLostOrFound("eltűnt");
        } else {
            animalToUpdate.setLostOrFound("megtalált");
        }
        animalToUpdate.setAdvertisementDescription(advertisementDetails.getText().toString());
        animalToUpdate.setSpecies(species.getText().toString());
        animalToUpdate.setBreed(breed.getText().toString());
        animalToUpdate.setCity(city.getText().toString());
        animalToUpdate.setDate(date.getText().toString());
        animalToUpdate.setContactName(contactName.getText().toString());
        animalToUpdate.setContactPhone(contactPhone.getText().toString());
        animalDetailsPresenter.modifyAnimal(animalToUpdate);

    }

    @Override
    public void getAnimals() {
        Fragment fragment = new AnimalListFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainContent, fragment).commit();
        getActivity().setTitle("Animals");
    }
}
