import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int countOfPicks = Integer.parseInt(info[0]);
        int countOfChanges = Integer.parseInt(info[1]);

        String[] changes = reader.readLine().split(" ");

        List<Leaf> tree = growTree(countOfPicks);
        for (int i = 0; i < countOfChanges; i++) {
            changeLeaves(tree , Integer.parseInt(changes[i]));
        }
        Leaf root = tree.stream().filter(l -> l.getParent() == null).findFirst().get();
        showTree(root);

    }


    private static void showTree(Leaf top) {
        if (top == null) return;
        System.out.print(top.getValue() + " ");
        showTree(top.getLc());
        showTree(top.getRc());
    }

    private static void changeLeaves(List<Leaf> tree, int value) {
        Leaf v = tree.stream().filter(l -> l.getValue() == value).findFirst().orElse(null);
        if (v == null) return;

        Leaf p = v.getParent();
        if (p == null) return; // v уже корень

        Leaf pp = p.getParent();

        boolean vIsLeft = (p.getLc() == v); // v — левый ребёнок?
        boolean pIsLeft = pp != null && pp.getLc() == p; // p — левый ребёнок pp?

        // Подключаем v к pp
        v.setParent(pp);
        if (pp != null) {
            if (pIsLeft) {
                pp.setLc(v);
            } else {
                pp.setRc(v);
            }
        }

        // Потомки до обмена
        Leaf vl = v.getLc();
        Leaf vr = v.getRc();
        Leaf pl = p.getLc();
        Leaf pr = p.getRc();

        if (vIsLeft) {
            // v слева у p
            v.setLc(p);
            v.setRc(vr);
            if (vr != null) vr.setParent(v);

            p.setParent(v);
            p.setLc(vl);
            if (vl != null) vl.setParent(p);
            p.setRc(pr);
            if (pr != null && pr != v) pr.setParent(p); // важно: pr не должен быть v
        } else {
            // v справа у p
            v.setRc(p);
            v.setLc(vl);
            if (vl != null) vl.setParent(v);

            p.setParent(v);
            p.setRc(vr);
            if (vr != null) vr.setParent(p);
            p.setLc(pl);
            if (pl != null && pl != v) pl.setParent(p); // защита от зацикливания
        }
    }
    private static List<Leaf> growTree(int n){
        List<Leaf> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new Leaf(i+1));
        }
        growLeaves(tree);
        return tree;
    }

    private static void growLeaves(List<Leaf> tree){
        int n = tree.size();
        for (int i = 0; i < n; i++) {
            int v = tree.get(i).getValue();

            if (v == 1) {
                // Корень
                tree.get(i).setParent(null);
                if (v * 2 <= n) tree.get(i).setLc(tree.get(v * 2 - 1));
                if (v * 2 + 1 <= n) tree.get(i).setRc(tree.get(v * 2));
            } else if (v * 2 > n) {
                tree.get(i).setLc(null);
                tree.get(i).setRc(null);
                tree.get(i).setParent(tree.get(v / 2 - 1));
            } else if (v * 2 + 1 > n) {
                tree.get(i).setLc(tree.get(v * 2 - 1));
                tree.get(i).setRc(null);
                tree.get(i).setParent(tree.get(v / 2 - 1));
            } else {
                tree.get(i).setLc(tree.get(v * 2 - 1));
                tree.get(i).setRc(tree.get(v * 2));
                tree.get(i).setParent(tree.get(v / 2 - 1));
            }
        }
    }

    private static class Leaf {
        private Integer value;
        private Leaf parent;
        private Leaf lc;
        private Leaf rc;

        public Leaf(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Leaf{" +
                    "value=" + value +
                    '}';
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }


        public Leaf getParent() {
            return parent;
        }

        public void setParent(Leaf parent) {
            this.parent = parent;
        }

        public Leaf getLc() {
            return lc;
        }

        public void setLc(Leaf lc) {
            this.lc = lc;
        }

        public Leaf getRc() {
            return rc;
        }

        public void setRc(Leaf rc) {
            this.rc = rc;
        }
    }
}



















