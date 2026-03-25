package prova00;

import java.util.List;

public interface WorkoutRepository {
    List<WorkoutSession> findAll();
}