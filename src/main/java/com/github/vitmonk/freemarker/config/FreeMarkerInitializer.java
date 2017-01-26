package com.github.vitmonk.freemarker.config;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.github.vitmonk.freemarker.enums.MyEnum;
import com.google.common.collect.Maps;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;
import freemarker.template.TemplateModelException;
import org.springframework.stereotype.Component;

@Component
public class FreeMarkerInitializer {

    private Configuration config;
    private Map<String, Object> dataModel = Maps.newHashMap();

    public Configuration getConfig() {
        return config;
    }

    public Map<String, Object> getDataModel() {
        return dataModel;
    }

    @PostConstruct
    public void init() {
        initConfiguration();
        initDataModel();
    }

    private void initConfiguration() {
        config = new Configuration(Configuration.VERSION_2_3_25);
        try {
            config.setDirectoryForTemplateLoading(new File(FreeMarkerConstants.TEMPLATES_FOLDER));
        } catch (IOException e) {
            throw new RuntimeException("Could not find templates path!", e);
        }
        config.setDefaultEncoding("UTF-8");
        // changing this dynamically in REST controllers
        // config.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
        config.setLogTemplateExceptions(false);
    }

    private void initDataModel() {
        dataModel.put(FreeMarkerConstants.MAIN_CSS, FreeMarkerConstants.MAIN_CSS_PATH);

        BeansWrapper beansWrapper = (BeansWrapper) config.getObjectWrapper();
        try {
            dataModel.put(FreeMarkerConstants.CONTANTS,
                    beansWrapper.getStaticModels().get(FreeMarkerConstants.class.getCanonicalName()));

            dataModel.put(FreeMarkerConstants.ENUM,
                    beansWrapper.getEnumModels().get(MyEnum.class.getCanonicalName()));

        } catch (TemplateModelException e) {
            throw new RuntimeException("Could not init data model!", e);
        }

        dataModel.put(FreeMarkerConstants.SIMPLE_STRING, "Hello World!");

    }
}
