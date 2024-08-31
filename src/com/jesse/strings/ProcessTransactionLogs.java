package com.jesse.strings;

import java.util.*;

public class ProcessTransactionLogs {
    public static List<String> processLogs(List<String> logs, int threshold) {
        // Write your code here
        List<String> res = new ArrayList<>();
        Map<String, Integer> tmap = new HashMap<>();

        for (String log : logs) {
            String[] split = log.split(" ");
            String senderId = split[0];
            String recipientId = split[1];

            tmap.put(senderId, tmap.getOrDefault(senderId, 0) + 1);
            if (!senderId.equals(recipientId)) tmap.put(recipientId, tmap.getOrDefault(recipientId, 0) + 1);
        }

        for (Map.Entry<String, Integer> transaction : tmap.entrySet()) {
            if (transaction.getValue() >= threshold) {
                res.add(transaction.getKey());
            }
        }

        res.sort((a, b) -> Long.compare(Long.parseLong(a), Long.parseLong(b)));

        return res;
    }
}
