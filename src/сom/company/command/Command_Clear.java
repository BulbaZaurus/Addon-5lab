package сom.company.command;

import сom.company.Ticket;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Command_Clear implements Command, Serializable {
    private static final long serialVersionUID = 4L;
    public Command_Clear() {
    }
    public void Execute(TreeSet<Ticket> tickets, Scanner[] in, String savePath, boolean[] isScannerFromSystem, List<String> executed_scripts) {
        tickets.clear();
        System.out.println("All organizations have been removed.");
    }
}
