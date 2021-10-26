package cn.pat.model.parser;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.pat.model.Process;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.CsvFileSource;

class JsonProcessParserTest {

    private String demoJson;

    @BeforeEach
    void setUp() {
        demoJson = ResourceUtil.readUtf8Str("demo.fl.json");
    }


    @Test
    @DisplayName("序列化")
    void into() {
        JsonProcessParser jsonProcessParser = new JsonProcessParser();
        Process p1 = jsonProcessParser.from(demoJson);

        String json = jsonProcessParser.into(p1);

        Process p2 = jsonProcessParser.from(json);

        Assertions.assertEquals(p1,p2);
    }

    @Test
    @DisplayName("从json解析Process")
    @CsvFileSource
    void from() {
        JsonProcessParser jsonProcessParser = new JsonProcessParser();
        Process from = jsonProcessParser.from(demoJson);
        Assertions.assertNotNull(from);
        System.out.println(from);
    }
}