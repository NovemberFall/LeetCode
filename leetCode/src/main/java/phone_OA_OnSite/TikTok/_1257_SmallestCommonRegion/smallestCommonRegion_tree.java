package phone_OA_OnSite.TikTok._1257_SmallestCommonRegion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class smallestCommonRegion_tree {
    class TreeNode {
        String val;
        TreeNode parent;

        TreeNode(String val) {
            this.val = val;
        }
    }

    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, TreeNode> parents = new HashMap<>();
        Set<String> ancestors = new HashSet<>();
        for (List<String> region : regions) {
            String parent = region.get(0);
            TreeNode pNode = parents.getOrDefault(parent, new TreeNode(parent));
            parents.putIfAbsent(parent, pNode);
            for (int i = 1; i < region.size(); i++) {
                String n = region.get(i);
                TreeNode node = parents.getOrDefault(n, new TreeNode(n));
                parents.putIfAbsent(n, node);
                node.parent = pNode;
            }
        }

        TreeNode cur = parents.get(region1);
        while (cur != null) {
            ancestors.add(cur.val);
            cur = cur.parent;
        }

        cur = parents.get(region2);
        while (cur != null) {
            if (ancestors.contains(cur.val)) {
                return cur.val;
            }
            cur = cur.parent;
        }
        return null;
    }
}
