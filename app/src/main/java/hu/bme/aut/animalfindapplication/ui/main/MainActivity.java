package hu.bme.aut.animalfindapplication.ui.main;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.animalfindapplication.R;
import hu.bme.aut.animalfindapplication.other.FragmentTypeEnum;
import hu.bme.aut.animalfindapplication.other.MenuItem;
import hu.bme.aut.animalfindapplication.ui.about.AboutFragment;
import hu.bme.aut.animalfindapplication.ui.animalCreate.AnimalCreateFragment;
import hu.bme.aut.animalfindapplication.ui.animalList.AnimalListFragment;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private List<MenuItem> menuItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        initializeMenu();
        activateFragmentForPositon(0);
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        return actionBarDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    private void initializeMenu() {
        menuItemList = new ArrayList<>();
        menuItemList.add(new MenuItem("Animal List", FragmentTypeEnum.ALL, R.drawable.listallanimalicon));
        menuItemList.add(new MenuItem("New Animal", FragmentTypeEnum.NEW, R.drawable.addanimalicon));
        menuItemList.add(new MenuItem("About", FragmentTypeEnum.ABOUT, R.drawable.abouticon));
        menuItemList.add(new MenuItem("Logout", FragmentTypeEnum.NEW, R.drawable.logouticon));

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        relativeLayout = (RelativeLayout) findViewById(R.id.drawerPane);
        ListView mDrawerList = (ListView) findViewById(R.id.navList);

        MainAdapter adapter = new MainAdapter(this, menuItemList);
        mDrawerList.setAdapter(adapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                activateFragmentForPositon(position);
            }
        });

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    private void activateFragmentForPositon(int position) {
        Fragment fragment = null;
        switch(menuItemList.get(position).getFragmentTypeEnum()) {
            case ALL:
                fragment = new AnimalListFragment();
                break;
            case NEW:
                fragment = new AnimalCreateFragment();
                break;
            case ABOUT:
                fragment = new AboutFragment();
        }
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainContent, fragment).commit();
        setTitle(menuItemList.get(position).getName());
        drawerLayout.closeDrawer(relativeLayout);
    }
}
