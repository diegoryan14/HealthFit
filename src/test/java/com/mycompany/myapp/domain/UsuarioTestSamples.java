package com.mycompany.myapp.domain;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class UsuarioTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Usuario getUsuarioSample1() {
        return new Usuario().id(1L);
    }

    public static Usuario getUsuarioSample2() {
        return new Usuario().id(2L);
    }

    public static Usuario getUsuarioRandomSampleGenerator() {
        return new Usuario().id(longCount.incrementAndGet());
    }
}
