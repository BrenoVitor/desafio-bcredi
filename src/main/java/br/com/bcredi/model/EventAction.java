package br.com.bcredi.model;

public enum EventAction {

	PROPOSAL_CREATED("proposal.created"),
	PROPOSAL_UPDATED("proposal.updated"),
	PROPOSAL_DELETED("proposal.deleted"),
	WARRANTY_ADDED("warranty.added"),
	WARRANTY_UPDATED("warranty.updated"),
	WARRANTY_REMOVED("warranty.removed"),
	PROPONENT_ADDED("proponent.added"),
	PROPONENT_UPDATED("proponent.updated"),
	PROPONENT_REMOVED("proponent.removed");

	private final String value;

	private EventAction(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public static EventAction valueOfAction(String value) {
		EventAction[] values = EventAction.values();
		for (int i = 0; i < values.length; i++) {
			if(values[i].getValue().equalsIgnoreCase(value)) {
				return values[i];
			}
		}
		return null;
	}

}
