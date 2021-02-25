package br.com.bcredi.dto.request;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.bcredi.model.EventAction;
import br.com.bcredi.model.EventSchema;

public interface EventDto extends Serializable {

	EventAction getEventAction();

	EventSchema getEventSchema();

	String getEventId();

	LocalDateTime getEventTimestamp();

}