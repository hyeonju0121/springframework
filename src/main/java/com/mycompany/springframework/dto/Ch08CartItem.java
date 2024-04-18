package com.mycompany.springframework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ch08CartItem {
	private Ch08Product product;
	private int amount;
}
