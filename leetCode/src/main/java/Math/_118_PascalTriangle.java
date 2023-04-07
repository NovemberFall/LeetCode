package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class _118_PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allRows = new ArrayList<>();

        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            allRows.add(new ArrayList<>(row));
        }
        return allRows;
    }

    public static void main(String[] args) {
        _118_PascalTriangle pascalTriangle = new _118_PascalTriangle();
        List<List<Integer>> res = pascalTriangle.generate(5);
        System.out.println(res);
    }
}
