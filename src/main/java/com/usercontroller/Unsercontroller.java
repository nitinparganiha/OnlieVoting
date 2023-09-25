package com.usercontroller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Candidate;
import com.entity.User;
import com.jparepository.CandidateJpa;
import com.jparepository.UserJpa;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class Unsercontroller {
	@Autowired
	UserJpa user;

	@Autowired
	CandidateJpa cand;
	
	@RequestMapping("/adduser")
	public String home(HttpServletRequest req, HttpServletResponse resp) {
       // EntityManagerFactory emf=Persistence.createEntityManagerFactory("");
		String nm = req.getParameter("name");
		String pas = req.getParameter("pass");
		String mail = req.getParameter("mail");
		int ps = Integer.parseInt(pas);
		User us = new User();
		us.setName(nm);
		us.setEmail(mail);
		us.setPass(ps);
		user.save(us);
		return "login";
	}
	
	@RequestMapping("/")
	public String m2() {
		return "login" ;
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest  req, HttpServletResponse resp, Model model) {
		String name = req.getParameter("mail");
		String pass = req.getParameter("pas");
		int pas = Integer.parseInt(pass);
		String log;
		User ur = user.findByEmailAndPass(name, pas);
		if (ur == null) {
			
		  Admin ad=adm.findByEmailAndPass(name, pas);
			if(ad!=null) {
				
				List<Candidate> al = cand.findByCandidate("candidate1");
				List<Candidate> c2 = cand.findByCandidate("candidate2");
				List<Candidate> c3 = cand.findByCandidate("candidate3");
				List<Candidate> c4 = cand.findByCandidate("candidate4");
				int c11 = al.size();
				int c12 = c2.size();
				int c13 = c3.size();
				int c14 = c4.size();

				model.addAttribute("Candidate1", c11);
				model.addAttribute("Candidate2", c12);
				model.addAttribute("Candidate3", c13);
				model.addAttribute("Candidate4", c14);
				log="CountVoting";
				
			}else {
		    log= "login";
			}
		} else {
			HttpSession h1=req.getSession();
			h1.setAttribute("user", ur);
			log="Voting";
		}
		return log;
	}

	
	@RequestMapping("/vote")
	public String voting(HttpServletRequest req, HttpServletResponse resp) {
		String can=req.getParameter("cand");
		HttpSession h=req.getSession();
		User usr= (User) h.getAttribute("user");
		Candidate c=new Candidate();
		String rt;
		c.setCandidate(can);
		c.setEmail(usr.getEmail());
		Candidate cnd=  cand.findByEmail(usr.getEmail());
		if(cnd==null) {
			cand.save(c);
			rt="submit";
		}else {
			rt="Allreadysub";
		}
		return rt;
	}
	
	@RequestMapping("/ulogout")
	public String logout(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession h3=req.getSession();
		h3.invalidate();
		return "login";
	}
	
	@RequestMapping("/in")
	public String Logbutton() {
		return "SignUp";
	}
}
