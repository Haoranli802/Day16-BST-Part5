class Solution {
    Map<Integer, Integer> position;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        position = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            position.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }
    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if(inStart >= inEnd || postStart >= postEnd) return null;
        int midIndex = position.get(postorder[postEnd - 1]);
        TreeNode mid = new TreeNode(inorder[midIndex]);
        int lenLeft = midIndex - inStart;
        mid.left = helper(inorder, inStart, midIndex, postorder, postStart, postStart + lenLeft);
        mid.right = helper(inorder, midIndex + 1, inEnd, postorder, postStart + lenLeft, postEnd - 1);
        return mid;
    }
}
//O(N), O(N)
