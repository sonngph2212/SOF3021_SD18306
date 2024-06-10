package fpt.com.assignment.repository;

import fpt.com.assignment.dto.HoaDonDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HoaDonRepository extends JpaRepository<HoaDonDto, Integer> {
    @Query("SELECT p FROM HoaDonDto p where p.trangThai = '1'")
    List<HoaDonDto> getActiveList();
}
