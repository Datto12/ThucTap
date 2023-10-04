package vn.edu.fpt.appbanhang.DienThoai;

import java.util.ArrayList;

public class DuLieuDT {
    private String msg;
    private ArrayList<DienThoai> data;

    public DuLieuDT(String msg, ArrayList<DienThoai> data) {
        this.msg = msg;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ArrayList<DienThoai> getData() {
        return data;
    }

    public void setData(ArrayList<DienThoai> data) {
        this.data = data;
    }
}
