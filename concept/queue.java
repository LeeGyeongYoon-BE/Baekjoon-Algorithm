// 선입선출(FIFO, First In First Out) 구조
// 먼저 들어온 데이터가 먼저 나옴

// enqueue(x) : 큐에 요소 x 추가
// dequeue() : 큐에서 가장 앞 요소 제거 및 반환
// peek() / front() : 큐의 가장 앞 요소 확인
// isEmpty() : 큐가 비어있는지 확인

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // 요소 추가
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        // 큐의 가장 앞 확인
        System.out.println("Front element: " + queue.peek()); // 10

        // 요소 제거
        System.out.println("Dequeued element: " + queue.poll()); // 10
        System.out.println("Dequeued element: " + queue.poll()); // 20

        // 큐가 비어있는지 확인
        System.out.println("Is queue empty? " + queue.isEmpty()); // false
    } // main
} // class
