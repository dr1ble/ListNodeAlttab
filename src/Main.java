import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        L1List <String> l = new L1List<>();
        Node active = null;
        while (true) {
            String com = sc.nextLine().strip();
            String[] command = com.split(" ");
            String[] command2 = com.split("\\+");
            if (command[0].equals("Run")) {
                com = com.replace("Run ", "");
                active = new Node<>(com);
                l.append(active);
            } 
            else if (command2[0].equals("Alt") && command2[1].equals("Tab")) {
                int count = command2.length - 1;
                for (int i = 0; i < count; i++) {
                    l.remove(count % l.size() - 1);
                }
            } 
            else if (command2[0].equals("Alt") && command2[1].equals("Delete")) {
                int count = command2.length - 1;
                for (int i = 0; i < count; i++) {
                    l.removeFirst();
                }
            } else if (command[0].equals("q")) {
                break;
            }
            l.toPrint();
        }
    }
}
