package hu.bme.aut.animalfindapplication.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hu.bme.aut.animalfindapplication.R;
import hu.bme.aut.animalfindapplication.other.MenuItem;


public class MainAdapter extends BaseAdapter {
    private Context context;
    private List<MenuItem> menuItemList;

    public MainAdapter(Context con, List<MenuItem> items) {
        context = con;
        menuItemList = items;
    }

    @Override
    public int getCount() {
        return menuItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return menuItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.menu_item, null);
        }
        else {
            view = convertView;
        }

        TextView titleView = (TextView) view.findViewById(R.id.title);
        ImageView iconView = (ImageView) view.findViewById(R.id.icon);

        titleView.setText(menuItemList.get(position).getName());
        iconView.setImageResource(menuItemList.get(position).getIcon());

        return view;
    }
}
