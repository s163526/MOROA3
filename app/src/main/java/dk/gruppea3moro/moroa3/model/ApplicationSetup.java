package dk.gruppea3moro.moroa3.model;

import android.app.Application;

public class ApplicationSetup extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppState.resetPM();
        AppState.get().saveToPM(getApplicationContext());


    }
}
