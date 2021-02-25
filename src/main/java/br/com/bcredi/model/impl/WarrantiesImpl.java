package br.com.bcredi.model.impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.stream.Stream;

import br.com.bcredi.model.Warranties;
import br.com.bcredi.model.Warranty;
import br.com.bcredi.model.WarrantyProvince;
import br.com.bcredi.util.BigDecimalCompareUtil;

public class WarrantiesImpl implements Warranties {

	private static final long serialVersionUID = 1L;

	private final Collection<Warranty> warranties;

	public WarrantiesImpl() {
		this.warranties = new HashSet<>();
	}

	@Override
	public Iterator<Warranty> iterator() {
		return warranties.iterator();
	}

	@Override
	public void addWarranty(Warranty warranty) {
		this.warranties.add(warranty);
	}

	@Override
	public void removeWarranty(Warranty warranty) {
		this.warranties.remove(warranty);
	}

	@Override
	public boolean isMinimumQuantityOfWarranties(int minimumQuantity) {
		return getQuantityOfWarranties() >= minimumQuantity;
	}

	@Override
	public boolean isSumOfWarrantiesMoreThanProjectsProposalLoanValue(BigDecimal projectsProposalLoanValue) {
		return getSumOfWarranties().compareTo(projectsProposalLoanValue) >= BigDecimalCompareUtil.EQUALITY_SYMBOL
				.getValue();

	}

	@Override
	public boolean isWarrantiesProvinceNotIn(Collection<WarrantyProvince> notAcceptedWarrantyProvinces) {
		return getWarrantiesStream()
				.noneMatch(warranty -> notAcceptedWarrantyProvinces.contains(warranty.getWarrantyProvince()));
	}

	private BigDecimal getSumOfWarranties() {
		return getWarrantiesStream().map(Warranty::getWarrantyValue).reduce(BigDecimal.ZERO,
				(actual, next) -> actual.add(next));
	}

	private Stream<Warranty> getWarrantiesStream() {
		return warranties.stream();
	}

	private int getQuantityOfWarranties() {
		return warranties.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((warranties == null) ? 0 : warranties.hashCode());
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
		WarrantiesImpl other = (WarrantiesImpl) obj;
		if (warranties == null) {
			if (other.warranties != null)
				return false;
		} else if (!warranties.equals(other.warranties))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WarrantiesImpl [warranties=" + warranties + "]";
	}

}
