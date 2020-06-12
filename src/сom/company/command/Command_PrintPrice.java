package сom.company.command;

import сom.company.Ticket;

import java.io.Serializable;
import java.util.*;

public class Command_PrintPrice  implements Command, Serializable {
    private static final long serialVersionUID = 11L;
    String[] args;
    public Command_PrintPrice() {

    }

    @Override
    public void Execute(TreeSet<Ticket> tickets, Scanner[] in,
                        String savePath, boolean[] isScannerFromSystem, List<String> executed_scripts){
        if(tickets.size()!=0){
            NavigableSet<Ticket> treereverse=tickets.descendingSet();
            Iterator<Ticket> iterator=treereverse.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next().print_Price() );
            }

        }else
            System.out.println("Коллекция пустая на данный момент.Добавь эллемент и попробуй снова");
    }
}
