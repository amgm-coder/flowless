package cn.pat.model.parser;

import cn.pat.model.FlowElement;
import cn.pat.model.SequenceFlow;
import cn.pat.model.parser.parse.ParseHandler;
import cn.pat.model.parser.parse.SequenceFlowParseHandler;

import java.util.HashMap;
import java.util.Map;

public class ParerHandlers {

    private static Map<Class<? extends FlowElement>, ParseHandler> parseHandlers = new HashMap<>();

    static {
        parseHandlers.put(SequenceFlow.class, new SequenceFlowParseHandler());
    }

    public static ParseHandler getHandler(Class<? extends FlowElement> clz) {
        return parseHandlers.get(clz);
    }
}
