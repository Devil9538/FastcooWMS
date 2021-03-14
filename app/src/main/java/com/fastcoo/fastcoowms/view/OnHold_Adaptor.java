package com.fastcoo.fastcoowms.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fastcoo.fastcoowms.R;
import com.fastcoo.fastcoowms.model.OnHold_Data;
import com.fastcoo.fastcoowms.model.Schedule_Data;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OnHold_Adaptor extends RecyclerView.Adapter<OnHold_Adaptor.OnHoldViewHolder> {

    private List<OnHold_Data> onHold;
    Context context;

    public OnHold_Adaptor(List<OnHold_Data> onHold, Context context) {
        this.onHold = onHold;
        this.context = context;
    }

    @NonNull
    @Override


    public OnHoldViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.content_onhold_adaptor,parent,false);
        return new OnHoldViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OnHoldViewHolder holder, int position) {
        holder.bind(onHold.get(position));
    }

    @Override
    public int getItemCount() {
        return onHold.size();
    }

    public class OnHoldViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_slipdetail)
        TextView slip;
        @BindView(R.id.tv_schedule_type)
        TextView sc_type;
        @BindView(R.id.tv_schedule_date)
        TextView sc_date;
        @BindView(R.id.tv_messenger_code)
        TextView dr_code;
        @BindView(R.id.tv_messenger_name)
        TextView origin;
        @BindView(R.id.tv_area)
        TextView area;
        public OnHoldViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
        void bind(OnHold_Data status){
            slip.setText("Slip No: "+status.getAwb());
            sc_type.setText("Destination: "+status.getDestination());
            sc_date.setText("Schedule Date: "+status.getScheduleDate());
            dr_code.setText("OnHold: "+status.getOnHold());
            origin.setText("Origin: "+status.getOrigin());
            area.setText("OnHold Confirm: "+status.getOnHoldConfirm());
        }

    }
}
