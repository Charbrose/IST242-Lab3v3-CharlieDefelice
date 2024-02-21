package org.example;

import redis.clients.jedis.Jedis;

public class RedisCRUD {
    public void performCRUD() {
        try (Jedis jedis = new Jedis("localhost")) {
            // Implement CRUD operations for Redis
            // Set key-value pair
            jedis.set("key", "value");

            // Get value by key
            String value = jedis.get("key");
            System.out.println(value);

            // Update value
            jedis.set("key", "new_value");

            // Delete key
            jedis.del("key");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
