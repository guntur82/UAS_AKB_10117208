package com.wisataku_10117208;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/*
tgl : 10/8/2020
nim : 10117208
nama : guntur prakasa irwan
 */
public class ListFragment extends Fragment implements AlamatAdapter.OnMapsListener{
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
    private static final String TAG = ListFragment.class.getSimpleName();
    private RecyclerView recyclerView;
    private ImageView myImage;
    private AlamatAdapter adapter;
    TextView nama,alamat;
    protected Cursor cursor;
    ListView listView;
    DatabaseHelper myDB;
    ArrayList<Wisata> dataList;
    Wisata wisata;

    @SuppressLint("ResourceType")
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_list,container,false);
        dataList = new ArrayList<>();
        myDB = new DatabaseHelper(getContext());
        cursor = myDB.getAllData();
        int numRows = cursor.getCount();
        if(numRows == 0){
            Toast.makeText(getContext(), "Data Kosong", Toast.LENGTH_SHORT).show();
        } else {
            int i = 0;
            while (cursor.moveToNext()){
                wisata = new Wisata(cursor.getString(0),cursor.getString(1),
                        cursor.getDouble(2),cursor.getDouble(3));
                dataList.add(wisata);
            }
        }
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        nama = (TextView) rootView.findViewById(R.id.txt_nama);
        alamat = (TextView) rootView.findViewById(R.id.txt_alamat);
        recyclerView.setHasFixedSize(true);
        adapter = new AlamatAdapter(getContext(), dataList, this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListFragment.super.getContext());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

        return rootView;
    }



    public void onMapsClick(int position) {
        Log.d(TAG,"OnAlamatClick : is clicked"+position);
        Intent intent = new Intent(ListFragment.super.getContext(), Maps.class);
        intent.putExtra("nama", dataList.get(position).getNama());
        intent.putExtra("alamat", dataList.get(position).getTempat());
        intent.putExtra("lat", dataList.get(position).getLat());
        intent.putExtra("lng", dataList.get(position).getLng());

        startActivity(intent);
    }
}
