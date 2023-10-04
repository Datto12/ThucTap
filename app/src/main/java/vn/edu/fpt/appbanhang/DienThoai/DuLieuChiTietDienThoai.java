package vn.edu.fpt.appbanhang.DienThoai;

import java.util.ArrayList;

public class DuLieuChiTietDienThoai {
    private String msg;
    private ArrayList<ChiTietDienThoai> data;

    public DuLieuChiTietDienThoai(String msg, ArrayList<ChiTietDienThoai> data) {
        this.msg = msg;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ArrayList<ChiTietDienThoai> getData() {
        return data;
    }

    public void setData(ArrayList<ChiTietDienThoai> data) {
        this.data = data;
    }
}
