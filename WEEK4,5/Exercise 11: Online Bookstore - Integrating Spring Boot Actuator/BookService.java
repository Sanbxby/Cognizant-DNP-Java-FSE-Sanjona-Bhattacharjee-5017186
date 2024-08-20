

package com.example.bookstore.service;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final MeterRegistry meterRegistry;

    @Autowired
    public BookService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    public void someServiceMethod() {
        // Increment a custom counter
        meterRegistry.counter("book_service_custom_metric", "type", "example").increment();
    }
}
