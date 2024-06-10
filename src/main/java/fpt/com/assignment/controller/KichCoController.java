package fpt.com.assignment.controller;

import fpt.com.assignment.dto.AppParamDto;
import fpt.com.assignment.dto.KichCoDto;
import fpt.com.assignment.repository.AppParamRepository;
import fpt.com.assignment.repository.KichCoRepository;
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
@RequestMapping("/admin/kich-co")
public class KichCoController {

    @Autowired
    private KichCoRepository kichCoRepository;

    @GetMapping("/index")
    private String index(@RequestParam("page") Optional<Integer> page, Model model) {
        Pageable pageable = PageRequest.of(page.orElse(0), 10);
        model.addAttribute("pages", kichCoRepository.findAll(pageable));
        return "/admin/kich-co/index";
    }

    @GetMapping({"them-moi", "cap-nhat", "chi-tiet"})
    public String hienThiForm(@RequestParam("id") Optional<Integer> id, Model model, HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        boolean isDetail = false;
        boolean isUpdate = false;
        String title = "Thêm mới";
        if (url.contains("them-moi")) {
            model.addAttribute("objInput", new KichCoDto());
        } else {
            if (url.contains("cap-nhat")) {
                title = "Chỉnh Sửa";
                isUpdate = true;
            } else if (url.contains("chi-tiet")) {
                title = "Chi tiết";
                isDetail = true;
            }
            KichCoDto objTmp = kichCoRepository.findById(id.get()).orElse(null);
            if (objTmp == null) {
                model.addAttribute("errMess", "Sản phẩm không tồn tại");
                return "/admin/kich-co/index";
            }
            model.addAttribute("objInput", objTmp);
        }
        model.addAttribute("title", title);
        model.addAttribute("isUpdate", isUpdate);
        model.addAttribute("isDetail", isDetail);
        return "/admin/kich-co/detail";
    }

    @GetMapping({"delete"})
    public String delete(@RequestParam("id") Integer id) {
        kichCoRepository.deleteById(id);
        return "redirect:/admin/kich-co/index";
    }

    @PostMapping({"/them-moi", "/cap-nhat"})
    public String saveData(@Valid @ModelAttribute("objInput") KichCoDto objInput, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            System.out.println("Lỗi");
            return "/admin/kich-co/detail";
        } else {
            String url = request.getRequestURL().toString();
            if (url.contains("them-moi")) {
                objInput.setNgayTao(new Date());
            } else {
                objInput.setNgaySua(new Date());
            }
            kichCoRepository.save(objInput);
            return "redirect:/admin/kich-co/index";
        }
    }


    @Autowired
    private AppParamRepository appParamRepository;

    @ModelAttribute("lstStatus")
    public List<AppParamDto> getLstStatus() {
        return appParamRepository.getListStatus();
    }
}
