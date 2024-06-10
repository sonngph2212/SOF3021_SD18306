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
@Table(name = "gio_hang")
public class GioHangDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_khach_hang")
    private KhachHangDto khachHangDto;

    @ManyToOne
    @JoinColumn(name = "id_sp")
    private SanPhamCtDto sanPhamCtDto;

    @Column(name = "so_luong")
    private int soLuong;

    @Column(name = "ngay_tao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao;
}
