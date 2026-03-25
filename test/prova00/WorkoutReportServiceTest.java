package prova00;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WorkoutReportServiceTest {
    private final UUID arnoldSchwazeneggerUUID = UUID.fromString("71479dc0-55e1-44e0-8dd8-37c1da2d74b4");
    private final UUID biteloUUID = UUID.fromString("d839785a-f8bc-4a56-964f-3fb081855a2e");

    @Mock
    WorkoutRepository repository;
    @InjectMocks
    WorkoutReportService sut;

    @Nested
    class NestedWorkoutReportWithSetupTest {
        @BeforeEach
        void setup() {
            List<WorkoutSession> sessions = new ArrayList<>();
            var arnoldSchwazenegger = new Member(arnoldSchwazeneggerUUID);
            var bitelo = new Member(biteloUUID);
            sessions.add(new WorkoutSession(arnoldSchwazenegger, 10, 30));
            sessions.add(new WorkoutSession(bitelo, 10, 300));
            sessions.add(new WorkoutSession(arnoldSchwazenegger, 10, 40));
            when(repository.findAll()).thenReturn(sessions);
        }

        @Test
        @DisplayName("Should calculate cost average")
        void shouldCalculateCostAverage() {
            assertThat(sut.averageWorkoutPaidValue(arnoldSchwazeneggerUUID)).isEqualTo(35);
        }

        @Test
        @DisplayName("Should get zero if it is not a member")
        void shouldGetZeroIfItIsNotAMember() {
            assertThat(sut.averageWorkoutPaidValue(UUID.randomUUID())).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("Should throw NullPointerException if user is null")
    void shouldThrowNullPointerExceptionIfUserIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> sut.averageWorkoutPaidValue(null));
    }
}