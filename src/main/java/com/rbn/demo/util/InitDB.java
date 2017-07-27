package com.rbn.demo.util;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.rbn.demo.domain.UserRating;
import com.rbn.demo.service.UserRatingService;

@Component
public class InitDB implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserRatingService userRatingService;

	@Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		Document doc = null;
		try {
			doc = Jsoup.connect("http://en.camping.info/netherlands/overijssel/camping-de-papillon-16098/rating")
					.timeout(10000).validateTLSCertificates(false).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (doc != null) {
			Element li = doc.getElementById("rating-container");
			if (li != null) {
				String names[] = { li.getElementsByClass("ub521").html() };
				String dates[] = { li.getElementsByClass("rt12").html() };
				String rates[] = { li.getElementsByClass("rating rating-stars-green large").html() };
				String summeries[] = { li.getElementsByClass("rt70").html() };
				String descs[] = { li.getElementsByClass("quote-text").html() };
				
				for(int i=0;i<=names.length;i++){
					UserRating rating = new UserRating();
					rating.setDateOfStay(StringUtils.substringBetween(dates[i], "<strong>", "</strong>"));
					rating.setDesc(descs[i]);
					rating.setRating(Double.parseDouble(rates[i]));
					rating.setTitle(summeries[i]);
					rating.setUserName(names[i]);
					userRatingService.saveUserRating(rating);
				}
				
			}
		}
	}
}