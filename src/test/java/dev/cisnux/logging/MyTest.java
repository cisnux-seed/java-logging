package dev.cisnux.logging;

import org.junit.jupiter.api.Test;
import org.slf4j.MDC;

import java.util.UUID;
import java.util.stream.Stream;

public class MyTest {
    @Test
    void testRequestId() {
        final var controller = new MyController(new MyService(new MyRepository()));

        final var threads = Stream.generate(() -> new Thread(() -> {
            try {
                Thread.sleep(1000L);
                String requestId = UUID.randomUUID().toString();
                MDC.put("requestId", requestId);
                controller.save();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                MDC.remove("requestId");
            }
        })).limit(10).toList();

        threads.forEach(thread -> {
            try {
                thread.start();
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Complete");
    }
}
