package com.kubajuszczak.randomAddress.Generation;

import java.util.Random;

public class AppWordGenerator {

	public static String[] counties = { "Bedfordshire", "Berkshire", "Buckinghamshire", "Cambridgeshire", "Cheshire",
			"Cornwall", "Cumbria", "Derbyshire", "Devon", "Dorset", "Durham ", "East Sussex", "Essex",
			"Gloucestershire", "Greater Manchester", "Hampshire", "Herefordshire", "Hertfordshire", "Isle of Wight",
			"Kent", "Lancashire", "Leicestershire", "Lincolnshire", "Merseyside", "Norfolk", "Northamptonshire",
			"Northumberland", "North Yorkshire", "Nottinghamshire", "Oxfordshire", "Rutland", "Shropshire", "Somerset",
			"South Yorkshire", "Staffordshire", "Suffolk", "Surrey", "Tyne and Wear", "Warwickshire", "West Midlands",
			"West Sussex", "West Yorkshire", "Wiltshire", "Worcestershire", "East Riding of Yorkshire" };

	private static WordGenerator wg = new WordGenerator();

	public static void generateAddresses(int count) {
		Random r = new Random();
		for (int i = 0; i < count; i++) {

			String street = wg.generateStreetAddress();

			String town = wg.generateTownName();

			String county = counties[r.nextInt(counties.length)];

			System.out.println(String.format("%s, %s, %s", street, town, county));
		}
	}

	public static void main(String[] args) {
		generateAddresses(15);
	}

}
