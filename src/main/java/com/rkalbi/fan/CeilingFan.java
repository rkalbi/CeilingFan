package com.rkalbi.fan;

/**
 * Represents a ceiling fan with adjustable speed and direction.
 * The fan has four speed settings (OFF=0, LOW=1, MEDIUM=2, HIGH=3) and two directions (CLOCKWISE, COUNTER_CLOCKWISE).
 *
 * @author Ramesh Kalbi
 */
public class CeilingFan {

  /**
   * Represents the speed settings of the ceiling fan.
   */
  public enum Speed {
    OFF, LOW, MEDIUM, HIGH;

    private static final Speed[] VALUES = values();

    /**
     * Returns the next speed setting in the cycle.
     * @return the next Speed in the cycle
     */
    public Speed next() {
      return VALUES[(this.ordinal() + 1) % VALUES.length];
    }
  }

  /**
   * Represents the rotation direction of the ceiling fan.
   */
  public enum Direction {
    CLOCKWISE, COUNTER_CLOCKWISE;

    /**
     * Toggles the direction between CLOCKWISE and COUNTER_CLOCKWISE.
     * @return the opposite Direction
     */
    public Direction toggle() {
      return this == CLOCKWISE ? COUNTER_CLOCKWISE : CLOCKWISE;
    }
  }

  private Speed speed;
  private Direction direction;

  /**
   * Constructs a new CeilingFan with default settings (OFF speed and CLOCKWISE direction).
   */
  public CeilingFan() {
    this.speed = Speed.OFF;
    this.direction = Direction.CLOCKWISE;
  }

  /**
   * Simulates pulling the speed cord, cycling through speed settings.
   */
  public void pullSpeedCord() {
    speed = speed.next();
  }

  /**
   * Simulates pulling the direction cord, toggling the fan's direction.
   */
  public void pullDirectionCord() {
    direction = direction.toggle();
  }

  /**
   * Gets the current speed setting of the fan.
   * @return the current Speed
   */
  public Speed getSpeed() {
    return speed;
  }

  /**
   * Gets the current rotation direction of the fan.
   * @return the current Direction
   */
  public Direction getDirection() {
    return direction;
  }

  /**
   * Returns a string representation of the CeilingFan's current state.
   * @return a string representing the fan's speed and direction
   */
  @Override
  public String toString() {
    return "CeilingFan{speed=" + speed + ", direction=" + direction + "}";
  }
}