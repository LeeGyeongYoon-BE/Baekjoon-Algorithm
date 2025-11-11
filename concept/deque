// 양쪽 끝에서 삽입 / 삭제 가능한 큐
// 스택과 큐의 기능을 모두 가짐

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        // 요소 추가
        deque.addFirst(10); // 앞
        deque.addLast(20);  // 뒤
        deque.addLast(30);

        // 앞/뒤 확인
        System.out.println("Front: " + deque.peekFirst()); // 10
        System.out.println("Back: " + deque.peekLast());   // 30

        // 제거
        System.out.println("Removed front: " + deque.pollFirst()); // 10
        System.out.println("Removed back: " + deque.pollLast());   // 30
    } // main
} // class
