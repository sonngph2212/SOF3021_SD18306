package fpt.com.assignment.repository;

import fpt.com.assignment.dto.SanPhamDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPhamDto, Integer> {

    @Query("SELECT p FROM SanPhamDto p where p.maSanPham=?1 and p.id != ?2")
    List<SanPhamDto> getSanPhamByMaSp(String maSanPham, int id);

    @Query("SELECT p FROM SanPhamDto p where p.trangThai = '1'")
    List<SanPhamDto> getActiveList();
}
