/**
 * Created by weishubin on 2017/4/18.
 */
public class StockTest {
    public static void main(String[] args) {
        double totalMoney = 0;
        double benjin = 0;
        int month = 0;
        double rate = 0.1;
        double benjinPerMonth = 1000;
        while (true) {
            month++;
            totalMoney += totalMoney * rate/12D; //每月股票增长
            totalMoney += benjinPerMonth;//每月投入本金;
            benjin += benjinPerMonth;//每月投入本金
            if (totalMoney >= 1000000) {
                String s = String.format("每月投入%s元，年息%s，需%s年变成%s元，共投入本金%s元", benjinPerMonth, rate, month/13.0D, totalMoney, benjin);
                System.out.println(s);
                break;
            }
        }
    }
}
