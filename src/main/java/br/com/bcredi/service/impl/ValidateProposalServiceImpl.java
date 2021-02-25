package br.com.bcredi.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import br.com.bcredi.dto.request.ProposalEventDto;
import br.com.bcredi.dto.request.ProposalsEventDto;
import br.com.bcredi.model.Proposal;
import br.com.bcredi.model.impl.ProponentImpl;
import br.com.bcredi.model.impl.ProposalImpl;
import br.com.bcredi.model.impl.WarrantyImpl;
import br.com.bcredi.service.ValidateProposalService;
import br.com.bcredi.validator.Validator;

public class ValidateProposalServiceImpl implements ValidateProposalService {

	private static final long serialVersionUID = 757764774766038547L;

	private final Validator validator;

	public ValidateProposalServiceImpl(Validator validator) {
		this.validator = validator;
	}

	public String validate(ProposalsEventDto proposalsEventDto) {
		Collection<Proposal> proposals = new ArrayList<>();
		proposalsEventDto.forEach(proposalId -> {
			ProposalEventDto proposalEventDto = proposalsEventDto.getProposalEventDto(proposalId);
			Proposal proposal = new ProposalImpl(proposalEventDto.getProposalId(),
					proposalEventDto.getProposalLoanValue(), proposalEventDto.getProposalNumberOfMonthlyInstallments());
			proposalEventDto.getWarrantiesEventDto().forEach(warrantyEventDto -> {
				proposal.addWarranty(new WarrantyImpl(warrantyEventDto.getWarrantyId(),
						warrantyEventDto.getWarrantyValue(), warrantyEventDto.getWarrantyProvince()));
			});
			proposalEventDto.getProponentsEventDto().forEach(proponentEventDto -> {
				proposal.addProponent(new ProponentImpl(proponentEventDto.getProponentId(),
						proponentEventDto.getProponentName(), proponentEventDto.getProponentAge(),
						proponentEventDto.getProponentMonthlyIncome(), proponentEventDto.isProponentIsMain()));
			});
			proposals.add(proposal);
		});
		System.out.println(proposals.size());
		Collection<String> idValidos = new ArrayList<>();
		proposals.forEach(proposal -> {
			System.out.println(proposal.getProposalId());
			validator.validate(proposal);
			if (!validator.hasErros()) {
				idValidos.add(proposal.getProposalId());
			} else {
				validator.getErros().forEach(error -> {
					System.out.println(error.getMessage());
				});
			}
		});
		return idValidos.toString();
	}

	@Override
	public String toString() {
		return "ValidateProposalServiceImpl [validator=" + validator + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((validator == null) ? 0 : validator.hashCode());
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
		ValidateProposalServiceImpl other = (ValidateProposalServiceImpl) obj;
		if (validator == null) {
			if (other.validator != null)
				return false;
		} else if (!validator.equals(other.validator))
			return false;
		return true;
	}

}
