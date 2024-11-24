// Base Class
public class Transaksi {
    protected String noFaktur;
    protected String kodeBarang;
    protected String namaBarang;
    protected double hargaBarang;
    protected int jumlahBeli;

    public Transaksi(String noFaktur, String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        this.noFaktur = noFaktur;
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.jumlahBeli = jumlahBeli;
    }

    public double hitungTotal() throws IllegalArgumentException {
        if (hargaBarang < 0 || jumlahBeli < 0) {
            throw new IllegalArgumentException("Harga barang atau jumlah beli tidak boleh negatif!");
        }
        return hargaBarang * jumlahBeli;
    }
}
