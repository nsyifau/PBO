import java.text.SimpleDateFormat;
import java.util.Date;

// Derived Class
public class TransaksiDetail extends Transaksi {
    public TransaksiDetail(String noFaktur, String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        super(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlahBeli);
    }

    public void tampilkanDetail(String kasir) {
        try {
            double total = hitungTotal();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String tanggalWaktu = sdf.format(new Date()); // Format tanggal dan waktu
            System.out.println("\n+----------------------------------------------------+");
            System.out.println("Selamat Datang di Supermarket FafauMart");
            System.out.println("Tanggal dan Waktu : " + tanggalWaktu);
            System.out.println("+----------------------------------------------------+");
            System.out.println("No. Faktur      : " + noFaktur);
            System.out.println("Kode Barang     : " + kodeBarang.toUpperCase());
            System.out.println("Nama Barang     : " + namaBarang.trim());
            System.out.printf("Harga Barang    : %.2f\n", hargaBarang);
            System.out.println("Jumlah Beli     : " + jumlahBeli);
            System.out.printf("TOTAL           : %.2f\n", total);
            System.out.println("+----------------------------------------------------+");
            System.out.println("Kasir           : " + kasir);
            System.out.println("+----------------------------------------------------+");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
