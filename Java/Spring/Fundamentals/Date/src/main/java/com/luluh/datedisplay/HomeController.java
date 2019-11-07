package com.luluh.datedisplay;

  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.text.SimpleDateFormat;  
import java.util.Date;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	} 
	
	@RequestMapping("/date")
	public String date(Model model) {
		SimpleDateFormat formatter = new SimpleDateFormat("E MMM d yyyy");  
	    Date date = new Date();
	    String date_to_display = formatter.format(date);
	    model.addAttribute("date", date_to_display);
		return "date.jsp";
	} 
	
	@RequestMapping("/time")
	public String time(Model model) {
	    SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a");  
	    Date time = new Date();  
	    String time_to_display = formatter.format(time);
	    model.addAttribute("time", time_to_display);

		return "time.jsp";
	} 
}
