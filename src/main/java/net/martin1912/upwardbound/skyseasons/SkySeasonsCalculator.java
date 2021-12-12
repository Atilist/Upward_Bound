package net.martin1912.upwardbound.skyseasons;

public class SkySeasonsCalculator {
    public int getDay (long levelTicksTime) {
        long totalDays = levelTicksTime / 24000; // Calculates the total days
        long year = totalDays / 250 + 1; // Calculates the current Skylands year
        int days = (int) totalDays + 250 - (int) year * 250;
        return days;
    }
}
