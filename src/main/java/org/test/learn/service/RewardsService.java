package org.test.learn.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.test.learn.model.Transaction;

@Service
public class RewardsService {

	public Map<String, Map<String, Integer>> getRewards(List<Transaction> transactions) {
		Map<String, Map<String, Integer>> rewards = new HashMap<>();
		Map<String, List<Transaction>> transactionsByCustomer = transactions.stream()
				.collect(Collectors.groupingBy(Transaction::getCustomerId));
		
		for(Map.Entry<String, List<Transaction>> e: transactionsByCustomer.entrySet()) {
			Map<String, Integer> rewardsByMonth = calculateRewardsByMonth(e.getValue()); 
			rewards.put(e.getKey(), rewardsByMonth);
		}
	
		return rewards;
	}

	private Map<String, Integer> calculateRewardsByMonth(List<Transaction> transactions) {
		Map<String, Integer> monthlyRewards = new HashMap<>();
		Map<String, List<Transaction>> monthlyTransactions = transactions.stream()
				.collect(Collectors.groupingBy(t -> t.getTransactionDate().getMonth().name()));
		
		for(Map.Entry<String, List<Transaction>> e: monthlyTransactions.entrySet()) {
			monthlyRewards.put(e.getKey(), calculateRewards(e.getValue()));
		}
		return monthlyRewards;
	}

	private Integer calculateRewards(List<Transaction> transactions) {
		Integer rewards = 0;
		for(Transaction transaction: transactions) {
			rewards = rewards + rewardsByAmount(transaction.getTransactionAmout());
		}
		return rewards;
	}

	private Integer rewardsByAmount(Float transactionAmout) {
		int rewards = 0;
        if (transactionAmout - 100 > 0) {
        	Float amountOver100 = transactionAmout - 100;
        	rewards = rewards +  Math.round(amountOver100 * 2);
        }
        if (transactionAmout > 50) {
        	
        	rewards = rewards +  Math.round(50 * 1);
        }
		return rewards;
	}

}
