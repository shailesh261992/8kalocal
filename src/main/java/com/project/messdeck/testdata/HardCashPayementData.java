package com.project.messdeck.testdata;

import java.time.LocalDateTime;

import com.project.messdeck.entity.HardCashPayment;

public class HardCashPayementData {

	public static HardCashPayment getHardCashPaymentData() {
		HardCashPayment hardCashPayment = new HardCashPayment();
		hardCashPayment.setAmount(100);
		hardCashPayment.setRecivedBy("Shailesh Kadam");
		hardCashPayment.setTimeStamp(LocalDateTime.now());

		return hardCashPayment;
	}

}
