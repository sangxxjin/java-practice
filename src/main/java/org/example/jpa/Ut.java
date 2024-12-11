package org.example.jpa;

import lombok.SneakyThrows;

public class Ut {

    public static class thread {

        @SneakyThrows
        public static void sleep(int millis) {
            Thread.sleep(millis);
        }
    }
}
