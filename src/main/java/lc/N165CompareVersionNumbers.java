package lc;

/**
 * @author hawdies
 * @date 2021/9/1
 **/
public class N165CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");
        int n = v1s.length;
        int m = v2s.length;
        for (int i = 0; i < Math.max(n, m); i++) {
            int value1 = i < n ? Integer.parseInt(v1s[i]) : 0;
            int value2 = i < m ? Integer.parseInt(v2s[i]) : 0;
            if (value1 - value2 > 0) return 1;
            else if (value1 - value2 < 0) return -1;
        }
        return 0;
    }
}
