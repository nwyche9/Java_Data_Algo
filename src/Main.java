public class Main {

    public static void main(String[] args){//bare hashtable

        Employee tchalla = new Employee("Tchalla", "King", 000);
        Employee tony = new Employee("Tony", "Stark", 002);
        Employee bias = new Employee("Offensive", "Bias", 003);
        Employee bruce = new Employee("Bruce", "Banner", 004);
        Employee end = new Employee("Mike", "End", 005);

        Hashtables ht = new Hashtables();

        ht.put("Tchalla",tchalla);
        ht.put("Tony", tony);
        ht.put("Bruce", bruce);
        ht.put("Bias", bias);
        ht.put("Mike", end);

        //ht.printTable();

        System.out.println("Retrieve Tony: " + ht.get("Tony"));
        System.out.println("Retrieve Bias: " + ht.get("Bias"));

        ht.remove("Mike");
        ht.remove("Bias");
        ht.printTable();

    }
}
