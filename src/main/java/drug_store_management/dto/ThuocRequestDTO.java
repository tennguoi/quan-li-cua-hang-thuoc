package drug_store_management.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import drug_store_management.entity.Thuoc;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThuocRequestDTO {

    private Integer id;

    @NotBlank(message = "URL ảnh không được để trống")
    private String imageUrl;

    private MultipartFile imageFile;

    @NotBlank(message = "Tên thuốc không được để trống")
    private String ten;

    @NotBlank(message = "Loại thuốc không được để trống")
    private String loai;

    private LocalDate hanSuDung;

    @NotNull(message = "Giá không được để trống")
    @DecimalMin(value = "0.0", inclusive = true, message = "Giá phải lớn hơn hoặc bằng 0")
    private BigDecimal gia;

    @NotNull(message = "Số lượng tồn kho không được để trống")
    @Min(value = 0, message = "Số lượng tồn kho phải lớn hơn hoặc bằng 0")
    private Integer soLuongTonKho;

    @NotBlank(message = "Nhà cung cấp không được để trống")
    private String nhaCungCap;

    // Convert to Thuoc entity
    public Thuoc toEntity() {
        Thuoc thuoc = new Thuoc();
        thuoc.setId(this.id != null ? this.id.intValue() : null);
        thuoc.setAnh(this.imageUrl); // Gọi setAnh(String)
        thuoc.setTen(this.ten);
        thuoc.setLoai(this.loai);
        thuoc.setHanSuDung(this.hanSuDung != null ? this.hanSuDung.toString() : null);
        thuoc.setGia(this.gia);
        thuoc.setSoLuongTonKho(this.soLuongTonKho);
        thuoc.setNhaCungCap(this.nhaCungCap);
        return thuoc;
    }

    // Create from Thuoc entity
    public static ThuocRequestDTO fromEntity(Thuoc thuoc) {
        ThuocRequestDTO dto = new ThuocRequestDTO();
        dto.setId(thuoc.getId() != null ? Integer.valueOf(thuoc.getId()) : null);
        dto.setImageUrl(thuoc.getAnh());
        dto.setTen(thuoc.getTen());
        dto.setLoai(thuoc.getLoai());
        dto.setHanSuDung(thuoc.getHanSuDung() != null ? LocalDate.parse(thuoc.getHanSuDung()) : null);
        dto.setGia(thuoc.getGia());
        dto.setSoLuongTonKho(thuoc.getSoLuongTonKho());
        dto.setNhaCungCap(thuoc.getNhaCungCap());
        return dto;
    }
    private String saveImageFile() {
        return "uploads/list_image/" + imageFile.getOriginalFilename() + ".jpg";
    }
}