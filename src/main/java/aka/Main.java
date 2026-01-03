package aka;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer> transaksiList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    
    static void tambahTransaksi() {
        System.out.print("Masukkan total transaksi (Rp): ");
        int total = sc.nextInt();
        transaksiList.add(total);
        System.out.println("Transaksi berhasil ditambahkan!");
    }

    static void tampilkanTransaksi() {
        if (transaksiList.isEmpty()) {
            System.out.println("Belum ada transaksi.");
            return;
        }

        System.out.println("\nDaftar Transaksi:");
        for (int i = 0; i < transaksiList.size(); i++) {
            System.out.println("Transaksi ke-" + (i + 1) + ": Rp " + transaksiList.get(i));
        }
    }


    static int cariMaksimum() {
        int max = transaksiList.get(0);

        for (int i = 1; i < transaksiList.size(); i++) {
            if (transaksiList.get(i) > max) {
                max = transaksiList.get(i);
            }
        }
        
        return max;
    }


    static int hitungTotal(int index) {
        if (index == transaksiList.size()) {
            return 0;
        }
        
        return transaksiList.get(index) + hitungTotal(index + 1);
    }
	    
	    public static void main(String[] args) {
	    	int pilih;

	        do {
	            System.out.println("\n=== APLIKASI KASIR ===");
	            System.out.println("1. Tambah Transaksi");
	            System.out.println("2. Tampilkan Semua Transaksi");
	            System.out.println("3. Cari Transaksi Terbesar");
	            System.out.println("4. Hitung Total Omzet");
	            System.out.println("0. Keluar");
	            System.out.print("Pilih menu: ");
	            pilih = sc.nextInt();

	            switch (pilih) {
	                case 1:
	                    tambahTransaksi();
	                    break;
	                case 2:
	                    tampilkanTransaksi();
	                    break;
	                case 3:
	                    if (transaksiList.isEmpty()) {
	                        System.out.println("Belum ada transaksi.");
	                    } else {
	                        int max = cariMaksimum();
	                        System.out.println("Transaksi terbesar: Rp " + max);
	                    }
	                    break;
	                case 4:
	                    if (transaksiList.isEmpty()) {
	                        System.out.println("Belum ada transaksi.");
	                    } else {
	                        int total = hitungTotal(0);
	                        System.out.println("Total omzet: Rp " + total);
	                    }
	                    break;
	                case 0:
	                    System.out.println("Terima kasih telah menggunakan aplikasi kasir.");
	                    break;
	                default:
	                    System.out.println("Menu tidak valid.");
	            }
	        } while (pilih != 0);
	    }
}
