package com.jesse.strings;

import java.util.*;

public class ProcessTransactionLogs {
    public static List<String> processLogs(List<String> logs, int threshold) {
        // Write your code here
        List<String> res = new ArrayList<>();
        Map<String, Integer> transactions = new HashMap<>();

        for (String log : logs) {
            String[] split = log.split(" ");
            String senderId = split[0];
            String recipientId = split[1];

            if (senderId.equalsIgnoreCase(recipientId)) {
                if (transactions.containsKey(senderId)) {
                    transactions.put(senderId, transactions.get(senderId) + 1);
                } else {
                    transactions.put(senderId, 1);
                }
            } else {
                if (transactions.containsKey(senderId)) {
                    transactions.put(senderId, transactions.get(senderId) + 1);
                } else {
                    transactions.put(senderId, 1);
                }
                if (transactions.containsKey(recipientId)) {
                    transactions.put(recipientId, transactions.get(recipientId) + 1);
                } else {
                    transactions.put(recipientId, 1);
                }
            }
        }

        for (Map.Entry<String, Integer> transaction : transactions.entrySet()) {
            if (transaction.getValue() >= threshold) {
                res.add(transaction.getKey());
            }
        }

        res.sort(new Comparator<String>() {
            public int compare(String a, String b) {
                return Long.compare(Long.parseLong(a), Long.parseLong(b));
            }
        });

        return res;
    }
}
