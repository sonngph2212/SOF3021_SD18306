package fpt.com.assignment.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "khach_hang")
public class KhachHangDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ho_ten", length = 255)
    @NotBlank(message = "Tên không thể trống!")
    private String hoTen;

    @Column(name = "dia_chi", length = 255)
    @NotBlank(message = "Địa chỉ không thể trống!")
    private String diaChi;

    @Column(name = "sdt", length = 20)
    @Pattern(regexp = "^(03|05|07|08|09)+[0-9]{7,8}$", message = "Số điện thoại không hợp lệ!")
    private String sdt;

    @Column(name = "trang_thai", length = 50)
    private String trangThai;

    @Column(name = "ngay_tao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao;

    @Column(name = "ngay_sua")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaySua;

    public String getStatus() {
        if (this.getTrangThai().equals("1")) {
            return "Hoạt động";
        } else {
            return "Ngừng hoạt động";
        }
    }
}