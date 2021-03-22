package btl.nhom39;
import java.io.Serializable;
import java.util.Scanner;
public class PERSON implements Serializable{
    private String hoTen;

   
    private String gioiTinh;
    private String diaChi;
    private String soDT;
    private int namSinh;
    public PERSON() {
        this.hoTen = "";
        this.gioiTinh = "";
        this.diaChi = "";
        this.namSinh = 0;
        this.soDT = "0";
    }
 public String getHoTen() {
        return hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }
    public PERSON(String ten, String gTinh, String dChi, int nSinh, String sdt) {
        this.hoTen = ten;
        this.gioiTinh = gTinh;
        this.diaChi = dChi;
        this.namSinh = nSinh;
        this.soDT = sdt;
    }
     public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhập họ tên: ");
        this.hoTen = sc.nextLine();
        System.out.print("Nhập giới tính: ");
        this.gioiTinh = sc.nextLine();
        System.out.print("Nhập địa chỉ: ");
        this.diaChi = sc.nextLine();
        System.out.print("Nhập số DT: ");
        this.soDT = sc.nextLine();
        System.out.print("Nhập năm sinh: ");
        this.namSinh = Integer.parseInt(sc.nextLine());

        
    }
     public void xuat() {
        System.out.printf("%20s%13s%15s%13d%15s", this.hoTen, this.gioiTinh, this.diaChi, this.namSinh, this.soDT);
    }
       public String toString() {
        return this.hoTen +"\t"+ this.gioiTinh+"\t"+ this.diaChi + "\t" + this.namSinh + "\t" + this.soDT;
        
    }
}
