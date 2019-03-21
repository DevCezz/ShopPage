package pl.csanecki.AITSI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.csanecki.AITSI.entity.Product;
import pl.csanecki.AITSI.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public String getProductsOfCategoryName(@RequestParam("categoryId") long categoryId, Model model) {
        String productTypeName = productService.getProductTypeNameWithFirstCapitalLetter(categoryId);
        List<Product> listOfProducts = productService.getProductsByCategory(categoryId);

        model.addAttribute("categoryName", productTypeName);
        model.addAttribute("products", listOfProducts);

        return "products";
    }

    @GetMapping("/product")
    public String getProductById(@RequestParam("productId") long productId, Model model) {
        Product product = productService.getProductById(productId);

        model.addAttribute("product", product);

        return "product";
    }
}
