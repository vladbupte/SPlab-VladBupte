
package ro.uvt.dp.commands;

public class CommandExecutor {
    public static <R> R run(Command<R> c) throws Exception {
        return c.execute();
    }
}
