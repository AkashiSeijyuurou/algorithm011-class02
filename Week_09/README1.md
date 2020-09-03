学习笔记

1.高级DP
（1）复杂度来源
	1）状态拥有更多维度（二维，三维或者更多，甚至要压缩）
	2）状态方程更加复杂
本质：内功，逻辑思维，数学

2.字符串
（1）字符串声明，初始化，比较，遍历

不同路径2状态转移方程：
（1）定义dp矩阵
dp[i][j]为机器人走到obstacleGrid[i][j]这个位置有多少条路径

（2）方程
边界点
if grid[0][0] == 0 return 0
else
dp[0][i] = 1;
dp[i][0] = 1;

if grid[i][j] == 1
dp[i][j] = dp[i - 1][j] + dp[i][j - 1];