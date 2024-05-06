import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    static class Node implements Comparable<Node> {
        final int frequency;
        Character data;
        Node left, right;

        Node(int freq, Character data, Node left, Node right) {
            this.frequency = freq;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.frequency, other.frequency);
        }
    }

    /**
     * Create a Huffman tree from a priority queue of nodes. 
     *
     * @param nodes The priority queue of nodes, where each node represents 
     *              a character and its frequency in the input string.
     * @return The root of the Huffman tree.
     */
    public static Node createTree(PriorityQueue<Node> nodes) {
        while (nodes.size() > 1) {
            Node left = nodes.poll();
            Node right = nodes.poll();
            Node parent = new Node(left.frequency + right.frequency, null, left, right);
            nodes.add(parent);
        }
        return nodes.poll();
    }

    /** 
     * Performs a DFS on the Huffman tree to build an encoding map at the leaf nodes.
     * 
     * @param node The current node in the DFS.
     * @param code A binary string representing the path from the root to the current node, 
     *             where '0' indicates a left child and '1' indicates a right child.
     * @param encodingMap The map being built by the function, which will map each character 
     *                    in the input string to its Huffman code.
     */
    public static void buildEncodingMap(Node node, String code, Map<Character, String> encodingMap) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            encodingMap.put(node.data, code);
            return;
        }
        buildEncodingMap(node.left, code + '0', encodingMap);
        buildEncodingMap(node.right, code + '1', encodingMap);
    }

    public static String encode(String s, Map<Character, String> encodingMap) {
        StringBuilder out = new StringBuilder();
        for (char c : s.toCharArray()) {
            out.append(encodingMap.get(c));
        }
        return out.toString();
    }

    public static String decode(String s, Node root) {
        StringBuilder out = new StringBuilder();
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            curr = s.charAt(i) == '0' ? curr.left : curr.right;
            if (curr.left == null && curr.right == null) {
                out.append(curr.data);
                curr = root;
            }
        }
        return out.toString();
    }


    public static void main(String[] args) {
        String s = "Quoting Snoop Dogg's famous speech... I want to thank me for believing in me, I want to thank me for doing all this hard work. I wanna thank me for...";
        Map<Character, Integer> frequencyTable = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyTable.put(c, frequencyTable.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyTable.entrySet()) {
            nodes.add(new Node(entry.getValue(), entry.getKey(), null, null));
        }
        Node root = createTree(nodes);
        String encoded = "1010101010";
        String decoded = decode(encoded, root);
        System.out.println(decoded);

        HashMap<Character, String> encodingMap = new HashMap<>();
        buildEncodingMap(root, "", encodingMap);
        String encoding = encode(s, encodingMap);

        System.out.println("Encoding of is " + encoding);
        System.out.println("Here is it decoded " + decode(encoding, root));

        // Theoretical lower bound
        double shannonEntropy = 0.0;
        for (Integer frequency : frequencyTable.values()) {
            double probability = (double) frequency / s.length();
            shannonEntropy += probability * (Math.log(probability) / Math.log(2));
        }
        shannonEntropy = -shannonEntropy;

        // Obversed value
        double huffmanAvgLength = 0.0;
        for (Map.Entry<Character, String> entry : encodingMap.entrySet()) {
            double probability = (double) frequencyTable.get(entry.getKey()) / s.length();
            huffmanAvgLength += probability * entry.getValue().length();
        }

        System.out.println("Shannon Entropy (theoretical lower bound): " + shannonEntropy);
        System.out.println("Average Huffman code length: " + huffmanAvgLength);
        System.out.println("Difference: " + (huffmanAvgLength - shannonEntropy));
    }
}