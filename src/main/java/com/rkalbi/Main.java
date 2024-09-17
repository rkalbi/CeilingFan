package com.rkalbi;

import com.rkalbi.fan.CeilingFan;
import com.rkalbi.fan.CeilingFan.Direction;
import com.rkalbi.fan.CeilingFan.Speed;
import java.util.Arrays;
import java.util.function.Supplier;

/**
 * Demonstrates the use of the CeilingFan class to simulate a ceiling fan with adjustable speed and
 * direction. The fan has four speed settings (OFF=0, LOW=1, MEDIUM=2, HIGH=3) and two directions
 * (CLOCKWISE, COUNTER_CLOCKWISE). The fan can be controlled by pulling the speed cord to cycle
 * through speed settings and pulling the direction cord to toggle the direction. The current state
 * of the fan can be retrieved using the toString method.
 *
 * @author Ramesh Kalbi
 */
public class Main {

  public static void main(String[] args) {

    final CeilingFan fan = new CeilingFan();
    System.out.println("Initial state: " + fan);

    final Supplier<String> fanState = () -> "Current state: " + fan;

    System.out.println("\nTesting speed cord:");
    Arrays.stream(Speed.values())
        .forEach(s -> {
          fan.pullSpeedCord();
          System.out.println(fanState.get());
        });

    System.out.println("\nTesting direction cord:");
    Arrays.stream(Direction.values())
        .forEach(d -> {
          fan.pullDirectionCord();
          System.out.println(fanState.get());
        });

    System.out.println("\nTesting multiple speed cycles:");
    final CeilingFan newFan = new CeilingFan();
    Arrays.stream(new int[10])
        .forEach(i -> newFan.pullSpeedCord());
    System.out.println("After 10 speed cord pulls: " + newFan);
  }
}