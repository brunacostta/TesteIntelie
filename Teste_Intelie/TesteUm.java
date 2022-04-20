import java.util.ArrayList;
import java.util.List;

public class TesteUm {
    public static void main(String[] args) {

        Facts d1 = new Facts("gabriel", "endereço", "av rio branco, 109", true);
        Facts d2 = new Facts("joão", "endereço", "rua alice, 10", true);
        Facts d3 = new Facts("joão", "endereço", "rua bob, 88", true);
        Facts d4 = new Facts("joão", "telefone", "234-5678", true);
        Facts d5 = new Facts("joão", "telefone", "91234-5555", true);
        Facts d6 = new Facts("joão", "telefone", "234-5678", false);
        Facts d7 = new Facts("gabriel", "telefone", "98888-1111", true);
        Facts d8 = new Facts("gabriel", "telefone", "56789-1010", true);

        Schema s1 = new Schema("endereço", "cardinality", "one");
        Schema s2 = new Schema("telefone", "cardinality", "many");

        List<Facts> facts = new ArrayList<Facts>();
        facts.add(d1);
        facts.add(d2);
        facts.add(d3);
        facts.add(d4);
        facts.add(d5);
        facts.add(d6);
        facts.add(d7);
        facts.add(d8);

        List<Schema> schema = new ArrayList<Schema>();
        schema.add(s1);
        schema.add(s2);

        filter(facts, schema);
    }

    private static void filter(List<Facts> list, List<Schema> schema) {
        List<Facts> lista = new ArrayList<Facts>();

        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getActive()) {
                continue;
            }

            if (list.get(i).getItem() == schema.get(1).getItem()) {
                lista.add(list.get(i));
            }

            if (list.get(i).getItem() == schema.get(0).getItem()) {
                if (lista.size() == 0) {
                    lista.add(list.get(i));
                    continue;
                }

                boolean test = true;
                for (int j = 0; j < lista.size(); j++) {
                    if (lista.get(j).getItem() == list.get(i).getItem()
                            && lista.get(j).getName() == list.get(i).getName()) {
                        test = false;
                        lista.set(j, list.get(i));
                        continue;
                    }
                }

                if (test) {
                    lista.add(list.get(i));
                }
            }

        }
        for (Facts facts : lista) {
            System.out.println(
                    "('" + facts.getName() + "'," + " '" + facts.getItem() + "'," + " '" + facts.getValue() + "', "
                            + facts.getActive() + ")");
        }
    }

}