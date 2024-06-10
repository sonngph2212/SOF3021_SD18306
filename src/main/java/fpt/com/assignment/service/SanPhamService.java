package fpt.com.assignment.service;

import fpt.com.assignment.dto.SanPhamDto;
import fpt.com.assignment.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    // Phân trang - Paginating
    public Page<SanPhamDto> getPhanTrang(Pageable pageable) {
        return sanPhamRepository.findAll(pageable);
    }
}
