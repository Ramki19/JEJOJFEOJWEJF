package com.example.Approvel.Service;

import com.example.Approvel.Dto.Dto;
import com.example.Approvel.Dto.Responsedto;
import com.example.Approvel.Model.Employee;
import com.example.Approvel.Model.LeaveRequest;
import com.example.Approvel.Model.Role;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Servicebussiness {
    void addemployee(Dto dto);

    //    void tlapprove(Long id);
//
//    void managerapprove(Long id);
    List<LeaveRequest> fetch();

    Employee add(Employee employee);

    void approve(Dto dto, Long id);

    public List<LeaveRequest> check(Role role);

    void reapply(Long id, Dto dto);
    public Responsedto showall(Long id) ;

    public ResponseEntity<Employee> showbyid(Long id);
}
