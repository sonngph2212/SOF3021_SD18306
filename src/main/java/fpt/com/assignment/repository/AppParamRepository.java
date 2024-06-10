package fpt.com.assignment.repository;

import fpt.com.assignment.dto.AppParamDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppParamRepository extends JpaRepository<AppParamDto, Integer> {

    @Query("SELECT p FROM AppParamDto p where p.maDm='TRANG_THAI' and p.trangThai = 1")
    List<AppParamDto> getListStatus();

    @Query("SELECT p FROM AppParamDto p where p.maDm=?1 and p.value =?2")
    AppParamDto getAppParam(String maDm, String value);
}

