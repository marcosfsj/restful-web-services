package com.marcos.rest.webservices.restfulwebservices.filtering;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		SomeBean someBean = new SomeBean("Value1", "Value2", "Value3");
		return buildFiltering(someBean, "prop1", "prop2");
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListOfSomeBean() {
		List<SomeBean> listOfSomeBean = new ArrayList<>();
		listOfSomeBean.add(new SomeBean("Value1", "Value2", "Value3"));
		listOfSomeBean.add(new SomeBean("Value1", "Value2", "Value3"));
		listOfSomeBean.add(new SomeBean("Value1", "Value2", "Value3"));
		return buildFiltering(listOfSomeBean, "prop2", "prop3");
	}
	
	private <T> MappingJacksonValue buildFiltering(T dataToBeFiltered, String... fields) {
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(dataToBeFiltered);
		mapping.setFilters(filters);
		return mapping;
	}
	
}
