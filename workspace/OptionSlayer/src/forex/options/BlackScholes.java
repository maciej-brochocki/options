package forex.options;

public class BlackScholes {
	/** The Black and Scholes (1973) Stock option formula
	 * @param CallPutFlag	Option type	 
	 * @param S		Stock price
	 * @param X 	Strike price of option
	 * @param T 	Time to expiration in years
	 * @param r 	Risk-free interest rate
	 * @param v 	Volatility
	 * @return option price
	 */
	static public double GetPrice(char CallPutFlag, double S, double X, double T, double r, double v)
	{
		double d1, d2;

		d1=(Math.log(S/X)+(r+v*v/2)*T)/(v*Math.sqrt(T));
		d2=d1-v*Math.sqrt(T);

		if (CallPutFlag=='c')
		{
			return S*CND(d1)-X*Math.exp(-r*T)*CND(d2);
		}
		else
		{
			return X*Math.exp(-r*T)*CND(-d2)-S*CND(-d1);
		}
	}

	/** The cumulative normal distribution function
	 * @param X		Argument
	 * @return		Result
	 */
	static public double CND(double X)
	{
		double L, K, w ;
		double a1 = 0.31938153, a2 = -0.356563782, a3 = 1.781477937, a4 = -1.821255978, a5 = 1.330274429;

		L = Math.abs(X);
		K = 1.0 / (1.0 + 0.2316419 * L);
		w = 1.0 - 1.0 / Math.sqrt(2.0 * Math.PI) * Math.exp(-L *L / 2) * (a1 * K + a2 * K *K + a3 
				* Math.pow(K,3) + a4 * Math.pow(K,4) + a5 * Math.pow(K,5));

		if (X < 0.0) 
		{
			w = 1.0 - w;
		}
		return w;
	 }
}
