package сom.company.command;

import сom.company.Ticket;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Command_Exit implements Command, Serializable {
    private static final long serialVersionUID = 6L;
    boolean force;
    public Command_Exit(boolean force) {
        this.force = force;
    }
    public void Execute(TreeSet<Ticket> tickets, Scanner[] in, String savePath, boolean[] isScannerFromSystem, List<String> executed_scripts){
        if (!this.force) {
            System.out.println("Шо упало то пропало.");
        }

        if (this.force ) {
            System.out.println("Выключаюсь....");
            System.exit(0);
        }
    }

}
