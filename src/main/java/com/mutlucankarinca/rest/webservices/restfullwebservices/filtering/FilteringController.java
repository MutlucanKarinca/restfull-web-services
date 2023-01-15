package com.mutlucankarinca.rest.webservices.restfullwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue retriveSomeBean(){
        SomeBean bean = new  SomeBean("value1","value2","value3");
        MappingJacksonValue mapping=new MappingJacksonValue(bean);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);

        mapping.setFilters(filters);
        return mapping;
    }
    @GetMapping("/filtering-list")
    public MappingJacksonValue retriveListSomeBean(){
        List<SomeBean> someBeans = Arrays.asList(new SomeBean("value1","value2","value3"),new SomeBean("value11","value22","value33"));

        MappingJacksonValue mapping=new MappingJacksonValue(someBeans);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);

        mapping.setFilters(filters);

        return mapping;
    }
}
