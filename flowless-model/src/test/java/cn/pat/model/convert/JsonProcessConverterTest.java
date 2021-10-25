package cn.pat.model.convert;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.pat.design.Process;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JsonProcessConverterTest {

    private String demoJson;

    @BeforeEach
    void setUp() {
        demoJson = ResourceUtil.readUtf8Str("demo.fl.json");
    }


    @Test
    void into() {
        JsonProcessConverter jsonProcessConverter = new JsonProcessConverter();
        Process from = jsonProcessConverter.from(demoJson);
        Assertions.assertNotNull(from);
    }

    @Test
    void from() {
    }
}