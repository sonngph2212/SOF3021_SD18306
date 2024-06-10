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
@Table(name = "size")
public class KichCoDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ma_size", length = 255)
    private String maSize;

    @Column(name = "ten_size", length = 255)
    @NotBlank(message = "Kích cỡ không thể trống!")
    private String tenSize;

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
