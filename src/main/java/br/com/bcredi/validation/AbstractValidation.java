package br.com.bcredi.validation;

import br.com.bcredi.dto.request.ErrorDto;

public abstract class AbstractValidation implements Validation {

	private static final long serialVersionUID = 6224869286487424374L;

	protected ErrorDto errorDto;

	@Override
	public boolean hasError() {
		return errorDto != null;
	}

	@Override
	public ErrorDto getError() {
		return errorDto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((errorDto == null) ? 0 : errorDto.hashCode());
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
		AbstractValidation other = (AbstractValidation) obj;
		if (errorDto == null) {
			if (other.errorDto != null)
				return false;
		} else if (!errorDto.equals(other.errorDto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AbstractValidation [errorDto=" + errorDto + "]";
	}

}
