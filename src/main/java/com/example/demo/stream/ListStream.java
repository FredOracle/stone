package com.example.demo.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.interview.JudgeDataInArray;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ListStream {

	public static void main(String[] args) {
		generaterItems().stream()
				.filter(item -> item.getSex().equals("male"))
				.map(item -> item.getName())
				.collect(Collectors.toList())
				.stream()
				.filter(str -> str.matches("^[a-zA-Z]*"))
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList())
				.forEach(System.out::println);

		System.out.println("============================");
		
		
		generaterList().stream()
			.filter(str -> str.matches("^[0-9]*"))
			.collect(Collectors.toList())
			.forEach(System.out::println);


		int[][] array = {{1,2,8,9}, {2,4,9,12},{4,7,10,13},{6,8,11,15}};
		boolean result = ListStream.find(27,array);
		System.out.println(result);
		
		
	}

	private static List<String> generaterList() {
		return Arrays.asList("12,1222,23,aaaa,1211,2333,abc,43".split(","));
	}

	private static List<Item> generaterItems(){
		return Arrays.asList(
				Item.builder().id("1").name("a").sex("male").build(),
				Item.builder().id("2").name("b").sex("female").build(),
				Item.builder().id("20").name("999").sex("female").build(),
				Item.builder().id("29").name("12").sex("male").build(),
				Item.builder().id("32").name("db").sex("male").build(),
				Item.builder().id("3").name("c").sex("female").build());
	}

	private static boolean find(int target, int[][] array) {
		return Arrays.stream(array).anyMatch(arr -> Arrays.stream(arr).anyMatch(item -> item == target));
	}

}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
class Item
{
	private String id;
	
	private String name;
	
	private String sex;
}
