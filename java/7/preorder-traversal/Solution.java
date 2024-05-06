import java.io.*;
import java.util.*;

public class Solution {
    static class Node {
        int data;
        Node left, right;
        
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public static void addChild(Node child, Node root) {
        if (child.data < root.data) {
            if (root.left == null) {
                root.left = child;
            } else {
                addChild(child, root.left);
            }
        } else {
            if (root.right == null) {
                root.right = child;
            } else {
                addChild(child, root.right);
            }
        }
    }
    
    public static void traverse(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        traverse(root.left);
        traverse(root.right);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numNodes = scanner.nextInt();
        
        Node root = new Node(scanner.nextInt());
        for (int i = 0; i < numNodes - 1; i++) {
            Node n = new Node(scanner.nextInt());
            addChild(n, root);
        }
        
        traverse(root);
    }
}