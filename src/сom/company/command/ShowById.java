package сom.company.command;

import сom.company.Ticket;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class ShowById implements  Command, Serializable {
    private static final long serialVersionUID = 1516767656987L;
    public long id;
    public ShowById (long id){
        this.id=id;
    }
    @Override
    public void Execute(TreeSet<Ticket> tickets, Scanner[] in, String savePath,
                        boolean[] isScannerFromSystem, List<String> executed_scripts){
        for(Ticket ticket:tickets){
            if(ticket.id==id){
                System.out.println("---------");
                System.out.println(Ticket.TicketToString(ticket,true));
            }
        }

    }
}
