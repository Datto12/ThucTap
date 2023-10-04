package vn.edu.fpt.appbanhang.DienThoai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.fpt.appbanhang.R;
import vn.edu.fpt.appbanhang.Retrofit.MyRetrofit;

public class ChiTietDienThoaiActivity extends AppCompatActivity {
    private ImageView img;
    private TextView tvTen , tvGia, tvMota;
    private Button btnMua;
    private ArrayList<ChiTietDienThoai> list;
    private String id_dienthoai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_dien_thoai);
        img = findViewById(R.id.imgChiTietDienThoai);
        tvTen = findViewById(R.id.tenChiTietDienThoai);
        tvGia = findViewById(R.id.giaChiTietDienThoai);
        tvMota = findViewById(R.id.motaChiTietDienThoai);
        btnMua = findViewById(R.id.btnMuaDienThoai);
        ChiTiet();
    }
    public void ChiTiet(){
        Handler handler = new Handler(Looper.getMainLooper());
        String id = getIntent().getStringExtra("id_dienthoai");
        MyRetrofit.api.getChiTietDienThoai(id).enqueue(new Callback<DuLieuChiTietDienThoai>() {
            @Override
            public void onResponse(Call<DuLieuChiTietDienThoai> call, Response<DuLieuChiTietDienThoai> response) {
                DuLieuChiTietDienThoai dl = response.body();
                String tensp =dl.getData().get(0).getTensp();
                String giasp = dl.getData().get(0).getGiasp();
                String hinhanh = dl.getData().get(0).getHinhanh();
                String mota = dl.getData().get(0).getMota();
                id_dienthoai = dl.getData().get(0).getId();

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tvTen.setText(tensp);
                        tvGia.setText(giasp);
                        tvMota.setText(mota);
                        Picasso.get().load(hinhanh).into(img);
                    }
                });
            }

            @Override
            public void onFailure(Call<DuLieuChiTietDienThoai> call, Throwable t) {

            }
        });
    }
}