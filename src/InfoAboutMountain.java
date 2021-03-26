import java.net.SocketOption;
import java.util.Scanner;
class Mountain{
    String name,cord;
    double square;
}
public class InfoAboutMountain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.println("Введите количество гор");
        int n = sc.nextInt(); //Количество стран
        Mountain countr[] = new Mountain[n];
        System.out.println("Введите информацию о странах");
        for (int i = 0; i < countr.length; i++) {
            sc.nextLine(); //Очистка буфера
            countr[i] = new Mountain();
            System.out.println("Название" + (i + 1) + "-й горы =>");
            countr[i].name = sc.nextLine();
            System.out.println("Место расположения" + (i + 1) + "-й горы =>");
            countr[i].cord = sc.nextLine();
            System.out.println("Высота" + (i + 1) + "-й горы =>");
            countr[i].square = sc.nextDouble();

        }
        sc.nextLine();
        System.out.println("\nХарактеристики гор:");
        for (int i = 0; i < countr.length; i++) {
            System.out.println("" + countr[i].name + "\t" + countr[i].cord + "\t" + countr[i].square + "м");
        }
        int nommax = 0; //Номер элемента для страны с максимальной площадью
        double max = countr[nommax].square;
        for (int i = 0; i < countr.length; i++)
            if (countr[i].square > max) {
                max = countr[i].square;
                nommax = i;
            }
        System.out.println("\nСамая высокая гора");
        System.out.println("" + countr[nommax].name + "\t" + countr[nommax].cord + "\t" + countr[nommax].square + "м");
        for (int i = 0; i < countr.length - 1; i++)
            for (i = 0; i < countr.length - 1 - i; i++) {
                if (countr[i].square > countr[i + 1].square) {
                    Mountain rab = countr[i]; //rab - рабочая переменная для перестановки
                    countr[i] = countr[i + 1];
                    countr[i + 1] = rab;
                }
                double s = 1000; //Суммарная площадь
                for (i = 0; i < countr.length; i++) ;
                double sr = s;
                System.out.println("\nГоры высотой выше 1000м");
                for (i = 0; i < countr.length; i++) {
                    if (countr[i].square > sr)
                        System.out.println("" + countr[i].name + "\t" + countr[i].cord + "\t" + countr[i].square + "м");
                }
                System.out.println("\nОтсортированный список по высоте");//
                for (i = 0; i < countr.length; i++) {
                    System.out.println("" + countr[i].name + "\t" + countr[i].cord + "\t" + countr[i].square + "м");
                }
                System.out.println("Type searchName");
                String nameSearch = sc.nextLine();
                int nomS = -1;
                for (i = 0; i < countr.length; i++) {
                    if (countr[i].name.equals(nameSearch)) {
                        nomS = 1;
                    }
                }

                if (nomS != -1) {
                    System.out.println("Введите индекс поля");
                    System.out.println("name, location, high");
                    String strPole = sc.nextLine();
                    switch (strPole) {
                        case "name": {
                            System.out.println("Введите новое имя");
                            String newName = sc.nextLine();
                            countr[nomS].name = newName;
                            break;
                        }
                        case "location": {
                            System.out.println("Введите новое место");
                            String newCord = sc.nextLine();
                            countr[nomS].cord = newCord;
                            break;
                        }
                        case "high": {
                            System.out.println("Введите новую высоту");
                            double newSquare = sc.nextDouble();
                            countr[nomS].square = newSquare;
                            break;

                        }
                        default: {
                            System.out.println("Поля с таким индексом не существуют");
                        }
                    }
                    System.out.println("Отредактированный вариант");
                    System.out.println("" + countr[nomS].name + "\t" + countr[nomS].cord + "\t" + countr[nomS].square + "м");
                } else {
                    System.out.println("Ничего не найдено");
                }
            }
    }
}






