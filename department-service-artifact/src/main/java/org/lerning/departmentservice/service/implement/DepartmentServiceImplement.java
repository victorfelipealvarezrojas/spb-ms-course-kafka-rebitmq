package org.lerning.departmentservice.service.implement;

import lombok.AllArgsConstructor;
import org.lerning.departmentservice.adapter.mapper.DepartmentDtoToDepartmentMapper;
import org.lerning.departmentservice.adapter.mapper.DepartmentToDepartmentDtoMapper;
import org.lerning.departmentservice.dto.DepartmentDto;
import org.lerning.departmentservice.entity.Department;
import org.lerning.departmentservice.exception.ResourceNotFoundException;
import org.lerning.departmentservice.repository.DepartmentRepository;
import org.lerning.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DepartmentServiceImplement  implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentDtoToDepartmentMapper dtoToEntityMapper;
    private final DepartmentToDepartmentDtoMapper entityToDtoMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department newDepartment = dtoToEntityMapper.map(departmentDto);
        Department saveNewDepartment = departmentRepository.save(newDepartment);
        return entityToDtoMapper.map(saveNewDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        return departmentRepository.findByDepartmentCode(code)
                .map(entityToDtoMapper::map)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "code", code));
    }
}