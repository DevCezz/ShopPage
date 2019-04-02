package pl.csanecki.AITSI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.csanecki.AITSI.entity.Cart;
import pl.csanecki.AITSI.entity.Product;
import pl.csanecki.AITSI.service.ProductService;

@Controller
@RequestMapping("/order")
@SessionAttributes("cart")
public class OrderController {
	private ProductService productService;
    private Cart cart;

    @Autowired
    public OrderController(ProductService productService, Cart cart) {
		this.productService = productService;
		this.cart = cart;
	}

    @GetMapping("/cart")
    public String showCart(Model model) {
        model.addAttribute("cart", cart);

        return "cart";
    }

	@PostMapping("/addToCart/{productId}")
    public String addProductToCart(@PathVariable("productId") long productId, 
    		@RequestParam(value="amount", required=false) int amount, Model model) {
		Product product = productService.getProductById(productId);
        cart.addProductWithAmount(product, amount);
        
        model.addAttribute("cart", cart);

        return "redirect:/order/cart";
    }
}
