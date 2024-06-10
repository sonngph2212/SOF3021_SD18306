package fpt.com.assignment.repository;

import fpt.com.assignment.dto.DanhMucDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DanhMucRepository extends JpaRepository<DanhMucDto, Integer> {

    @Query("SELECT p FROM DanhMucDto p where p.trangThai = '1'")
    List<DanhMucDto> getActiveList();
}
