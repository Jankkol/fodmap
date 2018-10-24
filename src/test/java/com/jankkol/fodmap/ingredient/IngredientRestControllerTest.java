package com.jankkol.fodmap.ingredient;

import com.jankkol.fodmap.FodmapApplication;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.FileSystemResourceAccessor;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = FodmapApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:db-test.properties")
public class IngredientRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static Connection conn;
    private static Liquibase liquibase;

    @BeforeClass
    public static void createTestData() throws SQLException,
            ClassNotFoundException, LiquibaseException {

        Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");

        Database database = DatabaseFactory.getInstance()
                .findCorrectDatabaseImplementation(new JdbcConnection(conn));

        liquibase = new Liquibase("db-schema.xml",
                new FileSystemResourceAccessor(), database);
        liquibase.update((String) null);
    }

    @AfterClass
    public static void removeTestData() throws LiquibaseException, SQLException {
        liquibase.rollback(1000, null);
        conn.close();
    }

    @Test
    public void initTest() throws Exception {
        this.mockMvc.perform(get("/test")).andDo(print());
    }
}
