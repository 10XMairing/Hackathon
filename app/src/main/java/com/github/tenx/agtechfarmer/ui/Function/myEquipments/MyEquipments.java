package com.github.tenx.agtechfarmer.ui.Function.myEquipments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.github.tenx.agtechfarmer.R;
import com.github.tenx.agtechfarmer.ui.Function.createEquipments.CreateEquipmentFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyEquipments extends Fragment {

    @BindView(R.id.iv_topic)
    ImageView ivTopic;
    @BindView(R.id.tv_topic)
    TextView tvTopic;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Inject
    CreateEquipmentFragment createEquipmentFragment;

    @Inject
    public MyEquipments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_equipments, container, false);


        AndroidSupportInjection.inject(this);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onAttach(Context context) {

        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }


    @OnClick({R.id.iv_topic, R.id.tv_topic})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_topic:
            case R.id.tv_topic:initializeFragments(createEquipmentFragment);
                break;
        }
    }

    private void initializeFragments(Fragment frag) {

        String backStateName = frag.getClass().toString();
        //Log.d(TAG, "onBtnOtpLoginClicked: " + backStateName);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_right,R.anim.enter_from_right,R.anim.exit_to_right);

        transaction.replace(R.id.frame_layout,frag);
        transaction.addToBackStack(backStateName);

        transaction.commit();
    }
}
