package com.example.demo_spring.demo9.service;

import com.example.demo_spring.demo9.entity.Employee;
import com.example.demo_spring.demo9.feignclient.AddressClient;
import com.example.demo_spring.demo9.repository.EmployeeRepo;
import com.example.demo_spring.demo9.response.AddressResponse;
import com.example.demo_spring.demo9.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private AddressClient addressClient;

    public EmployeeResponse getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);

        // Using FeignClient: Append an address response to employee response
        ResponseEntity<AddressResponse> addressResponse = addressClient.getAddressByEmployeeId(id);
        employeeResponse.setAddressResponse(addressResponse.getBody());
        return employeeResponse;
    }
}
