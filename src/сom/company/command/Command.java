package сom.company.command;

import сom.company.Ticket;

import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public interface Command {
    void Execute(TreeSet<Ticket> tickets, Scanner[] in,
                 String savePath, boolean[] isScannerFromSystem, List<String> executed_scripts);
}
