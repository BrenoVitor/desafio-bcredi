package br.com.bcredi.dto.request.impl;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.bcredi.dto.request.EventDto;
import br.com.bcredi.dto.request.ProponentEventDto;

public class ProponentEventDtoImpl implements Serializable, ProponentEventDto {

	private static final long serialVersionUID = 7914742528433487368L;

	private final String proponentId;

	private final EventDto event;

	private String proponentName;

	private int proponentAge;

	private BigDecimal proponentMonthlyIncome;

	private boolean proponentIsMain;

	public ProponentEventDtoImpl(String proponentId, EventDto event, String proponentName, int proponentAge,
			BigDecimal proponentMonthlyIncome, boolean proponentIsMain) {
		this(proponentId, event);
		this.proponentName = proponentName;
		this.proponentAge = proponentAge;
		this.proponentMonthlyIncome = proponentMonthlyIncome;
		this.proponentIsMain = proponentIsMain;
	}

	public ProponentEventDtoImpl(String proponentId, EventDto event) {
		this.proponentId = proponentId;
		this.event = event;
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
	public void setProponentName(String proponentName) {
		this.proponentName = proponentName;
	}

	@Override
	public int getProponentAge() {
		return proponentAge;
	}

	@Override
	public void setProponentAge(int proponentAge) {
		this.proponentAge = proponentAge;
	}

	@Override
	public BigDecimal getProponentMonthlyIncome() {
		return proponentMonthlyIncome;
	}

	@Override
	public void setProponentMonthlyIncome(BigDecimal proponentMonthlyIncome) {
		this.proponentMonthlyIncome = proponentMonthlyIncome;
	}

	@Override
	public boolean isProponentIsMain() {
		return proponentIsMain;
	}

	@Override
	public void setProponentIsMain(boolean proponentIsMain) {
		this.proponentIsMain = proponentIsMain;
	}

	@Override
	public EventDto getEvent() {
		return event;
	}

	@Override
	public String toString() {
		return "ProponentEventDto [proponentId=" + proponentId + ", event=" + event + ", proponentName=" + proponentName
				+ ", proponentAge=" + proponentAge + ", proponentMonthlyIncome=" + proponentMonthlyIncome
				+ ", proponentIsMain=" + proponentIsMain + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((event == null) ? 0 : event.hashCode());
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
		ProponentEventDtoImpl other = (ProponentEventDtoImpl) obj;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
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
