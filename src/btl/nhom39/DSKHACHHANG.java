package btl.nhom39;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.Scanner;

public class DSKHACHHANG {

    private ArrayList<KHACHHANG> kh = new ArrayList();

    public DSKHACHHANG() {
    }

    public void nhap() {
        docFile();
        KHACHHANG x = new KHACHHANG();
        x.nhap();
        this.kh.add(x);
    }

    public void nhapDS() {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.print("\nNhập số khách hàng: ");
            n = sc.nextInt();
        } while (n <= 0);

        for (int i = 0; i < n; ++i) {
            KHACHHANG x = new KHACHHANG();
            System.out.printf("\nNhập khách hàng thứ %d", i + 1);
            x.nhap();
            this.kh.add(x);
        }

    }

    public void luuFile() {
        try {
            FileWriter fw = new FileWriter("khachhang.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (KHACHHANG a : kh) {
                bw.write(a.toString());
                bw.newLine();
            }

            bw.close();
            fw.close();

        } catch (IOException e) {
        }
    }

    public void tableH() {
        System.out.printf("\n%20s%13s%15s%13s%15s%15s%n",
                "Họ tên", "Giới tính", "Địa chỉ", "Năm sinh", "Số DT", "Mã số thuế");
    }

    public void xuatKH() {
        tableH();
        for (KHACHHANG a : kh) {
            a.xuat();
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

///HERE!!!
    public void xoa1KH() {
        Scanner SC = new Scanner(System.in);
        System.out.print("\n Nhập mã số thuế khách hàng cần xoá: ");
        boolean a = true;
        String xString = SC.nextLine();
        for (int i = 0; i < kh.size(); ++i) {
            if (kh.get(i).getMaSoThue().equals(xString)) {
                this.kh.remove(i);
                System.out.println("xoa thành công!!!");
                a = false;
            }

        }
        if (a) {
            System.out.println("Không có khách hàng nào có mã số thuế " + xString);
        }
    }

    public void tim1KH() {
        Scanner SC = new Scanner(System.in);
        boolean a = true;
        System.out.print("\n Nhập mã số thuế cảu khách cần tìm: ");
        String xString = SC.nextLine();
        for (int i = 0; i < kh.size(); ++i) {

            if (kh.get(i).getMaSoThue().equals(xString)) {
                tableH();
                this.kh.get(i).xuat();
                a = false;
            }
        }
        if (a) {
            System.out.println("Không có khách hàng nào có mã số thuế này " + xString);
        }
    }

    public void sapXepMaSTKH() {
        Collections.sort(this.kh, new Comparator<KHACHHANG>() {
            @Override
            public int compare(KHACHHANG o1, KHACHHANG o2) {
                return (o1.getMaSoThue().compareTo(o2.getMaSoThue()));
            }
        });
    }

    public void emtpy() {
        try {
            FileWriter fw = new FileWriter("khachhang.txt");
            fw.close();
            System.out.print("\nFile đã rỗng!");
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }
    public void thayDoiTenKhachHang() {
        Scanner SC = new Scanner(System.in);
        System.out.print("\n Nhập mã khách hàng cần thay đổi thông tin: ");
        String xString = SC.nextLine();
        boolean a=false;
        for (int i = 0; i < kh.size(); ++i) {

            if (kh.get(i).getMaSoThue().equals(xString)) {
                System.out.print("\nMỜI nhập tên khách hàng mới: ");
                String newName = SC.nextLine();
                kh.get(i).setHoTen(newName);
                System.out.print("\n thay đổi thành công!!!!");
                a=true;
                
            }

        }
        if(!a)
               System.out.print("\n không có khách hàng nào có mã "+xString);
    }
}
