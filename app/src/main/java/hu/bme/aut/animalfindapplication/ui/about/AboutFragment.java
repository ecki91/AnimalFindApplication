package hu.bme.aut.animalfindapplication.ui.about;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import hu.bme.aut.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.R;

public class AboutFragment extends Fragment implements AboutScreen {

    @Inject
    protected AboutPresenter aboutPresenter;

    public AboutFragment() {
        AnimalFindApplication.injector.inject(this);
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        aboutPresenter.attachScreen(this);
    }

    @Override
    public void onDetach() {
        aboutPresenter.detachScreen();
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle inState) {
        View result = inflater.inflate(R.layout.fragment_about, container, false);


        return result;
    }

}
