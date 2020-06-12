package сom.company.command;


import сom.company.Ticket;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Command_Info implements  Serializable,Command {
    private  static  final  long serialVersionUID = 10L;

    @Override
    public void Execute(TreeSet<Ticket> tickets, Scanner[] in,
                        String savePath, boolean[] isScannerFromSystem, List<String> executed_scripts){
        LocalDateTime dateTime = null;
        System.out.println("Тип: TreeSet \n" +
                "Количество элементов: " + tickets.size() );
    }
    }


