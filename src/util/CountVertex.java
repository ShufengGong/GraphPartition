package util;

import gnu.trove.set.hash.THashSet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountVertex {

	public static void main(String[] args) throws IOException {
		String input = "/home/gongsf/program/dynamicSchedule/dataSet/roadNet/vertex.txt";

		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-in")) {
				input = args[++i];
			}
		}

		int maxValue = -1;
		int minValue = Integer.MAX_VALUE;
		int src = 0;
		int dst = 0;
		String line = null;
		BufferedReader br = new BufferedReader(new FileReader(input));
		while ((line = br.readLine()) != null) {
			if (!line.startsWith("#")) {
				String[] ss = line.split("\\s+");
				// src = Integer.parseInt(ss[0]);
				// dst = Integer.parseInt(ss[1]);
				for (String s : ss) {
					int value = Integer.parseInt(s);
					if(value < 0){
						System.out.println(line);
					}
					if (maxValue < value) {
						maxValue = value;
					}
					if (minValue > value) {
						minValue = value;
					}
				}
			}
		}
		br.close();
		System.out.println("minValue : " + minValue);
		System.out.println("maxValue : " + maxValue);
		System.out.println("vertex : " + (maxValue - (minValue - 1)));
	}

}
