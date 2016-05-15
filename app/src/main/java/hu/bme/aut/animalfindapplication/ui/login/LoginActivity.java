package hu.bme.aut.animalfindapplication.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import hu.bme.aut.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.R;
import hu.bme.aut.animalfindapplication.model.user.User;
import hu.bme.aut.animalfindapplication.ui.main.MainActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginScreen {

    @Inject
    LoginPresenter loginPresenter;

    Button bLogin;
    EditText etUsername, etPassword;
    Button bRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        AnimalFindApplication.injector.inject(this);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin = (Button) findViewById(R.id.bLogin);

        bLogin.setOnClickListener(this);
        bRegister = (Button) findViewById(R.id.bRegister);
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

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

                login();
                break;
        }
    }


    @Override
    public void login() {
        User user = new User();
        user.setName(etUsername.getText().toString());
        user.setPassword(etPassword.getText().toString());
        if(loginPresenter.login(user)) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void logout() {

    }

    @Override
    public void register() {
        User user = new User();
        user.setName(etUsername.getText().toString());
        user.setPassword(etPassword.getText().toString());
        loginPresenter.register(user);
        login();
    }
}
