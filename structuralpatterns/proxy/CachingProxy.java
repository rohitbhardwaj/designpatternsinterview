package structuralpatterns.proxy;

import java.util.HashMap;
import java.util.Map;

public class CachingProxy implements Database {
    private final Database next;
    private final Map<String, String> cache = new HashMap<>();

    public CachingProxy(Database next) {
        this.next = next;
    }

    @Override
    public void connect() {
        next.connect();
    }

    @Override
    public void executeQuery(String query) {
        if (cache.containsKey(query)) {
            System.out.println("Cache hit: " + cache.get(query));
        } else {
            next.executeQuery(query);
            cache.put(query, "Result of " + query);
        }
    }
}