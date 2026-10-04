class Solution {

    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int start, int end) {

        // No elements left
        if (start > end) {
            return null;
        }

        // First unused preorder element is root
        int rootValue = preorder[preIndex++];

        TreeNode root = new TreeNode(rootValue);

        // Find root position in inorder
        int rootIndex = start;

        while (inorder[rootIndex] != rootValue) {
            rootIndex++;
        }

        // Build left subtree
        root.left = build(preorder, inorder, start, rootIndex - 1);

        // Build right subtree
        root.right = build(preorder, inorder, rootIndex + 1, end);

        return root;
    }
}