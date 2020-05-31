package br.ce.wcaquino.taskbackend.utils;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class DateUtilsTest {

    @Test
    public void shouldBeTrueForFutureDate() {
        LocalDate localDate = LocalDate.of(3000, 01, 01);
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(localDate));
    }

    @Test
    public void shouldBeTrueForNowDate() {
        LocalDate localDate = LocalDate.now();
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(localDate));
    }

    @Test
    public void shouldBeFalseForPastDate() {
        LocalDate localDate = LocalDate.of(2000, 01, 01);
        Assert.assertFalse(DateUtils.isEqualOrFutureDate(localDate));
    }
}
