package 递归回溯.有重复项数字的全排列;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: 递归回溯.有重复项数字的全排列
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/19 18:45
 */

public class Solution {
    public void recursion(ArrayList<ArrayList<Integer>> res, int[] num, ArrayList<Integer> temp, Boolean[] vis){
        //临时数组满了加入输出
        if(temp.size() == num.length){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        //遍历所有元素选取一个加入
        for(int i = 0; i < num.length; i++){
            //如果该元素已经被加入了则不需要再加入了
            if(vis[i]) {
                continue;
            }
            //当前的元素num[i]与同一层的前一个元素num[i-1]相同且num[i-1]已经用过了
            if(i > 0 && num[i - 1] == num[i] && !vis[i - 1])
            {
                continue;
            }
            //标记为使用过
            vis[i] =  true;
            //加入数组
            temp.add(num[i]);
            recursion(res, num, temp, vis);
            //回溯
            vis[i] =  false;
            temp.remove(temp.size() - 1);
        }
    }
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        //先按字典序排序
        Arrays.sort(num);
        Boolean[] vis = new Boolean[num.length];
        Arrays.fill(vis, false);
        ArrayList<ArrayList<Integer> > res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        recursion(res, num, temp, vis);
        return res;
    }
}

