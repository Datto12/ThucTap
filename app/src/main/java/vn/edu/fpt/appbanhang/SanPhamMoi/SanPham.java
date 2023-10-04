package vn.edu.fpt.appbanhang.SanPhamMoi;

import java.util.ArrayList;

public class SanPham {
    private String msg;
    private ArrayList<SpMoi> data;

    public SanPham(String msg, ArrayList<SpMoi> data) {
        this.msg = msg;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ArrayList<SpMoi> getData() {
        return data;
    }

    public void setData(ArrayList<SpMoi> data) {
        this.data = data;
    }
}
