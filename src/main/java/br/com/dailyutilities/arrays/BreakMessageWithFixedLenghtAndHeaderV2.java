package br.com.dailyutilities.arrays;

import java.util.ArrayList;

public class BreakMessageWithFixedLenghtAndHeaderV2 {

	// private static final int DEFAULT_LENGHT = 599;
	// private static final String DEFAULT_HEADER = ".0593.";
	private static final int DEFAULT_LENGHT = 605;
	private static final String DEFAULT_HEADER = "0x0205930x03";

	public static void main(String[] args) {
		ArrayList<Object> list_msg = new ArrayList<Object>();
		ArrayList<Object> list_msg_to_show;
		ArrayList<Object> list_msg_to_show2;
		ArrayList<Object> list_msg_to_show3;

		System.out.println("####### INICIO #####\n");

		Object raw_msg_01 = createMessage(1);
		System.out.println("####### Caso 1 - Mensagem com tamanho de: " + raw_msg_01.toString().length()
				+ "(593 caracteres de mensagem + " + (DEFAULT_LENGHT - 593) + " de Header)");
		System.out.println(raw_msg_01.toString());

		list_msg.add(raw_msg_01);

		list_msg_to_show = new ArrayList<Object>();
		for (Object objectItem : list_msg) {

			dividePorHeader(objectItem, list_msg_to_show);
		}

		System.out.println("\n####### Mensagem a ser considerado e persistido");
		for (Object objectItem : list_msg_to_show)
			System.out.println(objectItem);

		System.out.println("\n###################################################################");
		Object raw_msg_02 = createMessage(2);
		System.out.println("\n####### Caso 2 - Mensagem com tamanho de: " + raw_msg_02.toString().length()
				+ "(593 caracteres de mensagem + " + (DEFAULT_LENGHT - 593) + " de Header)");
		System.out.println(raw_msg_02.toString());

		list_msg = new ArrayList<Object>();
		list_msg.add(raw_msg_02);

		list_msg_to_show2 = new ArrayList<Object>();
		for (Object objectItem : list_msg) {

			dividePorHeader(objectItem, list_msg_to_show2);
		}

		System.out.println("\n####### Mensagem a ser considerado e persistido");
		for (Object objectItem : list_msg_to_show2)
			System.out.println(objectItem);

		System.out.println("\n###################################################################");
		Object raw_msg_03 = createMessage(3);
		System.out.println("\n####### Caso 3 - Mensagem com tamanho de: " + raw_msg_03.toString().length()
				+ "(593 caracteres de mensagem + " + (DEFAULT_LENGHT - 593) + " de Header)");
		System.out.println(raw_msg_03.toString());

		list_msg = new ArrayList<Object>();
		list_msg.add(raw_msg_03);

		list_msg_to_show3 = new ArrayList<Object>();
		for (Object objectItem : list_msg) {

			dividePorHeader(objectItem, list_msg_to_show3);
		}

		System.out.println("\n####### Mensagem a ser considerado e persistido");
		for (Object objectItem : list_msg_to_show3)
			System.out.println(objectItem);

	}

	public static Object createMessage(Integer typeMessage) {

		// Mensagem com 2 registro validos e um particionado
		if (typeMessage == 1) {
			return "0x0205930x0313M17  201802050345290130003000   552914******5429000000235631SAMAST02 1517809529031 1517809529034 000003SAMAST02 1517809529067 1517809529067 00000015806600000007319200000023563111160                     D2272844                                        0000000            00         9868409860000000000000000000000000000000000000000000000000000000020180205034529000000000000000000E00000000000000000000000000000000000000000000000000000000000000000000000000000000N00000000000000000000000000000000    000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";

		} // Mensagem com inicio invalido
		else if (typeMessage == 2) {
			return "0000x0205930x0313M17  802050345290130003000   552914******5429000000235631SAMAST02 1517809529031 1517809529034 000003SAMAST02 1517809529067 1517809529067 00000015806600000007319200000023563111160                     D2272844                                        0000000            00         9868409860000000000000000000000000000000000000000000000000000000020180205034529000000000000000000E00000000000000000000000000000000000000000000000000000000000000000000000000000000N00000000000000000000000000000000    000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";

		} else {
			return "0z0205930x0313M17  201802050345290130003000   552914******5429000000235631SAMAST02 1517809529031 1517809529034 000003SAMAST02 1517809529067 1517809529067 00000015806600000007319200000023563111160                     D2272844                                        0000000            00         9868409860000000000000000000000000000000000000000000000000000000020180205034529000000000000000000E00000000000000000000000000000000000000000000000000000000000000000000000000000000N00000000000000000000000000000000    000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
		}

	}

	public static ArrayList<Object> createListWithRawMessage(Object rawObject, int definedAmount) {

		ArrayList<Object> list = new ArrayList<Object>();

		if (rawObject != null) {

			list.add(rawObject);
		}

		return list;
	}

	public static void dividePorHeader(Object line, ArrayList<Object> list) {

		String messageString = line.toString().trim();

		Integer headerIndex = messageString.indexOf(DEFAULT_HEADER);

		if (headerIndex > -1) {

			Integer msg_length = Integer.parseInt(messageString.substring(headerIndex + 4, headerIndex + 8));

			if (msg_length != messageString.substring(headerIndex + 12).length()) {

				System.out.println(
						"\n####### Mensagem desconsiderada, pois o tamanho da mensagem é diferente do denifido no Header:\n"
								+ line);
			} else {
				list.add(messageString.substring(headerIndex, headerIndex + 12 + msg_length));
			}

		} else {
			System.out.println("\n####### Mensagem desconsiderada, pois não possue um Header:\n" + line);

		}
	}

}
