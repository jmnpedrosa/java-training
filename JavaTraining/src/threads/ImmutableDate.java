package threads;

import java.util.Date;

/**
 * Example of how to make an object that is immutable and thread-safe.
 */
public class ImmutableDate {
  
  // Define a private final object
  private final Date myDate;
  
  // Initialize it in the public constructor
  public ImmutableDate(Date date) {
    myDate = date;
  }
  
  // Return a copy of the object in its getter.
  public Date getDate() {
    return (Date) myDate.clone();
  }
  
  // No setter ;)
}
