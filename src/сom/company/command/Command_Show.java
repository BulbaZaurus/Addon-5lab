package сom.company.command;

import сom.company.Ticket;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Command_Show implements Command, Serializable {
    private static final long serialVersionUID = 15L;

    @Override
    public void Execute(TreeSet<Ticket> tickets, Scanner[] in,
                        String savePath, boolean[] isScannerFromSystem, List<String> executed_scripts){
        Iterator<Ticket> iter=tickets.iterator();
        while (iter.hasNext()){
            System.out.println('\n' + iter.next().toString() + '\n');
        }
    }

}
