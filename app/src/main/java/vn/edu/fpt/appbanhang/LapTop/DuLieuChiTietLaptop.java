package vn.edu.fpt.appbanhang.LapTop;

import java.util.ArrayList;

public class DuLieuChiTietLaptop {
    private String msg;
    private ArrayList<ChiTietLaptop> data;

    public DuLieuChiTietLaptop(String msg, ArrayList<ChiTietLaptop> data) {
        this.msg = msg;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ArrayList<ChiTietLaptop> getData() {
        return data;
    }

    public void setData(ArrayList<ChiTietLaptop> data) {
        this.data = data;
    }
}
