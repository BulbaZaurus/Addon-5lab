package сom.company.command;

import сom.company.Ticket;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Command_Add implements Command, Serializable {
    private static final long serialVersionUID = 1L;
    Ticket element;
    public Command_Add(Ticket ticket){element=ticket;}

    @Override
    public void Execute(TreeSet<Ticket> tickets, Scanner[] in,
                        String savePath, boolean[] isScannerFromSystem, List<String> executed_scripts){
        System.out.println("Добавляю элементы в суп");
        try {
            tickets.add(element);
            System.out.println("Элемент успешно добавлен");
        }catch (Exception e){
            System.out.println("Здрасте,а тут экшепшон");
        }
    }
}
