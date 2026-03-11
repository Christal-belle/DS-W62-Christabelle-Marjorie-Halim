import java.util.*;

public class Identifying {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        while (inputScanner.hasNextInt()) {
            int totalOperations = inputScanner.nextInt();
            
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            boolean isStack = true;
            boolean isQueue = true;
            boolean isPQ = true;

            for (int i = 0; i < totalOperations; i++) {
                if (!inputScanner.hasNextInt()) break;
                int operationType = inputScanner.nextInt();

                if(!inputScanner.hasNextInt()) break;
                int dataValue = inputScanner.nextInt();

                if (operationType == 1) {
                    //Operasi Push
                    if (isStack) stack.push(dataValue);
                    if (isQueue) queue.add(dataValue);
                    if (isPQ) pq.add(dataValue);
                } else {
                    // Operasi Take out (Cek kecocokan)
                    if (isStack) {
                        if (stack.isEmpty() || stack.pop() != dataValue) isStack = false;
                    }
                    if (isQueue) {
                        if (queue.isEmpty() || queue.poll() != dataValue) isQueue = false;
                    }
                    if (isPQ) {
                        if (pq.isEmpty() || pq.poll() != dataValue) isPQ = false;
                    }
                }
            }

            // Menentukan Output berdasarkan sisa Flag yang true
            int kemungkinan = 0;
            if (isStack) kemungkinan = kemungkinan + 1;
            if (isQueue) kemungkinan = kemungkinan + 1;
            if (isPQ) kemungkinan = kemungkinan + 1;

            if (kemungkinan == 0) {
                System.out.println("tidak ada");
            } else if (kemungkinan > 1) {
                System.out.println("tidak yakin");
            } else {
                if (isStack) {
                    System.out.println("stack");
                } else if (isQueue) {
                    System.out.println("queue");
                } else {
                    System.out.println("priority queue");
                }
            }
        }
        inputScanner.close();
    }
}

 //dipandu oleh gemini