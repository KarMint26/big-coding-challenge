import java.util.Scanner; // mengimport Scanner dari java.util untuk memproses input atau masukkan
import java.util.Arrays; // mengimport Arrays untuk tujuan menjadikan array sebagai string

public class Main // main class atau class utama berjalannya program
{
    public static Scanner userInput = new Scanner(System.in); // fungsi atau method untuk memproses input atau masukkan
    
    public static int[] timeToEat(String input) { // method atau fungsi untuk mengembalikan nilai selisih jam dan menit
        int[] ans = new int[2]; // Membuat array untuk menyimpan selisih jam dan menit

        String[] timeParts = input.split(":"); // menjadikan string sebagai array dengan method split
        int currentHour = Integer.parseInt(timeParts[0]); // mengambil index ke-0 yang merupakan keterangan jam
        int currentMinute = Integer.parseInt(timeParts[1].split(" ")[0]); // mengambil index ke-1 yang merupakan menit
        String amOrPm = timeParts[1].split(" ")[1]; // mengambil index ke-1 dan melakukan split untuk mendapatkan keterangan am atau pm
        
        int diffHour = 0; // menginisialisasi nilai selisih dari jam
        int diffMinute = 0; // menginisialisasi nlai selisih dari menit
        
        // melakukan pengkondisian dengan if, else, dan else if
        if (amOrPm.equals("a.m.")) { // jika keterangan a.m. maka dia dihitung dari jam 12 dini hari atau 00:00 sampai 11:59
            if (currentHour < 7 || (currentHour == 7 && currentMinute == 0)) {
                diffHour = 7 - currentHour;
            } else if(currentHour < 12 && currentHour > 7) {
                diffHour = 12 - currentHour;
            }
        } else if (amOrPm.equals("p.m.")) { // jika keterangan a.m. maka dia dihitung dari jam 12 dini hari atau 12:00 sampai 23:59
            if (currentHour < 7 || (currentHour == 7 && currentMinute == 0)) {
                diffHour = 7 - currentHour;
            } else if(currentHour > 7) {
                currentHour -= 7;
                diffHour = 12 - currentHour;
            }
        }
        
        diffMinute = 60 - currentMinute; // selisih menit dilakukan perhitungan 60 menit dikurangi menit sekarang
        if(currentMinute == 0){ // jika menit sekarang adalah 0 maka selisihnya juga 0
            diffMinute = 0;
        } else { // jika menit bukan 0 maka yang dilakukan adalah mengurangi selisih jam dengan 1
            diffHour -= 1;
        }
        
        ans[0] = diffHour; // Memasukkan value dari variabel diffHour kedalam index ke 0 dari array int[] ans
        ans[1] = diffMinute; // Memasukkan value dari variabel diffMinute kedalam index ke 1 dari array int[] ans
        
        return ans; // Mengembalikan nilai dari array ans yang berisi jawaban berapa jam dan menitnya
    }
	public static void main(String[] args) { // main method untuk menampilkannya di console
        // Breakfast at 7:00 a.m. (makan pagi pada jam 07:00)
        // lunch at 12:00 p.m. (makan siang pada jam 12:00)
        // dinner at 7:00 p.m. (makan malam pada jam 19:00)
        // Tugasnya adalah mencari selisih berapa jam dan menit sampai pada makan selanjutnya sesuai rules
        
        // Memasukkan waktu saat ini dari pengguna
        System.out.print("Masukkan waktu saat ini (format: HH:mm a.m./p.m.): ");
        String currentTime = userInput.nextLine();

        // Memanggil fungsi timeToEat dan mencetak hasilnya
        int[] timeUntilNextMeal = timeToEat(currentTime);
        System.out.println(Arrays.toString(timeUntilNextMeal) + ", Waktu hingga makan berikutnya: " + timeUntilNextMeal[0] + " jam " + timeUntilNextMeal[1] + " menit");
	}
}
