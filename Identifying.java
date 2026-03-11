import java.util.*;

public class Identifying {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Membaca selama masih ada input (jumlah operasi dalam satu grup)
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            // Menggunakan reverseOrder karena contoh menunjukkan pengambilan nilai terbesar (Max-Priority)
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            boolean isStack = true;
            boolean isQueue = true;
            boolean isPQ = true;

            for (int i = 0; i < n; i++) {
                int type = sc.nextInt();
                int val = sc.nextInt();

                if (type == 1) {
                    // Operasi ADD: Masukkan ke semua struktur
                    if (isStack) stack.push(val);
                    if (isQueue) queue.add(val);
                    if (isPQ) pq.add(val);
                } else {
                    // Operasi TAKE OUT: Cek kecocokan
                    if (isStack) {
                        if (stack.isEmpty() || stack.pop() != val) isStack = false;
                    }
                    if (isQueue) {
                        if (queue.isEmpty() || queue.poll() != val) isQueue = false;
                    }
                    if (isPQ) {
                        if (pq.isEmpty() || pq.poll() != val) isPQ = false;
                    }
                }
            }

            // Menentukan Output berdasarkan sisa Flag yang true
            int count = 0;
            if (isStack) count++;
            if (isQueue) count++;
            if (isPQ) count++;

            if (count == 0) {
                System.out.println("tidak ada");
            } else if (count > 1) {
                System.out.println("tidak yakin");
            } else {
                if (isStack) System.out.println("stack");
                else if (isQueue) System.out.println("queue");
                else System.out.println("priority queue");
            }
        }
        sc.close();
    }
}
