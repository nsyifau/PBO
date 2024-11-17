import java.util.Scanner;

// Base Class
class Transaksi {
    protected String noFaktur;
    protected String kodeBarang;
    protected String namaBarang;
    protected double hargaBarang;
    protected int jumlahBeli;

    // Constructor untuk menginisialisasi data transaksi
    public Transaksi(String noFaktur, String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        this.noFaktur = noFaktur;
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.jumlahBeli = jumlahBeli;
    }

    // Method untuk menghitung total harga
    public double hitungTotal() throws IllegalArgumentException {
        if (hargaBarang < 0 || jumlahBeli < 0) {
            // Exception handling: Jika harga atau jumlah negatif, lempar exception
            throw new IllegalArgumentException("Harga barang atau jumlah beli tidak boleh negatif!");
        }
        return hargaBarang * jumlahBeli;
    }
}

// Derived Class (Inheritance)
class TransaksiDetail extends Transaksi {
    // Constructor yang memanggil constructor dari base class
    public TransaksiDetail(String noFaktur, String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        super(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlahBeli);
    }

    // Method untuk menampilkan detail transaksi
    public void tampilkanDetail() {
        try {
            double total = hitungTotal(); // Menggunakan method dari base class
            System.out.println("\n=== Detail Transaksi ===");
            System.out.println("No Faktur     : " + noFaktur);
            System.out.println("Kode Barang   : " + kodeBarang);
            System.out.println("Nama Barang   : " + namaBarang);
            System.out.println("Harga Barang  : " + hargaBarang);
            System.out.println("Jumlah Beli   : " + jumlahBeli);
            System.out.println("Total Harga   : " + total);
        } catch (IllegalArgumentException e) {
            // Menangkap exception jika terjadi kesalahan perhitungan
            System.out.println("Error: " + e.getMessage());
        }
    }
}

public class Tugas4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("=== Program Kasir Sederhana ===");

            // Input data transaksi
            System.out.print("Masukkan No Faktur: ");
            String noFaktur = scanner.nextLine();

            System.out.print("Masukkan Kode Barang: ");
            String kodeBarang = scanner.nextLine();

            System.out.print("Masukkan Nama Barang: ");
            String namaBarang = scanner.nextLine();

            System.out.print("Masukkan Harga Barang: ");
            double hargaBarang = Double.parseDouble(scanner.nextLine()); // Exception jika bukan angka

            System.out.print("Masukkan Jumlah Beli: ");
            int jumlahBeli = Integer.parseInt(scanner.nextLine()); // Exception jika bukan angka

            // Validasi input kosong
            if (noFaktur.isEmpty() || kodeBarang.isEmpty() || namaBarang.isEmpty()) {
                throw new IllegalArgumentException("Semua data harus diisi!"); // Exception untuk input kosong
            }

            // Membuat objek TransaksiDetail (Inheritance)
            TransaksiDetail transaksi = new TransaksiDetail(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlahBeli);

            // Menampilkan detail transaksi
            transaksi.tampilkanDetail();

        } catch (NumberFormatException e) {
            // Menangkap kesalahan jika input harga atau jumlah beli bukan angka
            System.out.println("Error: Input untuk harga atau jumlah beli harus berupa angka!");
        } catch (IllegalArgumentException e) {
            // Menangkap kesalahan jika ada input kosong atau nilai negatif
            System.out.println("Input Error: " + e.getMessage());
        } catch (Exception e) {
            // Menangkap semua jenis kesalahan lain
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            // Menutup scanner
            scanner.close();
        }
    }
}
