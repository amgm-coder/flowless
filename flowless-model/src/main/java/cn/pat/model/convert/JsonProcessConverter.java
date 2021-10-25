package cn.pat.model.convert;

import cn.pat.design.Process;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

/**
 * json-process 转换器
 *
 * @author pat
 * @date 2021/10/25
 */
public class JsonProcessConverter {
    public String into(Process process) {

        return null;
    }

    @SneakyThrows
    public Process from(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.readValue(json, Process.class);
        return null;
    }
}
