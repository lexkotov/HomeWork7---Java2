package ru.geekbrains.qa.java2.lesson7_project.project;

import ru.geekbrains.qa.java2.lesson7_project.project.enums.Periods;

import java.io.IOException;

public interface WeatherProvider {

    public void getWeather(Periods period) throws IOException;
}
