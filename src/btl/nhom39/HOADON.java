package btl.nhom39;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class HOADON implements Serializable {

    private String maNVBan;
    private String maThue;
    private String maHD;
    private int soLuongSP;

    ArrayList<MATHANG> mh = new ArrayList();
    ArrayList<MATHANG> cthd = new ArrayList();
    ArrayList<KHACHHANG> kh = new ArrayList();
    ArrayList<NHANVIEN> nv = new ArrayList();

    @Override
    public String toString() {
        return maNVBan + "\t" + maThue + "\t" + maHD + "\t" + soLuongSP;
    }

    public int getSoLuongSP() {
        return soLuongSP;
    }

    public HOADON(int soLuongSP) {
        this.soLuongSP = soLuongSP;
    }

    public HOADON(String maNVBan, String maThue, String maHD, int slsp) {
        this.maNVBan = maNVBan;
        this.maThue = maThue;

        this.maHD = maHD;
        this.soLuongSP = slsp;
    }

    HOADON() {

    }

    public String getMaHD() {
        return this.maHD;
    }

    public String getMaNVBan() {
        return this.maNVBan;
    }

    public String getMaThue() {
        return this.maThue;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public void setMaNVBan(String maNVBan) {
        this.maNVBan = maNVBan;
    }

    public void setmaThue(String soDTKH) {
        this.maThue = soDTKH;
    }

    public boolean fileCheckDataMH(String maHangban) {
        for (MATHANG a : mh) {
            if (a.getMaSoHang().equals(maHangban)) {
                return true;
            }
        }
        return false;
    }

    public boolean fileCheckDataSL(int ct1, String maHangban) {

        for (int i = 0; i < mh.size(); i++) {
            if ((mh.get(i).getMaSoHang().equals(maHangban))&& (mh.get(i).getSoLuong() - ct1 >= 0)) {
         
                MATHANG a2 = new MATHANG();
                
                a2 = mh.get(i);
                   
                a2.setSoLuong(ct1);
                System.out.println(a2.toString());
                this.cthd.add(a2);
                mh.clear();
                return true;
            }
        }
        return false;
    }

    public boolean checkForupdate(int ct1, String maHangban) {
        Data();
        for (int i = 0; i < mh.size(); i++) {
            if ((mh.get(i).getMaSoHang().equals(maHangban)) && (mh.get(i).getSoLuong() - ct1 >= 0)) {
                MATHANG a = new MATHANG();

                a = mh.get(i);

                a.setSoLuong(mh.get(i).getSoLuong() - ct1);

                mh.set(i, a);
                return true;
            }
        }
        return false;
    }

    public void Data() {
        try {
            ArrayList<NHANVIEN> nv = new ArrayList();
            nv.clear();
            FileReader frnv = new FileReader("nhanvien.txt");
            BufferedReader brnv = new BufferedReader(frnv);
            String line = "";
            while (true) {
                line = brnv.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split("\t");
                String name = txt[0];
                String gTinhString = txt[1];
                String diaChi = txt[2];
                int ns = Integer.parseInt(txt[3]);
                String SDT = txt[4];
                String ma = txt[5];
                float hSL = Float.parseFloat(txt[6]);
                int nc = Integer.parseInt(txt[7]);

                this.nv.add(new NHANVIEN(name, gTinhString, diaChi, ns, SDT, ma, hSL, nc));
            }
            ArrayList<MATHANG> mh = new ArrayList<>();
            mh.clear();
            FileReader frmh = new FileReader("mathang.txt");
            BufferedReader brmh = new BufferedReader(frmh);

            while (true) {
                line = brmh.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split("\t");
                String name = txt[0];
                String hangSX = txt[1];
                String mahang = txt[2];
                int soluong = Integer.parseInt(txt[3]);
                float gia = Float.parseFloat(txt[4]);
                this.mh.add(new MATHANG(name, hangSX, mahang, soluong, gia));
            }
            ArrayList<KHACHHANG> kh = new ArrayList<>();
            kh.clear();
            FileReader frkh = new FileReader("khachhang.txt");
            BufferedReader brkh = new BufferedReader(frkh);
            while (true) {
                line = brkh.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split("\t");
                String name = txt[0];
                String gTinhString = txt[1];
                String diaChi = txt[2];
                int ns = Integer.parseInt(txt[3]);
                String SDT = txt[4];
                String ma = txt[5];

                this.kh.add(new KHACHHANG(name, gTinhString, diaChi, ns, SDT, ma));
                frkh.close();
                brkh.close();
                frnv.close();
                brnv.close();
                frmh.close();
                brmh.close();
            }

        } catch (Exception e) {
        }
    }

    public void docFile() {

        try {
            kh.clear();
            FileReader fr = new FileReader("khachhang.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split("\t");
                String name = txt[0];
                String gTinhString = txt[1];
                String diaChi = txt[2];
                int ns = Integer.parseInt(txt[3]);
                String SDT = txt[4];

                String ma = txt[5];

                this.kh.add(new KHACHHANG(name, gTinhString, diaChi, ns, SDT, ma));
            }

        } catch (FileNotFoundException var5) {
            System.out.print("\nfile bị lỗi!");
        } catch (Exception var6) {
            System.out.print("\nChưa có thông tin, vui lòng nhập trước!");
        }
    }

    public boolean fileCheckDataKH(String st) {

        docFile();
        for (KHACHHANG a : kh) {

            if (a.getMaSoThue().equals(st)) {
                return true;
            }
        }
        return false;
    }

    public boolean fileCheckDataNV(String hd1) {
        for (NHANVIEN a : nv) {

            if (a.getMaNV().equals(hd1)) {
                return true;
            }

        }
        return false;
    }

    public void nhap() {
        Data();
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhập mã hợp đồng: ");
        this.maHD = sc.nextLine();

        System.out.print("Nhập mã số thuế khách hàng: ");
        this.maThue = sc.nextLine();
        if (fileCheckDataKH(maThue)) {
        } else {
            System.out.println("nhap thong tin khach hang sai");
            System.exit(0);
        }
        System.out.print("Nhập mã số nhân viên: ");
        this.maNVBan = sc.nextLine();
        if (fileCheckDataNV(maNVBan)) {
        } else {
            System.out.println("nhap thong tin nhan vien sai");
            System.exit(0);
        }
        System.out.print("Nhập số sản phẩm mua: ");
        soLuongSP = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < this.soLuongSP; ++i) {
            String maMHMua;
            System.out.print("\nNhập mã mặt hàng mua:");
            maMHMua = sc.nextLine();
            if (fileCheckDataMH(maMHMua)) {
            } else {
                System.out.println("nhap thong tin mat hang sai");
                System.exit(0);
            }
            System.out.print("\nnhập số lượng muốn mua:");
            int soLuongMua = Integer.parseInt(sc.nextLine());
            if (fileCheckDataSL(soLuongMua, maMHMua)) {
                checkForupdate(soLuongMua, maMHMua);
            } else {
                System.out.println("nhap thong tin so luong san pham sai");
                System.exit(0);

            }

        }
        updateDataMH();
    }

    public void updateDataMH() {
        try {

            FileWriter fw = new FileWriter("mathang.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (MATHANG a : mh) {
                bw.write(a.toString());

                bw.newLine();
            }
            bw.close();
            fw.close();

        } catch (Exception e) {
        }
    }

    public String chechNamekh(String a1) {
        for (KHACHHANG a : kh) {
            if (a.getMaSoThue().equals(a1)) {
                return a.getHoTen();
            }
        }
        return "NO DATA!!!";

    }

    public String chechNamenv(String a1) {
        for (NHANVIEN a : nv) {
            if (a.getMaNV().equals(a1)) {
                return a.getHoTen();
            }
        }
        return "NO DATA!!!";

    }

    public String chechdAddKH(String a1) {
        for (KHACHHANG a : kh) {
            if (a.getMaSoThue().equals(a1)) {
                return a.getDiaChi();
            }
        }
        return "NO DATA!!!";

    }

    public String chechdPhoneNumberKH(String a1) {
        for (KHACHHANG a : kh) {
            if (a.getMaSoThue().equals(a1)) {
                return a.getSoDT();
            }
        }
        return "NO DATA!!!";

    }

    public void tableHead() {
        System.out.printf("\n%5s", "STT");
        System.out.printf("%25s", "TÊN MĂT HÀNG");
        System.out.printf("%10s", "SỐ LƯỢNG");
        System.out.printf("%15s", "ĐƠN GIÁ");
        System.out.printf("%15s%n", "THÀNH TIỀN");
    }

    public void xuat() {
        int SL = 0;
        float thanhtien = 0;
        System.out.printf(" \nMã hoá Đơn: " + this.maHD);
        System.out.printf("\nTên khách hàng: " + chechNamekh(this.maThue));
        System.out.printf("\nĐịa chỉ: " + chechdAddKH(this.maThue));
        System.out.printf("\nSĐT: " + chechdPhoneNumberKH(this.maThue));
        tableHead();
        for (int i = 0; i < cthd.size(); ++i) {
            System.out.printf("%5d", (i + 1));
            System.out.printf("%25s", cthd.get(i).getTenMatHang());
            System.out.printf("%10d", cthd.get(i).getSoLuong());
            System.out.printf("%15.0f", cthd.get(i).getGiaTien());
            System.out.printf("%15.0f%n", sumcurr(cthd.get(i).getSoLuong(), cthd.get(i).getGiaTien()));
            thanhtien += sumcurr(cthd.get(i).getSoLuong(), cthd.get(i).getGiaTien());
            SL += cthd.get(i).getSoLuong();

        }
        System.out.printf("\n\n\n%30s", "TỔNG CỘNG");
        System.out.printf("%10d", SL);
        System.out.printf("%15s", "      ");
        System.out.printf("%15.0f", thanhtien);
        System.out.print("\n\n\n\n\t\t\t TEN NV BAN");
        System.out.print("\n\n\t\t\t\t" + chechNamenv(this.maNVBan));
    }

    public float sumcurr(int sl, float tien) {
        return sl * tien;
    }
}
