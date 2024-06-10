package fpt.com.assignment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fpt.com.assignment.dto.AppParamDto;
import fpt.com.assignment.dto.DanhMucDto;
import fpt.com.assignment.dto.SanPhamDto;
import fpt.com.assignment.repository.AppParamRepository;
import fpt.com.assignment.repository.DanhMucRepository;
import fpt.com.assignment.repository.SanPhamRepository;
import fpt.com.assignment.service.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
@RequestMapping("/admin/san-pham")
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private DanhMucRepository danhMucRepository;

    @Autowired
    private AppParamRepository appParamRepository;

    @GetMapping("index")
    public String index(@RequestParam("page") Optional<Integer> page, Model model) {
        Pageable pageable = PageRequest.of(page.orElse(0), 10);
        model.addAttribute("pages", sanPhamService.getPhanTrang(pageable));
        return "/admin/san-pham/index";
    }

    @GetMapping({"them-moi", "cap-nhat"})
    public String hienThiForm(@RequestParam("id") Optional<Integer> id, Model model) {
        if (id.isPresent()) {
            SanPhamDto sanPhamDto = sanPhamRepository.findById(id.get()).orElse(null);
            if (sanPhamDto == null) {
                model.addAttribute("errMess", "Sản phẩm không tồn tại");
                return "/admin/san-pham/index";
            }
            model.addAttribute("objInput", sanPhamDto);
            model.addAttribute("title", "Chỉnh Sửa");
            model.addAttribute("isUpdate", true);
        } else {
            model.addAttribute("objInput", new SanPhamDto());
            model.addAttribute("title", "Thêm mới");
            model.addAttribute("isUpdate", false);
        }
        model.addAttribute("isDetail", false);
        return "/admin/san-pham/insert-update";
    }

    @GetMapping({"chi-tiet"})
    public String chiTiet(@RequestParam("id") Integer id, Model model) {
        SanPhamDto sanPhamDto = sanPhamRepository.findById(id).orElse(null);
        if (sanPhamDto == null) {
            model.addAttribute("errMess", "Sản phẩm không tồn tại");
            return "/admin/san-pham/index";
        }
        model.addAttribute("objInput", sanPhamDto);
        model.addAttribute("title", "Chi tiết");
        model.addAttribute("isDetail", true);
        return "/admin/san-pham/insert-update";
    }

    @GetMapping({"delete"})
    public String delete(@RequestParam("id") Integer id) {
        sanPhamRepository.deleteById(id);
        return "redirect:/admin/san-pham/index";
    }

    @GetMapping("/phan-trang")
    public String phanTrang(@RequestParam("pageNo") Optional<Integer> pageNo, Model model) {
        System.out.println(pageNo);
        Pageable pageable = PageRequest.of(pageNo.orElse(0), 10);
        Page<SanPhamDto> page = sanPhamService.getPhanTrang(pageable);
        //conver json text
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonString = objectMapper.writeValueAsString(page);
            model.addAttribute("pageJson", jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        model.addAttribute("result", page);
        return "/admin/san-pham/phan-trang-json";
    }

    @ModelAttribute("listDanhMuc")
    public List<DanhMucDto> getListDanhMuc() {
        return danhMucRepository.findAll();
    }

    @PostMapping({"/them-moi", "/cap-nhat"})
    public String themMoi(@Valid @ModelAttribute("objInput") SanPhamDto sanPhamDto, BindingResult bindingResult) {
        System.out.println(sanPhamDto.toString());
        if (bindingResult.hasErrors()) {
            System.out.println("Lỗi");
            return "/admin/san-pham/insert-update";
        } else {
            if (!sanPhamRepository.getSanPhamByMaSp(sanPhamDto.getMaSanPham(), sanPhamDto.getId()).isEmpty()) {
                bindingResult.rejectValue("maSanPham", "duplicate", "Mã sản phẩm đã  tồn tại"); // Thêm lỗi vào BindingResult
                return "/admin/san-pham/insert-update"; // Trả về lại trang form với thông tin lỗi
            }
            sanPhamDto.setNgayTao(new Date());
            sanPhamRepository.save(sanPhamDto);
            return "redirect:/admin/san-pham/index";
        }
    }

    @ModelAttribute("lstStatus")
    public List<AppParamDto> getLstStatus() {
        return appParamRepository.getListStatus();
    }
}
