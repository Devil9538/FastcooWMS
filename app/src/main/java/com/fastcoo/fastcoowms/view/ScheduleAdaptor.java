package com.fastcoo.fastcoowms.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fastcoo.fastcoowms.R;
import com.fastcoo.fastcoowms.model.Schedule_Data;
import com.fastcoo.fastcoowms.model.Schedule_Status;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScheduleAdaptor extends RecyclerView.Adapter<ScheduleAdaptor.ScheduleViewHolder> {

    private List<Schedule_Data> schedule;
    Context context;

    public ScheduleAdaptor(List<Schedule_Data> schedule, Context context) {
        this.schedule = schedule;
        this.context = context;
    }

    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.content_schedule_adaptor,parent,false);

        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
        holder.bind(schedule.get(position));

    }

    @Override
    public int getItemCount() {
        return schedule.size();
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder {

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

        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
        void bind(Schedule_Data status){
            slip.setText("Slip No: "+status.getAwb());
            sc_type.setText("Schedule: "+status.getSchedule());
            sc_date.setText("Schedule Date: "+status.getScheduleDate());
            dr_code.setText("Driver Code: "+status.getDriverCode());
            origin.setText("Origin: "+status.getOrigin());
            area.setText("Area: "+status.getDestination());
        }
    }
}
