package com.github.tenx.agtechfarmer.ui.business.funcnatilies.notification.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.tenx.agtechfarmer.R;
import com.github.tenx.agtechfarmer.data.models.functions.appointments.FarmerAppointmentsResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class NotificationRecyclerAdapter extends RecyclerView.Adapter<NotificationRecyclerAdapter.NotificationViewHolder> {

    List<FarmerAppointmentsResponse.AppointmentBody> mList;
    private View.OnClickListener onItemClickListener;

    @Inject
    public NotificationRecyclerAdapter() {

        mList = new ArrayList<>();
    }

    public void setOnItemClickListener(View.OnClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public void updateListItems(List<FarmerAppointmentsResponse.AppointmentBody> mList){
        this.mList.addAll(mList);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_notifications,parent,false);
        return  new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
//        holder.body.setText(mList.get(position).getBody());
//        holder.name.setText(mList.get(position).getName());

       // holder.body.setText(mList.get(position).getExpertId());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView body;

        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setTag(this);
            name = itemView.findViewById(R.id.tv_name);
            body = itemView.findViewById(R.id.tv_notifications_type);
            itemView.setOnClickListener(onItemClickListener);

        }
    }
}
