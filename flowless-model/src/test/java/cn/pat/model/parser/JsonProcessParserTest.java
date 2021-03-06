package cn.pat.model.parser;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.pat.model.BpmnProcess;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
        BpmnProcess p1 = jsonProcessParser.from(demoJson);

        String json = jsonProcessParser.into(p1);

        BpmnProcess p2 = jsonProcessParser.from(json);

        Assertions.assertEquals(p1, p2);
    }

    @Test
    @DisplayName("从json解析Process")
    @CsvFileSource
    void from() {
        JsonProcessParser jsonProcessParser = new JsonProcessParser();
        BpmnProcess from = jsonProcessParser.from(demoJson);
        Assertions.assertNotNull(from);
        System.out.println(from);
    }
}