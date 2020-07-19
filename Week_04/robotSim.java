//机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令： 
//
// 
// -2：向左转 90 度 
// -1：向右转 90 度 
// 1 <= x <= 9：向前移动 x 个单位长度 
// 
//
// 在网格上有一些格子被视为障碍物。 
//
// 第 i 个障碍物位于网格点 (obstacles[i][0], obstacles[i][1]) 
//
// 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。 
//
// 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。 
//
// 
//
// 示例 1： 
//
// 输入: commands = [4,-1,3], obstacles = []
//输出: 25
//解释: 机器人将会到达 (3, 4)
// 
//
// 示例 2： 
//
// 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//输出: 65
//解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
// 
//
// 
//
// 提示： 
//
// 
// 0 <= commands.length <= 10000 
// 0 <= obstacles.length <= 10000 
// -30000 <= obstacle[i][0] <= 30000 
// -30000 <= obstacle[i][1] <= 30000 
// 答案保证小于 2 ^ 31 
// 
// Related Topics 贪心算法 
// 👍 101 👎 0


import java.util.HashSet;
import javafx.scene.effect.SepiaTone;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int ans = 0;
        int direction = 0; //0北 1东 2南 3西
        int[][] add = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0;
        int y = 0;
        Set<String>  set = new HashSet<>();

        for (int i = 0; i < obstacles.length; i++) {
            set.add(obstacles[i][0] + "," + obstacles[i][1]);
        }

        for (int steps : commands) {
            int new_x = 0;
            int new_y = 0;
            if (steps >= 0) {
                for (int i = 0; i < steps; i++) {
                    new_x = x + add[direction][0];
                    new_y = y + add[direction][1];

                    if (set.contains(new_x + "," + new_y)) {
                        break;
                    }

                    x = new_x;
                    y = new_y;

                    ans = Math.max(ans, x * x + y * y);
                }
            }else {
                direction = steps == -1 ? (direction + 1) % 4 : (direction + 3) % 4;
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
