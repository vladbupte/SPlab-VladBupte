
package ro.uvt.dp.commands;

public interface Command<R> {
    R execute() throws Exception;
}
