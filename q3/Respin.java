import java.util.*;

public class Respin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int jumlahMahasiswa = sc.nextInt();
        sc.nextLine(); 

        String[] daftarNama = sc.nextLine().split(" ");
        Queue<String> antreanNama = new LinkedList<>(Arrays.asList(daftarNama));
        Queue<Integer> kesempatan = new LinkedList<>();
        for (int i = 0; i < jumlahMahasiswa; i++) {
            kesempatan.add(sc.nextInt());
        }

        while (!antreanNama.isEmpty()) {
            String namaSekarang = antreanNama.poll();
            int sisaKesempatan = kesempatan.poll();

            //Kurang 1 kesempatan tiap kli maju
            sisaKesempatan = sisaKesempatan - 1;

            if (sisaKesempatan > 0) {
                System.out.println(namaSekarang + "|Try Again|" + sisaKesempatan);
                antreanNama.add(namaSekarang);
                kesempatan.add(sisaKesempatan);
            } else {
                System.out.println(namaSekarang + "|Get Out|" + sisaKesempatan);
            }
        }
        sc.close();
    }
}


//dipandu oleh gemini
