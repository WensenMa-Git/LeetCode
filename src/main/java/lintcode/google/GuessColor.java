package lintcode.google;

/**
 * 2.猜颜色游戏, 4位数每位可能是6个颜色中的一个，先让你当先手实现guess函数，然后再当猜的人。
 * 每次猜会返回一个b和一个w。 b表示有多少个位置和颜色都对应，w表示有多少个颜色对了但是位置不对
 * 比如RRBB BRGG b=1 w=1
 */
public class GuessColor {

    public int guessColor(String first, String second) {

        int[] counts = new int[256];
        int b = 0, w = 0;
        for (int i = 0; i < 4; i++) {
            if (first.charAt(i) == second.charAt(i)) {
                b++;
            } else {
                counts[first.charAt(i)]++;
                counts[second.charAt(i)]--;
            }
        }
        int sum = 0;
        for (int count: counts) {
            sum += Math.abs(count);
        }
        return ((4 - b) * 2 - sum) / 2;
    }

    public static void main(String[] args) {
        int i = new GuessColor().guessColor("accd", "dcba");
        System.out.println(i);
    }
}
