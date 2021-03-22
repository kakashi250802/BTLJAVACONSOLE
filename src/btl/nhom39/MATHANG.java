
package btl.nhom39;

import java.io.Serializable;
import java.util.Scanner;
import java.util.Locale;
public class MATHANG implements Serializable{
private String tenMatHang;
    private String hangSX;
    private String maHang;
    private int soLuong;
    private float giaTien;

    public MATHANG() {
        this.tenMatHang = "0";
        this.maHang = "0";
        this.soLuong = 0;
        this.giaTien = 0.0F;
    }

    public MATHANG(String tMH,String hsx, String mSH, int sL, float gT) {
        this.tenMatHang = tMH;
        
        this.maHang = mSH;
        this.hangSX = hsx;
        this.soLuong = sL;
        this.giaTien = gT;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhập tên mặt hàng: ");
        this.tenMatHang = sc.nextLine();
        System.out.print("Nhập hãng sản xuất: ");
        this.hangSX = sc.nextLine();
        System.out.print("Nhập mã số hàng: ");
        this.maHang = sc.nextLine();
        System.out.print("Nhập số lượng: ");
        this.soLuong = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập giá tiền của sản phẩm: ");
        this.giaTien = Float.parseFloat(sc.nextLine());
    }

    public String getTenMatHang() {
        return this.tenMatHang;
    }

    public int getSoLuong() {
        return this.soLuong;
    }

    public String getMaSoHang() {
        return this.maHang;
    }

    public float getGiaTien() {
        return this.giaTien;
    }

    public String getHangSX() {
        return this.hangSX;
    }

    public void setGiaTien(float giaTien) {
        this.giaTien = giaTien;
    }

    public void setHangSX(String hangSX) {
        this.hangSX = hangSX;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setMaSoHang(String maSoHang) {
        this.maHang = maSoHang;
    }

    public void setTenMatHang(String tenMatHang) {
        this.tenMatHang = tenMatHang;
    }

    public void xuat() {
        System.out.printf("%20s%20s%15s%15d%20.0f", this.tenMatHang, this.hangSX, this.maHang, this.soLuong, this.giaTien);
    }

    public String toString() {
        return this.tenMatHang+ "\t" + this.hangSX  + "\t" + this.maHang + "\t" + this.soLuong + "\t" + String.format("%.0f",this.giaTien);
    }
}
    

