package сom.company.command;


import сom.company.Ticket;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Command_Update_id implements Command, Serializable {
    private static final long serialVersionUID = 16L;
    public long id;
    Ticket newticket;

    public  Command_Update_id(long id){
        this.id=id;
    }
    @Override
    public void Execute(TreeSet<Ticket> tickets, Scanner[] in, String savePath,
                        boolean[] isScannerFromSystem, List<String> executed_scripts){
        try {
            boolean found=false;

            found = tickets.removeIf((i) -> {
                return i.id == id;
            });
            if(found) {
                Ticket org = newticket;
                org.id = id;
                tickets.add(org);
                System.out.println("Успешно обновлен эллемент = " + id + ".");
            }else{
                System.out.println("Эллемент с данным id не найден");
            }
        } catch (Exception e) {
            System.out.println("Ошибка....");
        }

    }
    public void Prepare(){
        newticket=Ticket.TicketBuilder();
    }
}
