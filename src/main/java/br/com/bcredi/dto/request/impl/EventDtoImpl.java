package br.com.bcredi.dto.request.impl;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.bcredi.dto.request.EventDto;
import br.com.bcredi.model.EventAction;
import br.com.bcredi.model.EventSchema;

public class EventDtoImpl implements Serializable, EventDto {

	private static final long serialVersionUID = 941319589233367221L;

	private final String eventId;

	private final EventSchema eventSchema;

	private final EventAction eventAction;

	private final LocalDateTime eventTimestamp;

	public EventDtoImpl(String eventId, EventSchema eventSchema, EventAction eventAction, LocalDateTime eventTimestamp) {
		this.eventId = eventId;
		this.eventSchema = eventSchema;
		this.eventAction = eventAction;
		this.eventTimestamp = eventTimestamp;
	}

	@Override
	public EventAction getEventAction() {
		return eventAction;
	}

	@Override
	public EventSchema getEventSchema() {
		return eventSchema;
	}

	@Override
	public String getEventId() {
		return eventId;
	}

	@Override
	public LocalDateTime getEventTimestamp() {
		return eventTimestamp;
	}

	@Override
	public String toString() {
		return "EventDto [eventId=" + eventId + ", eventSchema=" + eventSchema + ", eventAction=" + eventAction
				+ ", eventTimestamp=" + eventTimestamp + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventAction == null) ? 0 : eventAction.hashCode());
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result + ((eventSchema == null) ? 0 : eventSchema.hashCode());
		result = prime * result + ((eventTimestamp == null) ? 0 : eventTimestamp.hashCode());
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
		EventDtoImpl other = (EventDtoImpl) obj;
		if (eventAction != other.eventAction)
			return false;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (eventSchema != other.eventSchema)
			return false;
		if (eventTimestamp == null) {
			if (other.eventTimestamp != null)
				return false;
		} else if (!eventTimestamp.equals(other.eventTimestamp))
			return false;
		return true;
	}

}
