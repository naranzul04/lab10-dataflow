package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BonusTest {
    @Test
    void emptyBelowThreshold() {
        assertEquals(0, DataFlowTargets.bonus(new int[]{}, 1));
    }

    @Test
    void splitAttendanceAtThreshold() {
        assertEquals(5, DataFlowTargets.bonus(new int[]{1, 0, 1}, 2));
    }

    @Test
    void fiveConsecutiveAtThreshold() {
        assertEquals(8, DataFlowTargets.bonus(new int[]{1, 1, 1, 1, 1}, 5));
    }

    @Test
    void rejectsNullAttendance() {
        assertThrows(IllegalArgumentException.class, () -> DataFlowTargets.bonus(null, -1));
    }

    @Test
    void rejectsNegativeThreshold() {
        assertThrows(IllegalArgumentException.class, () -> DataFlowTargets.bonus(new int[]{1}, -1));
    }

    @Test
    void emptyAtZeroThreshold() {
        assertEquals(5, DataFlowTargets.bonus(new int[]{}, 0));
    }

    @Test
    void longStreakBelowThreshold() {
        assertEquals(3, DataFlowTargets.bonus(new int[]{1, 0, 1, 1, 1, 1, 1}, 7));
    }

    @Test
    void separatedDaysDoNotMakeFiveDayStreak() {
        assertEquals(5, DataFlowTargets.bonus(new int[]{1, 0, 1, 1, 1, 1}, 5));
    }
}
