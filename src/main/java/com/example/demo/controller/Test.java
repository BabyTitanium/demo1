package com.example.demo.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author     :Lilian
 * @date       :2021/8/17 17:55
 * @description:
 */
public class Test {
	public static void main(String[] args) {
		test3();
	}

	public static void test1(){
		Map<String,Object> map = new HashMap<>();
		map.put("Lilian", "111");
		map.put("Amy","222");
		for(Map.Entry<String,Object> entry : map.entrySet()){
			System.out.println(entry.getKey());
		}
		if(true){
			return;
		}
		System.out.println("test1");
	}

	public static void test2(){
		System.out.println("test2");
	}

	public static void test3(){

	}
}
