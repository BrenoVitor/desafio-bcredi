package br.com.bcredi.dto.request.impl;

import java.math.BigDecimal;

import br.com.bcredi.dto.request.EventDto;
import br.com.bcredi.dto.request.ProponentEventDto;
import br.com.bcredi.dto.request.ProponentsEventDto;
import br.com.bcredi.dto.request.ProposalEventDto;
import br.com.bcredi.dto.request.WarrantiesEventDto;
import br.com.bcredi.dto.request.WarrantyEventDto;

public class ProposalEventDtoImpl implements ProposalEventDto {

	private static final long serialVersionUID = 6920363427012474279L;

	private EventDto event;

	private final String proposalId;

	private WarrantiesEventDto warrantiesEventDto;

	private ProponentsEventDto proponentsEventDto;

	private BigDecimal proposalLoanValue;

	private int proposalNumberOfMonthlyInstallments;

	public ProposalEventDtoImpl(EventDto event, String proposalId, BigDecimal proposalLoanValue,
			int proposalNumberOfMonthlyInstallments) {
		this(proposalId);
		this.proposalLoanValue = proposalLoanValue;
		this.proposalNumberOfMonthlyInstallments = proposalNumberOfMonthlyInstallments;
		this.event = event;
	}

	public ProposalEventDtoImpl(String proposalId) {
		this.warrantiesEventDto = new WarrantiesEventDtoImpl();
		this.proponentsEventDto = new ProponentsEventDtoImpl();
		this.proposalId = proposalId;
	}

	@Override
	public void addWarrantyEventDto(WarrantyEventDto warrantyEventDto) {
		this.warrantiesEventDto.addWarrantyEventDto(warrantyEventDto);
	}

	@Override
	public void addWarrantyEventDto(WarrantiesEventDto warrantiesEventDto) {
		this.warrantiesEventDto = warrantiesEventDto;
	}

	@Override
	public void addProponentEventDto(ProponentEventDto proponentEventDto) {
		this.proponentsEventDto.addProponentEventDto(proponentEventDto);
	}

	@Override
	public void addProponentEventDto(ProponentsEventDto proponentsEventDto) {
		this.proponentsEventDto = proponentsEventDto;
	}

	@Override
	public String getProposalId() {
		return proposalId;
	}

	@Override
	public WarrantiesEventDto getWarrantiesEventDto() {
		return warrantiesEventDto;
	}

	@Override
	public ProponentsEventDto getProponentsEventDto() {
		return proponentsEventDto;
	}

	@Override
	public BigDecimal getProposalLoanValue() {
		return proposalLoanValue;
	}

	@Override
	public void setProposalLoanValue(BigDecimal proposalLoanValue) {
		this.proposalLoanValue = proposalLoanValue;
	}

	@Override
	public int getProposalNumberOfMonthlyInstallments() {
		return proposalNumberOfMonthlyInstallments;
	}

	@Override
	public void setProposalNumberOfMonthlyInstallments(int proposalNumberOfMonthlyInstallments) {
		this.proposalNumberOfMonthlyInstallments = proposalNumberOfMonthlyInstallments;
	}

	@Override
	public EventDto getEvent() {
		return event;
	}

	@Override
	public void setEvent(EventDto event) {
		this.event = event;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + ((proponentsEventDto == null) ? 0 : proponentsEventDto.hashCode());
		result = prime * result + ((proposalId == null) ? 0 : proposalId.hashCode());
		result = prime * result + ((proposalLoanValue == null) ? 0 : proposalLoanValue.hashCode());
		result = prime * result + proposalNumberOfMonthlyInstallments;
		result = prime * result + ((warrantiesEventDto == null) ? 0 : warrantiesEventDto.hashCode());
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
		ProposalEventDtoImpl other = (ProposalEventDtoImpl) obj;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (proponentsEventDto == null) {
			if (other.proponentsEventDto != null)
				return false;
		} else if (!proponentsEventDto.equals(other.proponentsEventDto))
			return false;
		if (proposalId == null) {
			if (other.proposalId != null)
				return false;
		} else if (!proposalId.equals(other.proposalId))
			return false;
		if (proposalLoanValue == null) {
			if (other.proposalLoanValue != null)
				return false;
		} else if (!proposalLoanValue.equals(other.proposalLoanValue))
			return false;
		if (proposalNumberOfMonthlyInstallments != other.proposalNumberOfMonthlyInstallments)
			return false;
		if (warrantiesEventDto == null) {
			if (other.warrantiesEventDto != null)
				return false;
		} else if (!warrantiesEventDto.equals(other.warrantiesEventDto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProposalEventDtoImpl [event=" + event + ", proposalId=" + proposalId + ", warrantiesEventDto="
				+ warrantiesEventDto + ", proponentsEventDto=" + proponentsEventDto + ", proposalLoanValue="
				+ proposalLoanValue + ", proposalNumberOfMonthlyInstallments=" + proposalNumberOfMonthlyInstallments
				+ "]";
	}

}
