import java.util.*;

public class SuratCinta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        if (!sc.hasNextInt()) return;
        int jumlahSurat = sc.nextInt();

        List<Surat> pending = new ArrayList<>();
        List<Surat> sent = new ArrayList<>();
        
        // Priority Queue: Otomatis mengurutkan dari prioritas terkecil (0 paling utama)
        PriorityQueue<Surat> queued = new PriorityQueue<>(Comparator.comparingInt(s -> s.priority));

        for (int i = 0; i < jumlahSurat; i++) {
            pending.add(new Surat(sc.next(), sc.nextInt(), sc.nextInt()));
        }
        queued.addAll(pending);
        pending.clear();

        int waktuSekarang = 0;
        while (!queued.isEmpty()) {
            // Intip surat yang punya prioritas tertinggi saat ini
            Surat suratProses = queued.peek();

            cetakStatus(waktuSekarang, pending, queued, sent);

            suratProses.durasiSisa--;
            waktuSekarang++;

            if (suratProses.durasiSisa == 0) {
                sent.add(queued.poll());
            }
        }

        cetakStatus(waktuSekarang, pending, queued, sent);
        sc.close();
    }

    private static void cetakStatus(int waktu, List<Surat> p, PriorityQueue<Surat> q, List<Surat> s) {
        System.out.print(waktu + " ");
        
        System.out.print(formatNama(p) + " | "); // Kolom Pending
        System.out.print(formatNama(new ArrayList<>(q)) + " | "); // Kolom Queued
        System.out.print(formatNama(s)); // Kolom Sent
        
        System.out.println();
    }

    private static String formatNama(Collection<Surat> daftar) {
        if (daftar.isEmpty()) return "";
        StringJoiner sj = new StringJoiner(",");
        for (Surat s : daftar) {
            sj.add(s.nama);
        }
        return sj.toString();
    }
}

class Surat {
    String nama;
    int durasiSisa;
    int priority;

    Surat(String nama, int durasi, int priority) {
        this.nama = nama;
        this.durasiSisa = durasi;
        this.priority = priority;
    }
}

//credit: gemini