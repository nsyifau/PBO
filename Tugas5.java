import java.util.Scanner;

public class Tugas5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("=== Login ===");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            String captcha = "1234"; // Contoh captcha sederhana
            System.out.print("Captcha [" + captcha + "]: ");
            String inputCaptcha = scanner.nextLine();

            if (username.isEmpty() || password.isEmpty() || !inputCaptcha.equals(captcha)) {
                throw new IllegalArgumentException("Login gagal! Username, password, atau captcha salah.");
            }
            System.out.println("Login berhasil! Selamat datang, " + username.toUpperCase() + "!\n");

            System.out.print("Masukkan No Faktur: ");
            String noFaktur = scanner.nextLine();

            System.out.print("Masukkan Kode Barang: ");
            String kodeBarang = scanner.nextLine();

            System.out.print("Masukkan Nama Barang: ");
            String namaBarang = scanner.nextLine();

            System.out.print("Masukkan Harga Barang: ");
            double hargaBarang = Double.parseDouble(scanner.nextLine());

            System.out.print("Masukkan Jumlah Beli: ");
            int jumlahBeli = Integer.parseInt(scanner.nextLine());

            if (noFaktur.isEmpty() || kodeBarang.isEmpty() || namaBarang.isEmpty()) {
                throw new IllegalArgumentException("Semua data harus diisi!");
            }

            System.out.print("Masukkan Nama Kasir: ");
            String kasir = scanner.nextLine();

            TransaksiDetail transaksi = new TransaksiDetail(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlahBeli);
            transaksi.tampilkanDetail(kasir.trim());

        } catch (NumberFormatException e) {
            System.out.println("Error: Input untuk harga atau jumlah beli harus berupa angka!");
        } catch (IllegalArgumentException e) {
            System.out.println("Input Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
