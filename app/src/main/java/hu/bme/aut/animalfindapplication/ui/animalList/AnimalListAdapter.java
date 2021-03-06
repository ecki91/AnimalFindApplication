package hu.bme.aut.animalfindapplication.ui.animalList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hu.bme.aut.animalfindapplication.R;
import hu.bme.aut.animalfindapplication.model.animal.Animal;

/**
 * Created by Norbert on 2016. 04. 22..
 */
public class AnimalListAdapter extends BaseAdapter {

    private Context context;
    private List<Animal> animalList;
    private static LayoutInflater inflater;

    public AnimalListAdapter(Context context, List<Animal> animalList) {
        this.context = context;
        this.animalList = animalList;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return animalList.size();
    }

    @Override
    public Object getItem(int position) {
        return animalList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return animalList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if(view == null)
        {
            view = inflater.inflate(R.layout.list_item, null);
        }

        TextView tvAdvertisementTitle = (TextView) view.findViewById(R.id.advertisementTitle);
        TextView tvLostOrFound = (TextView) view.findViewById(R.id.lostOrFound);
        TextView tvSpecies = (TextView) view.findViewById(R.id.species);
        TextView tvBreed = (TextView) view.findViewById(R.id.breed);
        TextView tvDate = (TextView) view.findViewById(R.id.date);
        Animal currendAnimal = animalList.get(position);
        tvAdvertisementTitle.setText(currendAnimal.getAdvertisementTitle());
        tvLostOrFound.setText(currendAnimal.getLostOrFound());
        tvSpecies.setText(currendAnimal.getSpecies());
        tvBreed.setText(currendAnimal.getBreed());
        tvDate.setText(currendAnimal.getDate());

        return  view;
    }
}
