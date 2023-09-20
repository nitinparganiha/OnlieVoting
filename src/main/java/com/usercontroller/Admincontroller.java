package com.usercontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Admin;
import com.entity.Candidate;
import com.jparepository.AdminJpa;
import com.jparepository.CandidateJpa;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class Admincontroller {
	@Autowired
	AdminJpa adm;

	@Autowired
	CandidateJpa cj;

	@RequestMapping("/admin")
	public String AdminLogin(HttpServletRequest req, HttpServletResponse resp) {
		return "AdmLogin";
	}



	@RequestMapping("/alogin")
	public String adminHome1(@RequestParam("mail") String email, @RequestParam("pass") int pass, Model model) {
		String temp;

		if (email == null) {
			temp = "AdmLogin";
		} else {
			List<Candidate> al = cj.findByCandidate("candidate1");
			List<Candidate> c2 = cj.findByCandidate("candidate2");
			List<Candidate> c3 = cj.findByCandidate("candidate3");
			List<Candidate> c4 = cj.findByCandidate("candidate4");
			int c11 = al.size();
			int c12 = c2.size();
			int c13 = c3.size();
			int c14 = c4.size();

			model.addAttribute("Candidate1", c11);
			model.addAttribute("Candidate2", c12);
			model.addAttribute("Candidate3", c13);
			model.addAttribute("Candidate4", c14);
			temp = "CountVoting";
		}
		return temp;
	}

	@RequestMapping("/admRegis")
	public String Sign(HttpServletRequest req, HttpServletResponse resp) {
		return "AdminSign";
	}

	@RequestMapping("/asign")
	public String AdminS(HttpServletRequest req, HttpServletResponse resp) {
		String mail = req.getParameter("mail");
		String pas = req.getParameter("pass");
		int ps = Integer.parseInt(pas);
		Admin a = new Admin();
		a.setEmail(mail);
		a.setPass(ps);
		adm.save(a);
		return "AdmLogin";
	}

}
