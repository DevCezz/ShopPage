package pl.csanecki.AITSI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.csanecki.AITSI.entity.Product;
import pl.csanecki.AITSI.entity.ProductCount;
import pl.csanecki.AITSI.entity.ProductType;
import pl.csanecki.AITSI.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {
    private ProductService productService;

    @Autowired
    public AdminController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/addCategory")
    public String getFormForCategory(@ModelAttribute("category") ProductType productType, Model model) {
        if(productType == null)
            productType = new ProductType();

        model.addAttribute("category", productType);

        return "addCategory";
    }

    @PostMapping("/addCategory")
    public String postFormForCategory(@Valid @ModelAttribute("category") ProductType productType,
                                      BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
    	String nameOfProductTypeInCapitals = productType.getName().toUpperCase();
        ProductType productTypeExists = productService.getProductTypeByName(nameOfProductTypeInCapitals);

        productType.setName(nameOfProductTypeInCapitals);
        
        if(productTypeExists != null && productType.getProductTypeId() == 0) {
            bindingResult
                    .rejectValue("name", "error.productType",
                            "* Istnieje już w bazie taka kategoria");
        }

        if(bindingResult.hasErrors()) {
            return "addCategory";
        } else {
            productType.setName(productType.getName().toUpperCase());
            productService.saveProductType(productType);

            redirectAttributes.addFlashAttribute("successMessage", "Pomyślenie zarejestrowano kategorię.");

            return "redirect:/main";
        }
    }
    
    @GetMapping("/editCategory")
    public String getFormForCategory(@RequestParam("categoryId") long productTypeId, Model model) {
        ProductType productType = productService.getProductTypeById(productTypeId);

        model.addAttribute("category", productType);

        return "addCategory";
    }
    
    @GetMapping("/addProduct")
    public String getFormForProduct(@ModelAttribute("product") Product product, Model model) {
        if(product == null) {
            product = new Product();
        }

        List<ProductType> productTypes = productService.getAllCategories();

        model.addAttribute("product", product);
        model.addAttribute("categories", productTypes);

        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String postFormForProduct(@Valid Product product, BindingResult bindingResult, Model model,
                                     RedirectAttributes redirectAttributes) {
        Product productExists = productService.getProductByProducerAndModel(product.getProducer(), product.getModel());

        if(productExists != null && product.getProductId() == 0) {
            bindingResult
                    .rejectValue("model", "error.product",
                            "* Istnieje już w bazie product o takim modelu tego producenta");
        }

        if(bindingResult.hasErrors()) {
            List<ProductType> productTypes = productService.getAllCategories();

            model.addAttribute("categories", productTypes);

            return "addProduct";
        } else {
            productService.saveProduct(product);

            redirectAttributes.addFlashAttribute("successMessage", "Pomyślenie zarejestrowano produkt.");

            return "redirect:/main";
        }
    }
    
    @GetMapping("/editProduct")
    public String getFormForProduct(@RequestParam("productId") long productId, Model model) {
        Product product = productService.getProductById(productId);
        List<ProductType> productTypes = productService.getAllCategories();

        model.addAttribute("product", product);
        model.addAttribute("categories", productTypes);

        return "addProduct";
    }
    
    @DeleteMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("productId") long productId, Model model, RedirectAttributes redirectAttributes) {
        Product product = productService.getProductById(productId);
        productService.deleteProduct(product);

        redirectAttributes.addFlashAttribute("successMessage", "Produkt o id " + productId + " został usunięty.");

        return "redirect:/main";
    }
}
