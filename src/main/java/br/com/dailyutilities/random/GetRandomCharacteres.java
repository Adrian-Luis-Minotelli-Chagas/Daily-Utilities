package br.com.dailyutilities.random;

import java.util.Random;

public class GetRandomCharacteres {

	private static final String HEX_SPC = "0x020";

	private static final String HEX_ETX = "0x03";

	public static final int LAYOUT_MAX_LENGTH = 593;

	public static String getRandomSimpleCharactersGroup() {

		String[] characters = { "a", "S", "H", "7", "n", "N", "E", "0", "r", "V", "b", "A", "e", "j", "Y", "i", // " ",
				"w", "m", "K", "1", "O", "x", "v", "D", "M", "6", "5", "u", "l", "c", "J", "8", "d", "t", "C", "4", "k",
				"G", "s", "f", "T", "R", "P", "Q", "h", "W", "I", "z", "9", "U", "y", "2", "o", "L", "g", "F", "B", "3",
				"q", "Z", "p" };

		Random r = new Random();
		return characters[r.nextInt(characters.length)];
	}

	public static Object createRandomMessage(Integer rowNumber) {

		Integer lineSize = 0;

		int tamanhoFixo = HEX_SPC.length() + HEX_ETX.length() + 3;

		Random r = new Random();

		StringBuilder message = new StringBuilder();

		do {

			lineSize = r.nextInt(LAYOUT_MAX_LENGTH) + tamanhoFixo + 1; // gera um tanho para a msg
																		// adiciona tamanho dos delimitadores + tamanho
																		// da
																		// msg

			String messageSize = lineSize.toString();

			// garante que tamanho da mensagem tenha 3 digitos
			while (messageSize.length() < 3) {
				messageSize = "0" + messageSize;
			}

			message.append(HEX_SPC);
			message.append(messageSize);
			message.append(HEX_ETX);

			for (int x = tamanhoFixo; x < lineSize; x++) {

				message.append(GetRandomCharacteres.getRandomSimpleCharactersGroup());
			}

			rowNumber--;

		} while (rowNumber > 0);

		// System.out.println(message);

		return message;
	}

}
