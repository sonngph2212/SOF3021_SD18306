package fpt.com.assignment.repository;

import fpt.com.assignment.dto.KichCoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KichCoRepository extends JpaRepository<KichCoDto, Integer> {

    @Query("SELECT p FROM KichCoDto p where p.trangThai = '1'")
    List<KichCoDto> getActiveList();
}
