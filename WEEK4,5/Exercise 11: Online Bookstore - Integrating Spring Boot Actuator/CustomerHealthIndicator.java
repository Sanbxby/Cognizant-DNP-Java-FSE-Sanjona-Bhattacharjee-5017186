

package com.example.bookstore.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        // Example: Check if a service is up and running
        boolean serviceUp = checkServiceStatus();
        
        if (serviceUp) {
            return Health.up().withDetail("CustomService", "Service is up and running").build();
        } else {
            return Health.down().withDetail("CustomService", "Service is down").build();
        }
    }

    private boolean checkServiceStatus() {
        // Implement your service status check logic here
        return true; // Example status
    }
}
