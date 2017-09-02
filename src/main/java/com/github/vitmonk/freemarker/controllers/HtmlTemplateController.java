package com.github.vitmonk.freemarker.controllers;

import com.github.vitmonk.freemarker.config.FreeMarkerInitializer;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.StringBuilderWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

@RestController
public class HtmlTemplateController {

    @Autowired
    private FreeMarkerInitializer freeMarkerInitializer;

    @RequestMapping(value = {"/freemarkerHtml"},
            produces = {MediaType.TEXT_HTML_VALUE})
    @ResponseBody
    public ResponseEntity<String> getFilledTemplate() throws IOException, TemplateException {

        Configuration config = freeMarkerInitializer.getConfig();
        config.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
        Map<String, Object> dataModel = freeMarkerInitializer.getDataModel();

        Template template = config.getTemplate("html/htmlTemplate.ftlh");
        Writer output = new StringBuilderWriter();
        template.process(dataModel, output);
        IOUtils.closeQuietly(output);

        return ResponseEntity.ok(output.toString());
    }
}
