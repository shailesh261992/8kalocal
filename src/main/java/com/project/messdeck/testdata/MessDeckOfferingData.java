package com.project.messdeck.testdata;

import java.time.LocalTime;

import com.project.messdeck.entity.MessDeckOffering;
import com.project.messdeck.entity.ServiceType;

public class MessDeckOfferingData {

	public static MessDeckOffering getMessDeckOfferingData() {
		MessDeckOffering messDeckOffering = new MessDeckOffering();
		messDeckOffering.setCapacityOfMembers(50);
		messDeckOffering.setCost(60);
		messDeckOffering.setCustomizable(false);
		messDeckOffering.setEndTime(LocalTime.of(12, 30));
		messDeckOffering.setStartTime(LocalTime.of(10, 30));
		messDeckOffering.setPenaltyPercentage(20);
		messDeckOffering.setUnlimited(false);
		messDeckOffering.setSubscribeThreshold(60000);
		messDeckOffering.setUnSubscribeThreshold(60000);
		messDeckOffering.setVegeterian(true);
		messDeckOffering.setServiceType(ServiceType.LUNCH);
		return messDeckOffering;
	}

}
