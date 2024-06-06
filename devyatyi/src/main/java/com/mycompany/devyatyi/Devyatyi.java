package com.mycompany.devyatyi;

import javax.swing.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.HashMap;
import java.util.Map;

public class Devyatyi {

    private static final Map<String, Integer> MONTHS = new HashMap<>();

    static {
        MONTHS.put("Янв.", Calendar.JANUARY);
        MONTHS.put("Фев.", Calendar.FEBRUARY);
        MONTHS.put("Мар.", Calendar.MARCH);
        MONTHS.put("Апр.", Calendar.APRIL);
        MONTHS.put("Май", Calendar.MAY);
        MONTHS.put("Июн.", Calendar.JUNE);
        MONTHS.put("Июл.", Calendar.JULY);
        MONTHS.put("Авг.", Calendar.AUGUST);
        MONTHS.put("Сен.", Calendar.SEPTEMBER);
        MONTHS.put("Окт.", Calendar.OCTOBER);
        MONTHS.put("Ноя.", Calendar.NOVEMBER);
        MONTHS.put("Дек.", Calendar.DECEMBER);
    }

    public static void main(String[] args) {
        String monthInput = JOptionPane.showInputDialog("Введите месяц (1–12 или 'Янв.'–'Дек.'): ");
        String yearInput = JOptionPane.showInputDialog("Введите год (1900–2100): ");

        int month;
        int year;

        try {
            if (MONTHS.containsKey(monthInput)) {
                month = MONTHS.get(monthInput);
            } else {
                month = Integer.parseInt(monthInput) - 1;
            }

            year = Integer.parseInt(yearInput);

            if (year < 1900 || year > 2100) {
                throw new IllegalArgumentException("Год вне диапазона 1900–2100.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ошибка ввода: " + e.getMessage());
            return;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(year, month, 1);

        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        SimpleDateFormat sdf = new SimpleDateFormat("EE", Locale.forLanguageTag("ru"));

        StringBuilder calendarText = new StringBuilder("Пн Вт Ср Чт Пт Сб Вс\n");

        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        for (int i = Calendar.MONDAY; i < firstDayOfWeek; i++) {
            calendarText.append("   ");
        }

        for (int day = 1; day <= daysInMonth; day++) {
            calendar.set(Calendar.DAY_OF_MONTH, day);
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY && day != 1) {
                calendarText.append("\n");
            }
            calendarText.append(String.format("%2d ", day));
        }

        JOptionPane.showMessageDialog(null, calendarText.toString(), "Календарь для " +
                new SimpleDateFormat("MMMM yyyy").format(calendar.getTime()), JOptionPane.INFORMATION_MESSAGE);
    }
}
