package company.amazon.other;

import java.sql.Time;
import java.util.*;

public class MetricTracker {
    static final int ONE_SECOND = 60 * 1000;
    static final int ONE_MINUTE = 60 * 60 * 1000;
    static final int ONE_Hour = 60 * 60 * 60 * 1000;

    class MetricItem {
        String type;
        int metricValue;
        long timestamp;

        public MetricItem(String type, int metricValue, long timestamp) {
            this.type = type;
            this.metricValue = metricValue;
            this.timestamp = timestamp;
        }
    }

    LinkedList<MetricItem> itemList = new LinkedList<>();
    Map<String, LinkedList<MetricItem>> map = new HashMap<>();

    void insert(String type, int value) {
        MetricItem item = new MetricItem(type, value, System.currentTimeMillis());
        itemList.add(item);
        map.putIfAbsent(type, new LinkedList<>());
        map.get(type).add(item);
    }

    void drop(String timeUnit, int amount) {
        long curTimestamp = System.currentTimeMillis();
        long duration = 0;
        switch (timeUnit) {
            case "second":
                duration = amount * ONE_SECOND;
                break;
            case "minute":
                duration = amount * ONE_MINUTE;
                break;
            case "hour":
                duration = amount * ONE_Hour;
                break;
        }
        while (itemList.size() > 0) {
            MetricItem lastItem = itemList.getLast();
            if (curTimestamp - lastItem.timestamp < duration) {
                itemList.removeLast();
                map.get(lastItem.type).removeLast();
            } else {
                break;
            }
        }
    }
}
