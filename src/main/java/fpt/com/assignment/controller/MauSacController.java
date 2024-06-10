package fpt.com.assignment.controller;

import fpt.com.assignment.dto.AppParamDto;
import fpt.com.assignment.dto.MauSacDto;
import fpt.com.assignment.repository.AppParamRepository;
import fpt.com.assignment.repository.MauSacRepository;
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
@RequestMapping("/admin/mau-sac")
public class MauSacController {

    @Autowired
    private MauSacRepository mauSacRepository;

    @GetMapping("/index")
    private String index(@RequestParam("page") Optional<Integer> page, Model model) {
        Pageable pageable = PageRequest.of(page.orElse(0), 10);
        model.addAttribute("pages", mauSacRepository.findAll(pageable));
        return "/admin/mau-sac/index";
    }

    @GetMapping({"them-moi", "cap-nhat", "chi-tiet"})
    public String hienThiForm(@RequestParam("id") Optional<Integer> id, Model model, HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        boolean isDetail = false;
        boolean isUpdate = false;
        String title = "Thêm mới";
        if (url.contains("them-moi")) {
            model.addAttribute("objInput", new MauSacDto());
        } else {
            if (url.contains("cap-nhat")) {
                title = "Chỉnh Sửa";
                isUpdate = true;
            } else if (url.contains("chi-tiet")) {
                title = "Chi tiết";
                isDetail = true;
            }
            MauSacDto objTmp = mauSacRepository.findById(id.get()).orElse(null);
            if (objTmp == null) {
                model.addAttribute("errMess", "Sản phẩm không tồn tại");
                return "/admin/mau-sac/index";
            }
            model.addAttribute("objInput", objTmp);
        }
        model.addAttribute("title", title);
        model.addAttribute("isUpdate", isUpdate);
        model.addAttribute("isDetail", isDetail);
        return "/admin/mau-sac/detail";
    }

    @GetMapping({"delete"})
    public String delete(@RequestParam("id") Integer id) {
        mauSacRepository.deleteById(id);
        return "redirect:/admin/mau-sac/index";
    }

    @PostMapping({"/them-moi", "/cap-nhat"})
    public String saveData(@Valid @ModelAttribute("objInput") MauSacDto objInput, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            System.out.println("Lỗi");
            return "/admin/mau-sac/detail";
        } else {
            String url = request.getRequestURL().toString();
            if (url.contains("them-moi")) {
                objInput.setNgayTao(new Date());
            } else {
                objInput.setNgaySua(new Date());
            }
            mauSacRepository.save(objInput);
            return "redirect:/admin/mau-sac/index";
        }
    }


    @Autowired
    private AppParamRepository appParamRepository;

    @ModelAttribute("lstStatus")
    public List<AppParamDto> getLstStatus() {
        return appParamRepository.getListStatus();
    }
}
