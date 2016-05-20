package hu.bme.aut.animalfindapplication;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import hu.bme.aut.animalfindapplication.ui.UIModule;

/**
 * Created by Norbert on 2016. 04. 10..
 */
public class AnimalFindApplication extends Application {

    public static AnimalFindApplicationComponent injector;
    private Tracker mTracker;

    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerMockAnimalFindApplicationComponent.builder().uIModule(new UIModule()).build();
    }

    public void setInjector(AnimalFindApplicationComponent injector) {
        AnimalFindApplication.injector = injector;
    }

    public AnimalFindApplicationComponent getInjector() {
        return injector;
    }
}
