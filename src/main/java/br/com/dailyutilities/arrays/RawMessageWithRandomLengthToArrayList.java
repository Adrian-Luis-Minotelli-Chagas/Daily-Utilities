package br.com.dailyutilities.arrays;

import java.util.ArrayList;
import br.com.dailyutilities.random.GetRandomCharacteres;

public class RawMessageWithRandomLengthToArrayList {

	public static void main(String[] args) {

		// ConvertFromBases.convertBase16ToBase10("03");

		Object rawMessage = GetRandomCharacteres.createRandomMessage(10);

		ArrayList<Object> list = new ArrayList<Object>();
		Integer index = 0;
		String messageString = rawMessage.toString();
		Integer messageLength = messageString.length();

		Integer layout_lenght = 0;

		while (index < messageLength) {

			layout_lenght = Integer.parseInt(messageString.substring(index + 5, index + 5 + 3)); // obtem o tamanho
																									// total do registro

			list.add(messageString.substring(index, Math.min(index + layout_lenght, messageLength)));

			index += layout_lenght;
		}
		
		String l = ".0593.13M00  201711200057433671909586                   -00100000000SAMAST02 1511146662775 1511146662776 000001N        0000000000000000000000000000000000808464000000000000000000000000                                                                          0000123                       8221230000000000000000000000000000000000000000000000000000000000020171120005742000000000000000000E00000000000000000000000000000000000000000000000000000000000000000000000000000000N00000000000000000000000000000000    000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
		
		System.out.println(l.length());

		// outputs
		System.out.println("####### Mensagem Bruta: ");
		System.out.println(rawMessage);
		System.out.println("");

		System.out.println("####### Mensagem Particionada COM pré-fixo de identificação do tamanho: ");
		for (Object obj : list) {
			System.out.println(obj);
		}

		System.out.println("");

		System.out.println("####### Mensagem Particionada SEM pré-fixo de identificação do tamanho: ");
		for (Object obj : list) {
			System.out.println(obj.toString().substring(12, obj.toString().length()));
		}

		System.out.println("");

		System.out.println("####### Mensagem Particionada sub-dividida em ");
		System.out.println("SPC	Tam.	ETX	MSG:");
		for (Object obj : list) {

			String text = obj.toString();

			System.out.println(text.substring(0, 5) + "	" + text.substring(5, 8) + "	" + text.substring(8, 12)
					+ "	" + text.substring(12));
		}

	}

}
