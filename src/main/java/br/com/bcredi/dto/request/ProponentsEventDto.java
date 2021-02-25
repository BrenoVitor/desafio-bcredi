package br.com.bcredi.dto.request;

import java.io.Serializable;
import java.util.Collection;

public interface ProponentsEventDto extends Iterable<ProponentEventDto>, Serializable {

	void addProponentEventDto(ProponentEventDto proponentEventDto);

	void addAllProponentsEventDto(Collection<ProponentEventDto> proponentsEventDto);

}