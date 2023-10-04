package vn.edu.fpt.appbanhang.DienThoai;

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

import vn.edu.fpt.appbanhang.R;
import vn.edu.fpt.appbanhang.Retrofit.MyRetrofit;


public class DienThoaiFragment extends Fragment {

    private DienThoaiAdapter adapter;
    private GridView gridView;
    private ArrayList<DienThoai> list;
    private String id_dienthoai;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    public DienThoaiFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DienThoaiFragment newInstance() {
        DienThoaiFragment fragment = new DienThoaiFragment();

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
        return inflater.inflate(R.layout.fragment_dien_thoai, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        gridView = view.findViewById(R.id.GridViewDienThoai);


        getDienThoai();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DienThoai dienThoai = list.get(position);
                id_dienthoai = dienThoai.getId();
                Intent intent = new Intent(getActivity(),ChiTietDienThoaiActivity.class);
                intent.putExtra("id_dienthoai",id_dienthoai);
                startActivity(intent);
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }
    public void getDienThoai(){
        MyRetrofit.api.getListDienThoai().enqueue(new Callback<DuLieuDT>() {
            @Override
            public void onResponse(Call<DuLieuDT> call, Response<DuLieuDT> response) {
                if(response.body()!=null){
                    list = new ArrayList<>();
                    list = response.body().getData();
                    adapter = new DienThoaiAdapter(list,getActivity(),R.layout.item_dienthoai);
                    gridView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<DuLieuDT> call, Throwable t) {

            }
        });
    }
}