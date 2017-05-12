package shanshan.spring.boot.common.enums;

/**
 * 还款方式
 * @author zss
 * @date 2017年4月24日
 */
public enum RepaymentMethod implements BaseEnum{
	
	MonthlyInterest("按月付息到期还本", "还款压力小"),
    EqualInstallment("按月等额本息", "还款便捷"),
    EqualPrincipal("按月等额本金", "总利息最低"),
    BulletRepayment("一次性还本付息", "短期首选"),
    SeasonInterest("按季付息到期还本", "到期还本"),
    HalfYearInterest("每半年付息", "到期还本");

    private final String key;

    private final String desc;
    
    private RepaymentMethod(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

	@Override
	public String getKey() {
		return key;
	}
	 
	public String getDesc() {
        return desc;
    }
}
