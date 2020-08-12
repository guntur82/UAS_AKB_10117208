package com.wisataku_10117208;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;
/*
tgl : 10/8/2020
nim : 10117208
nama : guntur prakasa irwan
 */
public class AlamatAdapter extends RecyclerView.Adapter<AlamatAdapter.MapsViewHolder> {

    private ArrayList<Wisata> dataList = new ArrayList<>();
    private ArrayList<Wisata> wisataList;
    private OnMapsListener mOnMapsListener;
    LayoutInflater inflter;

    protected Cursor cursor;
    private static final int REQUEST = 112;
    int mResources[] = {
            R.drawable.pict1,
            R.drawable.pict2,
            R.drawable.pict3,
            R.drawable.pict4,
            R.drawable.pict5,
            R.drawable.pict6,
            R.drawable.pict7,
            R.drawable.pict8,
            R.drawable.pict9,

    };
    public AlamatAdapter(Context context, ArrayList<Wisata> dataList, ListFragment OnMapsListener){
        this.dataList = dataList;
        this.wisataList = dataList;
        this.mOnMapsListener = OnMapsListener;
        inflter = (LayoutInflater.from(context));
    }

    public MapsViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new MapsViewHolder(view,mOnMapsListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AlamatAdapter.MapsViewHolder holder, int position) {
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtalamat.setText(dataList.get(position).getTempat());
        holder.imageView.setImageResource(mResources[position]);
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }


    public class MapsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        RelativeLayout parentLayout;
        OnMapsListener onMapsListener;
        TextView txtNama, txtalamat;
        ImageView imageView;
        private static final int REQUEST_CALL = 1;
        public MapsViewHolder(@NonNull View itemView, OnMapsListener OnMapsListener) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama);
            txtalamat = (TextView) itemView.findViewById(R.id.txt_alamat);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            mOnMapsListener = OnMapsListener;
            itemView.setOnClickListener(this);
        }
        public void onClick(View v) {
            Log.d(TAG, "onClick: " + getAdapterPosition());
            mOnMapsListener.onMapsClick(getAdapterPosition());
        }
    }
    public interface OnMapsListener {
        void onMapsClick(int position);
    }

}
