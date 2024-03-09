class Solution {
    Map<Integer, Integer> position;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        position = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            position.put(inorder[i], i);
        }
        return builder(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
    private TreeNode builder(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd){
        if(preBegin >= preEnd || inBegin >= inEnd) return null;
        int midIndex = position.get(preorder[preBegin]);
        TreeNode mid = new TreeNode(inorder[midIndex]);
        int lenLeft = midIndex - inBegin;
        mid.left = builder(preorder, preBegin + 1, preBegin + 1 + lenLeft, inorder, inBegin, midIndex);
        mid.right = builder(preorder, preBegin + 1 + lenLeft, preEnd, inorder, midIndex + 1, inEnd);
        return mid;
    }
}
O(N), O(N)
