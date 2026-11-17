package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GcdTest {
    @Test
    @DisplayName("G1: x 13->20; y 13->15F")
    void zeroDivisor() {
        assertEquals(7, DataFlowTargets.gcd(7, 0));
    }

    @Test
    @DisplayName("G2: x 13->16, 17->16/20; y 13->15T/16/17, 18->15T/15F/16/17; tmp 16->18")
    void twoIterations() {
        assertEquals(4, DataFlowTargets.gcd(12, 8));
    }
}
