class Solution {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        if(root == null) return result;
        path = new ArrayList<>();
        path.add(root.val);
        backTracking(root, targetSum);
        return result;
    }
    private void backTracking(TreeNode root, int targetSum){
        if(root.left == null && root.right == null && root.val == targetSum){
            result.add(new ArrayList(path));
            return;
        }
        if(root.left != null){
            path.add(root.left.val);
            backTracking(root.left, targetSum - root.val);
            path.removeLast();
        }
        if(root.right != null){
            path.add(root.right.val);
            backTracking(root.right, targetSum - root.val);
            path.removeLast();
        }
    }
}

//O(N^2), O(N)
