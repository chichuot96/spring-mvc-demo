package vn.topica.itlab4.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.topica.itlab4.form.AccountForm;
import vn.topica.itlab4.model.Account;
import vn.topica.itlab4.model.Product;


@Controller
@Scope("session")
public class MainController {
	private static List<Account> listA=new ArrayList<Account>();
	private static List<Product> listP=new ArrayList<Product>();
	
	 static {
	        listA.add(new Account("chichuot96","123456","abcd@mail.com","nguyen minh chi","ha noi","0348840691",true));
	        listA.add(new Account("hoangnv","123456","abcde@mail.com","nguyen van a","tp ho chi minh","0987654321",false));
	        listP.add(new Product(1,"Christmas tree","https://images.pexels.com/photos/264988/pexels-photo-264988.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",4000,10,100,"10/10/2019"));
	        listP.add(new Product(2,"Christmas tree","https://images.pexels.com/photos/264988/pexels-photo-264988.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",4000,10,100,"10/08/2019"));
	        listP.add(new Product(3,"Christmas tree","https://images.pexels.com/photos/264988/pexels-photo-264988.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",4000,10,100,"02/10/2019"));
	        listP.add(new Product(4,"Christmas tree","https://images.pexels.com/photos/264988/pexels-photo-264988.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",4000,10,100,"16/10/2019"));
	        listP.add(new Product(5,"Christmas tree","https://images.pexels.com/photos/264988/pexels-photo-264988.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",4000,10,100,"19/10/2019"));
	       
	       
	 
	 }
	 
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String loginF(Model model) {
//		AccountForm accountForm=new AccountForm();
//		model.addAttribute("accountForm", accountForm);
        return "loginForm";
    }
//	@ModelAttribute("accountForm") AccountForm accountForm
	@RequestMapping(value= { "/login"}, method=RequestMethod.POST)
	public String login(Model model,  @RequestParam(value="username")String name,  @RequestParam(value="password")String password ,HttpServletRequest request ){
		for(Account a: listA) {
			if(a.getUsername().equals(name)&&a.getPassword().equals(password)) {
//				model.addAttribute("message", "login success");
//			
//				return "loginForm";
				request.getSession().setAttribute("username", a.getFullname()); 
				return "redirect:/";
			}
		}
		model.addAttribute("message", "username or password is incorrect");
		return "loginForm";
	}
	@RequestMapping(value= {"/register"}, method=RequestMethod.GET)
	public String registerF(Model model) {
		AccountForm accountForm=new AccountForm();
		model.addAttribute("accountForm", accountForm);
		return "register";
	}
	@RequestMapping(value= {"/register"}, method=RequestMethod.POST)
	public String register(Model model,@ModelAttribute("accountForm") AccountForm accountForm, HttpServletRequest request) {
		List<String > listUsername=listA.stream().map(a -> a.getUsername()).collect(Collectors.toList());
		if(listUsername.contains(accountForm.getUsername())) {
			model.addAttribute("message","Username has already existed");
			return "register";
			
		}
		model.addAttribute("registerMessage", "register success");
		
		request.getSession().setAttribute("username", accountForm.getUsername());
		return "redirect:/";
	}
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String home(Model model,HttpServletRequest request ) {
		request.getSession().getAttribute("username");
		model.addAttribute("listProduct", listP);
        return "index";
    }
	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
    public String logout(Model model,HttpServletRequest request ) {
		request.getSession().removeAttribute("username");
		model.addAttribute("listProduct", listP);
        return "redirect:/";
    }
	@RequestMapping(value = { "/search" }, method = RequestMethod.GET)
    public String search(Model model,HttpServletRequest request, @ModelAttribute("searchForm") String search ) {
		request.getSession().getAttribute("username");
		List<Product> list1=new ArrayList<Product>();
		for(Product p: listP) {
			if(p.getName().contains(search)) {
				list1.add(p);
			}
		}
		model.addAttribute("listProduct", list1);
        return "index";
    }
	
}
