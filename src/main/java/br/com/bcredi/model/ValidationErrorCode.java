package br.com.bcredi.model;

public enum ValidationErrorCode {

	LOAN_AMOUNT(1L), NUMBER_OF_MONTHLY_INSTALLMENTS(2L), COUNT_OF_PROPONENTS(3L), COUNT_OF_MAIN_PROPONENTS(4L),
	PROPONENTS_AGE(5L), MINIMUM_OF_WARRANTIES(6L), SUM_OF_WARRANTIES_VALUES(7L), WARRANTIES_PROVINCE_ACCEPTED(8L),
	PROPONENTS_MONTHLY_INCOME(9L);

	private final long code;

	ValidationErrorCode(Long code) {
		this.code = code;
	}

	public long getCode() {
		return code;
	}

}
