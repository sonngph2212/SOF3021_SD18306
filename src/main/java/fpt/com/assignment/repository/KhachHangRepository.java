package fpt.com.assignment.repository;

import fpt.com.assignment.dto.KhachHangDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KhachHangRepository extends JpaRepository<KhachHangDto, Integer> {
    @Query("SELECT p FROM KhachHangDto p where p.trangThai = '1'")
    List<KhachHangDto> getActiveList();
}
