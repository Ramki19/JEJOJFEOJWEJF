package com.example.Approvel.Serviceimp;

import com.example.Approvel.Dto.Dto;
import com.example.Approvel.Dto.Responsedto;
import com.example.Approvel.Model.Employee;
import com.example.Approvel.Model.LeaveRequest;
import com.example.Approvel.Model.Role;
import com.example.Approvel.Model.Status;
import com.example.Approvel.Repository.Employeerepo;
import com.example.Approvel.Repository.Leaverequestrepo;
import com.example.Approvel.Service.Servicebussiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Serviceimple implements Servicebussiness {
    @Autowired
    private Employeerepo employeerepo;
    @Autowired
    private Leaverequestrepo leaverequestrepo;

    public void addemployee(Dto dto){
        Employee emp= employeerepo.findById(dto.getId()).orElseThrow();
        LeaveRequest request=new LeaveRequest();
        request.setEmployee(emp);
        request.setFromdate(dto.getFromdate());
        request.setTodate(dto.getTodate());
        request.setReason(dto.getReason());
        request.setStatus(Status.PENDING);
        leaverequestrepo.save(request);

}

//    public void tlapprove(Long id) {
//        LeaveRequest request=leaverequestrepo.findById(id).orElseThrow();
//        if(request.getStatus() == Status.PENDING ){
//            request.setStatus(Status.APPROVE_TL);
//
//        }else {
//            System.out.println("approvel not submit");
//        }leaverequestrepo.save(request);
//    }
//    public void managerapprove(Long id){
//        LeaveRequest request=leaverequestrepo.findById(id).orElseThrow();
//        if(request.getStatus()==Status.APPROVE_TL){
//            request.setStatus(Status.APPROVE_MANAGER);
//        }
//        else {
//            System.out.println("approvel not submit");
//        }        leaverequestrepo.save(request);
//
//    }

    public List<LeaveRequest> fetch() {
        return leaverequestrepo.findAll();
    }

    public Employee add(Employee emp){
        return employeerepo.save(emp);
    }
   public void approve(Dto dto, Long id){
        LeaveRequest request=leaverequestrepo.findById(id).orElseThrow();
        if(request.getStatus() == Status.PENDING && dto.getStatus() == Status.APPROVE_TL){
            request.setStatus(dto.getStatus());
        }
        else if(request.getStatus() == Status.APPROVE_TL && dto.getStatus() == Status.APPROVE_MANAGER){
            request.setStatus(dto.getStatus());
       } else{
            request.setStatus(Status.PENDING);
        }
   leaverequestrepo.save(request);
    }
    public List<LeaveRequest> check(Role role) {
        if(role == Role.TL){
            return leaverequestrepo.findByStatus(Status.PENDING);
        }
        else if(role == Role.MANAGER){
            return leaverequestrepo.findByStatus(Status.APPROVE_TL);
        }
        else{
            throw new RuntimeException("details not shown");
        }
    }

    public void reapply(Long id, Dto dto){
        LeaveRequest request=leaverequestrepo.findById(id).orElseThrow();

        if(request.getStatus()==Status.REJECT){
            request.setFromdate(dto.getFromdate());
            request.setTodate(dto.getTodate());
            request.setReason(dto.getReason());
            request.setStatus(Status.PENDING);
        }
        leaverequestrepo.save(request);
    }


    public Responsedto showall(Long id) {
        Employee emp=employeerepo.findById(id).orElseThrow(()->new RuntimeException("Details not found"));
        LeaveRequest leaveRequest = leaverequestrepo. findTopByEmployeeIdOrderByIdDesc(id)
                .orElseThrow(() -> new RuntimeException("Leave request not found"));


        Responsedto response=new Responsedto();
        response.setEmpid(emp.getId());
        response.setEmpname(emp.getEmpname());
        response.setRole(emp.getRole());
        response.setFromdate(leaveRequest.getFromdate());
        response.setTodate(leaveRequest.getTodate());
        response.setReason(leaveRequest.getReason());
        response.setStatus(leaveRequest.getStatus());

return response;
    }


    public ResponseEntity<Employee> showbyid(Long id) {
        Employee employee=employeerepo.findById(id).orElseThrow(()->new RuntimeException("the id is not found"));
        return ResponseEntity.ok(employee);
    }
}
