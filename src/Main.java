import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        L1List<String> l = new L1List<>();
        Node active = null;
        while (true) {
            String com = sc.nextLine().strip();
            String[] command = com.split(" ");
            String[] command2 = com.split("\\+");
            if (command[0].equals("Run")) {
                com = com.replace("Run ", "");
                active = new Node<>(com);
                l.append(active);
                System.out.println(l.last.value);
            }
            else if (command2[0].equals("Alt") && command2[1].equals("Tab")) {
                int count = command2.length - 1;
                int i = l.size() - 1;
                while (count != 0){
                    if (count ==  i + 1) {
                        i = l.size() - 1;
                        break;
                    }
                    else {
                        count--;
                        i--;
                    }
                }
                String a = String.valueOf(l.get(i).value);
                l.remove(i);
                l.append(new Node<>(a));
                System.out.println(l.last.value);
            }
            else if (command2[0].equals("Alt") && command2[1].equals("Delete")) {
                int count = command2.length - 1;
                for(int i = 0; i < count; i++){
                    try{
                        l.remove(l.size() - 1);
                        System.out.println(l.last.value);
                    }
                    catch (Exception e){
                        System.out.println("Последнее окно закрыто");
                    }
                }
            }
            else if (command[0].equals("q")) {
                break;
            }
        }
        for(int i = 0; i < l.size(); i++) {
            try {
                l.toPrint();
            } catch (Exception e) {
                System.out.println("Список приложений пуст");
            }
        }

    }
}
