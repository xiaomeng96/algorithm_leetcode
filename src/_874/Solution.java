package _874;

import java.util.HashSet;
import java.util.Set;

/**
 * 874. 模拟行走机器人
 * @author xm
 *
 */
public class Solution {
	/**
	 * 存储机器人的位置和方向
	 * 采用set集合保存障碍物点（节省时间）
	 * @param commands
	 * @param obstacles
	 * @return
	 */
    public int robotSim(int[] commands, int[][] obstacles) {
    	//方向{北，东， 南， 西}
    	int[] dx= {0, 1, 0, -1};//x坐标：东西走，东为正
    	int[] dy= {1, 0, -1, 0};//y坐标：南北走，北为正
    	int x=0, y=0, di=0;
    	
    	//将obstacles转为set集合
    	Set<String> obstacleSet=new HashSet<>();
    	for (int[] obstacle : obstacles) {
			obstacleSet.add(obstacle[0]+","+obstacle[1]);
		}
    	
    	int res=0;
    	for (int comm : commands) {
			if(comm == -1) {//向右转90度
				di=(di+1)%4;
			}else if(comm == -2) {//向左转90度
				di=(di+3)%4;
			}else {
				for (int i = 0; i < comm; i++) {
					//下一步的坐标
					int nx=x+dx[di];
					int ny=y+dy[di];
					if(obstacleSet.contains(nx+","+ny)) {
						break;
					}else {
						x=nx;
						y=ny;
						res=Math.max(res, x*x+y*y);
					}
				}
			}
		}
    	return res;

    }
    
    public int robotSim2(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, di = 0;

        // Encode obstacles (x, y) as (x+30000) * (2^16) + (y+30000)
        Set<Long> obstacleSet = new HashSet();
        for (int[] obstacle: obstacles) {
            long ox = (long) obstacle[0] + 30000;
            long oy = (long) obstacle[1] + 30000;
            obstacleSet.add((ox << 16) + oy);
        }

        int ans = 0;
        for (int cmd: commands) {
            if (cmd == -2)  //left
                di = (di + 3) % 4;
            else if (cmd == -1)  //right
                di = (di + 1) % 4;
            else {
                for (int k = 0; k < cmd; ++k) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
                    if (!obstacleSet.contains(code)) {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x*x + y*y);
                    }
                }
            }
        }

        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution so=new Solution();
		int[] commands= {4,-1,4};
		int[][] obstacles= {{2, 4}};
		System.out.println(so.robotSim2(commands, obstacles));
		
	}

}
