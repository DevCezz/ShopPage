package pl.csanecki.AITSI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.csanecki.AITSI.entity.Cart;
import pl.csanecki.AITSI.entity.Product;

@Controller
@RequestMapping("/order")
public class OrderController {
    private Cart cart;

    @Autowired
    public OrderController(Cart cart) {
        this.cart = cart;
    }

    @GetMapping("/cart")
    public String showCart(Model model) {
        model.addAttribute("cart", cart);

        return "cart";
    }

    @PostMapping("/addToCart")
    public String addProductToCart(@ModelAttribute("product") Product product, Model model) {
        cart = new Cart();
        cart.addProduct(product);

        model.addAttribute("cart", cart);

        return "cart";
    }
}
