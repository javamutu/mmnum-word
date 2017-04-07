package com.mutu.ntw.mm;

import java.util.Formatter;

public class TestCase {
	public static String escapeUnicode(String input) {
		StringBuilder b = new StringBuilder(input.length());
		Formatter f = new Formatter(b);
		for (char c : input.toCharArray()) {
			if (c < 128) {
				b.append(c);
			} else {
				f.format("\\u%04x", (int) c);
			}
		}
		return b.toString();
	}

	public static void main(String[] args) {
		String st = "9,000,101".replaceAll("[^\\d.]+", "");
		Double value = Double.valueOf(st);
		AbstractMynNumConvertor convertor = new DefaultConvertor();
		String mmWord = convertor.getName(value);
		
		/*
		 To check the output 
		 Go -> https://www.percederberg.net/tools/text_converter.html
		 Convert the out ascii code of mmWord.
		 */
		 String assciiOutput = escapeUnicode(mmWord);
		 System.out.println(assciiOutput);
	}
}
