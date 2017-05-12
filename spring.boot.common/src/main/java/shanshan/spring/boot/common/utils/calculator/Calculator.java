package shanshan.spring.boot.common.utils.calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import shanshan.spring.boot.common.constant.NumberConstant;
import shanshan.spring.boot.common.constant.TimeConstant;
import shanshan.spring.boot.common.enums.RepaymentMethod;
import shanshan.spring.boot.common.model.embedded.Duration;


public class Calculator {
	
	private static final BigDecimal ONE = new BigDecimal(1).setScale(2);
	
	private static final BigDecimal monthsPerYear = new BigDecimal(TimeConstant.MONTHS_PER_YEAR);

	private static final BigDecimal daysPerYear = new BigDecimal(TimeConstant.DAYS_PER_YEAR);

	private static final BigDecimal RATESCALE = new BigDecimal(NumberConstant.DEFAULT_RATESCALE);
	
	private static final MathContext mc = MathContext.DECIMAL64;
	
	private static final RoundingMode ROUNDING_MODE = NumberConstant.ROUNDING_MODE;
	
	public static BigDecimal quickInterest(int amount, int rate, Duration duration, RepaymentMethod method){
		// 本金
		BigDecimal principal = new BigDecimal(amount);
		// 年利率 月利率
		BigDecimal rateYear = new BigDecimal(rate).divide(RATESCALE, mc);
		BigDecimal rateMonth = rateYear.divide(monthsPerYear, mc);
		
		// 利息    分期利息   分期本金   剩余本金
		BigDecimal interest = NumberConstant.ZERO, amortizedInterest, amortizedPrincipal, outstandingPrincipal;
		
		int tenure = duration.getTotalMonths();
		
		switch (method) {
			case BulletRepayment:
				BigDecimal rateDay = rateYear.divide(daysPerYear, mc);
				
				// 按天计算总利息
				interest = principal.multiply(rateDay)
									.multiply(new BigDecimal(duration.getTotalDays()))
									.setScale(2, ROUNDING_MODE);
				break;
			case MonthlyInterest:
				amortizedInterest = principal.multiply(rateMonth).setScale(2, ROUNDING_MODE);
				interest = amortizedInterest.multiply(new BigDecimal(tenure));
				break;
			case EqualInstallment:
				// pre-calc
				BigDecimal[] is = new BigDecimal[tenure + 1];
				for (int i = 0; i <= tenure; i++) {
					is[i] = rateMonth.add(ONE).pow(i);
				}
				BigDecimal baseInterest = principal.multiply(rateMonth);
				// calc installment
				BigDecimal installment = baseInterest.multiply(is[tenure])
													 .divide(is[tenure].subtract(ONE), mc)
													 .setScale(2, ROUNDING_MODE);
				for (int i = 0; i < tenure; i++) {
					amortizedInterest = baseInterest.subtract(installment, mc)
													.multiply(is[i])
													.add(installment, mc)
													.setScale(2, ROUNDING_MODE);
					interest = interest.add(amortizedInterest);
				}
				break;
			case EqualPrincipal:
				// calc amortized principal first
				amortizedPrincipal = principal.divide(new BigDecimal(tenure), mc)
												.setScale(2,ROUNDING_MODE);
				// calc by each month
				BigDecimal[] interests = new BigDecimal[tenure];
				outstandingPrincipal = principal;
				for (int i = 0; i < tenure; i++) {
					interests[i] = outstandingPrincipal.multiply(rateMonth, mc)
														.setScale(2,ROUNDING_MODE);
					interest = interest.add(interests[i]);
					outstandingPrincipal = outstandingPrincipal.subtract(amortizedPrincipal);
				}
				break;
		}
		return interest;
	}
}
