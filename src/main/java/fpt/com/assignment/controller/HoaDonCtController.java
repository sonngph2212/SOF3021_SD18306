package fpt.com.assignment.controller;

import fpt.com.assignment.dto.AppParamDto;
import fpt.com.assignment.dto.HoaDonCtDto;
import fpt.com.assignment.dto.HoaDonDto;
import fpt.com.assignment.dto.SanPhamCtDto;
import fpt.com.assignment.repository.AppParamRepository;
import fpt.com.assignment.repository.HoaDonCtRepository;
import fpt.com.assignment.repository.HoaDonRepository;
import fpt.com.assignment.repository.SanPhamCtRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/hoa-don-ct")
public class HoaDonCtController {

    @Autowired
    private HoaDonCtRepository hoaDonCtRepository;

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private SanPhamCtRepository sanPhamCtRepository;

    @GetMapping("/index")
    private String index(@RequestParam("page") Optional<Integer> page, Model model) {
        Pageable pageable = PageRequest.of(page.orElse(0), 10);
        model.addAttribute("pages", hoaDonCtRepository.findAll(pageable));
        return "/admin/hoa-don-ct/index";
    }

    @GetMapping({"them-moi", "cap-nhat", "chi-tiet"})
    public String hienThiForm(@RequestParam("id") Optional<Integer> id, Model model, HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        boolean isDetail = false;
        boolean isUpdate = false;
        String title = "Thêm mới";
        if (url.contains("them-moi")) {
            model.addAttribute("objInput", new HoaDonCtDto());
        } else {
            if (url.contains("cap-nhat")) {
                title = "Chỉnh Sửa";
                isUpdate = true;
            } else if (url.contains("chi-tiet")) {
                title = "Chi tiết";
                isDetail = true;
            }
            HoaDonCtDto objTmp = hoaDonCtRepository.findById(id.get()).orElse(null);
            if (objTmp == null) {
                model.addAttribute("errMess", "Sản phẩm không tồn tại");
                return "/admin/hoa-don-ct/index";
            }
            model.addAttribute("objInput", objTmp);
        }
        model.addAttribute("title", title);
        model.addAttribute("isUpdate", isUpdate);
        model.addAttribute("isDetail", isDetail);
        return "/admin/hoa-don-ct/detail";
    }

    @GetMapping({"delete"})
    public String delete(@RequestParam("id") Integer id) {
        hoaDonCtRepository.deleteById(id);
        return "redirect:/admin/hoa-don-ct/index";
    }

    @PostMapping({"/them-moi", "/cap-nhat"})
    public String saveData(@Valid @ModelAttribute("objInput") HoaDonCtDto objInput, BindingResult bindingResult, HttpServletRequest request, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("Lỗi");
            return "/admin/hoa-don-ct/detail";
        } else {
            String url = request.getRequestURL().toString();
            if (url.contains("them-moi")) {
                objInput.setNgayTao(new Date());
            } else {
                HoaDonCtDto hoaDonCtDto = hoaDonCtRepository.findById(objInput.getId()).orElse(null);
                objInput.setNgayTao(hoaDonCtDto.getNgayTao());
                objInput.setNgaySua(new Date());
            }
            hoaDonCtRepository.save(objInput);
            return "redirect:/admin/hoa-don-ct/index";
        }
    }

    @ModelAttribute("lstHd")
    public List<HoaDonDto> getLstHd() {
        return hoaDonRepository.getActiveList();
    }

    @ModelAttribute("lstSp")
    public List<SanPhamCtDto> getLstSp() {
        return sanPhamCtRepository.getActiveList();
    }

    @Autowired
    private AppParamRepository appParamRepository;

    @ModelAttribute("lstStatus")
    public List<AppParamDto> getLstStatus() {
        return appParamRepository.getListStatus();
    }
}
