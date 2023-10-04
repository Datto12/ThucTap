package vn.edu.fpt.appbanhang.LapTop;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.fpt.appbanhang.DienThoai.ChiTietDienThoaiActivity;
import vn.edu.fpt.appbanhang.DienThoai.DienThoai;
import vn.edu.fpt.appbanhang.MainActivity;
import vn.edu.fpt.appbanhang.R;
import vn.edu.fpt.appbanhang.Retrofit.MyRetrofit;


public class LapTopFragment extends Fragment {

    private LapTopAdapter adapter;

    private GridView gridView;

    private ArrayList<LapTop> list;

    private String id_laptop;

    // TODO: Rename parameter arguments, choose names that match


    public LapTopFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static LapTopFragment newInstance() {
        LapTopFragment fragment = new LapTopFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lap_top, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        gridView = view.findViewById(R.id.GridViewLaptop);
        getLapTop();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LapTop lapTop = list.get(position);
                id_laptop = lapTop.getId();
                Intent intent = new Intent(getActivity(), ChiTietLaptopActivity.class);
                intent.putExtra("id_laptop",id_laptop);
                startActivity(intent);
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }

    public void getLapTop(){
        MyRetrofit.api.getListLapTop().enqueue(new Callback<DuLieu>() {
            @Override
            public void onResponse(Call<DuLieu> call, Response<DuLieu> response) {
                if (response.body() != null) {
                    list = new ArrayList<>();
                    list = response.body().getData();
                    adapter = new LapTopAdapter(list, getActivity(),R.layout.item_laptop);
                    gridView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<DuLieu> call, Throwable t) {

            }
        });
    }
}