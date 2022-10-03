import Pojo.JsonPojoClass2;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
//import io.restassured.response.Response;
//import com.beust.ah.A;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;



public class TestClass {
    File file2;


    ObjectMapper objectMapper;
    JsonPojoClass2 jsonPojoClass2;


    @BeforeClass
    public void fileRead() throws IOException {

        file2 = new File("./src/test/java/JsonFile2.json");

        objectMapper = new ObjectMapper();

        jsonPojoClass2 = objectMapper.readValue(file2, JsonPojoClass2.class);
    }
    @Test
        public void toCheckforeignPlayers()
        {
            int totalPlayers = jsonPojoClass2.getPlayer().size();
            int indianPlayers = jsonPojoClass2.getPlayer().stream().filter(t -> t.getCountry().contentEquals("India")).collect(Collectors.toList()).size();
            int foreignPlayer = totalPlayers - indianPlayers;
            Assert.assertEquals(foreignPlayer, 4);
        }

@Test
        public void oneWicketKeeperValidation()
        {

            boolean atleastOneWicketKeeper = jsonPojoClass2.getPlayer().stream().filter(t -> t.getRole().contentEquals("Wicket-keeper")).count() > 0;
            jsonPojoClass2.getLocation();
            Assert.assertEquals(atleastOneWicketKeeper, true);


        }

    }