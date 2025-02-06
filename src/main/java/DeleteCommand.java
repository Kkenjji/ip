public class DeleteCommand extends Command {
    private final int index;
    private boolean toDeleteAll = false;

    public DeleteCommand(String input) {
        try {
            String[] parts = input.split(" ");
            if (parts.length != 2) {
                throw new InvalidFormatException();
            }

            if (parts[1].equals("all")) {
                toDeleteAll = true;
            }
            this.index = Integer.parseInt(parts[1]) - 1;
        } catch (NumberFormatException e) {
            throw new InvalidFormatException();
        }
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        try {
            taskList.deleteTask(index, toDeleteAll);
        } catch (InvalidFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
