package language;

import java.time.*;

public interface TimeClient {
  public void setTime(int hour, int minute, int second);

  public void setDate(int day, int month, int year);

  public void setDateAndTime(int day, int month, int year, int hour, int minute, int second);

  public LocalDateTime getLocalDateTime();

  static public ZoneId getZoneId(String zoneString) {
    try {
      return ZoneId.of(zoneString);
    } catch (DateTimeException e) {
      System.err.println("Invalid time zone: " + zoneString + "; using default time zone instead.");
      return ZoneId.systemDefault();
    }
  }

  public default ZonedDateTime getZonedDateTime(String zoneString) {
    return ZonedDateTime.of(getLocalDateTime(), getZoneId(zoneString));
  }
}
