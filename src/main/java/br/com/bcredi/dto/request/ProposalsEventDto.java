package br.com.bcredi.dto.request;

import java.io.Serializable;

public interface ProposalsEventDto extends Iterable<String>, Serializable {

	ProposalEventDto getProposalEventDto(String proposalId);

	ProposalEventDto setProposalEventDto(ProposalEventDto proposalEventDto);

}