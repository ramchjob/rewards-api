package org.test.learn.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.test.learn.model.Transaction;
import org.test.learn.service.RewardsService;

@RequestMapping("/")
@RestController
public class RewardsController {

	@Autowired
	RewardsService rewardsService;
	
	
	@PostMapping("/rewards")
	public ResponseEntity<Map<String, Map<String, Integer>>> calculateRewards(@RequestBody List<Transaction> transactions) {
		Map<String, Map<String, Integer>> rewardsByMonth = rewardsService.getRewards(transactions);
		return ResponseEntity.ok(rewardsByMonth);
	}
	
	
}
