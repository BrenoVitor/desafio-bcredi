package br.com.bcredi.dto.response.impl;

import br.com.bcredi.dto.response.ValidProposalDto;

public class ValidProposalDtoImpl implements ValidProposalDto {

	private static final long serialVersionUID = -1046965496005400155L;

	private final String proposalId;

	public ValidProposalDtoImpl(String proposalId) {
		this.proposalId = proposalId;
	}

	@Override
	public String getProposalId() {
		return proposalId;
	}

}
