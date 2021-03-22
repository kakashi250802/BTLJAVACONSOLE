package btl.nhom39;

import java.util.Scanner;

public class KHACHHANG extends PERSON  {

    private String maSoThue;

    public KHACHHANG() {
        this.maSoThue = "0";
    }
     public KHACHHANG(String ten, String gTinh, String dChi, int nSinh, String sdt, String mst) {
            super(ten, gTinh, dChi, nSinh, sdt);
        this.maSoThue = mst;
    }


    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã số thuế: ");
        this.maSoThue = sc.nextLine();
    }

    public String getMaSoThue() {
        return this.maSoThue;
    }
//    public String getTenKhachHang() {
//        return super.
//    }
    
    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public void xuat() {
        super.xuat();
        System.out.printf("%15s%n", this.maSoThue);
    }

    public String toString() {
        String var10000 = super.toString();
        return var10000 + "\t" + this.maSoThue;
    }

}
