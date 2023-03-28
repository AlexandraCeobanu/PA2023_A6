package org.example.tema5;

import com.fasterxml.jackson.core.Version;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportCommand extends GenericCommand{
    ReportCommand()
    {
        this.name="Report";
    }
    public void action(Object ...obj) throws IOException, TemplateException {
        if((obj[0] instanceof Catalog)==false)
            throw new IllegalArgumentException("Argumentul nu este o instanta a clasei Catalog");

        Catalog catalog=(Catalog) obj[0];
        var cfg=new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(ReportCommand.class, "/");
        cfg.setDefaultEncoding("UTF-8");
        Map<String, Object> data = new HashMap<>();
        data.put("catalog", catalog);
        Template template = cfg.getTemplate("report.ftl");

        Writer out = new FileWriter(new File("report.html"));
        template.process(data, out);
        out.flush();
        out.close();
    }
    /*@Override
    public void action(Catalog catalog) throws IOException, TemplateException {
        var cfg=new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(ReportCommand.class, "/");
        cfg.setDefaultEncoding("UTF-8");
        Map<String, Object> data = new HashMap<>();
        data.put("catalog", catalog);
        Template template = cfg.getTemplate("report.ftl");

        Writer out = new FileWriter(new File("report.html"));
        template.process(data, out);
        out.flush();
        out.close();
    }*/
}
