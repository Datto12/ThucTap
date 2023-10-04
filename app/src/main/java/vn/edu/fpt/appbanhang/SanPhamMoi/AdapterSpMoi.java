package vn.edu.fpt.appbanhang.SanPhamMoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vn.edu.fpt.appbanhang.R;

public class AdapterSpMoi extends RecyclerView.Adapter<AdapterSpMoi.ViewHodels> {
    private ArrayList<SpMoi> list;

    public AdapterSpMoi(ArrayList<SpMoi> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHodels onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listspmoi,parent,false);
        return new ViewHodels(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodels holder, int position) {
        SpMoi spMoi = list.get(holder.getAdapterPosition());
        if (spMoi ==null){
            return;
        }
        holder.tvTensp.setText(spMoi.getTensp());
        holder.tvGiasp.setText(spMoi.getGiasp() + " đ");
        Picasso.get().load(spMoi.getHinhanh()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        if(list!=null){
            return list.size();
        }
        return 0;
    }

    public class ViewHodels extends RecyclerView.ViewHolder{
        private TextView tvTensp, tvGiasp;
        private ImageView img;
        public ViewHodels(@NonNull View itemView) {
            super(itemView);
            tvGiasp = itemView.findViewById(R.id.giaspmoi);
            tvTensp = itemView.findViewById(R.id.tenspmoi);
            img = itemView.findViewById(R.id.imgListSpMoi);
        }
    }
}
