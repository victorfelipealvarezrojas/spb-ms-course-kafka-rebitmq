package org.lerning.employeeservice.service.Implements;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.lerning.employeeservice.adapter.mapper.EmployeeDtoToEmployeeMapper;
import org.lerning.employeeservice.adapter.mapper.EmployeeToEmployeeDtoMapper;
import org.lerning.employeeservice.dto.APIResponseDto;
import org.lerning.employeeservice.dto.DepartmentDto;
import org.lerning.employeeservice.dto.EmployeeDto;
import org.lerning.employeeservice.entity.Employee;
import org.lerning.employeeservice.repository.ApiFeignRepository;
import org.lerning.employeeservice.repository.EmployeeRepository;
import org.lerning.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class EmployeeServiceImplement implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeDtoToEmployeeMapper dtoToEntityMapper;
    private final EmployeeToEmployeeDtoMapper entityToDtoMapper;
    private final ApiFeignRepository apiClient;

    // private final static String URL_API = "DEPARTMENT-SERVICE";

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = dtoToEntityMapper.map(employeeDto);
        Employee NewEmployee = employeeRepository.save(employee);
        return entityToDtoMapper.map(NewEmployee);
    }

    @Override
    public EmployeeDto getDEmployeeByEmail(String email) {
        Employee department = employeeRepository.findByEmail(email);
        return entityToDtoMapper.map(department);
    }

    // implementa el patron Circuit Breaker (patron disyuntor)
    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getDEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new NoSuchElementException("No employee found with id: " + employeeId));

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("Research and Development Department");


        return new APIResponseDto(
                entityToDtoMapper.map(employee),
                departmentDto
        );
    }

    public APIResponseDto getDefaultDepartment(Long employeeId, Exception exception) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new NoSuchElementException("No employee found with id: " + employeeId));

        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        return new APIResponseDto(
                entityToDtoMapper.map(employee),
                departmentDto
        );
    }
}