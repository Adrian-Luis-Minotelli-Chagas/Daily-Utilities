package br.com.dailyutilities.arrays;

import java.util.Random;

public class GetRandomValuesAssociated {

	public static void main(String args[]) {

		String[] redeOrigens = { "0", "3001", "3002", "10011", "10083", "10500", "29991", "29992", "29994", "29995",
				"29996", "29997", "29998", "31200", "31300", "31400", "31500", "32200", "40912", "60998", "61500",
				"61600", "50009", "50006", "50004", "55001", "54001" };

		String[][] redeDestinos = {

				// Group 0
				{ "0", "3331", "3332", "29995", "29994", "31300", "31400", "50011", "50079", "55555", "61600", "77777",
						"88888", "3331", "29991", "29994", "31200", "32200", "61500", "50000", "55000" },

				// Group 3001
				{ "3341", "3331" },

				// Group 3002
				{ "3332", "3341", "3351", "3353" },

				// Group 10011
				{ "99949" },

				// Group 10083
				{ "99979" },

				// Group 10500
				{ "99950", "99951" },

				// Group 29991
				{ "99955" },

				// Group 29992
				{ "99958" },

				// Group 29994
				{ "99964" },

				// Group 29995
				{ "99929", "99977", "99978" },

				// Group 29996
				{ "90952" },

				// Group 29997
				{ "90953" },

				// Group 29998
				{ "99946", "99947", "99948" },

				// Group 31200
				{ "99944", "99945", "99974" },

				// Group 31300
				{ "99944", "99968" },

				// Group 31400
				{ "99943", "99966" },

				// Group 31500
				{ "99943", "99966" },

				// Group 32200
				{ "99986" },

				// Group 40912
				{ "99976" },

				// Group 60998
				{ "90922", "99966", "99988", "99994" },

				// Group 61500
				{ "99941", "99942", "99970", "99971", "99981" },

				// Group 61600
				{ "99941", "99942", "99969", "99970" },

				// Group 50009
				{ "99985" },

				// Group 50006
				{ "99985" },

				// Group 50004
				{ "99985", "99983" },

				// Group 55001
				{ "99974" },

				// Group 54001
				{ "99971", "99970" } 
		};

		for (int x = 0; x < 100; x++) {
			StringBuffer buff = new StringBuffer("");

			int redeOrigemIndex = getRandomIndex(redeOrigens);

			buff.append(fillWithSpaces(redeOrigens[redeOrigemIndex], 8));
			buff.append(getRandomField(redeDestinos[redeOrigemIndex], 8));

			System.out.println(buff.toString());
		}
	}

	private static int getRandomIndex(String[] array) {
		Random r = new Random();

		return r.nextInt(array.length);
	};

	private static String getRandomField(String[] array, int size) {
		Random r = new Random();
		String value = array[r.nextInt(array.length)];
		return fillWithSpaces(value, size);
	};

	private static String fillWithSpaces(String in, int size) {
		String out = in;
		while (out.length() < size) {
			out = out + " ";
		}
		return out;
	}

}
