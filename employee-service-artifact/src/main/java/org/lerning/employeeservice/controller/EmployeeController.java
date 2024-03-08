package org.lerning.employeeservice.controller;

import lombok.AllArgsConstructor;
import org.lerning.employeeservice.dto.APIResponseDto;
import org.lerning.employeeservice.dto.EmployeeDto;
import org.lerning.employeeservice.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveDepartment(@RequestBody EmployeeDto dto){
        var result = employeeService.saveEmployee(dto);
        return new ResponseEntity<>(result, CREATED);
    }

    @GetMapping("email/{email}")
    public ResponseEntity<EmployeeDto> getDepartmentWithCode(@PathVariable("email") String email){
        return new ResponseEntity<>(employeeService.getDEmployeeByEmail(email), OK);
    }


    @GetMapping("{employeeId}")
    public ResponseEntity<APIResponseDto> getDepartmentWithCode(@PathVariable("employeeId") Long employeeId){
        return new ResponseEntity<>(employeeService.getDEmployeeById(employeeId), OK);
    }

}
