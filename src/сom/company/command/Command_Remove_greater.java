package сom.company.command;

import сom.company.Ticket;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Command_Remove_greater implements Command, Serializable {
    private static final long serialVersionUID = 13L;
    Ticket element;
    public Command_Remove_greater(Ticket ticket){
        element=ticket;
    }

    @Override
    public void Execute(TreeSet<Ticket> tickets, Scanner[] in,
                        String savePath, boolean[] isScannerFromSystem, List<String> executed_scripts){
        try {
            if (tickets.size() != 0) {
                boolean found = tickets.removeIf(x -> x.getPrice() > element.getPrice());
                if (found) {
                    System.out.println("Билеты с ценой больше чем  " + element.getPrice() + " были удалены ");
                } else {
                    System.out.println("Билеты с данными параметрами не найдены");
                }
                System.out.println("Йапи");
            } else {
                System.out.println("Коллекция пустая.Добавь элемент ,а потом уже поговорим.");
            }
        } catch (Exception e) {
            System.out.println("ЭКСЕПШОН");
        }
    }
}
