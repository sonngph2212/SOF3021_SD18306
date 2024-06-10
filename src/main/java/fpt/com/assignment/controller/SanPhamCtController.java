package fpt.com.assignment.controller;

import fpt.com.assignment.dto.*;
import fpt.com.assignment.repository.*;
import fpt.com.assignment.service.CommonService;
import fpt.com.assignment.utils.EnumCommon;
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
@RequestMapping("/admin/san-pham-ct")
public class SanPhamCtController {

    @Autowired
    private SanPhamCtRepository sanPhamCtRepository;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private MauSacRepository mauSacRepository;

    @Autowired
    private KichCoRepository kichCoRepository;

    @Autowired
    private AppParamRepository appParamRepository;

    @GetMapping("/index")
    private String index(@RequestParam("page") Optional<Integer> page, Model model) {
        Pageable pageable = PageRequest.of(page.orElse(0), 10);
        model.addAttribute("pages", sanPhamCtRepository.findAll(pageable));
        return "/admin/san-pham-ct/index";
    }

    @GetMapping({"them-moi", "cap-nhat", "chi-tiet"})
    public String hienThiForm(@RequestParam("id") Optional<Integer> id, Model model, HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        boolean isDetail = false;
        boolean isUpdate = false;
        String title = "Thêm mới";
        if (url.contains("them-moi")) {
            model.addAttribute("objInput", new SanPhamCtDto());
        } else {
            if (url.contains("cap-nhat")) {
                title = "Chỉnh Sửa";
                isUpdate = true;
            } else if (url.contains("chi-tiet")) {
                title = "Chi tiết";
                isDetail = true;
            }
            SanPhamCtDto objTmp = sanPhamCtRepository.findById(id.get()).orElse(null);
            if (objTmp == null) {
                model.addAttribute("errMess", "Sản phẩm không tồn tại");
                return "/admin/san-pham-ct/index";
            }
            model.addAttribute("objInput", objTmp);
        }
        model.addAttribute("title", title);
        model.addAttribute("isUpdate", isUpdate);
        model.addAttribute("isDetail", isDetail);
        return "/admin/san-pham-ct/detail";
    }

    @GetMapping({"delete"})
    public String delete(@RequestParam("id") Integer id) {
        sanPhamCtRepository.deleteById(id);
        return "redirect:/admin/san-pham-ct/index";
    }

    @PostMapping({"/them-moi", "/cap-nhat"})
    public String saveData(@Valid @ModelAttribute("objInput") SanPhamCtDto objInput, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            System.out.println("Lỗi");
            return "/admin/san-pham-ct/detail";
        } else {
            String url = request.getRequestURL().toString();
            if (url.contains("them-moi")) {
                objInput.setNgayTao(new Date());
            } else {
                SanPhamCtDto sanPhamCtDto = sanPhamCtRepository.findById(objInput.getId()).orElse(null);
                objInput.setNgayTao(sanPhamCtDto.getNgayTao());
                objInput.setNgaySua(new Date());
            }
            sanPhamCtRepository.save(objInput);
            return "redirect:/admin/san-pham-ct/index";
        }
    }

    @ModelAttribute("lstSanPham")
    public List<SanPhamDto> getLstSanPham() {
        return sanPhamRepository.getActiveList();
    }

    @ModelAttribute("lstSize")
    public List<KichCoDto> getLstSize() {
        return kichCoRepository.getActiveList();
    }

    @ModelAttribute("lstMau")
    public List<MauSacDto> getLstMau() {
        return mauSacRepository.getActiveList();
    }

    @ModelAttribute("lstStatus")
    public List<AppParamDto> getLstStatus() {
        return appParamRepository.getListStatus();
    }
}
