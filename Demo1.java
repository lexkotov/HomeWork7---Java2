package Lesson7;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ru.geekbrains.qa.java2.lesson7_project.entity.Student student = new ru.geekbrains.qa.java2.lesson7_project.entity.Student("Ivan", 4.87);
        String jsonStudent = objectMapper.writeValueAsString(student);
        System.out.println(jsonStudent);

    }

    private static void simpleWriteJsonToFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ru.geekbrains.qa.java2.lesson7_project.entity.Car car = new ru.geekbrains.qa.java2.lesson7_project.entity.Car("yellow", "Renault Logan");
        objectMapper.writeValue(new File("car.json"), car);
    }

    private static void simpleWriteJsonAsString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        ru.geekbrains.qa.java2.lesson7_project.entity.Car car = new ru.geekbrains.qa.java2.lesson7_project.entity.Car("yellow", "Renault Logan");
        System.out.println(objectMapper.writeValueAsString(car));
    }

    private static void simpleReadJsonFromString() throws JsonProcessingException {
        String jsonString = "{ \"color\" : \"white\", \"type\" : \"Volga\" }";
        ObjectMapper objectMapper = new ObjectMapper();
        ru.geekbrains.qa.java2.lesson7_project.entity.Car car = objectMapper.readValue(jsonString, ru.geekbrains.qa.java2.lesson7_project.entity.Car.class);
        System.out.println(car);
    }

    private static void readObjectWithUnknownProperties() throws com.fasterxml.jackson.core.JsonProcessingException {
        String jsonString = "{ \"color\" : \"white\", \"type\" : \"Volga\", \"year\" :\"1970\" }";
        ObjectMapper objectMapper = new ObjectMapper();
        ru.geekbrains.qa.java2.lesson7_project.entity.Car car = objectMapper.readValue(jsonString, ru.geekbrains.qa.java2.lesson7_project.entity.Car.class);
        System.out.println(car);
    }

    private static void readValuesToList() throws com.fasterxml.jackson.core.JsonProcessingException {
        String carsList = "[{\"color\":\"red\", \"type\":\"BMW\"}," +
                " {\"color\":\"black\", \"type\":\"lada priora\"}]";
        ObjectMapper objectMapper = new ObjectMapper();
        List<ru.geekbrains.qa.java2.lesson7_project.entity.Car> carList = objectMapper.readValue(carsList, new TypeReference<List<ru.geekbrains.qa.java2.lesson7_project.entity.Car>>() {});
        System.out.println(carList);
    }

    private static void navigatingByJsonAsNodeTree() throws JsonProcessingException {
        String jsonString = "{\"name\":\"Ivan\", \"education\": " +
                "{\"school\": \"School #52\", \"university\": " +
                "{\"degree\": \"master\", \"name\": \"MGU\"}}}";

        //нагляднее в консоль
        System.out.println(jsonString);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode universityName = objectMapper.readTree(jsonString).at("/education/university/name");
        System.out.println(universityName.asText());
    }

    private static void useJsonCreatorAnnotation() throws JsonProcessingException {
        String jsonPerson = "{ \"age\" : 30, \"firstName\" : \"Vsevolod\" }";
        ObjectMapper objectMapper = new ObjectMapper();
        ru.geekbrains.qa.java2.lesson7_project.entity.Person p = objectMapper.readValue(jsonPerson, ru.geekbrains.qa.java2.lesson7_project.entity.Person.class);
        System.out.println(p);
    }
}
