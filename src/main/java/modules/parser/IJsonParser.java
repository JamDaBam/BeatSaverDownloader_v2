package modules.parser;

public interface IJsonParser {
    <T> T parse(String aJson, Class<T> aClass);

    <T> T[] parse(String[] aJson, Class<T> aClass);
}
