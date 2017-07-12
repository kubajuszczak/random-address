package com.kubajuszczak.randomAddress.Generation;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WordGenerator {

	private static int[][] wordMarkovChain = {{255,13237,18023,9605,6131,2147,8545,1450,6588,318,3053,40559,11450,40044,389,10562,341,31754,16637,42057,5457,3495,1953,1286,2611,1474},
			{8685,1711,390,452,8859,144,87,187,8912,256,36,12411,237,166,6967,206,10,6095,1525,492,4645,141,78,4,596,10},
			{23273,23,2386,53,14904,19,14,19822,11481,0,6525,5088,52,228,24157,42,178,8335,1031,10302,7751,2,20,1,3558,45},
			{8639,358,201,1822,22147,343,1029,479,19348,294,46,3017,619,1424,8317,184,12,5030,2717,145,3435,375,494,2,1779,40},
			{15043,3042,13180,30878,7312,3774,4208,1461,4366,396,695,19587,12725,38434,5476,8610,931,66714,46930,18125,4490,3385,2367,5175,1743,450},
			{3561,49,39,40,5162,3062,24,42,7027,8,12,4104,45,44,5545,29,0,2832,318,1219,3908,2,42,3,943,6},
			{7713,198,34,124,11915,121,2113,2864,8527,12,35,5660,845,2781,4842,69,1,7273,1682,213,3820,5,211,0,2064,12},
			{14065,307,116,138,18798,259,77,112,14800,15,62,1785,904,992,14847,181,12,4080,836,2480,2801,33,409,0,8173,18},
			{20666,4670,35999,14417,13427,6241,7040,420,579,132,2633,15968,8343,60886,22038,7030,500,7287,36502,24854,2242,8371,147,767,91,8384},
			{1378,2,5,9,1057,0,2,8,413,6,4,3,4,16,1028,3,0,11,3,3,1463,1,2,0,7,0},
			{2349,258,58,62,7885,191,36,465,4525,25,132,1194,242,769,1039,140,1,392,1770,258,485,30,299,1,670,3},
			{25052,743,1288,2320,34576,946,853,259,32897,20,901,18756,1399,1085,18943,1458,19,184,2966,3549,6727,1090,304,10,20196,51},
			{19645,4332,101,92,18876,231,37,80,18111,19,36,381,3425,1012,12427,6919,6,123,1851,102,4008,79,92,1,2804,15},
			{18634,1423,13466,15069,32262,3417,29713,1407,22288,522,2202,1794,1606,3949,20423,2539,489,2084,14510,29533,3301,1838,940,108,1749,527},
			{3667,4784,10904,7714,2840,2145,10672,1028,5816,155,1782,18296,17030,47067,7476,14881,329,28810,15626,12894,19518,6396,4375,1995,1060,761},
			{12541,205,142,94,17219,176,73,16764,10292,20,71,7341,224,540,12574,3577,4,14814,3871,4582,3814,8,187,1,1788,1},
			{21,0,0,2,6,1,1,2,18,0,0,2,1,2,4,2,4,6,5,8,5763,2,2,0,1,0},
			{35217,3087,5741,5667,40023,1520,3256,2077,35622,183,1927,2822,6706,4308,31100,3508,147,5752,11857,8440,6071,1730,902,12,7582,119},
			{9273,483,9519,256,20839,485,266,11197,18106,71,1825,3754,7285,2573,8826,8548,1021,281,20859,34122,10456,130,1412,0,3007,20},
			{21117,538,1778,196,44229,748,271,16523,49645,67,69,3471,882,717,21357,395,20,20369,5670,5826,7301,82,1133,7,7364,340},
			{4130,5296,4527,3659,3452,968,2365,105,4152,80,531,14100,8779,27616,1042,5085,41,14228,19837,9310,70,450,30,403,147,280},
			{5020,1,7,9,17745,0,8,1,6761,0,6,19,3,13,2556,3,0,105,26,8,459,44,2,0,134,4},
			{4851,243,71,250,3496,137,50,1459,3643,5,180,615,145,959,3246,103,2,739,719,166,112,2,82,0,160,20},
			{1050,41,613,18,1115,41,13,190,2140,0,2,60,33,13,759,972,13,13,101,1180,285,8,37,10,758,1},
			{2094,475,2270,1489,1694,226,911,210,1441,10,83,3861,2399,2325,1689,3738,5,2038,3655,2194,215,38,311,200,9,222},
			{2438,21,16,21,6290,3,9,15,2309,2,14,265,15,12,1849,16,4,11,15,14,131,9,18,0,442,567}};
	
	private static int[] englishLetterFrequencies = { 8167, 1492, 2782, 4253, 12702, 2228, 2015, 6094, 6966, 153, 772,
			4025, 2406, 6749, 7507, 1929, 95, 5987, 6327, 9056, 2758, 978, 2360, 150, 1974, 74 };
	
	private static String[] streetSuffixes= { "Alley", "Avenue", "Beach", "Bayou", "Bluff", "Bluffs", "Boulevard", "Bridge", "Brook",
			"Camp", "Cape", "Causeway", "Circle", "Cliff", "Corner", "Court", "Cove", "Creek", "Crossing", "Dam",
			"Drive", "Estate", "Expressway", "Falls", "Field", "Ford", "Forest", "Forge", "Freeway", "Garden",
			"Gateway", "Grove", "Harbor", "Haven", "Highway", "Hollow", "Lake", "Meadow", "Mill", "Mills", "Park",
			"Parkway", "Pine", "Plaza", "Point", "Point", "Radial", "Ridge", "River", "Road", "Route", "Run",
			"Shoal", "Shoals", "Shore", "Skyway", "Spring", "Square", "Station", "Street", "Terrace", "Trace",
			"Trail", "Tunnel", "Turnpike", "Valley", "View", "Village", "Walk", "Way" };
	
	private static String[] townSuffixes = { "by", "toft", "worth", "ay", "y", "ey", "bost", "carden",
			"caster", "chester", "cester", "ceter", "cot", "cott", "dale", "dean", "den", "don", "don", "den",
			"field", "firth", "frith", "ham", "hay", "hays", "hayes", "ing", "keth", "cheth", "mouth", "ness",
			"pool", "port", "stead", "ster", "thwaite", "wick", "wich", "wych", "wyke", "wick", "shaw" };
	
	private Random r;
	
	public WordGenerator(){
		r = new Random();
	}
	
	private String getNextLetter(String currentLetter) {
		int[] letterProbabilities = wordMarkovChain[currentLetter.charAt(0) - 97];

		return getLetterFromGivenProbabilities(letterProbabilities);
	}

	private String getLetterFromGivenProbabilities(int[] probabilities) {
		int sum = 0;
		for (int value : probabilities) {
			sum += value;
		}

		int generatedValue = r.nextInt(sum);
		
		for (int i = 0; i < 26; i++) {
			if (probabilities[i] < generatedValue) {	
				generatedValue -= probabilities[i];
			} else {
				return String.valueOf((char) (i + 97));
			}
		}
		return "!";
	}
	
	

	public String generateWord(int length) {
		String currentLetter = getLetterFromGivenProbabilities(englishLetterFrequencies);
		StringBuilder sb = new StringBuilder();

		sb.append(currentLetter.toUpperCase());
		for (int i = 1; i < length; i++) {
			currentLetter = getNextLetter(currentLetter);
			sb.append(currentLetter);
		}
		
		String generatedWord = sb.toString();
		
		// Try again if there are no vowels. 
		// Makes for somewhat more pronounceable names 
		List<String> vowels = Arrays.asList(new String[] { "a", "e", "i", "o", "u" });
		if (vowels.stream().noneMatch(vowel -> generatedWord.contains(vowel))) {
			return generateWord(length);
		} else {
			return sb.toString();
		}
	}
	
	public String generateStreetAddress(){
		String number = String.valueOf(r.nextInt(180) + 1);
		String street = this.generateWord(r.nextInt(5) + 3);
		String suffix = streetSuffixes[r.nextInt(streetSuffixes.length)];
		return number + " " + street + " " + suffix;
	}
	
	public String generateTownName(){
		String town = this.generateWord(r.nextInt(3) + 3);
		String suffix = townSuffixes[r.nextInt(townSuffixes.length)];
		return town + suffix;
	}
}
