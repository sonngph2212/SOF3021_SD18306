package fpt.com.assignment.repository;

import fpt.com.assignment.dto.MauSacDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MauSacRepository extends JpaRepository<MauSacDto, Integer> {

    @Query("SELECT p FROM MauSacDto p where p.trangThai = '1'")
    List<MauSacDto> getActiveList();
}
