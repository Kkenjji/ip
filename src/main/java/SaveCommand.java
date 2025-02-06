public class SaveCommand extends Command {
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        storage.saveTasks(taskList);
    }
}
