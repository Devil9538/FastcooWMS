package com.fastcoo.fastcoowms.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fastcoo.fastcoowms.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShipmentInfo_Adaptor extends RecyclerView.Adapter<ShipmentInfo_Adaptor.ShipmentViewHolder> {

    @NonNull
    @Override
    public ShipmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.shipmentinfo_adaptor,parent,false);
        return new  ShipmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShipmentViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ShipmentViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_shipment_no)
        TextView shipment_no;
        @BindView(R.id.tv_1_detail)
        TextView tv1;
        @BindView(R.id.tv_2_detail)
        TextView tv2;
        @BindView(R.id.tv_3_detail)
        TextView tv3;
        @BindView(R.id.tv_4_detail)
        TextView tv4;

        public ShipmentViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }
}
