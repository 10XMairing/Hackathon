package com.github.tenx.agtechfarmer.ui.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.github.tenx.agtechfarmer.R;
import com.github.tenx.agtechfarmer.data.prefs.AppPreferencesHelper;
import com.github.tenx.agtechfarmer.ui.auth.login.LoginFragment;
import com.github.tenx.agtechfarmer.ui.auth.registration.RegistrationFragment;
import com.github.tenx.agtechfarmer.ui.main.MainActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class AuthenticationActivity extends AppCompatActivity implements HasSupportFragmentInjector {


    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Inject
    AuthViewModel viewModel;

    private static final String TAG = "debuggable";

    FragmentManager fragmentManager;

    @Inject
    LoginFragment loginFragment;

    @Inject
    RegistrationFragment registrationFragment;

    AppPreferencesHelper appPreferencesHelper;

    @Override
    protected void onStart() {
        super.onStart();
        //TODO change the hint colour
        if (viewModel.getAuthToken()=="")
        {
            Log.d(TAG, "onStart: Empty Auth Token.");
        }else{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
            Log.d(TAG, "onStart: Auth Token not Empty.");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        AndroidInjection.inject(this);

        if (viewModel==null)
            Log.d(TAG, "onCreate: ViewmOdel is null");
        else
            Log.d(TAG, "onCreate: ViewModel is not null");


        Log.d(TAG, "onCreate: " + viewModel.getString());


        fragmentManager = getSupportFragmentManager();
        initFrag(registrationFragment);



      //  viewModel.setAuthToken("");
        Log.d(TAG, "onCreate: Answer is::: " + viewModel.getAuthToken() );


    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }


    private void initFrag(Fragment fragment) {

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frame_layout, fragment);
        ft.commit();

    }



}
