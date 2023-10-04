package vn.edu.fpt.appbanhang.LapTop;

import java.util.ArrayList;

public class DuLieu {
    private String msg;
    private ArrayList<LapTop> data;

    public DuLieu(String msg, ArrayList<LapTop> data) {
        this.msg = msg;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ArrayList<LapTop> getData() {
        return data;
    }

    public void setData(ArrayList<LapTop> data) {
        this.data = data;
    }
}
