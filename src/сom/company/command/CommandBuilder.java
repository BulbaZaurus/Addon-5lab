package сom.company.command;

import сom.company.Archive;
import сom.company.Ticket;

public class CommandBuilder {
    public static Command Build(String input) {
        String[] args = input.split(" ");
        switch (args[0]) {
            case ("help"):
                Archive.add("help");
                return new Command_Help();
            case ("info"):
                Archive.add("info");
                return new Command_Info();
            case ("show"):
                Archive.add("show");
                return new Command_Show();
            case "history":
                return  new Command_history();
            case ("add"):
                Archive.add("add");
                return new Command_Add(Ticket.TicketBuilder());
            case ("update_id"):
                Archive.add("update_id");
                if (args.length == 2) {
                    try {
                       return new Command_Update_id(Long.parseLong(args[1]));
                    } catch (NumberFormatException e) {
                        System.out.println(args[1] + " Воу воу палехче.Слишком большой ");
                    } catch (Exception var8) {
                        System.out.println("Эксепшон");
                    }
                } else {
                    System.out.println("Ожидался аргумент " + (args.length - 1));

                }
                break;
            case ("remove_by_id"):
                Archive.add("remove_by_id");
                if (args.length == 2) {
                    try {
                        return new Command_Remove_by_id(Long.parseLong(args[1]));
                    } catch (NumberFormatException var5) {
                        System.out.println(args[1] + " Воу воу палехче.Слишком большой");
                    } catch (Exception var6) {
                        System.out.println("Эксепшон");
                    }
                } else {
                    System.out.println("Ожидался аргумент " + (args.length - 1));
                    System.out.println("id необходим");
                }
                break;

            case ("clear"):
                Archive.add("clear");
                return new Command_Clear();
            case ("save"):
                Archive.add("save");
                return new Command_Save();
            case ("execute_script"):
                Archive.add("execute_script");
                if (args.length == 2) {
                    try {
                        return new Command_Execute_script(args[1]);
                    } catch (Exception e) {
                        System.out.println("Ошибка выполнения : " + e.getMessage());
                    }
                } else {
                    System.out.println("Ожидался 1 аргумент ,но найдено " + (args.length - 1));
                    System.out.println("Необходим путь файла ");
                }
                break;
            case ("exit"):
                Archive.add("exit");
                return new Command_Exit(true);
            case ("add_if_max"):
                Archive.add("add_if_max");
                return new Command_Add_if_Max(Ticket.TicketBuilder());

            case ("remove_greater"):
                Archive.add("remove_greater");
                return new Command_Remove_greater(Ticket.TicketBuilder());
            case ("print_field_descending_comment") :
                Archive.add("print_field_descending_comment");
                return new Command_PrintComment();
            case ("print_field_descending_price"):
                Archive.add("print_field_descending_price");
                return  new Command_PrintPrice();
            case "filter_less_than_event":
                Archive.add("filter_less_than_event");
                if(args.length==2){
                    try {
                        return new Command_filter_less_than_event(Long.parseLong(args[1]));
                    }catch (NumberFormatException var5) {
                        System.out.println(args[1] + " Воу воу палехче.Слишком большой");
                    } catch (Exception var6) {
                        System.out.println("Эксепшон");
                    }
                }else
                    System.out.println("Ожидался 1 аргумент ,но найдено " + (args.length - 1));


            default:
                Archive.add(args[0]);
                System.out.println("Неизвестная комманда: " + args[0]);
                System.out.println("Напишите help для помощи");
                break;
        }
        return null;
    }
}

