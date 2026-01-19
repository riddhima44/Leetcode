// Last updated: 1/19/2026, 10:46:01 PM
import java.util.*;

class MovieRentingSystem {

    static class Node {
        int shop, movie, price;
        Node(int s, int m, int p) {
            shop = s;
            movie = m;
            price = p;
        }
    }

    Map<Integer, Map<Integer, Integer>> price = new HashMap<>();
    Map<Integer, TreeSet<Node>> available = new HashMap<>();

    TreeSet<Node> rented = new TreeSet<>(
        (a, b) -> {
            if (a.price != b.price) return a.price - b.price;
            if (a.shop != b.shop) return a.shop - b.shop;
            return a.movie - b.movie;
        }
    );

    Map<String, Node> nodes = new HashMap<>();

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], priceVal = e[2];

            price.computeIfAbsent(shop, k -> new HashMap<>()).put(movie, priceVal);

            Node node = new Node(shop, movie, priceVal);
            nodes.put(shop + "#" + movie, node);

            available
                .computeIfAbsent(movie, k -> new TreeSet<>(
                    (a, b) -> {
                        if (a.price != b.price) return a.price - b.price;
                        return a.shop - b.shop;
                    }
                ))
                .add(node);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!available.containsKey(movie)) return res;

        int count = 0;
        for (Node n : available.get(movie)) {
            res.add(n.shop);
            if (++count == 5) break;
        }
        return res;
    }

    public void rent(int shop, int movie) {
        Node node = nodes.get(shop + "#" + movie);
        available.get(movie).remove(node);
        rented.add(node);
    }

    public void drop(int shop, int movie) {
        Node node = nodes.get(shop + "#" + movie);
        rented.remove(node);
        available.get(movie).add(node);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        for (Node n : rented) {
            res.add(Arrays.asList(n.shop, n.movie));
            if (++count == 5) break;
        }
        return res;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */