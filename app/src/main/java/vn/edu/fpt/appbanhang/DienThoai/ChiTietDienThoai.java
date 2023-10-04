package vn.edu.fpt.appbanhang.DienThoai;

public class ChiTietDienThoai {
    private String tensp;
    private String giasp;
    private String hinhanh;
    private String id;
    private String mota;

    public ChiTietDienThoai(String tensp, String giasp, String hinhanh, String id, String mota) {
        this.tensp = tensp;
        this.giasp = giasp;
        this.hinhanh = hinhanh;
        this.id = id;
        this.mota = mota;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getGiasp() {
        return giasp;
    }

    public void setGiasp(String giasp) {
        this.giasp = giasp;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
