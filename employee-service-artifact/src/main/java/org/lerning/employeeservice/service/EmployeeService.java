package org.lerning.employeeservice.service;

import org.lerning.employeeservice.dto.APIResponseDto;
import org.lerning.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getDEmployeeByEmail(String email);

    APIResponseDto getDEmployeeById(Long employeeId);
}
