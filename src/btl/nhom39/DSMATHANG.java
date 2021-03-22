package btl.nhom39;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DSMATHANG {

    private ArrayList<MATHANG> mh = new ArrayList();

    public DSMATHANG() {
    }

    public void nhapDS() {
        Scanner sc = new Scanner(System.in);

        int n;
        System.out.print("\nNhập số mặt hàng: ");
        n = sc.nextInt();

        for (int i = 0; i < n; ++i) {
            MATHANG x = new MATHANG();
            System.out.printf("\nNhập mặt hàng thứ %d", i + 1);
            x.nhap();
            this.mh.add(x);
        }

    }

    public void xuatDS() {
        System.out.printf("\n%20s%20s%15s%15s%20s\n", "Mặt hàng", "Hãng SX", "MSố hàng", "Số lượng", "Tiền/SP");
        for (MATHANG a : mh) {
            a.xuat();
            System.out.print("\n");
        }
    }

    public void luuFile() {
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

    public void docFile() {
        try {
            mh.clear();
            FileReader fr = new FileReader("mathang.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
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

        } catch (FileNotFoundException var5) {
            System.out.print("\nfile bị lỗi!");
            System.exit(0);
        } catch (Exception var6) {
            System.out.print("\nChưa có thông tin, vui lòng nhập trước!");
            System.exit(0);
        }
    }

    /////HERE!!!
    public void xoa1mh() {
        Scanner SC = new Scanner(System.in);
        System.out.print("\n Nhập mã mặt hàng cần xoá: ");
        boolean a = true;
        String xString = SC.nextLine();
        for (int i = 0; i < mh.size(); ++i) {
            if (mh.get(i).getMaSoHang().equals(xString)) {
                this.mh.remove(i);
                System.out.println("xoa thành công!!!");
                a = false;
            }

        }
        if (a) {
            System.out.println("Không có mặt hàng nào có mã số này " + xString);
        }
    }

    public void tableH() {
        System.out.printf("%20s%20s%15s%15d%20.0f\n", "Tên mặt hàng", "Hãng sản xuất", "Mã hàng", "Số lượng", "Giá tiền");
    }

    public void tim1mh() {
        Scanner SC = new Scanner(System.in);
        System.out.print("\n Nhập mã mặt hàng cần tìm: ");
        String xString = SC.nextLine();
        boolean s=true;
        for (int i = 0; i < mh.size(); ++i) {

            if (mh.get(i).getMaSoHang().equals(xString)) {
                tableH();
               s=false;
                this.mh.get(i).xuat();
            }
        }
        if(s)
            System.out.println("Không có mặt hàng nào có mã: "+xString);

    }
    public void hangX() {
        Scanner SC = new Scanner(System.in);
        System.out.print("\n Nhập hãng cần hiện: ");
        String xString = SC.nextLine();
        boolean s=true;
        tableH();
        for (int i = 0; i < mh.size(); ++i) {

            if (mh.get(i).getHangSX().equals(xString)) {                
               s=false;
                this.mh.get(i).xuat();
            }
        }
        if(s)
            System.out.println("Không có mặt hàng nào có mã: "+xString);

    }

    public void sapXepMatHang() {
        Collections.sort(this.mh, new Comparator<MATHANG>() {
            @Override

            public int compare(MATHANG o1, MATHANG o2) {

                return (int) (o1.getGiaTien()-o2.getGiaTien());

            }
        });
    }
    public void emtpy() {
        try {
            FileWriter fw = new FileWriter("mathang.txt");
            fw.close();
            System.out.print("\nFile đã rỗng!");
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }
    public void thayDoiTen1MatHang() {
        Scanner SC = new Scanner(System.in);
        System.out.print("\n Nhập mã mặt hàng cần thay đổi thông tin: ");
        String xString = SC.nextLine();
        for (int i = 0; i < mh.size(); ++i) {

            if (mh.get(i).getMaSoHang().equals(xString)) {
                System.out.print("\nMỜI nhập tên mặt hàng mới: ");
                String newName = SC.nextLine();
                mh.get(i).setTenMatHang(newName);
                System.out.print("\n thay đổi thành công!!!!");
            }

        }
    }
    // End!!!

}
