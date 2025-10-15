package drug_store_management.controller;

import drug_store_management.entity.Medicine;
import drug_store_management.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/medicines")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    // 🧩 Hiển thị form thêm thuốc
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("medicine", new Medicine());
        model.addAttribute("types", medicineService.getAllMedicineTypes());
        model.addAttribute("suppliers", medicineService.getAllSuppliers());
        return "medicine_add"; // Tên file HTML (view)
    }

    // 💾 Xử lý thêm thuốc khi người dùng submit form
    @PostMapping("/add")
    public String addMedicine(@ModelAttribute("medicine") Medicine medicine) {
        medicineService.addMedicine(medicine);
        return "redirect:/medicines"; // Sau khi thêm xong quay về danh sách
    }
}
