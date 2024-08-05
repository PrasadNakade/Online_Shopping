

package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cart;
import com.example.demo.model.MyOrders;
import com.example.demo.model.OrderProduct;
import com.example.demo.model.Product;
import com.example.demo.model.Rating;
import com.example.demo.projection.Cartui;
import com.example.demo.projection.ProductUiBuyer;
import com.example.demo.repo.CartRepo;
import com.example.demo.repo.OrderProductRepo;
import com.example.demo.repo.OrderRepo;
import com.example.demo.repo.ProductRepo;
import com.example.demo.repo.RatingRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("buyer")
public class BuyerController {
    
    @Autowired
    private ProductRepo productRepo;
    
    
  
    @Autowired
    private RatingRepo ratingRepo;
    
    @Autowired
    CartRepo cartRepo;
    
    @Autowired
    OrderRepo orderRepo;
    
    @Autowired
    OrderProductRepo orderProductRepo;
    
    @RequestMapping("placeOrder{id}")
    public int placeOrder(@PathVariable int id, @RequestBody int[][] a) {
        try {
            MyOrders order = new MyOrders();
            order.setUserid(id);
            order = orderRepo.save(order);

            double totalAmount = 0;

            for (int i = 0; i < a.length; i++) {
                int[] a1 = a[i];
                int cartid = a1[0];
                int quantity = a1[1];

                Optional<Cart> optionalCart = cartRepo.findById(cartid);
               
                Cart cart = optionalCart.get();
                int productid = cart.getProductid();

                Optional<Product> optionalProduct = productRepo.findById(productid);
                Product product = optionalProduct.get();

                OrderProduct obj = new OrderProduct();

                double price = product.getPrice() * quantity;
                price = price - (price * product.getDiscount() / 100);
                obj.setAmount(price);

                totalAmount += price;
                obj.setOrderid(order.getId());
                obj.setProductid(productid);
                obj.setQuantity(quantity);
                orderProductRepo.save(obj);

                product.setQuantity(product.getQuantity() - quantity);
                productRepo.save(product);

                cartRepo.delete(cart);
            }

            order.setAmount(totalAmount);
            orderRepo.save(order);
            return 1;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    
    
    
    @RequestMapping("deleteCategory{catid}")
    public int deleteCategory(@PathVariable int catid)
    {
    	try 
    	{
    		cartRepo.deleteById(catid);
    		return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
    }
    	
    @RequestMapping("getAllCartInfo{userid}")
    public List<Cartui> getAllCartInfo(@PathVariable int userid)
    {
    	return cartRepo.getAllCartDetailsInfo(userid);
    	
    }
    
    
    @RequestMapping("addToCart{productid}and{userid}")
    public int addToCart(@PathVariable int productid, @PathVariable int userid)    
    {
 		try {
    			int count= cartRepo.countByProductidAndUserid(productid, userid);
    	    	
    	    	if(count==1)  //ahe cart madhe
    	    	{
    	    		return 1;
    	    	}
    	    	else if(count>1)
    	    	{
    	    		return 0;   //multiple products in cart
    	    	}
    	    	else
    	    	{
    	    		Cart cart=new Cart();
    	    		cart.setUserid(userid);
    	    		cart.setProductid(productid);
    	    		cartRepo.save(cart);
    	    		return -1;   //added successful
    	    		
    	    	}
			} catch (Exception e) {
				e.printStackTrace();
				return -2;
			}
    }
    
    
    
    
    
    @GetMapping("getRating{productid}and{userid}and{stars}")
    public int getRating(@PathVariable int productid, @PathVariable int userid, @PathVariable int stars) {
        try {
            int count = ratingRepo.countByProductidAndUserid(productid, userid);
            
            if (count == 1) { // update existing rating
                Rating rev = ratingRepo.findByProductidAndUserid(productid, userid);
                rev.setStars(stars);
                ratingRepo.save(rev);
                
            } else if (count == 0) { // new rating
                Rating newRating = new Rating();
                newRating.setProductid(productid);
                newRating.setUserid(userid);
                newRating.setStars(stars);
                newRating.setDate(new Date());
                ratingRepo.save(newRating);
                
                
            } else {
                return 0;
            }
            
            double avg = ratingRepo.findAvgRatingByProductid(productid);
            Product product = productRepo.findById(productid).get();
           
                product.setRating(avg);
                productRepo.save(product);
            
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    @PostMapping("allFilterProductDataSendToUi")
    public List<ProductUiBuyer> allFilterProductDataSendToUi(@RequestBody int[] a) {
        return productRepo.getAllFilterProductInfo(a[0], a[1], a[2], a[3]);
    }
}
