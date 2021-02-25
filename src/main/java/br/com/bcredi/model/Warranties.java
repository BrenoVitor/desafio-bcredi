package br.com.bcredi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

public interface Warranties extends Iterable<Warranty>, Serializable {

	void addWarranty(Warranty warranty);

	void removeWarranty(Warranty warranty);

	boolean isMinimumQuantityOfWarranties(int minimumQuantity);

	boolean isSumOfWarrantiesMoreThanProjectsProposalLoanValue(BigDecimal projectsProposalLoanValue);

	boolean isWarrantiesProvinceNotIn(Collection<WarrantyProvince> notAcceptedWarrantyProvinces);

}