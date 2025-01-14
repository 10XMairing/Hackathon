package com.github.tenx.agtechfarmer.ui.Function;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.github.tenx.agtechfarmer.R;
import com.github.tenx.agtechfarmer.data.prefs.AppPreferencesHelper;
import com.github.tenx.agtechfarmer.ui.Function.appointments.FarmerAppointmentsFragment;
import com.github.tenx.agtechfarmer.ui.Function.cart.CartFragment;
import com.github.tenx.agtechfarmer.ui.Function.createEquipments.CreateEquipmentFragment;
import com.github.tenx.agtechfarmer.ui.Function.meetingTheExpert.ExpertMeetingFragment;
import com.github.tenx.agtechfarmer.ui.Function.myEquipments.MyEquipments;
import com.github.tenx.agtechfarmer.ui.Function.notification.FarmerNotificationFragment;
import com.github.tenx.agtechfarmer.ui.Function.profile.MyProfileFragment;
import com.github.tenx.agtechfarmer.ui.Function.shop.ShopFragment;
import com.github.tenx.agtechfarmer.ui.Function.articles.ArticlesFragment;
import com.github.tenx.agtechfarmer.ui.Function.contactExperts.ContactExpertsFragment;
import com.github.tenx.agtechfarmer.ui.Function.prediction.PredictionFragment;
import com.github.tenx.agtechfarmer.ui.Function.questions.QuestionFragment;
import com.github.tenx.agtechfarmer.ui.Services.ServicesActivity;
import com.github.tenx.agtechfarmer.utils.Constants;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import maes.tech.intentanim.CustomIntent;

public class FunctionActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    FunctionViewModel viewModel;

    private static final String TAG = "sudoCoder";

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;


    @Inject
    ArticlesFragment articlesFragment;
    @Inject
    ContactExpertsFragment contactExpertsFragment;
    @Inject
    PredictionFragment predictionFragment;
    @Inject
    QuestionFragment questionFragment;
    @Inject
    ShopFragment shopFragment;
    @Inject
    CartFragment cartFragment;
    @Inject
    FarmerAppointmentsFragment farmerAppointmentsFragment;

    @Inject
    FarmerNotificationFragment farmerNotificationFragment;

    @Inject
    CreateEquipmentFragment createEquipmentFragment;

    @Inject
    MyEquipments myEquipmentsFragment;

    @Inject
    ExpertMeetingFragment expertMeetingFragment;

    @Inject
    AppPreferencesHelper preferencesHelper;

    @Inject
    MyProfileFragment myProfileFragment;

    int flagId = 0;
    boolean flagState = true;
    @BindView(R.id.titleText)
    TextView titleText;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);
        ButterKnife.bind(this);

        //To make the injections
        AndroidInjection.inject(this);

        if (viewModel == null)
            Log.d(TAG, "onCreate: ViewModel is empty");
        else
            Log.d(TAG, "onCreate: ViewModel is not empty");




        flagId = getIntent().getExtras().getInt(Constants.SELECTED_ID);
        flagState = getIntent().getExtras().getBoolean(Constants.FLAG_BUSINESS);

        fragmentManager = getSupportFragmentManager();

        Log.d(TAG, "onCreate: Preferences::: Token id::: " +preferencesHelper.getAccessToken());
        inititalizeFragment(flagId,flagState);
        Log.d(TAG, "onCreate: Flag id ::: " + flagId);

        Log.d(TAG, "onCreate: Reached here.");

       // Log.d(TAG, "onCreate: " + appPreferencesHelper.getAccessToken());



    }

    private void inititalizeFragment(int flagId, boolean flagState) {

        if (flagState) {

            switch (flagId) {

                case 0:
                    goToNextActivity();
                    setUpToolBar("Services");
                    break;
                case 1:
                    initFrag(shopFragment);
                    setUpToolBar("Shop");
                    break;
                case 2:
                    initFrag(questionFragment);
                    setUpToolBar("Post a Question");
                    break;
                case 3:
                    initFrag(contactExpertsFragment);
                    setUpToolBar("Contact the Experts");
                    break;
                case 4:
                    initFrag(articlesFragment);
                    setUpToolBar("Articles");
                    break;

            }

        }
        else{
            switch (flagId) {
                case 0:
                    initFrag(farmerNotificationFragment);
                    setUpToolBar("Notifications");
                    break;
                case 1:
                    initFrag(predictionFragment);
                    Log.d(TAG, "inititalizeFragment: LALALLA predfictions");
                    setUpToolBar("Predict my Production");
                    break;
                case 2:
                    initFrag(cartFragment);
                    Log.d(TAG, "inititalizeFragment: CARTSSSSs");
                    setUpToolBar("Your cart");
                    break;
                case 3:
                    initFrag(farmerAppointmentsFragment);
                    setUpToolBar("Appointments");
                    break;
                case 4:
                    initFrag(myEquipmentsFragment);
                    setUpToolBar("Lend Equipment");
                    break;
                case 5:initFrag(myProfileFragment);
                setUpToolBar("My Profile");
                break;
            }

        }
    }

    private void setUpToolBar(String title) {
        titleText.setText(title);

    }

    private void initFrag(Fragment fragment) {

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frame_layout, fragment);
        ft.commit();

    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;

    }

    @Override
    public void finish() {
        super.finish();
        CustomIntent.customType(this,"right-to-left");
    }

    private void goToNextActivity() {

        Intent intent = new Intent(this, ServicesActivity.class);
        startActivity(intent);
        CustomIntent.customType(this,"left-to-right");


    }

}


