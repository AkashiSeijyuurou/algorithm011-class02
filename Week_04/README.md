学习笔记
1.思考题：使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
答：其实该问题可以转换为找最小值所在的位置，因为是升序数组进行的旋转，所以无序的地方就是最小值所在的位置，从而转换为寻找旋转有序数组的最小值的位置
使用二分查找条件：
（1）左值<中值  中值<右值，该范围有序，最小值在左边，收缩右边界
（2）左值>中值  中值<右值，左边存在旋转点，最小值在左边，收缩右边界
（3）左值<中值  中值>右值, 最小值在右边，收缩左边界
（4）最后一种情况为递减数组的情况，所以不考虑
最后可以合并成 if nums[mid] < nums[right] right = mid;  or  if nums[mid] > nums[left] left = mid + 1;


总结：
1.深度优先 DFS, 广度优先 BFS
（1）DFS和BFS是通过访问节点顺序不同而分出来的，其中还有通过优先级优先，例如推荐算法
（2）二者相同点是所有的点都要访问一次，且每个点仅访问一次
（3）DFS实质上就是递归
（4）BFS是维护一个队列，将队列中的节点弹出，并遍历，并通过该节点获取其他有联系的节点，并放入队列中，用于下次循环，直至队列中没有节点

2.贪心算法
（1）贪心算法是一种在每一步训责中都采取在当前状态下最好或最优的（即最有利的）选择，从而希望导致结果是全局最好或最优的算法
（2）与动态规划的区别：
     1）贪心算法对每个子问题的解决方案都做出选择，不能回退；（当下做局部最优的判断）
	 2）动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能（最优判断 + 回退）
（3）适用场景
     1）问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解为最优子结构
（4）可以解决的问题：1）求图中的最小生成树；2）求哈夫曼编码等
（5）一旦某个问题可用贪心算法解决，那么该算法一般是解决这个问题的最优解。由于贪心算法的高效性以及其所求得的答案比较接近最优解，贪心算法常用作于辅助算法或直接解决一些要求结果不特别精确的问题

3.二分查找
（1）时间复杂度 O(log n)
（2）模板1
while (left < right) {
	int mid = left + (right - left) / 2;
	if (nums[left] < target) {
		left = mid + 1;
	} else {
		right = mid;
	}
}

return left; 


