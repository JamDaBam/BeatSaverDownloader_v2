package Modules.Parser;

public interface IJsonParser {
    <T> T parse(String aJson, Class<T> aClass);
}
