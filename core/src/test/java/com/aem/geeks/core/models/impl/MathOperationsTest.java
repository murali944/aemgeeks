package com.aem.geeks.core.models.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({ MockitoExtension.class })
class MathOperationsTest {

    @InjectMocks
    MathOperations mathOperations;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void validateAddition() {
        int actual = mathOperations.addition(3, 3);
        assertEquals(6, actual);
    }

    @Test
    public void validateAdditionwithNegative() {
        int actual = mathOperations.addition(3, -3);
        assertEquals(0, actual);
    }

    @Test
    public void validateNegative() {
        int actual = mathOperations.addition(-3, -3);
        assertEquals(-6, actual);
    }
}