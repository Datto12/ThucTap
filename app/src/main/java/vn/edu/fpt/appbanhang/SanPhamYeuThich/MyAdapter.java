package vn.edu.fpt.appbanhang.SanPhamYeuThich;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vn.edu.fpt.appbanhang.R;
import vn.edu.fpt.appbanhang.SanPhamMoi.SpMoi;

public class MyAdapter  extends BaseAdapter {
    private ArrayList<SpMoi> list;
     private Context context;
     private int layoutitem;

    public MyAdapter(ArrayList<SpMoi> list, Context context, int layoutitem) {
        this.list = list;
        this.context = context;
        this.layoutitem = layoutitem;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 2;
    }

    public static class ViewHodels{
        private TextView tvtensp, tvgiasp;
        private ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodels viewHodels = null;
        if(convertView==null){
            viewHodels  =new ViewHodels();
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =inflater.inflate(layoutitem,null);
            viewHodels.img = convertView.findViewById(R.id.imgListSpLike);
            viewHodels.tvgiasp = convertView.findViewById(R.id.giasplike);
            viewHodels.tvtensp = convertView.findViewById(R.id.tensplike);
            convertView.setTag(viewHodels);
        }else {
            viewHodels = (ViewHodels) convertView.getTag();
        }
        Picasso.get().load(list.get(position).getHinhanh()).into(viewHodels.img);
        viewHodels.tvtensp.setText(list.get(position).getTensp());
        viewHodels.tvgiasp.setText(list.get(position).getGiasp() + " đ");
        return convertView;
    }
}
