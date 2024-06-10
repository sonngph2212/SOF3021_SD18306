package fpt.com.assignment.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ctsp")
public class SanPhamCtDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_sp")
    private SanPhamDto sanPhamDto;

    @ManyToOne
    @JoinColumn(name = "id_mau_sac")
    private MauSacDto mauSacDto;

    @ManyToOne
    @JoinColumn(name = "id_size")
    private KichCoDto kichCoDto;

    @Column(name = "gia_ban")
    @Positive(message = "Giá bán phải lớn hơn 0")
    @Min(value = 100, message = "Giá bán phải lớn hơn 100")
    @NotNull(message = "Giá bạn không thể trống")
    private Double giaBan;

    @Column(name = "so_luong_ton")
    @Positive(message = "Số lượng tồn phải lớn hơn 0")
    @NotNull(message = "Số lượng không thể trống")
    private Integer soLuongTon;

    @Column(name = "trang_thai", length = 50)
    private String trangThai;

    @Column(name = "ngay_tao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao;

    @Column(name = "ngay_sua")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaySua;

    @Column(name = "dir_img", length = 255)
    @NotBlank(message = "Ảnh không được trống!")
    private String dirImg;

    public String getStatus() {
        if (this.getTrangThai().equals("1")) {
            return "Hoạt động";
        } else {
            return "Ngừng hoạt động";
        }
    }
}
