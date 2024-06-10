package fpt.com.assignment.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "danh_muc")
public class DanhMucDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ma_danh_muc", length = 255)
    private String maDanhMuc;

    @Column(name = "ten_danh_muc", columnDefinition = "nvarchar", length = 255)
    private String tenDanhMuc;

    @Column(name = "value", length = 100)
    private String value;

    @Column(name = "trang_thai", length = 50)
    private String trangThai;

    @Column(name = "ngay_tao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao;

    @Column(name = "ngay_sua")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaySua;
}