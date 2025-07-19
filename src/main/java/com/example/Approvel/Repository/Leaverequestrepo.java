package com.example.Approvel.Repository;

import com.example.Approvel.Model.LeaveRequest;
import com.example.Approvel.Model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Leaverequestrepo extends JpaRepository<LeaveRequest, Long> {


    List<LeaveRequest> findByStatus(Status status);

    Optional<LeaveRequest> findTopByEmployeeIdOrderByIdDesc(Long employeeId);

}
