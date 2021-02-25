package br.com.bcredi.service;

import java.io.Serializable;

import br.com.bcredi.dto.request.ProposalsEventDto;

public interface ValidateProposalService extends Serializable {

	String validate(ProposalsEventDto proposalsEventDto);
}
