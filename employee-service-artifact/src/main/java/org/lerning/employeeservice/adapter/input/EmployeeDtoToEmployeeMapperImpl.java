package org.lerning.employeeservice.adapter.input;

import org.lerning.employeeservice.adapter.mapper.EmployeeDtoToEmployeeMapper;
import org.lerning.employeeservice.dto.EmployeeDto;
import org.lerning.employeeservice.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDtoToEmployeeMapperImpl implements EmployeeDtoToEmployeeMapper {
    @Override
    public Employee map(EmployeeDto employeeDto) {
        return Employee.builder()
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .email(employeeDto.getEmail())
                .departmentCode(employeeDto.getDepartmentCode())
                .build();
    }
}
