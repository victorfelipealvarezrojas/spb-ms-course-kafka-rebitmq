package org.lerning.employeeservice.adapter.mapper;


import org.lerning.employeeservice.dto.EmployeeDto;
import org.lerning.employeeservice.entity.Employee;

public interface EmployeeDtoToEmployeeMapper {
    Employee map(EmployeeDto employeeDto);
}
