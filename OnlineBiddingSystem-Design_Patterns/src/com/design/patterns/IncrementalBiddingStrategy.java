package com.design.patterns;

public class IncrementalBiddingStrategy implements BiddingStrategy {
	@Override
	public double bid(Item item, User user, double amount ) {
		double currentBid = item.getCurrentHighestBid();
		if(amount>currentBid) {
			item.placeBid(user, amount);	
			}else {
				NotificationService notificationService = new NotificationService();
				notificationService.notifyUser(user, item);
			}
		
		return amount;
	}

	
	
}