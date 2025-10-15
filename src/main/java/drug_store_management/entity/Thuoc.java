package drug_store_management.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "thuoc")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Thuoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Ảnh không được để trống")
    @Column(name = "anh", nullable = false)
    private String anh; // Đảm bảo trường này tồn tại

    @NotBlank(message = "Tên thuốc không được để trống")
    @Column(name = "ten", nullable = false)
    private String ten;

    @NotBlank(message = "Loại thuốc không được để trống")
    @Column(name = "loai", nullable = false)
    private String loai;

    @Column(name = "han_su_dung")
    private String hanSuDung;

    @NotNull(message = "Giá không được để trống")
    @DecimalMin(value = "0.0", inclusive = true, message = "Giá phải lớn hơn hoặc bằng 0")
    @Column(name = "gia", nullable = false)
    private BigDecimal gia;

    @NotNull(message = "Số lượng tồn kho không được để trống")
    @Min(value = 0, message = "Số lượng tồn kho phải lớn hơn hoặc bằng 0")
    @Column(name = "so_luong_ton_kho", nullable = false)
    private Integer soLuongTonKho;

    @NotBlank(message = "Nhà cung cấp không được để trống")
    @Column(name = "nha_cung_cap", nullable = false)
    private String nhaCungCap;
}