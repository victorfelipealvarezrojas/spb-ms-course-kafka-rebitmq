package org.lerning.employeeservice.adapter.output;

import org.lerning.employeeservice.adapter.mapper.EmployeeToEmployeeDtoMapper;
import org.lerning.employeeservice.dto.EmployeeDto;
import org.lerning.employeeservice.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeToEmployeeDtoMapperImpl implements EmployeeToEmployeeDtoMapper {
    @Override
    public EmployeeDto map(Employee employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .departmentCode(employee.getDepartmentCode())
                .build();
    }
}
