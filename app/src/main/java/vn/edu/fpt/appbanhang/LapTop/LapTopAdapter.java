package vn.edu.fpt.appbanhang.LapTop;

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
import vn.edu.fpt.appbanhang.SanPhamYeuThich.MyAdapter;

public class LapTopAdapter extends BaseAdapter {
    private ArrayList<LapTop> list;
    private Context context;
    private int layout;

    public LapTopAdapter(ArrayList<LapTop> list, Context context, int layout) {
        this.list = list;
        this.context = context;
        this.layout = layout;
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
        return 0;
    }
    public static class ViewHodels{
        private TextView tvtensp, tvgiasp;
        private ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodels viewHodels = null;
        if(convertView==null){
            viewHodels  = new ViewHodels();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =inflater.inflate(layout,null);
            viewHodels.img = convertView.findViewById(R.id.imgLaptop);
            viewHodels.tvgiasp = convertView.findViewById(R.id.gialaptop);
            viewHodels.tvtensp = convertView.findViewById(R.id.tenlaptop);
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
