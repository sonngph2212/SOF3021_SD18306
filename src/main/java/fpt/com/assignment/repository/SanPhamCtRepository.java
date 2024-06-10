package fpt.com.assignment.repository;

import fpt.com.assignment.dto.SanPhamCtDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SanPhamCtRepository extends JpaRepository<SanPhamCtDto, Integer> {

    @Query("SELECT p FROM SanPhamCtDto p where p.trangThai = '1'")
    List<SanPhamCtDto> getActiveList();
}
