
package btl.nhom39;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class BTLNHOM39 {
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        DSKHACHHANG kh = new DSKHACHHANG();
        DSNHANVIEN nv = new DSNHANVIEN();
        DSMATHANG mh = new DSMATHANG();
        DSHOADON hd = new DSHOADON();
       
        while(true) {
            label73:
            while(true) {
                System.out.print("\n=======================================================\n");
                System.out.print("==== CHƯƠNG TRÌNH QUẢN LÝ KINH DOANH MÁY TÍNH =======\n");
                System.out.print("1. Quản lý nhân viên                                 ||\n");
                System.out.print("2. Quản lý khách hàng                                ||\n");
                System.out.print("3. Quản lý mặt hàng                                  ||\n");
                System.out.print("4. Quản lý hoá đơn                                   ||\n");
                System.out.print("0. Thoát khỏi chương trình                           ||\n");
                System.out.print("=======================================================\n");
                System.out.print("Nhập lựa chọn của bạn: ");
                Scanner sc = new Scanner(System.in);
                int chon = sc.nextInt();
                int k;
                switch(chon) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    while(true) {
                        if (chon == -99) {
                            continue label73;
                        }

                        System.out.print("\n=============================\n");
                        System.out.print("QUẢN LÝ NHÂN VIÊN\n");
                        System.out.print("1. Thêm một nhân viên mới\n");
                        System.out.print("2. Thêm danh sách nhiều nhân viên\n");
                        System.out.print("3. In Danh sách nhân viên\n");
                        System.out.print("4. Xoá một nhân viên khỏi danh sách\n");
                        System.out.print("5. Tìm một nhân viên trong danh sách\n");
                        System.out.print("6. sắp xếp nhân viên theo mã nhân viên\n");
                        System.out.print("7. thay đổi tên nhân viên theo mã nhân viên\n");
                        System.out.print("8. Trở về Menu Chính\n");
                        System.out.print("0. Thoát khỏi chương trình\n");
                        System.out.print("Nhập lựa chọn của bạn: ");
                        k = sc.nextInt();
                        switch(k) {
                        case 0:
                            System.exit(0);
                            break;
                        case 1:
                        System.out.print("\nBạn chọn nhập một nhân viên mới:");
                            nv.nhap();
                            nv.luuFile();
                            break;
                        case 2:
                            System.out.print("\nBạn chọn nhập danh sách nhân viên:");
                            nv.nhapDS();
                            nv.luuFile();
                            break;
                        case 3:
                            System.out.print("\nDANH SÁCH NHÂN VIÊN: \n");
                            nv.docFile();
                            nv.xuatDS();
                            break;
                        case 4:
                            System.out.print("\nBạn chọn xoá một nhân viên:");
                            nv.xoa1nv();
                            nv.luuFile();
                            break;
                        case 5:
                            System.out.print("\nBạn chọn tìm nhân viên từ danh sách:");
                            nv.docFile();
                            nv.tim1nv();
                            break;
                        case 6:
                            System.out.print("\nBạn chọn sắp xếp nhân viên:");
                            nv.docFile();
                            nv.sapXepMaNV();
                            nv.luuFile();
                            break;
                        case 7:
                            System.out.print("\nBạn chọn thay đổi tên nhân viên:");
                            nv.docFile();
                            nv.thayDoiTenNV();
                            nv.luuFile();
                            break;
                            
                        case 8:
                            chon = -99;
                        }
                    }
                case 2:
                    while(true) {
                        if (chon == -99) {
                            continue label73;
                        }

                        System.out.print("\n=============================\n");
                        System.out.print("QUẢN LÝ KHÁCH HÀNG\n");
                        System.out.print("1. Thêm một khách hàng\n");
                        System.out.print("2. Thêm danh sách nhiều khách hàng\n");
                        System.out.print("3. In Danh sách khách hàng\n");
                        System.out.print("4. Xoá một khách hàng khỏi danh sách\n");
                        System.out.print("5. Tìm một khách hàng trong danh sách\n");
                        System.out.print("6. Sắp xếp khách hàng theo mã khách hàng\n");
                        System.out.print("7. Thay đổi tên khách hàng theo mã khách hàng\n");
                        System.out.print("8. Xoá tất cả thông tin khách hàng từ file\n");
                        System.out.print("9. Trở về Menu Chính\n");
                        System.out.print("0. Thoát khỏi chương trình\n");
                        System.out.print("Nhập lựa chọn của bạn: ");
                        k = sc.nextInt();
                        switch(k) {
                        case 0:
                            System.exit(0);
                            break;
                        case 1:
                            System.out.print("\nBạn chọn nhập một khách hàng mới:");
                            kh.nhap();
                            kh.luuFile();
                            break;
                        case 2:
                            System.out.print("\nBạn chọn nhập danh sách khách hàng:");
                            kh.docFile();
                            kh.nhapDS();
                            kh.luuFile();
                            break;
                        case 3:
                            System.out.print("\nDANH SÁCH KHÁCH HÀNG: \n");
                            kh.docFile();
                            kh.xuatKH();
                            break;
                        case 4:
                            System.out.print("\nBạn chọn xoá một khách hàng:");
                            kh.docFile();
                            kh.xoa1KH();
                            
                            kh.luuFile();
                            break;
                        case 5:
                            System.out.print("\nBạn chọn tìm một khách hàng:");
                            kh.docFile();
                            kh.tim1KH();
                         
                            kh.luuFile();
                            break;
                        case 6:
                            System.out.print("\nBạn chọn sắp xếp khách hàng theo mã số thuế:");
                            kh.docFile();
                            kh.sapXepMaSTKH();
                            System.out.print("\n Đã SX thành công!!!");
                            kh.luuFile();
                            break;
                        case 7:
                            System.out.print("\nBạn chọn thay đổi thông tin khách hàng theo mã số thuế:");
                            kh.docFile();
                            kh.thayDoiTenKhachHang();
                            System.out.print("\n Đã đổi thành công!!!");
                            kh.luuFile();
                            break;
                        case 8:
                            System.out.print("\nBạn đã chọn xoá tất cả thông tin khách hàng:");
                            kh.emtpy();
                            
                            break;

                        case 9:
                            chon = -99;
                        }
                    }
                case 3:
                    while(true) {
                        if (chon == -99) {
                            continue label73;
                        }

                        System.out.print("\n=============================\n");
                        System.out.print("QUẢN LÝ MẶT HÀNG\n");
                        System.out.print("1. Thêm danh sách nhiều mặt hàng\n");
                        System.out.print("2. Sắp xếp danh sách mặt hàng theo tiền\n");
                        System.out.print("3. In ra danh sách mặt hàng từ hãng X\n");
                        System.out.print("4. In ra danh sách mặt hàng từ file\n");
                        System.out.print("5. Xoá tất cả thông tin mặt hàng từ file\n");
                        System.out.print("6. Xoá thông tin 1 mặt hàng từ file\n");
                        System.out.print("7. Tìm thông tin 1 mặt hàng từ file\n");
                        System.out.print("8. Sắp xếp thông tin mặt hàng từ file\n");
                        System.out.print("9. Thay đổi thông tin 1 mặt hàng theo mã mặt hàng từ file\n");
                        System.out.print("10. Trở về Menu Chính\n");
                        System.out.print("0. Thoát khỏi chương trình\n");
                        System.out.print("Nhập lựa chọn của bạn: ");
                        k = sc.nextInt();
                        switch(k) {
                        case 0:
                            System.exit(0);
                            break;
                        case 1:
                            System.out.print("\nBạn chọn nhập mặt hàng mới:");
                            mh.nhapDS();
                            mh.luuFile();
                            break;
                        case 2:
                            System.out.print("\nBạn chọn sắp xếp danh sách mặt hàng:");
                            System.out.print("\nDANH SÁCH MẶT HÀNG SẮP XẾP THEO TIỀN: \n");
                           mh.sapXepMatHang();
                           mh.luuFile();
                           mh.docFile();
                           mh.xuatDS();
                           
                            break;
                        case 3:
                            System.out.print("\nBạn chọn hiện mặt hàng của hãng X:");
                            mh.docFile();
                            mh.hangX();
                            break;
                        case 4:
                            System.out.print("\nDANH SÁCH MẶT HÀNG TỪ FILE: \n");
                            mh.docFile();
                            mh.xuatDS();
                            break;
                        case 5:
                            System.out.print("\nBạn đã chọn xoá thông tin từ file mặt hàng \n");
                            mh.emtpy();
                            break;
                            
               
                        case 6:
                            System.out.print("\nBạn đã chọn xoá thông tin 1 mặt hàng \n");
                            mh.docFile();
                            mh.xoa1mh();
                            System.out.print("\n Đã xóa thành công!!!");
                            mh.luuFile();
                            break;
                        case 7:
                            System.out.print("\nBạn đã chọn tìm thông tin 1 mặt hàng \n");
                            mh.docFile();
                            mh.tim1mh();
                            System.out.print("\n Đã tìm thành công!!!");
                            mh.luuFile();
                            break;
                        case 8:
                            System.out.print("\nSắp xếp thông tin mặt hàng \n");
                            mh.docFile();
                            mh.sapXepMatHang();
                            System.out.print("\n Đã SX thành công!!!");
                            mh.luuFile();
                            break;
                        case 9:
                            System.out.print("\nBạn đã chọn thay đổi thông tin tên 1 mặt hàng theo mã mặt hàng \n");
                            mh.docFile();
                            mh.thayDoiTen1MatHang();
                            System.out.print("\n Đã thay đổi thành công!!!");
                            mh.luuFile();
                            break;
                  
                            
                        case 10:
                            chon = -99;
                        }
                    }
                case 4:
                    while(chon != -99) {
                        System.out.print("\n=============================\n");
                        System.out.print("QUẢN LÝ HOÁ ĐƠN\n");
                        System.out.print("1. Thêm danh sách nhiều hoá đơn\n");
                        System.out.print("2. Xoá một hoá đơn khỏi danh sách\n");
                        System.out.print("3. Tìm một hoá đơn trong danh sách\n");
                        System.out.print("4. Sắp xếp hoá đơn trong danh sách\n");
                        System.out.print("5. Thay đổi mã NV bán trong hóa đơn\n");
                        System.out.print("6. In danh sách hoá đơn từ file\n");
                        System.out.print("7. Xoá tất cả thông tin file hoá đơn\n");
                        System.out.print("8. Trở về Menu Chính\n");
                        System.out.print("0. Thoát khỏi chương trình\n");
                        System.out.print("Nhập lựa chọn của bạn: ");
                        k = sc.nextInt();
                        switch(k) {
                        case 0:
                            System.exit(0);
                            break;
                        case 1:
                            System.out.print("\nBạn chọn nhập danh sách hoá đơn:");
                               hd.nhapDS();
                               hd.luuFile();
                            break;
               
                        case 2:
                            System.out.print("\nBạn chọn xoá một hoá đơn:");
                            hd.docFile();
                            hd.xoa1hd();
                         
                            hd.luuFile();
                            break;
                        case 3:
                            System.out.print("\nBạn chọn tìm một hoá đơn từ danh sách:");
                            hd.tim1hd();
                            break;
                        case 4:
                            System.out.print("\nBạn chọn sắp xếp hoá đơn trong danh sách:");
                            hd.docFile();

                            hd.sapXepHoaDon();
                            System.out.print("\n Đã SX thành công!!!");
                            hd.luuFile();
                            break;
                        case 5:
                            System.out.print("\nThay đổi mã NV bán trong hóa đơn:");
                            hd.docFile();
                            hd.thayDoiMaNVBanTrongHoaDon();
                            System.out.print("\n Đã thay đổi thành công!!!");
                            hd.luuFile();
                            break; 
                        case 6:
                            System.out.print("\nDANH SÁCH HOÁ ĐƠN TỪ FILE:\n");
                           hd.docFile();
                            hd.xuatDS();
                            break;
                        case 7:
                            System.out.print("\nBạn đã chon làm sạch file\n");
                            hd.emtpy();
                            break;
                        case 8:
                            chon = -99;
                        }
                    }
                }
            }
        }
    }
}



