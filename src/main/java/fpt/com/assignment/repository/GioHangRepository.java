package fpt.com.assignment.repository;

import fpt.com.assignment.dto.DanhMucDto;
import fpt.com.assignment.dto.GioHangDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GioHangRepository extends JpaRepository<GioHangDto, Integer> {

    @Query("SELECT p FROM GioHangDto p where p.khachHangDto.id=?1")
    List<GioHangDto> getGioHangByIdUser(int id);
}
