package br.com.bcredi.dto.request.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import br.com.bcredi.dto.request.ProposalEventDto;
import br.com.bcredi.dto.request.ProposalsEventDto;

public class ProposalsEventDtoImpl implements ProposalsEventDto {

	private static final long serialVersionUID = -371933045471529359L;

	private final Map<String, ProposalEventDto> proposalsEventDtoMap;

	public ProposalsEventDtoImpl() {
		this.proposalsEventDtoMap = new LinkedHashMap<>();
	}

	@Override
	public ProposalEventDto getProposalEventDto(String proposalId) {
		return proposalsEventDtoMap.get(proposalId);
	}

	@Override
	public ProposalEventDto setProposalEventDto(ProposalEventDto proposalEventDto) {
		return proposalsEventDtoMap.put(proposalEventDto.getProposalId(), proposalEventDto);
	}

	@Override
	public Iterator<String> iterator() {
		return proposalsEventDtoMap.keySet().iterator();
	}

	@Override
	public String toString() {
		return "ProposalsEventDto [proposalsEventDtoMap=" + proposalsEventDtoMap + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((proposalsEventDtoMap == null) ? 0 : proposalsEventDtoMap.hashCode());
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
		ProposalsEventDtoImpl other = (ProposalsEventDtoImpl) obj;
		if (proposalsEventDtoMap == null) {
			if (other.proposalsEventDtoMap != null)
				return false;
		} else if (!proposalsEventDtoMap.equals(other.proposalsEventDtoMap))
			return false;
		return true;
	}

}
