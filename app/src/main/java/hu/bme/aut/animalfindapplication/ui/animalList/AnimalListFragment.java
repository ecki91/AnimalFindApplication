package hu.bme.aut.animalfindapplication.ui.animalList;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.R;
import hu.bme.aut.animalfindapplication.model.animal.Animal;
import hu.bme.aut.animalfindapplication.ui.animalCreate.AnimalCreateFragment;
import hu.bme.aut.animalfindapplication.ui.animalDetails.AnimalDetailsFragment;


public class AnimalListFragment extends Fragment implements AnimalListScreen {
    @Inject
    protected AnimalListPresenter animalListPresenter;

    private ListView lvAnimals;
    private List<Animal> animalList;
    private EditText breedFilter;
    private Button addAnimalButton;
    private Button filterButton;


    public AnimalListFragment() {
        AnimalFindApplication.injector.inject(this);
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        animalListPresenter.attachScreen(this);
    }

    @Override
    public void onDetach() {
        animalListPresenter.detachScreen();
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle inState) {
        View result = inflater.inflate(R.layout.animal_list, container, false);
        addAnimalButton = (Button)result.findViewById(R.id.addAnimalButton);
        addAnimalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new AnimalCreateFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.mainContent, fragment).commit();
            }
        });
        filterButton = (Button)result.findViewById(R.id.filterButton);
        breedFilter = (EditText) result.findViewById(R.id.breedFilterText);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterForBreed();
            }
        });
        initializeAnimalListAndAdapter();
        initList(result);
        fillAnimalList();
        return result;
    }

    private void initializeAnimalListAndAdapter() {
        animalList = new ArrayList<>();
    }

    private void initList(View result) {
        lvAnimals = (ListView)result.findViewById(R.id.animalList);
        lvAnimals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                activateDetailsFragment(position);
            }
        });
    }

    void filterForBreed() {
        animalListPresenter.getAnimalsForBreed(breedFilter.getText().toString());
    }

    private void fillAnimalList() {

            animalListPresenter.getAnimals();

    }

    private void activateDetailsFragment(int position) {
        Fragment fragment = new AnimalDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("animal", animalList.get(position));
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainContent, fragment).commit();
        getActivity().setTitle("Animal Details");
    }


    @Override
    public void getAnimalList(List<Animal> animals) {
        animalList = animals;
        lvAnimals.setAdapter(new AnimalListAdapter(getContext(), animalList));
    }

    @Override
    public void getAnimalsForBreed(String breedFilter) {

    }
}
