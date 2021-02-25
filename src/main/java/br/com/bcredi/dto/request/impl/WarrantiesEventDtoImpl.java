package br.com.bcredi.dto.request.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import br.com.bcredi.dto.request.WarrantiesEventDto;
import br.com.bcredi.dto.request.WarrantyEventDto;

public class WarrantiesEventDtoImpl implements WarrantiesEventDto {

	private static final long serialVersionUID = -8793153810155013506L;

	private final Collection<WarrantyEventDto> warrantiesEventDto;

	public WarrantiesEventDtoImpl() {
		this.warrantiesEventDto = new HashSet<>();
	}

	@Override
	public void addWarrantyEventDto(WarrantyEventDto warrantyEventDto) {
		this.warrantiesEventDto.add(warrantyEventDto);
	}

	@Override
	public void addAllWarrantiesEventDto(Collection<WarrantyEventDto> warrantiesEventDto) {
		this.warrantiesEventDto.addAll(warrantiesEventDto);
	}

	@Override
	public Iterator<WarrantyEventDto> iterator() {
		return warrantiesEventDto.iterator();
	}

}
