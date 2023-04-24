import java.util.Scanner;
import java.util.LinkedList;

public class Main2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> l = new LinkedList<>();
        while (true) {
            String com = sc.nextLine().strip();
            String[] command = com.split(" ");
            String[] command2 = com.split("\\+");
            if (command[0].equals("Run")) {
                com = com.replace("Run ", "");
                l.add(com);
                System.out.println(l.getLast());
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
                com = l.get(i);
                l.remove(i);
                l.add(com);
                System.out.println(l.getLast());
            }
            else if (command2[0].equals("Alt") && command2[1].equals("Delete")) {
                int count = command2.length - 1;
                for(int i = 0; i < count; i++){
                    try{
                        l.remove(l.size() - 1);
                        System.out.println(l.getLast());
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
            try {
                System.out.println(l);
            } catch (Exception e) {
                System.out.println("Список приложений пуст");
            }
        }

    }