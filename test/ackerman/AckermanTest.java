/*
    Licensed by Louis Vallat under the GNU General Public License v3.0
*/
package ackerman;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit tests
 * @author Louis Vallat
 */
public class AckermanTest {
    /**
     * Test of acker method, of class ackerman.
     */
    @Test
    public void testAcker() {
        System.out.println("acker");
        int m = 2;
        int n = 2;
        int expResult = 7;
        int result = ackerman.acker(m, n);
        assertEquals(expResult, result);
    }
    
}
