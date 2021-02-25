package br.com.bcredi.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;

public interface ProponentEventDto extends Serializable {

	String getProponentId();

	String getProponentName();

	void setProponentName(String proponentName);

	int getProponentAge();

	void setProponentAge(int proponentAge);

	BigDecimal getProponentMonthlyIncome();

	void setProponentMonthlyIncome(BigDecimal proponentMonthlyIncome);

	boolean isProponentIsMain();

	void setProponentIsMain(boolean proponentIsMain);

	EventDto getEvent();

}