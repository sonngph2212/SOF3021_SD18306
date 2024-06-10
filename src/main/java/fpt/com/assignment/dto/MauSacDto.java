package fpt.com.assignment.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mau_sac")
public class MauSacDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ma_mau", length = 255)
    private String maMau;

    @Column(name = "ten_mau", length = 255)
    @NotBlank(message = "Màu không thể trống!")
    private String tenMau;

    @Column(name = "trang_thai", length = 50)
    private String trangThai;

    @Column(name = "ngay_sua")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaySua;

    @Column(name = "ngay_tao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao;

    public String getStatus() {
        if (this.getTrangThai().equals("1")) {
            return "Hoạt động";
        } else {
            return "Ngừng hoạt động";
        }
    }
}