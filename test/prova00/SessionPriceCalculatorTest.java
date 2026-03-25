package prova00;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class SessionPriceCalculatorTest {
    @ParameterizedTest
    @CsvSource(value = {
            "6,0,6,2,16.0", // R2
            "7,59,8,1,18.0", // R3
            "8,1,8,3,20.0", // R4
            "20,59,21,1,18.0", // R5
            "21,0,21,2,16.0", // R6
            "7,59,21,1,7816.0", // R7
            "8,0,8,1,10.0", // R11
            "20,59,21,0,10.0", // R12
            "22,59,23,0,8.0", // R13
            "20,0,20,0,0.0", // R17
    })
    @DisplayName("Should compute session cost")
    void shouldComputeSessionCost(int beginHour, int beginMinute, int endHour, int endMinute, double totalPrice) {
        LocalDateTime start = LocalDateTime.of(LocalDate.now(), LocalTime.of(beginHour, beginMinute));
        LocalDateTime end = LocalDateTime.of(LocalDate.now(), LocalTime.of(endHour, endMinute));
        var sut = new SessionPriceCalculator(10, start, end);
        assertThat(sut.checkout()).isEqualTo(totalPrice);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "4,0,4,2", // R2
            "10,0,23,10", // R8
            "10,0,23,1", // R14
    })
    @DisplayName("Should throw illegal state if session is invalid")
    void shouldThrowIllegalStateIfSessionIsInvalid(int beginHour, int beginMinute, int endHour, int endMinute) {
        LocalDateTime start = LocalDateTime.of(LocalDate.now(), LocalTime.of(beginHour, beginMinute));
        LocalDateTime end = LocalDateTime.of(LocalDate.now(), LocalTime.of(endHour, endMinute));
        assertThatIllegalStateException()
                .isThrownBy(() -> new SessionPriceCalculator(10, start, end));
    }

    @Test // R16
    @DisplayName("Should cost one minute if stays for seconds")
    void shouldCostOneMinuteIfStaysForSeconds() {
        LocalDateTime start = LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0));
        LocalDateTime end = start.plusSeconds(10);
        var sut = new SessionPriceCalculator(10, start, end);
        assertThat(sut.checkout()).isEqualTo(10.0);
    }

    @Test // R9
    @DisplayName("Should throw IllegalStateException if session ends in the next day")
    void shouldThrowIllegalStateExceptionIfSessionEndsInTheNextDay() {
        LocalDateTime start = LocalDateTime.of(LocalDate.now(), LocalTime.of(19, 0));
        LocalDateTime end = start.plusDays(1);
        var sut = new SessionPriceCalculator(10, start, end);
        assertThat(sut.checkout()).isEqualTo(10.0);
    }

    @Test // R15
    @DisplayName("Should throw IllegalStateException if did not register the check-in")
    void shouldThrowIllegalStateExceptionIfDidNotRegisterTheCheckIn() {
        LocalDateTime end = LocalDateTime.of(LocalDate.now(), LocalTime.of(19, 0));
        var sut = new SessionPriceCalculator(10, null, end);
        assertThatIllegalStateException().isThrownBy(sut::checkout);
    }
}