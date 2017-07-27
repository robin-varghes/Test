package com.rbn.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rbn.demo.service.UserRatingService;

@Controller
public class PersonController {

	@Autowired
	private UserRatingService userRatingService;

	@RequestMapping(value = "/rating", method = RequestMethod.GET)
	public String listPersonsRating(Model model) throws IOException {
		model.addAttribute("count", userRatingService.totalUserRatingCount());
		model.addAttribute("avg", userRatingService.averageUserRatingCount());
		model.addAttribute("ratings", userRatingService.findAll());
		return "rating";
	}

}
