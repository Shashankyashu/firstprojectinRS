package com.example.demo.module;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AadharCard {
	


		@Id
		private String adharNumber;



		public String getAdharNumber() {
			return adharNumber;
		}

		public void setAdharNumber(String adharNumber) {
			this.adharNumber = adharNumber;
		}
	}


