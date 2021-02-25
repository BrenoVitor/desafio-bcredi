package br.com.bcredi.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;

public interface ProposalEventDto extends Serializable {

	void addWarrantyEventDto(WarrantyEventDto warrantyEventDto);

	void addWarrantyEventDto(WarrantiesEventDto warrantiesEventDto);

	void addProponentEventDto(ProponentEventDto proponentEventDto);

	void addProponentEventDto(ProponentsEventDto proponentsEventDto);

	String getProposalId();

	WarrantiesEventDto getWarrantiesEventDto();

	ProponentsEventDto getProponentsEventDto();

	BigDecimal getProposalLoanValue();

	void setProposalLoanValue(BigDecimal proposalLoanValue);

	int getProposalNumberOfMonthlyInstallments();

	void setProposalNumberOfMonthlyInstallments(int proposalNumberOfMonthlyInstallments);

	EventDto getEvent();

	void setEvent(EventDto event);

}