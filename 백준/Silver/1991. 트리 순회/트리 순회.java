import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        char data;
        Node left, right;
        public Node( char data ) { this.data = data; }
        public String toString() { return this.data + ""; }
    } // Node

    private static void preOrder(Node node) {
        System.out.print( node.data );
        if(node.left != null) preOrder(node.left);
        if(node.right != null) preOrder(node.right);
    } // preorder

    private static void inOrder(Node node) {
        if(node.left != null) inOrder(node.left);
        System.out.print( node.data );
        if(node.right != null) inOrder(node.right);
    } // inorder

    private static void postOrder(Node node) {
        if(node.left != null) postOrder(node.left);
        if(node.right != null) postOrder(node.right);
        System.out.print( node.data );
    } // postorder

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node [] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node( (char)('A' + i) ); // 아스키 코드를 이용해서 알파벳 순으로 노드를 먼저 생성
        } // for

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char data = st.nextToken().charAt(0);
            char leftChar = st.nextToken().charAt(0);
            char rightChar = st.nextToken().charAt(0);

            Node cur = nodes[data - 'A']; // 아스키 코드를 이용해서 알파벳 순으로 노드를 저장
            // 'C' - 'A' == 67 - 65 == 2
            cur.left = (leftChar != '.')? nodes[leftChar - 'A'] : null; // 노드 연결
            cur.right = (rightChar != '.')? nodes[rightChar - 'A'] : null; // 노드 연결
        } // for - i

        preOrder( nodes[0] );// 전위 : 부모 -> 왼 -> 오른
        System.out.println();
        inOrder( nodes[0] );// 중위 : 왼 -> 부모 -> 오른
        System.out.println();
        postOrder( nodes[0] );// 후위 : 왼 -> 오른 -> 부모

        br.close();
    } // main
} // class
