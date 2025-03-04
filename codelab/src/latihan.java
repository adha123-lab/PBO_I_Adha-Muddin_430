import java.time.LocalDate;
import java.util.Scanner;

public class latihan {
}

public class  latihan {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        System.out.print("Masukkan nama: ");
        String nama = Scanner.nextLine();

        System.out.print("Masukkan jenis kelamin (P/L): ");
        char jenisKelaminInput = Scanner.next().charAt(0);
        String jenisKelamin = (jenisKelaminInput == 'L' || jenisKelaminInput == 'l') ? "Laki-laki" : "Perempuan";

        System.out.print("Masukkan tahun lahir: ");
        int tahunLahir = Scanner.nextInt();

        int tahunSekarang = LocalDate .now().getYear();
        int umur = tahunSekarang - tahunLahir;

        scanner.close();

        System.out.println("\nData Diri:");
        System.out.println("Nama         : " + nama);
        System.out.println("Jenis Kelamin: " + jenisKelamin);
        System.out.println("Umur         : " + umur + " tahun");
    }
}