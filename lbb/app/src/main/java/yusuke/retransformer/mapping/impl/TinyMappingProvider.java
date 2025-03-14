package yusuke.retransformer.mapping.impl;

import lombok.Data;
import yusuke.retransformer.mapping.IMappingProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TinyMappingProvider implements IMappingProvider {

    private final Map<String, ClassMappingData> classMapping;

    private static final Pattern OBJECT_PATTEN = Pattern.compile("L[^;]+;");

    private String getOriginalDesc(String desc) {
        Matcher matcher = OBJECT_PATTEN.matcher(desc);

        while (matcher.find()) {
            String group = matcher.group();
            desc = desc.replace(group, String.format("L%s;", this.getClassName(group.substring(1, group.length() - 1))));
        }

        return desc;
    }

    public TinyMappingProvider(String rawData) {
        this.classMapping = new HashMap<>();

        String[] lines = rawData.split("\\R");
        // load all class mappings
        for (int i = 1; i < lines.length; i++) {
            String[] tab = lines[i].split("\t");
            // class mapping
            if (tab[0].equals("c")) {
                classMapping.put(tab[2], new ClassMappingData(tab[1]));
            }
        }

        ClassMappingData current = null;

        for (int i = 1; i < lines.length; i++) {
            String[] tab = lines[i].split("\t");

            if (tab[0].equals("c")) {
                current = classMapping.get(tab[2]);
            }

            if (current == null) {
                continue;
            }

            // field mapping
            if (tab[1].equals("f") && tab.length == 5) {
                current.fieldMapping.put(
                        new FieldMappingData(tab[4], tab[2]),
                        new FieldMappingData(tab[3], tab[2])
                );
            }

            // method mapping
            if (tab[1].equals("m") && tab.length == 5) {
                current.methodMapping.put(
                        new MethodMappingData(tab[4], getOriginalDesc(tab[2])),
                        new MethodMappingData(tab[3], tab[2])
                );
            }
        }
    }

    @Override
    public String getClassName(String className) {
        return this.classMapping.getOrDefault(className, new ClassMappingData(className)).obfuscated;
    }

    @Override
    public String getMethodName(String className, String methodName, String methodDesc) {
        return this.classMapping.getOrDefault(className, new ClassMappingData(className))
                .methodMapping.getOrDefault(new MethodMappingData(methodName, methodDesc), new MethodMappingData(methodName, methodDesc))
                .obfuscated;
    }

    @Override
    public String getMethodDesc(String className, String methodName, String methodDesc) {
        Matcher matcher = OBJECT_PATTEN.matcher(methodDesc);

        while (matcher.find()) {
            String group = matcher.group();
            methodDesc = methodDesc.replace(group, String.format("L%s;", this.getClassName(group.substring(1, group.length() - 1))));
        }

        return methodDesc;
    }

    @Override
    public String getFieldName(String className, String fieldName, String fieldDesc) {
        return this.classMapping.getOrDefault(className, new ClassMappingData(className))
                .fieldMapping.getOrDefault(new FieldMappingData(fieldName, fieldDesc), new FieldMappingData(fieldName, fieldDesc))
                .obfuscated;
    }

    @Override
    public String getFieldDesc(String className, String fieldName, String fieldDesc) {
        return "";
    }

    @Data
    private static class ClassMappingData {

        private final String obfuscated;

        private final Map<FieldMappingData, FieldMappingData> fieldMapping = new HashMap<>();

        private final Map<MethodMappingData, MethodMappingData> methodMapping = new HashMap<>();

    }

    @Data
    private static class FieldMappingData {

        private final String obfuscated;
        private final String desc;

    }

    @Data
    private static class MethodMappingData {

        private final String obfuscated;
        private final String desc;

    }


}
