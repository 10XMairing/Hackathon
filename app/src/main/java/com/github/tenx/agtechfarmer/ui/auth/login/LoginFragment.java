package com.github.tenx.agtechfarmer.ui.auth.login;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;

import com.github.tenx.agtechfarmer.R;
import com.github.tenx.agtechfarmer.data.models.auth.LoginBody;
import com.github.tenx.agtechfarmer.ui.auth.AuthViewModel;
import com.github.tenx.agtechfarmer.ui.auth.registration.RegistrationFragment;
import com.github.tenx.agtechfarmer.ui.main.MainActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    private static final String TAG = "LoginFragment";

    @BindView(R.id.email)
    TextInputEditText email;
    @BindView(R.id.password)
    TextInputEditText password;
    @BindView(R.id.singin)
    MaterialButton singin;
    @BindView(R.id.register)
    MaterialButton register;
    @BindView(R.id.email_login_form)
    LinearLayout emailLoginForm;

    @Inject
    RegistrationFragment registrationFragment;
    @BindView(R.id.layout)
    LinearLayout layout;
    @BindView(R.id.spin_kit)
    ProgressBar spinKit;
    @BindView(R.id.tv_login_text)
    TextView tvLoginText;

    @Inject
    AuthViewModel viewModel;



    @Inject
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);


        AndroidSupportInjection.inject(this);
        ButterKnife.bind(this, view);

        subscribeObservers();


        return view;
    }

    private void subscribeObservers() {
        viewModel.getLoginResponse().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){

                    Log.d(TAG, "onChanged: Login Complete");
                    spinKit.setVisibility(View.INVISIBLE);
                    Snackbar.make(layout,"Login Complete",Snackbar.LENGTH_SHORT).show();


                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                    getActivity().finish();

                }else{
                    Log.d(TAG, "onChanged: Loading ");
                }
            }
        });
    }


    @Override
    public void onAttach(Context context) {

        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }


    @OnClick({R.id.singin, R.id.register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.singin:
                signIn();
                break;
            case R.id.register:
                initializeFrag(registrationFragment);
                break;
        }
    }

    public void initializeFrag(Fragment frag) {
        String backStateName = frag.getClass().toString();
        //Log.d(TAG, "onBtnOtpLoginClicked: " + backStateName);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);

        transaction.replace(R.id.frame_layout, frag);
        transaction.addToBackStack(backStateName);

        transaction.commit();
    }


    public void signIn() {

        String emailStr = email.getText().toString();
        String passwordStr = password.getText().toString();

        if (!Patterns.EMAIL_ADDRESS.matcher(emailStr).matches()) {
            Snackbar.make(layout, "Enter valid Email", Snackbar.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(passwordStr) || passwordStr.length() < 6) {
            Snackbar.make(layout, "Password should have atleast 6 literals", Snackbar.LENGTH_LONG).show();
            return;
        }

        spinKit.setVisibility(View.INVISIBLE);
        //TODO the signIn
        viewModel.loginFarmer(new LoginBody(emailStr,passwordStr));



    }

}
