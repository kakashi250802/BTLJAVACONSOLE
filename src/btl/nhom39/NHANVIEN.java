/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl.nhom39;

import java.io.Serializable;
import java.util.Scanner;

public class NHANVIEN extends PERSON {
    private String maNV;
    private int ngayCong;
    private final float luongNgay = 1800000;
    private float hSLuong;
    public NHANVIEN(String ten, String gTinh, String dChi, int nSinh, String sdt, String ma, float hsl, int nc) {
        super(ten, gTinh, dChi, nSinh, sdt);
        this.maNV = ma;
        this.hSLuong = hsl;
        this.ngayCong = nc;
}
        public NHANVIEN() {
        this.maNV = "0";
        this.ngayCong=0;
        this.hSLuong = 0.0F;
        
    }
public void nhap(){
     Scanner SC = new Scanner(System.in);
        super.nhap();
        System.out.print("Nhập mã nhân viên: ");
        this.maNV = SC.nextLine();
        System.out.print("Nhập số ngày công: ");
        this.ngayCong = SC.nextInt();
        System.out.print("Nhập hệ số lương: ");
        this.hSLuong = SC.nextFloat();

}

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setHeSoLuong(float heSoLuong) {
        this.hSLuong = heSoLuong;
    }

    public void setNgayCong(int ngayCong) {
        this.ngayCong = ngayCong;
    }

    public int getNgayCong() {
        return this.ngayCong;
    }

    public String getMaNV() {
        return this.maNV;
    }

    public float getHeSoLuong() {
        return this.hSLuong;
    }

    public float tinhLuong() {
        return (float)this.ngayCong * this.hSLuong * 1600000.0F;
    }
public void xuat(){
super.xuat();
System.out.printf("%15s%15d%15.1f%20.0f\n", this.maNV, this.ngayCong, this.hSLuong, this.tinhLuong());
}

public String toString() {
        String var10000 = super.toString();
        return var10000 + "\t" + this.maNV + "\t" + String.format("%.0f", this.hSLuong) +"\t"+this.ngayCong;
    }
}

