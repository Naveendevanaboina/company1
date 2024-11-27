package com.neoteric.collections.orders;


import java.util.*;

public class WeeklyRestaurantOrderTracker {

        private Map<String, Map<String, Integer>> weeklyOrders;
        private static final List<String> DAYS_OF_WEEK = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");

        public WeeklyRestaurantOrderTracker() {
            weeklyOrders = new HashMap<>();
            for (String day : DAYS_OF_WEEK) {
                weeklyOrders.put(day, new HashMap<>());
            }
        }

        public void recordOrder(String day, String itemName) {
            if (!weeklyOrders.containsKey(day)) {
                System.out.println("Invalid day: " + day);
                return;
            }

            Map<String, Integer> dailyOrderCount = weeklyOrders.get(day);
            dailyOrderCount.put(itemName, dailyOrderCount.getOrDefault(itemName, 0) + 1);
        }

        public String getDayWithMostOrders() {
            String dayWithMostOrders = null;
            int maxOrders = 0;

            for (String day : DAYS_OF_WEEK) {
                int totalOrdersForDay = weeklyOrders.get(day).values().stream().mapToInt(Integer::intValue).sum();
                if (totalOrdersForDay > maxOrders) {
                    maxOrders = totalOrdersForDay;
                    dayWithMostOrders = day;
                }
            }

            return dayWithMostOrders;
        }

        public String getDayWithLeastOrders() {
            String dayWithLeastOrders = null;
            int minOrders = Integer.MAX_VALUE;

            for (String day : DAYS_OF_WEEK) {
                int totalOrdersForDay = weeklyOrders.get(day).values().stream().mapToInt(Integer::intValue).sum();
                if (totalOrdersForDay < minOrders) {
                    minOrders = totalOrdersForDay;
                    dayWithLeastOrders = day;
                }
            }

            return dayWithLeastOrders;
        }

        public List<String> getHighDemandItems(int threshold) {
            Map<String, Integer> totalItemOrders = new HashMap<>();

            for (String day : DAYS_OF_WEEK) {
                Map<String, Integer> dailyOrders = weeklyOrders.get(day);
                for (Map.Entry<String, Integer> entry : dailyOrders.entrySet()) {
                    totalItemOrders.put(entry.getKey(), totalItemOrders.getOrDefault(entry.getKey(), 0) + entry.getValue());
                }
            }

            List<String> highDemandItems = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : totalItemOrders.entrySet()) {
                if (entry.getValue() >= threshold) {
                    highDemandItems.add(entry.getKey());
                }
            }
            return highDemandItems;
        }

        public List<String> getLowDemandItems(int threshold) {
            Map<String, Integer> totalItemOrders = new HashMap<>();

            for (String day : DAYS_OF_WEEK) {
                Map<String, Integer> dailyOrders = weeklyOrders.get(day);
                for (Map.Entry<String, Integer> entry : dailyOrders.entrySet()) {
                    totalItemOrders.put(entry.getKey(), totalItemOrders.getOrDefault(entry.getKey(), 0) + entry.getValue());
                }
            }

            List<String> lowDemandItems = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : totalItemOrders.entrySet()) {
                if (entry.getValue() < threshold) {
                    lowDemandItems.add(entry.getKey());
                }
            }
            return lowDemandItems;
        }

        public void displayWeeklyOrders() {
            System.out.println("Weekly Orders Summary:");
            for (String day : DAYS_OF_WEEK) {
                System.out.println(day + ": " + weeklyOrders.get(day));
            }
        }

    }


