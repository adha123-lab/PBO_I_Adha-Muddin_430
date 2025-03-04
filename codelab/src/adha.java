import java.time.LocalDate;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Nama;


        Scanner objInput = new Scanner(System.in);

        System.out.print("Masukkan nama: ");
        Nama =objInput.nextLine();

        System.out.print("Masukkan jenis kelamin (P/L): ");
        String jenisKelaminInput = scanner.next().charAt(0);
        String jenisKelamin = (jenisKelaminInput == 'L' || jenisKelaminInput == 'l') ? "Laki-laki" : "Perempuan";

        System.out.print("Masukkan tahun lahir: ");
        int tahunLahir = scanner.nextInt();

        int tahunSekarang = LocalDate.now().getYear();
        int umur = tahunSekarang - tahunLahir;

        scanner.close();

        System.out.println("Data Diri:");
        System.out.println("Nama         : " + nama);
        System.out.println("Jenis Kelamin: " + jenisKelamin);
        System.out.println("Umur         : " + umur + " tahun");
    }
}