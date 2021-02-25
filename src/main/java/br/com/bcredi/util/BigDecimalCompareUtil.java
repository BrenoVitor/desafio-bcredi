package br.com.bcredi.util;

public enum BigDecimalCompareUtil {

	EQUALITY_SYMBOL(0);

	private final int value;

	BigDecimalCompareUtil(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
