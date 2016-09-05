package com.gmail.dpierron.calibre;

import com.gmail.dpierron.calibre.datamodel.DateRange;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.fail;


public class DateRangeTest {

  @Test
  public void testValueOf() {
    GregorianCalendar d = new GregorianCalendar();
    d.add(Calendar.DAY_OF_MONTH, -0);

    if (DateRange.ONEDAY != DateRange.valueOf(d.getTime()))
      fail("DateRange failed on ONEDAY");

    d = new GregorianCalendar();
    d.add(Calendar.DAY_OF_MONTH, -6);

    if (DateRange.ONEWEEK != DateRange.valueOf(d.getTime()))
      fail("DateRange failed on ONEWEEK");

    d = new GregorianCalendar();
    d.add(Calendar.DAY_OF_MONTH, -13);

    if (DateRange.FORTNIGHT != DateRange.valueOf(d.getTime()))
      fail("DateRange failed on FORTNIGHT");

    d = new GregorianCalendar();
    d.add(Calendar.DAY_OF_MONTH, -27); // sometimes a month can even be 28 days long

    if (DateRange.MONTH != DateRange.valueOf(d.getTime()))
      fail("DateRange failed on MONTH");

    d = new GregorianCalendar();
    d.add(Calendar.DAY_OF_MONTH, -57); // minimum is 28 + 30

    if (DateRange.TWOMONTHS != DateRange.valueOf(d.getTime()))
      fail("DateRange failed on TWOMONTHS");

    d = new GregorianCalendar();
    d.add(Calendar.DAY_OF_MONTH, -88); // minimum is 28 + 30 + 31

    if (DateRange.THREEMONTHS != DateRange.valueOf(d.getTime()))
      fail("DateRange failed on THREEMONTHS");

    d = new GregorianCalendar();
    d.add(Calendar.DAY_OF_MONTH, -179);  // minimum is 28 + 30 + 31 + 30 + 31 + 30

    if (DateRange.SIXMONTHS != DateRange.valueOf(d.getTime()))
      fail("DateRange failed on SIXMONTHS");

    d = new GregorianCalendar();
    d.add(Calendar.DAY_OF_MONTH, -359);

    if (DateRange.YEAR != DateRange.valueOf(d.getTime()))
      fail("DateRange failed on YEAR");

    d = new GregorianCalendar();
    d.add(Calendar.DAY_OF_MONTH, -3000);

    if (DateRange.MORE != DateRange.valueOf(d.getTime()))
      fail("DateRange failed on MORE");

  }

}
