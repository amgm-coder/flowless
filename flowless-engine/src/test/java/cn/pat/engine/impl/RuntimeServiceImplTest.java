package cn.pat.engine.impl;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.pat.model.BpmnProcess;
import cn.pat.model.parser.JsonProcessParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RuntimeServiceImplTest {
    private String demoJson;

    @BeforeEach
    void setUp() {
        demoJson = ResourceUtil.readUtf8Str("demo.fl.json");
    }

    @Test
    void startProcessInstance() {
        RuntimeServiceImpl runtimeService = new RuntimeServiceImpl();

        JsonProcessParser jsonProcessParser = new JsonProcessParser();
        BpmnProcess bpmnProcess = jsonProcessParser.from(demoJson);

        runtimeService.startProcessInstance(bpmnProcess);
    }
}