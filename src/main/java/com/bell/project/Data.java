package com.bell.project;

/**
 * Класс для представления ответов из контроллеров
 * @param <T> Тип возвращаемого объекта
 */
public class Data<T> {
    private T data;

    public Data(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}