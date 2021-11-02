package cn.pat.model.parser;

import cn.pat.model.BpmnProcess;
import cn.pat.model.FlowElement;
import cn.pat.model.exception.RequiredPropertyMissingException;
import cn.pat.model.parser.parse.ParseHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.SneakyThrows;

/**
 * json-process 转换器
 *
 * @author pat
 * @date 2021/10/25
 */
public class JsonProcessParser {
    private ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public String into(BpmnProcess process) {
        return objectMapper.writeValueAsString(process);
    }

    @SneakyThrows
    @SuppressWarnings({"rawtypes","unchecked"})
    public BpmnProcess from(String json) {
        JsonNode root = objectMapper.readTree(json);
        if (root.isMissingNode() || root.isEmpty()) {
            return null;
        }
        BpmnProcess process = readBaseProcess(root);
        JsonNode elements = root.path("elements");
        if (elements.isArray()) {
            ArrayNode arrayNode = (ArrayNode) elements;
            for (JsonNode child : arrayNode) {
                if (child.isObject()) {
                    FlowElement flowElement = readChildElement(child);
                    if (flowElement != null) {

                        process.addElement(flowElement);
                    }
                }
            }
        }
        for (FlowElement flowElement : process.getElements()) {
            ParseHandler handler = ParerHandlers.getHandler(flowElement.getClass());
            if (handler != null) {
                handler.executeParse(process,flowElement);
            }
        }
        return process;
    }

    private FlowElement readChildElement(JsonNode element) throws ClassNotFoundException, com.fasterxml.jackson.core.JsonProcessingException {
        checkTextNonEmpty(element, "id");
        String stencil = checkTextNonEmpty(element, "stencil");
        String packageName = FlowElement.class.getPackage().getName();
        String elementClassName = packageName + "." + stencil;
        Class<?> clz = getClass().getClassLoader().loadClass(elementClassName);
        FlowElement elem = (FlowElement) objectMapper.treeToValue(element, clz);
        return elem;
    }

    private BpmnProcess readBaseProcess(JsonNode root) {
        String id = checkTextNonEmpty(root, "id");
        BpmnProcess process = new BpmnProcess();
        process.setId(id);
        process.setName(root.path("name").asText());
        return process;
    }

    private String checkTextNonEmpty(JsonNode root, String prop) {
        JsonNode node = root.path(prop);
        if (!node.isTextual() || node.isMissingNode()) {
            throw new RequiredPropertyMissingException(prop);
        }
        return node.asText();
    }
}
