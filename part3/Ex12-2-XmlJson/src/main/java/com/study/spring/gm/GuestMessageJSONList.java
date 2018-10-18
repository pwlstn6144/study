package com.study.spring.gm;

import java.util.List;

public class GuestMessageJSONList {
	private List<GuestMessage> messages3;
	
	public GuestMessageJSONList(List<GuestMessage> messages4) {
		this.messages3 = messages4;
	}
	
	public List<GuestMessage> getMessages() {
		return messages3;
	}
}
