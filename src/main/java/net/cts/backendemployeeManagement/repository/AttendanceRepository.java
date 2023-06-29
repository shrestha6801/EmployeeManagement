package net.cts.backendemployeeManagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.cts.backendemployeeManagement.dto.AttendanceDTO;
import net.cts.backendemployeeManagement.model.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
    // Add custom query methods if needed
}
