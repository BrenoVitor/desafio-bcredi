package br.com.bcredi.model.impl;

import java.math.BigDecimal;

import br.com.bcredi.model.Proponent;
import br.com.bcredi.util.BigDecimalCompareUtil;

public class ProponentImpl implements Proponent {

	private static final long serialVersionUID = 1L;

	private final String proponentId;

	private final String proponentName;

	private final int proponentAge;

	private final BigDecimal proponentMonthlyIncome;

	private final boolean proponentIsMain;

	public ProponentImpl(String proponentId, String proponentName, int proponentAge, BigDecimal proponentMonthlyIncome,
			boolean proponentIsMain) {
		this.proponentId = proponentId;
		this.proponentName = proponentName;
		this.proponentAge = proponentAge;
		this.proponentMonthlyIncome = proponentMonthlyIncome;
		this.proponentIsMain = proponentIsMain;
	}

	@Override
	public boolean isProponentIsMain() {
		return proponentIsMain;
	}

	@Override
	public boolean isOlderThan(int age) {
		return getProponentAge() >= age;
	}

	@Override
	public boolean isYoungerThan(int age) {
		return getProponentAge() <= age;
	}

	@Override
	public int getProponentAge() {
		return proponentAge;
	}

	@Override
	public boolean isProponentAgeBetween(int minimumAge, int maximumAge) {
		return isOlderThan(minimumAge) && isYoungerThan(maximumAge);
	}

	@Override
	public BigDecimal getProponentMonthlyIncome() {
		return proponentMonthlyIncome;
	}

	@Override
	public boolean isProponentMonthlyIncomeMoreThan(BigDecimal value) {
		return proponentMonthlyIncome.compareTo(value) >= BigDecimalCompareUtil.EQUALITY_SYMBOL.getValue();
	}

	@Override
	public String getProponentId() {
		return proponentId;
	}

	@Override
	public String getProponentName() {
		return proponentName;
	}

	@Override
	public String toString() {
		return "ProponentImpl [proponentId=" + proponentId + ", proponentName=" + proponentName + ", proponentAge="
				+ proponentAge + ", proponentMonthlyIncome=" + proponentMonthlyIncome + ", proponentIsMain="
				+ proponentIsMain + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + proponentAge;
		result = prime * result + ((proponentId == null) ? 0 : proponentId.hashCode());
		result = prime * result + (proponentIsMain ? 1231 : 1237);
		result = prime * result + ((proponentMonthlyIncome == null) ? 0 : proponentMonthlyIncome.hashCode());
		result = prime * result + ((proponentName == null) ? 0 : proponentName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProponentImpl other = (ProponentImpl) obj;
		if (proponentAge != other.proponentAge)
			return false;
		if (proponentId == null) {
			if (other.proponentId != null)
				return false;
		} else if (!proponentId.equals(other.proponentId))
			return false;
		if (proponentIsMain != other.proponentIsMain)
			return false;
		if (proponentMonthlyIncome == null) {
			if (other.proponentMonthlyIncome != null)
				return false;
		} else if (!proponentMonthlyIncome.equals(other.proponentMonthlyIncome))
			return false;
		if (proponentName == null) {
			if (other.proponentName != null)
				return false;
		} else if (!proponentName.equals(other.proponentName))
			return false;
		return true;
	}

}
