// Import kelas Scanner dari package java.util untuk memproses input atau masukkan
import java.util.Scanner;

// Import kelas Arrays dari package java.util untuk konversi array menjadi string
import java.util.Arrays;

// Deklarasi class utama yang akan berisi metode utama (main)
public class Main {

    // Deklarasi objek Scanner yang akan digunakan untuk input
    public static Scanner userInput = new Scanner(System.in);

    // Metode timeToEat untuk menghitung selisih waktu hingga makan selanjutnya
    public static int[] timeToEat(String input) {
        // Membuat array ans untuk menyimpan selisih jam dan menit
        int[] ans = new int[2];

        // Memisahkan waktu menjadi bagian jam dan menit dengan delimiter ":"
        String[] timeParts = input.split(":");

        // Mengambil jam dari bagian pertama array hasil split
        int currentHour = Integer.parseInt(timeParts[0]);

        // Mengambil menit dari bagian kedua array hasil split, dan menghapus "a.m." atau "p.m." dengan split lagi
        int currentMinute = Integer.parseInt(timeParts[1].split(" ")[0]);

        // Mengambil "a.m." atau "p.m." dari bagian kedua array hasil split
        String amOrPm = timeParts[1].split(" ")[1];

        // Menginisialisasi variabel selisih jam dan menit
        int diffHour = 0;
        int diffMinute = 0;

        // Melakukan pengkondisian berdasarkan waktu "a.m." atau "p.m."
        if (amOrPm.equals("a.m.")) {
            // Jika "a.m.", maka perhitungan dimulai dari jam 00:00
            if (currentHour < 7 || (currentHour == 7 && currentMinute == 0)) {
                diffHour = 7 - currentHour;
            } else if (currentHour < 12 && currentHour > 7) {
                diffHour = 12 - currentHour;
            }
        } else if (amOrPm.equals("p.m.")) {
            // Jika "p.m.", maka perhitungan dimulai dari jam 12:00
            if (currentHour < 7 || (currentHour == 7 && currentMinute == 0)) {
                diffHour = 7 - currentHour;
            } else if (currentHour > 7) {
                currentHour -= 7;
                diffHour = 12 - currentHour;
            }
        }

        // Menghitung selisih menit, jika menit bukan 0, maka mengurangkan selisih jam dengan 1
        diffMinute = 60 - currentMinute;
        if (currentMinute == 0) {
            diffMinute = 0;
        } else {
            diffHour -= 1;
        }

        // Memasukkan nilai selisih jam dan menit ke dalam array ans
        ans[0] = diffHour;
        ans[1] = diffMinute;

        // Mengembalikan array ans yang berisi selisih jam dan menit
        return ans;
    }

    // Metode utama (main) yang akan dijalankan saat program dijalankan
    public static void main(String[] args) {
        // Menampilkan informasi tugas kepada pengguna
        System.out.print("Masukkan waktu saat ini (format: HH:mm a.m./p.m.): ");
        
        // Membaca input waktu saat ini dari pengguna
        String currentTime = userInput.nextLine();

        // Memanggil metode timeToEat untuk menghitung selisih waktu hingga makan selanjutnya
        int[] timeUntilNextMeal = timeToEat(currentTime);

        // Menampilkan hasil perhitungan selisih waktu dalam bentuk array dan teks informatif
        System.out.println(Arrays.toString(timeUntilNextMeal) + ", Waktu hingga makan berikutnya: " + timeUntilNextMeal[0] + " jam " + timeUntilNextMeal[1] + " menit");
    }
}
