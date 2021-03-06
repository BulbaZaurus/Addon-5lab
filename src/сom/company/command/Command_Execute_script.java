package сom.company.command;

import сom.company.Ticket;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Command_Execute_script implements Command, Serializable {
    private static final long serialVersionUID = 5L;
    public String file_path;

    public Command_Execute_script(String file_path) {
        this.file_path = file_path;
    }

    public void Execute(TreeSet<Ticket> tickets, Scanner[] in, String savePath, boolean[] isScannerFromSystem, List<String> executed_scripts){
        try {
            Scanner scanner = new Scanner(new File(file_path));
            System.out.println(isScannerFromSystem);
            if (isScannerFromSystem[0]) {
                executed_scripts.add(this.file_path);
                in[0] = scanner;
            } else {
                ArrayList st = new ArrayList();
                while(in[0].hasNext()) {
                    st.add(in[0].nextLine());
                }
                in[0] = scanner;
                isScannerFromSystem[0] = false;
                ArrayList st1 = new ArrayList();

                while(true) {
                    if (!in[0].hasNext()) {
                        st1.addAll(st);
                        String input = String.join("\n", st1);
                        in[0] = new Scanner(input);
                        break;
                    }
                    st1.add(in[0].nextLine());
                }
            }

            isScannerFromSystem[0] = false;
        } catch (FileNotFoundException var10) {
            System.out.println("File not found error: " + var10.getMessage());
        }

    }
    }

