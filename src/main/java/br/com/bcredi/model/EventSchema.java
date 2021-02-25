package br.com.bcredi.model;

public enum EventSchema {

	PROPOSAL("proposal"), WARRANTY("warranty"), PROPONENT("proponent");

	private final String value;

	private EventSchema(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public static EventSchema valueOfSchema(String value) {
		EventSchema[] values = EventSchema.values();
		for (int i = 0; i < values.length; i++) {
			if(values[i].getValue().equalsIgnoreCase(value)) {
				return values[i];
			}
		}
		return null;
	}

}
