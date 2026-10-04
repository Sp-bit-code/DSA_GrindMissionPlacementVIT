class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, targetSum, path, result);

        return result;
    }

    private void dfs(TreeNode node,
                     int remainingSum,
                     List<Integer> path,
                     List<List<Integer>> result) {

        // Base case
        if (node == null) {
            return;
        }

        // Add current node to path
        path.add(node.val);

        // Reduce remaining sum
        remainingSum -= node.val;

        // Check if it is a leaf and sum becomes 0
        if (node.left == null &&
            node.right == null &&
            remainingSum == 0) {

            result.add(new ArrayList<>(path));
        }

        // Explore left subtree
        dfs(node.left, remainingSum, path, result);

        // Explore right subtree
        dfs(node.right, remainingSum, path, result);

        // Backtracking
        path.remove(path.size() - 1);
    }
}