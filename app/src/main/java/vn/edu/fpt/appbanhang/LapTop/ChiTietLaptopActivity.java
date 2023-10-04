package vn.edu.fpt.appbanhang.LapTop;

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
import vn.edu.fpt.appbanhang.DienThoai.ChiTietDienThoai;
import vn.edu.fpt.appbanhang.R;
import vn.edu.fpt.appbanhang.Retrofit.MyRetrofit;

public class ChiTietLaptopActivity extends AppCompatActivity {
    private ImageView img;
    private TextView tvTen , tvGia, tvMota;
    private Button btnMua;
    private ArrayList<ChiTietLaptop> list;
    private String id_laptop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_laptop);
        AnhXa();
        ChiTiet();
    }

    public void AnhXa(){
        img = findViewById(R.id.imgChiTietLaptop);
        tvTen = findViewById(R.id.tenChiTietLaptop);
        tvGia = findViewById(R.id.giaChiTietLaptop);
        tvMota = findViewById(R.id.motaChiTietLaptop);
        btnMua = findViewById(R.id.btnMualaptop);
    }
    public void ChiTiet(){
        String id = getIntent().getStringExtra("id_laptop");
        Handler handler = new Handler(Looper.getMainLooper());
        MyRetrofit.api.getChiTietLaptop(id).enqueue(new Callback<DuLieuChiTietLaptop>() {
            @Override
            public void onResponse(Call<DuLieuChiTietLaptop> call, Response<DuLieuChiTietLaptop> response) {
                DuLieuChiTietLaptop dl = response.body();
                String tensp = dl.getData().get(0).getTensp();
                String giasp = dl.getData().get(0).getGiasp();
                String mota = dl.getData().get(0).getMota();
                String hinhanh = dl.getData().get(0).getHinhanh();
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
            public void onFailure(Call<DuLieuChiTietLaptop> call, Throwable t) {

            }
        });
    }
}