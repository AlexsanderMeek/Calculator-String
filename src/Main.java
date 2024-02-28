import java.util.Scanner;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Добро пожаловать в словесный калькулятор!");
        System.out.print("Введите выражение (Например: a + b, a - b, и т.д.): ");
        // Получаем выражение от пользователя и передаём в переменную "num"
        String word = scan.nextLine();
        String x = word.replaceAll(" ", "");
        String[] oper = x.split("[+\\-*/]");
        String oper2 = x.replaceAll("\\w+", "");
        String edoper2 = oper2.replace("\"","");


        if (oper.length < 2) {
            throw new IllegalStateException("Не подходит по требования двух операндам");
        } else if (oper.length > 2) {
            throw new IllegalStateException("Формат выражения не удовлетворяет заданию - два операнда и один оператор (+, -, /, *);");
        }
        boolean quotes;
        boolean quotes1;

        //проверка ковычек
        if (oper[0].contains("\"")){
            quotes = true;
        }
        else{
            quotes = false;
        }

        //проверка ковычек
        if (oper[1].contains("\"")){
            quotes1 = true;
        }
        else{
            quotes1 = false;
        }



        String[] keys = new String[999];
        for (int i = 0; i < keys.length; i++) {
            keys[i] = String.valueOf(i + 1);
        }

        if (quotes && quotes1){
            CalcString calcString = new CalcString();
            calcString.operation1(oper,edoper2);


        }
        else if (!quotes && quotes1) {
            throw new IllegalStateException("В данном калькуляторе первым не может идти число" +
                    " ИЛИ используйте кавычки для обозначений строк.\n" +
                    "Пример правильного выражения: (\"ABC\" + \"ABC\") или (\"ABC\" * 3);");

        }
        else if (!quotes && !quotes1) {
            throw new IllegalStateException("Калькулятор на предусмотрен для цифровых выражений ИЛИ используйте кавычки для строк; \n" +
                    "Используйте цифровой калькулятор: https://github.com/AlexsanderMeek/Calculator ");

        }
        else if (quotes && !quotes1) {
            CalcSN calcSN = new CalcSN();
            calcSN.operation2(oper,edoper2);

        }
        else {
            throw new IllegalStateException("Вы ввели неизвестное выражение. \n Пример правильного выражения: (\\\"ABC\\\" + \\\"ABC\\\") или (\\\"ABC\\\" * 3); ");
        }


    }

}

class CalcString{
    void operation1(String[] oper, String edoper2 ){
        String s = oper[0].replace("\"","");
        String s2 = oper[1].replace("\"","");

        if (edoper2.equals("+")){
            System.out.println("\"" + s+s2 + "\"");
        }
        else if (edoper2.equals("-")) {
            String result = s.replace(s2,"");
            System.out.println(result);

        }
        else if (edoper2.equals("*")) {
            throw new IllegalStateException("Это невозможно выполнить;");

        }
        else if (edoper2.equals("/")) {
            throw new IllegalStateException("Это невозможно выполнить;");
        }


    }

}


class CalcSN{
    void operation2(String[] oper, String edoper2 ){
        String s = oper[0].replace("\"","");
        String s2 = oper[1].replace("\"","");
        int num = Integer.parseInt(s2);

        if (edoper2.equals("+")){
            throw new IllegalStateException("Это невозможно выполнить;");
        }
        else if (edoper2.equals("-")) {
            throw new IllegalStateException("Это невозможно выполнить;");

        }
        else if (edoper2.equals("*")) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < num; i++){
                sb.append(s);
            }
            String result = sb.toString();
            System.out.println(result);


        }
        else if (edoper2.equals("/")) {
            String result = s.substring(0, s.length() - num);
            System.out.println(result);


        }


    }

}