package hu.bme.aut.animalfindapplication.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import hu.aut.bme.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.R;
import hu.bme.aut.animalfindapplication.model.user.User;
import hu.bme.aut.animalfindapplication.model.user.UserLocalStore;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginScreen {

    @Inject
    LoginPresenter loginPresenter;

    Button bLogin;
    EditText etUsername, etPassword;
    TextView tvRegisterLink;

    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        AnimalFindApplication.injector.inject(this);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);
        bLogin = (Button) findViewById(R.id.bLogin);

        bLogin.setOnClickListener(this);
        tvRegisterLink.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loginPresenter.attachScreen(this);


    }

    @Override
    protected void onStop() {
        super.onStop();
        loginPresenter.detachScreen();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bLogin:

                User user = new User(null, null);

                userLocalStore.storeUserData(user);
                userLocalStore.setUserLoggedIn(true);
                break;
            case R.id.tvRegisterLink:
                startActivity(new Intent(this, Register.class));
                break;
        }
    }


}
