package leetcode.to500;


public class _434_NumberofSegmentsinaString {

    public int countSegments(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        return s.split("\\s+").length;
    }
}
