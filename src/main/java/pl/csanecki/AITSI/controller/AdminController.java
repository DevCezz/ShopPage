package pl.csanecki.AITSI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.csanecki.AITSI.entity.Product;
import pl.csanecki.AITSI.entity.ProductType;

@Controller
public class AdminController {
    @GetMapping("/addCategory")
    public String addCategory(Model model) {
        ProductType productType = new ProductType();

        model.addAttribute("category", productType);

        return "addCategory";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();

        model.addAttribute("product", product);

        return "addProduct";
    }
}
