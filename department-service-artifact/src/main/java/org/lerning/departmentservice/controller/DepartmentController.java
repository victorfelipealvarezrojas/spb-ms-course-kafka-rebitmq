package org.lerning.departmentservice.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.lerning.departmentservice.dto.DepartmentDto;
import org.lerning.departmentservice.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@Valid @RequestBody DepartmentDto dto){
        var result = departmentService.saveDepartment(dto);
        return new ResponseEntity<>(result, CREATED);
    }

    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentWithCode(@PathVariable("department-code") String code){
        return new ResponseEntity<>(departmentService.getDepartmentByCode(code), OK);
    }
}
