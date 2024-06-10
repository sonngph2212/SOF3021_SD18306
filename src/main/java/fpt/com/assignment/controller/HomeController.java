package fpt.com.assignment.controller;

import fpt.com.assignment.dto.KhachHangDto;
import fpt.com.assignment.dto.SanPhamCtDto;
import fpt.com.assignment.repository.GioHangRepository;
import fpt.com.assignment.repository.KhachHangRepository;
import fpt.com.assignment.repository.SanPhamCtRepository;
import fpt.com.assignment.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/demo")
public class HomeController {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private SanPhamCtRepository sanPhamCtRepository;

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private GioHangRepository gioHangRepository;

    @GetMapping
    public String home(@RequestParam("page") Optional<Integer> page, Model model) {
        Pageable pageable = PageRequest.of(page.orElse(0), 8);
        model.addAttribute("ourProducts", sanPhamCtRepository.findAll(pageable));
        List<SanPhamCtDto> listTmp = sanPhamCtRepository.getActiveList();
        Collections.shuffle(listTmp);
        model.addAttribute("listRandom", listTmp.subList(0, 4));
//        model.addAttribute("sanPham", sanPhamRepository);
        return "/user/home/index";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("objDetail", sanPhamCtRepository.findById(id).orElse(new SanPhamCtDto()));
        return "/user/home/chi-tiet-sp";
    }

    @GetMapping("/gio-hang")
    public String gioHang(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("listData", gioHangRepository.getGioHangByIdUser(id));
        return "/user/home/gio-hang";
    }

    @ModelAttribute("user")
    public KhachHangDto getKhachHang() {
        return khachHangRepository.getActiveList().get(0);
    }

    @ModelAttribute("soLuongGh")
    public int getSoLuongGh() {
        return gioHangRepository.findAll().size();
    }

}
