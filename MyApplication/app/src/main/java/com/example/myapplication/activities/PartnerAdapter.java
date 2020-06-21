package com.example.myapplication.activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Database.Object.Partner;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class PartnerAdapter extends RecyclerView.Adapter<PartnerAdapter.ViewHolder> {
    List<Partner> partnerArrayList = new ArrayList<>();
    OnItemClickListener mListener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public PartnerAdapter(List<Partner> partnerArrayList) {
        this.partnerArrayList = partnerArrayList;
    }

    @NonNull
    @Override
    public PartnerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.partner_row, parent, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PartnerAdapter.ViewHolder holder, int position) {
        holder.name.setText(partnerArrayList.get(position).getNamePartner());
        holder.address.setText(partnerArrayList.get(position).getAddressPartner());
        holder.phone.setText(partnerArrayList.get(position).getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return partnerArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView address;
        public TextView phone;
        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            name = itemView.findViewById(R.id.partnerName);
            address = itemView.findViewById(R.id.partnerAddress);
            phone = itemView.findViewById(R.id.partnerPhone);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
