import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        if (eh_anterior()){
            System.out.println("A primeira data eh anterior");
        }else {
            System.out.println(" A primeira data não eh anterior");
        }

    }

    public static boolean eh_anterior() {

        Scanner scanner = new Scanner(System.in);

        // Especifica o formato que a data deve ter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate date = null;
        LocalDate date2 = null;

        do {
            System.out.println("Entre com a data 1 no formato dd/MM/yyyy\n" +
                    "Lebre-se de digitar as barras com os números");
            String apt = scanner.nextLine();

            System.out.println("Entre com a data 2 no formato dd/MM/yyyy");
            String imput = scanner.nextLine();
            try {
                date = LocalDate.parse(apt, formatter); // analisar a entrada do usuário como uma data usando LocalDate.parse()
                date2 = LocalDate.parse(imput, formatter);

            } catch (NumberFormatException | DateTimeParseException e) {
                //Lança exceções de números invalidos e formato de data incorretos
                System.err.println("Data inválida!");
            }
        } while (date == null && date2 == null);

        scanner.close();

        assert date != null;
        assert date2 != null;
        return date.isBefore(date2);
        // compará se a primeira data e anterior a segunda.
    }

    
    
}