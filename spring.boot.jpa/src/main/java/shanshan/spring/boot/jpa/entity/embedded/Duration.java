package shanshan.spring.boot.jpa.entity.embedded;

import javax.persistence.Embeddable;

import shanshan.spring.boot.common.constant.TimeConstant;
import shanshan.spring.boot.jpa.entity.base.EntityBase;


@Embeddable
public class Duration extends EntityBase implements Comparable<Duration> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4249099551407156161L;

	private int years;

	private int months;

	private int days;
	
	public Duration() {
	}

	public Duration(int years, int months, int days) {
		this.years = years;
		this.months = months;
		this.days = days;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
	
	
	@Override
	public int compareTo(Duration o) {
		if (!(years == o.years)) {
			return years > o.years ? 1 : -1;
		}
		if (!(months == o.months)) {
			return months > o.months ? 1 : -1;
		}
		if (!(days == o.days)) {
			return days > o.days ? 1 : -1;
		}
		return 0;
	}

//	@Override
//	public int hashCode() {
//		return new HashCodeBuilder().append(years).append(months).append(days)
//				.toHashCode();
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (obj == null) {
//			return false;
//		}
//		if (getClass() != obj.getClass()) {
//			return false;
//		}
//		final Duration other = (Duration) obj;
//		if (this.years != other.years) {
//			return false;
//		}
//		if (this.months != other.months) {
//			return false;
//		}
//		if (this.days != other.days) {
//			return false;
//		}
//		return true;
//	}
	
	public int getTotalMonths() {
		return years * TimeConstant.MONTHS_PER_YEAR + months;
	}
	
	public int getTotalDays() {
		return getTotalMonths() * TimeConstant.DAYS_PER_MONTH + days;
	}
	
	@Override
	public String toString() {
		String text = "";
		if (years > 0) {
			return text += years + "年";
		}
		if (months > 0) {
			return text += months + "个月";
		}
		if (days > 0) {
			if (years > 0 || months > 0) {
				text += "零";
			}
			return text += days + "天";
		}
		
		return super.toString();
	}
	
}
