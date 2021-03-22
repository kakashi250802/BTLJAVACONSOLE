package btl.nhom39;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class DSNHANVIEN {

    private ArrayList<NHANVIEN> nv = new ArrayList();

    public void nhap() {
        docFile();
        NHANVIEN x = new NHANVIEN();
        x.nhap();
        this.nv.add(x);
    }

    public void nhapDS() {
        Scanner sc = new Scanner(System.in);
        docFile();
        int n;
        do {
            System.out.print("\nNhập số nhân viên: ");
            n = sc.nextInt();
        } while (n <= 0);

        for (int i = 0; i < n; ++i) {
            NHANVIEN x = new NHANVIEN();
            System.out.printf("\nNhập nhân viên thứ %d", i + 1);
            x.nhap();
            this.nv.add(x);
        }

    }

    public void tableH() {
        System.out.printf("\n%20s%13s%15s%13s%15s%15s%15s%15s%20s\n",
                "Họ tên", "Giới tính", "Địa chỉ", "Năm sinh", "Số DT", "Mã NV", "Ngày công", "HS lương", "Tiền lương");
    }

    public void xuatDS() {
        tableH();
        for (NHANVIEN x : nv) {
            x.xuat();
        }

    }

    public void luuFile() {
        try {
            FileWriter fw = new FileWriter("nhanvien.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (NHANVIEN a : nv) {
                bw.write(a.toString());

                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }

    public void docFile() {
        try {
            nv.clear();
            FileReader fr = new FileReader("nhanvien.txt");
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
                float hSL = Float.parseFloat(txt[6]);
                int nc = Integer.parseInt(txt[7]);

                this.nv.add(new NHANVIEN(name, gTinhString, diaChi, ns, SDT, ma, hSL, nc));
            }

        } catch (FileNotFoundException var5) {
            System.out.print("\nfile bị lỗi!");
            System.exit(0);
        } catch (Exception var6) {
            System.out.print("\nChưa có thông tin, vui lòng nhập trước!");
            System.exit(0);
        }
    }

    public void xoa1nv() {
        Scanner SC = new Scanner(System.in);
        System.out.print("\n Nhập mã nhân viên cần xoá: ");
        String xString = SC.nextLine();
        for (int i = 0; i < nv.size(); ++i) {
            if (nv.get(i).getMaNV().equals(xString)) {
                this.nv.remove(i);
                System.out.println("xoa thành công!!!");
            }

        }
    }

    public void tim1nv() {
        Scanner SC = new Scanner(System.in);
        System.out.print("\n Nhập mã nhân viên cần tìm: ");
        String xString = SC.nextLine();
        for (int i = 0; i < nv.size(); ++i) {

            if (nv.get(i).getMaNV().equals(xString)) {
                tableH();
                this.nv.get(i).xuat();
            }
        }

    }

    public void sapXepMaNV() {
        Collections.sort(this.nv, new Comparator<NHANVIEN>() {
            @Override
            public int compare(NHANVIEN o1, NHANVIEN o2) {
                return (o1.getMaNV().compareTo(o2.getMaNV()));
            }
        });
    }

    public void thayDoiTenNV() {
        Scanner SC = new Scanner(System.in);
        System.out.print("\n Nhập mã nhân viên cần thay đổi thông tin: ");
        String xString = SC.nextLine();
        for (int i = 0; i < nv.size(); ++i) {

            if (nv.get(i).getMaNV().equals(xString)) {
                System.out.print("\nMỜI nhập tên NV mới: ");
                String newName = SC.nextLine();
                nv.get(i).setHoTen(newName);
                System.out.print("\n thay đổi thành công!!!!");
            }

        }
    }
}
