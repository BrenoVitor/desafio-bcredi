package br.com.bcredi.dto.request.impl;

import java.io.Serializable;

import br.com.bcredi.dto.request.ErrorDto;

public class ErrorDtoImpl implements Serializable, ErrorDto {

	private static final long serialVersionUID = 4608440064477528209L;

	private final long code;

	private final String message;

	private final String field;

	public ErrorDtoImpl(long code, String message, String field) {
		this.code = code;
		this.message = message;
		this.field = field;
	}

	@Override
	public long getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public String getField() {
		return field;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (code ^ (code >>> 32));
		result = prime * result + ((field == null) ? 0 : field.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
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
		ErrorDtoImpl other = (ErrorDtoImpl) obj;
		if (code != other.code)
			return false;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ErrorDto [code=" + code + ", message=" + message + ", field=" + field + "]";
	}
}
