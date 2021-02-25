package br.com.bcredi.dto.request.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import br.com.bcredi.dto.request.ProponentEventDto;
import br.com.bcredi.dto.request.ProponentsEventDto;

public class ProponentsEventDtoImpl implements ProponentsEventDto {

	private static final long serialVersionUID = 1737579921986561880L;

	private final Collection<ProponentEventDto> proponentsEventDto;

	public ProponentsEventDtoImpl() {
		this.proponentsEventDto = new HashSet<>();
	}

	@Override
	public void addProponentEventDto(ProponentEventDto proponentEventDto) {
		this.proponentsEventDto.add(proponentEventDto);
	}

	@Override
	public void addAllProponentsEventDto(Collection<ProponentEventDto> proponentsEventDto) {
		this.proponentsEventDto.addAll(proponentsEventDto);
	}

	@Override
	public Iterator<ProponentEventDto> iterator() {
		return proponentsEventDto.iterator();
	}

}
