package com.example.Approvel.Controller;

import com.example.Approvel.Dto.Dto;
import com.example.Approvel.Dto.Responsedto;
import com.example.Approvel.Model.Employee;
import com.example.Approvel.Model.LeaveRequest;
import com.example.Approvel.Model.Role;
import com.example.Approvel.Model.Status;
import com.example.Approvel.Serviceimp.Serviceimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class Maincontroller {
@Autowired
    private Serviceimple serviceimplel;

@PostMapping("/employee")
    public ResponseEntity<String> addemployee(@RequestBody Dto dto){
    serviceimplel.addemployee(dto);
    return ResponseEntity.ok("the details added succesfully");
}

//@PutMapping("tl/{id}")
//    public ResponseEntity<String> tlapprove(@PathVariable Long id){
//    serviceimplel.tlapprove(id);
//    return ResponseEntity.ok("tl approved successfylly");
//}
//
//@PutMapping("manager/{id}")
//    public ResponseEntity<String> manager(@PathVariable Long id){
//    serviceimplel.managerapprove(id);
//    return ResponseEntity.ok("manager approved successfully");
//}

@GetMapping("/leaverequestcheck")
    public ResponseEntity<List<LeaveRequest>> fetch(){
    return ResponseEntity.ok(serviceimplel.fetch());
}
@PostMapping("addemp")
public Employee add(@RequestBody Employee employee){
    return serviceimplel.add(employee);
}

@PutMapping("/approve/{id}")
    public ResponseEntity<String> approve(@RequestBody Dto dto ,@PathVariable Long id){
    serviceimplel.approve(dto, id);
    return ResponseEntity.ok("approvel successfully");
}
@GetMapping("/Role/{role}")
    public ResponseEntity<List<LeaveRequest>> check(@PathVariable Role role ){
    return ResponseEntity.ok( serviceimplel.check(role));
}

@PostMapping("/reapp/{id}")
    public ResponseEntity<String> reaapply(@PathVariable Long id, @RequestBody Dto dto){
    serviceimplel.reapply(id, dto);
    return ResponseEntity.ok("the reapplyied successfully");
}
@GetMapping("/showall/{id}")
    public Responsedto showall(@PathVariable Long id){
    return serviceimplel.showall(id);
}


}
