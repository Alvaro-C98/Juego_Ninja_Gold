package com.example.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@RequestMapping("/")
	public String redirecting() {
		return "redirect:/gold";
	}
	
	@RequestMapping("/gold")
	public String home(HttpSession sesion, Model model) {
		if(sesion.getAttribute("gold")==null){
			model.addAttribute("gold",0);
		}else {
			model.addAttribute("gold",sesion.getAttribute("gold"));
			model.addAttribute("activity",sesion.getAttribute("activity"));
		}
		return "index.jsp";
	}
	
	@PostMapping("/gold")
	public String gold(HttpSession sesion,
			Model model,
			@RequestParam(value="site") String site) {
		int gold = 0;
		ArrayList<String> activity = new ArrayList<String>();
		SimpleDateFormat date = new SimpleDateFormat("MMMM d y h:mm a");

		if(sesion.getAttribute("gold")==null) {
			sesion.setAttribute("gold", gold);
			sesion.setAttribute("activity", activity);
		}else {
			gold=(int)sesion.getAttribute("gold");
			activity = (ArrayList<String>)sesion.getAttribute("activity");
		}
		
		if(site.equals("farm")) {
			int cant = new Random().nextInt(11)+10;
			gold+=cant;
			activity.add(0,"You entered a farm and earned "+cant+" gold. ("+date.format(new Date())+")");
			sesion.setAttribute("activity", activity);
			sesion.setAttribute("gold", gold);
			
		}
		if(site.equals("cave")) {
			int cant = new Random().nextInt(6)+5;
			gold+=cant;
			activity.add(0,"You entered a cave and earned "+cant+" gold. ("+date.format(new Date())+")");
			sesion.setAttribute("activity", activity);
			sesion.setAttribute("gold", gold);
		}
		if(site.equals("house")) {
			int cant = new Random().nextInt(6)+2;
			gold+=cant;
			activity.add(0,"You entered a house and earned "+cant+" gold. ("+date.format(new Date())+")");
			sesion.setAttribute("activity", activity);
			sesion.setAttribute("gold", gold);
		}
		if(site.equals("casino")) {
			int cant = new Random().nextInt(51);
			int rand = new Random().nextInt(2);
			if(rand==1) {
				gold+=cant;
				activity.add(0,"You entered a casino and earned "+cant+" gold. ("+date.format(new Date())+")");
				sesion.setAttribute("activity", activity);
			}else {
				gold-=cant;
				activity.add(0,"You entered a casino and lost "+cant+" gold... Ouch. ("+date.format(new Date())+")");
				sesion.setAttribute("activity", activity);
			}
			
			sesion.setAttribute("gold", gold);
		}
		
		return "redirect:/gold";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession sesion) {
		sesion.invalidate();
		return "redirect:/gold";
	}
}
