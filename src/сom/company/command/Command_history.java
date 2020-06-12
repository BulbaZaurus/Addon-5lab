package сom.company.command;

import сom.company.Archive;
import сom.company.Ticket;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Command_history implements Command, Serializable {
    private  static  final  long serialVersionUID = 17L;
    public Command_history(){

    }
    @Override
    public void Execute(TreeSet<Ticket> tickets, Scanner[] in,
                        String savePath, boolean[] isScannerFromSystem, List<String> executed_scripts){
        System.out.println("Последнии введеные пользователем комманды: ");
        Archive.add("history");
        Archive.write();
    }
}
