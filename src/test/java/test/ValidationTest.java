package test;

import data.DataGenerator;
import lombok.val;
import org.junit.jupiter.api.*;
import page.AccountPage;
import page.LoginPage;
import page.VerifiyPage;

import java.sql.DriverManager;
import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ValidationTest {


    @Test
    @Order(1)
     void shouldCorrectedUserRegistered() throws SQLException {
        DataGenerator.insertFakeUser();
        open("http://localhost:9999");
        LoginPage loginPage = new LoginPage();
        VerifiyPage verifiyPage = loginPage.validLogin(DataGenerator.getLoginUser(), DataGenerator.getPasswordUser());
        AccountPage accountPage = verifiyPage.validVerify(DataGenerator.getVerificationCode());
        accountPage.checkIfVisible();

    }

    @Test
    @Order(2)
    void shouldEnteredInvalidLogin() {
        open("http://localhost:9999");
        LoginPage loginPage = new LoginPage();
        loginPage.invalidLogin();

    }



    @Test
    @Order(3)
    void shouldEnteredInvalidPassword() {
        open("http://localhost:9999");
        LoginPage loginPage = new LoginPage();
        loginPage.invalidPassword();

    }



    @Test
    @Order(4)
    void shouldEnteredInvalidVerifyCode() {
        open("http://localhost:9999");
        LoginPage loginPage = new LoginPage();
        VerifiyPage verifiyPage = loginPage.validLogin(DataGenerator.getLoginUser(), DataGenerator.getPasswordUser());
        AccountPage accountPage = verifiyPage.invalidVerify();
        accountPage.checkError();

    }


    @AfterAll
    static void cleanTablesAfterTests() {
        val cards = "DELETE FROM cards";
        val users = "DELETE FROM users";
        val codes = "DELETE FROM auth_codes";

        try (
                val connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
                val prepareStatCard = connect.prepareStatement(cards);
                val prepareStatUser = connect.prepareStatement(users);
                val prepareStatCode = connect.prepareStatement(codes);

        ) {
           prepareStatCode.executeUpdate(codes);
           prepareStatCard.executeUpdate(cards);
            prepareStatUser.executeUpdate(users);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


}
