import static org.junit.Assert.*;

import org.junit.Test;
import forex.options.*;


public class BlackScholesTest {

	@Test
	public void test() {
		 /*      Microsoft:   share price:             23.75
		 *                   strike price:            15.00
		 *                   time until expiration:    0.5 years
		 *                   risk-free interest rate:  1%
		 *                   volatility:              35%          (historical estimate) */
		 assertTrue(BlackScholes.GetPrice('c', 23.75, 15.00, 0.5, 0.01, 0.35) - 9.1 < 0.1);


		 /*       GE:         share price:             30.14
		 *                   strike price:            15.00
		 *                   time until expiration     0.25 years	}
		 *                   risk-free interest rate   1%
		 *                   volatility:              33.2%         (historical estimate) */
		 assertTrue(BlackScholes.GetPrice('c', 30.14, 15.00, 0.25, 0.01, 0.332) - 14.5 < 1);
	}
}