package normal;


import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

class CBTInserter {
    List<TreeNode> list = new ArrayList<>();
    int index = 0;
    private TreeNode root;
    public CBTInserter(TreeNode root) {
        list.add(root);
        int cur = 0;
        while(cur < list.size()){
            TreeNode node = list.get(cur);
            if (node.left != null) list.add(node.left);
            if (node.right != null) list.add(node.right);
            cur++;
        }
    }

    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        while (list.get(index).left != null && list.get(index).right != null) index++;
        TreeNode fa = list.get(index);
        if (fa.left == null) fa.left = node;
        else if (fa.right == null) fa.right = node;
        list.add(node);
        return fa.val;
    }

    public TreeNode get_root() {
        return list.get(0);
    }
}
