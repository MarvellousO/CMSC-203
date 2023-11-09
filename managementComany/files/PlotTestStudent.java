package managementComany;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class PlotTestStudent {
    private Plot plot1, plot2;

    @BeforeEach
    void setUp() throws Exception {
        plot1 = new Plot(2, 2, 6, 6);
        plot2 = new Plot(3, 4, 4, 3);
    }

    @AfterEach
    void tearDown() throws Exception {
        plot1 = plot2 = null;
    }

    @Test
    void testOverlaps() {
        assertTrue(plot1.overlaps(plot2));
    }

    @Test
    void testEncompasses() {
        assertTrue(plot1.encompasses(plot2));
    }

    @Test
    void testToString() {
        assertEquals("3,4,4,3", plot2.toString());
    }
}