package com.rkalbi.fan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.IntStream;

/**
 * @author Ramesh Kalbi
 */
class CeilingFanTest {

  private CeilingFan fan;

  @BeforeEach
  void setUp() {
    fan = new CeilingFan();
  }

  @Test
  @DisplayName("Initial state should be OFF and CLOCKWISE")
  void testInitialState() {
    Assertions.assertAll(
        () -> Assertions.assertEquals(CeilingFan.Speed.OFF, fan.getSpeed(),
            "Initial speed should be OFF"),
        () -> Assertions.assertEquals(CeilingFan.Direction.CLOCKWISE, fan.getDirection(),
            "Initial direction should be CLOCKWISE")
    );
  }

  @ParameterizedTest
  @EnumSource(CeilingFan.Speed.class)
  @DisplayName("Speed cord should cycle through all speeds")
  void testSpeedCordCycle(CeilingFan.Speed expectedSpeed) {
    IntStream.range(0, expectedSpeed.ordinal())
        .forEach(i -> fan.pullSpeedCord());
    Assertions.assertEquals(expectedSpeed, fan.getSpeed(), "Speed should match expected value");
  }

  @Test
  @DisplayName("Speed should return to OFF after HIGH")
  void testSpeedCordFullCycle() {
    IntStream.range(0, CeilingFan.Speed.values().length)
        .forEach(i -> {
          Assertions.assertEquals(CeilingFan.Speed.values()[i], fan.getSpeed(),
              "Speed should match cycle position");
          fan.pullSpeedCord();
        });
    Assertions.assertEquals(CeilingFan.Speed.OFF, fan.getSpeed(),
        "Speed should return to OFF after full cycle");
  }

  @Test
  @DisplayName("Direction cord should toggle between CLOCKWISE and COUNTER_CLOCKWISE")
  void testDirectionCordToggle() {
    Assertions.assertAll(
        () -> Assertions.assertEquals(CeilingFan.Direction.CLOCKWISE, fan.getDirection(),
            "Initial direction should be CLOCKWISE"),
        () -> {
          fan.pullDirectionCord();
          Assertions.assertEquals(CeilingFan.Direction.COUNTER_CLOCKWISE, fan.getDirection(),
              "Direction should change to COUNTER_CLOCKWISE");
        },
        () -> {
          fan.pullDirectionCord();
          Assertions.assertEquals(CeilingFan.Direction.CLOCKWISE, fan.getDirection(),
              "Direction should change back to CLOCKWISE");
        }
    );
  }

  @ParameterizedTest
  @CsvSource({
      "1, COUNTER_CLOCKWISE",
      "2, COUNTER_CLOCKWISE",
      "3, COUNTER_CLOCKWISE"
  })
  @DisplayName("Speed and direction changes should not interfere with each other")
  void testSpeedAndDirectionInteraction(int speedPulls, CeilingFan.Direction expectedDirection) {
    IntStream.range(0, speedPulls).forEach(i -> fan.pullSpeedCord());
    fan.pullDirectionCord();
    Assertions.assertAll(
        () -> Assertions.assertEquals(CeilingFan.Speed.values()[speedPulls], fan.getSpeed(),
            "Speed should match number of pulls"),
        () -> Assertions.assertEquals(expectedDirection, fan.getDirection(),
            "Direction should match expected value")
    );
  }

  @Test
  @DisplayName("Multiple speed cycles should work correctly")
  void testMultipleSpeedCycles() {
    int totalPulls = 100;
    IntStream.range(0, totalPulls).forEach(i -> fan.pullSpeedCord());
    Assertions.assertEquals(
        CeilingFan.Speed.values()[totalPulls % CeilingFan.Speed.values().length],
        fan.getSpeed(),
        "Speed should be correct after " + totalPulls + " pulls");
  }

  @Test
  @DisplayName("toString should return correct representation")
  void testToString() {
    Assertions.assertEquals("CeilingFan{speed=OFF, direction=CLOCKWISE}", fan.toString(),
        "toString should match initial state");
    fan.pullSpeedCord();
    fan.pullDirectionCord();
    Assertions.assertEquals("CeilingFan{speed=LOW, direction=COUNTER_CLOCKWISE}", fan.toString(),
        "toString should reflect changes");
  }
}