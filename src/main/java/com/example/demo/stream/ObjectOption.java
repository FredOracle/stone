package com.example.demo.stream;

import java.util.Optional;

import javax.el.MethodNotFoundException;

public class ObjectOption {

	public static void main(String[] args) {

		Integer value = null;

		Optional<Integer> b = Optional.ofNullable(value);
		System.out.println(b.orElse(110));

		// Optional<Integer> a = Optional.of(value);
		// System.out.println(a.orElseThrow(() -> new
		// MethodNotFoundException()));

		Item bean = Item.builder().name("FRED").build();
		Optional msg = showMsg(bean);
		msg.ifPresent(consumer -> System.out.println(consumer));

		
		filter("aa");
	}

	public static Optional<String> showMsg(Item bean) {
		Optional<Item> item = Optional.ofNullable(bean);
		return Optional.of(
				item.map(i -> i.getName()).map(name -> name.toLowerCase()).orElseThrow(MethodNotFoundException::new));
	}
	
	public static void filter(String name){
		Optional<String> op = Optional.ofNullable(name);
		Optional<String> longName = op.filter((value) -> value.length() > 6);
		System.out.println(longName.orElse("The name is less than 6 characters"));//输出Sanaul
	}

}
