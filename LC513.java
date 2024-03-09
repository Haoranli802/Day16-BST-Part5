class Solution {
    int result;
    int maxDepth;
    public int findBottomLeftValue(TreeNode root) {
        result = 0;
        maxDepth = 0;
        helper(root, 1); 
        return result;
    }
    private void helper(TreeNode root, int depth){
        if(root == null) return;
        if(depth > maxDepth){
            result = root.val;
            maxDepth = depth;
        };
        helper(root.left, depth + 1);
        helper(root.right, depth + 1);
    }
}
//递归 O(N), O(N)

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int result = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = que.poll();
                if(i == 0) result = cur.val;
                if(cur.left != null) que.offer(cur.left);
                if(cur.right != null) que.offer(cur.right);
            }
        }
        return result;
    }
}

//迭代 O(N), O(N)
