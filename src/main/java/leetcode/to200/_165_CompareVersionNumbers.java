package leetcode.to200;

/**
 * https://leetcode.com/problems/compare-version-numbers/
 * Subject: Array
 * #Medium
 */
public class _165_CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }
        return 0;
    }

    //Provide a second solution (Preferred)
    public int compareVersion2(String version1, String version2) {
        String[] parts1 = version1.split("\\.");
        String[] parts2 = version2.split("\\.");
        for(int p = 0; p < parts1.length || p < parts2.length; p++){
            int num1 = p < parts1.length? Integer.parseInt(parts1[p]) : 0;
            int num2 = p < parts2.length? Integer.parseInt(parts2[p]) : 0;
            if(num1 > num2){
                return 1;
            }else if(num1 < num2){
                return -1;
            }
        }
        return 0;
    }
}
