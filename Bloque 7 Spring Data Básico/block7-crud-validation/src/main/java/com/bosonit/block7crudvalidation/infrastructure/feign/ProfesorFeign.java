package com.bosonit.block7crudvalidation.infrastructure.feign;

import com.bosonit.block7crudvalidation.infrastructure.controller.dto.output.ProfOutputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://localhost:8081/", name = "professorFeign")

public interface ProfesorFeign {
    @GetMapping("profesores/{id}")
    ProfOutputDto getById(@PathVariable int id,
                          @RequestParam (value = "ouputType", defaultValue = "simple") String ouputType);

}
