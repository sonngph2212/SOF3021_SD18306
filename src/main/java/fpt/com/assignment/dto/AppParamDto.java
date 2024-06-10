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
@Table(name = "dm_app_param")
public class AppParamDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ma_dm", length = 255)
    private String maDm;

    @Column(name = "ten_dm", columnDefinition = "nvarchar", length = 255)
    private String tenDm;

    @Column(name = "value", length = 100)
    private String value;

    @Column(name = "value_2")
    private int value2;

    @Column(name = "trang_thai")
    private int trangThai;

    @Column(name = "ngay_tao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao;

    @Column(name = "ngay_sua")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaySua;
}
