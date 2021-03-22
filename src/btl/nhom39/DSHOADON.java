package btl.nhom39;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DSHOADON {

    ArrayList<HOADON> hd = new ArrayList();
    ArrayList<MATHANG> mh = new ArrayList();
    ArrayList<KHACHHANG> kh = new ArrayList();
    ArrayList<NHANVIEN> nv = new ArrayList();

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

    public void nhapDS() {
        Scanner sc = new Scanner(System.in);
        Data();
        int n;
        int z = 0;
        do {
            System.out.print("\nNhập số hoá đơn: ");
            n = Integer.parseInt(sc.nextLine());
        } while (n <= 0);
        for (int i = 0; i < n; ++i) {
            System.out.printf("\nNhập hoá đơn thứ %d", i + 1);
            HOADON x = new HOADON();
            x.nhap();
            this.hd.add(x);

        }
    }

    public void xuatDS() {

        Data();
        for (HOADON a : hd) {
            System.out.printf("\nHÓA DƠN BÁN HÀNG\n");
            a.xuat();

        }

    }

    public void luuFile() throws FileNotFoundException, IOException {

        File fname = new File("hoadon.txt");
        FileOutputStream fout = new FileOutputStream(fname);
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(hd);
    }

    public void docFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        File fname = new File("hoadon.txt");
        FileInputStream fin = new FileInputStream(fname);
        ObjectInputStream in = new ObjectInputStream(fin);
        this.hd = (ArrayList<HOADON>) in.readObject();
        in.close();
        fin.close();
    }

    //HERE!!!
    public void xoa1hd() {
        Scanner SC = new Scanner(System.in);
        System.out.print("\n Nhập mã hóa đơn cho hóa đơn cần xoá: ");
        boolean a = true;
        String xString = SC.nextLine();
        for (int i = 0; i < hd.size(); ++i) {
            if (hd.get(i).getMaHD().equals(xString)) {
                this.hd.remove(i);
                System.out.println("xoa thành công!!!");
                a = false;
            }

        }
        if (a) {
            System.out.println("Không có hóa đơn nào có mã số này " + xString);
        }
    }

    public void tableH() {
        System.out.printf("%20s%20s%15s%15s%20s\n", "Mã nhân viên bán", "Mã Thuế", "Mã hóa đơn", "Số lượng SP", "Giá tiền");
    }

    public void tim1hd() {
        Scanner SC = new Scanner(System.in);
        System.out.print("\n Nhập mã hóa đơn cần tìm: ");
        String xString = SC.nextLine();
        boolean a=true;
        for (int i = 0; i < hd.size(); ++i) {

            if (hd.get(i).getMaHD().equals(xString)) {
//                tableH();
                this.hd.get(i).xuat();
                a=false;
            }
        }
        if(a)
            System.out.print("không có hoá đơn nào có mã "+ xString);
    }

    public void sapXepHoaDon() {
        Collections.sort(this.hd, new Comparator<HOADON>() {

            @Override
            public int compare(HOADON o1, HOADON o2) {

                return (o1.getMaHD().compareTo(o2.getMaHD()));

            }
        });
    }

    public void thayDoiMaNVBanTrongHoaDon() {
        Scanner SC = new Scanner(System.in);
        System.out.print("\n Nhập mã hóa đơn cần thay đổi thông tin: ");
        String xString = SC.nextLine();
        for (int i = 0; i < hd.size(); ++i) {

            if (hd.get(i).getMaHD().equals(xString)) {
                System.out.print("\nMỜI nhập mã nhân viên bán mới: ");
                String newName = SC.nextLine();
                hd.get(i).setMaNVBan(newName);
                System.out.print("\n thay đổi thành công!!!!");
            }

        }
    }
    public void emtpy() {
        try {
            (new FileOutputStream("hoadon.txt")).close();
            System.out.print("\nFile đã rỗng!");
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

}
