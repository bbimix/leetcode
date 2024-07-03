package 字符串.验证IP地址;

/**
 * @projectName: leetcode
 * @package: 字符串.验证IP地址
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/18 21:23
 */
public class Solution {

    public boolean isIPv4(String IP) {
        String[] s = IP.split("\\.");
        int leng = s.length;
        if (leng != 4) {
            return false;
        }
        for (int i = 0; i < leng; i++) {
            if (s[i].length() == 0 || s[i].length() < 0 || s[i].length() > 3 || (s[i].charAt(0) == '0' && s[i].length() != 1)) {
                return false;
            }
            for (int j = 0; j < s[i].length(); j++) {
                char c = s[i].charAt(j);
                if (c < '0' || c > '9') {
                    return false;
                }
            }
            if (Integer.parseInt(s[i]) < 0 || Integer.parseInt(s[i]) > 255) {
                return false;
            }
        }
        return true;
    }

    public boolean isIPv6(String IP) {
        String[] s = IP.split(":", -1);
        if(s.length != 8){
            return false;
        }
        for(int i = 0; i < s.length; i++){
            //每个分割不能缺省，不能超过4位
            if(s[i].length() == 0 || s[i].length() > 4){
                return false;
            }
            for(int j = 0; j < s[i].length(); j++){
                //不能出现a-fA-F以外的大小写字符
                char c = s[i].charAt(j);
                boolean expr = (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F') ;
                if(!expr){
                    return false;
                }
            }
        }
        return true;
    }

    public String solve(String IP) {
        if (isIPv4(IP)) {
            return "IPv4";
        } else if (isIPv6(IP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }
}

