package com.example.springexample.xmlautowired;

import org.springframework.beans.factory.annotation.Autowired;

public class FooService {

	@Autowired
	CurrencyService currencyServiceBean;
	
	public void method(){
		currencyServiceBean.convert(10.0);
	}

	public CurrencyService getCurrencyServiceBean() {
		return currencyServiceBean;
	}

	public void setCurrencyServiceBean(CurrencyService currencyServiceBean) {
		this.currencyServiceBean = currencyServiceBean;
	}
	
	
}
