package helper;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class fakerClass {
    Faker faker = new Faker();

    public String firstName() {
        return faker.name().firstName();
    }
    public String lastName() {
        return faker.name().lastName();
    }
    public String phoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }
    public String eMail(){
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        String email = fakeValuesService.bothify("????##@gmail.com");
        return email;
    }

}
