package br.com.bcredi.dto.request;

import java.io.Serializable;
import java.util.Collection;

public interface WarrantiesEventDto extends Iterable<WarrantyEventDto>, Serializable {

	void addWarrantyEventDto(WarrantyEventDto warrantyEventDto);

	void addAllWarrantiesEventDto(Collection<WarrantyEventDto> warrantiesEventDto);

}