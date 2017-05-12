package shanshan.spring.boot.common.constant;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class NumberConstant {
	
	/**BigDecimal 正常都保留两位小数 **/
	public static final int DEFAULT_SCALE = 2;
	
	/**利率/10000 **/
	public static final int DEFAULT_RATESCALE = 10000;
	
	public static final BigDecimal ZERO = new BigDecimal(BigInteger.ZERO, DEFAULT_SCALE, MathContext.DECIMAL64);
	
	/** 四舍五入方式  银行家算法 **/
	public static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;
}
