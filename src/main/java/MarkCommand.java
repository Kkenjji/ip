public class MarkCommand extends Command {
    private final int index;

    public MarkCommand(String input) {
        try {
            String[] parts = input.split(" ");
            if (parts.length != 2) {
                throw new InvalidFormatException();
            }
            this.index = Integer.parseInt(parts[1]) - 1;
        } catch (NumberFormatException e) {
            throw new InvalidFormatException();
        }
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        try {
            taskList.markTask(index);
        } catch (InvalidFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
