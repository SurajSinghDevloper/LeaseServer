package gov.municipal.suda.service;

import java.util.Optional;

import gov.municipal.suda.model.ConsumerAllDropDownBean;

public interface ConsumerAllDropDownService {

	Optional<ConsumerAllDropDownBean> findAllDropDown();

}
