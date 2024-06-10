package fpt.com.assignment.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "san_pham")
public class SanPhamDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ma_san_pham", length = 255)
    private String maSanPham;

    @Column(name = "ten_san_pham", columnDefinition = "nvarchar", length = 255)
    private String tenSanPham;

    @Column(name = "trang_thai", columnDefinition = "nvarchar", length = 50)
    private String trangThai;

    @Column(name = "ngay_tao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao;

    @Column(name = "ngay_sua")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaySua;

    @ManyToOne
    @JoinColumn(name = "id_danh_muc")
    private DanhMucDto danhMucDto;

    @Column(name = "dir_img", length = 255)
    private String dirImg;

    public String getStatus() {
        if (this.getTrangThai().equals("1")) {
            return "Hoạt động";
        } else {
            return "Ngừng hoạt động";
        }
    }
}