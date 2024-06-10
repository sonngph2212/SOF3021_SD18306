package fpt.com.assignment.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hdct")
public class HoaDonCtDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_hoa_don")
    private HoaDonDto idHoaDon;

    @ManyToOne
    @JoinColumn(name = "id_ctsp")
    private SanPhamCtDto sanPhamCtDto;

    @Column(name = "so_luong_mua")
    @Positive(message = "Số lượng phải lớn hơn 0")
    @NotNull(message = "Số lượng không thể trống")
    private Integer soLuongMua;

    @Column(name = "gia_ban")
    @Positive(message = "Giá bán phải lớn hơn 0")
    @Min(value = 100, message = "Giá bán phải lớn hơn 100")
    @NotNull(message = "Giá bạn không thể trống")
    private Double giaBan;

    @Column(name = "tong_tien")
    @Positive(message = "Tổng tiền phải lớn hơn 0")
    @NotNull(message = "Tổng tiền không thể trống")
    private Double tongTien;

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
            return "Thanh toán thành công";
        } else {
            return "Thanh toán không thành công";
        }
    }
}
